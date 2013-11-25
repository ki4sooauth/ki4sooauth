package com.gooagoo.view.gms.tools;

import java.io.Serializable;

/**
 * 商家服务工具信息
 */

public class FToolInfo implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String toolId;//服务工具编号

    private String toolName;//服务工具名称

    private String toolUrl;//工具介绍URL

    private String toolIcoFocus;//工具图标（选中）

    private String toolIcoUnfocus;//工具图标（非选中状态）

    private String toolType;//服务工具类型，0-现场服务，1-远程服务

    private String localCmd;//手机本地命令

    private String ver;//版本，不同版本对应不同的工具信息类型

    private String remark;//备注

    public String getToolId()
    {
        return this.toolId;
    }

    public void setToolId(String toolId)
    {
        this.toolId = toolId;
    }

    public String getToolName()
    {
        return this.toolName;
    }

    public void setToolName(String toolName)
    {
        this.toolName = toolName;
    }

    public String getToolUrl()
    {
        return this.toolUrl;
    }

    public void setToolUrl(String toolUrl)
    {
        this.toolUrl = toolUrl;
    }

    public String getToolIcoFocus()
    {
        return this.toolIcoFocus;
    }

    public void setToolIcoFocus(String toolIcoFocus)
    {
        this.toolIcoFocus = toolIcoFocus;
    }

    public String getToolIcoUnfocus()
    {
        return this.toolIcoUnfocus;
    }

    public void setToolIcoUnfocus(String toolIcoUnfocus)
    {
        this.toolIcoUnfocus = toolIcoUnfocus;
    }

    public String getToolType()
    {
        return this.toolType;
    }

    public void setToolType(String toolType)
    {
        this.toolType = toolType;
    }

    public String getLocalCmd()
    {
        return this.localCmd;
    }

    public void setLocalCmd(String localCmd)
    {
        this.localCmd = localCmd;
    }

    public String getVer()
    {
        return this.ver;
    }

    public void setVer(String ver)
    {
        this.ver = ver;
    }

    public String getRemark()
    {
        return this.remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    @Override
    public String toString()
    {
        return this.toolId + "^" + this.toolName + "^" + this.toolUrl + "^" + this.toolIcoFocus + "^" + this.toolIcoUnfocus + "^" + this.toolType + "^" + this.localCmd + "^" + this.ver + "^" + this.remark;
    }
}