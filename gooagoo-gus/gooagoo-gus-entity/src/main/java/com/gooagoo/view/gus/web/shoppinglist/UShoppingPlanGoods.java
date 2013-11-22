package com.gooagoo.view.gus.web.shoppinglist;

import java.io.Serializable;
import java.util.Date;

public class UShoppingPlanGoods implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String shoppingGoodsId;//购物清单详细编号，UUID

    private String shoppingListId;//购物清单编号

    private String goodsId;//商品编号

    private String goodsName;//商品名称

    private Integer goodsTypeId;//商品类型编号

    private String goodsTypeName;//商品类型名称

    private String shopId;//商家编号

    private String shopName;//商家名称

    private Date createTime;//创建时间

    public String getShoppingGoodsId()
    {
        return shoppingGoodsId;
    }

    public void setShoppingGoodsId(String shoppingGoodsId)
    {
        this.shoppingGoodsId = shoppingGoodsId;
    }

    public String getShoppingListId()
    {
        return shoppingListId;
    }

    public void setShoppingListId(String shoppingListId)
    {
        this.shoppingListId = shoppingListId;
    }

    public String getGoodsId()
    {
        return goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    public String getGoodsName()
    {
        return goodsName;
    }

    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public Integer getGoodsTypeId()
    {
        return goodsTypeId;
    }

    public void setGoodsTypeId(Integer goodsTypeId)
    {
        this.goodsTypeId = goodsTypeId;
    }

    public String getGoodsTypeName()
    {
        return goodsTypeName;
    }

    public void setGoodsTypeName(String goodsTypeName)
    {
        this.goodsTypeName = goodsTypeName;
    }

    public String getShopId()
    {
        return shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopName()
    {
        return shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

}
