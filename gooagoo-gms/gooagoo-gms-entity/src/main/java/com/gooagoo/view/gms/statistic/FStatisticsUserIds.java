package com.gooagoo.view.gms.statistic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class FStatisticsUserIds implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String id; //自动编号
    private List<Map<String, String>> mapList = new ArrayList<Map<String, String>>();

    public void setMapList(List<Map<String, String>> mapList)
    {
        this.mapList = mapList;
    }

    private Date createTime;

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public List<Map<String, String>> getMapList()
    {
        return mapList;
    }

    @Override
    public String toString()
    {
        return "FStatisticsUserIds [id=" + id + ", idsMap=" + mapList + ", createTime=" + createTime + "]";
    }

}
