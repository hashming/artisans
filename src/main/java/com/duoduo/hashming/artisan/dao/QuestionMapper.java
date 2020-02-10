package com.duoduo.hashming.artisan.dao;

import com.duoduo.hashming.artisan.model.Question;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface QuestionMapper {

    /**
     * 添加问题信息
     */
    int create(Question question);

}
