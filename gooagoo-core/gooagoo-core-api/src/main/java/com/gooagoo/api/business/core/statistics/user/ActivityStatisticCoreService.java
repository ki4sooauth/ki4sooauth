package com.gooagoo.api.business.core.statistics.user;

import java.util.List;

import com.gooagoo.entity.generator.marketing.MarketingActivity;

public interface ActivityStatisticCoreService
{
    /**
     * 猜你喜欢的活动
     * @param account 用户编号
     * @return 营销活动列表
     * @throws Exception
     */
    public abstract List<MarketingActivity> queryGuessYouTastes(String account) throws Exception;

}
