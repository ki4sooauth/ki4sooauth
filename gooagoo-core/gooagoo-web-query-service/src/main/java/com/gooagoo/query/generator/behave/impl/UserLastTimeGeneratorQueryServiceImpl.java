package com.gooagoo.query.generator.behave.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.behave.UserLastTimeGeneratorQueryService;
import com.gooagoo.entity.generator.behave.UserLastTime;
import com.gooagoo.entity.generator.behave.UserLastTimeExample;
import com.gooagoo.entity.generator.behave.UserLastTimeKey;
import com.gooagoo.dao.generator.behave.UserLastTimeMapper;

@Service
public class UserLastTimeGeneratorQueryServiceImpl implements UserLastTimeGeneratorQueryService
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

}
