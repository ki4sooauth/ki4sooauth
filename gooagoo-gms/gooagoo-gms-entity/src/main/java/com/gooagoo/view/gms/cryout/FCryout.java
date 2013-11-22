package com.gooagoo.view.gms.cryout;

import java.io.Serializable;
import java.util.Date;

/**
 * 吆喝信息
 * 
 */
public class FCryout implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String cryoutInfoId;//吆喝编号，UUID

    private String shopId;//商家编号

    private String activityId;//活动编号

    private String activityName;//活动名称

    private Date activeStartTime;//活动开始时间

    private Date activeEndTime;//活动结束时间

    private String cryoutTitle;//吆喝标题

    private String cryoutType;//吆喝类型，参考通用字典表的cryout_type

    private String marketingLinkType;//营销内容关联类型，参考通用字典表的marketing_link_type

    private String marketingLinkId;//营销内容关联编号，如关联的是商品，此字段保存的是商品的编号，其他类型依次类推

    private String cryoutTextMobile;//具体内容（手机）//<a href='#localcmd:type=voucher|id=|shopid=|url='>名称</a>

    private String cryoutTextWeb;//具体内容（网站）

    private String img;//关联图片，仅限一张

    private String publishStatus;//状态（审核与发布），参考通用字典表的publish_status

    private String note;//审核备注

    private String ruleId;//发布规则编号

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getCryoutInfoId()
    {
        return this.cryoutInfoId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public String getActivityId()
    {
        return this.activityId;
    }

    public String getCryoutTitle()
    {
        return this.cryoutTitle;
    }

    public String getCryoutType()
    {
        return this.cryoutType;
    }

    public String getActivityName()
    {
        return activityName;
    }

    public void setActivityName(String activityName)
    {
        this.activityName = activityName;
    }

    public Date getActiveStartTime()
    {
        return activeStartTime;
    }

    public void setActiveStartTime(Date activeStartTime)
    {
        this.activeStartTime = activeStartTime;
    }

    public Date getActiveEndTime()
    {
        return activeEndTime;
    }

    public void setActiveEndTime(Date activeEndTime)
    {
        this.activeEndTime = activeEndTime;
    }

    public String getMarketingLinkType()
    {
        return this.marketingLinkType;
    }

    public String getMarketingLinkId()
    {
        return this.marketingLinkId;
    }

    public String getCryoutTextMobile()
    {
        return this.cryoutTextMobile;
    }

    public String getCryoutTextWeb()
    {
        return this.cryoutTextWeb;
    }

    public String getImg()
    {
        return this.img;
    }

    public String getPublishStatus()
    {
        return this.publishStatus;
    }

    public String getNote()
    {
        return this.note;
    }

    public String getRuleId()
    {
        return this.ruleId;
    }

    public String getIsDel()
    {
        return this.isDel;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public Date getcTimeStamp()
    {
        return this.cTimeStamp;
    }

    public void setCryoutInfoId(String cryoutInfoId)
    {
        this.cryoutInfoId = cryoutInfoId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public void setActivityId(String activityId)
    {
        this.activityId = activityId;
    }

    public void setCryoutTitle(String cryoutTitle)
    {
        this.cryoutTitle = cryoutTitle;
    }

    public void setCryoutType(String cryoutType)
    {
        this.cryoutType = cryoutType;
    }

    public void setMarketingLinkType(String marketingLinkType)
    {
        this.marketingLinkType = marketingLinkType;
    }

    public void setMarketingLinkId(String marketingLinkId)
    {
        this.marketingLinkId = marketingLinkId;
    }

    public void setCryoutTextMobile(String cryoutTextMobile)
    {
        this.cryoutTextMobile = cryoutTextMobile;
    }

    public void setCryoutTextWeb(String cryoutTextWeb)
    {
        this.cryoutTextWeb = cryoutTextWeb;
    }

    public void setImg(String img)
    {
        this.img = img;
    }

    public void setPublishStatus(String publishStatus)
    {
        this.publishStatus = publishStatus;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public void setRuleId(String ruleId)
    {
        this.ruleId = ruleId;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public void setcTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

}
