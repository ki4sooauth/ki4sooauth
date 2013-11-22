package com.gooagoo.dao.generator.behave;

import java.util.List;

import com.gooagoo.entity.generator.behave.UserStoreQueue;
import com.gooagoo.entity.generator.behave.UserStoreQueueExample;
import com.gooagoo.entity.generator.behave.UserStoreQueueKey;

public interface UserStoreQueueMapper
{

    public Integer countByExample(UserStoreQueueExample userStoreQueueExample);

    public List<UserStoreQueue> selectByExample(UserStoreQueueExample userStoreQueueExample);

    public UserStoreQueue selectByPrimaryKey(UserStoreQueueKey userStoreQueueKey);

}
