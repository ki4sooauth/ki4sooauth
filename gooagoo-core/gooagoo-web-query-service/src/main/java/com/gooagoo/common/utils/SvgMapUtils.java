package com.gooagoo.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gooagoo.entity.business.shop.map.Line;
import com.gooagoo.entity.business.shop.map.PathPosition;
import com.gooagoo.entity.business.shop.map.Point;
import com.gooagoo.entity.business.shop.map.SvgLine;
import com.gooagoo.entity.business.shop.map.SvgPoint;
import com.gooagoo.entity.generator.shop.SectionLineInfo;

public class SvgMapUtils
{
    /**
     * 导航路径
     * @param lines
     * @param beginPoint
     * @param endPoint
     * @return
     */
    public static List<List<String>> navigation(List<Line> lines, Point beginPoint, Point endPoint)
    {
        WayService wayService = new WayService();
        wayService.init(lines);

        List<List<Point>> pList = wayService.createWay(beginPoint, endPoint);

        return wayService.getLinesIdList(pList);
    }

    /**
     * 离点最近的分段线对象，lineId
     * 点到分段线  svgLine1  对应firstPoint
     * 点到分段线  svgLine2  对应secondPoint
     * 导航起点  beginPoint         --> firstPoint
     * 
     * @param point
     * @param list 
     * @return
     */
    public static Map<String, Object> getBeginPoint(Point point, List<SectionLineInfo> list)
    {
        if (point == null || list == null || list.size() == 0)
        {
            return null;
        }

        SectionLineInfo lineInfo = list.get(0);
        // 点
        SvgPoint svgPoint = new SvgPoint();
        svgPoint.setPathX(point.getXp());
        svgPoint.setPathY(point.getYp());
        String firstLine = "m " + point.getXp() + " " + point.getYp() + " ";

        String dValue = lineInfo.getSvgTagCode();
        List<PathPosition> pathPositions = SvgMapPathHandleUtils.getPathPositions(dValue);
        Map<String, Object> reMap = SvgMapPathHandleUtils.getShortest(svgPoint, pathPositions);
        // 多条分段线时，获得离点最近的那条分线段
        if (list.size() > 1)
        {
            double space = (Double) reMap.get(SvgMapPathHandleUtils.key_space);

            Map<String, Object> tempReMap = null;
            double tempSpace = 0;

            for (int i = 1; i < list.size(); i++)
            {
                String tempdValue = list.get(i).getSvgTagCode();
                List<PathPosition> tempPathPositions = SvgMapPathHandleUtils.getPathPositions(tempdValue);
                tempReMap = SvgMapPathHandleUtils.getShortest(svgPoint, tempPathPositions);
                tempSpace = (Double) tempReMap.get(SvgMapPathHandleUtils.key_space);
                if (space > tempSpace)
                {
                    space = tempSpace;
                    lineInfo = list.get(i);
                    pathPositions = tempPathPositions;
                    reMap = tempReMap;
                }
            }
        }
        // 导航起点
        Point beginPoint = new Point();
        beginPoint.setXp(lineInfo.getFirstPointX());
        beginPoint.setYp(lineInfo.getFirstPointY());

        // 线段分成两段
        SvgPoint p1 = new SvgPoint();
        p1.setPathX(lineInfo.getFirstPointX());
        p1.setPathY(lineInfo.getFirstPointY());
        SvgPoint p2 = new SvgPoint();
        p2.setPathX(lineInfo.getSecondPointX());
        p2.setPathY(lineInfo.getSecondPointY());

        SvgLine svgLine1 = new SvgLine();
        svgLine1.setWeight(lineInfo.getWeight());

        int index = (Integer) reMap.get(SvgMapPathHandleUtils.key_index);
        SvgPoint p = pathPositions.get(index);
        firstLine += "L" + p.getPathX() + " " + p.getPathY();

        List<PathPosition> svgPoints = pathPositions.subList(0, index + 1);
        svgLine1.setD(SvgMapPathHandleUtils.toDValue(svgPoints));
        svgLine1.setFirstPoint(p1);
        svgLine1.setSecondPoint(p);
        svgLine1.setLength(SvgMapPathHandleUtils.getLineLength(svgPoints));

        SvgLine svgLine2 = new SvgLine();
        svgLine2.setWeight(lineInfo.getWeight());

        svgPoints = pathPositions.subList(index, pathPositions.size());
        String temp = "m " + svgPoints.get(0).getPathX() + " " + svgPoints.get(0).getPathY() + " ";
        svgLine2.setD(temp + SvgMapPathHandleUtils.toDValue(svgPoints.subList(1, svgPoints.size())));
        svgLine2.setFirstPoint(p);
        svgLine2.setSecondPoint(p2);
        svgLine2.setLength(SvgMapPathHandleUtils.getLineLength(svgPoints));

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("lineId", lineInfo.getLineId());
        map.put("svgLine1", svgLine1);
        map.put("svgLine2", svgLine2);
        map.put("beginPoint", beginPoint);
        map.put("firstLine", firstLine);

        return map;
    }

    // 获得线段列
    public static List<Line> getLines(List<SectionLineInfo> infos)
    {
        List<Line> reList = new ArrayList<Line>();
        for (SectionLineInfo e : infos)
        {
            Line line = getLine(e);
            reList.add(line);
        }
        return reList;
    }

    // 获得线段
    public static Line getLine(SectionLineInfo e)
    {

        Line line = new Line();
        line.setLineId(e.getLineId());

        Point p1 = new Point();
        p1.setXp(e.getFirstPointX());
        p1.setYp(e.getFirstPointY());
        line.setFirstPoint(p1);

        Point p2 = new Point();
        p2.setXp(e.getSecondPointX());
        p2.setYp(e.getSecondPointY());
        line.setSecondPoint(p2);

        return line;
    }

    public static List<String> getShortLine(Map<String, Object> beginMap, List<List<String>> ways, List<SectionLineInfo> lines)
    {
        SvgLine svgLine1 = (SvgLine) beginMap.get("svgLine1");
        SvgLine svgLine2 = (SvgLine) beginMap.get("svgLine2");
        String lineId = (String) beginMap.get("lineId");

        Map<String, SectionLineInfo> map = new HashMap<String, SectionLineInfo>();
        for (SectionLineInfo e : lines)
        {
            map.put(e.getLineId(), e);
        }

        // 被分两端的线段长度
        double l = map.get(lineId).getLength();
        // 被分两端线段中离firstPoint近的线段的长度
        double l1 = svgLine1.getLength();
        // 被分两端线段中离secondPoint近的线段的长度
        double l2 = svgLine2.getLength();

        double length = 0;
        // true 表示经过被分线段 ，false表示没有经过被分线段
        boolean flag = true;

        // i=1
        List<String> list = ways.get(0);
        length = getLinesLength(list, map);
        if (list.contains(lineId))
        {
            flag = true;
            length = length - l + l2;
        }
        else
        {
            flag = false;
            length += l1;
        }
        // i>1
        for (int i = 1; i < ways.size(); i++)
        {
            List<String> tempList = ways.get(i);
            double tempLength = getLinesLength(tempList, map);
            if (tempList.contains(lineId))
            {
                tempLength = tempLength - l + l2;
                if (length > tempLength)
                {
                    flag = true;
                    list = tempList;
                }
            }
            else
            {
                tempLength += l1;
                if (length > tempLength)
                {
                    flag = false;
                    list = tempList;
                }
            }
        }

        List<String> r = new ArrayList<String>();

        for (String e : list)
        {
            r.add(map.get(e).getSvgTagCode());
        }

        if (flag)
        {
            r.set(0, svgLine2.getD());
        }
        else
        {
            r.add(0, svgLine1.getD());
        }
        String firstLine = (String) beginMap.get("firstLine");
        r.add(0, firstLine);

        return r;
    }

    // 获得路线的长度
    private static double getLinesLength(List<String> lineIds, Map<String, SectionLineInfo> iMap)
    {
        double length = 0;
        for (String e : lineIds)
        {
            length += iMap.get(e).getLength();
        }
        return length;
    }
}
