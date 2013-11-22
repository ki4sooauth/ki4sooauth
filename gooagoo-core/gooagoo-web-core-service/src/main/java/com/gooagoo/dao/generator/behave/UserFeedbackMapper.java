package com.gooagoo.dao.generator.behave;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.behave.UserFeedback;
import com.gooagoo.entity.generator.behave.UserFeedbackExample;
import com.gooagoo.entity.generator.behave.UserFeedbackKey;

public interface UserFeedbackMapper
{

    public Integer countByExample(UserFeedbackExample userFeedbackExample);

    public List<UserFeedback> selectByExample(UserFeedbackExample userFeedbackExample);

    public UserFeedback selectByPrimaryKey(UserFeedbackKey userFeedbackKey);

    public Integer deleteByExample(UserFeedbackExample userFeedbackExample);

    public Integer deleteByPrimaryKey(UserFeedbackKey userFeedbackKey);

    public Integer insertSelective(UserFeedback userFeedback);

    public Integer updateAllByExample(@Param("record") UserFeedback userFeedback, @Param("example") UserFeedbackExample userFeedbackExample);

    public Integer updateByExampleSelective(@Param("record") UserFeedback userFeedback, @Param("example") UserFeedbackExample userFeedbackExample);

    public Integer updateByPrimaryKeySelective(UserFeedback userFeedback);

}
