package com.gooagoo.view.gms.crm;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户属性档案信息
 *
 */
public class FAccountBaseInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String name;//姓名
    private String sex;//性别
    private Date birthday;//生日
    private String idType; //证件类型
    private String idTypeCn; //证件类型中文名称
    private String idNo; //证件号码
    private int age;//年龄 
    private String email;//邮箱
    private String telephone; //联系电话
    private String postCode; //邮编
    private String address; //联系地址
    private String memberLevel; //会员等级

    public String getIdTypeCn() {
		return idTypeCn;
	}

	public void setIdTypeCn(String idTypeCn) {
		this.idTypeCn = idTypeCn;
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

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getAge()
    {
        return this.age;
    }

    public void setAge(int age)
    {
        this.age = age;
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
