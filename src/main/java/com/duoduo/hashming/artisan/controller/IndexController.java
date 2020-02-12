package com.duoduo.hashming.artisan.controller;

import com.duoduo.hashming.artisan.dto.QuestionDTO;
import com.duoduo.hashming.artisan.model.Question;
import com.duoduo.hashming.artisan.model.User;
import com.duoduo.hashming.artisan.service.QuestionService;
import com.duoduo.hashming.artisan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 先判断登录状态 然后跳入index界面
 */
@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,Model model){
        //cookie和session的关系。cookie是银行卡，session是账户
        Cookie[] cookies = request.getCookies();//请求中又好多cookie
        //下面的这个代码以后可以用redis的方式进行代替
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {//找到cookie中名字为token的键值对
                    String token = cookie.getValue();//取出对应的cookie
                    User user = userService.find(token);//通过这个特定的cookie查找指定的user信息
                    if (user != null) {
                        request.getSession().setAttribute("user", user);//把查找到的user存入session中。
                    }
                    break;
                }
            }
        }


        List<QuestionDTO> questionList =  questionService.show();
        model.addAttribute("questions",questionList);
        return "index";
    }

}

