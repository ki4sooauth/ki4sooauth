package com.gooagoo.view.gus.web.cryout;

import java.io.Serializable;
import java.util.List;

public class UCryoutInfo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String cryoutType;//吆喝类型：1-商家推送的新吆喝，2-平台推荐吆喝

    private List<UCryout> cryoutList;//吆喝信息列表

    public String getCryoutType()
    {
        return this.cryoutType;
    }

    public void setCryoutType(String cryoutType)
    {
        this.cryoutType = cryoutType;
    }

    public List<UCryout> getCryoutList()
    {
        return this.cryoutList;
    }

    public void setCryoutList(List<UCryout> cryoutList)
    {
        this.cryoutList = cryoutList;
    }

}
