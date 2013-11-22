package com.gooagoo.entity.business.shop.map;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * svg 线段
 *
 */
public class SvgLine implements Cloneable, Serializable
{
    private static final long serialVersionUID = 1L;
    // 动线指令集
    private String d;
    // 动线的权重值
    private int weight;
    // 动线的长度
    private double length;
    // 动线的第一个端点
    private SvgPoint firstPoint;
    // 动线的第二个端点
    private SvgPoint secondPoint;

    public String getD()
    {
        return this.d;
    }

    public void setD(String d)
    {
        this.d = d;
    }

    public int getWeight()
    {
        return this.weight;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    public double getLength()
    {
        return this.length;
    }

    public void setLength(double length)
    {
        this.length = length;
    }

    public SvgPoint getFirstPoint()
    {
        return this.firstPoint;
    }

    public void setFirstPoint(SvgPoint firstPoint)
    {
        this.firstPoint = firstPoint;
    }

    public SvgPoint getSecondPoint()
    {
        return this.secondPoint;
    }

    public void setSecondPoint(SvgPoint secondPoint)
    {
        this.secondPoint = secondPoint;
    }

    @Override
    public Object clone()
    {
        Object object = null;
        try
        {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(this);

            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
            ObjectInputStream oi = new ObjectInputStream(bi);
            object = oi.readObject();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return object;
    }
}
