package com.gooagoo.entity.generator.base;

import java.io.Serializable;
import java.util.Date;

/**
 * 省份城市字典表
 */

public class UserCityarea implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Integer id;//自动编号，自增长

    private String cityId;//省市区编码

    private String cityName;//省市区名称

    private String parentCityId;//上级编码

    private String parentCityName;//上级名称

    private String levelCode;//省市区级别：P-省，C-市，D-区

    private Integer sortOrder;//排序

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public Integer getId()
    {
        return this.id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getCityId()
    {
        return this.cityId;
    }

    public void setCityId(String cityId)
    {
        this.cityId = cityId;
    }

    public String getCityName()
    {
        return this.cityName;
    }

    public void setCityName(String cityName)
    {
        this.cityName = cityName;
    }

    public String getParentCityId()
    {
        return this.parentCityId;
    }

    public void setParentCityId(String parentCityId)
    {
        this.parentCityId = parentCityId;
    }

    public String getParentCityName()
    {
        return this.parentCityName;
    }

    public void setParentCityName(String parentCityName)
    {
        this.parentCityName = parentCityName;
    }

    public String getLevelCode()
    {
        return this.levelCode;
    }

    public void setLevelCode(String levelCode)
    {
        this.levelCode = levelCode;
    }

    public Integer getSortOrder()
    {
        return this.sortOrder;
    }

    public void setSortOrder(Integer sortOrder)
    {
        this.sortOrder = sortOrder;
    }

    public String getIsDel()
    {
        return this.isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getCTimeStamp()
    {
        return this.cTimeStamp;
    }

    public void setCTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    @Override
    public String toString()
    {
        return this.id + "^" + this.cityId + "^" + this.cityName + "^" + this.parentCityId + "^" + this.parentCityName + "^" + this.levelCode + "^" + this.sortOrder + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
