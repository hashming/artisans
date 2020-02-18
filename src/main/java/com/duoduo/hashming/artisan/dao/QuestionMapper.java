package com.duoduo.hashming.artisan.dao;

import com.duoduo.hashming.artisan.dto.QuestionDTO;
import com.duoduo.hashming.artisan.dto.Question_User;
import com.duoduo.hashming.artisan.model.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface QuestionMapper {

    /**
     * 添加问题信息
     */
    int create(Question question);

    /**
     * 查询全部
     * @return
     */
    List<Question> getall(@Param("offset") Integer offset,@Param("pageSize") Integer pageSize);

    /**
     * 返回问题的数目
     * @return
     */
    Integer count();

    /**
     *查询传入的创建者创建的问题
     * @param userId
     * @param offset
     * @param pageSize
     * @return
     */
    @Select("select * from question where creator = #{userId} limit #{offset},#{pageSize}")
    List<Question> getall_byCreator(@Param("userId") Integer userId,@Param("offset") Integer offset,@Param("pageSize") Integer pageSize);

    /**
     * 根据userId查询符合的问题条数
     * @return
     */
    @Select("select count(1) from question where creator = #{userId}")
    Integer countByUserId(@Param("userId") Integer userId);

    /**
     * 查询全部的问题
     * @return
     */
    @Select("select a.*,b.* from question a join user b on a.creator=b.ID")
    List<Question_User> showAll();

    /**
     * 查询全部的问题 根据creator
     * @return
     */
    @Select("select a.*,b.* from question a join user b on a.creator=b.ID where a.creator = #{userId}")
    List<Question_User> showAll_byCreator(@Param("userId") Integer userId);

    @Select("select a.*,b.* from question a join user b on a.creator=b.ID where a.id=#{Id}")
    Question_User getById(@Param("Id") Integer id);

    @Select("select * from question where id=#{Id}")
    Question getId(@Param("Id") Integer id);

    @Update("update question set title=#{title},description=#{description},gmt_modified=#{gmt_modified},tag=#{tag} where id=#{id}")
    void update(Question question);

}
