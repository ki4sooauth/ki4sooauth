package com.gooagoo.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 日期时间处理工具类
 * @author frenn
 *
 */
public final class TimeUtils
{
    public static final String FORMAT1 = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT2 = "yyyy-MM-dd";
    public static final String FORMAT3 = "MM/dd/yyyy HH:mm:ss";
    public static final String FORMAT4 = "MM/dd/yyyy";
    public static final String FORMAT5 = "HH:mm:ss";
    public static final String FORMAT6 = "yyyyMMddHHmmss";
    public static final String FORMAT7 = "yyyy-MM";
    public static final String FORMAT8 = "yyyy年MM月dd日";

    public static final int DATATYPE_YEAR = 1;
    public static final int DATATYPE_MONTH = 2;
    public static final int DATATYPE_DAY = 3;
    public static final int DATATYPE_HOUR = 4;
    public static final int DATATYPE_MINUTE = 5;
    public static final int DATATYPE_SECOND = 6;

    /**
     * 获取日期格式
     * 支持的格式有：
     * yyyy-MM-dd HH:mm:ss
     * yyyy-MM-dd HH:mm:ss.SSS（归到yyyy-MM-dd HH:mm:ss中）
     * yyyy-MM-dd
     * MM/dd/yyyy HH:mm:ss
     * MM/dd/yyyy HH:mm:ss.SSS（归到MM/dd/yyyy HH:mm:ss中）
     * MM/dd/yyyy
     * @param date  日期
     * @return      格式
     */
    public static String getFormat(String date) throws Exception
    {
        String reg1 = "\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}(.\\d{1,3}){0,1}";
        String reg2 = "\\d{4}-\\d{1,2}-\\d{1,2}";
        String reg3 = "\\d{1,2}/\\d{1,2}/\\d{4} \\d{1,2}:\\d{1,2}:\\d{1,2}(.\\d{1,3}){0,1}";
        String reg4 = "\\d{1,2}/\\d{1,2}/\\d{4}";
        if (date.matches(reg1))
        {
            return FORMAT1;
        }
        else if (date.matches(reg2))
        {
            return FORMAT2;
        }
        else if (date.matches(reg3))
        {
            return FORMAT3;
        }
        else if (date.matches(reg4))
        {
            return FORMAT4;
        }
        else
        {
            throw new Exception("不支持的日期格式：" + date);
        }
    }

    /**
     * 获取当前日期（固定格式：yyyy-MM-dd）
     * @return  当前日期
     */
    public static String getCurrentDate()
    {
        return getCurrentDateTime(FORMAT2);
    }

    /**
     * 获取当前时间（固定格式：HH:mm:ss）
     * @return  当前时间
     */
    public static String getCurrentTime()
    {
        return getCurrentDateTime(FORMAT5);
    }

    /**
     * 获取当前日期和时间（固定格式：yyyy-MM-dd HH:mm:ss）
     * @return  当前日期和时间
     */
    public static String getCurrentDateTime()
    {
        return getCurrentDateTime(FORMAT1);
    }

    /**
     * 获取当前日期和时间（自定义格式）
     * 参考格式：yyyy年MM月dd日HH时（hh时）mm分ss秒ms毫秒E本月第F个星期
     * 对应的值：2009年07月22日15时（03时）05分30秒530毫秒星期三本月第4个星期
     * @param format    日期时间的格式
     * @return          当前日期和时间
     */
    public static String getCurrentDateTime(String format)
    {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(new Date());
    }

    /**
     * 获取昨天的日期（固定格式：yyyy-MM-dd）
     * @return  日期
     */
    public static String getYesterday()
    {
        SimpleDateFormat df = new SimpleDateFormat(FORMAT2);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -1);
        return df.format(c.getTime());
    }

    /**
     * 获取明天的日期（固定格式：yyyy-MM-dd）
     * @return  日期
     */
    public static String getTomorrow()
    {
        SimpleDateFormat df = new SimpleDateFormat(FORMAT2);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);
        return df.format(c.getTime());
    }

    /**
     * 把String转换成日期
     * @param date      String型日期
     * @return          Date型日期
     */
    public static Date convertStringToDate(String date) throws Exception
    {
        SimpleDateFormat df = new SimpleDateFormat(getFormat(date));
        return df.parse(date);
    }

    /**
     * 把日期类型转换成String
     * @param date      Date型日期
     * @param format    转换成String型日期后的格式
     * @return          String型日期
     */
    public static String convertDateToString(Date date, String format)
    {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    /**
     * 日期时间格式转换
     * @param value         转换前的值
     * @param format        转换后的格式
     * @return              转换后的值
     */
    public static String dateFormat(String value, String format)
    {
        try
        {
            Date date = convertStringToDate(value);
            return convertDateToString(date, format);
        }
        catch (Exception e)
        {
            return "";
        }
    }

    /**
     * 计算两个日期的间隔（yyyy MM dd HH mm ss）
     * @param type      间隔的单位：1-年，2-月，3-日，4-小时，5-分钟，6-秒，不填默认为日
     * @param sdate1    String型日期
     * @param sdate2    String型日期
     * @return          间隔的数量。如果日期sdate2在日期sdate1之后，则结果为正数；如果日期sdate2在日期sdate1之前，则结果为负数
     */
    public static int dateDiff(int type, String sdate1, String sdate2) throws Exception
    {
        Date date1 = new SimpleDateFormat(getFormat(sdate1)).parse(sdate1);
        Date date2 = new SimpleDateFormat(getFormat(sdate2)).parse(sdate2);
        return dateDiff(type, date1, date2);
    }

    /**
     * 计算两个日期的间隔（yyyy MM dd HH mm ss）
     * @param type      间隔的单位：1-年，2-月，3-日，4-小时，5-分钟，6-秒，不填默认为日
     * @param sdate1    Date型日期
     * @param sdate2    Date型日期
     * @return          间隔的数量。如果日期date2在日期date1之后，则结果为正数；如果日期date2在日期date1之前，则结果为负数
     */
    public static int dateDiff(int type, Date date1, Date date2)
    {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);
        int yearDiff = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR);
        if (type == DATATYPE_YEAR)
        {//年
            return yearDiff;
        }
        else if (type == DATATYPE_MONTH)
        {//月
            int monthDiff = yearDiff * 12 + cal2.get(Calendar.MONTH) - cal1.get(Calendar.MONTH);
            return monthDiff;
        }
        else
        {
            long ldate1 = date1.getTime() + cal1.get(Calendar.ZONE_OFFSET) + cal1.get(Calendar.DST_OFFSET);
            long ldate2 = date2.getTime() + cal2.get(Calendar.ZONE_OFFSET) + cal2.get(Calendar.DST_OFFSET);
            if (type == DATATYPE_HOUR)
            {//小时
                return (int) ((ldate2 - ldate1) / 3600000);
            }
            else if (type == DATATYPE_MINUTE)
            {//分钟
                return (int) ((ldate2 - ldate1) / 60000);
            }
            else if (type == DATATYPE_SECOND)
            {//秒
                return (int) ((ldate2 - ldate1) / 1000);
            }
            else
            {//日
                return (int) ((ldate2 - ldate1) / (3600000 * 24));
            }
        }
    }

    /**
     * 计算日期加上一段间隔之后的新日期
     * @param type  间隔的单位：1-年，2-月，3-日，4-小时，5-分钟，6-秒，不填默认为日
     * @param date  日期
     * @param num   间隔数量
     * @return      返回新日期
     * @throws Exception
     */
    public static Date dateAdd(int type, Date date, int num)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        if (type == DATATYPE_YEAR)
        {
            cal.add(Calendar.YEAR, num);
        }
        else if (type == DATATYPE_MONTH)
        {
            cal.add(Calendar.MONTH, num);
        }
        else if (type == DATATYPE_HOUR)
        {
            cal.add(Calendar.HOUR, num);
        }
        else if (type == DATATYPE_MINUTE)
        {
            cal.add(Calendar.MINUTE, num);
        }
        else if (type == DATATYPE_SECOND)
        {
            cal.add(Calendar.SECOND, num);
        }
        else
        {
            cal.add(Calendar.DATE, num);
        }
        return cal.getTime();
    }

    /**
     * 计算日期加上一段间隔之后的新日期
     * @param type      间隔的单位：1-年，2-月，3-日，4-小时，5-分钟，6-秒，不填默认为日
     * @param sdate     String型日期
     * @param num       间隔数量
     * @return          返回新日期
     */
    public static String dateAdd(int type, String sdate, int num) throws Exception
    {
        SimpleDateFormat df = new SimpleDateFormat(getFormat(sdate));
        Date date = df.parse(sdate);
        Date newDate = dateAdd(type, date, num);
        return df.format(newDate);
    }

    /**
     * 计算年龄
     * 1、对于天，两个日期直接相减
     * 2、对于月，如果2011年3月26日出生，则2011年4月27日才满一个月
     * 3、对于周岁，如果2010年4月26日出生，则2011年4月27日才满一周岁
     * @param birthday  出生日期
     * @param type      年龄类型，Y-周岁，M-月，D-天，默认为周岁
     * @return          年龄数值
     * @throws Exception 
     */
    public static int calAge(String birthday, String type) throws Exception
    {
        String currDate = getCurrentDate();
        if ("D".equalsIgnoreCase(type))
        {
            return dateDiff(DATATYPE_DAY, birthday, currDate);
        }
        else if ("M".equalsIgnoreCase(type))
        {
            int result = dateDiff(DATATYPE_MONTH, birthday, currDate);
            String temp = dateAdd(DATATYPE_MONTH, birthday, result);
            if (dateDiff(DATATYPE_DAY, temp, currDate) <= 0)
            {
                result--;
            }
            return result;
        }
        else
        {
            int result = dateDiff(DATATYPE_YEAR, birthday, currDate);
            String temp = dateAdd(DATATYPE_YEAR, birthday, result);
            if (dateDiff(DATATYPE_DAY, temp, currDate) <= 0)
            {
                result--;
            }
            return result;
        }
    }

    /**
     * 获得本年1月1号零点的日期时间
     * @return
     * @throws Exception
     */
    public static Date getFirstDayOfYear() throws Exception
    {
        return convertStringToDate(getCurrentDateTime("yyyy") + "-01-01 00:00:00");
    }

    /**
     * 获取本月1号零点的日期时间
     * @return
     * @throws Exception
     */
    public static Date getFirstDayOfMonth() throws Exception
    {
        return convertStringToDate(getCurrentDateTime("yyyy-MM") + "-01 00:00:00");
    }

    /**
     * 获取本周第一天（周日）零点的日期时间
     * @param date
     * @return
     * @throws Exception
     */
    public static Date getMondayOfDate() throws Exception
    {
        Date date = new Date();
        int x = getWeekOfDate(date);
        date = dateAdd(DATATYPE_DAY, date, -x);
        return getZeroHourOfDate(date);
    }

    /**
     * 获取某天凌晨时间
     * @param date
     * @return
     * @throws Exception 
     */
    public static Date getZeroHourOfDate(Date date) throws Exception
    {
        return convertStringToDate(convertDateToString(date, FORMAT2) + " 00:00:00");
    }

    /**
     * 获取日期是星期几
     * @param date  日期
     * @return      0-周日，1-周一，2-周二。。。。。。
     */
    public static int getWeekOfDate(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
        {
            w = 0;//0表示星期天，是一周的第一天
        }
        return w;
    }

    /**
     * 获取指定日期所在月份的天数
     * @param dt
     * @return
     */
    public static Integer getCountOfMonth(Date dt)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(dt);
        return cal.getActualMaximum(Calendar.DATE);
    }

    /**
     * 获取指定日期所在月份第一天是星期几
     * @param dt 日期
     * @return  0-周日，1-周一，2-周二。。。。。。
     */
    @SuppressWarnings("deprecation")
    public static Integer getWeekOfMonthFirstDay(Date dt)
    {
        Calendar cal = Calendar.getInstance();
        cal.set(dt.getYear() + 1900, dt.getMonth(), 1);
        return cal.get(Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * 正则验证日期格式(yyyy-MM-dd)
     * @param dt 日期
     */
    public static boolean dateMatcher(String dt)
    {
        Pattern pattern = Pattern.compile("((((0[0-9])(([02468][48])|([13579][26]))-0?2-29))|(((0[0-9])(([2468][048])|([13579][26]))-0?2-29))|(((0[1-9])(([02468][048])|([13579][26]))-0?2-29))|((([1-9][0-9])(([02468][048])|([13579][26]))-0?2-29))|((0[0-9][0-9][1-9])|(0[0-9][1-9][0-9])|(0[1-9][0-9][0-9])|([1-9][0-9][0-9][0-9]))-((((0?[1-9])|(1[0-2]))-((0?[1-9])|(1[0-9])|(2[0-8])))|((((0?[13578])|(1[02]))-31)|(((0?[1,3-9])|(1[0-2]))-(29|30)))))");
        Matcher matcher = pattern.matcher(dt);
        return matcher.matches();
    }

    /**
     * 正则验证日期格式(yyyy-MM-dd hh:mm:ss)
     * @param dt 日期
     */
    public static boolean dateTimeMatcher(String dt)
    {
        Pattern pattern = Pattern.compile("^(((20[0-3][0-9]-(0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01]))|(20[0-3][0-9]-(0[2469]|11)-(0[1-9]|[12][0-9]|30))) (20|21|22|23|[0-1][0-9]):[0-5][0-9]:[0-5][0-9])$");
        Matcher matcher = pattern.matcher(dt);
        return matcher.matches();
    }

    /**
     * 获取某一天前或后指定天（列：days=1时获取前天）
     * @param date 某一天
     * @param format 返回时间类型
     * @param days 天数(正数表示后几天负数表示前几天：-1为取前一天,1为取后一天)
     * @return String (yyyy-MM-dd)
     */
    public static String getBeforeOrAfterDay(Date date, String format, Integer days)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(calendar.getTime());
    }

    /**
     * 获取某月的第一天和最后一天
     * @param moons 某一月
     * @param returnType 返回类型(firstDay第一天,lastDay最后一天)
     * @return Map (firstDay,lastDay) 默认返回最后一天
     */
    public static String getFirstOrLastDay(String moons, String returnType)
    {
        String day = null;
        String[] monthArr = moons.split("-");
        Integer year = Integer.parseInt(monthArr[0]);
        Integer month = Integer.parseInt(monthArr[1]);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date lastDay = calendar.getTime();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date firstDay = calendar.getTime();
        if ("firstDay".equalsIgnoreCase(returnType))
        {
            day = TimeUtils.convertDateToString(firstDay, TimeUtils.FORMAT2);
        }
        else
        {
            day = TimeUtils.convertDateToString(lastDay, TimeUtils.FORMAT2);
        }
        return day;
    }

    /**
     * 获取定时器的启动日期和时间
     * 规则：time为传入的时间，
     * 如果当前时间大于time，则定时器下一次启动时间为第二天的time时刻，
     * 否则，定时器下一次启动时间为当前的time时刻
     * @param time  启动时间（HH:mm:ss）
     * @return      启动日期和时间
     * @throws Exception
     */
    public static Date getTimerDate(String time) throws Exception
    {
        String reg = "\\d{2}:\\d{2}:\\d{2}";
        if (time.matches(reg))
        {
            String[] temp = time.split(":");
            Calendar c = Calendar.getInstance();
            Date now = new Date();
            c.setTime(now);
            c.set(Calendar.HOUR, Integer.parseInt(temp[0]));
            c.set(Calendar.MINUTE, Integer.parseInt(temp[1]));
            c.set(Calendar.SECOND, Integer.parseInt(temp[2]));
            Date timer = c.getTime();
            if (timer.after(now))
            {
                return timer;
            }
            else
            {
                c.add(Calendar.DAY_OF_YEAR, 1);
                return c.getTime();
            }
        }
        else
        {
            return null;
        }
    }
}
