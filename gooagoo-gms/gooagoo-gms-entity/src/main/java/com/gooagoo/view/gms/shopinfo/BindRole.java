package com.gooagoo.view.gms.shopinfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BindRole implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String userId;
    private List<String> roleIds = new ArrayList<String>();

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public List<String> getRoleIds()
    {
        return this.roleIds;
    }

    public void setRoleIds(List<String> roleIds)
    {
        this.roleIds = roleIds;
    }

}
