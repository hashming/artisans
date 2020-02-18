package com.duoduo.hashming.artisan.controller;

import com.duoduo.hashming.artisan.dao.QuestionMapper;
import com.duoduo.hashming.artisan.dto.QuestionDTO;
import com.duoduo.hashming.artisan.dto.Question_User;
import com.duoduo.hashming.artisan.model.Question;
import com.duoduo.hashming.artisan.model.User;
import com.duoduo.hashming.artisan.service.QuestionService;
import com.duoduo.hashming.artisan.service.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


@Controller
public class PublishController {

    /*@Autowired
    private QuestionMapper questionMapper;*/

    @Autowired
    private QuestionService questionService;

    @GetMapping("/publish/{id}")
    public String edit(@PathVariable(name = "id") Integer id,Model model){
       /* Question_User question = questionService.getById(id);
        model.addAttribute("title",question.getTitle());
        model.addAttribute("description",question.getDescription());
        model.addAttribute("tag",question.getTag());*/
        QuestionDTO question = questionService.getId(id);
       model.addAttribute("title",question.getTitle());
       model.addAttribute("description",question.getDescription());
       model.addAttribute("tag",question.getTag());
       model.addAttribute("id",question.getId());//问题的id
        return "publish";
    }

    @GetMapping("/publish")
    public String publish(){
        return "publish";
    }

    @PostMapping("/publish")
    //参数里面放的是前端传递过来的数据
    public String doPublish(//required=false或者true来要求@RequestParam配置的前端参数是否一定要传
            @RequestParam(value = "title",required = false) String title,//标题
            @RequestParam(value = "description",required = false) String description,//详情描述
            @RequestParam(value = "tag",required = false) String tag,//标签
                            @RequestParam(value = "id",required = false) Integer id,//问题的id
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

        User user = (User)request.getSession().getAttribute("user");//把查找到的user存入session中。

        if (user==null){
            model.addAttribute("error","用户没有登录");
            return "publish";
        }

        Question question = new Question();
        question.setTitle(title);
        question.setDescription(description);
        question.setTag(tag);
        question.setCreator(user.getId());
        question.setId(id);
        questionService.createOrUpdate(question);
//        questionService.addQuestion(question);//写入数据库

        return "redirect:/";

    }
}
