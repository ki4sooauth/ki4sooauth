package com.gooagoo.igms.map.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;

import com.gooagoo.common.gms.constants.SvgConstants;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.StringUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.shop.GeneratrixInfo;
import com.gooagoo.entity.generator.shop.SectionLineInfo;
import com.gooagoo.view.gms.map.GeneratrixLine;
import com.gooagoo.view.gms.map.SvgLine;

/**
 * 解析动线和分线段工具类
 */
public class SvgParseGeneratrixUtil
{
    /**
     * 动线标签类型
     */
    private final String[] generatrixType = { "path", "line" };

    /**
     * 解析所有的动线
     * @param svgContent svg图内容
     * @param mapId 地图ID
     * @param color 颜色值 （如：#FFFFFF，六位十六进制数）
     * @return
     */
    public List<GeneratrixInfo> getAllGeneratrixInfos(Document document, String mapId, String color)
    {
        List<GeneratrixInfo> result = new ArrayList<GeneratrixInfo>();

        List<Element> elements = new ArrayList<Element>();
        Element root = document.getRootElement();

        this.getAllGeneratrixs(elements, root, color);

        if (elements != null & elements.size() > 0)
        {

            for (Element e : elements)
            {
                GeneratrixInfo generatrixInfo = new GeneratrixInfo();
                generatrixInfo.setGeneratrixId(UUID.getUUID());
                generatrixInfo.setMapId(mapId);
                int width = this.getLineWidth(e);
                if (width > 5)
                {
                    generatrixInfo.setGeneratrixType(SvgConstants.mainLineType);
                }
                else
                {
                    generatrixInfo.setGeneratrixType(SvgConstants.subLineType);
                }
                generatrixInfo.setSvgTagId("");
                generatrixInfo.setSvgTagCode(SvgMapGeneratrixLineService.getLineTagSvgCode(e));
                generatrixInfo.setCreateTime(new Date());

                GooagooLog.debug("动线标签名：" + e.getName() + "，动线：" + e.toString());

                result.add(generatrixInfo);
            }
        }
        return result;
    }

    /**
     * 获取所有的动线元素
     * @param elements 动线元素集合
     * @param e 根元素
     */
    @SuppressWarnings("unchecked")
    private void getAllGeneratrixs(List<Element> elements, Element e, String color)
    {
        Iterator<Element> iterator = e.elementIterator();
        while (iterator.hasNext())
        {
            Element element = iterator.next();
            if (this.isGeneratrix(element, color))
            {
                elements.add(element);
            }
            else
            {
                this.getAllGeneratrixs(elements, element, color);
            }
        }
    }

    /**
     * 判断指定元素是否包含特定的填充颜色
     * @param e
     * @param color
     * @return
     */
    private boolean isGeneratrix(Element e, String color)
    {
        boolean flag = false;
        String tagName = e.getName();
        for (String str : this.generatrixType)
        {
            if (str == tagName || str.equals(tagName))
            {
                flag = true;
                break;
            }
        }
        if (flag)
        {
            Attribute attr = e.attribute("stroke");
            if (attr != null && (attr.getValue().trim() == color || attr.getValue().trim().equals(color)))
            {
                GooagooLog.debug("1:" + attr.getValue());
                return true;
            }
            else
            {
                attr = e.attribute("style");
                if (attr != null && attr.getValue().trim().contains("stroke:" + color))
                {
                    GooagooLog.debug("2:" + attr.getValue());
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 根据所有动线，打成分线段列表
     * @param generatrixInfos
     * @param mapId
     * @return
     */
    public List<SectionLineInfo> getAllSectionLineInfos(List<GeneratrixInfo> generatrixInfos, String mapId)
    {
        List<GeneratrixLine> generatrixLines = this.getGeneratrixInfos(generatrixInfos);

        SvgMapGeneratrixLineService service = new SvgMapGeneratrixLineService(generatrixLines, null);
        service.findCrosses();
        service.createSectionLine();

        List<SvgLine> list = service.getSectionLines();

        List<SectionLineInfo> rList = new ArrayList<SectionLineInfo>();
        for (SvgLine line : list)
        {
            SectionLineInfo lineInfo = new SectionLineInfo();

            lineInfo.setLineId(StringUtils.getUUID());
            lineInfo.setMapId(mapId);
            lineInfo.setSvgTagCode(line.getD());
            lineInfo.setWeight(line.getWeight());
            lineInfo.setLength(line.getLength());
            lineInfo.setFirstPointX(line.getFirstPoint().getPathX());
            lineInfo.setFirstPointY(line.getFirstPoint().getPathY());
            lineInfo.setSecondPointX(line.getSecondPoint().getPathX());
            lineInfo.setSecondPointY(line.getSecondPoint().getPathY());
            lineInfo.setCreateTime(new Date());

            rList.add(lineInfo);
        }

        return rList;
    }

    /**
     * 获得动线对象
     * @param infos
     * @return
     */
    private List<GeneratrixLine> getGeneratrixInfos(List<GeneratrixInfo> infos)
    {
        List<GeneratrixLine> rList = new ArrayList<GeneratrixLine>();
        for (GeneratrixInfo info : infos)
        {
            GeneratrixLine line = new GeneratrixLine();
            line.setD(info.getSvgTagCode());
            // 动线类型决定权重
            if (info.getGeneratrixType().equals(SvgConstants.mainLineType))
            {
                line.setWeight(SvgConstants.mainLineWeight);
            }
            else
            {
                line.setWeight(SvgConstants.subLineWeight);
            }
            rList.add(line);
        }
        return rList;
    }

    private int getLineWidth(Element e)
    {
        int width = 1;
        try
        {
            String attr = e.attribute("stroke-width").getValue();
            if (attr == null)
            {
                attr = e.attribute("style").getValue();
                attr = attr.substring(attr.indexOf("stroke-width"));
                if (attr.indexOf(";") != -1)
                {
                    attr = attr.substring(0, attr.indexOf(";"));
                }
                attr = attr.replace("stroke-width:", "");
            }

            width = new Double(attr).intValue();
        }
        catch (Exception exception)
        {
            GooagooLog.error("获取动线宽度出错：", exception);
        }

        return width;
    }
}
