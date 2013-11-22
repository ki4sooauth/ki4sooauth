package com.googoo.batch.utils;

import java.util.Date;

import com.gooagoo.common.utils.TimeUtils;

public class DateUtils {
	
	/**
	 * 获取某天前后几天0时时间
	 * @param num
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static Date getDaysBeforeAndAfterZeroTime(int num, Date date) throws Exception {
		Date dateAdd = TimeUtils.dateAdd(TimeUtils.DATATYPE_DAY, date, num);
		Date zeroHourOfDate = TimeUtils.getZeroHourOfDate(dateAdd);
		return zeroHourOfDate;
	}
    
	/**
	 * 获取某天前后几天24时时间
	 * @param num
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static Date getDaysBeforeAndAfter24HourTime(int num, Date date) throws Exception {
		Date dateAdd = TimeUtils.dateAdd(TimeUtils.DATATYPE_DAY, date, num);
		Date hDate = TimeUtils.convertStringToDate(TimeUtils.convertDateToString(dateAdd, "yyyy-MM-dd") + " 23:59:59");
		return hDate;
	}
}
