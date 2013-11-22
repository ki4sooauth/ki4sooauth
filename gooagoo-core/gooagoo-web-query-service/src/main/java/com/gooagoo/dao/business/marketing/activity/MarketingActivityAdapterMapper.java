package com.gooagoo.dao.business.marketing.activity;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.business.marketing.activity.MarketingActivityAdapter;
import com.gooagoo.entity.generator.marketing.MarketingActivity;

public interface MarketingActivityAdapterMapper
{
    /**
     * 按时间查询营销活动信息
     * @param firstdate 查询时间（YYYY-MM-DD）
     * @param lastdate 查询时间（YYYY-MM-DD）
     * @return
     */
    public List<MarketingActivityAdapter> findActityAdapterByDate(@Param("firstdate") String firstdate, @Param("lastdate") String lastdate);

    /**
     * 按时间段查询营销活动信息
     * @param begainDate 查询开始时间
     * @param endDate 查询结束时间
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<MarketingActivity> findActityByTimeScope(@Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

}
