package com.gooagoo.view.mis.dictionaryManage;

import java.io.Serializable;
import java.util.Date;

/**
 * 商家服务工具字典
 * @author Administrator
 *
 */
public class MShopToolInfo implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String toolId;// 服务工具编号
    private String toolName;// 服务工具名称
    private String toolUrl;// 工具介绍URL
    private String toolIcoFocus;// 工具图标（选中）
    private String toolIcoUnfocus;// 工具图标（非选中状态）
    private String toolType;// 服务工具类型，0-现场服务，1-远程服务
    private String localCmd;// 手机本地命令
    private String ver;// 版本，不同版本对应不同的工具信息类型
    private String remark;// 备注
    private String isDel;// 是否删除，Y-已删除，N-未删除
    private Date createTime;// 创建时间
    private Date cTimeStamp;// 最后一次修改时间

    public String getToolId()
    {
        return toolId;
    }

    public void setToolId(String toolId)
    {
        this.toolId = toolId;
    }

    public String getToolName()
    {
        return toolName;
    }

    public void setToolName(String toolName)
    {
        this.toolName = toolName;
    }

    public String getToolUrl()
    {
        return toolUrl;
    }

    public void setToolUrl(String toolUrl)
    {
        this.toolUrl = toolUrl;
    }

    public String getToolIcoFocus()
    {
        return toolIcoFocus;
    }

    public void setToolIcoFocus(String toolIcoFocus)
    {
        this.toolIcoFocus = toolIcoFocus;
    }

    public String getToolIcoUnfocus()
    {
        return toolIcoUnfocus;
    }

    public void setToolIcoUnfocus(String toolIcoUnfocus)
    {
        this.toolIcoUnfocus = toolIcoUnfocus;
    }

    public String getToolType()
    {
        return toolType;
    }

    public void setToolType(String toolType)
    {
        this.toolType = toolType;
    }

    public String getLocalCmd()
    {
        return localCmd;
    }

    public void setLocalCmd(String localCmd)
    {
        this.localCmd = localCmd;
    }

    public String getVer()
    {
        return ver;
    }

    public void setVer(String ver)
    {
        this.ver = ver;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public String getIsDel()
    {
        return isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getcTimeStamp()
    {
        return cTimeStamp;
    }

    public void setcTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

}
