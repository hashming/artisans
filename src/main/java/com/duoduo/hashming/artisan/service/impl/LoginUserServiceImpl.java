package com.duoduo.hashming.artisan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duoduo.hashming.artisan.entity.LoginUser;
import com.duoduo.hashming.artisan.mapper.LoginUserMapper;
import com.duoduo.hashming.artisan.service.ILoginUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;

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
