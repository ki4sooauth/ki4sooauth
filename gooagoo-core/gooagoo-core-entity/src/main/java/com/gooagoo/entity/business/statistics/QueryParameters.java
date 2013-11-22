package com.gooagoo.entity.business.statistics;

import java.io.Serializable;

import com.gooagoo.entity.business.marketing.rule.HistoryCondition;

public class QueryParameters implements Serializable
{
    private static final long serialVersionUID = 8283638679125711936L;

    private String _id;
    private String corpId;
    private String queryName;
    private String queryDesc;
    private String analysisType;
    
    private String condition;

    public String getAnalysisType()
    {
        return this.analysisType;
    }

    public void setAnalysisType(String analysisType)
    {
        this.analysisType = analysisType;
    }


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

    public String getCondition()
    {
        return this.condition;
    }

    public void setCondition(String condition)
    {
        this.condition = condition;
    }
}
