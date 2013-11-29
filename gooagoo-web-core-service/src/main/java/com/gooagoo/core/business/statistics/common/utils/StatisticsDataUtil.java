package com.gooagoo.core.business.statistics.common.utils;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.util.StringUtils;

public class StatisticsDataUtil
{
    /**
     * 判断是否是今天
     * @param dateTime
     * @return
     */
    public static boolean isToday(Date dateTime)
    {
        boolean flag = false;
        if (dateTime == null)
        {
            flag = true;
        }
        else
        {
            Date todayDate = new Date();
            Calendar tTime = Calendar.getInstance();
            tTime.setTime(todayDate);

            Calendar dTime = Calendar.getInstance();
            dTime.setTime(dateTime);

            int tYear = tTime.get(Calendar.YEAR);
            int tMonth = tTime.get(Calendar.MONTH);
            int tWeek = tTime.get(Calendar.WEEK_OF_YEAR);
            int tDay = tTime.get(Calendar.DAY_OF_MONTH);

            int dYear = dTime.get(Calendar.YEAR);
            int dMonth = dTime.get(Calendar.MONTH);
            int dWeek = dTime.get(Calendar.WEEK_OF_YEAR);
            int dDay = dTime.get(Calendar.DAY_OF_MONTH);

            if (tYear == dYear && tMonth == dMonth && tDay == dDay && tWeek == dWeek)
            {
                flag = true;
            }
        }

        return flag;
    }

    public static void main(String[] args)
    {
        String key = jointKeyForRedis("id", "behaveType", "userType", "channel", "3", "H", null);
        System.out.println(key);
    }

    /**
     * 拼接redis的key值
     * @param id
     * @param behaveType 行为类型        浏览B  使用U  收藏F  兑换E  分享S  评论C  购买P
     * @param userType 用户类型      所有会员A   会员M  潜在会员N
     * @param channel 渠道类型       吆喝C  通知N  短信M  邮件E  手机服务P   购好奇B
     * @param source 来源类型      手机端M  网站端W
     * @param dateType 时间类型      年-Y四位数字   月-M两位数字   周-W两位数字   日-D当天8点整时间戳   时-H两位数字
     * @param dateTime
     * @return
     */
    public static String jointKeyForRedis(String id, String behaveType, String userType, String channel, String source, String dateType, Date dateTime)
    {
        StringBuffer key = new StringBuffer(id);

        if (StringUtils.hasText(behaveType))
        {
            key.append("_" + behaveType);
        }
        if (StringUtils.hasText(userType))
        {
            key.append("_" + userType);
        }
        if (StringUtils.hasText(channel))
        {
            key.append("_" + channel);
        }
        if (StringUtils.hasText(source))
        {
            key.append("_" + source);
        }
        if (StringUtils.hasText(dateType))
        {
            //ID_行为类型_用户类型_渠道_来源_时间
            String year = "";
            String month = "";
            String week = "";
            String day = "";
            String hour = "";
            if (dateTime == null)
            {
                dateTime = new Date();
            }
            DecimalFormat df = new DecimalFormat("00");
            Calendar time = Calendar.getInstance();
            time.setTime(dateTime);
            year = String.valueOf(time.get(Calendar.YEAR));
            month = df.format(time.get(Calendar.MONTH) + 1);
            time.setFirstDayOfWeek(Calendar.MONDAY);
            time.setMinimalDaysInFirstWeek(7);
            week = df.format(time.get(Calendar.WEEK_OF_YEAR));
            day = df.format(time.get(Calendar.DAY_OF_MONTH));
            hour = df.format(time.get(Calendar.HOUR_OF_DAY));

            key.append("_");
            if ("Y".equals(dateType))
            {
                key.append("Y" + year);
            }
            else if ("M".equals(dateType))
            {
                key.append("Y" + year + "M" + month);
            }
            else if ("W".equals(dateType))
            {
                key.append("Y" + year + "W" + week);
            }
            else if ("D".equals(dateType))
            {
                key.append("Y" + year + "M" + month + "D" + day);
            }
            else if ("H".equals(dateType))
            {
                key.append("Y" + year + "M" + month + "D" + day + "H" + hour);
            }
        }

        return key.toString();
    }

    private static String filter(String key)
    {
        if (StringUtils.hasText(key))
        {
            return "_" + key;
        }
        else
        {
            return "_*";
        }
    }

    /**
     * 拼接Mongo的 _id
     * @return
     */
    public static String jointIdForMongo(String id, String dateType, Date dateTime)
    {
        //ID_时间类型

        StringBuffer key = new StringBuffer(id);

        if (StringUtils.hasText(dateType))
        {
            //ID_行为类型_用户类型_渠道_来源_时间
            String year = "";
            String month = "";
            String week = "";
            String day = "";
            String hour = "";
            if (dateTime == null)
            {
                dateTime = new Date();
            }
            DecimalFormat df = new DecimalFormat("00");
            Calendar time = Calendar.getInstance();
            time.setTime(dateTime);
            year = String.valueOf(time.get(Calendar.YEAR));
            month = df.format(time.get(Calendar.MONTH) + 1);
            time.setFirstDayOfWeek(Calendar.MONDAY);
            time.setMinimalDaysInFirstWeek(7);
            week = df.format(time.get(Calendar.WEEK_OF_YEAR));
            day = df.format(time.get(Calendar.DAY_OF_MONTH));
            hour = df.format(time.get(Calendar.HOUR_OF_DAY));

            key.append("_");
            if ("Y".equals(dateType))
            {
                key.append("Y" + year);
            }
            else if ("M".equals(dateType))
            {
                key.append("Y" + year + "M" + month);
            }
            else if ("W".equals(dateType))
            {
                key.append("Y" + year + "W" + week);
            }
            else if ("D".equals(dateType))
            {
                key.append("Y" + year + "M" + month + "D" + day);
            }
            else if ("H".equals(dateType))
            {
                key.append("Y" + year + "M" + month + "D" + day + "H" + hour);
            }
        }

        return key.toString();
    }
}
