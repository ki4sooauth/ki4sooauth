package com.gooagoo.entity.generator.behave;

import java.io.Serializable;
import java.util.Date;

/**
 * 购物清单主表
 */

public class UserShoppingPlan implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String shoppingListId;//购物清单编号，UUID

    private String userId;//用户编号

    private String title;//购物清单标题

    private Date preShoppingTime;//预计购物时间

    private String infoSource;//信息来源，参考通用字典表的info_source

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getShoppingListId()
    {
        return this.shoppingListId;
    }

    public void setShoppingListId(String shoppingListId)
    {
        this.shoppingListId = shoppingListId;
    }

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getTitle()
    {
        return this.title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Date getPreShoppingTime()
    {
        return this.preShoppingTime;
    }

    public void setPreShoppingTime(Date preShoppingTime)
    {
        this.preShoppingTime = preShoppingTime;
    }

    public String getInfoSource()
    {
        return this.infoSource;
    }

    public void setInfoSource(String infoSource)
    {
        this.infoSource = infoSource;
    }

    public String getIsDel()
    {
        return this.isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getCTimeStamp()
    {
        return this.cTimeStamp;
    }

    public void setCTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    @Override
    public String toString()
    {
        return this.shoppingListId + "^" + this.userId + "^" + this.title + "^" + this.preShoppingTime + "^" + this.infoSource + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
