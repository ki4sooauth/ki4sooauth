package com.gooagoo.entity.generator.marketing;

import java.io.Serializable;
import java.util.Date;

/**
 * 营销内容与商品、活动、优惠凭证关联表
 */

public class MarketingItemLink implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//自动编号，UUID

    private String marketingType;//营销类型，参考通用字典表的rule_type

    private String marketingId;//营销内容编号，吆喝编号、通知编号等

    private String shopId;//商家编号

    private String activityId;//所属活动编号

    private String marketingLinkType;//营销内容关联类型，参考通用字典表的marketing_link_type

    private String marketingLinkId;//营销内容关联编号，如关联的是商品，此字段保存的是商品的编号，其他类型依次类推

    private Integer sort;//排列顺序

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

    public String getActivityId()
    {
        return this.activityId;
    }

    public void setActivityId(String activityId)
    {
        this.activityId = activityId;
    }

    public String getMarketingLinkType()
    {
        return this.marketingLinkType;
    }

    public void setMarketingLinkType(String marketingLinkType)
    {
        this.marketingLinkType = marketingLinkType;
    }

    public String getMarketingLinkId()
    {
        return this.marketingLinkId;
    }

    public void setMarketingLinkId(String marketingLinkId)
    {
        this.marketingLinkId = marketingLinkId;
    }

    public Integer getSort()
    {
        return this.sort;
    }

    public void setSort(Integer sort)
    {
        this.sort = sort;
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
        return this.id + "^" + this.marketingType + "^" + this.marketingId + "^" + this.shopId + "^" + this.activityId + "^" + this.marketingLinkType + "^" + this.marketingLinkId + "^" + this.sort + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
