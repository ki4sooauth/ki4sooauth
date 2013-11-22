package com.gooagoo.view.gus.web.notice;

import java.io.Serializable;
import java.util.Date;

import com.gooagoo.view.gus.common.Image;

public class UNoticeInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String shopId;//商家id
    private String shopName;//商家名称
    private String title;//标题
    private String pageId = "";
    private String contentWeb;//通知内容
    private String infoType;//通知内容类型，A-活动，G-商品，C-优惠券，P-其他
    private Image thumbnailPic;////通知的图片
    private Date pushTime;//时间
    private String id;//关联表id
    private String picHerf;//商家id
    private String noticeId;//通知id
    private String objectId;//营销id

    public String getPageId()
    {
        return this.pageId;
    }

    public void setPageId(String pageId)
    {
        this.pageId = pageId;
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

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getContentWeb()
    {
        return this.contentWeb;
    }

    public void setContentWeb(String contentWeb)
    {
        this.contentWeb = contentWeb;
    }

    public String getInfoType()
    {
        return this.infoType;
    }

    public void setInfoType(String infoType)
    {
        this.infoType = infoType;
    }

    public Image getThumbnailPic()
    {
        return this.thumbnailPic;
    }

    public void setThumbnailPic(Image thumbnailPic)
    {
        this.thumbnailPic = thumbnailPic;
    }

    public Date getPushTime()
    {
        return this.pushTime;
    }

    public void setPushTime(Date pushTime)
    {
        this.pushTime = pushTime;
    }

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getPicHerf()
    {
        return this.picHerf;
    }

    public void setPicHerf(String picHerf)
    {
        this.picHerf = picHerf;
    }

    public String getNoticeId()
    {
        return this.noticeId;
    }

    public void setNoticeId(String noticeId)
    {
        this.noticeId = noticeId;
    }

    public String getObjectId()
    {
        return this.objectId;
    }

    public void setObjectId(String objectId)
    {
        this.objectId = objectId;
    }

}
