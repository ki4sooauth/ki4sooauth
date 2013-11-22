package com.gooagoo.view.gms.common;

import java.io.Serializable;

public class FConsumer implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String accountType;//账号类型　gooagoo帐号、物理卡号、电子卡号、mac地址、gooagooid、电子商务网站帐号、手机号码、IP地址
    private String account;//账号
    private String name;//姓名
    private String sex;//性别（F－女、M－男）
    private String birthday;//出生日期
    private String idno;//证件号码
    private String phone;//联系电话
    private String address;//联系地址

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

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSex()
    {
        return this.sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public String getBirthday()
    {
        return this.birthday;
    }

    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }

    public String getIdno()
    {
        return this.idno;
    }

    public void setIdno(String idno)
    {
        this.idno = idno;
    }

    public String getPhone()
    {
        return this.phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

}
