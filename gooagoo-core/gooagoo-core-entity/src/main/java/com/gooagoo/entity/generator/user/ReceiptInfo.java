package com.gooagoo.entity.generator.user;

import java.io.Serializable;
import java.util.Date;

/**
 * 发票信息管理
 */

public class ReceiptInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String receiptId;//自动编号，UUID

    private String userId;//用户编号

    private String companyName;//公司名称

    private String isDefault;//是否默认选项，Y-是，N-否

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getReceiptId()
    {
        return this.receiptId;
    }

    public void setReceiptId(String receiptId)
    {
        this.receiptId = receiptId;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getCompanyName()
    {
        return this.companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public String getIsDefault()
    {
        return this.isDefault;
    }

    public void setIsDefault(String isDefault)
    {
        this.isDefault = isDefault;
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
        return this.receiptId + "^" + this.userId + "^" + this.companyName + "^" + this.isDefault + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
