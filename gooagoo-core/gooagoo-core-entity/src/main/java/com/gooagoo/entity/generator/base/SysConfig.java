package com.gooagoo.entity.generator.base;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统配置信息
 */

public class SysConfig implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Integer id;//自动编号，自增长

    private String configKey;//配置信息key

    private String configValue;//配置信息value

    private String note;//备注

    private String sysType;//所属系统，gus、gms、mis、mobile、passport、upload

    private Date cTimeStamp;//最后一次修改时间

    public Integer getId()
    {
        return this.id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getConfigKey()
    {
        return this.configKey;
    }

    public void setConfigKey(String configKey)
    {
        this.configKey = configKey;
    }

    public String getConfigValue()
    {
        return this.configValue;
    }

    public void setConfigValue(String configValue)
    {
        this.configValue = configValue;
    }

    public String getNote()
    {
        return this.note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public String getSysType()
    {
        return this.sysType;
    }

    public void setSysType(String sysType)
    {
        this.sysType = sysType;
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
        return this.id + "^" + this.configKey + "^" + this.configValue + "^" + this.note + "^" + this.sysType + "^" + this.cTimeStamp;
    }
}
