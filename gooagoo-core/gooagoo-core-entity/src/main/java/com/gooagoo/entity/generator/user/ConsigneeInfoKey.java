package com.gooagoo.entity.generator.user;

import java.io.Serializable;

/**
 * 收货人信息
 */

public class ConsigneeInfoKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String consigneeId;//收货人信息编号，UUID

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getConsigneeId()
    {
        return consigneeId;
    }

    public void setConsigneeId(String consigneeId)
    {
        this.consigneeId = consigneeId;
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
