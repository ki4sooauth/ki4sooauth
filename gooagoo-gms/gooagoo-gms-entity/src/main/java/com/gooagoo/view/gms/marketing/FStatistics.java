package com.gooagoo.view.gms.marketing;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 折线数据
 */
public class FStatistics implements Serializable
{
    private static final long serialVersionUID = 1L;

    private String name;
    private List<Integer> data = new ArrayList<Integer>();

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<Integer> getData()
    {
        return this.data;
    }

    public void setData(List<Integer> data)
    {
        this.data = data;
    }
}
