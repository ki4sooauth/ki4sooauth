package com.gooagoo.position.utils;

public class CoordinateTransformationUtil
{
    /**
     * 真实X坐标转SVG图X坐标
     * @param x 真实坐标系X坐标
     * @param ratio_real 真实坐标系比例系数
     * @param ratio_svg SVG图坐标系比例系数
     * @return
     */
    public static long realToSvgX(int x, double ratio_real, double ratio_svg)
    {
        return (long) (x * ratio_real / ratio_svg);
    }

    /**
     * 真实Y坐标转SVG图Y坐标
     * @param y 真实坐标系Y坐标
     * @param map_real_height 地图真实高度
     * @param ratio_real 真实坐标系比例系数
     * @param ratio_svg SVG图坐标系比例系数
     * @return
     */
    public static long realToSvgY(int y, double map_real_height, double ratio_real, double ratio_svg)
    {
        return (long) ((map_real_height - y * ratio_real) / ratio_svg);
    }

    /**
     * 真实X坐标转网格X坐标
     * @param x 真实X坐标
     * @param ratio_real 真实坐标比例系数
     * @param ratio_grid 网格坐标比例系数
     * @return
     */
    public static int realToGridX(int x, double ratio_real, double ratio_grid)
    {
        return (int) (x * ratio_real / ratio_grid);
    }

    /**
     * 真实Y坐标转网络Y坐标
     * @param y 真实Y坐标
     * @param map_real_height 地图真实高度
     * @param ratio_real 真实坐标比例系数
     * @param ratio_grid 网格坐标比例系数
     * @return
     */
    public static int realToGridY(int y, double map_real_height, double ratio_real, double ratio_grid)
    {
        return (int) ((map_real_height - y * ratio_real) / ratio_grid);
    }
}
