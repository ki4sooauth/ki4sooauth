package com.gooagoo.common.gms.constants;

/**
 * svg地图的静态变量
 *
 */
public class SvgConstants
{
    /**generatrix_sub
     * 动线
     */
    public final static String line = "Line";// 动线前缀
    public final static String mainLine = "main" + line;// 主动线前缀
    public final static String mainLineType = "1";// 主动线类型标识
    public final static int mainLineWeight = 2;// 主动线权重值
    public final static String subLine = "sub" + line;// 辅动线前缀
    public final static String subLineType = "2";// 辅动线类型标识
    public final static int subLineWeight = 1;//辅动线权重值

    /**
     * 元素 
     *  1,门元素时，他的id需要包含所属的区域id
     */
    public final static String element = "element_";//元素前缀
    public final static String door = "door"; // 门元素前缀
    public final static String doorType = "1";
    public final static String stair = "stair";// 楼梯元素前缀
    public final static String stairType = "2";
    public final static String lift = "lift";// 电梯元素前缀
    public final static String liftType = "3";
    public final static String carbarn = element + "carbarn";// 车库元素前缀
    public final static String carbarnType = "5";
    public final static String lid = element + "lid_";// 设备 lid 位置标记
    public final static String lidType = "6";
    public final static String wifiSonser = element + "wifiSonser_";// 设备wifi sonser
    public final static String wifiSonserType = "7";
    public final static String atm = element + "atm_";// ATM取款机
    public final static String atmType = "8";
    public final static String textType = "9";
    public final static String manRoom = "manroom";// 男卫生间
    public final static String manRoomType = "4";
    public final static String ladyRoom = "ladyroom";// 女卫生间
    public final static String ladyRoomType = "a";

    public final static String undefineType = "0"; // 未定义的元素类型

    /**
     * 区域
     */
    public final static String range = "range";// 整块商铺区域，标记商场整层区域   关联位置id时，不好关联，取实体店的最父区域
    public final static String area = "area";//  普通商铺区域，手动关联区域
    public final static String carport = "carport";// 车位区域
    public final static String out = "out"; // 店外区域，记录行为出店、入店
    public final static String position = "position"; // 营销区域，手动关联区域

    /**
     * 文本
     */
    public final static String text = "_text";// 文本标签

    /**
     * svg图文件里的 元素属性名和属性值
     */
    public final static String notDisplay = "notDisplay";//标签不显示
    public final static String d = "d";// path 的 d属性
    public final static String points = "points";// polygon 的 points属性 
    public final static String id = "id";// id属性

    /**
     * svg图文件的 元素 标签名
     */
    public final static String path = "path"; // path标签
    public final static String rect = "rect"; // rect标签
    public final static String polygon = "polygon";// polygon标签

    /**
     * 元素的组件id值 
     */
    public final static String carModule = "carModule";// 车
    public final static String personModule = "personModule";// 人

}
