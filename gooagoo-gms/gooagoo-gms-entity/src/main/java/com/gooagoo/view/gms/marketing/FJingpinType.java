package com.gooagoo.view.gms.marketing;

import java.io.Serializable;

/**
 * 精品类型
 *
 */
public class FJingpinType implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private Integer goodsTypeId;//商品类型编号

    private String goodsTypeName;//商品类型名称

    private Integer parentGoodsTypeId;//上级类型编号，-1表示无上级

    private String frontPic;//点击前图片

    private String backPic;//点击后图片

    private Integer sortOrder;//排序号

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

    public Integer getParentGoodsTypeId()
    {
        return this.parentGoodsTypeId;
    }

    public void setParentGoodsTypeId(Integer parentGoodsTypeId)
    {
        this.parentGoodsTypeId = parentGoodsTypeId;
    }

    public String getFrontPic()
    {
        return this.frontPic;
    }

    public void setFrontPic(String frontPic)
    {
        this.frontPic = frontPic;
    }

    public String getBackPic()
    {
        return this.backPic;
    }

    public void setBackPic(String backPic)
    {
        this.backPic = backPic;
    }

    public Integer getSortOrder()
    {
        return this.sortOrder;
    }

    public void setSortOrder(Integer sortOrder)
    {
        this.sortOrder = sortOrder;
    }
}
