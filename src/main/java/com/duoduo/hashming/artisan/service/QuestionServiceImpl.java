package com.duoduo.hashming.artisan.service;

import com.duoduo.hashming.artisan.dao.QuestionExtMapper;
import com.duoduo.hashming.artisan.dao.QuestionMapper;
import com.duoduo.hashming.artisan.dao.UserMapper;
import com.duoduo.hashming.artisan.dto.PaginationDTO;
import com.duoduo.hashming.artisan.dto.QuestionDTO;
import com.duoduo.hashming.artisan.dto.Question_User;
import com.duoduo.hashming.artisan.model.Question;
import com.duoduo.hashming.artisan.model.QuestionExample;
import com.duoduo.hashming.artisan.model.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "questionService")
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionExtMapper questionExtMapper;

    @Override
    public int addQuestion(Question question) {
        return 0;
    }

    @Override
    //这里把结果返回给我们新定义的类中，这个类包含了页数信息和要返回的数据信息。
    public PaginationDTO show(Integer pageNum, Integer pageSize) {
        PaginationDTO paginationDTO = new PaginationDTO();
        /*Integer totalPage;
        Integer totalCount = (int)questionMapper.countByExample(new QuestionExample());//todo 以后肯定是要改正的

        if (totalCount % pageSize == 0) {
            totalPage = totalCount / pageSize;
        } else {
            totalPage = totalCount / pageSize + 1;
        }

        if (pageNum<1){
            pageNum=1;
        }
        if (pageNum>totalPage){
            pageNum=totalPage;
        }

        //查询出来所有的额问题信息，存入list中
        paginationDTO.setPagination(totalCount,pageNum);
        //size*(page-1)
        Integer offset = pageSize*(pageNum-1);
        List<Question> questions = questionMapper.getall(offset,pageSize);//根据分页信息查询问题列表
        List<QuestionDTO> questionDTOList = new ArrayList<>();

        for (Question question : questions) {
            //这里的creator和id是相互对应的
            User user = userMapper.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();//比question多一个user属性
//            questionDTO.setUser(user);
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);//把所有question多一个user属性点的东西都添加在列表中
        }
        paginationDTO.setQuestions(questionDTOList);*/
        //传入的参数有当前页码，页数，页面大小

        return paginationDTO;

    }

    /**
     * 统计总共有多少个问题的数量
     * @return
     */
    @Override
    public Integer count() {
        return 999;
//        return questionMapper.count();
    }

    /**
     * 查询指定的用户创建的问题
     * @param userId
     * @param pageNum
     * @param pageSize
     */
    public PaginationDTO show(Integer userId,Integer pageNum, Integer pageSize){
        PaginationDTO paginationDTO = new PaginationDTO();
        /*Integer totalPage;
       *//* QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria().andCreatorEqualTo(user)*//*
        Integer totalCount = questionMapper.count();//获取所有的问题数量

        if (totalCount % pageSize == 0) {
            totalPage = totalCount / pageSize;
        } else {
            totalPage = totalCount / pageSize + 1;
        }

        if (pageNum<1){
            pageNum=1;
        }
        if (pageNum>totalPage){
            pageNum=totalPage;
        }
        paginationDTO.setPagination(totalCount,pageNum);
        Integer offset = pageSize*(pageNum-1);
        List<Question> questions = questionMapper.getall_byCreator(userId,offset,pageSize);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions) {
            User user = userMapper.selectByPrimaryKey(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);*/
        return paginationDTO;
    }

    /**
     * 分页插件 主页的查询所有问题
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<Question_User> findAllQuestion(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Question_User> questions = questionMapper.showAll();
        PageInfo<Question_User> result = new PageInfo(questions);

        return result;
    }

    @Override
    public PageInfo<Question_User> findAllQuestionByuserId(Integer userId, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Question_User> question_users = questionMapper.showAll_byCreator(userId);
        PageInfo<Question_User> result = new PageInfo(question_users);
        return result;
    }

    @Override
    public Question_User getById(Integer id) {
        Question_User sdf = questionMapper.getById(id);//todo 这个需要改
        return sdf;
    }

    @Override
    public QuestionDTO getId(Integer id){
        Question question = questionMapper.selectByPrimaryKey(id);
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question,questionDTO);
        User user = userMapper.selectByPrimaryKey(question.getCreator());
        questionDTO.setUser(user);
        return questionDTO;

    }

    /**
     * 增加阅读数
     * @param id
     */
    @Override
    public void addViewCount(Integer id) {
        //先根据id查询出来所有的，然后再取出viewCount进行+1操作，然后根据问题的id进行更新数据
        /*Question_User sdf = questionMapper.getById(id);
        Question question = new Question();
        question.setViewCount(sdf.getViewCount()+1);
        QuestionExample questionExample = new QuestionExample();
        questionExample.createCriteria().andIdEqualTo(id);
        questionMapper.updateByExampleSelective(question,questionExample);*/
//        上面的这个方法在好多用户同时浏览的时候会出现错误
        Question question = new Question();
        question.setId(id);
        question.setViewCount(1);
        questionExtMapper.incView(question);
    }

    /**
     * 进行一个判断如果question.id是空的就创建 不是空就更新
     * @param question
     */
    @Override
    public void createOrUpdate(Question question) {
        if (question.getId()==null){
            //创建
            question.setGmtCreate(System.currentTimeMillis());
            question.setGmtModified(question.getGmtCreate());
            questionMapper.insert(question);
        }else{
            //更新
            Question updateQuestion = new Question();
            updateQuestion.setGmtModified(System.currentTimeMillis());
            updateQuestion.setTitle(question.getTitle());
            updateQuestion.setDescription(question.getDescription());
            updateQuestion.setTag(question.getTag());
            QuestionExample example = new QuestionExample();
            example.createCriteria().andIdEqualTo(question.getId());
            questionMapper.updateByExampleSelective(updateQuestion, example);
        }
    }

}
