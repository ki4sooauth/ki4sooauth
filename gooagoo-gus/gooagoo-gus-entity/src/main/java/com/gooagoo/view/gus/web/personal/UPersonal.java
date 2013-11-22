package com.gooagoo.view.gus.web.personal;

import java.io.Serializable;
import java.util.Date;

import com.gooagoo.view.gus.common.Image;

public class UPersonal implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String userId;//用户编号，关联user_info表的用户编号

    private String realName;//真实姓名

    private String sex;//性别：M-男，F-女，P-其他

    private Date birthday;//出生日期

    private String idType;//证件类型

    private String idNo;//证件号码

    private String phone;//联系电话

    private String postCode;//邮政编码

    private String province;//省id

    private String proincevalue;//省名称

    private String city;//市

    private String cityvalue;//市名称

    private String area;//区县

    private String areavalue;//区名称

    private String address;//详细地址

    private String isAllowFriend;//是否允许别人加自己为好友

    private Image headPic;//用户头像图片URL，默认为系统头像

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
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

    public String getPhone()
    {
        return this.phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
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

    public String getAddress()
    {
        return this.address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getProincevalue()
    {
        return this.proincevalue;
    }

    public void setProincevalue(String proincevalue)
    {
        this.proincevalue = proincevalue;
    }

    public String getCityvalue()
    {
        return this.cityvalue;
    }

    public void setCityvalue(String cityvalue)
    {
        this.cityvalue = cityvalue;
    }

    public String getAreavalue()
    {
        return this.areavalue;
    }

    public void setAreavalue(String areavalue)
    {
        this.areavalue = areavalue;
    }

    public String getIsAllowFriend()
    {
        return this.isAllowFriend;
    }

    public void setIsAllowFriend(String isAllowFriend)
    {
        this.isAllowFriend = isAllowFriend;
    }

    public Image getHeadPic()
    {
        return this.headPic;
    }

    public void setHeadPic(Image headPic)
    {
        this.headPic = headPic;
    }

}
