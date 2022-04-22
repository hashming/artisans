package com.duoduo.hashming.artisan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 
 * </p>
 *
 * @author duoduo
 * @since 2022-04-22
 */
@ApiModel(value = "Question对象", description = "")
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("简介")
    private String description;

    @ApiModelProperty("创建时间")
    private Long gmtCreate;

    @ApiModelProperty("修改时间")
    private Long gmtModified;

    @ApiModelProperty("操作人")
    private Integer creator;

    @ApiModelProperty("评论数")
    private Integer commentCount;

    @ApiModelProperty("查看数")
    private Integer viewCount;

    @ApiModelProperty("点赞数")
    private Integer likeCount;

    @ApiModelProperty("标签")
    private String tag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
    public Long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }
    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }
    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }
    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }
    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "Question{" +
            "id=" + id +
            ", title=" + title +
            ", description=" + description +
            ", gmtCreate=" + gmtCreate +
            ", gmtModified=" + gmtModified +
            ", creator=" + creator +
            ", commentCount=" + commentCount +
            ", viewCount=" + viewCount +
            ", likeCount=" + likeCount +
            ", tag=" + tag +
        "}";
    }
}
