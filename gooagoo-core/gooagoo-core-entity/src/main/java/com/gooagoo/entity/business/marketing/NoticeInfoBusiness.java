package com.gooagoo.entity.business.marketing;

import java.io.Serializable;

/**
 *  通知 
 */
public class NoticeInfoBusiness implements Serializable
{

    private static final long serialVersionUID = 1L;

    /** 是否已读  */
    private String isread = "";
    /**  营销内容与用户关联ID  */
    private String marketingUserLinkId = "";
    /**  分页编号  */
    private String pageId = "";
    /**  营销内容关联编号  */
    private String marketingLinkId = "";
    /**  营销内容关联类型  */
    private String marketingLinkType = "";
    /**  通知编号  */
    private String noticeInfoId = "";
    /**  通知标题 */
    private String noticeTitle = "";
    /**  图片*/
    private String img = "";
    /**  具体内容（手机）*/
    private String noticeTextMobile = "";
    /**  具体内容（网站）  */
    private String noticeTextWeb = "";
    /**  最后一次修改时间(取自marketing_item_link)  */
    private String cTimeStamp = "";
    /**  是否删除(取自marketing_item_link)  */
    private String isdel = "";
    /**  商家编号  */
    private String shopId = "";
    /**  商家名称  */
    private String shopName = "";
    /**  商家logo1，正方形  */
    private String logo1 = "";
    /**  商家logo2，长方形  */
    private String logo2 = "";
    /**  推送时间  */
    private String pushTime = "";

    public String getPageId()
    {
        return this.pageId;
    }

    public void setPageId(String pageId)
    {
        this.pageId = pageId;
    }

    public String getMarketingUserLinkId()
    {
        return this.marketingUserLinkId;
    }

    public void setMarketingUserLinkId(String marketingUserLinkId)
    {
        this.marketingUserLinkId = marketingUserLinkId;
    }

    public String getMarketingLinkId()
    {
        return this.marketingLinkId;
    }

    public void setMarketingLinkId(String marketingLinkId)
    {
        this.marketingLinkId = marketingLinkId;
    }

    public String getMarketingLinkType()
    {
        return this.marketingLinkType;
    }

    public void setMarketingLinkType(String marketingLinkType)
    {
        this.marketingLinkType = marketingLinkType;
    }

    public String getNoticeInfoId()
    {
        return this.noticeInfoId;
    }

    public void setNoticeInfoId(String noticeInfoId)
    {
        this.noticeInfoId = noticeInfoId;
    }

    public String getNoticeTitle()
    {
        return this.noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle)
    {
        this.noticeTitle = noticeTitle;
    }

    public String getImg()
    {
        return this.img;
    }

    public void setImg(String img)
    {
        this.img = img;
    }

    public String getNoticeTextMobile()
    {
        return this.noticeTextMobile;
    }

    public void setNoticeTextMobile(String noticeTextMobile)
    {
        this.noticeTextMobile = noticeTextMobile;
    }

    public String getNoticeTextWeb()
    {
        return this.noticeTextWeb;
    }

    public void setNoticeTextWeb(String noticeTextWeb)
    {
        this.noticeTextWeb = noticeTextWeb;
    }

    public String getcTimeStamp()
    {
        return this.cTimeStamp;
    }

    public void setcTimeStamp(String cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    public String getIsdel()
    {
        return this.isdel;
    }

    public void setIsdel(String isdel)
    {
        this.isdel = isdel;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getShopName()
    {
        return this.shopName;
    }

    public void setShopName(String shopName)
    {
        this.shopName = shopName;
    }

    public String getLogo1()
    {
        return this.logo1;
    }

    public void setLogo1(String logo1)
    {
        this.logo1 = logo1;
    }

    public String getLogo2()
    {
        return this.logo2;
    }

    public void setLogo2(String logo2)
    {
        this.logo2 = logo2;
    }

    public String getPushTime()
    {
        return this.pushTime;
    }

    public void setPushTime(String pushTime)
    {
        this.pushTime = pushTime;
    }

    public String getIsread()
    {
        return this.isread;
    }

    public void setIsread(String isread)
    {
        this.isread = isread;
    }

    @Override
    public String toString()
    {
        return "NoticeInfoBusiness [isread=" + this.isread + ", marketingUserLinkId=" + this.marketingUserLinkId + ", pageId=" + this.pageId + ", marketingLinkId=" + this.marketingLinkId + ", marketingLinkType=" + this.marketingLinkType + ", noticeInfoId=" + this.noticeInfoId + ", noticeTitle=" + this.noticeTitle + ", img=" + this.img + ", noticeTextMobile=" + this.noticeTextMobile + ", noticeTextWeb=" + this.noticeTextWeb + ", cTimeStamp=" + this.cTimeStamp + ", isdel=" + this.isdel + ", shopId=" + this.shopId + ", shopName=" + this.shopName + ", logo1=" + this.logo1 + ", logo2=" + this.logo2 + ", pushTime=" + this.pushTime + "]";
    }

}