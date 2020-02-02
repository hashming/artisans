package com.duoduo.hashming.artisan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name")String name,Model model){
        model.addAttribute("name",name);//浏览器中的值放入model中
        return "hello";
    }

}
