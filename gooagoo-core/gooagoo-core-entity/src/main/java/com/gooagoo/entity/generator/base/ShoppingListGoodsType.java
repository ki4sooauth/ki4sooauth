package com.gooagoo.entity.generator.base;

import java.io.Serializable;
import java.util.Date;

/**
 * 购物清单商品类型字典表
 */

public class ShoppingListGoodsType implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Integer goodsTypeId;//商品类型编号，自增长

    private String goodsTypeName;//商品类型名称

    private Integer parentGoodsTypeId;//上级类型编号，-1表示无上级

    private String frontPic;//点击前图片

    private String backPic;//点击后图片

    private Integer sortOrder;//排序号

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

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
        return this.goodsTypeId + "^" + this.goodsTypeName + "^" + this.parentGoodsTypeId + "^" + this.frontPic + "^" + this.backPic + "^" + this.sortOrder + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}