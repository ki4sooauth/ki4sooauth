package com.gooagoo.entity.generator.sys;

import java.io.Serializable;

/**
 * 商圈
 */

public class TradeAreaKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String tradeAreaId;//商圈编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getTradeAreaId()
    {
        return tradeAreaId;
    }

    public void setTradeAreaId(String tradeAreaId)
    {
        this.tradeAreaId = tradeAreaId;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

}
