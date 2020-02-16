package com.duoduo.hashming.artisan.dto;

import lombok.Data;

@Data
public class Question_User {
    private Integer id;//id
    private String title;//标题
    private String description;//描述  对应的mybatis中的数据类型是longvarchar
    private String tag;//标签
    private Long gmt_create;//创建时间
    private Long gmt_modified;//更改时间
    private Integer creator;//创建者
    private Integer view_count;//观看人数
    private Integer comment_count;//评论数
    private Integer like_count;//喜欢的人数
    private Integer id1;//id
    private String name;//名字
    private String account_id;//账户id
    private String token;//令牌
    private Long gmt_create1;//创建时间
    private Long gmt_modified1;//更改时间
    private String avatar_url;//图片路径
}
