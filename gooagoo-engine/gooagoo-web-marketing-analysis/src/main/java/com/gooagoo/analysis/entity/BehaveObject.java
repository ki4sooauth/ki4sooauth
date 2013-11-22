package com.gooagoo.analysis.entity;

import java.io.Serializable;

/**
 * 用户行为日志，记录一般性的行为
 */

public class BehaveObject implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String behaveType;//行为类型

    private Object object;//行为对象

    public String getBehaveType()
    {
        return this.behaveType;
    }

    public void setBehaveType(String behaveType)
    {
        this.behaveType = behaveType;
    }

    public Object getObject()
    {
        return this.object;
    }

    public void setObject(Object object)
    {
        this.object = object;
    }

}
