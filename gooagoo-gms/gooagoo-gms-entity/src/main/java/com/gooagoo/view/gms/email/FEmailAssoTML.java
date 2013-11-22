package com.gooagoo.view.gms.email;

import java.io.Serializable;
import java.util.Date;

/**
 * 邮件营销与模板关联信息
 */
public class FEmailAssoTML implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String emailId;//邮件编号
    private String shopId;//商家编号
    private String marketingLinkType;//营销内容关联类型
    private String marketingLinkId;//营销内容关联编号
    private Integer sort;//排列顺序
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

    public Integer getSort()
    {
        return this.sort;
    }

    public void setSort(Integer sort)
    {
        this.sort = sort;
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

}
