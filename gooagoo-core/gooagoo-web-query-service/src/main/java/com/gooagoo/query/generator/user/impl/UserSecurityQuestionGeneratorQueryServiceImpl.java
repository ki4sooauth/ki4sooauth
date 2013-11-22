package com.gooagoo.query.generator.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.user.UserSecurityQuestionGeneratorQueryService;
import com.gooagoo.entity.generator.user.UserSecurityQuestion;
import com.gooagoo.entity.generator.user.UserSecurityQuestionExample;
import com.gooagoo.entity.generator.user.UserSecurityQuestionKey;
import com.gooagoo.dao.generator.user.UserSecurityQuestionMapper;

@Service
public class UserSecurityQuestionGeneratorQueryServiceImpl implements UserSecurityQuestionGeneratorQueryService
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

}
