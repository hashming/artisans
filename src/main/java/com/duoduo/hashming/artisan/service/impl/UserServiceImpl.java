package com.duoduo.hashming.artisan.service.impl;

import com.duoduo.hashming.artisan.entity.User;
import com.duoduo.hashming.artisan.mapper.UserMapper;
import com.duoduo.hashming.artisan.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
}
