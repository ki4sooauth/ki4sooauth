package com.gooagoo.view.gus.web.cryout;

import java.io.Serializable;
import java.util.Date;

import com.gooagoo.view.gus.common.Image;

public class UCryout implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String shopId;//商家ID

    private String shopName;//商家名称

    private String shopVisitUrl;//商家访问地址

    private Image headPic;//商家头像

    private String userLinkId;//与用户关联ID

    private String cryoutId;//吆喝ID

    private String cryoutTitle;//吆喝标题

    private String cryoutContent;//吆喝内容

    private String cryoutContentType;//吆喝内容类型

    private String cryoutContentTypeId;//吆喝内容类型ID

    private String contentVisitUrl;//吆喝关联内容访问地址

    private Image cryoutImage;//吆喝图片

    private Date cryoutTime;//吆喝时间

    private String pageId;//推送时间+营销内容与用户关联表主键  

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

    public String getShopVisitUrl()
    {
        return this.shopVisitUrl;
    }

    public void setShopVisitUrl(String shopVisitUrl)
    {
        this.shopVisitUrl = shopVisitUrl;
    }

    public Image getHeadPic()
    {
        return this.headPic;
    }

    public void setHeadPic(Image headPic)
    {
        this.headPic = headPic;
    }

    public String getUserLinkId()
    {
        return this.userLinkId;
    }

    public void setUserLinkId(String userLinkId)
    {
        this.userLinkId = userLinkId;
    }

    public String getCryoutId()
    {
        return this.cryoutId;
    }

    public void setCryoutId(String cryoutId)
    {
        this.cryoutId = cryoutId;
    }

    public String getCryoutTitle()
    {
        return this.cryoutTitle;
    }

    public void setCryoutTitle(String cryoutTitle)
    {
        this.cryoutTitle = cryoutTitle;
    }

    public String getCryoutContent()
    {
        return this.cryoutContent;
    }

    public void setCryoutContent(String cryoutContent)
    {
        this.cryoutContent = cryoutContent;
    }

    public String getCryoutContentType()
    {
        return this.cryoutContentType;
    }

    public void setCryoutContentType(String cryoutContentType)
    {
        this.cryoutContentType = cryoutContentType;
    }

    public String getCryoutContentTypeId()
    {
        return this.cryoutContentTypeId;
    }

    public void setCryoutContentTypeId(String cryoutContentTypeId)
    {
        this.cryoutContentTypeId = cryoutContentTypeId;
    }

    public String getContentVisitUrl()
    {
        return this.contentVisitUrl;
    }

    public void setContentVisitUrl(String contentVisitUrl)
    {
        this.contentVisitUrl = contentVisitUrl;
    }

    public Image getCryoutImage()
    {
        return this.cryoutImage;
    }

    public void setCryoutImage(Image cryoutImage)
    {
        this.cryoutImage = cryoutImage;
    }

    public Date getCryoutTime()
    {
        return this.cryoutTime;
    }

    public void setCryoutTime(Date cryoutTime)
    {
        this.cryoutTime = cryoutTime;
    }

}
