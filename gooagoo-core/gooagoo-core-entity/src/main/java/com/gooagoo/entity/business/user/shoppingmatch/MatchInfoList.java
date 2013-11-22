package com.gooagoo.entity.business.user.shoppingmatch;

import java.io.Serializable;

/**
 *  购物匹配列表 
 */
public class MatchInfoList implements Serializable
{

    private static final long serialVersionUID = 1L;

    /** 购物清单关键字  */
    private String keyword = "";

    /** 商品id  */
    private String goodsid = "";

    /** 商品名称  */
    private String goodsname = "";

    /**
     * 设置购物清单关键字 
     * @param keyword	购物清单关键字 
     */
    public void setKeyword(String keyword)
    {
        this.keyword = keyword;
    }

    /**
     * 获取购物清单关键字 
     * @return	购物清单关键字 
     */
    public String getKeyword()
    {
        return this.keyword;
    }

    /**
     * 设置商品id 
     * @param goodsid	商品id 
     */
    public void setGoodsid(String goodsid)
    {
        this.goodsid = goodsid;
    }

    /**
     * 获取商品id 
     * @return	商品id 
     */
    public String getGoodsid()
    {
        return this.goodsid;
    }

    /**
     * 设置商品名称 
     * @param goodsname	商品名称 
     */
    public void setGoodsname(String goodsname)
    {
        this.goodsname = goodsname;
    }

    /**
     * 获取商品名称 
     * @return	商品名称 
     */
    public String getGoodsname()
    {
        return this.goodsname;
    }
}