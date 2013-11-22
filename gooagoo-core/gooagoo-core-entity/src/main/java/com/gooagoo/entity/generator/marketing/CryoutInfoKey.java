package com.gooagoo.entity.generator.marketing;

import java.io.Serializable;

/**
 * 吆喝信息表
 */

public class CryoutInfoKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String cryoutInfoId;//吆喝编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getCryoutInfoId()
    {
        return cryoutInfoId;
    }

    public void setCryoutInfoId(String cryoutInfoId)
    {
        this.cryoutInfoId = cryoutInfoId;
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
