package com.duoduo.hashming.artisan.mapper;

import com.duoduo.hashming.artisan.entity.LoginUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author duoduo
 * @since 2022-04-22
 */
@Mapper
public interface LoginUserMapper extends BaseMapper<LoginUser> {

}
