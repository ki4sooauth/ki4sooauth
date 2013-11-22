package com.gooagoo.analysis.entity;

import java.io.Serializable;
import java.util.List;

public class GoodsInfoRuleProperties implements Serializable
{
    private static final long serialVersionUID = 1L;
    private List<String> itemSerialList;
    private List<String> categoryIdList;
    private List<String> brandIdList;

    public List<String> getItemSerialList()
    {
        return this.itemSerialList;
    }

    public void setItemSerialList(List<String> itemSerialList)
    {
        this.itemSerialList = itemSerialList;
    }

    public List<String> getCategoryIdList()
    {
        return this.categoryIdList;
    }

    public void setCategoryIdList(List<String> categoryIdList)
    {
        this.categoryIdList = categoryIdList;
    }

    public List<String> getBrandIdList()
    {
        return this.brandIdList;
    }

    public void setBrandIdList(List<String> brandIdList)
    {
        this.brandIdList = brandIdList;
    }

}
