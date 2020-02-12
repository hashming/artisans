package com.duoduo.hashming.artisan.dao;

import com.duoduo.hashming.artisan.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
//import org.apache.ibatis.annotations.Select;

@Mapper
@Repository
public interface UserMapper {

    //插入方法
    int insert(User user);

    //根据token进行查找
    User findByToken(@Param("token") String token);

    /**
     * 根据id查询用户信息
     * @param id
     */
    User findById(@Param("id")Integer id);
}
