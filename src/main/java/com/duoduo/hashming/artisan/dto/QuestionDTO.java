package com.duoduo.hashming.artisan.dto;

import com.duoduo.hashming.artisan.entity.User;
import lombok.Data;

/**
 * question和user对象联系起来
 */
@Data
public class QuestionDTO {
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
    private User user;
}
