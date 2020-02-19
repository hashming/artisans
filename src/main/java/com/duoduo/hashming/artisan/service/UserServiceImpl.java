package com.duoduo.hashming.artisan.service;

import com.duoduo.hashming.artisan.dao.UserMapper;
import com.duoduo.hashming.artisan.model.User;
import com.duoduo.hashming.artisan.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        UserExample userExample = new UserExample();
        userExample.createCriteria().andTokenEqualTo(token);
        userMapper.selectByExample(userExample);
        return null;
    }

    @Override
    public void createOrUpdate(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountIdEqualTo(user.getAccountId());
        List<User> users = userMapper.selectByExample(userExample);
        //如果accountid已经存在那么就更新他对应的token,如果不存在就插入token
        if (users.size()==0){
            //插入
            user.setGmtCreate(System.currentTimeMillis());//用户的创建时间
            user.setGmtModified(user.getGmtCreate());//用户的更改时间
            userMapper.insert(user);
        }else {
            //更新
            User dbUser = users.get(0);
            User updateUser = new User();
            updateUser.setGmtModified(System.currentTimeMillis());
            updateUser.setAvatarUrl(user.getAvatarUrl());
            updateUser.setName(user.getName());
            updateUser.setToken(user.getToken());
            UserExample example = new UserExample();
            example.createCriteria().andIdEqualTo(dbUser.getId());
            userMapper.updateByExampleSelective(updateUser,example);
        }
    }
}
