package com.gooagoo.view.gms.marketing;

import java.io.Serializable;
import java.util.Date;

/**
 * 精品推荐信息
 */
public class FJingpin implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String jingpinId;//营销事件关联Id（主键）
    private String shopId;//商家id
    private Integer jingpinTypeId;//精品类型id
    private Integer jingpinTypeRootId;//精品类型根节点id
    private String jingpinTypeName;//精品类型名称
    private String goodsId;//商品id
    private String goodsName;//商品名称
    private String imgUrl;//商品图片地址
    private Date createTime;//创建时间

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public String getJingpinId()
    {
        return this.jingpinId;
    }

    public void setJingpinId(String jingpinId)
    {
        this.jingpinId = jingpinId;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public Integer getJingpinTypeId()
    {
        return this.jingpinTypeId;
    }

    public void setJingpinTypeId(Integer jingpinTypeId)
    {
        this.jingpinTypeId = jingpinTypeId;
    }

    public Integer getJingpinTypeRootId()
    {
        return this.jingpinTypeRootId;
    }

    public void setJingpinTypeRootId(Integer jingpinTypeRootId)
    {
        this.jingpinTypeRootId = jingpinTypeRootId;
    }

    public String getJingpinTypeName()
    {
        return this.jingpinTypeName;
    }

    public void setJingpinTypeName(String jingpinTypeName)
    {
        this.jingpinTypeName = jingpinTypeName;
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

    public String getImgUrl()
    {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }

}
