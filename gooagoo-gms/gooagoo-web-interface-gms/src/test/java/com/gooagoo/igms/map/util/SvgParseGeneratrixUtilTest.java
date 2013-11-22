package com.gooagoo.igms.map.util;

import java.util.List;

import org.dom4j.Document;

import com.gooagoo.common.gms.utils.GMSFile;
import com.gooagoo.entity.generator.shop.GeneratrixInfo;
import com.gooagoo.entity.generator.shop.SectionLineInfo;
import com.google.gson.Gson;

public class SvgParseGeneratrixUtilTest
{
    public static void main(String[] args)
    {
        long currentTime = System.currentTimeMillis();
        Document document = GMSFile.getDocumentByUrl("http://img.gooagoo.com/module/2013/11/15/xhsd1.svg");
        SvgParseGeneratrixUtil svgUtil = new SvgParseGeneratrixUtil();
        List<GeneratrixInfo> list = svgUtil.getAllGeneratrixInfos(document, "map_123", "#FF0000");
        Gson gson = new Gson();
        for (GeneratrixInfo info : list)
        {
            System.out.println(gson.toJson(info));
        }
        List<SectionLineInfo> list2 = svgUtil.getAllSectionLineInfos(list, "map_123");
        for (SectionLineInfo info : list2)
        {
            System.out.println(gson.toJson(info));
        }

        System.out.println("总共用时：" + (System.currentTimeMillis() - currentTime) + "毫秒");
    }
}
