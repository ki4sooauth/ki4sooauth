package com.gooagoo.view.gms.shopinfo;

import java.io.Serializable;

/**
 * 权限表，由数据库管理员维护，只有在新增功能时才有可能变动
 */

public class FShopAuthority implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String authorityId;//权限ID

    private String authorityName;//权限名称

    private String link;//链接

    private String parentAuthorityId;//父权限ID

    private String note; //备注

    private boolean isUserOwn = false;//是否是用户拥有的

    public String getNote()
    {
        return this.note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public String getAuthorityId()
    {
        return this.authorityId;
    }

    public String getAuthorityName()
    {
        return this.authorityName;
    }

    public String getLink()
    {
        return this.link;
    }

    public String getParentAuthorityId()
    {
        return this.parentAuthorityId;
    }

    public void setAuthorityId(String authorityId)
    {
        this.authorityId = authorityId;
    }

    public void setAuthorityName(String authorityName)
    {
        this.authorityName = authorityName;
    }

    public void setLink(String link)
    {
        this.link = link;
    }

    public void setParentAuthorityId(String parentAuthorityId)
    {
        this.parentAuthorityId = parentAuthorityId;
    }

    public boolean isUserOwn()
    {
        return this.isUserOwn;
    }

    public void setUserOwn(boolean isUserOwn)
    {
        this.isUserOwn = isUserOwn;
    }

    @Override
    public String toString()
    {
        return "FShopAuthority [authorityId=" + this.authorityId + ", authorityName=" + this.authorityName + ", link=" + this.link + ", parentAuthorityId=" + this.parentAuthorityId + ", note=" + this.note + "]";
    }
}
