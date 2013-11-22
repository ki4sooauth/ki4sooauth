package com.gooagoo.view.gms.crm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class YDataVo implements Serializable
{
    private String name; //图列的名称
    private List<Integer> data = new ArrayList<Integer>();

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Integer> getData()
    {
        return data;
    }

    public void setData(List<Integer> data)
    {
        this.data = data;
    }
}
