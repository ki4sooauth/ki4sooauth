package com.gooagoo.view.gms.shopinfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BindAuthority implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String roleId;
    private List<String> authority = new ArrayList<String>();

    public String getRoleId()
    {
        return this.roleId;
    }

    public void setRoleId(String roleId)
    {
        this.roleId = roleId;
    }

    public List<String> getAuthority()
    {
        return this.authority;
    }

    public void setAuthority(List<String> authority)
    {
        this.authority = authority;
    }
}
