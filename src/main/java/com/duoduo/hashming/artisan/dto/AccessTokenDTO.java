package com.duoduo.hashming.artisan.dto;

import lombok.Data;

/**
 * github登录令牌
 */

@Data
public class AccessTokenDTO {

    private String client_id;//委托人id
    private String client_secret;//委托secret
    private String code;
    private String redirect_uri;//重定向uri
    private String state;//状态


}
