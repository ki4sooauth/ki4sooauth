package com.gooagoo.igms.map.util;

import org.dom4j.DocumentException;
import org.dom4j.Element;

import com.gooagoo.cache.GmsConfigCache;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.HttpClientUtils;

public class SvgMapModuleService
{

    private static Element carGElement;
    private static Element personGElement;

    static
    {
        String baseUrl = GmsConfigCache.get(GMSConstant.HTML_URL_HEAD_KEY);
        String car = HttpClientUtils.loadFileStringByUrl(baseUrl + "/gms/gmap/html/car.svg");
        if (car != null)
        {
            try
            {
                SvgMapXmlParse carParse = new SvgMapXmlParse(car);
                carGElement = carParse.getSvg().element("g");
            }
            catch (DocumentException e)
            {
                GooagooLog.error("/gms/gmap/html/car.svg 车组件 解析失败", e);
                e.printStackTrace();
            }
        }
        else
        {
            GooagooLog.error("/gms/gmap/html/car.svg 车组件 加载失败", null);
        }
        String person = HttpClientUtils.loadFileStringByUrl(baseUrl + "/gms/gmap/html/person.svg");
        if (person != null)
        {
            try
            {
                SvgMapXmlParse personParse = new SvgMapXmlParse(person);
                personGElement = personParse.getSvg().element("g");
            }
            catch (DocumentException e)
            {
                GooagooLog.error("/gms/gmap/html/person.svg 人组件 解析失败", e);
                e.printStackTrace();
            }
        }
        else
        {
            GooagooLog.error("/gms/gmap/html/person.svg 人组件 加载失败 ", null);
        }
    }

    public static Element getCar()
    {
        return carGElement.createCopy();
    }

    public static Element getPerson()
    {
        return personGElement.createCopy();
    }
}
