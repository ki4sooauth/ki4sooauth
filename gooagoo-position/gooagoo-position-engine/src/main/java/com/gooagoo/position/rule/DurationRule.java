package com.gooagoo.position.rule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.entity.position.Duration;
import com.gooagoo.position.constants.BehaviorConstants;
import com.gooagoo.position.constants.RedisConstants;
import com.gooagoo.position.entity.DurationRuleInfo;
import com.gooagoo.position.utils.SendMessageUtil;
import com.gooagoo.redis.data.RedisSortedSetDao;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class DurationRule
{
    private static Map<String, List<DurationRuleInfo>> map = new HashMap<String, List<DurationRuleInfo>>();
    private static SendMessageUtil smu = new SendMessageUtil();

    public static List<DurationRuleInfo> getShopRule(String shopId)
    {
        return map.get(shopId);
    }

    public static void readRule(String json)
    {
        Map<String, List<DurationRuleInfo>> temp = new HashMap<String, List<DurationRuleInfo>>();
        Gson gson = new Gson();
        List<RuleInfo> ruleInfos = gson.fromJson(json, new TypeToken<List<DurationRuleInfo>>()
        {
        }.getType());

        for (RuleInfo ruleInfo : ruleInfos)
        {
            if ("P".equals(ruleInfo.getPublishStatus()))
            {
                String shopId = ruleInfo.getShopId();
                DurationRuleInfo tempRuleInfo = gson.fromJson(ruleInfo.getRuleContent(), DurationRuleInfo.class);
                tempRuleInfo.setShopId(shopId);
                if (tempRuleInfo.getMin() != null || tempRuleInfo.getMax() != null)
                {
                    List<DurationRuleInfo> list = temp.get(shopId);
                    if (list == null)
                    {
                        list = new ArrayList<DurationRuleInfo>();
                    }
                    list.add(tempRuleInfo);
                    temp.put(shopId, list);
                }
            }
        }
        map = temp;
    }

    private static RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisConstants.statistics_in_shop);

    public static void matching(String macAddress, String shopId)
    {
        List<DurationRuleInfo> ruleInfos = map.get(shopId);
        if (ruleInfos == null || ruleInfos.size() == 0)
        {
            return;
        }
        for (DurationRuleInfo durationRuleInfo : ruleInfos)
        {
            if ("1".equals(durationRuleInfo.getActionType()))
            { //到店
                Double timestamp = sortedSetDao.getScore(shopId, macAddress);
                judge(timestamp, durationRuleInfo, macAddress);
            }
            else if ("2".equals(durationRuleInfo.getActionType()))
            { //到区域
                Double timestamp = sortedSetDao.getScore(durationRuleInfo.getPositionId(), macAddress);
                judge(timestamp, durationRuleInfo, macAddress);
            }
        }
    }

    private static boolean judge(Double timestamp, DurationRuleInfo durationRuleInfo, String mac)
    {
        Duration duration = new Duration();
        duration.setMacAddress(mac);//MAC地址
        duration.setPositionId(durationRuleInfo.getPositionId());//位置id
        duration.setShopId(durationRuleInfo.getShopId()); //商家id
        if (durationRuleInfo.getMin() != null)
        {
            int second = (int) (timestamp / 1000);
            duration.setDuration(new Long(second));//时长
            if (durationRuleInfo.getMax() != null)
            {
                if (durationRuleInfo.getMin() < second && durationRuleInfo.getMax() > second)
                {
                    sendDurationMessage(duration);
                }
            }
            else
            {
                if (durationRuleInfo.getMin() < second)
                {
                    sendDurationMessage(duration);
                }
            }
        }
        return false;
    }

    private static void sendDurationMessage(Duration duration)
    {
        GooagooMessage<Duration> message = new GooagooMessage<Duration>();
        message.setSource("4");
        message.setBehaveCode("003");
        message.setBehaveType("2");
        message.setFlag(true);
        message.setContent(duration);

        smu.sendObjectMessage(BehaviorConstants.MQ_DESTINATION_POSITION, message);

    }
}
