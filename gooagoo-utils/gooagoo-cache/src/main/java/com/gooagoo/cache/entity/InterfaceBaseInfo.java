package com.gooagoo.cache.entity;

import java.io.Serializable;

/**
 * 接口基础信息表
 */

public class InterfaceBaseInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String iCode;//接口编码，由3位系统编码、1位功能编码、2位自增长数字组成

    private String iName;//接口名称

    private String iUrl;//接口地址

    private String behaveType;//行为类型，如对应不上，则为空，参考通用字典表的behave_type

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
}
