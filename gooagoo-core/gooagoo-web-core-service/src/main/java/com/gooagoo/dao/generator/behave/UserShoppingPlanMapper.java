package com.gooagoo.dao.generator.behave;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.behave.UserShoppingPlan;
import com.gooagoo.entity.generator.behave.UserShoppingPlanExample;
import com.gooagoo.entity.generator.behave.UserShoppingPlanKey;

public interface UserShoppingPlanMapper
{

    public Integer countByExample(UserShoppingPlanExample userShoppingPlanExample);

    public List<UserShoppingPlan> selectByExample(UserShoppingPlanExample userShoppingPlanExample);

    public UserShoppingPlan selectByPrimaryKey(UserShoppingPlanKey userShoppingPlanKey);

    public Integer deleteByExample(UserShoppingPlanExample userShoppingPlanExample);

    public Integer deleteByPrimaryKey(UserShoppingPlanKey userShoppingPlanKey);

    public Integer insertSelective(UserShoppingPlan userShoppingPlan);

    public Integer updateAllByExample(@Param("record") UserShoppingPlan userShoppingPlan, @Param("example") UserShoppingPlanExample userShoppingPlanExample);

    public Integer updateByExampleSelective(@Param("record") UserShoppingPlan userShoppingPlan, @Param("example") UserShoppingPlanExample userShoppingPlanExample);

    public Integer updateByPrimaryKeySelective(UserShoppingPlan userShoppingPlan);

}
