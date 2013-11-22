package com.gooagoo.dao.generator.behave;

import java.util.List;

import com.gooagoo.entity.generator.behave.UserFeedback;
import com.gooagoo.entity.generator.behave.UserFeedbackExample;
import com.gooagoo.entity.generator.behave.UserFeedbackKey;

public interface UserFeedbackMapper
{

    public Integer countByExample(UserFeedbackExample userFeedbackExample);

    public List<UserFeedback> selectByExample(UserFeedbackExample userFeedbackExample);

    public UserFeedback selectByPrimaryKey(UserFeedbackKey userFeedbackKey);

}
