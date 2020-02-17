package com.duoduo.hashming.artisan.dao;

import com.duoduo.hashming.artisan.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
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

    /**
     * 如果accountid已经存在那么就更新他对应的token,如果不存在就插入token
     * @param account_id
     * @return
     */
    @Select("select * from user where account_id=#{account_id}")
    User findByaccountId(@Param("account_id")String account_id);

    /**
     * 更新操作
     * @param user
     */
    @Update("update user set name=#{name},token=#{token},gmt_modified=#{gmt_modified},avatar_url=#{avatar_url} where id = #{id}")
    void update(User user);
}
