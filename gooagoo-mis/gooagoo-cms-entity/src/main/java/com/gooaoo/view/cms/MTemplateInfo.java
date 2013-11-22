package com.gooaoo.view.cms;

import java.io.Serializable;
import java.util.Date;

/**
 * 模板信息
 */
public class MTemplateInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String templateId;//模板编号，UUID

    private String templateType;//'模板类型，参考通用字典表的template_type（E-营销事件，G-商品，A-营销活动，C-优惠凭证，W-网站虚拟商家，M-手机虚拟商家）',

    private String channelCode;//营销渠道编码（4-邮件、5-购好奇、6-手机服务）

    private String templateName;//模板名称

    private String templateImg;//预览图片

    private String templateCont;//模板内容

    private String templateDescription;//模板描述

    private String authorization;//授权方式，R-仅限于使用，W-可修改

    private String userType;//账户类型，M-后台用户，S-商家用户，P-个人用户

    private String userId;//所属用户账号

    private Double price;//费用，模板单次使用费用或授权修改费用

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getTemplateId()
    {
        return this.templateId;
    }

    public void setTemplateId(String templateId)
    {
        this.templateId = templateId;
    }

    public String getTemplateType()
    {
        return this.templateType;
    }

    public void setTemplateType(String templateType)
    {
        this.templateType = templateType;
    }

    public String getChannelCode()
    {
        return this.channelCode;
    }

    public void setChannelCode(String channelCode)
    {
        this.channelCode = channelCode;
    }

    public String getTemplateName()
    {
        return this.templateName;
    }

    public void setTemplateName(String templateName)
    {
        this.templateName = templateName;
    }

    public String getTemplateImg()
    {
        return this.templateImg;
    }

    public void setTemplateImg(String templateImg)
    {
        this.templateImg = templateImg;
    }

    public String getTemplateCont()
    {
        return this.templateCont;
    }

    public void setTemplateCont(String templateCont)
    {
        this.templateCont = templateCont;
    }

    public String getTemplateDescription()
    {
        return this.templateDescription;
    }

    public void setTemplateDescription(String templateDescription)
    {
        this.templateDescription = templateDescription;
    }

    public String getAuthorization()
    {
        return this.authorization;
    }

    public void setAuthorization(String authorization)
    {
        this.authorization = authorization;
    }

    public String getUserType()
    {
        return this.userType;
    }

    public void setUserType(String userType)
    {
        this.userType = userType;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public Double getPrice()
    {
        return this.price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
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
