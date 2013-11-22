package com.gooagoo.entity.business.shop;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *  主区域
 */
public class MainAreaBusiness implements Serializable
{

    private static final long serialVersionUID = 1L;

    /** 店铺编号  */
    private String storeId = "";

    /** 主区域编号  */
    private String storeAreaId = "";

    /** 主区域名称  */
    private String storeAreaName = "";

    /** 主区域人数  */
    private String storeAreaCount = "";

    /** 子区域列表  */
    private List<SubAreaBusiness> subAreaBusinessList = new ArrayList<SubAreaBusiness>();

    public String getStoreId()
    {
        return this.storeId;
    }

    public void setStoreId(String storeId)
    {
        this.storeId = storeId;
    }

    public String getStoreAreaId()
    {
        return this.storeAreaId;
    }

    public void setStoreAreaId(String storeAreaId)
    {
        this.storeAreaId = storeAreaId;
    }

    public String getStoreAreaName()
    {
        return this.storeAreaName;
    }

    public void setStoreAreaName(String storeAreaName)
    {
        this.storeAreaName = storeAreaName;
    }

    public String getStoreAreaCount()
    {
        return this.storeAreaCount;
    }

    public void setStoreAreaCount(String storeAreaCount)
    {
        this.storeAreaCount = storeAreaCount;
    }

    public List<SubAreaBusiness> getSubAreaBusinessList()
    {
        return this.subAreaBusinessList;
    }

    public void setSubAreaBusinessList(List<SubAreaBusiness> subAreaBusinessList)
    {
        this.subAreaBusinessList = subAreaBusinessList;
    }

    @Override
    public String toString()
    {
        return "MainAreaBusiness [storeId=" + this.storeId + ", storeAreaId=" + this.storeAreaId + ", storeAreaName=" + this.storeAreaName + ", storeAreaCount=" + this.storeAreaCount + ", subAreaBusinessList=" + this.subAreaBusinessList.toString() + "]";
    }

}
