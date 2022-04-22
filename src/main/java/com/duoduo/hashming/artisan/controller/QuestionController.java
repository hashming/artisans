package com.duoduo.hashming.artisan.controller;

import com.duoduo.hashming.artisan.dto.Question_User;
import com.duoduo.hashming.artisan.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 问题详情展示
 */
@Controller
public class QuestionController {
    @Autowired
    private IQuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id")String id, Model model){
        Integer questionId = null;
        try{
            questionId = Integer.parseInt(id);
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        //根据问题的id查询对应的问题的详细信息
        Question_User question_user = questionService.getById(questionId);
        //累加阅读数
        questionService.addViewCount(questionId);
        model.addAttribute("question",question_user);
        return "question";
    }
}
