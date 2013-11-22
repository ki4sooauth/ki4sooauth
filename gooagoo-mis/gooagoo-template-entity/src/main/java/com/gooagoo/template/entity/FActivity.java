package com.gooagoo.template.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 营销活动信息
 */
public class FActivity implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String activityId;//活动编号，UUID
    private String shopId;//商家编号
    private String activityName;//活动名称
    private String title;//活动主题
    private String startTime;//活动开始时间
    private String endTime;//活动结束时间
    private String imgUrl;//活动图片URL
    private String content;//活动内容，具体信息保存在mongodb中
    private String purpose;//活动目的，具体信息保存在mongodb中
    private String description;//活动描述，具体信息保存在mongodb中
    private String templateId;//模板编号
    private String templateData;//模板数据，保存的是json串，具体信息保存在mongodb中
    private String publishStatus;//状态（审核与发布），参考通用字典表的publish_status
    private String auditNote;//审核备注
    private String isDel;//是否删除，Y-已删除，N-未删除
    private Date createTime;//创建时间
    private Date cTimeStamp;//最后一次修改时间
    private String startTimeStr;//活动开始时间
    private String endTimeStr;//活动结束时间
    private String mobileVisitUrl;//活动手机端访问地址
    private String webVisitUrl;//活动网站端访问地址
    private String shopMobileVisitUrl;//商家手机端访问地址
    private String shopWebVisitUrl;//商家网站端访问地址
    private Date startTime_FE;//活动开始时间，用于按时间查询，如果此字段有值，可查询出>=此字段值的记录
    private Date startTime_TE;//活动开始时间，用于按时间查询，如果此字段有值，可查询出<=此字段值的记录
    private Date endTime_FE;//活动结束时间，用于按时间查询，如果此字段有值，可查询出>=此字段值的记录
    private Date endTime_TE;//活动结束时间，用于按时间查询，如果此字段有值，可查询出<=此字段值的记录

    private String shopName;//活动商家，数据库无此字段

    public String getActivityId()
    {
        return activityId;
    }

    public void setActivityId(String activityId)
    {
        this.activityId = activityId;
    }

    public String getShopId()
    {
        return shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getActivityName()
    {
        return activityName;
    }

    public void setActivityName(String activityName)
    {
        this.activityName = activityName;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getStartTime()
    {
        return startTime;
    }

    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }

    public String getEndTime()
    {
        return endTime;
    }

    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }

    public String getImgUrl()
    {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getPurpose()
    {
        return purpose;
    }

    public void setPurpose(String purpose)
    {
        this.purpose = purpose;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getTemplateId()
    {
        return templateId;
    }

    public void setTemplateId(String templateId)
    {
        this.templateId = templateId;
    }

    public String getTemplateData()
    {
        return templateData;
    }

    public void setTemplateData(String templateData)
    {
        this.templateData = templateData;
    }

    public String getPublishStatus()
    {
        return publishStatus;
    }

    public void setPublishStatus(String publishStatus)
    {
        this.publishStatus = publishStatus;
    }

    public String getAuditNote()
    {
        return auditNote;
    }

    public void setAuditNote(String auditNote)
    {
        this.auditNote = auditNote;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getcTimeStamp()
    {
        return cTimeStamp;
    }

    public void setcTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    public String getStartTimeStr()
    {
        return startTimeStr;
    }

    public void setStartTimeStr(String startTimeStr)
    {
        this.startTimeStr = startTimeStr;
    }

    public String getEndTimeStr()
    {
        return endTimeStr;
    }

    public void setEndTimeStr(String endTimeStr)
    {
        this.endTimeStr = endTimeStr;
    }

    public String getMobileVisitUrl()
    {
        return mobileVisitUrl;
    }

    public void setMobileVisitUrl(String mobileVisitUrl)
    {
        this.mobileVisitUrl = mobileVisitUrl;
    }

    public String getWebVisitUrl()
    {
        return webVisitUrl;
    }

    public void setWebVisitUrl(String webVisitUrl)
    {
        this.webVisitUrl = webVisitUrl;
    }

    public Date getStartTime_FE()
    {
        return startTime_FE;
    }

    public void setStartTime_FE(Date startTime_FE)
    {
        this.startTime_FE = startTime_FE;
    }

    public Date getStartTime_TE()
    {
        return startTime_TE;
    }

    public void setStartTime_TE(Date startTime_TE)
    {
        this.startTime_TE = startTime_TE;
    }

    public Date getEndTime_FE()
    {
        return endTime_FE;
    }

    public void setEndTime_FE(Date endTime_FE)
    {
        this.endTime_FE = endTime_FE;
    }

    public Date getEndTime_TE()
    {
        return endTime_TE;
    }

    public void setEndTime_TE(Date endTime_TE)
    {
        this.endTime_TE = endTime_TE;
    }

    public String getShopName()
    {
        return shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public String getShopMobileVisitUrl()
    {
        return shopMobileVisitUrl;
    }

    public void setShopMobileVisitUrl(String shopMobileVisitUrl)
    {
        this.shopMobileVisitUrl = shopMobileVisitUrl;
    }

    public String getShopWebVisitUrl()
    {
        return shopWebVisitUrl;
    }

    public void setShopWebVisitUrl(String shopWebVisitUrl)
    {
        this.shopWebVisitUrl = shopWebVisitUrl;
    }

}
