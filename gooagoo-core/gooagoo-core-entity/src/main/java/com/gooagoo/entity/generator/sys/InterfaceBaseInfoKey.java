package com.gooagoo.entity.generator.sys;

import java.io.Serializable;

/**
 * 接口基础信息表
 */

public class InterfaceBaseInfoKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String iCode;//接口编码，由3位系统编码、1位功能编码、2位自增长数字组成

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getICode()
    {
        return iCode;
    }

    public void setICode(String iCode)
    {
        this.iCode = iCode;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

}
