package com.gooagoo.query.business.statistics.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.gooagoo.query.business.statistics.common.utils.StatisticsDataUtil;
import com.gooagoo.redis.data.RedisSortedSetDao;

/**
 * 此类是对 统计数据 中关于redis的公共查询方式 的整理
 * @author Austin
 *
 */
public class RedisOperateData
{
    /**
     * 得到redis库中指定value的score值
     * @param dao
     * @param id
     * @param behaveType
     * @param userType
     * @param channel
     * @param source
     * @param dateType
     * @param dateTime
     * @return
     */
    public static int getInteractionScore(RedisSortedSetDao dao, String id, String behaveType, String userType, String channel, String source, String dateType, Date dateTime)
    {
        int result = 0;
        //Set<String> set = dao.get("Interaction", 0, dao.zcard("Interaction"));
        //服务工具ID_浏览(B)_用户类型_D日
        String valueSource = StatisticsDataUtil.jointKeyForRedis(id, behaveType, userType, channel, source, dateType, dateTime);

        result = dao.getScore("Interaction", valueSource).intValue();
        /*        for (String value : set)
        {
            //应该判断value的值，得到score值，即为次数
            if (valueSource.equals(value))
            {
                result = dao.getScore("Interaction", value).intValue();
                break;
            }
        }*/
        return result;
    }

    /**
     * 根据key值得到value的list集合
     * @param dao
     * @param id
     * @param behaveType
     * @param userType
     * @param channel
     * @param source
     * @param dateType
     * @param dateTime
     * @return
     */
    public static List<String> getOrdersetValues(RedisSortedSetDao dao, String id, String behaveType, String userType, String channel, String source, String dateType, Date dateTime)
    {
        List<String> result = new ArrayList<String>();

        String key = StatisticsDataUtil.jointKeyForRedis(id, behaveType, userType, channel, source, dateType, dateTime);
        Set<String> set = dao.get(key, 0, dao.zcard(key));
        result.addAll(set);

        return result;
    }
}
