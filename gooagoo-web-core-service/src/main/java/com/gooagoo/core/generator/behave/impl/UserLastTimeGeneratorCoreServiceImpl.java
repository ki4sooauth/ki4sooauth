package com.gooagoo.core.generator.behave.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.behave.UserLastTimeGeneratorCoreService;
import com.gooagoo.entity.generator.behave.UserLastTime;
import com.gooagoo.entity.generator.behave.UserLastTimeExample;
import com.gooagoo.entity.generator.behave.UserLastTimeKey;
import com.gooagoo.dao.generator.behave.UserLastTimeMapper;

@Service
public class UserLastTimeGeneratorCoreServiceImpl implements UserLastTimeGeneratorCoreService
{

    @Autowired
    private UserLastTimeMapper userLastTimeMapper;

    @Override
    public Integer countByExample(UserLastTimeExample userLastTimeExample) 
    {
        return this.userLastTimeMapper.countByExample(userLastTimeExample);
    }

    @Override
    public List<UserLastTime> selectByExample(UserLastTimeExample userLastTimeExample) 
    {
        return this.userLastTimeMapper.selectByExample(userLastTimeExample);
    }

    @Override
    public UserLastTime selectByPrimaryKey(String primaryKey) 
    {
        UserLastTimeKey userLastTimeKey = new UserLastTimeKey();
        userLastTimeKey.setId(primaryKey);
        return this.userLastTimeMapper.selectByPrimaryKey(userLastTimeKey);
    }

    @Override
    public boolean physicalDeleteByExample(UserLastTimeExample userLastTimeExample) 
    {
        return this.userLastTimeMapper.deleteByExample(userLastTimeExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        UserLastTimeKey userLastTimeKey = new UserLastTimeKey();
        userLastTimeKey.setId(primaryKey);
        return this.userLastTimeMapper.deleteByPrimaryKey(userLastTimeKey) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(UserLastTime userLastTime) 
    {
        return this.userLastTimeMapper.insertSelective(userLastTime) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(UserLastTime userLastTime,UserLastTimeExample userLastTimeExample) 
    {
        return this.userLastTimeMapper.updateByExampleSelective(userLastTime,userLastTimeExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(UserLastTime userLastTime) 
    {
        return this.userLastTimeMapper.updateByPrimaryKeySelective(userLastTime) > 0 ? true : false;
    }

}
