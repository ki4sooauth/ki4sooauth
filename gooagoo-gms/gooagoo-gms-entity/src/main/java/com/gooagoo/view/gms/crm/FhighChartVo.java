package com.gooagoo.view.gms.crm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FhighChartVo implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String tableName; //表名称 
    private String yName; //轴明称 
    private String unit;//单位
    private List<String> xData = new ArrayList<String>(); //x轴数据
    private List<String> xCode = new ArrayList<String>(); //x轴编码
    private List<YDataVo> yDataVos = new ArrayList<YDataVo>();//y轴数据

    public String getUnit()
    {
        return this.unit;
    }

    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public void setxData(List<String> xData)
    {
        this.xData = xData;
    }

    public void setyDataVos(List<YDataVo> yDataVos)
    {
        this.yDataVos = yDataVos;
    }

    public String getTableName()
    {
        return this.tableName;
    }

    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    public String getyName()
    {
        return this.yName;
    }

    public void setyName(String yName)
    {
        this.yName = yName;
    }

    public List<String> getxData()
    {
        return this.xData;
    }

    public List<String> getxCode()
    {
        return this.xCode;
    }

    public void setxCode(List<String> xCode)
    {
        this.xCode = xCode;
    }

    public List<YDataVo> getyDataVos()
    {
        return this.yDataVos;
    }

    public void addYDate(Integer date)
    {
        YDataVo vo = new YDataVo();
        vo.getData().add(date);
        this.yDataVos.add(vo);
    }
}
