package com.gooagoo.view.gms.tools;

import java.io.Serializable;

/**
 * 商家和服务工具的关系信息
 */
public class FShopTool implements Serializable, Comparable<FShopTool>
{
    private static final long serialVersionUID = 1L;

    private String shopToolId;//商家服务工具id
    private String shopId;//商家的id
    private String toolId;//服务工具Id
    private String toolName;//服务工具名称
    private String toolUrl;//工具介绍URL
    private String toolIcoFocus;//工具图标（选中）
    private String toolIcoUnfocus;//工具图标（非选中状态）
    private String toolType;//服务工具类型，参考通用字典表的tool_type
    private String localCmd;//手机本地命令
    private String remark;//备注
    private String ver;//版本，不同版本对应不同的工具信息类型
    private String status;//状态，W待审核、A已审核通过、B已审核不通过、P已发布
    private String authority;//权限设置，对应会员卡类别，以逗号分隔，如为空，则表示所有会员都可使用
    private Integer orderNo;// 排序编号

    public String getAuthority()
    {
        return this.authority;
    }

    public void setAuthority(String authority)
    {
        this.authority = authority;
    }

    public String getToolId()
    {
        return this.toolId;
    }

    public void setToolId(String toolId)
    {
        this.toolId = toolId;
    }

    public String getShopToolId()
    {
        return this.shopToolId;
    }

    public void setShopToolId(String shopToolId)
    {
        this.shopToolId = shopToolId;
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

    public String getLocalCmd()
    {
        return this.localCmd;
    }

    public void setLocalCmd(String localCmd)
    {
        this.localCmd = localCmd;
    }

    public String getRemark()
    {
        return this.remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public String getVer()
    {
        return this.ver;
    }

    public void setVer(String ver)
    {
        this.ver = ver;
    }

    public String getStatus()
    {
        return this.status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
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

    public Integer getOrderNo()
    {
        return this.orderNo;
    }

    public void setOrderNo(Integer orderNo)
    {
        this.orderNo = orderNo;
    }

    @Override
    public int compareTo(FShopTool o)
    {
        // 处理脏数据，order为null的情况
        if (o.orderNo == null || this.orderNo == null)
        {
            return 0;
        }
        if (o.orderNo > this.orderNo)
        {
            return -1;
        }
        else if (o.orderNo < this.orderNo)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
