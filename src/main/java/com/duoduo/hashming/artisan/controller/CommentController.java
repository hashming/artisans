package com.duoduo.hashming.artisan.controller;

import com.duoduo.hashming.artisan.entity.Comment;
import com.duoduo.hashming.artisan.service.CommentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Comment)表控制层
 *
 * @author makejava
 * @since 2021-11-29 01:26:36
 */
@RestController
@RequestMapping("comment")
public class CommentController {
    /**
     * 服务对象
     */
    @Resource
    private CommentService commentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Comment selectOne(Long id) {
        return this.commentService.queryById(id);
    }

}