package com.duoduo.hashming.artisan.service;

import com.duoduo.hashming.artisan.dao.QuestionMapper;
import com.duoduo.hashming.artisan.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "questionService")
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public int addQuestion(Question question) {
        return questionMapper.create(question);
    }
}
