package com.gooagoo.entity.business.user.account.property;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户属性档案信息
 *
 */
public class AccountBaseInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String name;//姓名
    private String sex;//性别
    private Date birthday;//生日
    private String idType; //证件类型
    private String idNo; //证件号码
    private Integer age;//年龄 
    private String email;//邮箱
    private String telephone; //联系电话
    private String postCode; //邮编
    private String address; //联系地址
    private String memberLevel; //会员等级

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getSex()
    {
        return sex;
    }

    public void setSex(String sex)
    {
        this.sex = sex;
    }

    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public String getIdType()
    {
        return idType;
    }

    public void setIdType(String idType)
    {
        this.idType = idType;
    }

    public String getIdNo()
    {
        return idNo;
    }

    public void setIdNo(String idNo)
    {
        this.idNo = idNo;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getPostCode()
    {
        return postCode;
    }

    public void setPostCode(String postCode)
    {
        this.postCode = postCode;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getMemberLevel()
    {
        return memberLevel;
    }

    public void setMemberLevel(String memberLevel)
    {
        this.memberLevel = memberLevel;
    }
}
