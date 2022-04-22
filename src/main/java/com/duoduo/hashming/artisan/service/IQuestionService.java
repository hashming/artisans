package com.duoduo.hashming.artisan.service;

import com.duoduo.hashming.artisan.dto.Question_User;
import com.duoduo.hashming.artisan.entity.Question;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author duoduo
 * @since 2022-04-22
 */
public interface IQuestionService extends IService<Question> {

    PageInfo<Question_User> findAllQuestion(Integer pageNum, Integer pageSize);

    void createOrUpdate(Question question);
}
