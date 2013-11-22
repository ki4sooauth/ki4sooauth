package com.gooagoo.entity.generator.user;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户密保卡表
 */

public class UserSecurityCard implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//密保卡编号，UUID

    private String userId;//用户编号

    private String serialNum;//密保卡序列号

    private String coordData;//密保卡坐标数据，JSON串格式

    private String isBind;//'是否已绑定，Y-已绑定，N-未绑定',

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

    public String getUserId()
    {
        return this.userId;
    }

    public void setUserId(String userId)
    {
        this.userId = userId;
    }

    public String getSerialNum()
    {
        return this.serialNum;
    }

    public void setSerialNum(String serialNum)
    {
        this.serialNum = serialNum;
    }

    public String getCoordData()
    {
        return this.coordData;
    }

    public void setCoordData(String coordData)
    {
        this.coordData = coordData;
    }

    public String getIsBind()
    {
        return this.isBind;
    }

    public void setIsBind(String isBind)
    {
        this.isBind = isBind;
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
        return this.id + "^" + this.userId + "^" + this.serialNum + "^" + this.coordData + "^" + this.isBind + "^" + this.isDel + "^" + this.createTime + "^" + this.cTimeStamp;
    }
}
