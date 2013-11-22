package com.gooagoo.entity.business.shop;

import java.io.Serializable;

/**
 *  子区域
 */
public class SubAreaBusiness implements Serializable
{

    private static final long serialVersionUID = 1L;

    /** 子区域编号  */
    private String storeSubAreaId = "";

    /** 子区域名称  */
    private String storeSubAreaName = "";

    /** 子区域人数  */
    private String storeAreaCount = "";

    public String getStoreSubAreaId()
    {
        return this.storeSubAreaId;
    }

    public void setStoreSubAreaId(String storeSubAreaId)
    {
        this.storeSubAreaId = storeSubAreaId;
    }

    public String getStoreSubAreaName()
    {
        return this.storeSubAreaName;
    }

    public void setStoreSubAreaName(String storeSubAreaName)
    {
        this.storeSubAreaName = storeSubAreaName;
    }

    public String getStoreAreaCount()
    {
        return this.storeAreaCount;
    }

    public void setStoreAreaCount(String storeAreaCount)
    {
        this.storeAreaCount = storeAreaCount;
    }

    @Override
    public String toString()
    {
        return "SubAreaBusiness [storeSubAreaId=" + this.storeSubAreaId + ", storeSubAreaName=" + this.storeSubAreaName + ", storeAreaCount=" + this.storeAreaCount + "]";
    }

}
