package com.gooagoo.entity.generator.sys;

import java.io.Serializable;

/**
 * 接口请求参数信息表
 */

public class InterfaceRequestInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Integer id;//自动编号

    private String iCode;//接口编码，由3位系统编码、1位功能编码、2位自增长数字组成

    private String nameEn;//参数英文名称

    private String nameCn;//参数中文名称

    private String isRequired;//是否必填，Y-必填，N-非必填

    private String note;//备注，比如约束条件、枚举值

    public Integer getId()
    {
        return this.id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getICode()
    {
        return this.iCode;
    }

    public void setICode(String iCode)
    {
        this.iCode = iCode;
    }

    public String getNameEn()
    {
        return this.nameEn;
    }

    public void setNameEn(String nameEn)
    {
        this.nameEn = nameEn;
    }

    public String getNameCn()
    {
        return this.nameCn;
    }

    public void setNameCn(String nameCn)
    {
        this.nameCn = nameCn;
    }

    public String getIsRequired()
    {
        return this.isRequired;
    }

    public void setIsRequired(String isRequired)
    {
        this.isRequired = isRequired;
    }

    public String getNote()
    {
        return this.note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    @Override
    public String toString()
    {
        return this.id + "^" + this.iCode + "^" + this.nameEn + "^" + this.nameCn + "^" + this.isRequired + "^" + this.note;
    }
}