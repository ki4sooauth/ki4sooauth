package com.gooagoo.query.generator.behave.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.behave.UserShoppingPlanGeneratorQueryService;
import com.gooagoo.entity.generator.behave.UserShoppingPlan;
import com.gooagoo.entity.generator.behave.UserShoppingPlanExample;
import com.gooagoo.entity.generator.behave.UserShoppingPlanKey;
import com.gooagoo.dao.generator.behave.UserShoppingPlanMapper;

@Service
public class UserShoppingPlanGeneratorQueryServiceImpl implements UserShoppingPlanGeneratorQueryService
{

    @Autowired
    private UserShoppingPlanMapper userShoppingPlanMapper;

    @Override
    public Integer countByExample(UserShoppingPlanExample userShoppingPlanExample) 
    {
        return this.userShoppingPlanMapper.countByExample(userShoppingPlanExample);
    }

    @Override
    public List<UserShoppingPlan> selectByExample(UserShoppingPlanExample userShoppingPlanExample) 
    {
        return this.userShoppingPlanMapper.selectByExample(userShoppingPlanExample);
    }

    @Override
    public UserShoppingPlan selectUnDelByPrimaryKey(String primaryKey) 
    {
        UserShoppingPlanKey userShoppingPlanKey = new UserShoppingPlanKey();
        userShoppingPlanKey.setIsDel("N");
        userShoppingPlanKey.setShoppingListId(primaryKey);
        return this.userShoppingPlanMapper.selectByPrimaryKey(userShoppingPlanKey);
    }

    @Override
    public UserShoppingPlan selectByPrimaryKey(String primaryKey) 
    {
        UserShoppingPlanKey userShoppingPlanKey = new UserShoppingPlanKey();
        userShoppingPlanKey.setShoppingListId(primaryKey);
        return this.userShoppingPlanMapper.selectByPrimaryKey(userShoppingPlanKey);
    }

}
