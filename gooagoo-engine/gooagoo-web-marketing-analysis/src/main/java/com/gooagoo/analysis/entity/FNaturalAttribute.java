package com.gooagoo.analysis.entity;

import java.io.Serializable;

public class FNaturalAttribute implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String accountType;//账号类型　gooagoo帐号、物理卡号、电子卡号、mac地址、gooagooid、电子商务网站帐号、手机号码、IP地址

    private String account;//账号

    private String grade;//会员等级,卡类型ID，多个用英文半角逗号隔开

    private String gradeName;//会员等级,卡类型ID，多个用英文半角逗号隔开

    private String sex;//性别（F－女、M－男）

    private Integer ageStart;//年龄start

    private Integer ageEnd;//年龄end

    private String birthdayStart;//生日start

    private String birthdayEnd;//生日end

    public String getAccountType()
    {
        return this.accountType;
    }

    public void setAccountType(String accountType)
    {
        this.accountType = accountType;
    }

    public String getAccount()
    {
        return this.account;
    }

    public void setAccount(String account)
    {
        this.account = account;
    }

    public String getGrade()
    {
        return this.grade;
    }

    public void setGrade(String grade)
    {
        this.grade = grade;
    }

    public String getGradeName()
    {
        return this.gradeName;
    }

    public void setGradeName(String gradeName)
    {
        this.gradeName = gradeName;
    }

    public String getSex()
    {
        return this.sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public Integer getAgeStart()
    {
        return this.ageStart;
    }

    public void setAgeStart(Integer ageStart)
    {
        this.ageStart = ageStart;
    }

    public Integer getAgeEnd()
    {
        return this.ageEnd;
    }

    public void setAgeEnd(Integer ageEnd)
    {
        this.ageEnd = ageEnd;
    }

    public String getBirthdayStart()
    {
        return this.birthdayStart;
    }

    public void setBirthdayStart(String birthdayStart)
    {
        this.birthdayStart = birthdayStart;
    }

    public String getBirthdayEnd()
    {
        return this.birthdayEnd;
    }

    public void setBirthdayEnd(String birthdayEnd)
    {
        this.birthdayEnd = birthdayEnd;
    }

}
