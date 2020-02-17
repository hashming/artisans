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
                           HttpServletRequest request,
                           HttpServletResponse response){//会把上下文中的request直接放在这个request参数中
        //录入code和state
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();//承载类
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(secret);
        accessTokenDTO.setState(state);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(uri);//应用程序中用户经过授权后发送的 URL 就是登录成功后跳转的页面
        //第一步骤已经完成
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);//调用accesstoken这个方法把accesstoken承载类传入这个方法  accesstoken访问令牌 也可以说是通行证吧
        //第二步骤完成，成功获取到accesstoken
        GithubUser githubUser = githubProvider.getUser(accessToken);//获取github的用户信息

        if(githubUser!=null && githubUser.getId()!=null){//如果登录成功就生成一个token,存储入数据库中
            User user = new User();
            String token = UUID.randomUUID().toString();//生成一个token
            //把从github上面获取到的用户的信息，存入数据库
            user.setToken(token);
            user.setName(githubUser.getName());
            user.setAccount_id(String.valueOf(githubUser.getId()));
            user.setAvatar_url(githubUser.getAvatar_url());//用户头像的图片路径
            userService.createOrUpdate(user);
//            userService.addUser(user);
            response.addCookie(new Cookie("token",token));//把token放入到cookie中
            return "redirect:/";//redirect后面要引入一个具体的路径。重定向
            //登录成功写cookie和session
        }else{
            return "redirect:/";
            //登录失败，重新登录
        }
    }

    /**
     * 退出登录功能
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response){
        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("token",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }

}
