package com.gooagoo.dao.generator.behave;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.behave.UserStoreQueue;
import com.gooagoo.entity.generator.behave.UserStoreQueueExample;
import com.gooagoo.entity.generator.behave.UserStoreQueueKey;

public interface UserStoreQueueMapper
{

    public Integer countByExample(UserStoreQueueExample userStoreQueueExample);

    public List<UserStoreQueue> selectByExample(UserStoreQueueExample userStoreQueueExample);

    public UserStoreQueue selectByPrimaryKey(UserStoreQueueKey userStoreQueueKey);

    public Integer deleteByExample(UserStoreQueueExample userStoreQueueExample);

    public Integer deleteByPrimaryKey(UserStoreQueueKey userStoreQueueKey);

    public Integer insertSelective(UserStoreQueue userStoreQueue);

    public Integer updateAllByExample(@Param("record") UserStoreQueue userStoreQueue, @Param("example") UserStoreQueueExample userStoreQueueExample);

    public Integer updateByExampleSelective(@Param("record") UserStoreQueue userStoreQueue, @Param("example") UserStoreQueueExample userStoreQueueExample);

    public Integer updateByPrimaryKeySelective(UserStoreQueue userStoreQueue);

}
