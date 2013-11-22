package com.gooagoo.view.gms.marketing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LineVo implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String tableName;// 图表名称
    private String subTableName;// 副图表名称
    private String yName;// Y轴标记名称
    private List<String> xData = new ArrayList<String>(); //横坐标数据
    private List<YDataVo> yData = new ArrayList<YDataVo>(); //纵坐标数据

    public List<String> getxData()
    {
        return this.xData;
    }

    public void setxData(List<String> xData)
    {
        this.xData = xData;
    }

    public List<YDataVo> getyData()
    {
        return this.yData;
    }

    public void setyData(List<YDataVo> yData)
    {
        this.yData = yData;
    }

    public String getTableName()
    {
        return this.tableName;
    }

    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    public String getSubTableName()
    {
        return this.subTableName;
    }

    public void setSubTableName(String subTableName)
    {
        this.subTableName = subTableName;
    }

    public String getyName()
    {
        return this.yName;
    }

    public void setyName(String yName)
    {
        this.yName = yName;
    }
}
