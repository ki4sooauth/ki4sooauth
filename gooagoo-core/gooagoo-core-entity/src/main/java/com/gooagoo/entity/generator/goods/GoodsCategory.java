package com.gooagoo.entity.generator.goods;

import java.io.Serializable;
import java.util.Date;

/**
 * 品类信息，每个商家自行维护
 */

public class GoodsCategory implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//自动编号，UUID

    private String categoryId;//品类编号

    private String categoryName;//品类名称

    private String shopId;//所属商家

    private String shopEntityId;//实体店编号

    private String parentCategoryId;//父品类编号，-1表示没有父品类

    private String picUrl;//图片URL

    private Integer sort;//排序

    private String positionId;//位置编号，描述品类在实体店中所处的位置

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

    public String getCategoryId()
    {
        return this.categoryId;
    }

    public void setCategoryId(String categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getCategoryName()
    {
        return this.categoryName;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

    public String getParentCategoryId()
    {
        return this.parentCategoryId;
    }

    public void setParentCategoryId(String parentCategoryId)
    {
        this.parentCategoryId = parentCategoryId;
    }

    public String getPicUrl()
    {
        return this.picUrl;
    }

    public void setPicUrl(String picUrl)
    {
        this.picUrl = picUrl;
    }

    public Integer getSort()
    {
        return this.sort;
    }

    public void setSort(Integer sort)
    {
        this.sort = sort;
    }

    public String getPositionId()
    {
        return this.positionId;
    }

    public void setPositionId(String positionId)
    {
        this.positionId = positionId;
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
        return this.id + "^" + this.categoryId + "^" + this.categoryName + "^" + this.shopId + "^" + this.shopEntityId + "^" + this.parentCategoryId + "^" + this.picUrl + "^" + this.sort + "^" + this.positionId + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
