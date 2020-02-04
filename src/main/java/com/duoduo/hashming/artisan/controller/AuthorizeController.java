package com.duoduo.hashming.artisan.controller;

import com.duoduo.hashming.artisan.dto.AccessTokenDTO;
import com.duoduo.hashming.artisan.dto.GithubUser;
import com.duoduo.hashming.artisan.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;
    /**
     * value注解连接到配置文件，从配置文件中去读取数据
     */
    @Value("${github.client.id}")
    private String clientId;
    @Value("${github.client.secret}")
    private String secret;
    @Value("${github.redirect.uri}")
    private String uri;


    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state,
                           HttpServletRequest request){//会把上下文中的request直接放在这个request参数中
        //录入code和state
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();//承载类

        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(secret);
        accessTokenDTO.setState(state);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(uri);//应用程序中用户经过授权后发送的 URL 就是登录成功后跳转的页面

        String accessToken = githubProvider.getAccessToken(accessTokenDTO);//调用accesstoken这个方法把accesstoken承载类传入这个方法
        GithubUser user = githubProvider.getUser(accessToken);

        if(user!=null){
            request.getSession().setAttribute("user",user);
//            return "redirect:index";
            return "redirect:/";//redirect后面要引入一个具体的路径。
            //登录成功写cookie和session
        }else{
            return "redirect:/";
            //登录失败，重新登录
        }
//        return "index";

    }

}
