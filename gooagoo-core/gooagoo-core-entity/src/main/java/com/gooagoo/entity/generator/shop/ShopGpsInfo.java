package com.gooagoo.entity.generator.shop;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体店GPS信息表
 */

public class ShopGpsInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String shopEntityId;//实体店编号

    private String shopId;//商家编号

    private String shopGpsBaidux;//GPS百度的X坐标

    private String shopGpsBaiduy;//GPS百度的Y坐标

    private String shopGpsGooglex;//GPS Google的X坐标

    private String shopGpsGoogley;//GPS Google的Y坐标

    private String note;//备注

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopGpsBaidux()
    {
        return this.shopGpsBaidux;
    }

    public void setShopGpsBaidux(String shopGpsBaidux)
    {
        this.shopGpsBaidux = shopGpsBaidux;
    }

    public String getShopGpsBaiduy()
    {
        return this.shopGpsBaiduy;
    }

    public void setShopGpsBaiduy(String shopGpsBaiduy)
    {
        this.shopGpsBaiduy = shopGpsBaiduy;
    }

    public String getShopGpsGooglex()
    {
        return this.shopGpsGooglex;
    }

    public void setShopGpsGooglex(String shopGpsGooglex)
    {
        this.shopGpsGooglex = shopGpsGooglex;
    }

    public String getShopGpsGoogley()
    {
        return this.shopGpsGoogley;
    }

    public void setShopGpsGoogley(String shopGpsGoogley)
    {
        this.shopGpsGoogley = shopGpsGoogley;
    }

    public String getNote()
    {
        return this.note;
    }

    public void setNote(String note)
    {
        this.note = note;
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
        return this.shopEntityId + "^" + this.shopId + "^" + this.shopGpsBaidux + "^" + this.shopGpsBaiduy + "^" + this.shopGpsGooglex + "^" + this.shopGpsGoogley + "^" + this.note + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
