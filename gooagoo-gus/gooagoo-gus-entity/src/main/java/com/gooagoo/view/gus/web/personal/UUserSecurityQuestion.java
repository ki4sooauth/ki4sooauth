package com.gooagoo.view.gus.web.personal;

import java.io.Serializable;

public class UUserSecurityQuestion implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String id;//问题编号，UUID

    private String type;//问题类型，1-系统内置问题，2-用户自定义问题

    private String sysId;//系统问题编号

    private String content;//问题内容

    private String answer;//问题答案

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

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

    public String getAnswer()
    {
        return answer;
    }

    public void setAnswer(String answer)
    {
        this.answer = answer;
    }

}
