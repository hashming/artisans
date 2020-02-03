package com.duoduo.hashming.artisan.controller;

import com.duoduo.hashming.artisan.dto.AccessTokenDTO;
import com.duoduo.hashming.artisan.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state){
        //录入code和state
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();//承载类

        accessTokenDTO.setClient_id("c69ece8b7824522367e0");
        accessTokenDTO.setClient_secret("58f2c0643fd18fe045b876a0c4e245ac347f2b59");
        accessTokenDTO.setState(state);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");//应用程序中用户经过授权后发送的 URL 就是登录成功后跳转的页面

        githubProvider.getAccessToken(accessTokenDTO);//调用accesstoken这个方法把accesstoken承载类传入这个方法
        return "index";

    }

}
