package com.gooagoo.entity.generator.marketing;

import java.io.Serializable;
import java.util.Date;

/**
 * 吆喝信息表
 */

public class CryoutInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String cryoutInfoId;//吆喝编号，UUID

    private String shopId;//商家编号

    private String activityId;//活动编号

    private String cryoutTitle;//吆喝标题

    private String cryoutType;//吆喝类型，参考通用字典表的cryout_type

    private String marketingLinkType;//营销内容关联类型，参考通用字典表的marketing_link_type

    private String marketingLinkId;//营销内容关联编号，如关联的是商品，此字段保存的是商品的编号，其他类型依次类推

    private String cryoutTextMobile;//具体内容（手机）

    private String cryoutTextWeb;//具体内容（网站）

    private String img;//关联图片，仅限一张

    private String publishStatus;//状态（审核与发布），参考通用字典表的publish_status

    private String auditNote;//审核备注

    private String ruleId;//发布规则编号

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getCryoutInfoId()
    {
        return this.cryoutInfoId;
    }

    public void setCryoutInfoId(String cryoutInfoId)
    {
        this.cryoutInfoId = cryoutInfoId;
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

    public String getCryoutTitle()
    {
        return this.cryoutTitle;
    }

    public void setCryoutTitle(String cryoutTitle)
    {
        this.cryoutTitle = cryoutTitle;
    }

    public String getCryoutType()
    {
        return this.cryoutType;
    }

    public void setCryoutType(String cryoutType)
    {
        this.cryoutType = cryoutType;
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

    public String getCryoutTextMobile()
    {
        return this.cryoutTextMobile;
    }

    public void setCryoutTextMobile(String cryoutTextMobile)
    {
        this.cryoutTextMobile = cryoutTextMobile;
    }

    public String getCryoutTextWeb()
    {
        return this.cryoutTextWeb;
    }

    public void setCryoutTextWeb(String cryoutTextWeb)
    {
        this.cryoutTextWeb = cryoutTextWeb;
    }

    public String getImg()
    {
        return this.img;
    }

    public void setImg(String img)
    {
        this.img = img;
    }

    public String getPublishStatus()
    {
        return this.publishStatus;
    }

    public void setPublishStatus(String publishStatus)
    {
        this.publishStatus = publishStatus;
    }

    public String getAuditNote()
    {
        return this.auditNote;
    }

    public void setAuditNote(String auditNote)
    {
        this.auditNote = auditNote;
    }

    public String getRuleId()
    {
        return this.ruleId;
    }

    public void setRuleId(String ruleId)
    {
        this.ruleId = ruleId;
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
        return this.cryoutInfoId + "^" + this.shopId + "^" + this.activityId + "^" + this.cryoutTitle + "^" + this.cryoutType + "^" + this.marketingLinkType + "^" + this.marketingLinkId + "^" + this.cryoutTextMobile + "^" + this.cryoutTextWeb + "^" + this.img + "^" + this.publishStatus + "^" + this.auditNote + "^" + this.ruleId + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
