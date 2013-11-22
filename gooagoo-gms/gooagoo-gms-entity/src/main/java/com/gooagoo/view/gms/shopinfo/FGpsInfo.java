package com.gooagoo.view.gms.shopinfo;

import java.io.Serializable;
import java.util.Date;

public class FGpsInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Date createTime;//创建时间

    private String note;//备注

    private String shopEntityId;//实体店编号

    private String shopGpsBaidux;//GPS百度的X坐标

    private String shopGpsBaiduy;//GPS百度的Y坐标

    private String shopGpsGooglex;//GPS Google的X坐标

    private String shopGpsGoogley;//GPS Google的Y坐标

    private String shopId;//商家编号

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public String getNote()
    {
        return this.note;
    }

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public String getShopGpsBaidux()
    {
        return this.shopGpsBaidux;
    }

    public String getShopGpsBaiduy()
    {
        return this.shopGpsBaiduy;
    }

    public String getShopGpsGooglex()
    {
        return this.shopGpsGooglex;
    }

    public String getShopGpsGoogley()
    {
        return this.shopGpsGoogley;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

   

    

    public void setNote(String note)
    {
        this.note = note;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public void setShopGpsBaidux(String shopGpsBaidux)
    {
        this.shopGpsBaidux = shopGpsBaidux;
    }

    public void setShopGpsBaiduy(String shopGpsBaiduy)
    {
        this.shopGpsBaiduy = shopGpsBaiduy;
    }

    public void setShopGpsGooglex(String shopGpsGooglex)
    {
        this.shopGpsGooglex = shopGpsGooglex;
    }

    public void setShopGpsGoogley(String shopGpsGoogley)
    {
        this.shopGpsGoogley = shopGpsGoogley;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    @Override
    public String toString()
    {
        return "FGpsInfo [createTime=" + createTime + ", note=" + note + ", shopEntityId=" + shopEntityId + ", shopGpsBaidux=" + shopGpsBaidux + ", shopGpsBaiduy=" + shopGpsBaiduy + ", shopGpsGooglex=" + shopGpsGooglex + ", shopGpsGoogley=" + shopGpsGoogley + ", shopId=" + shopId + "]";
    }
}
