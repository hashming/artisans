package com.duoduo.hashming.artisan.service;

import com.duoduo.hashming.artisan.dao.UserMapper;
import com.duoduo.hashming.artisan.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }
}
