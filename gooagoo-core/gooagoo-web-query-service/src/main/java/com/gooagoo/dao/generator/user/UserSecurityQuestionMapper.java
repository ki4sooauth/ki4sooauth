package com.gooagoo.dao.generator.user;

import java.util.List;

import com.gooagoo.entity.generator.user.UserSecurityQuestion;
import com.gooagoo.entity.generator.user.UserSecurityQuestionExample;
import com.gooagoo.entity.generator.user.UserSecurityQuestionKey;

public interface UserSecurityQuestionMapper
{

    public Integer countByExample(UserSecurityQuestionExample userSecurityQuestionExample);

    public List<UserSecurityQuestion> selectByExample(UserSecurityQuestionExample userSecurityQuestionExample);

    public UserSecurityQuestion selectByPrimaryKey(UserSecurityQuestionKey userSecurityQuestionKey);

}
