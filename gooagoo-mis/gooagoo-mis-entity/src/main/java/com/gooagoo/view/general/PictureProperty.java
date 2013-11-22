package com.gooagoo.view.general;

import java.io.Serializable;

/**
 * 图片信息
 * @author GOOAGOO
 *
 */
public class PictureProperty implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String name;
    private String src;
    private int width;
    private int height;

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSrc()
    {
        return this.src;
    }

    public void setSrc(String src)
    {
        this.src = src;
    }

    public int getWidth()
    {
        return this.width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return this.height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

}
