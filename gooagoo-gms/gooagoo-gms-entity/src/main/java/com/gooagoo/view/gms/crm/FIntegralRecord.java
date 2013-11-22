package com.gooagoo.view.gms.crm;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户消费档案
 *
 */
public class FIntegralRecord implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String userName; //用户编号
    private Integer integralNumber; //积分数量
    private String integralSource; //积分来源
    private Date createTime;//时间
    private String note;//备注

    public String getNote()
    {
        return note;
    }

    public void setNote(String note)
    {
        this.note = note;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public Integer getIntegralNumber()
    {
        return integralNumber;
    }

    public void setIntegralNumber(Integer integralNumber)
    {
        this.integralNumber = integralNumber;
    }

    public String getIntegralSource()
    {
        return integralSource;
    }

    public void setIntegralSource(String integralSource)
    {
        this.integralSource = integralSource;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }

    @Override
	public String toString() {
		return "FIntegralRecord [userName=" + userName + ", integralNumber=" + integralNumber + ", integralSource=" + integralSource + ", createTime=" + createTime + ", note=" + note + "]";
	}

}
