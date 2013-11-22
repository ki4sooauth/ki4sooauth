package com.gooagoo.current.tools;

import java.util.Map;

import com.gooagoo.api.business.query.member.cache.MemberCacheQueryService;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.gooagoo.intelligence.utils.StringUtils;

public class UserTools
{
    /**
     * 判断是否为会员
     * @return
     */
    public static boolean isMember(String userId, String shopId)
    {
        try
        {
            if (StringUtils.hasText(userId, shopId))
            {
                MemberCacheQueryService service = SpringBeanUtils.getBean(MemberCacheQueryService.class);

                Map<String, String> relation = service.findMembeInfo(userId, shopId);
                return relation != null && !relation.keySet().isEmpty();
            }
        }
        catch (Exception e)
        {
        }
        return false;
    }

    public static String account(BehaveLog behaveLog)
    {
        if (StringUtils.hasText(behaveLog.getUserId()))
        {
            return "0_" + behaveLog.getUserId();
        }
        else if (StringUtils.hasText(behaveLog.getIpAddress()))
        {
            return "2_" + behaveLog.getIpAddress();
        }
        else if (StringUtils.hasText(behaveLog.getMacAddress()))
        {
            return "3_" + behaveLog.getMacAddress();
        }
        else
        {
            return null;
        }
    }

    public static String account(String userId, String mac, String ip)
    {
        if (StringUtils.hasText(userId))
        {
            return "0_" + userId;
        }
        else if (StringUtils.hasText(ip))
        {
            return "2_" + ip;
        }
        else if (StringUtils.hasText(mac))
        {
            return "3_" + mac;
        }
        else
        {
            return null;
        }
    }
}
