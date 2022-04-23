package com.duoduo.hashming.artisan.controller;

import com.duoduo.hashming.artisan.entity.User;
import com.duoduo.hashming.artisan.service.ILoginUserService;
import com.duoduo.hashming.artisan.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;


@Controller
public class LoginController {
    @Autowired
    private IUserService userService;

    @GetMapping("/login")
    public String userLogin(){
        return "login";
    }

    @PostMapping("/login")
    public String callback(@RequestParam(value = "userName",required = false) String userName,
                           @RequestParam(value = "password",required = false) String password,
                           HttpServletRequest request, HttpServletResponse response) {

        User user = userService.findUser(userName, password);
        if (!ObjectUtils.isEmpty(user)) {
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            Boolean isSaveStatus = userService.addCookieForCurrentUser(user);
            response.addCookie(new Cookie("token", token));
        }
        return "redirect:/";
    }


}
