package com.gooagoo.query.business.system.nominate;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.system.nominate.NominateActivityQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.dao.business.sys.nominate.NominateActivityAdapterMapper;
import com.gooagoo.entity.business.system.nominate.NominateActivityBusiness;
import com.google.gson.Gson;

@Service
public class NominateActivityQueryServiceImpl implements NominateActivityQueryService
{

    @Autowired
    private NominateActivityAdapterMapper nominateActivityAdapterMapper;

    @Override
    public List<NominateActivityBusiness> findNominateActivityBusiness(NominateActivityBusiness nominateActivityBusiness, Integer pageIndex, Integer pageSize)
    {
        GooagooLog.info("findNominateActivityBusiness-->入参:" + nominateActivityBusiness + "页码" + pageIndex + "显示数量" + pageSize);
        NominateActivityBusiness snominateActivityBusiness = this.convertTimeEnd(nominateActivityBusiness);
        if (snominateActivityBusiness.getEndTime() != null)
        {
            GooagooLog.info("findNominateGoodsBusiness-->入参推荐活动表结束时间处理" + TimeUtils.convertDateToString(snominateActivityBusiness.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        if (snominateActivityBusiness.getActivityEndTime() != null)
        {
            GooagooLog.info("findNominateGoodsBusiness-->入参营销活动表活动结束时间处理" + TimeUtils.convertDateToString(snominateActivityBusiness.getActivityEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        pageIndex = this.pageIndex(pageIndex, pageSize);
        GooagooLog.info("findNominateGoodsBusiness-->入参分页处理:" + pageIndex);
        List<NominateActivityBusiness> nominateActivityBusinessList = this.nominateActivityAdapterMapper.findNominateActivityBusiness(snominateActivityBusiness, pageIndex, pageSize);
        GooagooLog.debug("取出来的活动信息:" + new Gson().toJson(nominateActivityBusinessList));
        return nominateActivityBusinessList;

    }

    @Override
    public int countNominateActivityBusiness(NominateActivityBusiness nominateActivityBusiness)
    {
        GooagooLog.info("findNominateActivityBusiness-->入参:" + nominateActivityBusiness);

        NominateActivityBusiness snominateActivityBusiness = this.convertTimeEnd(nominateActivityBusiness);
        if (snominateActivityBusiness.getEndTime() != null)
        {
            GooagooLog.info("findNominateGoodsBusiness-->入参推荐活动表结束时间处理" + TimeUtils.convertDateToString(snominateActivityBusiness.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        if (snominateActivityBusiness.getActivityEndTime() != null)
        {
            GooagooLog.info("findNominateGoodsBusiness-->入参营销活动表活动结束时间处理" + TimeUtils.convertDateToString(snominateActivityBusiness.getActivityEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        int count = this.nominateActivityAdapterMapper.countNominateActivityBusiness(snominateActivityBusiness);
        GooagooLog.debug("取出来的活动信息数量:" + count);
        return count;
    }

    @Override
    public List<NominateActivityBusiness> findNominateActivity(NominateActivityBusiness nominateActivityBusiness, Integer pageIndex, Integer pageSize)
    {
        GooagooLog.info("findNominateActivityBusiness-->入参:" + nominateActivityBusiness + "页码" + pageIndex + "显示数量" + pageSize);
        NominateActivityBusiness snominateActivityBusiness = this.convertTimeEnd(nominateActivityBusiness);
        if (snominateActivityBusiness.getEndTime() != null)
        {
            GooagooLog.info("findNominateGoodsBusiness-->入参推荐活动表结束时间处理" + TimeUtils.convertDateToString(snominateActivityBusiness.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        if (snominateActivityBusiness.getActivityEndTime() != null)
        {
            GooagooLog.info("findNominateGoodsBusiness-->入参营销活动表活动结束时间处理" + TimeUtils.convertDateToString(snominateActivityBusiness.getActivityEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        pageIndex = this.pageIndex(pageIndex, pageSize);
        GooagooLog.info("findNominateGoodsBusiness-->入参分页处理:" + pageIndex);
        List<NominateActivityBusiness> nominateActivityBusinessList = this.nominateActivityAdapterMapper.findNominateActivity(snominateActivityBusiness, pageIndex, pageSize);
        GooagooLog.debug("取出来的活动信息:" + new Gson().toJson(nominateActivityBusinessList));
        return nominateActivityBusinessList;
    }

    @Override
    public int countNominateActivity(NominateActivityBusiness nominateActivityBusiness)
    {
        GooagooLog.info("findNominateActivityBusiness-->入参:" + nominateActivityBusiness);

        NominateActivityBusiness snominateActivityBusiness = this.convertTimeEnd(nominateActivityBusiness);
        if (snominateActivityBusiness.getEndTime() != null)
        {
            GooagooLog.info("findNominateGoodsBusiness-->入参推荐活动表结束时间处理" + TimeUtils.convertDateToString(snominateActivityBusiness.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        if (snominateActivityBusiness.getActivityEndTime() != null)
        {
            GooagooLog.info("findNominateGoodsBusiness-->入参营销活动表活动结束时间处理" + TimeUtils.convertDateToString(snominateActivityBusiness.getActivityEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        int count = this.nominateActivityAdapterMapper.countNominateActivity(snominateActivityBusiness);
        GooagooLog.debug("取出来的活动信息数量:" + count);
        return count;
    }

    private Integer pageIndex(Integer pageIndex, Integer pageSize)
    {
        if (pageIndex != null)
        {
            pageIndex = (pageIndex - 1) * pageSize;
        }
        return pageIndex;
    }

    private NominateActivityBusiness convertTimeEnd(NominateActivityBusiness nominateActivityBusiness)
    {
        NominateActivityBusiness snominateActivityBusiness = nominateActivityBusiness;
        Date endTime = null, activityEndTime = null;
        try
        {
            if (snominateActivityBusiness.getEndTime() != null)
            {
                endTime = TimeUtils.convertStringToDate(TimeUtils.convertDateToString(snominateActivityBusiness.getEndTime(), "yyyy-MM-dd") + " 23:59:59");
            }
            if (snominateActivityBusiness.getActivityEndTime() != null)
            {
                activityEndTime = TimeUtils.convertStringToDate(TimeUtils.convertDateToString(snominateActivityBusiness.getActivityEndTime(), "yyyy-MM-dd") + " 23:59:59");
            }
        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        snominateActivityBusiness.setEndTime(endTime);
        snominateActivityBusiness.setActivityEndTime(activityEndTime);
        return snominateActivityBusiness;
    }

}
