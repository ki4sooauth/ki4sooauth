package com.gooagoo.entity.business.marketing.rule;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HistoryCondition implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String crowdId;//人群ID

    private String crowdName;//人群名称ID
    
    private boolean isCustom; //统计类型是否为自定义(只用于用户自定义查询统计)
    
    private String statisticsType; //统计类型(只用于用户自定义查询统计)
    
    private NaturalAttribute naturalAttribute;
    
    private List<ActionAttribute> list = new ArrayList<ActionAttribute>();

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

    public NaturalAttribute getNaturalAttribute()
    {
        return this.naturalAttribute;
    }

    public List<ActionAttribute> getList()
    {
        return this.list;
    }

    public void setNaturalAttribute(NaturalAttribute naturalAttribute)
    {
        this.naturalAttribute = naturalAttribute;
    }

    public void setList(List<ActionAttribute> list)
    {
        this.list = list;
    }

	public String getStatisticsType() {
		return statisticsType;
	}

	public void setStatisticsType(String statisticsType) {
		this.statisticsType = statisticsType;
	}

	public boolean isCustom() {
		return isCustom;
	}

	public void setCustom(boolean isCustom) {
		this.isCustom = isCustom;
	}
	
	
}
