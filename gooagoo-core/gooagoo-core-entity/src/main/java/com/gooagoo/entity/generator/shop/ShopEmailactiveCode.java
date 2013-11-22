package com.gooagoo.entity.generator.shop;

import java.io.Serializable;
import java.util.Date;

/**
 * 邮箱激活码，仅在找回密码时使用
 */

public class ShopEmailactiveCode implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//编号，唯一，通过UUID产生

    private String shopId;//商家编号

    private Date expDate;//激活码过期时间，为创建时间的两天之内

    private String isActive;//是否激活：Y-已激活，N-未激活

    private Date activeDate;//激活时间

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public Date getExpDate()
    {
        return this.expDate;
    }

    public void setExpDate(Date expDate)
    {
        this.expDate = expDate;
    }

    public String getIsActive()
    {
        return this.isActive;
    }

    public void setIsActive(String isActive)
    {
        this.isActive = isActive;
    }

    public Date getActiveDate()
    {
        return this.activeDate;
    }

    public void setActiveDate(Date activeDate)
    {
        this.activeDate = activeDate;
    }

    public String getIsDel()
    {
        return this.isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getCTimeStamp()
    {
        return this.cTimeStamp;
    }

    public void setCTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    @Override
    public String toString()
    {
        return this.id + "^" + this.shopId + "^" + this.expDate + "^" + this.isActive + "^" + this.activeDate + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
