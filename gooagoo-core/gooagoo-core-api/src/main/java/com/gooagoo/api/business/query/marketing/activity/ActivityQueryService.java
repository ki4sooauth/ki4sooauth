package com.gooagoo.api.business.query.marketing.activity;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gooagoo.entity.business.marketing.ActivityDetail;
import com.gooagoo.entity.business.marketing.activity.ActivitylistBusiness;

public interface ActivityQueryService
{
    public boolean findActivity(String userId, String pageIndex, String pageSize) throws Exception;

    /**
     * 活动详情
     * @param activityId
     * @return
     * @throws Exception
     */
    public ActivityDetail findActivityDetail(String activityId) throws Exception;

    /**
     * 根据时间查询是否有活动
     * mobd03
     * @param type查询类型（Y-年，M-月）
     * @param date查询时间（年-YYYY，月-YYYY-MM）
     * @return List<Map<String, String>> [type 活动包含类型，根据发布活动的商家类型区分。1-餐饮；a-非餐饮。格式：以逗号分隔的字符串]
     * @return List<Map<String, String>> [date 时间（月（1-12）、日（1-31））]
     * @throws Exception
     */
    public List<Map<String, String>> getMarketingActivityInfo(String type, String date) throws Exception;

    /**
     * 获取活动列表信息
     * mobd04
     * @param startdate查询时间起
     * @param enddate查询结束时间止
     * @param pageIndex 页码
     * @param pageSize 每页信息显示条数
     * @return List<ActivitylistBusiness>
     * @throws Exception
     */
    public List<ActivitylistBusiness> getActivitylistInfo(Date startdate, Date enddate, String pageIndex, String pageSize) throws Exception;

}
