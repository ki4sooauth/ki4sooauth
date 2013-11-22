package com.gooagoo.entity.casclient.shop;

import java.io.Serializable;

/**
 * 商家用户权限
 */
public class ShopAuth implements Serializable
{

    private static final long serialVersionUID = 1L;

    private boolean isUserOwn = false;//是否是商家登录用户所拥有的权限

    private String authorityId;//权限ID

    private String authorityName;//权限名称

    private String parentAuthorityId;//父权限ID

    private String link;//链接

    private Integer orderNo;//排序编号

    private String note;//备注，对于创建和编辑，链接中保存的是展示页面的链接，备注中保存的是功能的链接

    public boolean isUserOwn()
    {
        return this.isUserOwn;
    }

    public void setUserOwn(boolean isUserOwn)
    {
        this.isUserOwn = isUserOwn;
    }

    public String getAuthorityId()
    {
        return this.authorityId;
    }

    public void setAuthorityId(String authorityId)
    {
        this.authorityId = authorityId;
    }

    public String getAuthorityName()
    {
        return this.authorityName;
    }

    public void setAuthorityName(String authorityName)
    {
        this.authorityName = authorityName;
    }

    public String getParentAuthorityId()
    {
        return this.parentAuthorityId;
    }

    public void setParentAuthorityId(String parentAuthorityId)
    {
        this.parentAuthorityId = parentAuthorityId;
    }

    public String getLink()
    {
        return this.link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }

    public Integer getOrderNo()
    {
        return this.orderNo;
    }

    public void setOrderNo(Integer orderNo)
    {
        this.orderNo = orderNo;
    }

    public String getNote()
    {
        return this.note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

}
