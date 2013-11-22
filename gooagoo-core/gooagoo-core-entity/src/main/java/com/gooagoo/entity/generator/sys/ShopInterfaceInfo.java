package com.gooagoo.entity.generator.sys;

import java.io.Serializable;
import java.util.Date;

/**
 * 商家接口地址分配
 */

public class ShopInterfaceInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//自动编号，UUID

    private String shopId;//商家编码

    private String iCode;//接口编码

    private String iUrl;//接口地址

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getICode()
    {
        return this.iCode;
    }

    public void setICode(String iCode)
    {
        this.iCode = iCode;
    }

    public String getIUrl()
    {
        return this.iUrl;
    }

    public void setIUrl(String iUrl)
    {
        this.iUrl = iUrl;
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
        return this.id + "^" + this.shopId + "^" + this.iCode + "^" + this.iUrl + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
