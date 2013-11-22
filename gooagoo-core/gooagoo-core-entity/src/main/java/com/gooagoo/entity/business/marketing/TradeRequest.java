package com.gooagoo.entity.business.marketing;

import java.io.Serializable;

public class TradeRequest implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String userId;//用户ID

    private String shopId;//商家ID

    private String type;//兑换类型

    private String integralValueMin;//积分兑换值上区间

    private String integralValueMax;//积分兑换值下区间

    private Integer pageIndex;

    private Integer pageSize;

    private String orderByClause;

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getShopId()
    {
        return shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getIntegralValueMin()
    {
        return integralValueMin;
    }

    public void setIntegralValueMin(String integralValueMin)
    {
        this.integralValueMin = integralValueMin;
    }

    public String getIntegralValueMax()
    {
        return integralValueMax;
    }

    public void setIntegralValueMax(String integralValueMax)
    {
        this.integralValueMax = integralValueMax;
    }

    public Integer getPageIndex()
    {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex)
    {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }

    public String getOrderByClause()
    {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause)
    {
        this.orderByClause = orderByClause;
    }

}
