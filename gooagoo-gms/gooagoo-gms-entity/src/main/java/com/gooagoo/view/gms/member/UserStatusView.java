package com.gooagoo.view.gms.member;

import java.io.Serializable;
import java.util.Date;

public class UserStatusView implements Serializable
{
    private static final long serialVersionUID = 8418619586521185704L;

    private String userId;
    private String account;//账号
    private String accountType; //帐号类型
    private String gooagooId;//账号
    private String name; //姓名
    private String sex; //性别
    private Date birthday;//出生日期
    private String phone; //联系电话
    private String mac; //mac

    /*private String arrival; //当天最早到店时间
    private String leave; //当天离店时间
    */
    
    public String getUserId()
    {
        return userId;
    }

    public String getGooagooId() {
		return gooagooId;
	}

	public void setGooagooId(String gooagooId) {
		this.gooagooId = gooagooId;
	}

	public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getAccount()
    {
        return account;
    }

    public void setAccount(String account)
    {
        this.account = account;
    }

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

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getMac()
    {
        return mac;
    }

    public void setMac(String mac)
    {
        this.mac = mac;
    }

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
    
    
    
    
    /*public String getArrival()
    {
        return arrival;
    }

    public void setArrival(String arrival)
    {
        this.arrival = arrival;
    }

    public String getLeave()
    {
        return leave;
    }

    public void setLeave(String leave)
    {
        this.leave = leave;
    }*/
}
