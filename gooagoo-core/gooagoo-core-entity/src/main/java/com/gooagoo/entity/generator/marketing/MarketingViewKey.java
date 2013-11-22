package com.gooagoo.entity.generator.marketing;

import java.io.Serializable;

/**
 * VIEW
 */

public class MarketingViewKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//

    private String isDel;//

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
