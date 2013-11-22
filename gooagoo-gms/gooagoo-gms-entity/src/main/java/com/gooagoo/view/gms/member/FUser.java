package com.gooagoo.view.gms.member;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 */
public class FUser implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String userId;//用户编号，唯一，通过UUID产生

    private String phone;//手机号码，唯一，11位数字
    
    private String telephone;//联系电话

    private String email;//电子邮箱，唯一，字母、数字、下划线、@组成

    private String nickName;//昵称，默认为电子邮箱@之前的部分

    private String realName;//真实姓名

    private String sex;//性别：M-男，F-女，P-其他

    private Date birthday;//出生日期

    private String idType;//证件类型

    private String idNo;//证件号码

    private String userType;//用户来源：M-手机端，W-PC端

    private String userStatus;//用户状态：L-锁定，U-正常，默认为正常

    private String isDel;//是否删除，Y-已删除，N-未删除

    private String postCode;//邮政编码

    private String province;//省

    private String city;//市

    private String area;//区县

    private String gradeId;//会员等级id

    private String gradeName;//会员等级名称
    
    private String phyCardNo; //物理卡号
    
    public String getPhyCardNo() {
		return phyCardNo;
	}

	public void setPhyCardNo(String phyCardNo) {
		this.phyCardNo = phyCardNo;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getPhone()
    {
        return this.phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getNickName()
    {
        return this.nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
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

    public String getIsDel()
    {
        return this.isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public String getPostCode()
    {
        return this.postCode;
    }

    public void setPostCode(String postCode)
    {
        this.postCode = postCode;
    }

    public String getProvince()
    {
        return this.province;
    }

    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getCity()
    {
        return this.city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getArea()
    {
        return this.area;
    }

    public void setArea(String area)
    {
        this.area = area;
    }

    public String getGradeId()
    {
        return this.gradeId;
    }

    public void setGradeId(String gradeId)
    {
        this.gradeId = gradeId;
    }

    public String getGradeName()
    {
        return this.gradeName;
    }

    public void setGradeName(String gradeName)
    {
        this.gradeName = gradeName;
    }

}
