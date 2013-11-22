package com.gooagoo.dao.generator.behave;

import java.util.List;

import com.gooagoo.entity.generator.behave.UserShoppingPlan;
import com.gooagoo.entity.generator.behave.UserShoppingPlanExample;
import com.gooagoo.entity.generator.behave.UserShoppingPlanKey;

public interface UserShoppingPlanMapper
{

    public Integer countByExample(UserShoppingPlanExample userShoppingPlanExample);

    public List<UserShoppingPlan> selectByExample(UserShoppingPlanExample userShoppingPlanExample);

    public UserShoppingPlan selectByPrimaryKey(UserShoppingPlanKey userShoppingPlanKey);

}
