package com.duoduo.hashming.artisan.interceptors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duoduo.hashming.artisan.entity.User;
import com.duoduo.hashming.artisan.mapper.UserMapper;
import com.duoduo.hashming.artisan.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class SessionInterceptor implements HandlerInterceptor {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserMapper userMapper;

    /**
     * 程序处理之前。
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();//请求中又好多cookie
        //下面的这个代码以后可以用redis的方式进行代替
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {//找到cookie中名字为token的键值对
                    String token = cookie.getValue();//取出对应的cookie
                    QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
                    userQueryWrapper.eq("token", token);
                    List<User> users = userMapper.selectList(userQueryWrapper);
                    if (users.size()!= 0) {
                        request.getSession().setAttribute("user", users.get(0));//把查找到的user存入session中。
                    }
                    break;
                }
            }
        }
        //如果return false会停止，如果return true会继续执行。
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
