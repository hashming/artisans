package com.duoduo.hashming.artisan.mapper;

import com.duoduo.hashming.artisan.dto.Question_User;
import com.duoduo.hashming.artisan.entity.Question;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.javassist.tools.reflect.Sample;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author duoduo
 * @since 2022-04-22
 */
public interface QuestionMapper extends BaseMapper<Question> {

    @Select("select a.*,b.* from question a join user b on a.creator=b.ID")
    List<Question_User> selectQuestionUser();
}
