package com.gooagoo.entity.business.user;

import java.io.Serializable;
import java.util.List;

/**
 * 购物清单详细信息
 */
public class ShoppingPlanDetailStepA implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String mobilechange;

    private List<ShoppingPlanDetailStepB> shoppingPlanDetailStepBList;

    public String getMobilechange()
    {
        return this.mobilechange;
    }

    public void setMobilechange(String mobilechange)
    {
        this.mobilechange = mobilechange;
    }

    public List<ShoppingPlanDetailStepB> getShoppingPlanDetailStepBList()
    {
        return this.shoppingPlanDetailStepBList;
    }

    public void setShoppingPlanDetailStepBList(List<ShoppingPlanDetailStepB> shoppingPlanDetailStepBList)
    {
        this.shoppingPlanDetailStepBList = shoppingPlanDetailStepBList;
    }

    @Override
    public String toString()
    {
        return "ShoppingPlanDetailStepA [mobilechange=" + this.mobilechange + ", shoppingPlanDetailStepBList=" + this.shoppingPlanDetailStepBList.toString() + "]";
    }

}
