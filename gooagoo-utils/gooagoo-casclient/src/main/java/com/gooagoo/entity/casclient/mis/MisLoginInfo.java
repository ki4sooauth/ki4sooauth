package com.gooagoo.entity.casclient.mis;

import java.io.Serializable;
import java.util.List;

public class MisLoginInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String token;//token值

    private String loginId;//登录Id

    private String status;//状态 0-停用 1-启用

    private String isAdmin;//是否为管理员 Y-是 N-否

    private List<MisZTreeNode> authorities;//用户拥有的权限

    private List<MisZTreeNode> allShopAuthorities;//所有权限

    private String password;//密码

    private String templateContInput;//模板输入内容

    private String templateContOutput;//模板输出内容

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    public String getLoginId()
    {
        return loginId;
    }

    public void setLoginId(String loginId)
    {
        this.loginId = loginId;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getIsAdmin()
    {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin)
    {
        this.isAdmin = isAdmin;
    }

    public List<MisZTreeNode> getAuthorities()
    {
        return authorities;
    }

    public void setAuthorities(List<MisZTreeNode> authorities)
    {
        this.authorities = authorities;
    }

    public List<MisZTreeNode> getAllShopAuthorities()
    {
        return allShopAuthorities;
    }

    public void setAllShopAuthorities(List<MisZTreeNode> allShopAuthorities)
    {
        this.allShopAuthorities = allShopAuthorities;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getTemplateContInput()
    {
        return templateContInput;
    }

    public void setTemplateContInput(String templateContInput)
    {
        this.templateContInput = templateContInput;
    }

    public String getTemplateContOutput()
    {
        return templateContOutput;
    }

    public void setTemplateContOutput(String templateContOutput)
    {
        this.templateContOutput = templateContOutput;
    }

}
