package com.gooagoo.analysis.common.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.analysis.entity.MarketingNotice;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.generator.marketing.MarketingUserLink;
import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.entity.push.EmailVo;
import com.gooagoo.entity.push.Message;
import com.gooagoo.entity.push.MobPushMsg;

public class MarketingUtils
{

    /**
     * 根据历史条件判断处理方式:0-不限，1-每天一次，2-仅此一次
     * @param behaveLog
     * @param ruleInfo
     * @param activityId
     * @return
     */
    public static boolean checkNumberOfTimes(String conditionType, String ruleActiveType, List<MarketingUserLink> marketingUserLinkList)
    {
        if ("0".equals(ruleActiveType))//0-不限
        {
            return true;
        }
        if ("1".equals(conditionType))//1-即时人群
        {
            if ("1".equals(ruleActiveType))//1-每天一次
            {
                if (CollectionUtils.isEmpty(marketingUserLinkList))
                {
                    return true;
                }
                String pushDate = TimeUtils.convertDateToString(marketingUserLinkList.get(0).getPushTime(), TimeUtils.FORMAT2);
                String nowDate = TimeUtils.getCurrentDate();
                if (!nowDate.equals(pushDate))
                {
                    return true;
                }
            }
            if ("2".equals(ruleActiveType))//2-仅此一次
            {
                if (CollectionUtils.isEmpty(marketingUserLinkList))
                {
                    return true;
                }
            }
        }
        else if ("2".equals(conditionType))//2-历史人群+即时人群
        {
            if ("1".equals(ruleActiveType))//1-每天一次
            {
                if (CollectionUtils.isNotEmpty(marketingUserLinkList))
                {
                    Date pushTime = marketingUserLinkList.get(0).getPushTime();
                    if (pushTime == null)
                    {
                        return true;
                    }
                    String pushDate = TimeUtils.convertDateToString(pushTime, TimeUtils.FORMAT2);
                    String nowDate = TimeUtils.getCurrentDate();
                    if (!nowDate.equals(pushDate))
                    {
                        return true;
                    }
                }

            }
            if ("2".equals(ruleActiveType))//2-仅此一次
            {
                Date pushTime = marketingUserLinkList.get(0).getPushTime();
                if (pushTime == null)
                {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 获取日期规则属性
     * @param date yyyy-MM-dd
     * @return
     * @throws Exception
     */
    public static Date getEventDateRuleProperties(Date date) throws Exception
    {
        return new SimpleDateFormat(TimeUtils.FORMAT2).parse(TimeUtils.convertDateToString(date, TimeUtils.FORMAT2));
    }

    /**
     * 获取时间规则属性
     * @param date HH:mm:ss
     * @return
     * @throws Exception
     */
    public static Date getEventTimeRuleProperties(Date date) throws Exception
    {
        return new SimpleDateFormat(TimeUtils.FORMAT5).parse(TimeUtils.convertDateToString(date, TimeUtils.FORMAT5));
    }

    /**
     * 获取周规则属性
     * @param date
     * @return
     * @throws Exception
     */
    public static int getEventWeekRuleProperties(Date date) throws Exception
    {
        return TimeUtils.getWeekOfDate(date);
    }

    /**
     * 封装GooagooMessage消息
     * @param behave 行为对象
     * @return GooagooMessage
     */
    public static GooagooMessage<MobPushMsg> getGooagooMessage(Behave behave)
    {
        GooagooMessage<MobPushMsg> gooagooMessage = new GooagooMessage<MobPushMsg>();
        gooagooMessage.setBehaveCode(behave.getRemoteCode());
        gooagooMessage.setBehaveType(behave.getBehaveType());
        gooagooMessage.setFlag(true);
        gooagooMessage.setSource("11");
        gooagooMessage.setUuid(behave.getBehaveId());
        return gooagooMessage;
    }

    /**
     * 封装GooagooMessage消息
     * @param behave 行为对象
     * @return GooagooMessage
     */
    public static GooagooMessage<EmailVo> getGooagooMessageEmailVo(Behave behave)
    {
        GooagooMessage<EmailVo> gooagooMessage = new GooagooMessage<EmailVo>();
        gooagooMessage.setBehaveCode(behave.getRemoteCode());
        gooagooMessage.setBehaveType(behave.getBehaveType());
        gooagooMessage.setFlag(true);
        gooagooMessage.setSource("11");
        gooagooMessage.setUuid(behave.getBehaveId());
        return gooagooMessage;
    }

    /**
     * 封装GooagooMessage消息
     * @param behave 行为对象
     * @return GooagooMessage
     */
    public static GooagooMessage<Message> getGooagooMessageMessage(Behave behave)
    {
        GooagooMessage<Message> gooagooMessage = new GooagooMessage<Message>();
        gooagooMessage.setBehaveCode(behave.getRemoteCode());
        gooagooMessage.setBehaveType(behave.getBehaveType());
        gooagooMessage.setFlag(true);
        gooagooMessage.setSource("11");
        gooagooMessage.setUuid(behave.getBehaveId());
        return gooagooMessage;
    }

    /**
     * 封装手机推送信息
     * @param behave 行为对象
     * @return MobPushMsg
     */
    public static MobPushMsg getMobPushMsg(Behave behave)
    {
        MobPushMsg mobPushMsg = new MobPushMsg();
        mobPushMsg.setMac(behave.getMacAddress());
        mobPushMsg.setSource("11");
        mobPushMsg.setUuid(behave.getBehaveId());
        return mobPushMsg;
    }

    /**
     * 封装短信信息
     * @param behave 行为对象
     * @return MobPushMsg
     */
    public static Message getMessage(Behave behave)
    {
        Message message = new Message();
        message.setSource("11");
        message.setUuid(behave.getBehaveId());
        return message;
    }

    /**
     * 封装邮件信息
     * @param behave 行为对象
     * @return MobPushMsg
     */
    public static EmailVo getEmailVo(Behave behave)
    {
        EmailVo emailVo = new EmailVo();
        emailVo.setSource("11");
        emailVo.setUuid(behave.getBehaveId());
        return emailVo;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static MarketingNotice<?> getMarketingNotice(String type, GooagooMessage<?> gooagooMessage)
    {
        MarketingNotice marketingNotice = new MarketingNotice();
        marketingNotice.setType(type);
        marketingNotice.setGooagooMessage(gooagooMessage);
        return marketingNotice;
    }

}
