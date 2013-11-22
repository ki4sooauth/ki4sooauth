package com.gooagoo.entity.casclient.personal;

import java.io.Serializable;
import java.util.Date;

public class PersonalProfile implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String userId;//用户编号，关联user_info表的用户编号

    private String realName;//真实姓名

    private String sex;//性别：M-男，F-女，P-其他

    private Date birthday;//出生日期

    private String idType;//证件类型

    private String idNo;//证件号码

    private String telephone;//联系电话

    private String postCode;//邮政编码

    private String province;//省

    private String city;//市

    private String area;//区县

    private String address;//详细地址

    private String regIp;//用户注册的ip

    private String isAllowFriend;//是否允许别人加自己为好友

    private String headPic;//用户头像图片URL，默认为系统头像

    private Date cTimeStamp;//最后一次修改时间

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getRealName()
    {
        return realName;
    }

    public void setRealName(String realName)
    {
        this.realName = realName;
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

    public String getProvince()
    {
        return province;
    }

    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getArea()
    {
        return area;
    }

    public void setArea(String area)
    {
        this.area = area;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getRegIp()
    {
        return regIp;
    }

    public void setRegIp(String regIp)
    {
        this.regIp = regIp;
    }

    public String getIsAllowFriend()
    {
        return isAllowFriend;
    }

    public void setIsAllowFriend(String isAllowFriend)
    {
        this.isAllowFriend = isAllowFriend;
    }

    public String getHeadPic()
    {
        return headPic;
    }

    public void setHeadPic(String headPic)
    {
        this.headPic = headPic;
    }

    public Date getCTimeStamp()
    {
        return cTimeStamp;
    }

    public void setCTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    @Override
    public String toString()
    {
        return this.userId + "^" + this.realName + "^" + this.sex + "^" + this.birthday + "^" + this.idType + "^" + this.idNo + "^" + this.telephone + "^" + this.postCode + "^" + this.province + "^" + this.city + "^" + this.area + "^" + this.address + "^" + this.regIp + "^" + this.isAllowFriend + "^" + this.headPic + "^" + this.cTimeStamp;
    }

}
