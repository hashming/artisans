package com.duoduo.hashming.artisan.dao;

import com.duoduo.hashming.artisan.dto.Question_User;
import com.duoduo.hashming.artisan.model.Question;
import com.duoduo.hashming.artisan.model.QuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface QuestionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hh_demo..question
     *
     * @mbg.generated Wed Feb 19 08:53:19 CST 2020
     */
    long countByExample(QuestionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hh_demo..question
     *
     * @mbg.generated Wed Feb 19 08:53:19 CST 2020
     */
    int deleteByExample(QuestionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hh_demo..question
     *
     * @mbg.generated Wed Feb 19 08:53:19 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hh_demo..question
     *
     * @mbg.generated Wed Feb 19 08:53:19 CST 2020
     */
    int insert(Question record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hh_demo..question
     *
     * @mbg.generated Wed Feb 19 08:53:19 CST 2020
     */
    int insertSelective(Question record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hh_demo..question
     *
     * @mbg.generated Wed Feb 19 08:53:19 CST 2020
     */
    List<Question> selectByExampleWithBLOBs(QuestionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hh_demo..question
     *
     * @mbg.generated Wed Feb 19 08:53:19 CST 2020
     */
    List<Question> selectByExample(QuestionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hh_demo..question
     *
     * @mbg.generated Wed Feb 19 08:53:19 CST 2020
     */
    Question selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hh_demo..question
     *
     * @mbg.generated Wed Feb 19 08:53:19 CST 2020
     */
    int updateByExampleSelective(@Param("record") Question record, @Param("example") QuestionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hh_demo..question
     *
     * @mbg.generated Wed Feb 19 08:53:19 CST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") Question record, @Param("example") QuestionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hh_demo..question
     *
     * @mbg.generated Wed Feb 19 08:53:19 CST 2020
     */
    int updateByExample(@Param("record") Question record, @Param("example") QuestionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hh_demo..question
     *
     * @mbg.generated Wed Feb 19 08:53:19 CST 2020
     */
    int updateByPrimaryKeySelective(Question record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hh_demo..question
     *
     * @mbg.generated Wed Feb 19 08:53:19 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(Question record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hh_demo..question
     *
     * @mbg.generated Wed Feb 19 08:53:19 CST 2020
     */
    int updateByPrimaryKey(Question record);

    /**
     * 查询全部的问题
     * @return
     */
    @Select("select a.*,b.* from question a join user b on a.creator=b.ID")
    List<Question_User> showAll();

    /**
     * 查询全部的问题 根据creator
     * @return
     */
    @Select("select a.*,b.* from question a join user b on a.creator=b.ID where a.creator = #{userId}")
    List<Question_User> showAll_byCreator(@Param("userId") Integer userId);

    /**
     * 问题详情显示，根据id来查询两个表的信息
     * @param id
     * @return
     */
    @Select("select a.*,b.* from question a join user b on a.creator=b.ID where a.id=#{Id}")
    Question_User getById(@Param("Id") Integer id);
}