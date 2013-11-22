package com.gooagoo.query.business.marketing.activity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.marketing.activity.ActivityQueryService;
import com.gooagoo.api.business.query.shop.cache.ShopCacheQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingActivityGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.dao.business.marketing.activity.MarketingActivityAdapterMapper;
import com.gooagoo.entity.business.marketing.ActivityDetail;
import com.gooagoo.entity.business.marketing.activity.ActivityBusiness;
import com.gooagoo.entity.business.marketing.activity.ActivitylistBusiness;
import com.gooagoo.entity.business.marketing.activity.MarketingActivityAdapter;
import com.gooagoo.entity.generator.marketing.MarketingActivity;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.exception.common.NoDataException;

@Service
public class ActivityQueryServiceImpl implements ActivityQueryService
{

    @Autowired
    private MarketingActivityGeneratorQueryService marketingActivityGeneratorQueryService;

    @Autowired
    private ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;

    @Autowired
    private MarketingActivityAdapterMapper marketingActivityAdapterMapper;

    @Autowired
    private ShopCacheQueryService shopCacheQueryService;

    @Override
    public boolean findActivity(String userId, String pageIndex, String pageSize) throws Exception
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public ActivityDetail findActivityDetail(String activityId) throws Exception
    {
        //1、获取活动详细信息
        MarketingActivity marketingActivity = this.marketingActivityGeneratorQueryService.selectByPrimaryKey(activityId);
        if (marketingActivity == null || "Y".equals(marketingActivity.getIsDel()))
        {
            GooagooLog.info("活动详情：活动（" + activityId + "）不存在或已被删除");
            throw new NoDataException("活动（" + activityId + "）不存在或已被删除");
        }
        //2、获取商家详细信息
        ShopInfo shopInfo = this.shopInfoGeneratorQueryService.selectByPrimaryKey(marketingActivity.getShopId());
        if (shopInfo == null || "Y".equals(shopInfo.getIsDel()))
        {
            GooagooLog.info("活动详情：商家（" + marketingActivity.getShopId() + "）不存在或已被删除");
            throw new NoDataException("商家（" + marketingActivity.getShopId() + "）不存在或已被删除");
        }
        //3、组装返回数据
        ActivityDetail activityDetail = new ActivityDetail();
        activityDetail.setMarketingActivity(marketingActivity);
        activityDetail.setShopInfo(shopInfo);

        return activityDetail;
    }

    @Override
    public List<Map<String, String>> getMarketingActivityInfo(String type, String date) throws Exception
    {
        List<Map<String, String>> marketingActivityList = new ArrayList<Map<String, String>>();
        String firstday = null;
        String lastday = null;
        if ("Y".equalsIgnoreCase(type))
        {
            firstday = TimeUtils.getFirstOrLastDay(date + "-01", "firstDay");
            lastday = TimeUtils.getFirstOrLastDay(date + "-12", "lastDay");
        }
        else
        {
            firstday = TimeUtils.getFirstOrLastDay(date, "firstDay");
            lastday = TimeUtils.getFirstOrLastDay(date, "lastDay");
        }
        List<MarketingActivityAdapter> marketingActivitys = this.marketingActivityAdapterMapper.findActityAdapterByDate(firstday, lastday);
        Map<String, String> map = new HashMap<String, String>();
        for (MarketingActivityAdapter vo : marketingActivitys)
        {
            map = this.getDateCount(map, vo, type);
        }
        Set<String> keys = map.keySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext())
        {
            String key = iterator.next();
            String[] querydateArray = date.split("-");
            String queryyear = querydateArray[0];
            String querymonth = querydateArray.length > 1 ? querydateArray[1] : null;
            String[] dateArr = TimeUtils.getCurrentDateTime(TimeUtils.FORMAT2).split("-");
            String year = dateArr[0];//当年
            String month = dateArr[1];//当月
            String day = dateArr[2];//当天
            if ("Y".equalsIgnoreCase(type))
            {
                if (Integer.parseInt(queryyear) == Integer.parseInt(year) && Integer.parseInt(month) > Integer.parseInt(key))
                {
                    continue;
                }
                else if (Integer.parseInt(queryyear) < Integer.parseInt(year))
                {
                    return null;
                }
            }
            else if ("M".equalsIgnoreCase(type))
            {
                if (Integer.parseInt(queryyear) == Integer.parseInt(year) && Integer.parseInt(month) == Integer.parseInt(querymonth))
                {
                    if (Integer.parseInt(day) > Integer.parseInt(key))
                    {
                        continue;
                    }
                }
                else if (Integer.parseInt(queryyear) <= Integer.parseInt(year) && Integer.parseInt(querymonth) < Integer.parseInt(month))
                {
                    return null;
                }
            }
            Map<String, String> marketingActivityMap = new HashMap<String, String>();
            marketingActivityMap.put("type", map.get(key));
            marketingActivityMap.put("date", key);
            marketingActivityList.add(marketingActivityMap);
        }
        return marketingActivityList;
    }

    /**
     * 获取某活动期间所有的月或日和活动类型
     */
    private static Map<String, String> getDateCount(Map<String, String> map, MarketingActivityAdapter obj, String dateType)
    {
        Calendar c_begin = Calendar.getInstance();
        Calendar c_end = Calendar.getInstance();
        c_begin.setTime(obj.getStartTime());
        c_end.setTime(obj.getEndTime());
        if ("Y".equalsIgnoreCase(dateType) && StringUtils.hasText(obj.getShopTypeRoot()))
        {
            while (c_begin.compareTo(c_end) == -1 || c_begin.compareTo(c_end) == 0)
            {
                Integer m = c_begin.get(Calendar.MONTH) + 1;
                if (StringUtils.hasText(map.get(m.toString())) && StringUtils.hasText(obj.getShopTypeRoot()) && !obj.getShopTypeRoot().equalsIgnoreCase(map.get(m.toString())))
                {
                    map.put(m.toString(), "1,a");
                }
                else if (StringUtils.hasText(obj.getShopTypeRoot()))
                {
                    if ("1".equalsIgnoreCase(obj.getShopTypeRoot()))
                    {
                        map.put(m.toString(), "1");
                    }
                    else
                    {
                        map.put(m.toString(), "a");
                    }
                }
                c_begin.add(Calendar.MONTH, 1);
            }
        }
        else if ("M".equalsIgnoreCase(dateType) && StringUtils.hasText(obj.getShopTypeRoot()))
        {
            Integer lastDay = null;
            while (c_begin.compareTo(c_end) == -1 || c_begin.compareTo(c_end) == 0)
            {
                Integer day = c_begin.get(Calendar.DAY_OF_MONTH);
                if (StringUtils.hasText(map.get(day.toString())) && !obj.getShopTypeRoot().equalsIgnoreCase(map.get(day.toString())))
                {
                    map.put(day.toString(), "1,a");
                }
                else
                {
                    if ("1".equalsIgnoreCase(obj.getShopTypeRoot()))
                    {
                        map.put(day.toString(), "1");
                    }
                    else
                    {
                        map.put(day.toString(), "a");
                    }
                }
                c_begin.add(Calendar.DAY_OF_MONTH, 1);
                lastDay = c_begin.get(Calendar.DAY_OF_MONTH);
            }
            if (StringUtils.hasText(map.get(lastDay.toString())) && !obj.getShopTypeRoot().equalsIgnoreCase(map.get(lastDay.toString())))
            {
                map.put(lastDay.toString(), "1,a");
            }
            else
            {
                if ("1".equalsIgnoreCase(obj.getShopTypeRoot()))
                {
                    map.put(lastDay.toString(), "1");
                }
                else
                {
                    map.put(lastDay.toString(), "a");
                }
            }
        }
        return map;
    }

    @Override
    public List<ActivitylistBusiness> getActivitylistInfo(Date startdate, Date enddate, String pageindex, String pagesize) throws Exception
    {
        List<ActivitylistBusiness> activitylistBusinessList = null;
        List<ActivityBusiness> activityBusinessList = new ArrayList<ActivityBusiness>();

        Integer pageIndex = null;
        Integer pageSize = null;
        if (StringUtils.hasText(pageindex) && StringUtils.hasText(pagesize))
        {
            pageIndex = Integer.valueOf(pageindex);
            pageSize = Integer.valueOf(pagesize);
            if (pageIndex == 1 && pageSize == -1)
            {//当pageindex=1，pagesize=-1时，不分页
                pageIndex = null;
                pageSize = null;
            }
            else
            {
                pageIndex = (pageIndex - 1) * pageSize;
            }
        }

        List<MarketingActivity> marketingActivityList = this.marketingActivityAdapterMapper.findActityByTimeScope(startdate, enddate, pageIndex, pageSize);
        if (CollectionUtils.isNotEmpty(marketingActivityList))
        {
            for (MarketingActivity item : marketingActivityList)
            {
                ActivityBusiness activityBusiness = new ActivityBusiness();
                activityBusiness.setActivityid(item.getActivityId());
                ShopInfo shopInfo = this.shopInfoGeneratorQueryService.selectUnDelByPrimaryKey(item.getShopId());
                if (shopInfo != null)
                {
                    activityBusiness.setActivityshoptype(shopInfo.getShopTypeRoot().toString());
                }
                activityBusiness.setShopid(item.getShopId());
                Map<String, String> shopInfoMap = this.shopCacheQueryService.findShopInfo(item.getShopId());
                activityBusiness.setShopname(shopInfoMap.get("shopName"));
                activityBusiness.setActivityname(item.getActivityName());
                activityBusiness.setTitle(item.getTitle());
                activityBusiness.setStarttime(TimeUtils.convertDateToString(item.getStartTime(), TimeUtils.FORMAT1));
                activityBusiness.setEndtime(TimeUtils.convertDateToString(item.getEndTime(), TimeUtils.FORMAT1));
                activityBusiness.setImgurl(item.getImgUrl());
                activityBusiness.setActivityurl(UrlUtils.getActiveUrl(item.getActivityId()));
                activityBusiness.setContent(item.getContent());
                activityBusiness.setPurpose(item.getPurpose());
                activityBusiness.setDescription(item.getDescription());
                activityBusinessList.add(activityBusiness);
            }
        }
        if (CollectionUtils.isNotEmpty(activityBusinessList))
        {
            activitylistBusinessList = new ArrayList<ActivitylistBusiness>();
            ActivitylistBusiness activitylistBusiness = new ActivitylistBusiness();
            activitylistBusiness.setActivitytypename("当日活动");
            activitylistBusiness.setActivityBusinessList(activityBusinessList);
            activitylistBusinessList.add(activitylistBusiness);
        }
        return activitylistBusinessList;
    }

}
