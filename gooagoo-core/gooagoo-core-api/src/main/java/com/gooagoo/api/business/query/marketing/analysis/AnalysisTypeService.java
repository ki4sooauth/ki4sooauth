package com.gooagoo.api.business.query.marketing.analysis;

import java.util.List;

import com.gooagoo.entity.business.marketing.analysis.AnalysisType;


public interface AnalysisTypeService
{

    /**
     * 获取指定商家的统计类型列表
     * @param corpId 商家标识
     * @return
     */
    public List<AnalysisType> getAnalysisTypeList(String corpId);
}
