package com.gooagoo.entity.business.user.account.property;

import java.io.Serializable;

/**
 * 用户属性档案信息
 *
 */
public class AccountTypeInfo implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String userId;//gooagoo账号
    private String gooagooId; //用户安装APP时分配的编号
    private String ip; //用户客户端的IP地址
    private String mac;//用户客户端的Mac地址
    private String hostName;//用户客户端的主机名称
    private String mobile;//手机号吗
    private String cardNo;//电子卡号
    private String phyCardNo;//物理卡号

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getGooagooId()
    {
        return this.gooagooId;
    }

    public void setGooagooId(String gooagooId)
    {
        this.gooagooId = gooagooId;
    }

    public String getIp()
    {
        return this.ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public String getMac()
    {
        return this.mac;
    }

    public void setMac(String mac)
    {
        this.mac = mac;
    }

    public String getHostName()
    {
        return this.hostName;
    }

    public void setHostName(String hostName)
    {
        this.hostName = hostName;
    }

    public String getMobile()
    {
        return this.mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getCardNo()
    {
        return this.cardNo;
    }

    public void setCardNo(String cardNo)
    {
        this.cardNo = cardNo;
    }

    public String getPhyCardNo()
    {
        return this.phyCardNo;
    }

    public void setPhyCardNo(String phyCardNo)
    {
        this.phyCardNo = phyCardNo;
    }

}
