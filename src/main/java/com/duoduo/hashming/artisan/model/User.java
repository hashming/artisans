package com.duoduo.hashming.artisan.model;

import lombok.Data;

@Data
public class User {
    private Integer id;//id  这个id是我们数据库里面的主键
    private String name;//名字
    private String account_id;//账户id  这个是唯一的，是github网站上面的主键
    private String token;//令牌
    private Long gmt_create;//创建时间
    private Long gmt_modified;//更改时间
    private String avatar_url;//图片路径

}
