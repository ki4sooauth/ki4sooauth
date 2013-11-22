package com.gooagoo.entity.generator.sys;

import java.io.Serializable;

/**
 * 广告位信息
 */

public class ShopAdKey implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String adCode;//广告位编码

    private String isDel;//是否删除，Y-已删除，N-未删除

    public String getAdCode()
    {
        return adCode;
    }

    public void setAdCode(String adCode)
    {
        this.adCode = adCode;
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
