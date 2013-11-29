package com.gooagoo.core.business.user.behave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.user.behave.UserLastTimeCoreService;
import com.gooagoo.api.generator.core.behave.UserLastTimeGeneratorCoreService;
import com.gooagoo.entity.generator.behave.UserLastTime;
import com.gooagoo.entity.generator.behave.UserLastTimeExample;

@Service
public class UserLastTimeCoreServiceImpl implements UserLastTimeCoreService
{
    @Autowired
    private UserLastTimeGeneratorCoreService userLastTimeGeneratorCoreService;

    @Override
    public boolean physicalDeleteByExample(UserLastTimeExample userLastTimeExample)
    {
        return this.userLastTimeGeneratorCoreService.physicalDeleteByExample(userLastTimeExample);
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey)
    {
        return this.userLastTimeGeneratorCoreService.physicalDeleteByPrimaryKey(primaryKey);
    }

    @Override
    public boolean insertSelective(UserLastTime userLastTime)
    {
        return this.userLastTimeGeneratorCoreService.insertSelective(userLastTime);
    }

    @Override
    public boolean updateByExampleSelective(UserLastTime userLastTime, UserLastTimeExample userLastTimeExample)
    {
        return this.userLastTimeGeneratorCoreService.updateByExampleSelective(userLastTime, userLastTimeExample);
    }

    @Override
    public boolean updateByPrimaryKeySelective(UserLastTime userLastTime)
    {
        return this.userLastTimeGeneratorCoreService.updateByPrimaryKeySelective(userLastTime);
    }

}
