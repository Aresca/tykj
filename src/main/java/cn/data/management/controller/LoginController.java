package cn.data.management.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.data.management.entity.DataManage;
import cn.data.management.entity.User;
import cn.data.management.service.DataManageService;
import cn.data.management.service.UserService;

@RequestMapping("login")
@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	@Autowired
	private DataManageService dataManageService;

	@RequestMapping(value = "signin.do")
	public String signin(HttpServletRequest request) {
		/*
		 * HttpSession session = request.getSession(); User loginUser = (User)
		 * session.getAttribute("loginUser");
		 */
		return "index";
	}

	@RequestMapping(value = "login.do")
	public String login(HttpServletRequest request, @RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password, Map<String, Object> map) {
		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
		User loginUser = userService.getUser(user);
		if (loginUser == null) {
			map.put("message", "用户名密码不正确");
			return "index";
		}
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", loginUser);

		List<DataManage> dataList = dataManageService.queryAll();
		map.put("dataList", dataList);
		return "dataList";
	}

	@RequestMapping(value = "manageLogin.do")
	public String manageLogin(HttpServletRequest request, @RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password, Map<String, Object> map) {
		if (StringUtils.isBlank(username) || !"admin".equals(username)) {
			map.put("message", "用户名或密码不正确");
			return "index";
		}
		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
		User loginUser = userService.getUser(user);
		if (loginUser == null) {
			map.put("message", "用户名或密码不正确");
			return "index";
		}
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", loginUser);
		List<DataManage> dataList = dataManageService.queryAll();
		map.put("dataList", dataList);
		return "dataList";
	}

	@RequestMapping(value = "goRegister.do")
	public String goRegister() {
		return "register";
	}

	@RequestMapping(value = "register.do")
	@ResponseBody
	public String register(User user) throws JsonProcessingException {
		Map<String, Object> resultMap = new HashMap<>();
		System.out.println(user);
		String userName = user.getUserName();
		String password = user.getPassword();
		String teamName = user.getTeamName();
		User queryUser = new User();
		queryUser.setUserName(userName);
		User queryOne = userService.queryOne(queryUser);
		if (StringUtils.isBlank(userName) || StringUtils.isBlank(password) || StringUtils.isBlank(teamName)) {
			resultMap.put("flag", false);
			resultMap.put("message", "填写的资料不完整");
		} else if (queryOne != null) {
			resultMap.put("flag", false);
			resultMap.put("message", "用户已存在");
		} else {
			user.setCreateTime(new Date());
			user.setUpdateTime(new Date());
			user.setManageFlag("0");
			userService.save(user);
			resultMap.put("flag", true);
		}

		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(resultMap);
	}

	@RequestMapping(value = "goManagerLogin.do")
	public String goManagerLogin() {
		return "managerLogin";
	}
}
