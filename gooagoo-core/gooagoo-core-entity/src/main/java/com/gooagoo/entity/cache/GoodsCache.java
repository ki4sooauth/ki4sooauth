package com.gooagoo.entity.cache;

import java.io.Serializable;
import java.util.List;

public class GoodsCache implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String _id; // mongodb键值
    private String goodsId;// 商品编号，UUID
    private String goodsName;// 商品名称
    private String shopId;// 商家编号
    private String shopEntityId;// 实体店编号
    private List<String> goodsCategoryId;//品类id
    private List<String> goodsCategory;//品类
    private String goodsBrand;// 品牌编号
    private String goodsSerial;// 商品序列号（商品的唯一识别编码）
    private String itemSerial;// 自定义序列号（商品细分的唯一识别编码）
    private Double price;// 商品价格

    public String get_id()
    {
        return _id;
    }

    public void set_id(String _id)
    {
        this._id = _id;
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

    public String getShopId()
    {
        return shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopEntityId()
    {
        return shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public List<String> getGoodsCategoryId()
    {
        return goodsCategoryId;
    }

    public void setGoodsCategoryId(List<String> goodsCategoryId)
    {
        this.goodsCategoryId = goodsCategoryId;
    }

    public List<String> getGoodsCategory()
    {
        return goodsCategory;
    }

    public void setGoodsCategory(List<String> goodsCategory)
    {
        this.goodsCategory = goodsCategory;
    }

    public String getGoodsBrand()
    {
        return goodsBrand;
    }

    public void setGoodsBrand(String goodsBrand)
    {
        this.goodsBrand = goodsBrand;
    }

    public String getGoodsSerial()
    {
        return goodsSerial;
    }

    public void setGoodsSerial(String goodsSerial)
    {
        this.goodsSerial = goodsSerial;
    }

    public String getItemSerial()
    {
        return itemSerial;
    }

    public void setItemSerial(String itemSerial)
    {
        this.itemSerial = itemSerial;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }
}
