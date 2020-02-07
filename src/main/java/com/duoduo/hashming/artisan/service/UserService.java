package com.duoduo.hashming.artisan.service;

import com.duoduo.hashming.artisan.model.User;

public interface UserService {

    /**
     * 插入信息
     */
    int addUser(User user);

    /**
     * 根据token查找对应的user
     * @param token
     * @return
     */
    User find(String token);
}
