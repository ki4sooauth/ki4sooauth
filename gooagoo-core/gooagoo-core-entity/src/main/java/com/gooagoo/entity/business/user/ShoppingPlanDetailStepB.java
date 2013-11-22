package com.gooagoo.entity.business.user;

import java.io.Serializable;
import java.util.List;

import com.gooagoo.entity.generator.behave.ShoppingPlanGoods;
import com.gooagoo.entity.generator.behave.UserShoppingPlan;

/**
 * 购物清单详细信息
 */
public class ShoppingPlanDetailStepB implements Serializable
{
    private static final long serialVersionUID = 1L;

    private UserShoppingPlan userShoppingPlan;//购物清单主表

    private List<ShoppingPlanGoods> shoppingPlanGoodsList;//购物清单商品表

    public UserShoppingPlan getUserShoppingPlan()
    {
        return this.userShoppingPlan;
    }

    public void setUserShoppingPlan(UserShoppingPlan userShoppingPlan)
    {
        this.userShoppingPlan = userShoppingPlan;
    }

    public List<ShoppingPlanGoods> getShoppingPlanGoodsList()
    {
        return this.shoppingPlanGoodsList;
    }

    public void setShoppingPlanGoodsList(List<ShoppingPlanGoods> shoppingPlanGoodsList)
    {
        this.shoppingPlanGoodsList = shoppingPlanGoodsList;
    }

    @Override
    public String toString()
    {
        return "ShoppingPlanDetail [userShoppingPlan=" + this.userShoppingPlan.toString() + ", shoppingPlanGoodsList=" + this.shoppingPlanGoodsList.toString() + "]";
    }

}
