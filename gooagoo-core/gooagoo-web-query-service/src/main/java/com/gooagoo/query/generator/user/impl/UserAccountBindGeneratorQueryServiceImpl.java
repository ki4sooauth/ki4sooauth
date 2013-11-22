package com.gooagoo.query.generator.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.user.UserAccountBindGeneratorQueryService;
import com.gooagoo.entity.generator.user.UserAccountBind;
import com.gooagoo.entity.generator.user.UserAccountBindExample;
import com.gooagoo.entity.generator.user.UserAccountBindKey;
import com.gooagoo.dao.generator.user.UserAccountBindMapper;

@Service
public class UserAccountBindGeneratorQueryServiceImpl implements UserAccountBindGeneratorQueryService
{

    @Autowired
    private UserAccountBindMapper userAccountBindMapper;

    @Override
    public Integer countByExample(UserAccountBindExample userAccountBindExample) 
    {
        return this.userAccountBindMapper.countByExample(userAccountBindExample);
    }

    @Override
    public List<UserAccountBind> selectByExample(UserAccountBindExample userAccountBindExample) 
    {
        return this.userAccountBindMapper.selectByExample(userAccountBindExample);
    }

    @Override
    public UserAccountBind selectUnDelByPrimaryKey(String primaryKey) 
    {
        UserAccountBindKey userAccountBindKey = new UserAccountBindKey();
        userAccountBindKey.setIsDel("N");
        userAccountBindKey.setId(primaryKey);
        return this.userAccountBindMapper.selectByPrimaryKey(userAccountBindKey);
    }

    @Override
    public UserAccountBind selectByPrimaryKey(String primaryKey) 
    {
        UserAccountBindKey userAccountBindKey = new UserAccountBindKey();
        userAccountBindKey.setId(primaryKey);
        return this.userAccountBindMapper.selectByPrimaryKey(userAccountBindKey);
    }

}
