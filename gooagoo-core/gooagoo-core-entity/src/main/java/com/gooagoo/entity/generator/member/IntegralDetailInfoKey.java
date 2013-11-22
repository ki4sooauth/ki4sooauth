package com.gooagoo.entity.generator.member;

import java.io.Serializable;

/**
 * 积分明细表
 */

public class IntegralDetailInfoKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String integralId;//积分明细编号，UUID

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
