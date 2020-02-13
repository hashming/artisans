package com.duoduo.hashming.artisan.service;

import com.duoduo.hashming.artisan.dto.PaginationDTO;
import com.duoduo.hashming.artisan.model.Question;

public interface QuestionService {

    //插入问题信息
    int addQuestion(Question question);
    //查询所有的问题
    PaginationDTO show(Integer pageNum, Integer pageSize);
    //分页插件
    /*PageInfo<Question> findAllQuestion(Integer pageNum, Integer pageSize);*/

    /**
     * 查询问题的个数
     * @return
     */
    Integer count();
}
