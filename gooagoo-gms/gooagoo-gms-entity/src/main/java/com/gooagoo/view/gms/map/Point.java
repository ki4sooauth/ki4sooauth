package com.gooagoo.view.gms.map;

import java.io.Serializable;

/**
 * 路径上的点
 *
 */
public class Point implements Serializable
{

    private static final long serialVersionUID = 1L;
    private double xp;
    private double yp;

    public Point()
    {

    }

    public Point(SvgPoint p)
    {
        this.xp = p.getPathX();
        this.yp = p.getPathY();
    }

    public Point(double xp, double yp)
    {
        this.xp = xp;
        this.yp = yp;
    }

    public double getXp()
    {
        return this.xp;
    }

    public void setXp(double xp)
    {
        this.xp = xp;
    }

    public double getYp()
    {
        return this.yp;
    }

    public void setYp(double yp)
    {
        this.yp = yp;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Point))
        {
            return false;
        }
        Point point = (Point) obj;
        if (this.xp == point.getXp() && this.yp == point.getYp())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
