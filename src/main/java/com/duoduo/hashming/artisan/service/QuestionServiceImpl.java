package com.duoduo.hashming.artisan.service;

import com.duoduo.hashming.artisan.dao.QuestionMapper;
import com.duoduo.hashming.artisan.dao.UserMapper;
import com.duoduo.hashming.artisan.dto.PaginationDTO;
import com.duoduo.hashming.artisan.dto.QuestionDTO;
import com.duoduo.hashming.artisan.model.Question;
import com.duoduo.hashming.artisan.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "questionService")
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addQuestion(Question question) {
        return questionMapper.create(question);
    }

    @Override
    //这里把结果返回给我们新定义的类中，这个类包含了页数信息和要返回的数据信息。
    public PaginationDTO show(Integer pageNum, Integer pageSize) {
        //查询出来所有的额问题信息，存入list中
        //size*(page-1)
        Integer offset = pageSize*(pageNum-1);
        List<Question> questions = questionMapper.getall(offset,pageSize);//根据分页信息查询问题列表
        List<QuestionDTO> questionDTOList = new ArrayList<>();

        PaginationDTO paginationDTO = new PaginationDTO();
        for (Question question : questions) {
            //这里的creator和id是相互对应的
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();//比question多一个user属性
//            questionDTO.setUser(user);
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);//把所有question多一个user属性点的东西都添加在列表中
        }
        paginationDTO.setQuestions(questionDTOList);
        Integer totalCount = questionMapper.count();//获取所有的问题数量
        //传入的参数有当前页码，页数，页面大小
        paginationDTO.setPagination(totalCount,pageNum,pageSize);//
        
        return paginationDTO;

    }

    /**
     * 统计总共有多少个问题的数量
     * @return
     */
    @Override
    public Integer count() {
        return questionMapper.count();
    }

    /**
     * 分页插件
     * @param pageNum
     * @param pageSize
     * @return
     */
    /*@Override
    public PageInfo<Question> findAllQuestion(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);//开始的页数，每一页的现实的数据的条数

        List<Question> questions = questionMapper.getall();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions) {
            //这里的creator和id是相互对应的
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
//            questionDTO.setUser(user);
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }

        PageInfo result = new PageInfo(questionDTOList);
        return result;
    }*/
}
