package com.gooagoo.core.generator.behave.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.core.behave.UserShoppingPlanGeneratorCoreService;
import com.gooagoo.entity.generator.behave.UserShoppingPlan;
import com.gooagoo.entity.generator.behave.UserShoppingPlanExample;
import com.gooagoo.entity.generator.behave.UserShoppingPlanKey;
import com.gooagoo.dao.generator.behave.UserShoppingPlanMapper;

@Service
public class UserShoppingPlanGeneratorCoreServiceImpl implements UserShoppingPlanGeneratorCoreService
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

    @Override
    public boolean physicalDeleteByExample(UserShoppingPlanExample userShoppingPlanExample) 
    {
        return this.userShoppingPlanMapper.deleteByExample(userShoppingPlanExample) > 0 ? true : false;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey) 
    {
        UserShoppingPlanKey userShoppingPlanKey = new UserShoppingPlanKey();
        userShoppingPlanKey.setShoppingListId(primaryKey);
        return this.userShoppingPlanMapper.deleteByPrimaryKey(userShoppingPlanKey) > 0 ? true : false;
    }

    @Override
    public boolean deleteByExample(UserShoppingPlanExample userShoppingPlanExample) 
    {
        UserShoppingPlan userShoppingPlan = new UserShoppingPlan();
        userShoppingPlan.setIsDel("Y");
        return this.userShoppingPlanMapper.updateByExampleSelective(userShoppingPlan,userShoppingPlanExample) > 0 ? true : false;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey) 
    {
        UserShoppingPlan userShoppingPlan = new UserShoppingPlan();
        userShoppingPlan.setShoppingListId(primaryKey);
        userShoppingPlan.setIsDel("Y");
        return this.userShoppingPlanMapper.updateByPrimaryKeySelective(userShoppingPlan) > 0 ? true : false;
    }

    @Override
    public boolean insertSelective(UserShoppingPlan userShoppingPlan) 
    {
        return this.userShoppingPlanMapper.insertSelective(userShoppingPlan) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(UserShoppingPlan userShoppingPlan,UserShoppingPlanExample userShoppingPlanExample) 
    {
        return this.userShoppingPlanMapper.updateByExampleSelective(userShoppingPlan,userShoppingPlanExample) > 0 ? true : false;
    }

    @Override
    public boolean updateByPrimaryKeySelective(UserShoppingPlan userShoppingPlan) 
    {
        return this.userShoppingPlanMapper.updateByPrimaryKeySelective(userShoppingPlan) > 0 ? true : false;
    }

}
