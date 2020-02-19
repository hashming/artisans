package com.duoduo.hashming.artisan.dto;

import lombok.Data;

@Data
public class Question_User {
    private Integer id;//id
    private String title;//标题
    private String description;//描述  对应的mybatis中的数据类型是longvarchar
    private String tag;//标签
    private Long gmtCreate;//创建时间
    private Long gmtModified;//更改时间
    private Integer creator;//创建者
    private Integer viewCount;//观看人数
    private Integer commentCount;//评论数
    private Integer likeCount;//喜欢的人数
    private Integer id1;//id
    private String name;//名字
    private String accountId;//账户id
    private String token;//令牌
    private Long gmtCreate1;//创建时间
    private Long gmtModified1;//更改时间
    private String avatarUrl;//图片路径
}
