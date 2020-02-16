package com.duoduo.hashming.artisan.controller;

import com.duoduo.hashming.artisan.dto.PaginationDTO;
import com.duoduo.hashming.artisan.dto.Question_User;
import com.duoduo.hashming.artisan.model.User;
import com.duoduo.hashming.artisan.service.QuestionService;
import com.duoduo.hashming.artisan.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @Autowired
    private QuestionService questionService;


//    对应前端的点击事件，当我们点击咱的问题的时候就动态的把questions赋值给action，然后下面的判断就成立了
    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action") String action, Model model,
                          HttpServletRequest request,
                          @RequestParam(name = "pageNum",defaultValue = "1") Integer pageNum,
                          @RequestParam(name = "pageSize",defaultValue = "5") Integer pageSize){
        //cookie和session的关系。cookie是银行卡，session是账户
        Cookie[] cookies = request.getCookies();//请求中又好多cookie
        User user = null;
        //下面的这个代码以后可以用redis的方式进行代替
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {//找到cookie中名字为token的键值对
                    String token = cookie.getValue();//取出对应的cookie
                    user = userService.find(token);//通过这个特定的cookie查找指定的user信息
                    if (user != null) {
                        request.getSession().setAttribute("user", user);//把查找到的user存入session中。
                    }
                    break;
                }
            }
        }

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
        PageInfo<Question_User> allUser = questionService.findAllQuestionByuserId(user.getId(),pageNum, pageSize);
        model.addAttribute("pagination",allUser);
        return "profile";
    }
}
