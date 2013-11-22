package com.gooagoo.view.mis.dictionaryManage;

import java.io.Serializable;

/**
 * 接口请求参数信息表
 */
public class MInterfaceRequestInfo implements Serializable
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
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getiCode()
    {
        return iCode;
    }

    public void setiCode(String iCode)
    {
        this.iCode = iCode;
    }

    public String getNameEn()
    {
        return nameEn;
    }

    public void setNameEn(String nameEn)
    {
        this.nameEn = nameEn;
    }

    public String getNameCn()
    {
        return nameCn;
    }

    public void setNameCn(String nameCn)
    {
        this.nameCn = nameCn;
    }

    public String getIsRequired()
    {
        return isRequired;
    }

    public void setIsRequired(String isRequired)
    {
        this.isRequired = isRequired;
    }

    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public String toString()
    {
        return this.id + "^" + this.iCode + "^" + this.nameEn + "^" + this.nameCn + "^" + this.isRequired + "^" + this.note;
    }
}
