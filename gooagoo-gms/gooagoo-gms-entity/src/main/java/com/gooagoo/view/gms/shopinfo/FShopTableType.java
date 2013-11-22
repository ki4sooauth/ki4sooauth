package com.gooagoo.view.gms.shopinfo;

import java.io.Serializable;

public class FShopTableType implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String id;//自动编号
    private String name;//类型名称
    private Integer minNums;//建议最小人数
    private Integer maxNums;//建议最大人数
    private String shopEntityId;//所属实体店，为空表示所有实体店
    private String shopEntityName;//所属实体店，为空表示所有实体店

    private String shopId;//所属商家

    public String getShopEntityId()
    {
        return this.shopEntityId;
    }

    public void setShopEntityId(String shopEntityId)
    {
        this.shopEntityId = shopEntityId;
    }

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

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
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

    public String getShopEntityName()
    {
        return this.shopEntityName;
    }

    public void setShopEntityName(String shopEntityName)
    {
        this.shopEntityName = shopEntityName;
    }

}
