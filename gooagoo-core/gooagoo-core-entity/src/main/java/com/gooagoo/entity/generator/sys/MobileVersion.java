package com.gooagoo.entity.generator.sys;

import java.io.Serializable;
import java.util.Date;

/**
 * 移动设备版本管理表
 */

public class MobileVersion implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//自动编号，UUID

    private String appCode;//APP识别码

    private String mobileType;//移动设备类型，参考mobile_type

    private String version;//版本号

    private String versionName;//版本名称

    private String link;//链接地址，应该是后台上传的apk包的访问地址

    private String platform;//所属平台

    private String note;//备注

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getAppCode()
    {
        return this.appCode;
    }

    public void setAppCode(String appCode)
    {
        this.appCode = appCode;
    }

    public String getMobileType()
    {
        return this.mobileType;
    }

    public void setMobileType(String mobileType)
    {
        this.mobileType = mobileType;
    }

    public String getVersion()
    {
        return this.version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }

    public String getVersionName()
    {
        return this.versionName;
    }

    public void setVersionName(String versionName)
    {
        this.versionName = versionName;
    }

    public String getLink()
    {
        return this.link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }

    public String getPlatform()
    {
        return this.platform;
    }

    public void setPlatform(String platform)
    {
        this.platform = platform;
    }

    public String getNote()
    {
        return this.note;
    }

    public void setNote(String note)
    {
        this.note = note;
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

    @Override
    public String toString()
    {
        return this.id + "^" + this.appCode + "^" + this.mobileType + "^" + this.version + "^" + this.versionName + "^" + this.link + "^" + this.platform + "^" + this.note + "^" + this.isDel + "^" + this.createTime;
    }
}
