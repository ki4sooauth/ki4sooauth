package com.gooagoo.query.generator.behave.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.behave.UserFeedbackGeneratorQueryService;
import com.gooagoo.entity.generator.behave.UserFeedback;
import com.gooagoo.entity.generator.behave.UserFeedbackExample;
import com.gooagoo.entity.generator.behave.UserFeedbackKey;
import com.gooagoo.dao.generator.behave.UserFeedbackMapper;

@Service
public class UserFeedbackGeneratorQueryServiceImpl implements UserFeedbackGeneratorQueryService
{

    @Autowired
    private UserFeedbackMapper userFeedbackMapper;

    @Override
    public Integer countByExample(UserFeedbackExample userFeedbackExample) 
    {
        return this.userFeedbackMapper.countByExample(userFeedbackExample);
    }

    @Override
    public List<UserFeedback> selectByExample(UserFeedbackExample userFeedbackExample) 
    {
        return this.userFeedbackMapper.selectByExample(userFeedbackExample);
    }

    @Override
    public UserFeedback selectUnDelByPrimaryKey(String primaryKey) 
    {
        UserFeedbackKey userFeedbackKey = new UserFeedbackKey();
        userFeedbackKey.setIsDel("N");
        userFeedbackKey.setFeedbackId(primaryKey);
        return this.userFeedbackMapper.selectByPrimaryKey(userFeedbackKey);
    }

    @Override
    public UserFeedback selectByPrimaryKey(String primaryKey) 
    {
        UserFeedbackKey userFeedbackKey = new UserFeedbackKey();
        userFeedbackKey.setFeedbackId(primaryKey);
        return this.userFeedbackMapper.selectByPrimaryKey(userFeedbackKey);
    }

}
