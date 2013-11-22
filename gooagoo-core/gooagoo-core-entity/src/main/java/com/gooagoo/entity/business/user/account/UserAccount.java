package com.gooagoo.entity.business.user.account;

import java.io.Serializable;

/**
 * 用户账号类型信息表
 */

public class UserAccount implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String accountType;//账号类型
    private String accountNo;//账号号码

    public String getAccountType()
    {
        return this.accountType;
    }

    public void setAccountType(String accountType)
    {
        this.accountType = accountType;
    }

    public String getAccountNo()
    {
        return this.accountNo;
    }

    public void setAccountNo(String accountNo)
    {
        this.accountNo = accountNo;
    }

}
