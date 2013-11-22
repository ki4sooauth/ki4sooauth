package com.gooagoo.entity.business.shop.map;

import java.io.Serializable;

/**
 * ·路径上的线
 * 
 */
public class Line implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String lineId;
    private Point firstPoint;
    private Point secondPoint;

    public Line()
    {

    }

    public Line(String lineId, Point first, Point second)
    {
        this.lineId = lineId;
        this.firstPoint = first;
        this.secondPoint = second;
    }

    public String getLineId()
    {
        return this.lineId;
    }

    public void setLineId(String lineId)
    {
        this.lineId = lineId;
    }

    public Point getFirstPoint()
    {
        return this.firstPoint;
    }

    public void setFirstPoint(Point firstPoint)
    {
        this.firstPoint = firstPoint;
    }

    public Point getSecondPoint()
    {
        return this.secondPoint;
    }

    public void setSecondPoint(Point secondPoint)
    {
        this.secondPoint = secondPoint;
    }

    public Point getEndPoint(Point beginPoint)
    {
        if (beginPoint.equals(this.firstPoint))
        {
            return this.secondPoint;
        }
        else
        {
            return this.firstPoint;
        }
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Line))
        {
            return false;
        }
        Line line = (Line) obj;
        if (this.firstPoint.equals(line.getFirstPoint()) && this.secondPoint.equals(line.getSecondPoint()))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
