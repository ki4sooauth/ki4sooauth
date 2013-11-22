package com.gooagoo.api.business.query.statistics;

import java.util.Date;
import java.util.List;


public interface UseStatisticQueryService {
   
	/**
	 * 查询商家服务工具使用次数
	 * @param shopId  实体店id
	 * @param toolId   服务工具id
	 * @param dateType 时间类型
	 * @param userType 用户类型
	 * @param dateTime 时间
	 * @return
	 */
   public abstract int  toolUseTimes(String shopId,String toolId,String dateType,String userType,Date dateTime);
   
   
   /**
	 * 查询商家服务工具使用人群
	 * @param shopId  实体店id
	 * @param toolId   服务工具id
	 * @param dateType 时间类型
	 * @param userType 用户类型
	 * @param dateTime 时间
	 * @return
	 */
  public abstract List<String>  toolUsePoeple(String shopId,String toolId,String dateType,String userType,Date dateTime);
  
  
  /**
	 *查询优惠凭证使用次数
	 * @param couponId
	 * @param userType
	 * @param dateType
	 * @param dateTime
	 * @return
	 */
	public abstract int couponUseTimes(String couponId, String userType,String dateType, Date dateTime);

	/**
	 * 查询优惠凭证使用人群
	 * @param couponId
	 * @param userType
	 * @param dateType
	 * @param dateTime
	 * @return
	 */
	public abstract List<String> couponUsePeople(String couponId, String userType,String dateType, Date dateTime);
 
}
