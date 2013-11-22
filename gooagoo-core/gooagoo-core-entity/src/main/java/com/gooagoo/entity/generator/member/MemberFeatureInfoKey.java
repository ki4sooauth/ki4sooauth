package com.gooagoo.entity.generator.member;

import java.io.Serializable;

/**
 * 会员特征信息
 */

public class MemberFeatureInfoKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//自动编号

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
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
