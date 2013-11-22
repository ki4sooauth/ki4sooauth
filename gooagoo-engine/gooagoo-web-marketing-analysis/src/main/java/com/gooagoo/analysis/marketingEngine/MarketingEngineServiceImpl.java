package com.gooagoo.analysis.marketingEngine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.analysis.complement.service.ComplementControlService;
import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.analysis.entity.MarketingNotice;
import com.gooagoo.analysis.entity.RuleInput;
import com.gooagoo.analysis.process.service.ProcessControlService;
import com.gooagoo.analysis.ruleEngine.RuleEngineService;
import com.gooagoo.entity.generator.marketing.RuleInfo;

@Service
public class MarketingEngineServiceImpl implements MarketingEngineService
{
    @Autowired
    private RuleEngineService ruleEngineService;
    @Autowired
    private ProcessControlService processControlService;
    @Autowired
    private ComplementControlService complementControlService;

    /**
     * 营销分析
     * @param obj 行为对象
     * @return 营销结果通知
     * @throws Exception
     */
    @Override
    public MarketingNotice<?> doAnalysis(Behave behave) throws Exception
    {
        //1.封装规则引擎入参
        RuleInput ruleInput = this.complementControlService.doComplement(behave);
        //2.调用规则引擎
        List<RuleInfo> ruleInfoList = this.ruleEngineService.matchingRule(ruleInput);
        //3.处理规则结果
        MarketingNotice<?> marketingNotice = this.processControlService.doProcess(ruleInfoList, behave);
        //4.返回营销结果通知
        return marketingNotice;
    }
}
