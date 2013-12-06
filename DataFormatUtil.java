package com.gooagoo.open.utils;

import java.util.List;

import com.gooagoo.open.constants.ComConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;

public class DataFormatUtil
{
    public static String toListXml(Object obj)
    {
        XStream xstream = null;
        if (((List<?>) obj).get(0) instanceof List)
        {
            xstream = new XStream();
            Class<?> classType = ((List<?>) ((List<?>) obj).get(0)).get(0).getClass();
            xstream.alias(classType.getSimpleName(), classType);
        }
        return ComConstants.XML_HEAD + xstream.toXML(((List<?>) obj).get(0)).toLowerCase();
    }

    public static String toXml(Object obj)
    {
        XStream xstream = new XStream();
        xstream.alias(obj.getClass().getSimpleName(), obj.getClass());
        //xstream.alias(List.class.getSimpleName(), List.class);
        return ComConstants.XML_HEAD + xstream.toXML(obj).toLowerCase();
    }

    public static String toJson(Object obj)
    {
        GsonBuilder gb = new GsonBuilder();
        gb.setDateFormat("yyyy-MM-dd HH:mm:ss");
        gb.enableComplexMapKeySerialization();
        Gson gson = gb.create();
        return gson.toJson(obj).toLowerCase();
    }
}
