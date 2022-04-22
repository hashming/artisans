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
@ApiModel(value = "Comment对象", description = "")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Long parentId;

    @ApiModelProperty("类型")
    private Integer type;

    @ApiModelProperty("评论员")
    private Integer commentator;

    @ApiModelProperty("创建时间")
    private Long gmtCreate;

    @ApiModelProperty("修改时间")
    private Long gmtModified;

    @ApiModelProperty("点赞数")
    private Long likeCount;

    @ApiModelProperty("内容")
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public Integer getCommentator() {
        return commentator;
    }

    public void setCommentator(Integer commentator) {
        this.commentator = commentator;
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
    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Comment{" +
            "id=" + id +
            ", parentId=" + parentId +
            ", type=" + type +
            ", commentator=" + commentator +
            ", gmtCreate=" + gmtCreate +
            ", gmtModified=" + gmtModified +
            ", likeCount=" + likeCount +
            ", content=" + content +
        "}";
    }
}
