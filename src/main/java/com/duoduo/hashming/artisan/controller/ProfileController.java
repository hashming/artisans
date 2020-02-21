package com.duoduo.hashming.artisan.controller;

import com.duoduo.hashming.artisan.dto.Question_User;
import com.duoduo.hashming.artisan.model.User;
import com.duoduo.hashming.artisan.service.QuestionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * 咱的问题的控制层
 */
@Controller
public class ProfileController {

    @Autowired
    private QuestionService questionService;


//    对应前端的点击事件，当我们点击咱的问题的时候就动态的把questions赋值给action，然后下面的判断就成立了
    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action") String action, Model model,
                          HttpServletRequest request,
                          @RequestParam(name = "pageNum",defaultValue = "1") Integer pageNum,
                          @RequestParam(name = "pageSize",defaultValue = "5") Integer pageSize){

        User user = (User)request.getSession().getAttribute("user");//把查找到的user存入session中。

        if (user==null){
            return "redirect:/";
        }

        if ("questions".equals(action)){
            model.addAttribute("section","questions");
            model.addAttribute("sectionName","咱的问题");
        }else if ("replies".equals(action)){
            model.addAttribute("section","replies");
            model.addAttribute("sectionName","最新回复");
        }
//        PaginationDTO paginationDTO = questionService.show(user.getId(), pageNum, pageSize);
        //根据创建人来查询问题信息
        PageInfo<Question_User> allUser = questionService.findAllQuestionByuserId(user.getId(),pageNum, pageSize);
        model.addAttribute("pagination",allUser);
        return "profile";
    }
}
