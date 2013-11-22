package com.gooagoo.entity.generator.shop;

import java.io.Serializable;
import java.util.Date;

/**
 * 服务工具排序
 */

public class ServiceToolSort implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//自动编号，UUID

    private String shopId;//商家编号

    private String toolId;//服务工具编号

    private String toolType;//分类，0-服务工具，1-栏目

    private Integer orderNo;//排序编号

    private Date createTime;//创建时间

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

    public String getToolId()
    {
        return this.toolId;
    }

    public void setToolId(String toolId)
    {
        this.toolId = toolId;
    }

    public String getToolType()
    {
        return this.toolType;
    }

    public void setToolType(String toolType)
    {
        this.toolType = toolType;
    }

    public Integer getOrderNo()
    {
        return this.orderNo;
    }

    public void setOrderNo(Integer orderNo)
    {
        this.orderNo = orderNo;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    @Override
    public String toString()
    {
        return this.id + "^" + this.shopId + "^" + this.toolId + "^" + this.toolType + "^" + this.orderNo + "^" + this.createTime;
    }
}
