package com.gooagoo.bi.entity.analysisUser;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class AnalysisAccount
{
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
    private String cardId;
    private String scardNo;
    private String shopId;
    private String userId;//gooagoo账号
    private String gooagooId; //用户安装APP时分配的编号
    private String ip; //用户客户端的IP地址
    private String mac;//用户客户端的Mac地址
    private String hostName;//用户客户端的主机名称
    private String mobile;//手机号吗
    private String cardNo;//电子卡号
    private String phyCardNo;//物理卡号
    private Map<String, String> feature = new HashMap<String, String>();

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

    public String getCardId()
    {
        return cardId;
    }

    public void setCardId(String cardId)
    {
        this.cardId = cardId;
    }

    public String getScardNo()
    {
        return scardNo;
    }

    public void setScardNo(String scardNo)
    {
        this.scardNo = scardNo;
    }

    public String getShopId()
    {
        return shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getGooagooId()
    {
        return gooagooId;
    }

    public void setGooagooId(String gooagooId)
    {
        this.gooagooId = gooagooId;
    }

    public String getIp()
    {
        return ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public String getMac()
    {
        return mac;
    }

    public void setMac(String mac)
    {
        this.mac = mac;
    }

    public String getHostName()
    {
        return hostName;
    }

    public void setHostName(String hostName)
    {
        this.hostName = hostName;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getCardNo()
    {
        return cardNo;
    }

    public void setCardNo(String cardNo)
    {
        this.cardNo = cardNo;
    }

    public String getPhyCardNo()
    {
        return phyCardNo;
    }

    public void setPhyCardNo(String phyCardNo)
    {
        this.phyCardNo = phyCardNo;
    }

    public Map<String, String> getFeature()
    {
        return feature;
    }

    public void setFeature(Map<String, String> feature)
    {
        this.feature = feature;
    }
}
