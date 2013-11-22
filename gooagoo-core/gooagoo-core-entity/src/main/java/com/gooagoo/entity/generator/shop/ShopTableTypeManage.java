package com.gooagoo.entity.generator.shop;

import java.io.Serializable;
import java.util.Date;

/**
 * 餐桌类型管理
 */

public class ShopTableTypeManage implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String tableTypeCode;//餐桌类型编码，UUID

    private String shopId;//商家编号

    private String shopEntityId;//实体店编号

    private Integer minNums;//建议最小人数

    private Integer maxNums;//建议最大人数

    private String tableTypeName;//餐桌类型名称，如8人桌

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getTableTypeCode()
    {
        return this.tableTypeCode;
    }

    public void setTableTypeCode(String tableTypeCode)
    {
        this.tableTypeCode = tableTypeCode;
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

    public Integer getMinNums()
    {
        return this.minNums;
    }

    public void setMinNums(Integer minNums)
    {
        this.minNums = minNums;
    }

    public Integer getMaxNums()
    {
        return this.maxNums;
    }

    public void setMaxNums(Integer maxNums)
    {
        this.maxNums = maxNums;
    }

    public String getTableTypeName()
    {
        return this.tableTypeName;
    }

    public void setTableTypeName(String tableTypeName)
    {
        this.tableTypeName = tableTypeName;
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
        return this.tableTypeCode + "^" + this.shopId + "^" + this.shopEntityId + "^" + this.minNums + "^" + this.maxNums + "^" + this.tableTypeName + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
