package com.gooagoo.gmember.util;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.gooagoo.cache.GmsConfigCache;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.view.gms.member.StateParams;

public class StatisUtil
{

    private static String baseUrl = null;
    static
    {
        baseUrl = GmsConfigCache.get("statistics_file_url_head");
        if (StringUtils.isBlank(baseUrl))
        {
            GooagooLog.warn("===========从缓存中获取统计数据文件访问头部地址为空");
        }
    }

    // 获取拉取文件路径
    public static List<String> getFileUrl(HttpServletRequest request)
    {
        List<String> fileUrls = new ArrayList<String>(0);
        try
        {
            StateParams sp = ServletUtils.objectMethod(StateParams.class, request);
            String[] sItem = getStatItem(sp.getsType());
            StringBuffer buffer = null;
            for (String s : sItem)
            {
                buffer = new StringBuffer(baseUrl+"/");
                if ("3".equals(sp.getsType()) || "4".equals(sp.getsType()) || "5".equals(sp.getsType()))
                {
                    buffer.append("_").append(sp.getShopIdOrEntityIdOrAreaId());
                }
                buffer.append("_").append(s);
                buffer.append("_").append(sp.getUserType()).append("_");
                buffer.append(sp.getTimeType()).append("_").append(sp.getTimeVal());
                fileUrls.add(buffer.toString());
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("用户状态获取统计数据文件路径错误", e);
        }
        return fileUrls;
    }

    /**
     * 跟据统计类型获取统计项
     * @param statType 统计类型：（如：店内用户，到达用户等）
     * @return 统计项。人次，人次 
     */
    public static String[] getStatItem(String statType)
    {
        if ("2".equals(statType) || "4".equals(statType) || "5".equals(statType))
        {
            return new String[] { "N", "T" };
        }
        else
        {
            return new String[] { "N" };
        }
    }

}
