package com.gooagoo.common.utils;

import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gooagoo.entity.business.shop.map.GeneratrixLine;
import com.gooagoo.entity.business.shop.map.PathPosition;
import com.gooagoo.entity.business.shop.map.SvgPoint;

/**
 * svg 中 path标签处理
 *
 */
public class SvgMapPathUtils
{
    // 两线最短距离，当小于或等于 时为相交，大于为不相交
    public final static int not_cross = 20;

    /**
     * path 路径画线指令 （规定大写 小写都支持）
     *  m l h v z 
     *  c s q t a
     */
    public final static String m_instruction = "m";
    public final static String l_instruction = "l";
    public final static String h_instruction = "h";
    public final static String v_instruction = "v";
    public final static String z_instruction = "z";
    public final static String c_instruction = "c";
    public final static String s_instruction = "s";
    public final static String q_instruction = "q";
    public final static String t_instruction = "t";
    public final static String a_instruction = "a";

    public final static String M_instruction = "M";
    public final static String L_instruction = "L";
    public final static String H_instruction = "H";
    public final static String V_instruction = "V";
    public final static String Z_instruction = "Z";
    public final static String C_instruction = "C";
    public final static String S_instruction = "S";
    public final static String Q_instruction = "Q";
    public final static String T_instruction = "T";
    public final static String A_instruction = "A";

    public final static List<String> instructions = new ArrayList<String>();
    static
    {
        instructions.add(m_instruction);
        instructions.add(l_instruction);
        instructions.add(h_instruction);
        instructions.add(v_instruction);
        instructions.add(z_instruction);

        instructions.add(c_instruction);
        instructions.add(s_instruction);
        instructions.add(q_instruction);
        instructions.add(t_instruction);
        instructions.add(a_instruction);

        instructions.add(M_instruction);
        instructions.add(L_instruction);
        instructions.add(H_instruction);
        instructions.add(V_instruction);
        instructions.add(Z_instruction);

        instructions.add(C_instruction);
        instructions.add(S_instruction);
        instructions.add(Q_instruction);
        instructions.add(T_instruction);
        instructions.add(A_instruction);
    }

    // 获取点到线的距离的 位置值时，在返回值map上的key
    public final static String key_index = "index";
    // 获取点到线的距离的距离值时，在返回值map上的key
    public final static String key_space = "space";
    // 主动线权值
    public final static int big_generatrix_weight = 3;
    // 辅动线权值
    public final static int middle_generatrix_weight = 2;
    // 普通线权值
    public final static int general_generatrix_weight = 1;

    /**
     * 获得path d value的指令list
     * @param pathDValue
     * @return
     */
    public static List<PathPosition> getPathPositions(String pathDValue)
    {
        // 处理字符串
        pathDValue = pathDValue.trim();
        pathDValue = pathDValueDeal(pathDValue);
        String[] splitArray = pathDValue.split(" ");
        if (!splitArray[0].equals(m_instruction) && !splitArray[0].equals(M_instruction))
        {
            return null;
        }

        String tempInstruction = "";
        String array[] = new String[7];
        int arrayLength = 0;

        PathPosition pathPosition = null;
        String instruction = M_instruction;
        double pathX = 0;
        double pathY = 0;

        List<PathPosition> result = new ArrayList<PathPosition>();
        PathPosition tPosition = null;
        for (int i = 0; i < splitArray.length;)
        {
            tempInstruction = splitArray[i];
            // 重新换另一个指令
            if (instructions.contains(tempInstruction))
            {
                i++;
                instruction = tempInstruction;
            }
            // 还是用上一个指令
            else
            {
                tempInstruction = instruction;
            }

            if (tempInstruction.equals(m_instruction) || tempInstruction.equals(M_instruction))
            {
                arrayLength = 2;
                System.arraycopy(splitArray, i, array, 0, arrayLength);
                pathX = Double.parseDouble(array[0]);
                pathY = Double.parseDouble(array[1]);
            }
            else if (tempInstruction.equals(l_instruction) || tempInstruction.equals(L_instruction))
            {
                arrayLength = 2;
                System.arraycopy(splitArray, i, array, 0, arrayLength);
                pathX = Double.parseDouble(array[0]);
                pathY = Double.parseDouble(array[1]);
                if (tempInstruction.equals(l_instruction))
                {
                    tPosition = result.get(result.size() - 1);
                    pathX += tPosition.getPathX();
                    pathY += tPosition.getPathY();
                }
            }
            else if (tempInstruction.equals(h_instruction) || tempInstruction.equals(H_instruction))
            {
                arrayLength = 1;
                System.arraycopy(splitArray, i, array, 0, arrayLength);
                pathX = Double.parseDouble(array[0]);
                if (tempInstruction.equals(h_instruction))
                {
                    tPosition = result.get(result.size() - 1);
                    pathX += tPosition.getPathX();
                }
            }
            else if (tempInstruction.equals(v_instruction) || tempInstruction.equals(V_instruction))
            {
                arrayLength = 1;
                System.arraycopy(splitArray, i, array, 0, arrayLength);
                pathY = Double.parseDouble(array[0]);
                if (tempInstruction.equals(v_instruction))
                {
                    tPosition = result.get(result.size() - 1);
                    pathY += tPosition.getPathY();
                }
            }
            else if (tempInstruction.equals(z_instruction) || tempInstruction.equals(Z_instruction))
            {
                arrayLength = 0;
                System.arraycopy(splitArray, i, array, 0, arrayLength);
            }
            else if (tempInstruction.equals(c_instruction) || tempInstruction.equals(C_instruction))
            {
                arrayLength = 6;
                System.arraycopy(splitArray, i, array, 0, arrayLength);
                pathX = Double.parseDouble(array[4]);
                pathY = Double.parseDouble(array[5]);
                if (tempInstruction.equals(c_instruction))
                {
                    tPosition = result.get(result.size() - 1);
                    pathX += tPosition.getPathX();
                    pathY += tPosition.getPathY();
                }
            }
            else if (tempInstruction.equals(s_instruction) || tempInstruction.equals(S_instruction))
            {
                arrayLength = 4;
                System.arraycopy(splitArray, i, array, 0, arrayLength);
                pathX = Double.parseDouble(array[2]);
                pathY = Double.parseDouble(array[3]);
                if (tempInstruction.equals(s_instruction))
                {
                    tPosition = result.get(result.size() - 1);
                    pathX += tPosition.getPathX();
                    pathY += tPosition.getPathY();
                }
            }
            else if (tempInstruction.equals(q_instruction) || tempInstruction.equals(Q_instruction))
            {
                arrayLength = 4;
                System.arraycopy(splitArray, i, array, 0, arrayLength);
                pathX = Double.parseDouble(array[2]);
                pathY = Double.parseDouble(array[3]);
                if (tempInstruction.equals(q_instruction))
                {
                    tPosition = result.get(result.size() - 1);
                    pathX += tPosition.getPathX();
                    pathY += tPosition.getPathY();
                }
            }
            else if (tempInstruction.equals(t_instruction) || tempInstruction.equals(T_instruction))
            {
                arrayLength = 2;
                System.arraycopy(splitArray, i, array, 0, arrayLength);
                pathX = Double.parseDouble(array[0]);
                pathY = Double.parseDouble(array[1]);
                if (tempInstruction.equals(t_instruction))
                {
                    tPosition = result.get(result.size() - 1);
                    pathX += tPosition.getPathX();
                    pathY += tPosition.getPathY();
                }
            }
            else if (tempInstruction.equals(a_instruction) || tempInstruction.equals(A_instruction))
            {
                arrayLength = 7;
                System.arraycopy(splitArray, i, array, 0, arrayLength);
                pathX = Double.parseDouble(array[5]);
                pathY = Double.parseDouble(array[6]);
                if (tempInstruction.equals(a_instruction))
                {
                    tPosition = result.get(result.size() - 1);
                    pathX += tPosition.getPathX();
                    pathY += tPosition.getPathY();
                }
            }

            pathPosition = new PathPosition();
            pathPosition.setInstruction(instruction);
            pathPosition.setNumString(toStringFromArray(array, arrayLength));
            pathPosition.setPathX(pathX);
            pathPosition.setPathY(pathY);
            result.add(pathPosition);

            i = i + arrayLength;
        }
        return result;
    }

    /**
     * 获得两条path的相交点坐标
     * @param firstPathDValue
     * @param secondPathDValue
     * @return
     */
    public static void markPathsCross(GeneratrixLine line1, GeneratrixLine line2)
    {
        List<PathPosition> firstList = line1.getPathPositions();
        List<PathPosition> secondList = line2.getPathPositions();
        int r[] = getCrostPathPoint0(firstList, secondList);
        if (r != null)
        {
            PathPosition tempPosition = firstList.get(r[0]);
            // line1
            line1.addSectionPositionIndexs(r[0]);
            line1.getSectionPositions().put(r[0], tempPosition);
            // line2
            line2.addSectionPositionIndexs(r[1]);
            line2.getSectionPositions().put(r[1], tempPosition);
        }
    }

    /**
     * 基于 pathPoint点，把path标签 分成两个path标签
     * @param pathDValue path 标签的 d 属性值
     * @param pathPoint 
     * @return list长度为2，两段
     */
    public static List<String> getPaths(String pathDValue, PathPosition pathPosition)
    {
        List<PathPosition> positions = getPathPositions(pathDValue);
        Map<String, Object> reMap = getShortest(pathPosition, positions);
        //        int index = getShortestIndex(pathPoint, points);
        int index = (Integer) reMap.get(key_index);

        List<String> result = new ArrayList<String>();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < positions.size(); i++)
        {
            stringBuffer.append(positions.get(i).toString() + " ");
            if (i == index)
            {
                result.add(new String(stringBuffer));
                stringBuffer = new StringBuffer();

                PathPosition e = positions.get(i + 1);
                stringBuffer.append("m ");
                stringBuffer.append(e.getPathX() + " ");
                stringBuffer.append(e.getPathY() + " ");
            }
        }
        result.add(new String(stringBuffer));

        return result;
    }

    /**
     * 从两个path 标签合并成一个 path标签
     * @param firstPathDValue
     * @param secondPathDValue
     * @return
     */
    public static String getPath(String firstPathDValue, String secondPathDValue)
    {

        return null;
    }

    /**
     * 获得两条path的最近点的索引数组
     * @param firstList
     * @param secondList
     * @return 长度为2，顺序和传入的参数相同
     */
    private static int[] getCrostPathPoint0(List<PathPosition> firstList, List<PathPosition> secondList)
    {

        Map<String, Object> reMap = getShortest(firstList.get(0), secondList);
        double space = (Double) reMap.get(key_space);
        double tempSpace = 0;
        Map<String, Object> tempReMap = null;
        int flag = 0;
        for (int i = 1; i < firstList.size(); i++)
        {
            tempReMap = getShortest(firstList.get(i), secondList);
            tempSpace = (Double) tempReMap.get(key_space);
            if (space > tempSpace)
            {
                space = tempSpace;
                flag = i;
                reMap = tempReMap;
            }
        }
        int[] r = new int[2];
        int index = (Integer) reMap.get(key_index);
        r[0] = flag;
        r[1] = index;
        if (space > not_cross)
        {
            r = null;
        }
        return r;
    }

    /**
     * 获得points中 离 p最近的点的位置值，和最近距离
     * @param p
     * @param points
     * @return map 类型， key为 index 对应value 为 位置值， key 为 space 对应 value 为 距离
     */
    public static Map<String, Object> getShortest(SvgPoint p, List<PathPosition> points)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        int index = 0;
        double space = getSpaceOfTwoPoint(p, points.get(0));
        double tempSpace = 0;
        for (int i = 1; i < points.size(); i++)
        {
            tempSpace = getSpaceOfTwoPoint(p, points.get(i));
            if (space > tempSpace)
            {
                space = tempSpace;
                index = i;
            }
        }
        result.put(key_index, index);
        result.put(key_space, space);
        return result;
    }

    /**
     * 获得两点之间的距离
     * @param p1
     * @param p2
     * @return
     */
    public static double getSpaceOfTwoPoint(SvgPoint p1, SvgPoint p2)
    {
        double x = p1.getPathX() - p2.getPathX();
        double y = p1.getPathY() - p2.getPathY();
        double r = x * x + y * y;
        return Math.sqrt(r);
    }

    /**
     * 处理path d value值
     * 
     * @param pathDValue
     * @return
     */
    private static String pathDValueDeal(String pathDValue)
    {
        // 逗号换空格
        pathDValue = pathDValue.replaceAll(",", " ");
        // 指令标签字符后面没空格的加空格
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(pathDValue.charAt(0) + " ");

        for (int i = 1; i < pathDValue.length(); i++)
        {
            char c1 = pathDValue.charAt(i);
            char c2 = stringBuffer.charAt(stringBuffer.length() - 1);
            if (c1 == ' ')
            {
                if (c2 != ' ')
                {
                    stringBuffer.append(c1);
                }
            }
            else if (instructions.contains(String.valueOf(c1)))
            {
                if (c2 != ' ')
                {
                    stringBuffer.append(" ");
                }
                stringBuffer.append(c1).append(" ");
            }
            else if (c1 == '-')
            {
                if (c2 != ' ')
                {
                    stringBuffer.append(" ");
                }
                stringBuffer.append(c1);
            }
            else
            {
                stringBuffer.append(c1);
            }
        }
        return new String(stringBuffer);
    }

    /**
     * 字符串数组转为 字符串，中间有空格
     * @param array
     * @param length
     * @return
     */
    private static String toStringFromArray(String[] array, int length)
    {

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < length; i++)
        {
            stringBuffer.append(array[i]);
            if (i < length - 1)
            {
                stringBuffer.append(" ");
            }
        }

        return new String(stringBuffer);
    }

    public static String toDValue(List<PathPosition> list)
    {
        StringBuffer stringBuffer = new StringBuffer();
        for (PathPosition p : list)
        {
            stringBuffer.append(p.getInstruction() + " ");
            stringBuffer.append(p.getNumString() + " ");
        }
        return new String(stringBuffer);
    }

    public static double getLineLength(List<PathPosition> list)
    {
        double length = 0;
        for (int i = 0; i < list.size() - 1; i++)
        {
            length += getSpaceOfTwoPoint(list.get(i), list.get(i + 1));
        }
        return length;
    }

    public static void initGeneratrixLine(GeneratrixLine line)
    {
        String dValue = line.getD();
        List<PathPosition> list = getPathPositions(dValue);
        line.setPathPositions(list);
        line.setFirstPoint(list.get(0));
        line.setSecondPoint(list.get(list.size() - 1));
        line.setLength(getLineLength(list));
    }

    /**
     * 点（x,y） 是否在区域内
     * @param points
     * @param x
     * @param y
     * @return
     */
    public static boolean pointIsInPolygon(List<Point> points, double x, double y)
    {
        Polygon pg = new Polygon();
        for (Point p : points)
        {
            pg.addPoint(p.x, p.y);
        }

        return pg.contains(x, y);
    }
}
