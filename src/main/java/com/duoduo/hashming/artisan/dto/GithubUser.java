package com.duoduo.hashming.artisan.dto;

import lombok.Data;

/**
 * 存储github用户信息
 * 返回的信息有很多，这里我们只需要name,id,bio
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;

    @Override
    public String toString() {
        return "GithubUser{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", bio='" + bio + '\'' +
                '}';
    }



}
