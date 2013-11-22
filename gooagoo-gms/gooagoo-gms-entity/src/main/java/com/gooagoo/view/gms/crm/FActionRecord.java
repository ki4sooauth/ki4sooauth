package com.gooagoo.view.gms.crm;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户行为档案 
 *
 */
public class FActionRecord implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String accountType;//帐号类型（gooagoo帐号、物理卡号、电子卡号、mac地址、gooagooid、电子商务网站帐号、手机号码）
    private String userName;//帐号
    private String actionType;//行为类型
    private Date actionTime;//行为发生时间
    private String actionDesc;//行为描述
    private String ipAddress; // ip地址
    private String source; //来源
    
    public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getActionDesc()
    {
        return actionDesc;
    }

    public void setActionDesc(String actionDesc)
    {
        this.actionDesc = actionDesc;
    }

    public String getAccountType()
    {
        return this.accountType;
    }

    public void setAccountType(String accountType)
    {
        this.accountType = accountType;
    }

    public String getUserName()
    {
        return this.userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getActionType()
    {
        return this.actionType;
    }

    public void setActionType(String actionType)
    {
        this.actionType = actionType;
    }

    public Date getActionTime()
    {
        return this.actionTime;
    }

    public void setActionTime(Date actionTime)
    {
        this.actionTime = actionTime;
    }

    @Override
    public String toString()
    {
        return "FActionRecord [accountType=" + accountType + ", userName=" + userName + ", actionType=" + actionType + ", actionTime=" + actionTime + ", actionDesc=" + actionDesc + "]";
    }
}
