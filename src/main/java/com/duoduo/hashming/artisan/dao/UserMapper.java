package com.duoduo.hashming.artisan.dao;

import com.duoduo.hashming.artisan.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
//import org.apache.ibatis.annotations.Select;

@Mapper
@Repository
public interface UserMapper {

    //插入方法
    int insert(User user);

}
