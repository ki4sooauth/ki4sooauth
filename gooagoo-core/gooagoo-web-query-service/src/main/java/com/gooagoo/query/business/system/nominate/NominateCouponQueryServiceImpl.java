package com.gooagoo.query.business.system.nominate;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.system.nominate.NominateCouponQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.dao.business.sys.nominate.NominateCouponAdapterMapper;
import com.gooagoo.entity.business.system.nominate.NominateCouponBusiness;
import com.google.gson.Gson;

@Service
public class NominateCouponQueryServiceImpl implements NominateCouponQueryService
{

    @Autowired
    private NominateCouponAdapterMapper nominateCouponAdapterMapper;

    @Override
    public List<NominateCouponBusiness> findNominateCouponBusiness(NominateCouponBusiness nominateCouponBusiness, Integer pageIndex, Integer pageSize)
    {
        GooagooLog.info("findNominateCouponBusiness-->入参:" + nominateCouponBusiness + "页码" + pageIndex + "显示数量" + pageSize);
        NominateCouponBusiness snominateCouponBusiness = this.convertEndTime(nominateCouponBusiness);
        if (snominateCouponBusiness.getPublishEndTime() != null)
        {
            GooagooLog.info("findNominateGoodsBusiness-->入参优惠券信息表优惠凭证发行截止日期" + TimeUtils.convertDateToString(snominateCouponBusiness.getPublishEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        if (snominateCouponBusiness.getUseEndTime() != null)
        {
            GooagooLog.info("findNominateGoodsBusiness-->入参优惠券信息表使用截止日期" + TimeUtils.convertDateToString(snominateCouponBusiness.getUseEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        pageIndex = this.pageIndex(pageIndex, pageSize);
        GooagooLog.info("findNominateGoodsBusiness-->入参分页处理:" + pageIndex);
        List<NominateCouponBusiness> nominateCouponBusinessList = this.nominateCouponAdapterMapper.findNominateCouponBusiness(snominateCouponBusiness, pageIndex, pageSize);
        GooagooLog.debug("取出来的优惠券信息:" + new Gson().toJson(nominateCouponBusinessList));
        return nominateCouponBusinessList;

    }

    @Override
    public int countNominateCouponBusiness(NominateCouponBusiness nominateCouponBusiness)
    {
        GooagooLog.info("findNominateCouponBusiness-->入参:" + nominateCouponBusiness);
        NominateCouponBusiness snominateCouponBusiness = this.convertEndTime(nominateCouponBusiness);
        if (snominateCouponBusiness.getEndTime() != null)
        {
            GooagooLog.info("findNominateGoodsBusiness-->入参推荐优惠券表结束时间" + TimeUtils.convertDateToString(snominateCouponBusiness.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        if (snominateCouponBusiness.getPublishEndTime() != null)
        {
            GooagooLog.info("findNominateGoodsBusiness-->入参优惠券信息表优惠凭证发行截止日期" + TimeUtils.convertDateToString(snominateCouponBusiness.getPublishEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        if (snominateCouponBusiness.getUseEndTime() != null)
        {
            GooagooLog.info("findNominateGoodsBusiness-->入参优惠券信息表使用截止日期" + TimeUtils.convertDateToString(snominateCouponBusiness.getUseEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        int count = this.nominateCouponAdapterMapper.countNominateCouponBusiness(snominateCouponBusiness);
        GooagooLog.debug("取出来的优惠券信息数量:" + count);
        return count;
    }

    @Override
    public List<NominateCouponBusiness> findNominateCoupon(NominateCouponBusiness nominateCouponBusiness, Integer pageIndex, Integer pageSize)
    {
        GooagooLog.info("findNominateCoupon-->入参:" + nominateCouponBusiness + "页码" + pageIndex + "显示数量" + pageSize);
        NominateCouponBusiness snominateCouponBusiness = this.convertEndTime(nominateCouponBusiness);
        if (snominateCouponBusiness.getPublishEndTime() != null)
        {
            GooagooLog.info("findNominateCoupon-->入参优惠券信息表优惠凭证发行截止日期" + TimeUtils.convertDateToString(snominateCouponBusiness.getPublishEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        if (snominateCouponBusiness.getUseEndTime() != null)
        {
            GooagooLog.info("findNominateCoupon-->入参优惠券信息表使用截止日期" + TimeUtils.convertDateToString(snominateCouponBusiness.getUseEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        pageIndex = this.pageIndex(pageIndex, pageSize);
        GooagooLog.info("findNominateCoupon-->入参分页处理:" + pageIndex);
        List<NominateCouponBusiness> nominateCouponBusinessList = this.nominateCouponAdapterMapper.findNominateCoupon(snominateCouponBusiness, pageIndex, pageSize);
        GooagooLog.debug("取出来的优惠券信息:" + new Gson().toJson(nominateCouponBusinessList));
        return nominateCouponBusinessList;
    }

    @Override
    public int countNominateCoupon(NominateCouponBusiness nominateCouponBusiness)
    {
        GooagooLog.info("findNominateCouponBusiness-->入参:" + nominateCouponBusiness);
        NominateCouponBusiness snominateCouponBusiness = this.convertEndTime(nominateCouponBusiness);
        if (snominateCouponBusiness.getEndTime() != null)
        {
            GooagooLog.info("findNominateGoodsBusiness-->入参推荐优惠券表结束时间" + TimeUtils.convertDateToString(snominateCouponBusiness.getEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        if (snominateCouponBusiness.getPublishEndTime() != null)
        {
            GooagooLog.info("findNominateGoodsBusiness-->入参优惠券信息表优惠凭证发行截止日期" + TimeUtils.convertDateToString(snominateCouponBusiness.getPublishEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        if (snominateCouponBusiness.getUseEndTime() != null)
        {
            GooagooLog.info("findNominateGoodsBusiness-->入参优惠券信息表使用截止日期" + TimeUtils.convertDateToString(snominateCouponBusiness.getUseEndTime(), "yyyy-MM-dd HH:mm:ss"));
        }
        int count = this.nominateCouponAdapterMapper.countNominateCoupon(snominateCouponBusiness);
        GooagooLog.debug("取出来的优惠券信息数量:" + count);
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

    private NominateCouponBusiness convertEndTime(NominateCouponBusiness nominateCouponBusiness)
    {
        NominateCouponBusiness snominateCouponBusiness = nominateCouponBusiness;
        Date endTime = null, publishEndTime = null, useEndTime = null;
        try
        {
            if (snominateCouponBusiness.getEndTime() != null)
            {
                endTime = TimeUtils.convertStringToDate(TimeUtils.convertDateToString(snominateCouponBusiness.getEndTime(), "yyyy-MM-dd") + " 23:59:59");
            }
            if (snominateCouponBusiness.getPublishEndTime() != null)
            {
                publishEndTime = TimeUtils.convertStringToDate(TimeUtils.convertDateToString(snominateCouponBusiness.getPublishEndTime(), "yyyy-MM-dd") + " 23:59:59");
            }
            if (snominateCouponBusiness.getUseEndTime() != null)
            {
                useEndTime = TimeUtils.convertStringToDate(TimeUtils.convertDateToString(snominateCouponBusiness.getUseEndTime(), "yyyy-MM-dd") + " 23:59:59");
            }

        }
        catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        snominateCouponBusiness.setEndTime(endTime);
        snominateCouponBusiness.setPublishEndTime(publishEndTime);
        snominateCouponBusiness.setUseEndTime(useEndTime);
        return snominateCouponBusiness;
    }

}
