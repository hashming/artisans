package com.duoduo.hashming.artisan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duoduo.hashming.artisan.entity.LoginUser;
import com.duoduo.hashming.artisan.entity.User;
import com.duoduo.hashming.artisan.mapper.LoginUserMapper;
import com.duoduo.hashming.artisan.mapper.UserMapper;
import com.duoduo.hashming.artisan.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author duoduo
 * @since 2022-04-22
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public void createOrUpdate(User user) {

    }

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findUser(String userName, String password) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("NAME", userName);
        map.put("ACCOUNT_ID", password);
        wrapper.allEq(map);
        User user = userMapper.selectOne(wrapper);
        return user;
    }

    @Override
    public Boolean addCookieForCurrentUser(User user) {
        return userMapper.updateById(user) > 0;
    }
}
