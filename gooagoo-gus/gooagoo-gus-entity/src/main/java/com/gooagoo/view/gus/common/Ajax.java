package com.gooagoo.view.gus.common;

import java.io.Serializable;

public class Ajax implements Serializable
{
    private static final long serialVersionUID = 2984846487553038164L;

    private boolean success; //是否成功

    private String message;//提示信息

    private Object data;//数据

    public Ajax()
    {
        super();
    }

    public Ajax(Boolean success, Object data)
    {
        super();
        this.success = success;
        this.data = data;
    }

    public boolean getSuccess()
    {
        return this.success;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public void setSuccess(boolean success)
    {
        this.success = success;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

}
