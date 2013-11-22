package com.gooagoo.entity.business.marketing.activity;

import java.io.Serializable;

/**
 *  活动列表 
 */
public class ActivityBusiness implements Serializable
{

    private static final long serialVersionUID = 1L;

    /** 活动编号  */
    private String activityid = "";

    /** 活动商家类型，根据发布活动的商家类型区分  */
    private String activityshoptype = "";

    /** 商家编号  */
    private String shopid = "";

    /** 商家名称  */
    private String shopname = "";

    /** 活动名称  */
    private String activityname = "";

    /** 活动主题  */
    private String title = "";

    /** 活动开始时间  */
    private String starttime = "";

    /** 活动结束时间  */
    private String endtime = "";

    /** 活动图片URL  */
    private String imgurl = "";

    /** 活动地址URL  */
    private String activityurl = "";

    /** 活动内容  */
    private String content = "";

    /** 活动目的  */
    private String purpose = "";

    /** 活动描述  */
    private String description = "";

    /**
     * 设置活动编号 
     * @param activityid	活动编号 
     */
    public void setActivityid(String activityid)
    {
        this.activityid = activityid;
    }

    /**
     * 获取活动编号 
     * @return	活动编号 
     */
    public String getActivityid()
    {
        return this.activityid;
    }

    /**
     * 设置活动商家类型，根据发布活动的商家类型区分 
     * @param activityshoptype	活动商家类型，根据发布活动的商家类型区分 
     */
    public void setActivityshoptype(String activityshoptype)
    {
        this.activityshoptype = activityshoptype;
    }

    /**
     * 获取活动商家类型，根据发布活动的商家类型区分 
     * @return	活动商家类型，根据发布活动的商家类型区分 
     */
    public String getActivityshoptype()
    {
        return this.activityshoptype;
    }

    /**
     * 设置商家编号 
     * @param shopid	商家编号 
     */
    public void setShopid(String shopid)
    {
        this.shopid = shopid;
    }

    /**
     * 获取商家编号 
     * @return	商家编号 
     */
    public String getShopid()
    {
        return this.shopid;
    }

    /**
     * 设置活动名称 
     * @param activityname	活动名称 
     */
    public void setActivityname(String activityname)
    {
        this.activityname = activityname;
    }

    /**
     * 获取活动名称 
     * @return	活动名称 
     */
    public String getActivityname()
    {
        return this.activityname;
    }

    /**
     * 设置活动主题 
     * @param title	活动主题 
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * 获取活动主题 
     * @return	活动主题 
     */
    public String getTitle()
    {
        return this.title;
    }

    /**
     * 设置活动开始时间 
     * @param starttime	活动开始时间 
     */
    public void setStarttime(String starttime)
    {
        this.starttime = starttime;
    }

    /**
     * 获取活动开始时间 
     * @return	活动开始时间 
     */
    public String getStarttime()
    {
        return this.starttime;
    }

    /**
     * 设置活动结束时间 
     * @param endtime	活动结束时间 
     */
    public void setEndtime(String endtime)
    {
        this.endtime = endtime;
    }

    /**
     * 获取活动结束时间 
     * @return	活动结束时间 
     */
    public String getEndtime()
    {
        return this.endtime;
    }

    /**
     * 设置活动图片URL 
     * @param imgurl	活动图片URL 
     */
    public void setImgurl(String imgurl)
    {
        this.imgurl = imgurl;
    }

    /**
     * 获取活动图片URL 
     * @return	活动图片URL 
     */
    public String getImgurl()
    {
        return this.imgurl;
    }

    /**
     * 设置活动地址URL 
     * @param activityurl	活动地址URL 
     */
    public void setActivityurl(String activityurl)
    {
        this.activityurl = activityurl;
    }

    /**
     * 获取活动地址URL 
     * @return	活动地址URL 
     */
    public String getActivityurl()
    {
        return this.activityurl;
    }

    /**
     * 设置活动内容 
     * @param content	活动内容 
     */
    public void setContent(String content)
    {
        this.content = content;
    }

    /**
     * 获取活动内容 
     * @return	活动内容 
     */
    public String getContent()
    {
        return this.content;
    }

    /**
     * 设置活动目的 
     * @param purpose	活动目的 
     */
    public void setPurpose(String purpose)
    {
        this.purpose = purpose;
    }

    /**
     * 获取活动目的 
     * @return	活动目的 
     */
    public String getPurpose()
    {
        return this.purpose;
    }

    /**
     * 设置活动描述 
     * @param description	活动描述 
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * 获取活动描述 
     * @return	活动描述 
     */
    public String getDescription()
    {
        return this.description;
    }

    /**
     * 获取商家名称
     * @param  商家名称 
     */
    public String getShopname()
    {
        return this.shopname;
    }

    /**
     * 设置商家名称
     * @return  商家名称 
     */
    public void setShopname(String shopname)
    {
        this.shopname = shopname;
    }

}