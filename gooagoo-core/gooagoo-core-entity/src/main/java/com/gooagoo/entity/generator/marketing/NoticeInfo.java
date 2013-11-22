package com.gooagoo.entity.generator.marketing;

import java.io.Serializable;
import java.util.Date;

/**
 * 商家通知信息表
 */

public class NoticeInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String noticeInfoId;//通知编号，UUID

    private String shopId;//商家编号

    private String activityId;//活动编号

    private String noticeTitle;//通知标题

    private String marketingLinkType;//营销内容关联类型，参考通用字典表的marketing_link_type

    private String marketingLinkId;//营销内容关联编号，如关联的是商品，此字段保存的是商品的编号，其他类型依次类推

    private String noticeTextMobile;//具体内容（手机）

    private String noticeTextWeb;//具体内容（网站）

    private String img;//关联图片，仅限一张

    private String publishStatus;//状态（审核与发布），参考通用字典表的publish_status

    private String auditNote;//审核备注

    private String ruleId;//发布规则编号

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getNoticeInfoId()
    {
        return this.noticeInfoId;
    }

    public void setNoticeInfoId(String noticeInfoId)
    {
        this.noticeInfoId = noticeInfoId;
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

    public String getNoticeTitle()
    {
        return this.noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle)
    {
        this.noticeTitle = noticeTitle;
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

    public String getNoticeTextMobile()
    {
        return this.noticeTextMobile;
    }

    public void setNoticeTextMobile(String noticeTextMobile)
    {
        this.noticeTextMobile = noticeTextMobile;
    }

    public String getNoticeTextWeb()
    {
        return this.noticeTextWeb;
    }

    public void setNoticeTextWeb(String noticeTextWeb)
    {
        this.noticeTextWeb = noticeTextWeb;
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
        return this.noticeInfoId + "^" + this.shopId + "^" + this.activityId + "^" + this.noticeTitle + "^" + this.marketingLinkType + "^" + this.marketingLinkId + "^" + this.noticeTextMobile + "^" + this.noticeTextWeb + "^" + this.img + "^" + this.publishStatus + "^" + this.auditNote + "^" + this.ruleId + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
