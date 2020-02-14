package com.duoduo.hashming.artisan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProfileController {
//    对应前端的点击事件，当我们点击咱的问题的时候就动态的把questions赋值给action，然后下面的判断就成立了
    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action") String action, Model model){
        if ("questions".equals(action)){
            model.addAttribute("section","questions");
            model.addAttribute("sectionName","咱的问题");
        }else if ("replies".equals(action)){
            model.addAttribute("section","replies");
            model.addAttribute("sectionName","最新回复");
        }

        return "profile";
    }
}
