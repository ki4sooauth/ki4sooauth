package com.gooagoo.view.gms.crm;

import java.io.Serializable;
import java.util.Date;

/**
 * crm中用户信息 
 *
 */
public class FUserInfoCrm implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String userName;//账号
    private String realName;//姓名
    private String sex;//性别
    private Date birthday;//出生日期
    private String idno;//身份证号
    private String phone;//联系电话
    private String address;//联系地址

    public String getUserName()
    {
        return this.userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getRealName()
    {
        return this.realName;
    }

    public void setRealName(String realName)
    {
        this.realName = realName;
    }

    public String getSex()
    {
        return this.sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public Date getBirthday()
    {
        return this.birthday;
    }

    public void setBirthday(Date birthday)
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
