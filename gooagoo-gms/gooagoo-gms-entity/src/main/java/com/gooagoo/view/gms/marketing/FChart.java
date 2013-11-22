package com.gooagoo.view.gms.marketing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 图表
 */
public class FChart implements Serializable
{
    private static final long serialVersionUID = 1L;

    private List<Map<String, String>> itemsList = new ArrayList<Map<String, String>>(); //存放列表信息
    private List<FLine> line = new ArrayList<FLine>(); //折线图数据
    private List<String> xData = new ArrayList<String>(); //X轴显示数据

    public List<Map<String, String>> getItemsList()
    {
        return this.itemsList;
    }

    public void setItemsList(List<Map<String, String>> itemsList)
    {
        this.itemsList = itemsList;
    }

    public List<String> getxData()
    {
        return this.xData;
    }

    public void setxData(List<String> xData)
    {
        this.xData = xData;
    }

    public List<FLine> getLine()
    {
        return this.line;
    }

    public void setLine(List<FLine> line)
    {
        this.line = line;
    }
}
