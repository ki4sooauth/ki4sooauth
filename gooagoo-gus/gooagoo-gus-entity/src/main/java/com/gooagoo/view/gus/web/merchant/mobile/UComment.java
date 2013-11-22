package com.gooagoo.view.gus.web.merchant.mobile;

import java.io.Serializable;

public class UComment implements Serializable
{

    private static final long serialVersionUID = 1L;

    private String nickName;//评论人昵称

    private Integer level;//评论星级

    private String content;//评论内容

    private String time;//评论时间

    public String getNickName()
    {
        return nickName;
    }

    public void setNickName(String nickName)
    {
        this.nickName = nickName;
    }

    public Integer getLevel()
    {
        return level;
    }

    public void setLevel(Integer level)
    {
        this.level = level;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }

}
