package com.gooagoo.entity.business.statistics;

import java.io.Serializable;

public class BasicQueryParameters implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String _id;
    private String corpId;
    private String queryName;
    private String queryDesc;

    public String get_id()
    {
        return this._id;
    }

    public void set_id(String _id)
    {
        this._id = _id;
    }

    public String getCorpId()
    {
        return this.corpId;
    }

    public void setCorpId(String corpId)
    {
        this.corpId = corpId;
    }

    public String getQueryName()
    {
        return this.queryName;
    }

    public void setQueryName(String queryName)
    {
        this.queryName = queryName;
    }

    public String getQueryDesc()
    {
        return this.queryDesc;
    }

    public void setQueryDesc(String queryDesc)
    {
        this.queryDesc = queryDesc;
    }
}
