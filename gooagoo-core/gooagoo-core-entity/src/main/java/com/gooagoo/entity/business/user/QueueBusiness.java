package com.gooagoo.entity.business.user;

import java.io.Serializable;

/**
 * 排队信息
 */
public class QueueBusiness implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String shopId;//商家编号

    private String shopEntityId;//实体店编号

    private String queueNo;//排队号码

    private String currentqueueno;//即将叫到的号码

    private String waitnum;//排队等候数=排队号码-当前叫到的号码

    private String checkoutnum;//正在结帐数

    private String createtime;//排号时间

    public String getQueueNo()
    {
        return this.queueNo;
    }

    public void setQueueNo(String queueNo)
    {
        this.queueNo = queueNo;
    }

    public String getCurrentqueueno()
    {
        return this.currentqueueno;
    }

    public void setCurrentqueueno(String currentqueueno)
    {
        this.currentqueueno = currentqueueno;
    }

    public String getWaitnum()
    {
        return this.waitnum;
    }

    public void setWaitnum(String waitnum)
    {
        this.waitnum = waitnum;
    }

    public String getCheckoutnum()
    {
        return this.checkoutnum;
    }

    public void setCheckoutnum(String checkoutnum)
    {
        this.checkoutnum = checkoutnum;
    }

    public String getCreatetime()
    {
        return this.createtime;
    }

    public void setCreatetime(String createtime)
    {
        this.createtime = createtime;
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

    @Override
    public String toString()
    {
        return "QueueBusiness [shopId=" + this.shopId + ", shopEntityId=" + this.shopEntityId + ", queueNo=" + this.queueNo + ", currentqueueno=" + this.currentqueueno + ", waitnum=" + this.waitnum + ", checkoutnum=" + this.checkoutnum + ", createtime=" + this.createtime + "]";
    }

}
