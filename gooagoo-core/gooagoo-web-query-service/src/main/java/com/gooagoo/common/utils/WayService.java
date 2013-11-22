package com.gooagoo.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gooagoo.entity.business.shop.map.Line;
import com.gooagoo.entity.business.shop.map.Point;

/**
 * 导航算法
 */
public class WayService
{

    private final Map<String, Line> lMap = new HashMap<String, Line>();
    private final Map<String, Set<Line>> pMap = new HashMap<String, Set<Line>>();

    public WayService()
    {

    }

    public void init(List<Line> list)
    {
        // list 从数据库中读取出来
        String key1 = "";
        String key2 = "";
        Set<Line> temp = null;

        for (Line e : list)
        {
            // first point
            key1 = createPointKey(e.getFirstPoint());
            temp = this.pMap.get(key1);
            if (temp == null)
            {
                temp = new HashSet<Line>();
                this.pMap.put(key1, temp);
            }
            temp.add(e);
            // second point
            key2 = createPointKey(e.getSecondPoint());
            temp = this.pMap.get(key2);
            if (temp == null)
            {
                temp = new HashSet<Line>();
                this.pMap.put(key2, temp);
            }
            temp.add(e);
            // lMap 1
            this.lMap.put(createLineKey1(e), e);
            this.lMap.put(createLineKey2(e), e);
        }
    }

    public List<List<Point>> createWay(Point beginPoint, Point endPoint)
    {
        List<Point> pList = new ArrayList<Point>();
        pList.add(beginPoint);
        return this.createWay0(pList, endPoint);
    }

    public List<List<Point>> createWay0(List<Point> pList, Point endPoint)
    {

        List<List<Point>> reList = new ArrayList<List<Point>>();
        Point beginPoint = pList.get(pList.size() - 1);
        Set<Line> lines = this.pMap.get(createPointKey(beginPoint));

        // 没有下一个节点
        if (lines == null || lines.size() == 0)
        {
            return null;
        }
        else
        {
            Iterator<Line> iterator = lines.iterator();
            List<Point> temp = null;
            Line line = null;
            Point eP = null;
            while (iterator.hasNext())
            {
                line = iterator.next();
                eP = line.getEndPoint(beginPoint);
                // line 中的另一点，曾经没有经过
                if (!pList.contains(eP))
                {
                    temp = new ArrayList<Point>();
                    // 到达终点
                    if (eP.equals(endPoint))
                    {
                        temp.addAll(pList);
                        temp.add(endPoint);
                        reList.add(temp);
                    }
                    else
                    {
                        temp.addAll(pList);
                        temp.add(eP);
                        List<List<Point>> recursionList = this.createWay0(temp, endPoint);
                        if (recursionList != null)
                        {
                            reList.addAll(recursionList);
                        }
                    }
                }
            }
        }
        return reList.size() == 0 ? null : reList;
    }

    public List<List<String>> getLinesIdList(List<List<Point>> pList)
    {

        List<List<String>> reList = new ArrayList<List<String>>();
        for (List<Point> p : pList)
        {
            reList.add(this.getIdList(p));
        }
        return reList;
    }

    private List<String> getIdList(List<Point> pList)
    {
        List<String> list = new ArrayList<String>();
        Line line = null;
        if (pList.size() >= 2)
        {
            for (int i = 0; i < pList.size() - 1; i++)
            {
                line = this.lMap.get(createPointsKey(pList.get(i), pList.get(i + 1)));
                list.add(line.getLineId());
            }
        }
        return list;
    }

    // get the point key of map
    public static String createPointKey(Point p)
    {
        return "point_" + p.getXp() + "_" + p.getYp();
    }

    // get the line key1 of map
    public static String createLineKey1(Line line)
    {
        return createPointsKey(line.getFirstPoint(), line.getSecondPoint());
    }

    // get the line key2 of map
    public static String createLineKey2(Line line)
    {
        return createPointsKey(line.getSecondPoint(), line.getFirstPoint());
    }

    // get the tow points key of map
    public static String createPointsKey(Point first, Point second)
    {
        String firstPointKey = createPointKey(first);
        String secondPointKey = createPointKey(second);
        return firstPointKey + "__" + secondPointKey;
    }
}
