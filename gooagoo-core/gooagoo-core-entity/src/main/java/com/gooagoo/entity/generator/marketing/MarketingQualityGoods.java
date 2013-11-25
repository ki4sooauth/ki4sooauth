package com.gooagoo.entity.generator.marketing;

import java.io.Serializable;
import java.util.Date;

/**
 * 精品推荐
 */

public class MarketingQualityGoods implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//自动编号，UUID

    private String shopId;//商家编号

    private Integer qualityTypeRoot;//精品类型（根节点）

    private Integer qualityTypeLeaf;//精品类型（叶节点）

    private String goodsId;//商品编号

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

    public Integer getQualityTypeRoot()
    {
        return this.qualityTypeRoot;
    }

    public void setQualityTypeRoot(Integer qualityTypeRoot)
    {
        this.qualityTypeRoot = qualityTypeRoot;
    }

    public Integer getQualityTypeLeaf()
    {
        return this.qualityTypeLeaf;
    }

    public void setQualityTypeLeaf(Integer qualityTypeLeaf)
    {
        this.qualityTypeLeaf = qualityTypeLeaf;
    }

    public String getGoodsId()
    {
        return this.goodsId;
    }

    public void setGoodsId(String goodsId)
    {
        this.goodsId = goodsId;
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
        return this.id + "^" + this.shopId + "^" + this.qualityTypeRoot + "^" + this.qualityTypeLeaf + "^" + this.goodsId + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}