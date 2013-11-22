package com.gooagoo.view.gus;

import java.io.Serializable;

/**
 * 市
 * @author SPZ
 *
 */
public class UCity implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String cityId;//市ID

    private String cityName;//市名称

    public String getCityId()
    {
        return cityId;
    }

    public void setCityId(String cityId)
    {
        this.cityId = cityId;
    }

    public String getCityName()
    {
        return cityName;
    }

    public void setCityName(String cityName)
    {
        this.cityName = cityName;
    }

    @Override
    public String toString()
    {
        return "UCity [cityId=" + cityId + ", cityName=" + cityName + "]";
    }

}
