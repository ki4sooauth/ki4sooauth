package com.gooagoo.view.mis.dictionaryManage;

import java.io.Serializable;
import java.util.Date;

/**
 * 省份城市字典
 * @author Administrator
 *
 */
public class MUserCityarea implements Serializable
{
    private static final long serialVersionUID = 1L;
    private Integer id;// 自动编号，自增长
    private String cityId;// 城市编码
    private String cityName;// 城市名称
    private String parentCityId;// 上级编码
    private String patentCityName;// 上级名称
    private String levelCode;// 省市级别：P-省，C-市，D-区
    private Integer sortOrder;// 排序
    private String isDel;// 是否删除，Y-删除，N-未删除
    private Date createTime;// 创建时间
    private Date cTimeStamp;// 最后一次修改时间

    public Integer getId()
    {
        return id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

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

    public String getParentCityId()
    {
        return parentCityId;
    }

    public void setParentCityId(String parentCityId)
    {
        this.parentCityId = parentCityId;
    }

    public String getPatentCityName()
    {
        return patentCityName;
    }

    public void setPatentCityName(String patentCityName)
    {
        this.patentCityName = patentCityName;
    }

    public String getLevelCode()
    {
        return levelCode;
    }

    public void setLevelCode(String levelCode)
    {
        this.levelCode = levelCode;
    }

    public Integer getSortOrder()
    {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder)
    {
        this.sortOrder = sortOrder;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getcTimeStamp()
    {
        return cTimeStamp;
    }

    public void setcTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

}
