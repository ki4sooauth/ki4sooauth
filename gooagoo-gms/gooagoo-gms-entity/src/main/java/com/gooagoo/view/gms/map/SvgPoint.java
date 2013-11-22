package com.gooagoo.view.gms.map;

import java.io.Serializable;

public class SvgPoint implements Serializable
{

    private static final long serialVersionUID = 1L;
    private double pathX;
    private double pathY;

    public double getPathX()
    {
        return this.pathX;
    }

    public void setPathX(double pathX)
    {
        this.pathX = pathX;
    }

    public double getPathY()
    {
        return this.pathY;
    }

    public void setPathY(double pathY)
    {
        this.pathY = pathY;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof SvgPoint)
        {
            return false;
        }
        SvgPoint point = (SvgPoint) obj;
        if (point.getPathX() == this.getPathX() && point.getPathY() == this.getPathY())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
