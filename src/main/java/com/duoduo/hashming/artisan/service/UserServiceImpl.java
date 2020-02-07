package com.duoduo.hashming.artisan.service;

import com.duoduo.hashming.artisan.dao.UserMapper;
import com.duoduo.hashming.artisan.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")//定位到对应的接口
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    /**
     * 动态的存入用户登录的信息
     * @param user
     * @return
     */
    @Override
    public int addUser(User user) {
        return userMapper.insert(user);
    }

    /**
     * 通过token取出对应的user信息
     * @param token
     * @return
     */
    @Override
    public User find(String token) {
        return userMapper.findByToken(token);
    }
}
