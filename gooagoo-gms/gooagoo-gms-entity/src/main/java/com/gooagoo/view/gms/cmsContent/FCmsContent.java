package com.gooagoo.view.gms.cmsContent;

import java.io.Serializable;
import java.util.Date;

/**
 * cms内容管理信息
 * @author Administrator
 *
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

    private String templateId;//'模板编号'

    private String templateData;//'模板数据，保存的是html代码',

    private String isTop;//是否置顶，Y-置顶，N-不置顶

    private Integer orderNo;//排序编号

    private String publishStatus;//状态（审核与发布），参考通用字典表的publish_status

    private String auditNote;//审核备注

    private Date publishTime;//发布时间

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getCmsContentId()
    {
        return this.cmsContentId;
    }

    public void setCmsContentId(String cmsContentId)
    {
        this.cmsContentId = cmsContentId;
    }

    public String getCmsContentType()
    {
        return this.cmsContentType;
    }

    public void setCmsContentType(String cmsContentType)
    {
        this.cmsContentType = cmsContentType;
    }

    public String getParentCmsContentId()
    {
        return this.parentCmsContentId;
    }

    public void setParentCmsContentId(String parentCmsContentId)
    {
        this.parentCmsContentId = parentCmsContentId;
    }

    public String getChannelType()
    {
        return this.channelType;
    }

    public void setChannelType(String channelType)
    {
        this.channelType = channelType;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getCmsContentName()
    {
        return this.cmsContentName;
    }

    public void setCmsContentName(String cmsContentName)
    {
        this.cmsContentName = cmsContentName;
    }

    public String getCmsContentImg()
    {
        return this.cmsContentImg;
    }

    public void setCmsContentImg(String cmsContentImg)
    {
        this.cmsContentImg = cmsContentImg;
    }

    public String getCmsContentDes()
    {
        return this.cmsContentDes;
    }

    public void setCmsContentDes(String cmsContentDes)
    {
        this.cmsContentDes = cmsContentDes;
    }

    public String getCmsContentUrl()
    {
        return this.cmsContentUrl;
    }

    public void setCmsContentUrl(String cmsContentUrl)
    {
        this.cmsContentUrl = cmsContentUrl;
    }

    public String getTemplateId()
    {
        return this.templateId;
    }

    public void setTemplateId(String templateId)
    {
        this.templateId = templateId;
    }

    public String getTemplateData()
    {
        return this.templateData;
    }

    public void setTemplateData(String templateData)
    {
        this.templateData = templateData;
    }

    public String getIsTop()
    {
        return this.isTop;
    }

    public void setIsTop(String isTop)
    {
        this.isTop = isTop;
    }

    public Integer getOrderNo()
    {
        return this.orderNo;
    }

    public void setOrderNo(Integer orderNo)
    {
        this.orderNo = orderNo;
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

    public Date getPublishTime()
    {
        return this.publishTime;
    }

    public void setPublishTime(Date publishTime)
    {
        this.publishTime = publishTime;
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

    public Date getcTimeStamp()
    {
        return this.cTimeStamp;
    }

    public void setcTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

}
