package com.gooagoo.entity.business.transaction;

import java.io.Serializable;

public class GoodsInfoJson implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public String itemserial;//菜品自定义序列号

    public String goodsname;//菜品名称

    public Integer goodsnums;//菜品数量

    public Double goodsprice = 0.00;//菜品数量

    public String servestate;//上菜标识

    public String getItemserial()
    {
        return this.itemserial;
    }

    public void setItemserial(String itemserial)
    {
        this.itemserial = itemserial;
    }

    public String getGoodsname()
    {
        return this.goodsname;
    }

    public void setGoodsname(String goodsname)
    {
        this.goodsname = goodsname;
    }

    public Integer getGoodsnums()
    {
        return this.goodsnums;
    }

    public void setGoodsnums(Integer goodsnums)
    {
        this.goodsnums = goodsnums;
    }

    public Double getGoodsprice()
    {
        return this.goodsprice;
    }

    public void setGoodsprice(Double goodsprice)
    {
        this.goodsprice = goodsprice;
    }

    public String getServestate()
    {
        return this.servestate;
    }

    public void setServestate(String servestate)
    {
        this.servestate = servestate;
    }

    @Override
    public String toString()
    {
        return "GoodsInfoJson [itemserial=" + this.itemserial + ", goodsname=" + this.goodsname + ", goodsnums=" + this.goodsnums + ", goodsprice=" + this.goodsprice + ", servestate=" + this.servestate + "]";
    }

}
