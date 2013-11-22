package com.gooagoo.cache.entity;

import java.io.Serializable;

public class DicImageCache implements Serializable
{

    private static final long serialVersionUID = 7055261412154865892L;

    private String id;
    private String name;
    private String frontPic;
    private String backPic;
    private String parentId;

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getFrontPic()
    {
        return this.frontPic;
    }

    public void setFrontPic(String frontPic)
    {
        this.frontPic = frontPic;
    }

    public String getBackPic()
    {
        return this.backPic;
    }

    public void setBackPic(String backPic)
    {
        this.backPic = backPic;
    }

    public String getParentId()
    {
        return parentId;
    }

    public void setParentId(String parentId)
    {
        this.parentId = parentId;
    }
}
