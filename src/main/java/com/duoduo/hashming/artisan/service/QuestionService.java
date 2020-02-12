package com.duoduo.hashming.artisan.service;

import com.duoduo.hashming.artisan.dto.QuestionDTO;
import com.duoduo.hashming.artisan.model.Question;

import java.util.List;

public interface QuestionService {

    //插入问题信息
    int addQuestion(Question question);
    //查询所有的问题
    List<QuestionDTO> show();
}
