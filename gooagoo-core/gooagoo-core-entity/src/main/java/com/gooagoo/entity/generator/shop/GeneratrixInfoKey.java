package com.gooagoo.entity.generator.shop;

import java.io.Serializable;

/**
 * 动线信息
 */

public class GeneratrixInfoKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String generatrixId;//动线编号

    public String getGeneratrixId()
    {
        return generatrixId;
    }

    public void setGeneratrixId(String generatrixId)
    {
        this.generatrixId = generatrixId;
    }

}
