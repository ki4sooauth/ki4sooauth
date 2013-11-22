package com.gooagoo.view.gms.marketing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class YDataVo implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String name; //图列名称
    private List<Double> data = new ArrayList<Double>(); //数据

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Double> getData()
    {
        return this.data;
    }

    public void setData(List<Double> data)
    {
        this.data = data;
    }
}
