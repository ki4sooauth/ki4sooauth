package com.gooagoo.view.gus.common;

import java.io.Serializable;

/**
 * 图片信息
 * @author GUS
 *
 */
public class Image implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String imgUrl;//原图URL

    private String bigImgUrl;//大图URL

    private String middleImgUrl;//中图URL

    private String smallImgUrl;//小图URL

    public String getImgUrl()
    {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }

    public String getBigImgUrl()
    {
        return bigImgUrl;
    }

    public void setBigImgUrl(String bigImgUrl)
    {
        this.bigImgUrl = bigImgUrl;
    }

    public String getMiddleImgUrl()
    {
        return middleImgUrl;
    }

    public void setMiddleImgUrl(String middleImgUrl)
    {
        this.middleImgUrl = middleImgUrl;
    }

    public String getSmallImgUrl()
    {
        return smallImgUrl;
    }

    public void setSmallImgUrl(String smallImgUrl)
    {
        this.smallImgUrl = smallImgUrl;
    }

}
