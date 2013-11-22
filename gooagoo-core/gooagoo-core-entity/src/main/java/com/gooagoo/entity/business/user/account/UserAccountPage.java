package com.gooagoo.entity.business.user.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页查询用户账号信息
 */

public class UserAccountPage implements Serializable
{

    private static final long serialVersionUID = 1L;

    private Integer pageIndex;//第几页
    private Integer pageSize;//每页记录数
    private Integer total;//总记录数
    private List<UserAccount> userAccounts = new ArrayList<UserAccount>();

    public Integer getPageIndex()
    {
        return this.pageIndex;
    }

    public void setPageIndex(Integer pageIndex)
    {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize()
    {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }

    public Integer getTotal()
    {
        return this.total;
    }

    public void setTotal(Integer total)
    {
        this.total = total;
    }

    public List<UserAccount> getUserAccounts()
    {
        return this.userAccounts;
    }

    public void setUserAccounts(List<UserAccount> userAccounts)
    {
        this.userAccounts = userAccounts;
    }

}
