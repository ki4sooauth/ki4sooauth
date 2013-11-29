package com.gooagoo.core.generator.behave.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.behave.UserFeedbackGeneratorCoreService;
import com.gooagoo.entity.generator.behave.UserFeedback;
import com.gooagoo.entity.generator.behave.UserFeedbackExample;
import com.gooagoo.entity.generator.behave.UserFeedbackKey;
import com.gooagoo.dao.generator.behave.UserFeedbackMapper;

@Service
public class UserFeedbackGeneratorCoreServiceImpl implements UserFeedbackGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(UserFeedbackExample userFeedbackExample) 
    {
        return this.userFeedbackMapper.deleteByExample(userFeedbackExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        UserFeedbackKey userFeedbackKey = new UserFeedbackKey();
        userFeedbackKey.setFeedbackId(primaryKey);
        return this.userFeedbackMapper.deleteByPrimaryKey(userFeedbackKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(UserFeedbackExample userFeedbackExample) 
    {
        UserFeedback userFeedback = new UserFeedback();
        userFeedback.setIsDel("Y");
        return this.userFeedbackMapper.updateByExampleSelective(userFeedback,userFeedbackExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        UserFeedback userFeedback = new UserFeedback();
        userFeedback.setFeedbackId(primaryKey);
        userFeedback.setIsDel("Y");
        return this.userFeedbackMapper.updateByPrimaryKeySelective(userFeedback) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(UserFeedback userFeedback) 
    {
        return this.userFeedbackMapper.insertSelective(userFeedback) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(UserFeedback userFeedback,UserFeedbackExample userFeedbackExample) 
    {
        return this.userFeedbackMapper.updateByExampleSelective(userFeedback,userFeedbackExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(UserFeedback userFeedback) 
    {
        return this.userFeedbackMapper.updateByPrimaryKeySelective(userFeedback) > 0 ? true : false;
    }

}
