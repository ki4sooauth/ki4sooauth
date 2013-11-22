package com.gooagoo.analysis.marketingEngine;

import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.analysis.entity.MarketingNotice;

public interface MarketingEngineService
{
    /**
     * 营销分析
     * @param obj   行为对象
     * @return 分析结果
     * @throws Exception
     */
    public MarketingNotice<?> doAnalysis(Behave behave) throws Exception;
}
