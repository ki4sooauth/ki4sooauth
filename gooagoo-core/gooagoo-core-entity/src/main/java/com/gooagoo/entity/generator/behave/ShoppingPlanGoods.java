package com.gooagoo.entity.generator.behave;

import java.io.Serializable;
import java.util.Date;

/**
 * 购物清单商品表
 */

public class ShoppingPlanGoods implements Serializable
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

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getShoppingGoodsId()
    {
        return this.shoppingGoodsId;
    }

    public void setShoppingGoodsId(String shoppingGoodsId)
    {
        this.shoppingGoodsId = shoppingGoodsId;
    }

    public String getShoppingListId()
    {
        return this.shoppingListId;
    }

    public void setShoppingListId(String shoppingListId)
    {
        this.shoppingListId = shoppingListId;
    }

    public String getGoodsId()
    {
        return this.goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
    }

    public String getGoodsName()
    {
        return this.goodsName;
    }

    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public Integer getGoodsTypeId()
    {
        return this.goodsTypeId;
    }

    public void setGoodsTypeId(Integer goodsTypeId)
    {
        this.goodsTypeId = goodsTypeId;
    }

    public String getGoodsTypeName()
    {
        return this.goodsTypeName;
    }

    public void setGoodsTypeName(String goodsTypeName)
    {
        this.goodsTypeName = goodsTypeName;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopName()
    {
        return this.shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public String getIsDel()
    {
        return this.isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getCTimeStamp()
    {
        return this.cTimeStamp;
    }

    public void setCTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    @Override
    public String toString()
    {
        return this.shoppingGoodsId + "^" + this.shoppingListId + "^" + this.goodsId + "^" + this.goodsName + "^" + this.goodsTypeId + "^" + this.goodsTypeName + "^" + this.shopId + "^" + this.shopName + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
