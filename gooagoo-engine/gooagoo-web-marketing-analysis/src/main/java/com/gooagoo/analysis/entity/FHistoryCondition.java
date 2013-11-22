package com.gooagoo.analysis.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FHistoryCondition implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String crowdId;//人群ID

    private String crowdName;//人群名称ID

    private FNaturalAttribute naturalAttribute;

    private List<FActionAttribute> list = new ArrayList<FActionAttribute>();

    public String getCrowdId()
    {
        return this.crowdId;
    }

    public void setCrowdId(String crowdId)
    {
        this.crowdId = crowdId;
    }

    public String getCrowdName()
    {
        return this.crowdName;
    }

    public void setCrowdName(String crowdName)
    {
        this.crowdName = crowdName;
    }

    public FNaturalAttribute getNaturalAttribute()
    {
        return this.naturalAttribute;
    }

    public List<FActionAttribute> getList()
    {
        return this.list;
    }

    public void setNaturalAttribute(FNaturalAttribute naturalAttribute)
    {
        this.naturalAttribute = naturalAttribute;
    }

    public void setList(List<FActionAttribute> list)
    {
        this.list = list;
    }

}
