package com.duoduo.hashming.artisan.provider;

import com.alibaba.fastjson.JSON;
import com.duoduo.hashming.artisan.dto.AccessTokenDTO;
import com.duoduo.hashming.artisan.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 连接github提供服务
 */
@Component
public class GithubProvider {
    /**
     * post请求 因为github上这一步就要用Post请求
     * 这个方法就是获取accesstoken
     * @param accessTokenDTO  把承载类作为参数传入进去
     * @return
     */
    public String getAccessToken(AccessTokenDTO accessTokenDTO){//这里的accessTokenDTO是一个类
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));//这里第二个形式参数，要求是json所以我们要转化一下
        Request request = new Request.Builder().url("https://github.com/login/oauth/access_token").post(body).build();
        try (Response response = client.newCall(request).execute()) {
            //post请求response中有token信息
            //下面是来获取他的accesstoken
            String ss = response.body().string();
            System.out.println(ss);
            String token = ss.split("&")[0].split("=")[1];
            System.out.println(token);
            return token;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }//获取完token就是第二部完成

    /**
     * get请求
     * 获取用户名
     * @param accessToken  传入参数accesstoken
     * @return
     */
    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();//response请求会返回一个html页面
            String string = response.body().string();//把这个页面转化成string
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);//把string转化为java的类对象
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
