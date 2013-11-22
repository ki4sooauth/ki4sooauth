package com.gooagoo.view.gus.web.common;

import java.io.Serializable;

public class UProvince implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String provinceId;//省ID

    private String provinceName;//省名称

    public String getProvinceId()
    {
        return provinceId;
    }

    public void setProvinceId(String provinceId)
    {
        this.provinceId = provinceId;
    }

    public String getProvinceName()
    {
        return provinceName;
    }

    public void setProvinceName(String provinceName)
    {
        this.provinceName = provinceName;
    }

}
