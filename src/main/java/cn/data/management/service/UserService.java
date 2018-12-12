package cn.data.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.abel533.mapper.Mapper;

import cn.data.management.entity.User;
import cn.data.management.mapper.UserMapper;

@Service
public class UserService extends BaseService<User> {

	@Autowired
	private UserMapper userMapper;

	@Override
	public Mapper<User> getMapper() {
		return userMapper;
	}

	public User getUser(int id) {
		User user = userMapper.selectByPrimaryKey(id);
		return user;
	}

	public User getUser(User user) {
		return userMapper.selectOne(user);

	}
}
