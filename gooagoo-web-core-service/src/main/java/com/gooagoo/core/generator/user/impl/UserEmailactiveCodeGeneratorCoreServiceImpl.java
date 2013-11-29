package com.gooagoo.core.generator.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.user.UserEmailactiveCodeGeneratorCoreService;
import com.gooagoo.entity.generator.user.UserEmailactiveCode;
import com.gooagoo.entity.generator.user.UserEmailactiveCodeExample;
import com.gooagoo.entity.generator.user.UserEmailactiveCodeKey;
import com.gooagoo.dao.generator.user.UserEmailactiveCodeMapper;

@Service
public class UserEmailactiveCodeGeneratorCoreServiceImpl implements UserEmailactiveCodeGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(UserEmailactiveCodeExample userEmailactiveCodeExample) 
    {
        return this.userEmailactiveCodeMapper.deleteByExample(userEmailactiveCodeExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        UserEmailactiveCodeKey userEmailactiveCodeKey = new UserEmailactiveCodeKey();
        userEmailactiveCodeKey.setId(primaryKey);
        return this.userEmailactiveCodeMapper.deleteByPrimaryKey(userEmailactiveCodeKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(UserEmailactiveCodeExample userEmailactiveCodeExample) 
    {
        UserEmailactiveCode userEmailactiveCode = new UserEmailactiveCode();
        userEmailactiveCode.setIsDel("Y");
        return this.userEmailactiveCodeMapper.updateByExampleSelective(userEmailactiveCode,userEmailactiveCodeExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        UserEmailactiveCode userEmailactiveCode = new UserEmailactiveCode();
        userEmailactiveCode.setId(primaryKey);
        userEmailactiveCode.setIsDel("Y");
        return this.userEmailactiveCodeMapper.updateByPrimaryKeySelective(userEmailactiveCode) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(UserEmailactiveCode userEmailactiveCode) 
    {
        return this.userEmailactiveCodeMapper.insertSelective(userEmailactiveCode) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(UserEmailactiveCode userEmailactiveCode,UserEmailactiveCodeExample userEmailactiveCodeExample) 
    {
        return this.userEmailactiveCodeMapper.updateByExampleSelective(userEmailactiveCode,userEmailactiveCodeExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(UserEmailactiveCode userEmailactiveCode) 
    {
        return this.userEmailactiveCodeMapper.updateByPrimaryKeySelective(userEmailactiveCode) > 0 ? true : false;
    }

}
