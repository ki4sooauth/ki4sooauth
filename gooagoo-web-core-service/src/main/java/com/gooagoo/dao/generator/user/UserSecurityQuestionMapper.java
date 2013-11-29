package com.gooagoo.dao.generator.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.user.UserSecurityQuestion;
import com.gooagoo.entity.generator.user.UserSecurityQuestionExample;
import com.gooagoo.entity.generator.user.UserSecurityQuestionKey;

public interface UserSecurityQuestionMapper
{

    public Integer countByExample(UserSecurityQuestionExample userSecurityQuestionExample);

    public List<UserSecurityQuestion> selectByExample(UserSecurityQuestionExample userSecurityQuestionExample);

    public UserSecurityQuestion selectByPrimaryKey(UserSecurityQuestionKey userSecurityQuestionKey);

    public Integer deleteByExample(UserSecurityQuestionExample userSecurityQuestionExample);

    public Integer deleteByPrimaryKey(UserSecurityQuestionKey userSecurityQuestionKey);

    public Integer insertSelective(UserSecurityQuestion userSecurityQuestion);

    public Integer updateAllByExample(@Param("record") UserSecurityQuestion userSecurityQuestion, @Param("example") UserSecurityQuestionExample userSecurityQuestionExample);

    public Integer updateByExampleSelective(@Param("record") UserSecurityQuestion userSecurityQuestion, @Param("example") UserSecurityQuestionExample userSecurityQuestionExample);

    public Integer updateByPrimaryKeySelective(UserSecurityQuestion userSecurityQuestion);

}
