package com.duoduo.hashming.artisan.controller;

import com.duoduo.hashming.artisan.dao.QuestionMapper;
import com.duoduo.hashming.artisan.dto.Question_User;
import com.duoduo.hashming.artisan.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id")Integer id, Model model){
        Question_User question_user = questionService.getById(id);
        model.addAttribute("question",question_user);
        return "question";
    }
}
