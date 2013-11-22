package com.gooagoo.query.generator.behave.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.behave.UserStoreQueueGeneratorQueryService;
import com.gooagoo.entity.generator.behave.UserStoreQueue;
import com.gooagoo.entity.generator.behave.UserStoreQueueExample;
import com.gooagoo.entity.generator.behave.UserStoreQueueKey;
import com.gooagoo.dao.generator.behave.UserStoreQueueMapper;

@Service
public class UserStoreQueueGeneratorQueryServiceImpl implements UserStoreQueueGeneratorQueryService
{

    @Autowired
    private UserStoreQueueMapper userStoreQueueMapper;

    @Override
    public Integer countByExample(UserStoreQueueExample userStoreQueueExample) 
    {
        return this.userStoreQueueMapper.countByExample(userStoreQueueExample);
    }

    @Override
    public List<UserStoreQueue> selectByExample(UserStoreQueueExample userStoreQueueExample) 
    {
        return this.userStoreQueueMapper.selectByExample(userStoreQueueExample);
    }

    @Override
    public UserStoreQueue selectUnDelByPrimaryKey(String primaryKey) 
    {
        UserStoreQueueKey userStoreQueueKey = new UserStoreQueueKey();
        userStoreQueueKey.setIsDel("N");
        userStoreQueueKey.setId(primaryKey);
        return this.userStoreQueueMapper.selectByPrimaryKey(userStoreQueueKey);
    }

    @Override
    public UserStoreQueue selectByPrimaryKey(String primaryKey) 
    {
        UserStoreQueueKey userStoreQueueKey = new UserStoreQueueKey();
        userStoreQueueKey.setId(primaryKey);
        return this.userStoreQueueMapper.selectByPrimaryKey(userStoreQueueKey);
    }

}
