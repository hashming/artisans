package com.duoduo.hashming.artisan.controller;

import com.duoduo.hashming.artisan.model.User;
import com.duoduo.hashming.artisan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(HttpServletRequest request){
        //cookie和session的关系。cookie是银行卡，session是账户
        Cookie[] cookies = request.getCookies();//请求中又好多cookie
        //下面的这个代码以后可以用redis的方式进行代替
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")){//找到cookie中名字为token的键值对
                String token = cookie.getValue();//取出对应的cookie
                User user = userService.find(token);//通过这个特定的cookie查找指定的user信息
                if (user!=null){
                    request.getSession().setAttribute("user",user);//把查找到的user存入session中。
                }
                break;
            }
        }

        return "index";
    }

}

