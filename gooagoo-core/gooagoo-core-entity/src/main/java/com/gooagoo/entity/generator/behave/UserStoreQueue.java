package com.gooagoo.entity.generator.behave;

import java.io.Serializable;
import java.util.Date;

/**
 * 排号记录，当餐桌够用时，不进行排号，餐桌不够用时才进行排号，由店员进行销号。当号码都已经消除，则重新排号。所有类型的餐桌
 */

public class UserStoreQueue implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//自动编号，UUID

    private String userId;//用户编号

    private String shopId;//商家编号

    private String shopEntityId;//实体店编号

    private Integer queueNo;//排队号码

    private Integer nums;//人数，本次排号所对应的人数

    private String queueType;//排队类型，对应餐桌的类型

    private String isElimination;//是否销号，Y-已销号，N-未销号

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

    public Integer getQueueNo()
    {
        return this.queueNo;
    }

    public void setQueueNo(Integer queueNo)
    {
        this.queueNo = queueNo;
    }

    public Integer getNums()
    {
        return this.nums;
    }

    public void setNums(Integer nums)
    {
        this.nums = nums;
    }

    public String getQueueType()
    {
        return this.queueType;
    }

    public void setQueueType(String queueType)
    {
        this.queueType = queueType;
    }

    public String getIsElimination()
    {
        return this.isElimination;
    }

    public void setIsElimination(String isElimination)
    {
        this.isElimination = isElimination;
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
        return this.id + "^" + this.userId + "^" + this.shopId + "^" + this.shopEntityId + "^" + this.queueNo + "^" + this.nums + "^" + this.queueType + "^" + this.isElimination + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
