package com.gooagoo.analysis.complement.impl;

import org.springframework.stereotype.Service;

import com.gooagoo.analysis.complement.service.ComplementService;
import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.analysis.entity.RuleInput;

/**
 * B-分享[时间段,会员等级,来源（手机/网站）,当天次数,累计次数]
 */
@Service("behaveBComplementService")
public class BehaveBComplementServiceImpl implements ComplementService
{
    @Override
    public RuleInput doComplement(RuleInput ruleInput, Behave behave) throws Exception
    {
        // TODO 当天次数,累计次数
        return ruleInput;
    }

}