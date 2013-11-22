package com.gooagoo.view.gus.web.common;

import java.io.Serializable;

import com.gooagoo.view.gus.common.Image;

public class URecommendActive implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String activeId;//活动ID

    private String activeVisitUrl;//活动访问地址

    private String activeName;//活动名称

    private Image activeImage;//活动图片URL

    public String getActiveId()
    {
        return activeId;
    }

    public void setActiveId(String activeId)
    {
        this.activeId = activeId;
    }

    public String getActiveVisitUrl()
    {
        return activeVisitUrl;
    }

    public void setActiveVisitUrl(String activeVisitUrl)
    {
        this.activeVisitUrl = activeVisitUrl;
    }

    public String getActiveName()
    {
        return activeName;
    }

    public void setActiveName(String activeName)
    {
        this.activeName = activeName;
    }

    public Image getActiveImage()
    {
        return activeImage;
    }

    public void setActiveImage(Image activeImage)
    {
        this.activeImage = activeImage;
    }

}
