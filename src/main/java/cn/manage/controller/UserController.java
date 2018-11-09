package cn.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.manage.bean.EasyUIResult;
import cn.manage.pojo.User;
import cn.manage.service.UserService;

import com.github.pagehelper.PageInfo;


@RequestMapping("user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;


   @RequestMapping(value = "list", method = RequestMethod.GET)
    public String toUsersPage(){
        return "users";
    }
    
    @RequestMapping(value = "datalist", method = RequestMethod.GET)
    @ResponseBody
    public EasyUIResult queryUserList(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "5") Integer rows) {
        
        PageInfo<User> pageInfo = this.userService.queryPageListByWhere(null, page, rows);
        
        return new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
        //return this.userService.queryUserList(page,rows);
    }

}
