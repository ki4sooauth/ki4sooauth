package com.gooagoo.entity.generator.sys;

import java.io.Serializable;
import java.util.Date;

/**
 * 接口基础信息表
 */

public class InterfaceBaseInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String iCode;//接口编码，由3位系统编码、1位功能编码、2位自增长数字组成

    private String iName;//接口名称

    private String iType;//接口类型，中文描述，如手机接口系统

    private String iFunction;//功能分类，指接口系统中的大分类，如手机接口系统分为5大功能：卡包、收藏、吆喝、购物计划、消费账单

    private String iUrl;//接口地址

    private String behaveType;//行为类型，如对应不上，则为空，参考通用字典表的behave_type

    private String canAllocate;//是否可分配，Y-是，N-否，只有在商家独立部署的时候才能分配

    private String dataXml;//报文示例（XMl）URL

    private String dataJson;//报文示例（JSON）URL

    private String note;//业务逻辑说明URL

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getICode()
    {
        return this.iCode;
    }

    public void setICode(String iCode)
    {
        this.iCode = iCode;
    }

    public String getIName()
    {
        return this.iName;
    }

    public void setIName(String iName)
    {
        this.iName = iName;
    }

    public String getIType()
    {
        return this.iType;
    }

    public void setIType(String iType)
    {
        this.iType = iType;
    }

    public String getIFunction()
    {
        return this.iFunction;
    }

    public void setIFunction(String iFunction)
    {
        this.iFunction = iFunction;
    }

    public String getIUrl()
    {
        return this.iUrl;
    }

    public void setIUrl(String iUrl)
    {
        this.iUrl = iUrl;
    }

    public String getBehaveType()
    {
        return this.behaveType;
    }

    public void setBehaveType(String behaveType)
    {
        this.behaveType = behaveType;
    }

    public String getCanAllocate()
    {
        return this.canAllocate;
    }

    public void setCanAllocate(String canAllocate)
    {
        this.canAllocate = canAllocate;
    }

    public String getDataXml()
    {
        return this.dataXml;
    }

    public void setDataXml(String dataXml)
    {
        this.dataXml = dataXml;
    }

    public String getDataJson()
    {
        return this.dataJson;
    }

    public void setDataJson(String dataJson)
    {
        this.dataJson = dataJson;
    }

    public String getNote()
    {
        return this.note;
    }

    public void setNote(String note)
    {
        this.note = note;
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
        return this.iCode + "^" + this.iName + "^" + this.iType + "^" + this.iFunction + "^" + this.iUrl + "^" + this.behaveType + "^" + this.canAllocate + "^" + this.dataXml + "^" + this.dataJson + "^" + this.note + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
