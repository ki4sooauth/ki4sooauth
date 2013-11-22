package com.gooagoo.view.mis.enterprise;

import java.io.Serializable;
import java.util.Date;

/**
 * 商家LID基本信息
 */

public class MShopLidInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String lidBase;//LID基本信息，完整LID的前6位表示商家或实体店，此处只保存完整LID的前6位

    private String shopId;//商家编号

    private String shopEntityId;//实体店编号，每个实体店至少独享一个LID

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getLidBase()
    {
        return lidBase;
    }

    public void setLidBase(String lidBase)
    {
        this.lidBase = lidBase;
    }

    public String getShopId()
    {
        return shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopEntityId()
    {
        return shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getcTimeStamp()
    {
        return cTimeStamp;
    }

    public void setcTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    public String toString()
    {
        return this.lidBase + "^" + this.shopId + "^" + this.shopEntityId + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
