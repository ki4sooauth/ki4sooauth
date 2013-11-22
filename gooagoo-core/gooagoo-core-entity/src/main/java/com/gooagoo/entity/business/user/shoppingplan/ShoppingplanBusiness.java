package com.gooagoo.entity.business.user.shoppingplan;

import java.io.Serializable;

/**
 *  购物计划 
 */
public class ShoppingplanBusiness implements Serializable
{

    private static final long serialVersionUID = 1L;

    /** 购物清单编号，UUID  */
    private String shoppinglistid = "";

    /** 购物清单标题  */
    private String title = "";

    /** 预计购物时间  */
    private String preshoppingtime = "";

    /** 信息来源，参考通用字典表的infosource  */
    private String infosource = "";

    /** 是否删除，Y-已删除，N-未删除  */
    private String isdel = "";

    /** 创建时间  */
    private String createtime = "";

    /** 最后一次修改时间  */
    private String ctimestamp = "";

    /**  商品列表  */
    private java.util.List<ShoppingplanGoodsBusiness> shoppingplanGoodsBusinessList = new java.util.ArrayList<ShoppingplanGoodsBusiness>();

    public String getShoppinglistid()
    {
        return this.shoppinglistid;
    }

    public void setShoppinglistid(String shoppinglistid)
    {
        this.shoppinglistid = shoppinglistid;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getPreshoppingtime()
    {
        return this.preshoppingtime;
    }

    public void setPreshoppingtime(String preshoppingtime)
    {
        this.preshoppingtime = preshoppingtime;
    }

    public String getInfosource()
    {
        return this.infosource;
    }

    public void setInfosource(String infosource)
    {
        this.infosource = infosource;
    }

    public String getIsdel()
    {
        return this.isdel;
    }

    public void setIsdel(String isdel)
    {
        this.isdel = isdel;
    }

    public String getCreatetime()
    {
        return this.createtime;
    }

    public void setCreatetime(String createtime)
    {
        this.createtime = createtime;
    }

    public String getCtimestamp()
    {
        return this.ctimestamp;
    }

    public void setCtimestamp(String ctimestamp)
    {
        this.ctimestamp = ctimestamp;
    }

    public java.util.List<ShoppingplanGoodsBusiness> getShoppingplanGoodsBusinessList()
    {
        return this.shoppingplanGoodsBusinessList;
    }

    public void setShoppingplanGoodsBusinessList(java.util.List<ShoppingplanGoodsBusiness> shoppingplanGoodsBusinessList)
    {
        this.shoppingplanGoodsBusinessList = shoppingplanGoodsBusinessList;
    }

    @Override
    public String toString()
    {
        return "ShoppingplanBusiness [shoppinglistid=" + this.shoppinglistid + ", title=" + this.title + ", preshoppingtime=" + this.preshoppingtime + ", infosource=" + this.infosource + ", isdel=" + this.isdel + ", createtime=" + this.createtime + ", ctimestamp=" + this.ctimestamp + ", shoppingplanGoodsBusinessList=" + this.shoppingplanGoodsBusinessList + "]";
    }

}