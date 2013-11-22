package com.gooagoo.trans.entity.transdata;

import java.io.Serializable;

public class TransData implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String resultJson;

    public String getResultJson()
    {
        return this.resultJson;
    }

    public void setResultJson(String resultJson)
    {
        this.resultJson = resultJson;
    }

}