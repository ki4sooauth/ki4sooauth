package com.gooagoo.view.gms.map;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 
 * map上动线对象
 *
 */
public class GeneratrixLine extends SvgLine implements Serializable
{
    private static final long serialVersionUID = 1L;
    // 动线的指令列
    private List<PathPosition> pathPositions = new ArrayList<PathPosition>();
    // 动线分段的位置标记
    private List<Integer> sectionPositionIndexs = new ArrayList<Integer>();
    // 动线分段的位置标记点
    private final Map<Integer, PathPosition> sectionPositions = new HashMap<Integer, PathPosition>();

    public List<PathPosition> getPathPositions()
    {
        return this.pathPositions;
    }

    public void setPathPositions(List<PathPosition> pathPositions)
    {
        this.pathPositions = pathPositions;
    }

    public List<Integer> getSectionPositionIndexs()
    {
        return this.sectionPositionIndexs;
    }

    public void setSectionPositionIndexs(List<Integer> sectionPositionIndexs)
    {
        this.sectionPositionIndexs = sectionPositionIndexs;
    }

    public Map<Integer, PathPosition> getSectionPositions()
    {
        return this.sectionPositions;
    }

    public void addSectionPositionIndexs(Integer i)
    {
        this.sectionPositionIndexs.add(i);
        Collections.sort(this.sectionPositionIndexs);
    }
}
