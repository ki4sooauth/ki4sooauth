package com.gooagoo.view.gms.shopinfo;

import java.io.Serializable;

public class FHeadPic implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String shImg;//店铺原图
    private String shSmallImg;//店铺小图

    private String suImg;//账户头像原图
    private String suSmallImg;//账户头像小图

    public String getSuImg()
    {
        return this.suImg;
    }

    public void setSuImg(String suImg)
    {
        this.suImg = suImg;
    }

    public String getSuSmallImg()
    {
        return this.suSmallImg;
    }

    public void setSuSmallImg(String suSmallImg)
    {
        this.suSmallImg = suSmallImg;
    }

    public String getShImg()
    {
        return this.shImg;
    }

    public String getShSmallImg()
    {
        return this.shSmallImg;
    }

    public void setShImg(String shImg)
    {
        this.shImg = shImg;
    }

    public void setShSmallImg(String shSmallImg)
    {
        this.shSmallImg = shSmallImg;
    }
}
