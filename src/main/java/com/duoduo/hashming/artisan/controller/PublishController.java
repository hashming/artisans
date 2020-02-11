package com.duoduo.hashming.artisan.controller;

import com.duoduo.hashming.artisan.model.Question;
import com.duoduo.hashming.artisan.model.User;
import com.duoduo.hashming.artisan.service.QuestionService;
import com.duoduo.hashming.artisan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;


@Controller
public class PublishController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserService userService;

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    public String doPublish(//required=false或者true来要求@RequestParam配置的前端参数是否一定要传
            @RequestParam(name = "title") String title,//标题
            @RequestParam(name = "description") String description,//详情描述
            @RequestParam(name = "tag") String tag,//标签
            HttpServletRequest request,Model model//request请求
    ){
        //首先把这些值放在model中就是为了能够在添加失败的时候还能回显到页面中去
        /*model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);*/

        if (title==null || title==""){
            model.addAttribute("error","标题不能是空的");
            return "publish";
        }
        if (description==null || description==""){
            model.addAttribute("error","描述不能是空的");
            return "publish";
        }
        if (tag==null || tag==""){
            model.addAttribute("error","标签不能是空的");
            return "publish";
        }

        model.addAttribute("title",title);
        model.addAttribute("description",description);
        model.addAttribute("tag",tag);


        User user = null;
        Cookie[] cookies = request.getCookies();//请求中又好多cookie
        //下面的这个代码以后可以用redis的方式进行代替
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")){//找到cookie中名字为token的键值对
                String token = cookie.getValue();//取出对应的cookie
                user = userService.find(token);//通过这个特定的cookie查找指定的user信息
                if (user!=null){
                    request.getSession().setAttribute("user",user);//把查找到的user存入session中。
                }
                break;
            }
        }

        if (user==null){
            model.addAttribute("error","用户没有登录");
            return "publish";
        }

        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setGmt_create(System.currentTimeMillis());
        question.setGmt_modified(question.getGmt_create());

        questionService.addQuestion(question);//写入数据库

        return "redirect:/";

    }
}
