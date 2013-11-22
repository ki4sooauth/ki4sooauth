package com.gooagoo.igms.map.util;

import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.gooagoo.common.gms.constants.SvgConstants;

public class SvgMapXmlParse
{
    private Document document = null;
    // 全部含有id的节点
    private final List<Element> elements = new ArrayList<Element>();
    // 根节点
    private final Element svg;
    // svg的宽度
    private int width;
    // svg的高度
    private int height;

    public SvgMapXmlParse(String svgContent) throws DocumentException
    {
        SAXReader reader = new SAXReader();
        InputStream is = new ByteArrayInputStream(svgContent.getBytes());
        this.document = reader.read(is);
        this.svg = this.document.getRootElement();
        Attribute attribute = this.svg.attribute("width");
        if (attribute != null)
        {
            String wString = attribute.getText().toLowerCase();
            wString = wString.replace("px", "").trim();
            double w = Double.parseDouble(wString);
            this.width = (int) w;
        }
        attribute = this.svg.attribute("height");
        if (attribute != null)
        {
            String hString = attribute.getText().toLowerCase();
            hString = hString.replace("px", "").trim();
            double h = Double.parseDouble(hString);
            this.height = (int) h;
        }
    }

    @SuppressWarnings("unchecked")
    public Element getMainElement()
    {
        Iterator<Element> iterator = this.svg.elementIterator();
        while (iterator.hasNext())
        {
            Element element = iterator.next();
            String id = this.getElementId(element);
            if (id.equals("main"))
            {
                return element;
            }
        }

        return null;
    }

    public void initIdElements(Element e)
    {
        @SuppressWarnings("unchecked")
        Iterator<Element> iterator = e.elementIterator();
        while (iterator.hasNext())
        {
            Element element = iterator.next();
            if (element.attribute(SvgConstants.id) != null)
            {
                this.elements.add(element);
            }
            this.initIdElements(element);
        }
    }

    public String getElementId(Element element)
    {
        Attribute attribute = element.attribute("id");
        if (attribute != null)
        {
            return attribute.getText();
        }
        else
        {
            return "";
        }
    }

    public void write(String fileName) throws IOException
    {
        XMLWriter writer = new XMLWriter(new FileWriter(fileName));
        writer.write(this.document);
        writer.close();
    }

    /**
     * 获得xml的字符串
     * @return
     */
    public String getXmlString()
    {
        return this.document.asXML();
    }

    /**
     * 添加一个元素
     * @param e
     */
    public void addModule(Element e)
    {
        this.svg.add(e);
    }

    public Element getSvg()
    {
        return this.svg;
    }

    public int getWidth()
    {
        return this.width;
    }

    public int getHeight()
    {
        return this.height;
    }

    public List<Element> getElements()
    {
        return this.elements;
    }
}
