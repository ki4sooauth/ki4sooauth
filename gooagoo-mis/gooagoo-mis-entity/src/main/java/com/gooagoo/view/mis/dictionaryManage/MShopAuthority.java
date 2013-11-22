package com.gooagoo.view.mis.dictionaryManage;

import java.util.Date;
import java.io.Serializable;

/**
 * 商家管理权限表
 */
public class MShopAuthority implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String authorityId;//权限ID

    private String authorityName;//权限名称

    private String parentAuthorityId;//父权限ID

    private String link;//链接

    private Integer orderNo;//排序编号

    private String note;//备注，对于创建和编辑，链接中保存的是展示页面的链接，备注中保存的是功能的链接

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getAuthorityId()
    {
        return authorityId;
    }

    public void setAuthorityId(String authorityId)
    {
        this.authorityId = authorityId;
    }

    public String getAuthorityName()
    {
        return authorityName;
    }

    public void setAuthorityName(String authorityName)
    {
        this.authorityName = authorityName;
    }

    public String getParentAuthorityId()
    {
        return parentAuthorityId;
    }

    public void setParentAuthorityId(String parentAuthorityId)
    {
        this.parentAuthorityId = parentAuthorityId;
    }

    public String getLink()
    {
        return link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }

    public Integer getOrderNo()
    {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo)
    {
        this.orderNo = orderNo;
    }

    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getcTimeStamp()
    {
        return cTimeStamp;
    }

    public void setcTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    public String toString()
    {
        return this.authorityId + "^" + this.authorityName + "^" + this.parentAuthorityId + "^" + this.link + "^" + this.orderNo + "^" + this.note + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
