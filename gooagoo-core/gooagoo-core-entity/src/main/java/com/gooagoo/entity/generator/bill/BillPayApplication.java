package com.gooagoo.entity.generator.bill;

import java.io.Serializable;
import java.util.Date;

/**
 * 手机端发起---后台---转发器---第三方系统
 */

public class BillPayApplication implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String orderId;//订单编号，UUID

    private String userId;//用户编号

    private String shopId;//商家编号

    private String shopEntityId;//实体店编号

    private Date applyTime;//申请结账时间

    private String isDeal;//商家是否处理，Y-已处理，N未处理

    private Date dealTime;//商家处理时间

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getOrderId()
    {
        return this.orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public Date getApplyTime()
    {
        return this.applyTime;
    }

    public void setApplyTime(Date applyTime)
    {
        this.applyTime = applyTime;
    }

    public String getIsDeal()
    {
        return this.isDeal;
    }

    public void setIsDeal(String isDeal)
    {
        this.isDeal = isDeal;
    }

    public Date getDealTime()
    {
        return this.dealTime;
    }

    public void setDealTime(Date dealTime)
    {
        this.dealTime = dealTime;
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
        return this.orderId + "^" + this.userId + "^" + this.shopId + "^" + this.shopEntityId + "^" + this.applyTime + "^" + this.isDeal + "^" + this.dealTime + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
