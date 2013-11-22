package com.gooaoo.view.common;

import java.io.Serializable;

/**
 * 用于向页面作简单ajax输出
 * @author 王宇
 *
 */
public class GAjax implements Serializable
{
    private static final long serialVersionUID = 2984846487553038164L;
    private Boolean success; //是否成功
    private String message; //提示信息
    private String extend; //扩展

    public GAjax()
    {
        super();
    }

    public GAjax(Boolean success)
    {
        super();
        this.success = success;
    }

    public GAjax(Boolean success, String message)
    {
        super();
        this.success = success;
        this.message = message;
    }

    public Boolean getSuccess()
    {
        return this.success;
    }

    public void setSuccess(Boolean success)
    {
        this.success = success;
    }

    public String getMessage()
    {
        return this.message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public String getExtend()
    {
        return this.extend;
    }

    public void setExtend(String extend)
    {
        this.extend = extend;
    }
}
