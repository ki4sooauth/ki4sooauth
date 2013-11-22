package com.gooagoo.entity.business.shop;

import java.io.Serializable;

/**
 *  商家列表 
 */
public class ShopInfoBusiness implements Serializable
{

    private static final long serialVersionUID = 1L;

    /** 商家id  */
    private String shopid = "";

    /** 商家名称  */
    private String shopname = "";

    /** 商家正方形logo  */
    private String squarelogo = "";

    /** 商家长方形logo  */
    private String oblonglogo = "";

    /** 商家名首字母  */
    private String shopfirstchar = "";

    /** 商家类别  */
    private String shoptypeleaf = "";

    /** 是否删除，Y-已删除，N-未删除  */
    private String isdel = "";

    /** 最后一次修改时间  */
    private String ctimestamp = "";

    public String getShopid()
    {
        return this.shopid;
    }

    public void setShopid(String shopid)
    {
        this.shopid = shopid;
    }

    public String getShopname()
    {
        return this.shopname;
    }

    public void setShopname(String shopname)
    {
        this.shopname = shopname;
    }

    public String getSquarelogo()
    {
        return this.squarelogo;
    }

    public void setSquarelogo(String squarelogo)
    {
        this.squarelogo = squarelogo;
    }

    public String getOblonglogo()
    {
        return this.oblonglogo;
    }

    public void setOblonglogo(String oblonglogo)
    {
        this.oblonglogo = oblonglogo;
    }

    public String getShopfirstchar()
    {
        return this.shopfirstchar;
    }

    public void setShopfirstchar(String shopfirstchar)
    {
        this.shopfirstchar = shopfirstchar;
    }

    public String getShoptypeleaf()
    {
        return this.shoptypeleaf;
    }

    public void setShoptypeleaf(String shoptypeleaf)
    {
        this.shoptypeleaf = shoptypeleaf;
    }

    public String getIsdel()
    {
        return this.isdel;
    }

    public void setIsdel(String isdel)
    {
        this.isdel = isdel;
    }

    public String getCtimestamp()
    {
        return this.ctimestamp;
    }

    public void setCtimestamp(String ctimestamp)
    {
        this.ctimestamp = ctimestamp;
    }

    @Override
    public String toString()
    {
        return "ShopInfoBusiness [shopid=" + this.shopid + ", shopname=" + this.shopname + ", squarelogo=" + this.squarelogo + ", oblonglogo=" + this.oblonglogo + ", shopfirstchar=" + this.shopfirstchar + ", shoptypeleaf=" + this.shoptypeleaf + ", isdel=" + this.isdel + ", ctimestamp=" + this.ctimestamp + "]";
    }

}
