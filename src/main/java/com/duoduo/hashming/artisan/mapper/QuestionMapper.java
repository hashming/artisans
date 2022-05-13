package com.duoduo.hashming.artisan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.duoduo.hashming.artisan.dto.Question_User;
import com.duoduo.hashming.artisan.entity.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper extends BaseMapper<Question> {

    List<Question> selectAllByCreatorOrCommentCount(@Param("creator")Integer creator,@Param("commentCount")Integer commentCount);

    List<Question_User> selectQuestionUser(@Param("questionName") String questionName);

    /**
     * 查询全部的问题 根据creator
     *
     * @return
     */
    @Select("select a.*,b.* from question a join user b on a.creator=b.ID where a.creator = #{userId}")
    List<Question_User> showAllByCreator(@Param("userId") Integer userId);

    @Select("select a.*,b.* from question a join user b on a.creator=b.ID where a.id=#{questionId}")
    Question_User getQuestionDetailById(@Param("questionId") Integer questionId);

    @Select("update question set view_count = view_count + 1 where id = #{questionId}")
    void addViewCount(Integer questionId);
}