package com.duoduo.hashming.artisan.controller;

import com.duoduo.hashming.artisan.entity.Question;
import com.duoduo.hashming.artisan.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Question)表控制层
 *
 * @author makejava
 * @since 2021-11-29 01:26:59
 */
@RestController
@RequestMapping("question")
public class QuestionController {
    /**
     * 服务对象
     */
    @Resource
    private QuestionService questionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Question selectOne(Integer id) {
        return this.questionService.queryById(id);
    }

}