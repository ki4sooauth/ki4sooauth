package com.gooagoo.view.gms.marketing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用校验信息，校验json串，支持品类、实体店、会员等级
 */
public class FCouponJson implements Serializable
{
    private static final long serialVersionUID = 1L;
    private List<String> categoryData = new ArrayList<String>(); //品类编码
    private List<String> shopEntityData = new ArrayList<String>(); //实体店ID
    private List<String> vipGradeData = new ArrayList<String>(); //会员等级ID
    private List<String> categoryNames = new ArrayList<String>(); //品类名称
    private List<String> shopEntityNames = new ArrayList<String>(); //实体店名称
    private List<String> vipGradeNames = new ArrayList<String>(); //会员等级名称

    public List<String> getCategoryData()
    {
        return this.categoryData;
    }

    public void setCategoryData(List<String> categoryData)
    {
        this.categoryData = categoryData;
    }

    public List<String> getShopEntityData()
    {
        return this.shopEntityData;
    }

    public void setShopEntityData(List<String> shopEntityData)
    {
        this.shopEntityData = shopEntityData;
    }

    public List<String> getVipGradeData()
    {
        return this.vipGradeData;
    }

    public void setVipGradeData(List<String> vipGradeData)
    {
        this.vipGradeData = vipGradeData;
    }

    public List<String> getCategoryNames()
    {
        return this.categoryNames;
    }

    public void setCategoryNames(List<String> categoryNames)
    {
        this.categoryNames = categoryNames;
    }

    public List<String> getShopEntityNames()
    {
        return this.shopEntityNames;
    }

    public void setShopEntityNames(List<String> shopEntityNames)
    {
        this.shopEntityNames = shopEntityNames;
    }

    public List<String> getVipGradeNames()
    {
        return this.vipGradeNames;
    }

    public void setVipGradeNames(List<String> vipGradeNames)
    {
        this.vipGradeNames = vipGradeNames;
    }

}
