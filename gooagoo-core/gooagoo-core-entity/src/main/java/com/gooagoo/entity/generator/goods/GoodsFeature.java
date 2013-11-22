package com.gooagoo.entity.generator.goods;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品特征字典表
 */

public class GoodsFeature implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//自动编号，UUID

    private String shopId;//商家编号

    private String goodsSerial;//商品序列号（商品的唯一识别编码）

    private String typeCode;//类型编号，例如color，同一商家唯一，由商家录入

    private String typeName;//类型名称，例如颜色，同一商家唯一，由商家录入

    private String enumValue;//枚举值，保存的是json串，例如["黄色","蓝色","白色"]

    private String isDisplay;//是否在界面展示，Y-是，N-否

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getGoodsSerial()
    {
        return this.goodsSerial;
    }

    public void setGoodsSerial(String goodsSerial)
    {
        this.goodsSerial = goodsSerial;
    }

    public String getTypeCode()
    {
        return this.typeCode;
    }

    public void setTypeCode(String typeCode)
    {
        this.typeCode = typeCode;
    }

    public String getTypeName()
    {
        return this.typeName;
    }

    public void setTypeName(String typeName)
    {
        this.typeName = typeName;
    }

    public String getEnumValue()
    {
        return this.enumValue;
    }

    public void setEnumValue(String enumValue)
    {
        this.enumValue = enumValue;
    }

    public String getIsDisplay()
    {
        return this.isDisplay;
    }

    public void setIsDisplay(String isDisplay)
    {
        this.isDisplay = isDisplay;
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
        return this.id + "^" + this.shopId + "^" + this.goodsSerial + "^" + this.typeCode + "^" + this.typeName + "^" + this.enumValue + "^" + this.isDisplay + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
