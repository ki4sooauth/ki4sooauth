package com.gooagoo.view.gms.email;

import java.io.Serializable;
import java.util.Date;

/**
 * 邮件营销与用户关联信息
 */
public class FEmailAssoUser implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String emailId;//邮件编号
    private String shopId;//商家编号
    private String userId;//用户编号
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

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
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
