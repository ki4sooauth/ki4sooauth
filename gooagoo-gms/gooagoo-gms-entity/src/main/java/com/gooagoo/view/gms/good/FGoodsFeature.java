package com.gooagoo.view.gms.good;

import java.io.Serializable;
import java.util.List;

public class FGoodsFeature implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String shopId;
    private String id; //自动编号
    private String code;//特征编号
    private String name;//特征名称
    private String isDisplay;// 是否显示
    private String goodsSerial;// 商品序列号

    private List<String> values;//特征值

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getCode()
    {
        return this.code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<String> getValues()
    {
        return this.values;
    }

    public void setValues(List<String> values)
    {
        this.values = values;
    }

    public String getGoodsSerial()
    {
        return this.goodsSerial;
    }

    public void setGoodsSerial(String goodsSerial)
    {
        this.goodsSerial = goodsSerial;
    }

    public String getIsDisplay()
    {
        return this.isDisplay;
    }

    public void setIsDisplay(String isDisplay)
    {
        this.isDisplay = isDisplay;
    }
}
