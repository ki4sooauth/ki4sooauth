package com.gooagoo.entity.generator.base;

import java.io.Serializable;
import java.util.Date;

/**
 * 商家平台界面名称管理
 */

public class ShopInterfaceName implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//自动编号，UUID

    private String nameCode;//名称编码

    private String nameValue;//名称值

    private String sys;//所属系统

    private String module;//所属模块

    private String note;//备注

    private String version;//版本号

    private String versionNote;//版本号说明

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getNameCode()
    {
        return this.nameCode;
    }

    public void setNameCode(String nameCode)
    {
        this.nameCode = nameCode;
    }

    public String getNameValue()
    {
        return this.nameValue;
    }

    public void setNameValue(String nameValue)
    {
        this.nameValue = nameValue;
    }

    public String getSys()
    {
        return this.sys;
    }

    public void setSys(String sys)
    {
        this.sys = sys;
    }

    public String getModule()
    {
        return this.module;
    }

    public void setModule(String module)
    {
        this.module = module;
    }

    public String getNote()
    {
        return this.note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public String getVersion()
    {
        return this.version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }

    public String getVersionNote()
    {
        return this.versionNote;
    }

    public void setVersionNote(String versionNote)
    {
        this.versionNote = versionNote;
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
        return this.id + "^" + this.nameCode + "^" + this.nameValue + "^" + this.sys + "^" + this.module + "^" + this.note + "^" + this.version + "^" + this.versionNote + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
