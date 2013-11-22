package com.gooagoo.analysis.complement.impl;

import org.springframework.stereotype.Service;

import com.gooagoo.analysis.complement.service.ComplementService;
import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.analysis.entity.RuleInput;

/**
 * 行为类型：1-到店
 * 通用规则属性（已在上层处理）：时间段,会员等级,时长
 * 差异性的规则属性：当天次数（暂不处理）,累计次数（暂不处理）
 */
@Service("behave1ComplementService")
public class Behave1ComplementServiceImpl implements ComplementService
{

    @Override
    public RuleInput doComplement(RuleInput ruleInput, Behave behave) throws Exception
    {
        // TODO 当天次数,累计次数
        return ruleInput;
    }
}
