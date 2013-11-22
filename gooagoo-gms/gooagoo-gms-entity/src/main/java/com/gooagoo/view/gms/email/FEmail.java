package com.gooagoo.view.gms.email;

import java.io.Serializable;
import java.util.Date;

/**
 * 邮件营销信息
 */
public class FEmail implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String emailId;//邮件编号（主键）
    private String shopId;//商家编号
    private String emailName;//邮件名称
    private String templateId;//模板编号
    private String templateDataId;//模板数据编号
    private String releaseId;//发布日志编号
    private Date createTime;//创建时间
    private Date lastModifyTime;//最后修改时间

    public String getEmailId()
    {
        return this.emailId;
    }

    public void setEmailId(String emailId)
    {
        this.emailId = emailId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getEmailName()
    {
        return this.emailName;
    }

    public void setEmailName(String emailName)
    {
        this.emailName = emailName;
    }

    public String getTemplateId()
    {
        return this.templateId;
    }

    public void setTemplateId(String templateId)
    {
        this.templateId = templateId;
    }

    public String getTemplateDataId()
    {
        return this.templateDataId;
    }

    public void setTemplateDataId(String templateDataId)
    {
        this.templateDataId = templateDataId;
    }

    public String getReleaseId()
    {
        return this.releaseId;
    }

    public void setReleaseId(String releaseId)
    {
        this.releaseId = releaseId;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getLastModifyTime()
    {
        return this.lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime)
    {
        this.lastModifyTime = lastModifyTime;
    }

}
