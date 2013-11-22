package com.gooagoo.entity.business.user.account.action;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户行为档案 
 *
 */
public class ActionRecord implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String _id; //id
    private String shopId; //商家id
    private String userId; //用户id
    private String ip; //IP
    private String mac; //mac userId,ip,mac必须至少有一个字段有值
    private String behaveType; //行为类型
    private String objectType; //行为对象类型，A-活动，G-商品，C-优惠凭证，Y-吆喝，N-通知，Q-购好奇，M-邮件，S-手机服务，0-cms栏目，1-cms文章，2-广告
    private String objectValue; //行为对象编号：用户所做操作的对象，比如商品、活动、商家
    private String source;//来源
    private Date timestamp; //时间戳

    public String getAccountType()
    {
        if (userId != null && !"".equals(userId))
        {
            return "0";
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

    public String get_id()
    {
        return _id;
    }

    public void set_id(String _id)
    {
        this._id = _id;
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

    public String getBehaveType()
    {
        return behaveType;
    }

    public void setBehaveType(String behaveType)
    {
        this.behaveType = behaveType;
    }

    public String getObjectType()
    {
        return objectType;
    }

    public void setObjectType(String objectType)
    {
        this.objectType = objectType;
    }

    public String getObjectValue()
    {
        return objectValue;
    }

    public void setObjectValue(String objectValue)
    {
        this.objectValue = objectValue;
    }

    public String getSource()
    {
        return source;
    }

    public void setSource(String source)
    {
        this.source = source;
    }

    public Date getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;
    }
}
