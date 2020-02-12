package com.duoduo.hashming.artisan.model;

import lombok.Data;

/**
 * 这里希望creator关联user表拿到对应的user中的图片路径
 * creator关联User中的id
 */
@Data
public class Question {
    private Integer id;//id
    private String title;//标题
    private String description;//描述  对应的mybatis中的数据类型是longvarchar
    private String tag;//标签
    private Long gmt_create;//创建时间
    private Long gmt_modified;//更改时间
    private Integer creator;//创建者  关联user的id
    private Integer view_count;//观看人数
    private Integer comment_count;//评论数
    private Integer like_count;//喜欢的人数


}