package com.duoduo.hashming.artisan.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private Long parentId;//问题的父问题的id
    private String content;//评论内容
    private Integer type;//问题的类型
}
