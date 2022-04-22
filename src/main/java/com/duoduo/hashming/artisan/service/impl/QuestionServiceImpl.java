package com.duoduo.hashming.artisan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duoduo.hashming.artisan.dto.Question_User;
import com.duoduo.hashming.artisan.entity.Question;
import com.duoduo.hashming.artisan.mapper.QuestionMapper;
import com.duoduo.hashming.artisan.service.IQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.javassist.tools.reflect.Sample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author duoduo
 * @since 2022-04-22
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    /**
     * 首页展示问题列表
     *
     * @param pageNum  pageNum
     * @param pageSize  pageSize
     * @return PageInfo
     */
    @Override
    public PageInfo<Question_User> findAllQuestion(Integer pageNum, Integer pageSize) {
        PageInfo<Question_User> pageInfo = PageHelper.startPage(1, 5).doSelectPageInfo(
                () -> questionMapper.selectQuestionUser()
        );
        return pageInfo;
    }


    @Override
    public void createOrUpdate(Question question) {
        QueryWrapper<Question> questionQueryWrapper = new QueryWrapper<>();

        questionMapper.update(question, questionQueryWrapper);
    }
}
