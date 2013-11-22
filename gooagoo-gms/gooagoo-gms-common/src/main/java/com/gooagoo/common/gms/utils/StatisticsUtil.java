package com.gooagoo.common.gms.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.gooagoo.cache.GmsConfigCache;
import com.gooagoo.common.log.GooagooLog;

/**
 * 统计工具类
 *
 */
public class StatisticsUtil
{
    // value 类型值，生成url是对应的类型目录
    private static List<String> statisticsType = new ArrayList<String>();
    private static String baseUrl = null;
    static
    {
        baseUrl = GmsConfigCache.get("statistics_file_url_head");
        if (!StringUtils.hasText(baseUrl))
        {
            GooagooLog.warn("===========从缓存中获取统计数据文件访问头部地址为空");
        }
        statisticsType.add("tools");
        statisticsType.add("coupon");
        statisticsType.add("brand");
        statisticsType.add("category");
        statisticsType.add("goods");
        statisticsType.add("activity");
        statisticsType.add("cryout");
        statisticsType.add("notice");
    }

    /**
     * 根据传入参数，生成图形文件路径
     * @param content
     * @return
     */
    public static String createGraphUrl(String type, String content)
    {
        if (content.isEmpty())
        {
            return "";
        }
        if (!statisticsType.contains(type))
        {
            return "";
        }
        return baseUrl + type + "/" + content + ".txt";
        // 测试使用
        //        return "http://img.gooagoo.com/gms/goods/test1.txt";
    }
}
