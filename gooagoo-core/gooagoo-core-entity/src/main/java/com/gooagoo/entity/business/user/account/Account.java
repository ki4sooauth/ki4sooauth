package com.gooagoo.entity.business.user.account;

import java.io.Serializable;

public class Account implements Serializable
{
    private static final long serialVersionUID = -443258985452271074L;

    private String userId;
    private String phyCardNo;
    private String mac;
    private String ip;

    public String getAccountType()
    {
        if (userId != null && !"".equals(userId))
        {
            return "0";
        }
        else if (phyCardNo != null && !"".equals(phyCardNo))
        {
            return "7";
        }
        else if (mac != null && !"".equals(mac))
        {
            return "3";
        }
        else if (ip != null && !"".equals(ip))
        {
            return "2";
        }
        else
        {
            return null;
        }
    }

    public String getAccountNo()
    {
        if (userId != null && !"".equals(userId))
        {
            return userId;
        }
        else if (phyCardNo != null && !"".equals(phyCardNo))
        {
            return phyCardNo;
        }
        else if (mac != null && !"".equals(mac))
        {
            return mac;
        }
        else if (ip != null && !"".equals(ip))
        {
            return "2";
        }
        else
        {
            return null;
        }
    }

    public Account()
    {
        super();
    }

    public Account(String userId)
    {
        super();
        this.userId = userId;
    }

    public Account(String accountType, String account)
    {
        if ("0".equals(accountType))
        {
            this.userId = account;
        }
        else if ("2".equals(accountType))
        {
            this.ip = account;
        }
        else if ("3".equals(accountType))
        {
            this.mac = account;
        }
        else if ("7".equals(accountType))
        {
            this.phyCardNo = account;
        }
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getPhyCardNo()
    {
        return phyCardNo;
    }

    public void setPhyCardNo(String phyCardNo)
    {
        this.phyCardNo = phyCardNo;
    }

    public String getMac()
    {
        return mac;
    }

    public void setMac(String mac)
    {
        this.mac = mac;
    }

    public String getIp()
    {
        return ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    @Override
    public int hashCode()
    {
        if (userId != null)
        {
            return userId.hashCode();
        }
        else if (phyCardNo != null)
        {
            return phyCardNo.hashCode();
        }
        else if (mac != null)
        {
            return mac.hashCode();
        }
        else if (ip != null)
        {
            return mac.hashCode();
        }
        else
        {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        Account other = (Account) obj;
        if (userId != null && userId.equals(other.userId))
        {
            return true;
        }
        else if (ip != null && ip.equals(other.ip))
        {
            return true;
        }
        else if (mac != null && mac.equals(other.mac))
        {
            return true;
        }
        else if (phyCardNo != null && phyCardNo.equals(other.phyCardNo))
        {
            return true;
        }
        return false;
    }
}
