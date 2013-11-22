package com.gooagoo.api.business.query.statistics;

import java.util.List;

import com.gooagoo.entity.business.statistics.ChartVo;
import com.gooagoo.entity.business.user.account.Account;

public interface RecordStatisticQueryService
{

    /**
     * 获取会员特征统计数据
     * @param shopId 商家Id
     * @param people 人群
     * @param memberFeature 会员特征
     * @return
     */
    public abstract ChartVo memberFeatureStatistic(String shopId, List<Account> people, String memberFeature);

    /**
     * 获取非会员特征统计数据
     * @param shopId 商家Id
     * @param people 人群
     * @param statistics 统计类型
     * @return
     */
    public abstract ChartVo memberStatisticService(String shopId, List<Account> people, String statistics);
    
    /**
     * 获取其它统计数据
     * @param shopId 商家Id
     * @param people 人群
     * @param statistics 统计类型
     * @param startDate 开始日期：YYYY-MM-DD
     * @param endDate 结束日期：YYYY-MM-DD
     * @param uuid 唯一标识符
     * @return
     */
    public abstract ChartVo memberStatisticService(String shopId, List<Account> people, String statistics,String startDate,String endDate,String uuid);
}
