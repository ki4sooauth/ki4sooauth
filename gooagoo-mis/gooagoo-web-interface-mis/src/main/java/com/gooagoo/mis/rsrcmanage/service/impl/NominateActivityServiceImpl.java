package com.gooagoo.mis.rsrcmanage.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.system.resource.recommend.RecommendActivityCoreService;
import com.gooagoo.api.business.query.system.nominate.NominateActivityQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingActivityGeneratorQueryService;
import com.gooagoo.api.generator.query.sys.NominateActivityGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.business.system.nominate.NominateActivityBusiness;
import com.gooagoo.entity.generator.marketing.MarketingActivity;
import com.gooagoo.entity.generator.sys.NominateActivity;
import com.gooagoo.entity.generator.sys.NominateActivityExample;
import com.gooagoo.entity.generator.sys.NominateActivityExample.Criteria;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.mis.constants.MisMessageConst;
import com.gooagoo.mis.rsrcmanage.service.NominateActivityService;
import com.gooagoo.mis.util.UtilsMis;
import com.gooagoo.view.general.PageCondition;
import com.gooagoo.view.general.PageModel;
import com.gooagoo.view.mis.recommendManage.MMarketingActivity;
import com.gooagoo.view.mis.recommendManage.MNominateActivity;
import com.gooagoo.view.mis.recommendManage.MNominateActivityBusiness;

@Service(value = "nominateActivityService")
public class NominateActivityServiceImpl implements NominateActivityService
{
    @Autowired
    private NominateActivityGeneratorQueryService nominateActivityGeneratorQueryService;
    @Autowired
    private RecommendActivityCoreService recommendActivityCoreService;
    @Autowired
    private MarketingActivityGeneratorQueryService marketingActivityGeneratorQueryService;
    @Autowired
    private NominateActivityQueryService nominateActivityQueryService;

    /**
     * 查询所有活动列表
     */
    @Override
    public TransData<PageModel<MNominateActivityBusiness>> queryActivityList(HttpServletRequest request) throws Exception
    {
        NominateActivityBusiness activity = ServletUtils.objectMethod(NominateActivityBusiness.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        PageModel<MNominateActivityBusiness> pm = new PageModel<MNominateActivityBusiness>();
        if (pageCondition != null)
        {
            pm.setPageIndex(pageCondition.getPageIndex());
            pm.setPageSize(pageSize);
        }
        Integer count = this.nominateActivityQueryService.countNominateActivityBusiness(activity);
        pm.setCount(count);
        if (count > 0)
        {
            List<NominateActivityBusiness> activityList = this.nominateActivityQueryService.findNominateActivityBusiness(activity, pm.getPageIndex(), pageSize);
            for (NominateActivityBusiness base : activityList)
            {
                MNominateActivityBusiness mbase = new MNominateActivityBusiness();
                EntityTools.copyValue(base, mbase);
                pm.getResult().add(mbase);
            }
        }
        return new TransData<PageModel<MNominateActivityBusiness>>(true, null, pm);
    }

    /**
     * 推荐活动操作
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> addNominateActivity(HttpServletRequest request) throws Exception
    {
        String nominateIds = ServletRequestUtils.getStringParameter(request, "ids", "");
        MNominateActivity nom = ServletUtils.objectMethod(MNominateActivity.class, request);
        nom.setActivityId(nominateIds);
        // 参数验证
        String check = this.checkNominateActivity(nom);
        if (check != null)
        {
            return new TransData<Object>(false, check, null);
        }
        boolean flag = false;
        String id = nominateIds.split(",")[0];
        MarketingActivity mark = this.marketingActivityGeneratorQueryService.selectUnDelByPrimaryKey(id);
        NominateActivity nominate = new NominateActivity();
        if (mark != null)
        {
            nominate.setId(UUID.getUUID());
            nominate.setShopId(mark.getShopId());
            nominate.setActivityId(mark.getActivityId());
            nominate.setStartTime(nom.getStartTime());
            nominate.setEndTime(nom.getEndTime());
            flag = this.recommendActivityCoreService.addRecommendActivity(nominate);
            if (!flag)
            {
                new GooagooException("推荐活动失败");
            }
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_NOMINATE_ACTIVITY_SUCCESS, MisMessageConst.MIS_NOMINATE_ACTIVITY_FAIL);
    }

    /**
     * 查询推荐活动列表
     */
    @Override
    public TransData<PageModel<MNominateActivityBusiness>> queryNominateActivity(HttpServletRequest request) throws Exception
    {
        NominateActivityBusiness activity = ServletUtils.objectMethod(NominateActivityBusiness.class, request);
        PageCondition pageCondition = ServletUtils.objectMethod(PageCondition.class, request);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        PageModel<MNominateActivityBusiness> pm = new PageModel<MNominateActivityBusiness>();
        if (pageCondition != null)
        {
            pm.setPageIndex(pageCondition.getPageIndex());
            pm.setPageSize(pageSize);
        }
        Integer count = this.nominateActivityQueryService.countNominateActivity(activity);
        pm.setCount(count);
        if (count > 0)
        {
            List<NominateActivityBusiness> activityList = this.nominateActivityQueryService.findNominateActivity(activity, pm.getPageIndex(), pageSize);
            for (NominateActivityBusiness base : activityList)
            {
                MNominateActivityBusiness mbase = new MNominateActivityBusiness();
                EntityTools.copyValue(base, mbase);
                pm.getResult().add(mbase);
            }
        }
        return new TransData<PageModel<MNominateActivityBusiness>>(true, null, pm);
    }

    /**
     * 取消推荐活动操作
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> updateNominateActivity(HttpServletRequest request) throws Exception
    {
        String nominateIds = ServletRequestUtils.getStringParameter(request, "id", "");
        boolean flag = false;
        for (int i = 0; i < nominateIds.split(",").length; i++)
        {
            String id = nominateIds.split(",")[i];
            flag = this.recommendActivityCoreService.delRecommendActivity(id);
            if (!flag)
            {
                new GooagooException("取消推荐活动失败");
            }
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_CANCEL_ACTIVITY_SUCCESS, MisMessageConst.MIS_CANCEL_ACTIVITY_FAIL);
    }

    /**
     * 修改推荐活动操作
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public TransData<Object> updateNominateActivityT(HttpServletRequest request) throws Exception
    {
        MNominateActivity nom = ServletUtils.objectMethod(MNominateActivity.class, request);
        // 参数验证
        String check = this.checkNominateActivity(nom);
        if (check != null)
        {
            return new TransData<Object>(false, check, null);
        }
        boolean flag = false;
        NominateActivity mark = new NominateActivity();
        EntityTools.copyValue(nom, mark);
        flag = this.recommendActivityCoreService.updateRecommendActivity(mark);
        if (!flag)
        {
            new GooagooException("修改推荐活动失败");
        }
        return UtilsMis.getBooleanResult(flag, MisMessageConst.MIS_UPDATE_ACTIVITY_SUCCESS, MisMessageConst.MIS_UPDATE_ACTIVITY_FAIL, mark.getId());
    }

    /**
     * 推荐活动操作页面
     */
    @Override
    public TransData<Object> addNominateActivityPage(HttpServletRequest request) throws Exception
    {
        String ids = ServletRequestUtils.getStringParameter(request, "ids", "");
        MarketingActivity activity = this.marketingActivityGeneratorQueryService.selectUnDelByPrimaryKey(ids.split(",")[0]);
        if (activity != null)
        {
            MMarketingActivity mactivity = new MMarketingActivity();
            EntityTools.copyValue(activity, mactivity);
            return new TransData<Object>(true, null, mactivity);
        }
        else
        {
            return new TransData<Object>(false, MisMessageConst.SYS_LOAD_DATA_ERROR, null);
        }
    }

    /**
     * 修改推荐活动页面
     */
    @SuppressWarnings("null")
    @Override
    public TransData<Object> updateNominateActivityTPage(HttpServletRequest request) throws Exception
    {
        String ids = ServletRequestUtils.getStringParameter(request, "id", "");
        NominateActivity acti = this.nominateActivityGeneratorQueryService.selectUnDelByPrimaryKey(ids.split(",")[0]);
        if (acti != null)
        {
            MNominateActivity macti = new MNominateActivity();
            EntityTools.copyValue(acti, macti);
            MarketingActivity activity = this.marketingActivityGeneratorQueryService.selectUnDelByPrimaryKey(acti.getActivityId());
            if (activity != null)
            {
                macti.setActivityName(activity.getActivityName());
                macti.setImgUrl(activity.getImgUrl());
            }
            return new TransData<Object>(true, null, macti);
        }
        else
        {
            return new TransData<Object>(false, MisMessageConst.SYS_LOAD_DATA_ERROR, null, acti.getActivityId());
        }
    }

    /**
     * 验证活动是否已推荐
     */
    @Override
    public TransData<Object> checkNominateActivityT(HttpServletRequest request) throws Exception
    {
        String ids = ServletRequestUtils.getStringParameter(request, "ids", "");
        MarketingActivity activity = this.marketingActivityGeneratorQueryService.selectUnDelByPrimaryKey(ids.split(",")[0]);
        if (activity != null)
        {
            NominateActivityExample exam = new NominateActivityExample();
            exam.createCriteria().andActivityIdEqualTo(activity.getActivityId()).andShopIdEqualTo(activity.getShopId()).andIsDelEqualTo("N");
            List<NominateActivity> acti = this.nominateActivityGeneratorQueryService.selectByExample(exam);
            if (acti.size() > 0)
            {
                return new TransData<Object>(false, MisMessageConst.MIS_DICTIARY_PARAMETER_CHECKACTIVITY_FAIL, null);
            }
        }
        return new TransData<Object>(true, null, null);
    }

    /**
     * 入参校验
     * @param nom
     * @return
     */
    private String checkNominateActivity(MNominateActivity nom)
    {
        //结束时间必须大于起始时间
        if (nom.getStartTime().compareTo(nom.getEndTime()) >= 0)
        {
            return MisMessageConst.MIS_NOMINATE_START_END;
        }
        //起始时间不允许重复存在
        NominateActivityExample example = new NominateActivityExample();
        Criteria criteria = example.createCriteria();
        if (StringUtils.hasText(nom.getId()))
        {
            criteria.andIdNotEqualTo(nom.getId());
        }
        criteria.andIsDelEqualTo("N").andActivityIdEqualTo(nom.getActivityId()).andStartTimeLessThanOrEqualTo(nom.getStartTime()).andEndTimeGreaterThanOrEqualTo(nom.getStartTime());
        List<NominateActivity> shopList = this.nominateActivityGeneratorQueryService.selectByExample(example);
        if (shopList != null && shopList.size() > 0)
        {
            return MisMessageConst.MIS_NOMINATE_START_EXITS;
        }
        //结束时间不允许重复存在
        NominateActivityExample example2 = new NominateActivityExample();
        Criteria criteria2 = example2.createCriteria();
        if (StringUtils.hasText(nom.getId()))
        {
            criteria2.andIdNotEqualTo(nom.getId());
        }
        criteria2.andIsDelEqualTo("N").andActivityIdEqualTo(nom.getActivityId()).andStartTimeLessThanOrEqualTo(nom.getEndTime()).andEndTimeGreaterThanOrEqualTo(nom.getEndTime());
        List<NominateActivity> shopList2 = this.nominateActivityGeneratorQueryService.selectByExample(example2);
        if (shopList2 != null && shopList2.size() > 0)
        {
            return MisMessageConst.MIS_NOMINATE_END_EXITS;
        }
        //不允许包含已存在的推荐时间段
        NominateActivityExample example3 = new NominateActivityExample();
        Criteria criteria3 = example3.createCriteria();
        if (StringUtils.hasText(nom.getId()))
        {
            criteria3.andIdNotEqualTo(nom.getId());
        }
        criteria3.andIsDelEqualTo("N").andActivityIdEqualTo(nom.getActivityId()).andStartTimeGreaterThan(nom.getStartTime()).andEndTimeLessThan(nom.getEndTime());
        List<NominateActivity> shopList3 = this.nominateActivityGeneratorQueryService.selectByExample(example3);
        if (shopList3 != null && shopList3.size() > 0)
        {
            return MisMessageConst.MIS_NOMINATE_TIME_EXITS;
        }
        return null;
    }

}
