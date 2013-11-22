package com.gooagoo.entity.business.log;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统管理日志表，记录gooagoo平台的系统管理员的操作行为日志
 */

public class SysLogExample implements Serializable
{
    private static final long serialVersionUID = -7626366297906875204L;

    private String sysLogId;//日志编号，唯一，通过UUID产生

    private String userId;//管理员帐号

    private String remoteCode;//所调用的接口编码

    private String sysBehaveType;//操作类型，对应字典表的sys_behave_type

    private String detail;//详细信息（保存在mongodb中）

    private String objectCode;//操作对象编号

    private String operateResult;//操作结果，Y-成功，N-失败

    private String operateIp;//操作IP

    private Date createTime;//创建时间
    private Date createTime_GTE;
    private Date createTime_LTE;

    public String getSysLogId()
    {
        return sysLogId;
    }

    public void setSysLogId(String sysLogId)
    {
        this.sysLogId = sysLogId;
    }

    public String getUserId()
    {
        return userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getRemoteCode()
    {
        return remoteCode;
    }

    public void setRemoteCode(String remoteCode)
    {
        this.remoteCode = remoteCode;
    }

    public String getSysBehaveType()
    {
        return sysBehaveType;
    }

    public void setSysBehaveType(String sysBehaveType)
    {
        this.sysBehaveType = sysBehaveType;
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

    public Date getCreateTime_GTE()
    {
        return createTime_GTE;
    }

    public void setCreateTime_GTE(Date createTime_GTE)
    {
        this.createTime_GTE = createTime_GTE;
    }

    public Date getCreateTime_LTE()
    {
        return createTime_LTE;
    }

    public void setCreateTime_LTE(Date createTime_LTE)
    {
        this.createTime_LTE = createTime_LTE;
    }
}
