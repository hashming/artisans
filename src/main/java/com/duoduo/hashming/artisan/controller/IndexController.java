package com.duoduo.hashming.artisan.controller;

import com.duoduo.hashming.artisan.dto.Question_User;
import com.duoduo.hashming.artisan.service.QuestionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 先判断登录状态 然后跳入index界面
 */
@Controller
public class IndexController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(Model model,
                        @RequestParam(name = "pageNum",defaultValue = "1") Integer pageNum,
                        @RequestParam(name = "pageSize",defaultValue = "5") Integer pageSize){

        PageInfo<Question_User> allUser = questionService.findAllQuestion(pageNum, pageSize);
        model.addAttribute("pagination",allUser);
        return "index";
    }

    @RequestMapping("/errorCtl")
    public String errorCtl(){
        int a=1/0;
        return a+"";
    }

}

