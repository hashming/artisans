package com.duoduo.hashming.artisan.service;

import com.duoduo.hashming.artisan.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author duoduo
 * @since 2022-04-22
 */
public interface IUserService extends IService<User> {

    void createOrUpdate(User user);

    User findUser(String userName, String password);

    Boolean addCookieForCurrentUser(User user);
}
