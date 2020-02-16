package com.duoduo.hashming.artisan.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebMvc  如果不注解这个css样式会无法显示   写了这个注解就要自定义静态文件的路径
public class WebConfig implements WebMvcConfigurer {

    //因为这个类被spring的service进行了修饰所以，这个时候webconfig类中引入这个类就要先生命一下
    @Autowired
    private SessionInterceptor sessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //下面的addPathPatterns中添加的是把哪些地址进行拦截，excludePathPatterns是对哪些地址进行一个略过。
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**");
    }
}