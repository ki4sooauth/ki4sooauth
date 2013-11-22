package com.gooagoo.entity.business.transaction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 优惠凭证使用条件json实体
 * 使用校验信息，校验json串，支持品类、实体店、会员等级
 * 接口gasl05:结账申请，用到该实体转换json串为对象，校验优惠凭证使用条件
 */
public class CouponRuleJson implements Serializable
{
    private static final long serialVersionUID = 1L;

    private List<String> categoryData = new ArrayList<String>(); //品类编码

    private List<String> shopEntityData = new ArrayList<String>(); //实体店ID

    private List<String> vipGradeData = new ArrayList<String>(); //会员等级ID

    private List<String> categoryNames = new ArrayList<String>(); //品类名称

    private List<String> shopEntityNames = new ArrayList<String>(); //实体店名称

    private List<String> vipGradeNames = new ArrayList<String>(); //会员等级名称

    /**
     * 品类编码
     * @return
     */
    public List<String> getCategoryData()
    {
        return this.categoryData;
    }

    /**
     * 品类编码
     * @return
     */
    public void setCategoryData(List<String> categoryData)
    {
        this.categoryData = categoryData;
    }

    /**
     * 实体店ID
     * @return
     */
    public List<String> getShopEntityData()
    {
        return this.shopEntityData;
    }

    /**
     * 实体店ID
     * @return
     */
    public void setShopEntityData(List<String> shopEntityData)
    {
        this.shopEntityData = shopEntityData;
    }

    /**
     * 会员等级ID
     * @return
     */
    public List<String> getVipGradeData()
    {
        return this.vipGradeData;
    }

    /**
     * 会员等级ID
     * @return
     */
    public void setVipGradeData(List<String> vipGradeData)
    {
        this.vipGradeData = vipGradeData;
    }

    /**
     * 品类名称
     * @return
     */
    public List<String> getCategoryNames()
    {
        return this.categoryNames;
    }

    /**
     * 品类名称
     * @return
     */
    public void setCategoryNames(List<String> categoryNames)
    {
        this.categoryNames = categoryNames;
    }

    /**
     * 实体店名称
     * @return
     */
    public List<String> getShopEntityNames()
    {
        return this.shopEntityNames;
    }

    /**
     * 实体店名称
     * @return
     */
    public void setShopEntityNames(List<String> shopEntityNames)
    {
        this.shopEntityNames = shopEntityNames;
    }

    /**
     * 会员等级名称
     * @return
     */
    public List<String> getVipGradeNames()
    {
        return this.vipGradeNames;
    }

    /**
     * 会员等级名称
     * @return
     */
    public void setVipGradeNames(List<String> vipGradeNames)
    {
        this.vipGradeNames = vipGradeNames;
    }

}
