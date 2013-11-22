package com.gooagoo.entity.business.log;

import java.io.Serializable;
import java.util.Date;

/**
 * 商家日志表，记录商家的行为日志
 */

public class ShopLog implements Serializable
{
    private static final long serialVersionUID = -1338951539258267722L;

    private String logId;//日志编号，UUID

    private String shopId;//商家编号

    private String accountId;//子帐号编号，如果来源是管理系统或者店员助理，则为具体的子帐号，如果来源是转发器，则为转发器的mac地址

    private String operateSource;//操作来源，S-管理系统，T-转发器，A-店员助理

    private String remoteCode;//所调用的接口编码

    private String shopBehaveType;//操作类型，对应字典表的shop_behave_type

    private String detail;//详细信息（保存在mongodb中）

    private String objectCode;//操作对象编号

    private String operateResult;//操作结果，Y-成功，N-失败

    private String operateIp;//操作IP（S-管理系统）或mac地址（T-转发器，A-店员助理）

    private Date createTime;//创建时间

    public String getLogId()
    {
        return logId;
    }

    public void setLogId(String logId)
    {
        this.logId = logId;
    }

    public String getShopId()
    {
        return shopId;
    }

    public void setShopId(String shopId)
    {
        this.shopId = shopId;
    }

    public String getAccountId()
    {
        return accountId;
    }

    public void setAccountId(String accountId)
    {
        this.accountId = accountId;
    }

    public String getOperateSource()
    {
        return operateSource;
    }

    public void setOperateSource(String operateSource)
    {
        this.operateSource = operateSource;
    }

    public String getRemoteCode()
    {
        return remoteCode;
    }

    public void setRemoteCode(String remoteCode)
    {
        this.remoteCode = remoteCode;
    }

    public String getShopBehaveType()
    {
        return shopBehaveType;
    }

    public void setShopBehaveType(String shopBehaveType)
    {
        this.shopBehaveType = shopBehaveType;
    }

    public String getDetail()
    {
        return detail;
    }

    public void setDetail(String detail)
    {
        this.detail = detail;
    }

    public String getObjectCode()
    {
        return objectCode;
    }

    public void setObjectCode(String objectCode)
    {
        this.objectCode = objectCode;
    }

    public String getOperateResult()
    {
        return operateResult;
    }

    public void setOperateResult(String operateResult)
    {
        this.operateResult = operateResult;
    }

    public String getOperateIp()
    {
        return operateIp;
    }

    public void setOperateIp(String operateIp)
    {
        this.operateIp = operateIp;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    @Override
    public String toString()
    {
        return this.logId + "^" + this.shopId + "^" + this.accountId + "^" + this.operateSource + "^" + this.remoteCode + "^" + this.shopBehaveType + "^" + this.detail + "^" + this.objectCode + "^" + this.operateResult + "^" + this.operateIp + "^" + this.createTime;
    }
}
