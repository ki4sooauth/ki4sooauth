package com.gooagoo.view.gms.marketing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PieVo implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String name; //饼状图名称
    private String tipName; // 图的tipname
    private List<String> key = new ArrayList<String>();// 名
    private List<Double> value = new ArrayList<Double>();// 值

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<String> getKey()
    {
        return this.key;
    }

    public void setKey(List<String> key)
    {
        this.key = key;
    }

    public List<Double> getValue()
    {
        return this.value;
    }

    public void setValue(List<Double> value)
    {
        this.value = value;
    }

    public String getTipName()
    {
        return this.tipName;
    }

    public void setTipName(String tipName)
    {
        this.tipName = tipName;
    }
}
