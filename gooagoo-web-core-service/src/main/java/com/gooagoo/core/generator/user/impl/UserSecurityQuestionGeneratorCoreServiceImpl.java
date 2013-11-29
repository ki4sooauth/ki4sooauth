package com.gooagoo.core.generator.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.user.UserSecurityQuestionGeneratorCoreService;
import com.gooagoo.entity.generator.user.UserSecurityQuestion;
import com.gooagoo.entity.generator.user.UserSecurityQuestionExample;
import com.gooagoo.entity.generator.user.UserSecurityQuestionKey;
import com.gooagoo.dao.generator.user.UserSecurityQuestionMapper;

@Service
public class UserSecurityQuestionGeneratorCoreServiceImpl implements UserSecurityQuestionGeneratorCoreService
{

    @Autowired
    private UserSecurityQuestionMapper userSecurityQuestionMapper;

    @Override
    public Integer countByExample(UserSecurityQuestionExample userSecurityQuestionExample) 
    {
        return this.userSecurityQuestionMapper.countByExample(userSecurityQuestionExample);
    }

    @Override
    public List<UserSecurityQuestion> selectByExample(UserSecurityQuestionExample userSecurityQuestionExample) 
    {
        return this.userSecurityQuestionMapper.selectByExample(userSecurityQuestionExample);
    }

    @Override
    public UserSecurityQuestion selectUnDelByPrimaryKey(String primaryKey) 
    {
        UserSecurityQuestionKey userSecurityQuestionKey = new UserSecurityQuestionKey();
        userSecurityQuestionKey.setIsDel("N");
        userSecurityQuestionKey.setId(primaryKey);
        return this.userSecurityQuestionMapper.selectByPrimaryKey(userSecurityQuestionKey);
    }

    @Override
    public UserSecurityQuestion selectByPrimaryKey(String primaryKey) 
    {
        UserSecurityQuestionKey userSecurityQuestionKey = new UserSecurityQuestionKey();
        userSecurityQuestionKey.setId(primaryKey);
        return this.userSecurityQuestionMapper.selectByPrimaryKey(userSecurityQuestionKey);
    }

    @Override
    public boolean physicalDeleteByExample(UserSecurityQuestionExample userSecurityQuestionExample) 
    {
        return this.userSecurityQuestionMapper.deleteByExample(userSecurityQuestionExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        UserSecurityQuestionKey userSecurityQuestionKey = new UserSecurityQuestionKey();
        userSecurityQuestionKey.setId(primaryKey);
        return this.userSecurityQuestionMapper.deleteByPrimaryKey(userSecurityQuestionKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(UserSecurityQuestionExample userSecurityQuestionExample) 
    {
        UserSecurityQuestion userSecurityQuestion = new UserSecurityQuestion();
        userSecurityQuestion.setIsDel("Y");
        return this.userSecurityQuestionMapper.updateByExampleSelective(userSecurityQuestion,userSecurityQuestionExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        UserSecurityQuestion userSecurityQuestion = new UserSecurityQuestion();
        userSecurityQuestion.setId(primaryKey);
        userSecurityQuestion.setIsDel("Y");
        return this.userSecurityQuestionMapper.updateByPrimaryKeySelective(userSecurityQuestion) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(UserSecurityQuestion userSecurityQuestion) 
    {
        return this.userSecurityQuestionMapper.insertSelective(userSecurityQuestion) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(UserSecurityQuestion userSecurityQuestion,UserSecurityQuestionExample userSecurityQuestionExample) 
    {
        return this.userSecurityQuestionMapper.updateByExampleSelective(userSecurityQuestion,userSecurityQuestionExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(UserSecurityQuestion userSecurityQuestion) 
    {
        return this.userSecurityQuestionMapper.updateByPrimaryKeySelective(userSecurityQuestion) > 0 ? true : false;
    }

}
