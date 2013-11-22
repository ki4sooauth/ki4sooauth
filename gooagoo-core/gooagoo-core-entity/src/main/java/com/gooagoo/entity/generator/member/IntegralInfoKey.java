package com.gooagoo.entity.generator.member;

import java.io.Serializable;

/**
 * 积分汇总表，通过对积分详细表的数据分析得出
 */

public class IntegralInfoKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String integralId;//积分编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getIntegralId()
    {
        return integralId;
    }

    public void setIntegralId(String integralId)
    {
        this.integralId = integralId;
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
