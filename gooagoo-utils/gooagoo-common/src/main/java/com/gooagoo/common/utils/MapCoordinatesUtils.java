package com.gooagoo.common.utils;

import java.util.List;

/**
 * 地图坐标工具类
 * @author GOOAGOO
 *
 */
public class MapCoordinatesUtils
{

    /**
     * 定位坐标转化成网格坐标
     * @param locationX 定位坐标x
     * @param locationY 定位坐标y
     * @param ratioLocation 定位坐标系比例
     * @param ratioGrid 网格坐标系比例
     * @param mapRealWidth 地图真实宽度
     * @return 网格坐标int[] { gridX, gridY }
     */
    public static int[] LocationToGrid(Double locationX, Double locationY, Double ratioLocation, Double ratioGrid, Double mapRealWidth)
    {
        int gridX = (int) (locationX * ratioLocation / ratioGrid);
        int gridY = (int) ((mapRealWidth - locationY * ratioLocation) / ratioGrid);
        return new int[] { gridX, gridY };
    }

    /**
     * 定位坐标转化成SVG坐标
     * @param locationX 定位坐标x
     * @param locationY 定位坐标y
     * @param ratioLocation 定位坐标系比例
     * @param ratioSvg SVG坐标系比例
     * @param mapRealWidth 地图真实宽度
     * @return SVG坐标 Double[] { svgX, svgY }
     */
    public static Double[] LocationToSvg(Double locationX, Double locationY, Double ratioLocation, Double ratioSvg, Double mapRealWidth)
    {
        Double svgX = locationX * ratioLocation / ratioSvg;
        Double svgY = (mapRealWidth - locationY * ratioLocation) / ratioSvg;
        return new Double[] { svgX, svgY };
    }

    /**
     * 网格坐标转化成SVG坐标
     * @param gridX 网格坐标x
     * @param gridY 网格坐标y
     * @param ratioGrid 网格坐标系比例
     * @param ratioSvg SVG坐标系比例
     * @return SVG坐标 Double[] { svgX, svgY }
     */
    public static Double[] GridToSvg(int gridX, int gridY, Double ratioGrid, Double ratioSvg)
    {
        Double svgX = gridX * ratioGrid / ratioSvg;
        Double svgY = gridY * ratioGrid / ratioSvg;
        return new Double[] { svgX, svgY };
    }

    /**
     * 网格坐标转化成定位坐标
     * @param gridX 网格坐标x
     * @param gridY 网格坐标y
     * @param ratioGrid 网格坐标系比例
     * @param ratioLocation 定位坐标系比例
     * @param mapRealWidth 地图真实宽度
     * @return 定位坐标 Double[] { locationX, locationY }
     */
    public static Double[] GridToLocation(int gridX, int gridY, Double ratioGrid, Double ratioLocation, Double mapRealWidth)
    {
        Double locationX = gridX * ratioGrid / ratioLocation;
        Double locationY = (mapRealWidth - gridY * ratioGrid) / ratioLocation;
        return new Double[] { locationX, locationY };
    }

    /**
     * svg坐标转化成定位坐标
     * @param svgX
     * @param svgY
     * @param ratioSvg
     * @param ratioLocation
     * @param mapRealWidth
     * @return
     */
    public static Double[] SvgToLocation(Double svgX, Double svgY, Double ratioSvg, Double ratioLocation, Double mapRealWidth)
    {
        Double locationX = svgX * ratioSvg / ratioLocation;
        Double locationY = (mapRealWidth - svgY * ratioSvg) / ratioLocation;
        return new Double[] { locationX, locationY };
    }

    /**
     * svg坐标转化成网格坐标
     * @param svgX
     * @param svgY
     * @param ratioSvg
     * @param ratioGrid
     * @param mapRealWidth
     * @return
     */
    public static int[] SvgToGrid(Double svgX, Double svgY, Double ratioSvg, Double ratioGrid, Double mapRealWidth)
    {
        int gridX = (int) (svgX * ratioSvg / ratioGrid);
        int gridY = (int) (svgY * ratioSvg / ratioGrid);
        return new int[] { gridX, gridY };
    }

    /**
     * 取一组网格坐标的中心点网格坐标,算法是取坐标的平均值。
     * @param coordinates 网格坐标列表，格式：[(x,y),...,(x,y)]
     * @return
     */
    public static int[] getGridCentralCoordinate(List<String> coordinates)
    {
        if (coordinates == null || coordinates.size() == 0)
        {
            return null;
        }

        double sumX = 0d;
        double sumY = 0d;
        for (String str : coordinates)
        {
            String[] coordinate = str.split(","); // 按逗号分割
            sumX += Double.parseDouble(coordinate[0]);//所有x坐标的和
            sumY += Double.parseDouble(coordinate[1]);
        }
        return new int[] { (int) (sumX / coordinates.size()), (int) (sumY / coordinates.size()) };
    }

    /**
     * 根据网格坐标列表取中心坐标的SVG坐标系坐标
     * @param coordinates 
     * @param ratioGrid 网格坐标系比例
     * @param ratioSvg SVG坐标系比例
     * @return SVG坐标 Double[] { svgX, svgY }
     */
    public static Double[] getSvgCentralCoordinate(List<String> coordinates, Double ratioGrid, Double ratioSvg)
    {
        int[] cordinate = getGridCentralCoordinate(coordinates);
        if (cordinate == null || cordinate.length == 0)
        {
            return null;
        }
        return GridToSvg(cordinate[0], cordinate[1], ratioGrid, ratioSvg);
    }
}
