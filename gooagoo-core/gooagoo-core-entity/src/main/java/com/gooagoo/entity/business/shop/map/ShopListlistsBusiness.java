package com.gooagoo.entity.business.shop.map;

import java.io.Serializable;

/**
 *  导航信息
 */
public class ShopListlistsBusiness implements Serializable
{

    private static final long serialVersionUID = 1L;

    /** 区域id  */
    private String svgid = "";

    /** 商家id  */
    private String shopid = "";

    /** 实体店编号  */
    private String shopentityid = "";

    /** 实体店名称  */
    private String shopentityname = "";

    /** 商家类型编号（根节点） */
    private String shoptyperootid = "";

    /** 商家类型名称（根节点） */
    private String shoptyperootname = "";

    /** 地图编号  */
    private String mapid = "";

    /** svg 图上的，x轴坐标   */
    private String px = "";

    /** svg 图上的，y轴坐标   */
    private String py = "";

    /**
     * 设置区域id 
     * @param svgid	区域id 
     */
    public void setSvgid(String svgid)
    {
        this.svgid = svgid;
    }

    /**
     * 获取区域id 
     * @return	区域id 
     */
    public String getSvgid()
    {
        return this.svgid;
    }

    /**
     * 设置商家id 
     * @param shopid	商家id 
     */
    public void setShopid(String shopid)
    {
        this.shopid = shopid;
    }

    /**
     * 获取商家id 
     * @return	商家id 
     */
    public String getShopid()
    {
        return this.shopid;
    }

    /**
     * 设置实体店编号 
     * @param shopentityid	实体店编号 
     */
    public void setShopentityid(String shopentityid)
    {
        this.shopentityid = shopentityid;
    }

    /**
     * 获取实体店编号 
     * @return	实体店编号 
     */
    public String getShopentityid()
    {
        return this.shopentityid;
    }

    /**
     * 设置实体店名称 
     * @param shopentityname	实体店名称 
     */
    public void setShopentityname(String shopentityname)
    {
        this.shopentityname = shopentityname;
    }

    /**
     * 获取实体店名称 
     * @return	实体店名称 
     */
    public String getShopentityname()
    {
        return this.shopentityname;
    }

    /**
     * 设置地图编号 
     * @param mapid	地图编号 
     */
    public void setMapid(String mapid)
    {
        this.mapid = mapid;
    }

    /**
     * 获取地图编号 
     * @return	地图编号 
     */
    public String getMapid()
    {
        return this.mapid;
    }

    /**
     * 设置svg 图上的，x轴坐标  
     * @param px	svg 图上的，x轴坐标  
     */
    public void setPx(String px)
    {
        this.px = px;
    }

    /**
     * 获取svg 图上的，x轴坐标  
     * @return	svg 图上的，x轴坐标  
     */
    public String getPx()
    {
        return this.px;
    }

    /**
     * 设置svg 图上的，y轴坐标  
     * @param py	svg 图上的，y轴坐标  
     */
    public void setPy(String py)
    {
        this.py = py;
    }

    /**
     * 获取svg 图上的，y轴坐标  
     * @return	svg 图上的，y轴坐标  
     */
    public String getPy()
    {
        return this.py;
    }

    /**
     * 获取商家类型编号（根节点）
     * @return  商家类型（根节点）
     */
    public String getShoptyperootid()
    {
        return this.shoptyperootid;
    }

    /**
     * 设置商家类型编号（根节点）
     * @param shoptyperoot  商家类型（根节点）
     */
    public void setShoptyperootid(String shoptyperootid)
    {
        this.shoptyperootid = shoptyperootid;
    }

    /**
     * 获取商家类型名称（根节点）
     * @return  商家类型（根节点）
     */
    public String getShoptyperootname()
    {
        return this.shoptyperootname;
    }

    /**
     * 设置商家类型名称（根节点）
     * @param shoptyperoot  商家类型（根节点）
     */
    public void setShoptyperootname(String shoptyperootname)
    {
        this.shoptyperootname = shoptyperootname;
    }

    @Override
    public String toString()
    {
        return "ShopListlistsBusiness [svgid=" + this.svgid + ", shopid=" + this.shopid + ", shopentityid=" + this.shopentityid + ", shopentityname=" + this.shopentityname + ", shoptyperootid=" + this.shoptyperootid + ", shoptyperootname=" + this.shoptyperootname + ", mapid=" + this.mapid + ", px=" + this.px + ", py=" + this.py + "]";
    }

}