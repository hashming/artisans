package com.duoduo.hashming.artisan.service;

import com.duoduo.hashming.artisan.dto.PaginationDTO;
import com.duoduo.hashming.artisan.dto.QuestionDTO;
import com.duoduo.hashming.artisan.dto.Question_User;
import com.duoduo.hashming.artisan.model.Question;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface QuestionService {

    /**
     * 插入问题信息
     * @param question
     * @return
     */
    int addQuestion(Question question);

    /**
     * 屋里分页——查询所有的问题
     * @param pageNum
     * @param pageSize
     * @return
     */
    PaginationDTO show(Integer pageNum, Integer pageSize);

    /**
     * 查询问题的个数
     * @return
     */
    Integer count();

    /**
     * 查询指定的用户创建的问题
     * @param userId
     * @param pageNum
     * @param pageSize
     */
    PaginationDTO show(Integer userId,Integer pageNum,Integer pageSize);

    /**
     * 分页插件 主页的查询所有问题
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Question_User> findAllQuestion(Integer pageNum, Integer pageSize);

    /**
     * 分页插件 主页的查询所有问题,根据创建者查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Question_User> findAllQuestionByuserId(Integer userId,Integer pageNum,Integer pageSize);

    /**
     *
     * @param id
     * @return
     */
    Question_User getById(Integer id);
}
