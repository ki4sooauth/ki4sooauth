package com.gooagoo.query.generator.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.user.UserEmailactiveCodeGeneratorQueryService;
import com.gooagoo.entity.generator.user.UserEmailactiveCode;
import com.gooagoo.entity.generator.user.UserEmailactiveCodeExample;
import com.gooagoo.entity.generator.user.UserEmailactiveCodeKey;
import com.gooagoo.dao.generator.user.UserEmailactiveCodeMapper;

@Service
public class UserEmailactiveCodeGeneratorQueryServiceImpl implements UserEmailactiveCodeGeneratorQueryService
{

    @Autowired
    private UserEmailactiveCodeMapper userEmailactiveCodeMapper;

    @Override
    public Integer countByExample(UserEmailactiveCodeExample userEmailactiveCodeExample) 
    {
        return this.userEmailactiveCodeMapper.countByExample(userEmailactiveCodeExample);
    }

    @Override
    public List<UserEmailactiveCode> selectByExample(UserEmailactiveCodeExample userEmailactiveCodeExample) 
    {
        return this.userEmailactiveCodeMapper.selectByExample(userEmailactiveCodeExample);
    }

    @Override
    public UserEmailactiveCode selectUnDelByPrimaryKey(String primaryKey) 
    {
        UserEmailactiveCodeKey userEmailactiveCodeKey = new UserEmailactiveCodeKey();
        userEmailactiveCodeKey.setIsDel("N");
        userEmailactiveCodeKey.setId(primaryKey);
        return this.userEmailactiveCodeMapper.selectByPrimaryKey(userEmailactiveCodeKey);
    }

    @Override
    public UserEmailactiveCode selectByPrimaryKey(String primaryKey) 
    {
        UserEmailactiveCodeKey userEmailactiveCodeKey = new UserEmailactiveCodeKey();
        userEmailactiveCodeKey.setId(primaryKey);
        return this.userEmailactiveCodeMapper.selectByPrimaryKey(userEmailactiveCodeKey);
    }

}
