package com.gooagoo.position.utils;

import java.awt.Polygon;

public class Geometry
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        java.awt.Polygon polygon = new Polygon();
        polygon.addPoint(393, 369);
        polygon.addPoint(288, 369);
        polygon.addPoint(288, 279);
        /*        polygon.addPoint(393, 279);
                polygon.addPoint(393, 329);
                polygon.addPoint(396, 329);
                polygon.addPoint(396, 279);
                polygon.addPoint(396, 277);
                polygon.addPoint(393, 277);
                polygon.addPoint(288, 277);
                polygon.addPoint(286, 277);
                polygon.addPoint(286, 279);
                polygon.addPoint(286, 369);
                polygon.addPoint(286, 372);
                polygon.addPoint(288, 372);
                polygon.addPoint(393, 372);
                polygon.addPoint(396, 372);
                polygon.addPoint(396, 369);
                polygon.addPoint(396, 349);
                polygon.addPoint(393, 349);*/

        long start = System.currentTimeMillis();
        for (int i = 0; i < 40000000; i++)
        {
            polygon.contains(5, 5);
            //System.out.println(polygon.contains(5, 5));
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
