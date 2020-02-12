package com.duoduo.hashming.artisan.service;

import com.duoduo.hashming.artisan.dao.QuestionMapper;
import com.duoduo.hashming.artisan.dao.UserMapper;
import com.duoduo.hashming.artisan.dto.QuestionDTO;
import com.duoduo.hashming.artisan.model.Question;
import com.duoduo.hashming.artisan.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "questionService")
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addQuestion(Question question) {
        return questionMapper.create(question);
    }

    @Override
    public List<QuestionDTO> show() {
        //查询出来所有的额问题信息，存入list中
        List<Question> questions = questionMapper.getall();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions) {
            //这里的creator和id是相互对应的
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
//            questionDTO.setUser(user);
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }

        return questionDTOList;

    }
}
