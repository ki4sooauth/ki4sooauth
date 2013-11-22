package com.gooagoo.view.mis.common;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统管理日志表，记录gooagoo平台的系统管理员的操作行为日志
 */

public class MSysLog implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String sysLogId;//日志编号，唯一，通过UUID产生

    private String userId;//管理员帐号

    private String remoteCode;//所调用的接口编码

    private String sysBehaveType;//操作类型，对应字典表的sys_behave_type

    private String detail;//详细信息（保存在mongodb中）

    private String objectCode;//操作对象编号

    private String operateResult;//操作结果，Y-成功，N-失败

    private String operateIp;//操作IP

    private Date createTime;//创建时间

    private Date createTime_F;//创建时间，用于按时间查询，如果此字段有值，可查询出>此字段值的记录

    private Date createTime_T;//创建时间，用于按时间查询，如果此字段有值，可查询出<此字段值的记录

    private Date createTime_FE;//创建时间，用于按时间查询，如果此字段有值，可查询出>=此字段值的记录

    private Date createTime_TE;//创建时间，用于按时间查询，如果此字段有值，可查询出<=此字段值的记录

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

    public Date getCreateTime_F()
    {
        return createTime_F;
    }

    public void setCreateTime_F(Date createTime_F)
    {
        this.createTime_F = createTime_F;
    }

    public Date getCreateTime_T()
    {
        return createTime_T;
    }

    public void setCreateTime_T(Date createTime_T)
    {
        this.createTime_T = createTime_T;
    }

    public Date getCreateTime_FE()
    {
        return createTime_FE;
    }

    public void setCreateTime_FE(Date createTime_FE)
    {
        this.createTime_FE = createTime_FE;
    }

    public Date getCreateTime_TE()
    {
        return createTime_TE;
    }

    public void setCreateTime_TE(Date createTime_TE)
    {
        this.createTime_TE = createTime_TE;
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

}
