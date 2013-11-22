package com.gooagoo.api.business.query.statistics;

import java.util.List;

import com.gooagoo.entity.business.marketing.rule.HistoryCondition;
import com.gooagoo.entity.business.statistics.BasicQueryParameters;

public interface QueryParametersQueryService
{
    /**
     * 保存查询参数
     * @param corpId 商家ID
     * @param analysisType 统计分析类型
     * @param isCustom 是否商家定义特征
     * @param queryName 保存名称
     * @param queryDesc 保存描述
     * @param historyCondition 查询条件
     * @return
     */
    public boolean saveQueryParameters(String corpId, String analysisType, boolean isCustom, String queryName, String queryDesc, HistoryCondition historyCondition);

    /**
     * 查询商家定义过的查询
     * @param corpId
     * @return
     */
    public List<BasicQueryParameters> findQueryParameters(String corpId);

    /**
     * @param id 一组查询条件标识
     * @return
     */
    //public ChartVo memberStatisticService(String id);

    /**
     * 根据保存的查询条件ID查询历史条件
     * @param queryParametersId
     * @return
     */
    public HistoryCondition getHistoryCondition(String queryParametersId);
}
