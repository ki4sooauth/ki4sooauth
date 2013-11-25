package com.gooagoo.entity.generator.shop;

import java.io.Serializable;
import java.util.Date;

/**
 * 商家申请的服务工具
 */

public class ShopToolList implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//自动编号，UUID

    private String shopId;//商家编号

    private String toolId;//服务工具编号

    private String toolName;//服务工具名称

    private String toolUrl;//工具介绍URL

    private String toolIcoFocus;//工具图标（选中）

    private String toolIcoUnfocus;//工具图标（非选中状态）

    private String toolType;//服务工具类型，参考通用字典表的tool_type

    private String status;//状态（服务工具），参考通用字典表的tool_status

    private String localCmd;//手机本地命令

    private String ver;//版本，不同版本对应不同的工具信息类型

    private String remark;//备注

    private String authority;//权限设置，对应会员卡类别，以逗号分隔，如为空，则表示所有会员都可使用

    private Integer orderNo;//排序编号

    private String isDel;//是否删除，Y-已删除，N-未删除

    private Date createTime;//创建时间

    private Date cTimeStamp;//最后一次修改时间

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getShopId()
    {
        return this.shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

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

    public String getStatus()
    {
        return this.status;
    }

    public void setStatus(String status)
    {
        this.status = status;
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

    public String getAuthority()
    {
        return this.authority;
    }

    public void setAuthority(String authority)
    {
        this.authority = authority;
    }

    public Integer getOrderNo()
    {
        return this.orderNo;
    }

    public void setOrderNo(Integer orderNo)
    {
        this.orderNo = orderNo;
    }

    public String getIsDel()
    {
        return this.isDel;
    }

    public void setIsDel(String isDel)
    {
        this.isDel = isDel;
    }

    public Date getCreateTime()
    {
        return this.createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getCTimeStamp()
    {
        return this.cTimeStamp;
    }

    public void setCTimeStamp(Date cTimeStamp)
    {
        this.cTimeStamp = cTimeStamp;
    }

    @Override
    public String toString()
    {
        return this.id + "^" + this.shopId + "^" + this.toolId + "^" + this.toolName + "^" + this.toolUrl + "^" + this.toolIcoFocus + "^" + this.toolIcoUnfocus + "^" + this.toolType + "^" + this.status + "^" + this.localCmd + "^" + this.ver + "^" + this.remark + "^" + this.authority + "^" + this.orderNo + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}