package com.duoduo.hashming.artisan.controller;

import com.duoduo.hashming.artisan.dto.AccessTokenDTO;
import com.duoduo.hashming.artisan.dto.GithubUser;
import com.duoduo.hashming.artisan.model.User;
import com.duoduo.hashming.artisan.provider.GithubProvider;
import com.duoduo.hashming.artisan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

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

    @Autowired
    private UserService userService;


    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state")String state,
                           HttpServletRequest request, HttpServletResponse response){//会把上下文中的request直接放在这个request参数中
        //录入code和state
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();//承载类

        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(secret);
        accessTokenDTO.setState(state);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(uri);//应用程序中用户经过授权后发送的 URL 就是登录成功后跳转的页面

        //第一步骤已经完成
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);//调用accesstoken这个方法把accesstoken承载类传入这个方法  accesstoken访问令牌
        //第二步骤完成，成功获取到accesstoken
        GithubUser user = githubProvider.getUser(accessToken);//获取github的用户信息

        if(user!=null && user.getId()!=null){//如果登录成功就生成一个token,存储入数据库中
            User user1 = new User();
            String token = UUID.randomUUID().toString();//生成一个token
            //存入数据库
            user1.setToken(token);
            user1.setName(user.getName());
            user1.setAccount_id(String.valueOf(user.getId()));
            user1.setGmt_create(System.currentTimeMillis());
            user1.setGmt_modified(user1.getGmt_create());
            user1.setAvatar_url(user.getAvatar_url());
            userService.addUser(user1);

            response.addCookie(new Cookie("token",token));//把token放入到cookie中

//            request.getSession().setAttribute("user",user);
//            return "redirect:index";
            return "redirect:/";//redirect后面要引入一个具体的路径。重定向
            //登录成功写cookie和session
        }else{
            return "redirect:/";
            //登录失败，重新登录
        }
//        return "index";

    }

}
