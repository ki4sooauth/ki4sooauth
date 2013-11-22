package com.gooagoo.igms.map.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dom4j.Element;

import com.gooagoo.view.gms.map.GeneratrixLine;
import com.gooagoo.view.gms.map.PathPosition;
import com.gooagoo.view.gms.map.SvgLine;
import com.gooagoo.view.gms.map.SvgPoint;

public class SvgMapGeneratrixLineService implements Serializable
{
    private static final long serialVersionUID = 1L;
    // map上的动线列
    private final List<GeneratrixLine> gLines;
    // map上的门点列
    private final List<SvgPoint> doors;
    // map上分段后的路线列
    private final List<SvgLine> sectionLines;

    // map上动线到 商家入口的线段
    private final List<SvgLine> doorLines;

    public SvgMapGeneratrixLineService(List<GeneratrixLine> generatrixLines, List<SvgPoint> svgPoints)
    {
        this.gLines = generatrixLines;
        this.doors = svgPoints;
        this.sectionLines = new ArrayList<SvgLine>();
        this.doorLines = new ArrayList<SvgLine>();
        for (GeneratrixLine g : this.gLines)
        {
            SvgMapPathHandle.initGeneratrixLine(g);
        }
    }

    public void findCrosses()
    {
        for (int i = 0; i < this.gLines.size() - 1; i++)
        {
            for (int j = i + 1; j < this.gLines.size(); j++)
            {
                SvgMapPathHandle.markPathsCross(this.gLines.get(i), this.gLines.get(j));
            }
        }
    }

    public void findDoors()
    {
        Map<String, Object> reMap = null;
        Map<String, Object> tempReMap = null;
        int flag = 0;
        double space = 0;
        double tempSpace = 0;
        for (int i = 0; i < this.doors.size(); i++)
        {
            reMap = SvgMapPathHandle.getShortest(this.doors.get(i), this.gLines.get(0).getPathPositions());
            space = (Double) reMap.get(SvgMapPathHandle.key_space);
            flag = 0;
            for (int j = 1; j < this.gLines.size(); j++)
            {
                tempReMap = SvgMapPathHandle.getShortest(this.doors.get(i), this.gLines.get(j).getPathPositions());
                tempSpace = (Double) tempReMap.get(SvgMapPathHandle.key_space);
                if (space > tempSpace)
                {
                    reMap = tempReMap;
                    space = tempSpace;
                    flag = j;
                }

            }
            GeneratrixLine line = this.gLines.get(flag);
            int index = (Integer) reMap.get(SvgMapPathHandle.key_index);
            line.addSectionPositionIndexs(index);

            SvgPoint p1 = this.doors.get(i);
            PathPosition p2 = line.getPathPositions().get(index);

            line.getSectionPositions().put(index, p2);

            SvgLine svgLine = (SvgLine) line.clone();
            String dValue = "m " + p1.getPathX() + " " + p1.getPathY() + " " + "l " + (p2.getPathX() - p1.getPathX()) + " " + (p2.getPathY() - p1.getPathY());
            svgLine.setD(dValue);
            //TODO 相当定位，绝对定位
            svgLine.setLength(SvgMapPathHandle.getSpaceOfTwoPoint(p1, p2));
            svgLine.setFirstPoint(p1);
            svgLine.setSecondPoint(p2);
            this.doorLines.add(svgLine);
        }
    }

    public void createSectionLine()
    {
        for (GeneratrixLine g : this.gLines)
        {
            int fromIndex = 0;
            SvgPoint p1 = g.getFirstPoint();
            SvgPoint p2 = null;
            List<Integer> positionIndexs = g.getSectionPositionIndexs();
            List<PathPosition> positions = g.getPathPositions();
            for (int a = 0; a < positionIndexs.size(); a++)
            {

                Integer i = positionIndexs.get(a);
                p2 = g.getSectionPositions().get(i);
                SvgLine svgLine = (SvgLine) g.clone();
                List<PathPosition> svgPoints = positions.subList(fromIndex, i + 1);
                svgLine.setD(SvgMapPathHandle.toDValue(svgPoints));
                svgLine.setFirstPoint(p1);
                svgLine.setSecondPoint(p2);

                svgLine.setLength(SvgMapPathHandle.getLineLength(svgPoints));
                if (a != 0)
                {
                    svgLine.setD(SvgMapPathHandle.toDValue(svgPoints.subList(1, svgPoints.size())));
                    String temp = "m " + svgPoints.get(0).getPathX() + " " + svgPoints.get(0).getPathY() + " ";
                    svgLine.setD(temp + svgLine.getD());
                }
                this.sectionLines.add(svgLine);

                p1 = p2;
                fromIndex = i;
            }

            // 已经分段，最后一段
            if (positionIndexs.size() > 0)
            {
                SvgLine svgLine = (SvgLine) g.clone();
                List<PathPosition> svgPoints = positions.subList(fromIndex, positions.size());
                String temp = "m " + svgPoints.get(0).getPathX() + " " + svgPoints.get(0).getPathY() + " ";
                svgLine.setD(temp + SvgMapPathHandle.toDValue(svgPoints.subList(1, svgPoints.size())));
                svgLine.setFirstPoint(p1);
                svgLine.setSecondPoint(g.getSecondPoint());
                svgLine.setLength(SvgMapPathHandle.getLineLength(svgPoints));
                this.sectionLines.add(svgLine);
            }
            else
            {
                SvgLine svgLine = (SvgLine) g.clone();
                this.sectionLines.add(svgLine);
            }
        }
    }

    public List<SvgLine> getSectionLines()
    {
        return this.sectionLines;
    }

    public List<SvgLine> getDoorLines()
    {
        return this.doorLines;
    }

    public static String getLineTagSvgCode(Element e)
    {

        String name = e.getName();
        String value = "";
        if (name.equals("path"))
        {
            value = e.attribute("d").getText();
        }
        else if (name.equals("line"))
        {
            String x1 = e.attribute("x1").getText();
            String y1 = e.attribute("y1").getText();
            String x2 = e.attribute("x2").getText();
            String y2 = e.attribute("y2").getText();
            value = "M " + x1 + "," + y1 + " L " + x2 + "," + y2;
        }

        return value;
    }
}
