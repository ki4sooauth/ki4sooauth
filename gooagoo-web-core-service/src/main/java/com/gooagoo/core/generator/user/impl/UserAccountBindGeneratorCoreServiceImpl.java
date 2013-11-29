package com.gooagoo.core.generator.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.user.UserAccountBindGeneratorCoreService;
import com.gooagoo.entity.generator.user.UserAccountBind;
import com.gooagoo.entity.generator.user.UserAccountBindExample;
import com.gooagoo.entity.generator.user.UserAccountBindKey;
import com.gooagoo.dao.generator.user.UserAccountBindMapper;

@Service
public class UserAccountBindGeneratorCoreServiceImpl implements UserAccountBindGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(UserAccountBindExample userAccountBindExample) 
    {
        return this.userAccountBindMapper.deleteByExample(userAccountBindExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        UserAccountBindKey userAccountBindKey = new UserAccountBindKey();
        userAccountBindKey.setId(primaryKey);
        return this.userAccountBindMapper.deleteByPrimaryKey(userAccountBindKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(UserAccountBindExample userAccountBindExample) 
    {
        UserAccountBind userAccountBind = new UserAccountBind();
        userAccountBind.setIsDel("Y");
        return this.userAccountBindMapper.updateByExampleSelective(userAccountBind,userAccountBindExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        UserAccountBind userAccountBind = new UserAccountBind();
        userAccountBind.setId(primaryKey);
        userAccountBind.setIsDel("Y");
        return this.userAccountBindMapper.updateByPrimaryKeySelective(userAccountBind) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(UserAccountBind userAccountBind) 
    {
        return this.userAccountBindMapper.insertSelective(userAccountBind) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(UserAccountBind userAccountBind,UserAccountBindExample userAccountBindExample) 
    {
        return this.userAccountBindMapper.updateByExampleSelective(userAccountBind,userAccountBindExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(UserAccountBind userAccountBind) 
    {
        return this.userAccountBindMapper.updateByPrimaryKeySelective(userAccountBind) > 0 ? true : false;
    }

}
