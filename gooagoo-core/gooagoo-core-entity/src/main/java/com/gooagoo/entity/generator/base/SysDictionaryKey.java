package com.gooagoo.entity.generator.base;

import java.io.Serializable;

/**
 * 通用字典表，包括性别、证件类型、转发器型号、信息来源、行为类型
 */

public class SysDictionaryKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Integer sysDictionaryId;//自动编号，自增长

    private String isDel;//是否删除，Y-已删除，N-未删除

    public Integer getSysDictionaryId()
    {
        return sysDictionaryId;
    }

    public void setSysDictionaryId(Integer sysDictionaryId)
    {
        this.sysDictionaryId = sysDictionaryId;
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
