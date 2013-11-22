package com.gooagoo.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gooagoo.entity.business.statistics.ChartVo;
import com.gooagoo.entity.business.statistics.ColumnVO;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;

public class AnalysisUtils
{
    public static int getAge(Date birthday)
    {
        int age = 0;
        try
        {
            age = Calendar.getInstance().get(Calendar.YEAR) - birthday.getYear();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return age;
    }

    public static String getAgeRange(Date birthday)
    {
        String ageRange = "未知";
        int age = getAge(birthday);
        if (age <= 15)
        {
            ageRange = "15岁以下";
        }
        if (age > 15 && age <= 25)
        {
            ageRange = "15-25岁";
        }
        if (age > 25 && age <= 35)
        {
            ageRange = "25-35岁";
        }
        if (age > 35 && age <= 45)
        {
            ageRange = "35-45岁";
        }
        if (age > 45 && age <= 55)
        {
            ageRange = "45-55岁";
        }
        if (age > 45)
        {
            ageRange = "55岁以上";
        }
        return ageRange;
    }

    public static ChartVo converToChartVo(BasicDBList list, String xkey, String ykey)
    {
        List<String> xlabel = new ArrayList<String>();
        List<Long> yvalue = new ArrayList<Long>();
        for (Object object : list)
        {
            BasicDBObject bo = (BasicDBObject) object;
            xlabel.add(bo.getString(xkey));
            yvalue.add(bo.getLong(ykey));
        }
        ChartVo cvo = new ChartVo();
        cvo.setxData(xlabel);
        Map<String, List<Long>> yData = new HashMap<String, List<Long>>();
        yData.put("column", yvalue);
        cvo.setyData(yData);
        return cvo;
    }

    public static ChartVo converToChartVo(BasicDBList list, String xkey, String ykey, int topn, String otherLabel)
    {
        List<ColumnVO> tarList = new ArrayList();
        if (list != null && list.size() > topn)
        {
            for (Object object : list)
            {
                BasicDBObject bo = (BasicDBObject) object;
                ColumnVO cvo = new ColumnVO();
                cvo.setLable(bo.getString(xkey));
                cvo.setValue(bo.getLong(ykey));
                tarList.add(cvo);
            }

            for (int i = 0; i < topn; i++)
            {
                for (int j = tarList.size() - 1; j > i; j--)
                {
                    ColumnVO v1 = tarList.get(j);
                    ColumnVO v2 = tarList.get(j - 1);
                    if (v1.getValue() > v2.getValue())
                    {
                        tarList.remove(j);
                        tarList.add(j - 1, v1);
                    }
                }
            }

            long others = 0;
            for (int p = topn; p < tarList.size(); p++)
            {
                others += tarList.get(p).getValue();
            }
            ColumnVO column = new ColumnVO();
            column.setLable(otherLabel);
            column.setValue(others);
            tarList.add(topn, column);

            List<String> xlabel = new ArrayList<String>();
            List<Long> yvalue = new ArrayList<Long>();
            for (int k = 0; k <= topn; k++)
            {
                ColumnVO obj = tarList.get(k);
                xlabel.add(obj.getLable());
                yvalue.add(obj.getValue());
            }

            ChartVo cvo = new ChartVo();
            cvo.setxData(xlabel);
            Map<String, List<Long>> yData = new HashMap<String, List<Long>>();
            yData.put("column", yvalue);
            cvo.setyData(yData);
            return cvo;
        }
        else
        {
            return converToChartVo(list, xkey, ykey);
        }
    }

    public static String generateFeatureCode(String featureCode)
    {
        return "ft_" + featureCode;
    }
}
