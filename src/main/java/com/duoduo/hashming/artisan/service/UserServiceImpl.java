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

    @Override
    public void createOrUpdate(User user) {
        //如果accountid已经存在那么就更新他对应的token,如果不存在就插入token
        User dbUser = userMapper.findByaccountId(user.getAccount_id());
        if (dbUser==null){
            //插入
            user.setGmt_create(System.currentTimeMillis());//用户的创建时间
            user.setGmt_modified(user.getGmt_create());//用户的更改时间
            userMapper.insert(user);
        }else {
            //更新
            dbUser.setGmt_modified(System.currentTimeMillis());
            dbUser.setAvatar_url(user.getAvatar_url());
            dbUser.setName(user.getName());
            dbUser.setToken(user.getToken());
            userMapper.update(dbUser);
        }
    }
}
