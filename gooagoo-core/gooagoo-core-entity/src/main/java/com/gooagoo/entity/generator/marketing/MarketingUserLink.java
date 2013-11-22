package com.gooagoo.entity.generator.marketing;

import java.io.Serializable;
import java.util.Date;

/**
 * 营销内容与用户关联表
 */

public class MarketingUserLink implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//自动编号，UUID

    private String marketingType;//营销类型，参考通用字典表的rule_type

    private String marketingId;//营销内容编号，吆喝编号、通知编号等

    private String shopId;//商家编号

    private String accountType;//用户帐号类型（userid、phyno、mac）

    private String account;//用户帐号

    private String activityId;//所属活动编号

    private String isPushed;//是否已推送，Y-已推送，N-未推送

    private Date pushTime;//推送时间

    private String isRead;//是否已读，Y-已读，N-未读

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

    public String getMarketingType()
    {
        return this.marketingType;
    }

    public void setMarketingType(String marketingType)
    {
        this.marketingType = marketingType;
    }

    public String getMarketingId()
    {
        return this.marketingId;
    }

    public void setMarketingId(String marketingId)
    {
        this.marketingId = marketingId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getAccountType()
    {
        return this.accountType;
    }

    public void setAccountType(String accountType)
    {
        this.accountType = accountType;
    }

    public String getAccount()
    {
        return this.account;
    }

    public void setAccount(String account)
    {
        this.account = account;
    }

    public String getActivityId()
    {
        return this.activityId;
    }

    public void setActivityId(String activityId)
    {
        this.activityId = activityId;
    }

    public String getIsPushed()
    {
        return this.isPushed;
    }

    public void setIsPushed(String isPushed)
    {
        this.isPushed = isPushed;
    }

    public Date getPushTime()
    {
        return this.pushTime;
    }

    public void setPushTime(Date pushTime)
    {
        this.pushTime = pushTime;
    }

    public String getIsRead()
    {
        return this.isRead;
    }

    public void setIsRead(String isRead)
    {
        this.isRead = isRead;
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
        return this.id + "^" + this.marketingType + "^" + this.marketingId + "^" + this.shopId + "^" + this.accountType + "^" + this.account + "^" + this.activityId + "^" + this.isPushed + "^" + this.pushTime + "^" + this.isRead + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
