package com.gooagoo.view.gms.marketing;

import java.io.Serializable;
import java.util.Date;

/**
 * 商家积分兑换信息
 */
public class FShopIntegral implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//积分兑换信息id
    private String shopId;//商家Id
    private String convertType;//积分兑换类型（G-商品，C-优惠凭证）
    private String convertObjectId;//积分兑换对象id
    private String convertObjectName;//积分兑换对象名称
    private Integer convertValue;//兑换积分值
    private Date convertStartTime;//允许兑换开始时间
    private Date convertEndTime;//允许兑换结束时间
    private String imgUrl;//商品或优惠凭证图片地址
    private Integer convertNums;//兑换次数

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

    public String getConvertType()
    {
        return this.convertType;
    }

    public void setConvertType(String convertType)
    {
        this.convertType = convertType;
    }

    public String getConvertObjectId()
    {
        return this.convertObjectId;
    }

    public void setConvertObjectId(String convertObjectId)
    {
        this.convertObjectId = convertObjectId;
    }

    public String getConvertObjectName()
    {
        return this.convertObjectName;
    }

    public void setConvertObjectName(String convertObjectName)
    {
        this.convertObjectName = convertObjectName;
    }

    public Integer getConvertValue()
    {
        return this.convertValue;
    }

    public void setConvertValue(Integer convertValue)
    {
        this.convertValue = convertValue;
    }

    public Date getConvertStartTime()
    {
        return this.convertStartTime;
    }

    public void setConvertStartTime(Date convertStartTime)
    {
        this.convertStartTime = convertStartTime;
    }

    public Date getConvertEndTime()
    {
        return this.convertEndTime;
    }

    public void setConvertEndTime(Date convertEndTime)
    {
        this.convertEndTime = convertEndTime;
    }

    public String getImgUrl()
    {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }

    public Integer getConvertNums()
    {
        return convertNums;
    }

    public void setConvertNums(Integer convertNums)
    {
        this.convertNums = convertNums;
    }

}
