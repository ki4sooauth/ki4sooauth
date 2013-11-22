package com.gooagoo.query.business.statistics;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.statistics.ShareStatisticQueryService;
import com.gooagoo.query.business.statistics.common.CouponCommonOperate;

@Service
public class ShareStatisticQueryServiceImpl implements ShareStatisticQueryService
{
    @Override
    public int couponShareTimes(String couponId, String userType, String dateType, Date dateTime)
    {
        return CouponCommonOperate.getTimes(couponId, "S", userType, dateType, dateTime, null, null);
    }

    @Override
    public List<String> couponSharePeople(String couponId, String userType, String dateType, Date dateTime)
    {
        return CouponCommonOperate.getPeople(couponId, "S", userType, dateType, dateTime, null, null);
    }

}
