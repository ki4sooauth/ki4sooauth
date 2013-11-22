package com.googoo.batch.dispatcher.historyDat.mongo;

import java.util.Calendar;
import java.util.Date;

public class DayJudgeUtil
{
    public static boolean isToday(String redis)
    {
        boolean result = false;

        Date todayDate = new Date();
        Calendar tTime = Calendar.getInstance();
        tTime.setTime(todayDate);

        int tDay = tTime.get(Calendar.DAY_OF_MONTH);

        String[] split = redis.split("_");
        for (String s : split)
        {
            if (s.startsWith("D"))
            {
                int day = Integer.parseInt(s.substring(1));
                if (day == tDay)
                {
                    result = true;
                }
            }

        }

        return result;
    }
}
