package com.gooagoo.entity.generator.goods;

import java.io.Serializable;
import java.util.Date;

/**
 * 商家品牌信息，每个商家自行维护
 */

public class GoodsBrand implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//自动编号，UUID

    private String brandId;//品牌编号

    private String brandName;//品牌名称

    private String shopId;//所属商家

    private String shopEntityId;//实体店编号

    private String picUrl;//图片URL

    private Integer sort;//排序

    private String positionId;//位置编号，描述品牌在实体店中所处的位置

    private String positionName;//位置名称，描述品牌在实体店中所处的位置

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

    public String getBrandId()
    {
        return this.brandId;
    }

    public void setBrandId(String brandId)
    {
        this.brandId = brandId;
    }

    public String getBrandName()
    {
        return this.brandName;
    }

    public void setBrandName(String brandName)
    {
        this.brandName = brandName;
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

    public String getPositionName()
    {
        return this.positionName;
    }

    public void setPositionName(String positionName)
    {
        this.positionName = positionName;
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
        return this.id + "^" + this.brandId + "^" + this.brandName + "^" + this.shopId + "^" + this.shopEntityId + "^" + this.picUrl + "^" + this.sort + "^" + this.positionId + "^" + this.positionName + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
