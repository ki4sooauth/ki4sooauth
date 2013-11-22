package com.gooagoo.view.mis.common;

import java.io.Serializable;
import java.util.List;

/**
 * 后台用户登录信息
 * @author dxh
 *
 */
public class MMisLoginInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String loginId;//登录Id
    private String status;//状态 0-停用 1-启用
    private String isAdmin;//是否为管理员 Y-是 N-否
    private List<MZTreeNode> authorities;//用户拥有的权限
    private String password;
    private String templateContInput;//模板输入内容
    private String templateContOutput;//模板输出内容

    public String getLoginId()
    {
        return this.loginId;
    }

    public void setLoginId(String loginId)
    {
        this.loginId = loginId;
    }

    public String getStatus()
    {
        return this.status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getIsAdmin()
    {
        return this.isAdmin;
    }

    public void setIsAdmin(String isAdmin)
    {
        this.isAdmin = isAdmin;
    }

    public List<MZTreeNode> getAuthorities()
    {
        return this.authorities;
    }

    public void setAuthorities(List<MZTreeNode> authorities)
    {
        this.authorities = authorities;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getTemplateContInput()
    {
        return this.templateContInput;
    }

    public void setTemplateContInput(String templateContInput)
    {
        this.templateContInput = templateContInput;
    }

    public String getTemplateContOutput()
    {
        return this.templateContOutput;
    }

    public void setTemplateContOutput(String templateContOutput)
    {
        this.templateContOutput = templateContOutput;
    }

}
