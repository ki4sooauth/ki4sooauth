package com.gooagoo.mobile.common.entity;

import java.io.Serializable;

/**
 *  购物计划 
 */
public class UsershoppingPlanEntity implements Serializable
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
    private java.util.List<ShoppingPlanGoodsEntity> shoppinggoodslistS;

    /**
     * 设置购物清单编号，UUID 
     * @param shoppinglistid	购物清单编号，UUID 
     */
    public void setShoppinglistid(String shoppinglistid)
    {
        this.shoppinglistid = shoppinglistid != null ? shoppinglistid : "";
    }

    /**
     * 获取购物清单编号，UUID 
     * @return	购物清单编号，UUID 
     */
    public String getShoppinglistid()
    {
        return this.shoppinglistid;
    }

    /**
     * 设置购物清单标题 
     * @param title	购物清单标题 
     */
    public void setTitle(String title)
    {
        this.title = title != null ? title : "";
    }

    /**
     * 获取购物清单标题 
     * @return	购物清单标题 
     */
    public String getTitle()
    {
        return this.title;
    }

    /**
     * 设置预计购物时间 
     * @param preshoppingtime	预计购物时间 
     */
    public void setPreshoppingtime(String preshoppingtime)
    {
        this.preshoppingtime = preshoppingtime != null ? preshoppingtime : "";
    }

    /**
     * 获取预计购物时间 
     * @return	预计购物时间 
     */
    public String getPreshoppingtime()
    {
        return this.preshoppingtime;
    }

    /**
     * 设置信息来源，参考通用字典表的infosource 
     * @param infosource	信息来源，参考通用字典表的infosource 
     */
    public void setInfosource(String infosource)
    {
        this.infosource = infosource != null ? infosource : "";
    }

    /**
     * 获取信息来源，参考通用字典表的infosource 
     * @return	信息来源，参考通用字典表的infosource 
     */
    public String getInfosource()
    {
        return this.infosource;
    }

    /**
     * 设置是否删除，Y-已删除，N-未删除 
     * @param isdel	是否删除，Y-已删除，N-未删除 
     */
    public void setIsdel(String isdel)
    {
        this.isdel = isdel != null ? isdel : "";
    }

    /**
     * 获取是否删除，Y-已删除，N-未删除 
     * @return	是否删除，Y-已删除，N-未删除 
     */
    public String getIsdel()
    {
        return this.isdel;
    }

    /**
     * 设置创建时间 
     * @param createtime	创建时间 
     */
    public void setCreatetime(String createtime)
    {
        this.createtime = createtime != null ? createtime : "";
    }

    /**
     * 获取创建时间 
     * @return	创建时间 
     */
    public String getCreatetime()
    {
        return this.createtime;
    }

    /**
     * 设置最后一次修改时间 
     * @param ctimestamp	最后一次修改时间 
     */
    public void setCtimestamp(String ctimestamp)
    {
        this.ctimestamp = ctimestamp != null ? ctimestamp : "";
    }

    /**
     * 获取最后一次修改时间 
     * @return	最后一次修改时间 
     */
    public String getCtimestamp()
    {
        return this.ctimestamp;
    }

    /**
     * 获取 商品列表 
     * @return   商品列表 
     */
    public java.util.List<ShoppingPlanGoodsEntity> getShoppinggoodslistS()
    {
        return this.shoppinggoodslistS;
    }

    /**
     * 设置 商品列表 
     * @param shoppingplangoodsmob   商品列表 
     */
    public void setShoppinggoodslistS(java.util.List<ShoppingPlanGoodsEntity> shoppinggoodslistS)
    {
        this.shoppinggoodslistS = shoppinggoodslistS;
    }

    @Override
    public String toString()
    {
        return "UsershoppingPlanEntity [shoppinglistid=" + this.shoppinglistid + ", title=" + this.title + ", preshoppingtime=" + this.preshoppingtime + ", infosource=" + this.infosource + ", isdel=" + this.isdel + ", createtime=" + this.createtime + ", ctimestamp=" + this.ctimestamp + ", shoppinggoodslistS=" + this.shoppinggoodslistS + "]";
    }

}