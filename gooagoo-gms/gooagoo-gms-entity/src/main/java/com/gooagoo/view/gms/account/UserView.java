package com.gooagoo.view.gms.account;

import java.io.Serializable;
import java.util.Date;

/**
 *  根据历史条件查询用户信息
 *
 */
public class UserView implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String accountType; //账号类型 

    private String account; //账号

    private String name; //名称

    private String sex;//性别

    private Date birthday;//生日

    private String idType; //证件类型

    private String idNo; //证件号码

    private int age;//年龄 

    private String email;//邮箱

    private String telephone; //联系电话

    private String postCode; //邮编

    private String address; //联系地址

    private String memberLevel; //会员等级

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

    public Date getBirthday()
    {
        return this.birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public String getIdType()
    {
        return this.idType;
    }

    public void setIdType(String idType)
    {
        this.idType = idType;
    }

    public String getIdNo()
    {
        return this.idNo;
    }

    public void setIdNo(String idNo)
    {
        this.idNo = idNo;
    }

    public int getAge()
    {
        return this.age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getTelephone()
    {
        return this.telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getPostCode()
    {
        return this.postCode;
    }

    public void setPostCode(String postCode)
    {
        this.postCode = postCode;
    }

    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getMemberLevel()
    {
        return this.memberLevel;
    }

    public void setMemberLevel(String memberLevel)
    {
        this.memberLevel = memberLevel;
    }

}
