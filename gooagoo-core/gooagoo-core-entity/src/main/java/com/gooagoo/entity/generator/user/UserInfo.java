package com.gooagoo.entity.generator.user;

import java.io.Serializable;
import java.util.Date;

/**
 * 个人用户表
 */

public class UserInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String userId;//用户编号，唯一，通过UUID产生

    private String account;//用户名，唯一，不包含特殊字符

    private String mobile;//手机号码，唯一，11位数字

    private String email;//电子邮箱，唯一，字母、数字、下划线、@组成

    private String password;//登录口令，md5加密

    private String userType;//用户来源：M-手机端，W-PC端

    private String userStatus;//用户状态：L-锁定，U-正常

    private String userNum;//默认卡号，用户无卡刷卡，唯一

    private String isActiveEmail;//是否激活：Y-已激活，N-未激活，手机端注册时默认为已激活

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getAccount()
    {
        return this.account;
    }

    public void setAccount(String account)
    {
        this.account = account;
    }

    public String getMobile()
    {
        return this.mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUserType()
    {
        return this.userType;
    }

    public void setUserType(String userType)
    {
        this.userType = userType;
    }

    public String getUserStatus()
    {
        return this.userStatus;
    }

    public void setUserStatus(String userStatus)
    {
        this.userStatus = userStatus;
    }

    public String getUserNum()
    {
        return this.userNum;
    }

    public void setUserNum(String userNum)
    {
        this.userNum = userNum;
    }

    public String getIsActiveEmail()
    {
        return this.isActiveEmail;
    }

    public void setIsActiveEmail(String isActiveEmail)
    {
        this.isActiveEmail = isActiveEmail;
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
        return this.userId + "^" + this.account + "^" + this.mobile + "^" + this.email + "^" + this.password + "^" + this.userType + "^" + this.userStatus + "^" + this.userNum + "^" + this.isActiveEmail + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
