package com.duoduo.hashming.artisan.dao;

import com.duoduo.hashming.artisan.model.Question;
import org.apache.ibatis.annotations.Mapper;
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
    List<Question> getall();
}
