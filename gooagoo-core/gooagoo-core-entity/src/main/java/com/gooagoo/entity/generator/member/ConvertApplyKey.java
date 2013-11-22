package com.gooagoo.entity.generator.member;

import java.io.Serializable;

/**
 * 物理卡转换申请
 */

public class ConvertApplyKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String applicationId;//申请编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getApplicationId()
    {
        return applicationId;
    }

    public void setApplicationId(String applicationId)
    {
        this.applicationId = applicationId;
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
