package com.gooagoo.entity.generator.user;

import java.io.Serializable;

/**
 * 产品序列号信息
 */

public class ProductSerialNumberKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String gooagooId;//产品序列号，UUID

    public String getGooagooId()
    {
        return gooagooId;
    }

    public void setGooagooId(String gooagooId)
    {
        this.gooagooId = gooagooId;
    }

}
