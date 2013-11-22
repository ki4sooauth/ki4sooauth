package com.gooagoo.entity.business.user.shoppingplan;

import java.io.Serializable;

public class ShoppingplanInfoBusiness implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**  数据状态标识，A-手机端新增数据、M-手机端数据是新的（包括修改和删除）、S-服务器端数据是新的（包括修改和删除）、E-手机端和服务器端数据时一样的  */
    private String flag;

    /**  当flag为A(手机端新增数据)时,此节点会返回，其它情况不返回  */
    private String newshoppinglistid;

    /**  购物计划  */
    private ShoppingplanBusiness shoppingplanBusiness;

    public String getFlag()
    {
        return this.flag;
    }

    public void setFlag(String flag)
    {
        this.flag = flag;
    }

    public String getNewshoppinglistid()
    {
        return this.newshoppinglistid;
    }

    public void setNewshoppinglistid(String newshoppinglistid)
    {
        this.newshoppinglistid = newshoppinglistid;
    }

    public ShoppingplanBusiness getShoppingplanBusiness()
    {
        return this.shoppingplanBusiness;
    }

    public void setShoppingplanBusiness(ShoppingplanBusiness shoppingplanBusiness)
    {
        this.shoppingplanBusiness = shoppingplanBusiness;
    }

    @Override
    public String toString()
    {
        return "ShoppingplanInfoBusiness [flag=" + this.flag + ", newshoppinglistid=" + this.newshoppinglistid + ", shoppingplanBusiness=" + this.shoppingplanBusiness + "]";
    }

}
