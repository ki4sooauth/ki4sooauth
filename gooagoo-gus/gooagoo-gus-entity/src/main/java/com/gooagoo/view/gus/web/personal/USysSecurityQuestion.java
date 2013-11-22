package com.gooagoo.view.gus.web.personal;

import java.io.Serializable;

public class USysSecurityQuestion implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String sysId;//问题编号，UUID

    private String content;//问题内容

    public String getSysId()
    {
        return sysId;
    }

    public void setSysId(String sysId)
    {
        this.sysId = sysId;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

}
