package com.duoduo.hashming.artisan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.duoduo.hashming.artisan.dto.QuestionDTO;
import com.duoduo.hashming.artisan.dto.Question_User;
import com.duoduo.hashming.artisan.entity.Question;
import com.duoduo.hashming.artisan.entity.User;
import com.duoduo.hashming.artisan.mapper.QuestionMapper;
import com.duoduo.hashming.artisan.mapper.UserMapper;
import com.duoduo.hashming.artisan.service.IQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.javassist.tools.reflect.Sample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private UserMapper userMapper;

    /**
     * 首页展示问题列表
     *
     * @param pageNum  pageNum
     * @param pageSize  pageSize
     * @return PageInfo
     */
    @Override
    public PageInfo<Question_User> findAllQuestion(Integer pageNum, Integer pageSize) {
        PageInfo<Question_User> pageInfo = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(
                () -> questionMapper.selectQuestionUser()
        );
        return pageInfo;
    }


    @Override
    public void createOrUpdate(Question question) {
        Long time = System.currentTimeMillis();
        QueryWrapper<Question> questionQueryWrapper = new QueryWrapper<>();
        questionQueryWrapper.eq("id", question.getId());
        boolean isExitQuestion = questionMapper.exists(questionQueryWrapper);
        if (isExitQuestion) {
            question.setGmtModified(time);
            questionMapper.update(question, questionQueryWrapper);
        } else {
            question.setGmtCreate(time);
            questionMapper.insert(question);
        }
    }

    /**
     * 根据Id查询问题相关信息
     *
     * @param id 问题id
     * @return 问题相关信息
     */
    @Override
    public QuestionDTO getQuestionById(Integer id) {
        Question question = questionMapper.selectById(id);
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question, questionDTO);
        User user = userMapper.selectById(question.getCreator());
        questionDTO.setUser(user);
        return questionDTO;
    }

    @Override
    public PageInfo<Question_User> findAllQuestionByUserId(Integer userId, Integer pageNum, Integer pageSize) {
        PageInfo<Question_User> pageInfo = PageHelper.startPage(pageNum, pageSize).doSelectPageInfo(
                () -> questionMapper.showAllByCreator(userId)
        );
        return pageInfo;
    }

    @Override
    public Question_User getQuestionDetailById(Integer questionId) {
        Question_User sdf = questionMapper.getQuestionDetailById(questionId);
        return sdf;
    }

    @Override
    public void addViewCount(Integer questionId) {
        questionMapper.addViewCount(questionId);
    }
}
