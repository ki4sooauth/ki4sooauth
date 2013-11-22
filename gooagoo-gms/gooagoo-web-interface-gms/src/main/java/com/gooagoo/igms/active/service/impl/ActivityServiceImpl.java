package com.gooagoo.igms.active.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.marketing.activity.ActivityCoreService;
import com.gooagoo.api.generator.query.marketing.MarketingActivityGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.StringUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.generator.marketing.MarketingActivity;
import com.gooagoo.entity.generator.marketing.MarketingActivityExample;
import com.gooagoo.entity.generator.marketing.MarketingActivityExample.Criteria;
import com.gooagoo.igms.active.service.ActivityService;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.view.gms.common.PageCondition;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.marketing.FActivity;

@Service(value = "activityService")
public class ActivityServiceImpl implements ActivityService
{
    @Autowired
    private MarketingActivityGeneratorQueryService marketingActivityGeneratorQueryService;
    @Autowired
    private ActivityCoreService activityCoreService;

    /**
     * 新增活动
     */
    @Override
    public TransData<Object> add(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        FActivity activity = ServletUtils.objectMethod(FActivity.class, request);

        activity.setActivityId(StringUtils.getUUID());
        activity.setShopId(shopId);

        MarketingActivity marketingActivity = this.covertToMarketingActivity(activity);
        boolean result = false;
        if (this.checkMarketingActivity(marketingActivity))
        {
            result = this.activityCoreService.addActivity(marketingActivity);
        }
        return GMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, activity.getActivityId());
    }

    /**
     * 删除活动
     */
    @Override
    public TransData<Object> delete(HttpServletRequest request) throws Exception
    {
        String ativityId = ServletRequestUtils.getStringParameter(request, "id", "");

        boolean result = this.activityCoreService.deleteActivity(ativityId);

        return GMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, ativityId);
    }

    /**
     * 修改活动
     */
    @Override
    public TransData<Object> update(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        FActivity activity = ServletUtils.objectMethod(FActivity.class, request);

        activity.setShopId(shopId);

        MarketingActivity marketingActivity = this.covertToMarketingActivity(activity);
        boolean result = false;
        if (this.checkMarketingActivity(marketingActivity))
        {
            result = this.activityCoreService.updateActivity(marketingActivity);
        }

        return GMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, activity.getActivityId());
    }

    /**
     * 活动信息列表（分页查询）
     */
    @Override
    public TransData<PageModel<FActivity>> pageActivity(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        FActivity activity = ServletUtils.objectMethod(FActivity.class, request);
        PageCondition pc = ServletUtils.objectMethod(PageCondition.class, request);
        String activityTime = ServletRequestUtils.getStringParameter(request, "activityTime", "");

        PageModel<FActivity> pm = new PageModel<FActivity>();
        pm.setPageIndex(pc.getPageIndex());
        pm.setPageSize(pc.getPageSize());
        if (pc.getPageSize() == 0)
        {
            pm.setPageSize(10);
        }
        MarketingActivityExample example = new MarketingActivityExample();
        example.setPage(pm.getPageIndex(), pm.getPageSize());
        example.setOrderByClause("c_time_stamp desc");
        Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO);
        criteria.andShopIdEqualTo(shopId);
        if (org.springframework.util.StringUtils.hasText(activityTime))
        {
            criteria.andStartTimeLessThanOrEqualTo(TimeUtils.convertStringToDate(activityTime));
        }
        if (org.springframework.util.StringUtils.hasText(activityTime))
        {
            criteria.andEndTimeGreaterThanOrEqualTo(TimeUtils.convertStringToDate(activityTime));
        }
        if (org.springframework.util.StringUtils.hasText(activity.getPublishStatus()))
        {
            criteria.andPublishStatusEqualTo(activity.getPublishStatus());
        }

        int count = this.marketingActivityGeneratorQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            List<MarketingActivity> list = this.marketingActivityGeneratorQueryService.selectByExample(example);
            for (MarketingActivity activityInfo : list)
            {
                pm.getResult().add(this.convertToFActivity(activityInfo));
            }
        }

        return new TransData<PageModel<FActivity>>(true, null, pm);
    }

    /**
     * 活动信息列表（不分页查询）
     */
    @Override
    public TransData<List<FActivity>> getActivityList(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        MarketingActivityExample example = new MarketingActivityExample();
        Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO);
        criteria.andShopIdEqualTo(shopId);
        List<FActivity> resultList = new ArrayList<FActivity>();
        int count = this.marketingActivityGeneratorQueryService.countByExample(example);
        if (count > 0)
        {
            List<MarketingActivity> list = this.marketingActivityGeneratorQueryService.selectByExample(example);
            for (MarketingActivity activityInfo : list)
            {
                resultList.add(this.convertToFActivity(activityInfo));
            }
        }

        return new TransData<List<FActivity>>(true, null, resultList);
    }

    /**
     * 活动详细信息
     */
    @Override
    public TransData<FActivity> getActivity(HttpServletRequest request) throws Exception
    {
        String activityId = ServletRequestUtils.getStringParameter(request, "id", "");

        MarketingActivity marketingActivity = this.marketingActivityGeneratorQueryService.selectByPrimaryKey(activityId);

        FActivity activity = this.convertToFActivity(marketingActivity);

        return new TransData<FActivity>(true, null, activity, activityId);
    }

    /**
     * 审核活动信息
     */
    @Override
    public TransData<Object> check(HttpServletRequest request) throws Exception
    {
        String activityId = ServletRequestUtils.getStringParameter(request, "activityId", "");
        String publishStatus = ServletRequestUtils.getStringParameter(request, "publishStatus", "");
        String auditNote = ServletRequestUtils.getStringParameter(request, "auditNote", "");

        boolean result = this.activityCoreService.reviewedActivity(activityId, publishStatus, auditNote);

        return GMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, activityId);
    }

    /**
     * 发布活动信息
     */
    @Override
    public TransData<Object> publish(HttpServletRequest request) throws Exception
    {
        String activityId = ServletRequestUtils.getStringParameter(request, "activityId", "");

        boolean result = this.activityCoreService.publishActivity(activityId);

        return GMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, activityId);
    }

    private MarketingActivity covertToMarketingActivity(FActivity activity) throws Exception
    {
        MarketingActivity marketingActivity = new MarketingActivity();
        if (activity != null)
        {
            //将时间设置成午夜12点
            activity.setStartTime(GMSUtil.getEarlyMorning(activity.getStartTime()));
            activity.setEndTime(GMSUtil.getMidNight(activity.getEndTime()));

            EntityTools.copyValue(activity, marketingActivity);
        }

        return marketingActivity;
    }

    private FActivity convertToFActivity(MarketingActivity activityInfo) throws Exception
    {
        FActivity fActivity = new FActivity();
        String webVisitUrl = "";
        if (activityInfo != null)
        {
            EntityTools.copyValue(activityInfo, fActivity);
            if ("P".equals(fActivity.getPublishStatus()))
            {
                webVisitUrl = UrlUtils.getActiveUrl(fActivity.getActivityId());
            }
            fActivity.setWebVisitUrl(webVisitUrl);
        }
        return fActivity;
    }

    /**
     * 校验活动信息
     * @param marketingActivity 
     * @return
     */
    private boolean checkMarketingActivity(MarketingActivity marketingActivity)
    {
        if (marketingActivity == null)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(marketingActivity.getActivityId()) || marketingActivity.getActivityId().length() != 32)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(marketingActivity.getActivityName()) || marketingActivity.getActivityName().length() > 32)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(marketingActivity.getTitle()) || marketingActivity.getTitle().length() > 32)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(marketingActivity.getContent()))
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(marketingActivity.getPurpose()))
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(marketingActivity.getDescription()))
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(marketingActivity.getStartTime().toString()) || TimeUtils.dateDiff(3, marketingActivity.getStartTime(), new Date()) > 0)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(marketingActivity.getEndTime().toString()) || TimeUtils.dateDiff(3, marketingActivity.getEndTime(), marketingActivity.getStartTime()) > 0)
        {
            return false;
        }
        return true;
    }

}
