package cn.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.manage.mapper.UserMapper;
import cn.manage.pojo.User;

import com.github.abel533.mapper.Mapper;

@Service
public class UserService extends BaseService<User>{

    @Autowired
    private UserMapper userMapper;

    @Override
    public Mapper<User> getMapper() {
        return userMapper;
    }

}
