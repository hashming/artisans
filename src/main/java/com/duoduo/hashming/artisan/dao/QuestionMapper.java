package com.duoduo.hashming.artisan.dao;

import com.duoduo.hashming.artisan.model.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
}
