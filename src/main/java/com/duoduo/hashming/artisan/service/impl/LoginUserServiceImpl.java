package com.duoduo.hashming.artisan.service.impl;

import com.duoduo.hashming.artisan.entity.LoginUser;
import com.duoduo.hashming.artisan.mapper.LoginUserMapper;
import com.duoduo.hashming.artisan.service.ILoginUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author duoduo
 * @since 2022-04-22
 */
@Service
public class LoginUserServiceImpl extends ServiceImpl<LoginUserMapper, LoginUser> implements ILoginUserService {

}
