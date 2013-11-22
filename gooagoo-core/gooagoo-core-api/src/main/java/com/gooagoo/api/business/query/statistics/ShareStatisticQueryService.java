package com.gooagoo.api.business.query.statistics;

import java.util.Date;
import java.util.List;

public interface ShareStatisticQueryService {
	/**
	 *查询优惠凭证分享次数
	 * @param couponId
	 * @param userType
	 * @param dateType
	 * @param dateTime
	 * @return
	 */
	public abstract int couponShareTimes(String couponId, String userType,String dateType,Date dateTime);

	/**
	 * 查询优惠凭证分享人群
	 * @param couponId
	 * @param userType
	 * @param dateType
	 * @param dateTime
	 * @return
	 */
	public abstract List<String> couponSharePeople(String couponId, String userType,String dateType,Date dateTime);
}
