package com.gooagoo.view.gms.crm;

import java.io.Serializable;

public class UserRecordLeftMenuVo implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String account;//账号
    private String email; // 邮箱
    private String name; //姓名
    private String integral; // 积分
    private String memberLevel; // 会员等级
    private String mac; // mac 地址
    private String phyNo; // 物理卡号;
    private String headImg; //头像

    public String getAccount()
    {
        return this.account;
    }

    public void setAccount(String account)
    {
        this.account = account;
    }

    public String getHeadImg()
    {
        return this.headImg;
    }

    public void setHeadImg(String headImg)
    {
        this.headImg = headImg;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getIntegral()
    {
        return this.integral;
    }

    public void setIntegral(String integral)
    {
        this.integral = integral;
    }

    public String getMemberLevel()
    {
        return this.memberLevel;
    }

    public void setMemberLevel(String memberLevel)
    {
        this.memberLevel = memberLevel;
    }

    public String getMac()
    {
        return this.mac;
    }

    public void setMac(String mac)
    {
        this.mac = mac;
    }

    public String getPhyNo()
    {
        return this.phyNo;
    }

    public void setPhyNo(String phyNo)
    {
        this.phyNo = phyNo;
    }

}
