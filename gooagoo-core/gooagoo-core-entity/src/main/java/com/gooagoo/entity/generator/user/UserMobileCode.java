package com.gooagoo.entity.generator.user;

import java.io.Serializable;
import java.util.Date;

/**
 * 手机验证码
 */

public class UserMobileCode implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//编号，唯一，通过UUID产生

    private String mobile;//手机号码

    private String captchaCode;//验证码

    private Date expDate;//过期时间，为创建时间的5分钟之内

    private String isUsed;//是否使用：Y-已使用，N-未使用

    private Date useDate;//使用时间

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

    public String getMobile()
    {
        return this.mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getCaptchaCode()
    {
        return this.captchaCode;
    }

    public void setCaptchaCode(String captchaCode)
    {
        this.captchaCode = captchaCode;
    }

    public Date getExpDate()
    {
        return this.expDate;
    }

    public void setExpDate(Date expDate)
    {
        this.expDate = expDate;
    }

    public String getIsUsed()
    {
        return this.isUsed;
    }

    public void setIsUsed(String isUsed)
    {
        this.isUsed = isUsed;
    }

    public Date getUseDate()
    {
        return this.useDate;
    }

    public void setUseDate(Date useDate)
    {
        this.useDate = useDate;
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
        return this.id + "^" + this.mobile + "^" + this.captchaCode + "^" + this.expDate + "^" + this.isUsed + "^" + this.useDate + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
