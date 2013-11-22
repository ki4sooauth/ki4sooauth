package com.gooagoo.entity.generator.sys;

import java.io.Serializable;
import java.util.Date;

/**
 * 商家竞拍信息表
 */

public class ShopBid implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//商家竞价自动编号，UUID

    private String bidId;//竞拍编号

    private String adCode;//广告位编码

    private String shopId;//商家编号

    private String shopName;//商家名称

    private Double bidAmount;//竞拍金额

    private String operator;//操作者

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

    public String getBidId()
    {
        return this.bidId;
    }

    public void setBidId(String bidId)
    {
        this.bidId = bidId;
    }

    public String getAdCode()
    {
        return this.adCode;
    }

    public void setAdCode(String adCode)
    {
        this.adCode = adCode;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopName()
    {
        return this.shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public Double getBidAmount()
    {
        return this.bidAmount;
    }

    public void setBidAmount(Double bidAmount)
    {
        this.bidAmount = bidAmount;
    }

    public String getOperator()
    {
        return this.operator;
    }

    public void setOperator(String operator)
    {
        this.operator = operator;
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
        return this.id + "^" + this.bidId + "^" + this.adCode + "^" + this.shopId + "^" + this.shopName + "^" + this.bidAmount + "^" + this.operator + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
