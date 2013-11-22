package com.gooagoo.view.mis;

import java.io.Serializable;
import java.util.Date;

/**
 * 营销模板
 */

public class MTemplate implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String templateId;//模板编号

    private String templateType;//模板类型，参考通用字典表的template_type

    private String channelCode;//营销渠道编码

    private String templateName;//模板名称

    private String initData;//初始数据来源，保存的是json串

    private String templateImg;//模板图片地址

    private String templateContInput;//模板输入内容

    private String templateContOutput;//模板输出内容

    private String templateDescription;//模板描述

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    private Date createTime_F;//创建时间，用于按时间查询，如果此字段有值，可查询出>此字段值的记录

    private Date createTime_T;//创建时间，用于按时间查询，如果此字段有值，可查询出<此字段值的记录

    private Date createTime_FE;//创建时间，用于按时间查询，如果此字段有值，可查询出>=此字段值的记录

    private Date createTime_TE;//创建时间，用于按时间查询，如果此字段有值，可查询出<=此字段值的记录

    private Date cTimeStamp_F;//最后一次修改时间，用于按时间查询，如果此字段有值，可查询出>此字段值的记录

    private Date cTimeStamp_T;//最后一次修改时间，用于按时间查询，如果此字段有值，可查询出<此字段值的记录

    private Date cTimeStamp_FE;//最后一次修改时间，用于按时间查询，如果此字段有值，可查询出>=此字段值的记录

    private Date cTimeStamp_TE;//最后一次修改时间，用于按时间查询，如果此字段有值，可查询出<=此字段值的记录

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

    public String getInitData()
    {
        return this.initData;
    }

    public void setInitData(String initData)
    {
        this.initData = initData;
    }

    public String getTemplateImg()
    {
        return this.templateImg;
    }

    public void setTemplateImg(String templateImg)
    {
        this.templateImg = templateImg;
    }

    public String getTemplateContInput()
    {
        return this.templateContInput;
    }

    public void setTemplateContInput(String templateContInput)
    {
        this.templateContInput = templateContInput;
    }

    public String getTemplateContOutput()
    {
        return this.templateContOutput;
    }

    public void setTemplateContOutput(String templateContOutput)
    {
        this.templateContOutput = templateContOutput;
    }

    public String getTemplateDescription()
    {
        return this.templateDescription;
    }

    public void setTemplateDescription(String templateDescription)
    {
        this.templateDescription = templateDescription;
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

    public Date getCreateTime_F()
    {
        return this.createTime_F;
    }

    public void setCreateTime_F(Date createTime_F)
    {
        this.createTime_F = createTime_F;
    }

    public Date getCreateTime_T()
    {
        return this.createTime_T;
    }

    public void setCreateTime_T(Date createTime_T)
    {
        this.createTime_T = createTime_T;
    }

    public Date getCreateTime_FE()
    {
        return this.createTime_FE;
    }

    public void setCreateTime_FE(Date createTime_FE)
    {
        this.createTime_FE = createTime_FE;
    }

    public Date getCreateTime_TE()
    {
        return this.createTime_TE;
    }

    public void setCreateTime_TE(Date createTime_TE)
    {
        this.createTime_TE = createTime_TE;
    }

    public Date getCTimeStamp_F()
    {
        return this.cTimeStamp_F;
    }

    public void setCTimeStamp_F(Date cTimeStamp_F)
    {
        this.cTimeStamp_F = cTimeStamp_F;
    }

    public Date getCTimeStamp_T()
    {
        return this.cTimeStamp_T;
    }

    public void setCTimeStamp_T(Date cTimeStamp_T)
    {
        this.cTimeStamp_T = cTimeStamp_T;
    }

    public Date getCTimeStamp_FE()
    {
        return this.cTimeStamp_FE;
    }

    public void setCTimeStamp_FE(Date cTimeStamp_FE)
    {
        this.cTimeStamp_FE = cTimeStamp_FE;
    }

    public Date getCTimeStamp_TE()
    {
        return this.cTimeStamp_TE;
    }

    public void setCTimeStamp_TE(Date cTimeStamp_TE)
    {
        this.cTimeStamp_TE = cTimeStamp_TE;
    }

    @Override
    public String toString()
    {
        return this.templateId + "^" + this.templateType + "^" + this.channelCode + "^" + this.templateName + "^" + this.initData + "^" + this.templateImg + "^" + this.templateContInput + "^" + this.templateContOutput + "^" + this.templateDescription + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }

}
