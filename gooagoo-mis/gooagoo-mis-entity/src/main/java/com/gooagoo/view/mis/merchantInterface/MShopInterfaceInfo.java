package com.gooagoo.view.mis.merchantInterface;

import java.io.Serializable;
import java.util.Date;

/**
 * 商家接口地址分配
 */

public class MShopInterfaceInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//自动编号，UUID

    private String shopId;//商家编码

    private String iCode;//接口编码

    private String iUrl;//接口地址

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    private Date createTime_F;//创建时间，用于按时间查询，如果此字段有值，可查询出>此字段值的记录

    private Date createTime_T;//创建时间，用于按时间查询，如果此字段有值，可查询出<此字段值的记录

    private Date createTime_FE;//创建时间，用于按时间查询，如果此字段有值，可查询出>=此字段值的记录

    private Date createTime_TE;//创建时间，用于按时间查询，如果此字段有值，可查询出<=此字段值的记录

    private Date cTimeStamp_F;//最后一次修改时间，用于按时间查询，如果此字段有值，可查询出>此字段值的记录

    private Date cTimeStamp_T;//最后一次修改时间，用于按时间查询，如果此字段有值，可查询出<此字段值的记录

    private Date cTimeStamp_FE;//最后一次修改时间，用于按时间查询，如果此字段有值，可查询出>=此字段值的记录

    private Date cTimeStamp_TE;//最后一次修改时间，用于按时间查询，如果此字段有值，可查询出<=此字段值的记录

    private String iName;//接口编码（用于页面展示）

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getShopId()
    {
        return shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getiCode()
    {
        return iCode;
    }

    public void setiCode(String iCode)
    {
        this.iCode = iCode;
    }

    public String getiUrl()
    {
        return iUrl;
    }

    public void setiUrl(String iUrl)
    {
        this.iUrl = iUrl;
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

    public Date getCreateTime_F()
    {
        return createTime_F;
    }

    public void setCreateTime_F(Date createTime_F)
    {
        this.createTime_F = createTime_F;
    }

    public Date getCreateTime_T()
    {
        return createTime_T;
    }

    public void setCreateTime_T(Date createTime_T)
    {
        this.createTime_T = createTime_T;
    }

    public Date getCreateTime_FE()
    {
        return createTime_FE;
    }

    public void setCreateTime_FE(Date createTime_FE)
    {
        this.createTime_FE = createTime_FE;
    }

    public Date getCreateTime_TE()
    {
        return createTime_TE;
    }

    public void setCreateTime_TE(Date createTime_TE)
    {
        this.createTime_TE = createTime_TE;
    }

    public Date getcTimeStamp_F()
    {
        return cTimeStamp_F;
    }

    public void setcTimeStamp_F(Date cTimeStamp_F)
    {
        this.cTimeStamp_F = cTimeStamp_F;
    }

    public Date getcTimeStamp_T()
    {
        return cTimeStamp_T;
    }

    public void setcTimeStamp_T(Date cTimeStamp_T)
    {
        this.cTimeStamp_T = cTimeStamp_T;
    }

    public Date getcTimeStamp_FE()
    {
        return cTimeStamp_FE;
    }

    public void setcTimeStamp_FE(Date cTimeStamp_FE)
    {
        this.cTimeStamp_FE = cTimeStamp_FE;
    }

    public Date getcTimeStamp_TE()
    {
        return cTimeStamp_TE;
    }

    public void setcTimeStamp_TE(Date cTimeStamp_TE)
    {
        this.cTimeStamp_TE = cTimeStamp_TE;
    }

    public String getiName()
    {
        return iName;
    }

    public void setiName(String iName)
    {
        this.iName = iName;
    }

    public String toString()
    {
        return this.id + "^" + this.shopId + "^" + this.iCode + "^" + this.iUrl + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
