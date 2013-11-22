package com.gooagoo.template.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * cms内容信息
 */

public class FCmsContent implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String cmsContentId;//cms内容编号，UUID
    private String cmsContentType;//cms内容类型（A-文章，C-栏目）
    private String parentCmsContentId;//父级cms内容编号
    private String channelType;//'栏目分类，参考info_source，M-手机，W-网站',
    private String shopId;//商家编号
    private String cmsContentName;//cms内容名称
    private String cmsContentImg;//cms内容图标
    private String cmsContentDes;//cms内容介绍
    private String cmsContentUrl;//访问路径
    private String templateContent;//模板内容
    private String isTop;//是否置顶，Y-置顶，N-不置顶
    private Integer orderNo;//排序编号
    private String publishStatus;//状态（审核与发布），参考通用字典表的publish_status
    private String auditNote;//审核备注
    private Date publishTime;//发布时间
    private String isDel;//是否删除，Y-已删除，N-未删除
    private Date createTime;//创建时间
    private Date cTimeStamp;//最后一次修改时间
    private String updateDate;//最后一次修改时间（用于页面显示）

    private String shopName;

    public String getCmsContentId()
    {
        return cmsContentId;
    }

    public void setCmsContentId(String cmsContentId)
    {
        this.cmsContentId = cmsContentId;
    }

    public String getCmsContentType()
    {
        return cmsContentType;
    }

    public void setCmsContentType(String cmsContentType)
    {
        this.cmsContentType = cmsContentType;
    }

    public String getParentCmsContentId()
    {
        return parentCmsContentId;
    }

    public void setParentCmsContentId(String parentCmsContentId)
    {
        this.parentCmsContentId = parentCmsContentId;
    }

    public String getChannelType()
    {
        return channelType;
    }

    public void setChannelType(String channelType)
    {
        this.channelType = channelType;
    }

    public String getShopId()
    {
        return shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getCmsContentName()
    {
        return cmsContentName;
    }

    public void setCmsContentName(String cmsContentName)
    {
        this.cmsContentName = cmsContentName;
    }

    public String getCmsContentImg()
    {
        return cmsContentImg;
    }

    public void setCmsContentImg(String cmsContentImg)
    {
        this.cmsContentImg = cmsContentImg;
    }

    public String getCmsContentDes()
    {
        return cmsContentDes;
    }

    public void setCmsContentDes(String cmsContentDes)
    {
        this.cmsContentDes = cmsContentDes;
    }

    public String getCmsContentUrl()
    {
        return cmsContentUrl;
    }

    public void setCmsContentUrl(String cmsContentUrl)
    {
        this.cmsContentUrl = cmsContentUrl;
    }

    public String getTemplateContent()
    {
        return templateContent;
    }

    public void setTemplateContent(String templateContent)
    {
        this.templateContent = templateContent;
    }

    public String getIsTop()
    {
        return isTop;
    }

    public void setIsTop(String isTop)
    {
        this.isTop = isTop;
    }

    public Integer getOrderNo()
    {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo)
    {
        this.orderNo = orderNo;
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

    public Date getPublishTime()
    {
        return publishTime;
    }

    public void setPublishTime(Date publishTime)
    {
        this.publishTime = publishTime;
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

    public String getShopName()
    {
        return shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public String getUpdateDate()
    {
        return updateDate;
    }

    public void setUpdateDate(String updateDate)
    {
        this.updateDate = updateDate;
    }

}
