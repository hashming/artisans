package com.duoduo.hashming.artisan.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyGlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,Object> customException(Exception e) {
        Map<String,Object> result=new HashMap<String,Object>();
        result.put("erroeCode","500");
        result.put("errorMsg","系统错误");
        return result;
    }
}
