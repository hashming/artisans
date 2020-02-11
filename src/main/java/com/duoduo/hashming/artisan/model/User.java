package com.duoduo.hashming.artisan.model;

import lombok.Data;

@Data
public class User {
    private Integer id;//id
    private String name;//名字
    private String account_id;//账户id
    private String token;//令牌
    private Long gmt_create;//创建时间
    private Long gmt_modified;//更改时间
    private String avatar_url;//图片路径

}
