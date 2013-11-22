package com.gooagoo.core.generator.behave.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.behave.UserStoreQueueGeneratorCoreService;
import com.gooagoo.entity.generator.behave.UserStoreQueue;
import com.gooagoo.entity.generator.behave.UserStoreQueueExample;
import com.gooagoo.entity.generator.behave.UserStoreQueueKey;
import com.gooagoo.dao.generator.behave.UserStoreQueueMapper;

@Service
public class UserStoreQueueGeneratorCoreServiceImpl implements UserStoreQueueGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(UserStoreQueueExample userStoreQueueExample) 
    {
        return this.userStoreQueueMapper.deleteByExample(userStoreQueueExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        UserStoreQueueKey userStoreQueueKey = new UserStoreQueueKey();
        userStoreQueueKey.setId(primaryKey);
        return this.userStoreQueueMapper.deleteByPrimaryKey(userStoreQueueKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(UserStoreQueueExample userStoreQueueExample) 
    {
        UserStoreQueue userStoreQueue = new UserStoreQueue();
        userStoreQueue.setIsDel("Y");
        return this.userStoreQueueMapper.updateByExampleSelective(userStoreQueue,userStoreQueueExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        UserStoreQueue userStoreQueue = new UserStoreQueue();
        userStoreQueue.setId(primaryKey);
        userStoreQueue.setIsDel("Y");
        return this.userStoreQueueMapper.updateByPrimaryKeySelective(userStoreQueue) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(UserStoreQueue userStoreQueue) 
    {
        return this.userStoreQueueMapper.insertSelective(userStoreQueue) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(UserStoreQueue userStoreQueue,UserStoreQueueExample userStoreQueueExample) 
    {
        return this.userStoreQueueMapper.updateByExampleSelective(userStoreQueue,userStoreQueueExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(UserStoreQueue userStoreQueue) 
    {
        return this.userStoreQueueMapper.updateByPrimaryKeySelective(userStoreQueue) > 0 ? true : false;
    }

}
