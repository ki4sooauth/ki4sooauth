package com.gooagoo.analysis.complement.impl;

import org.springframework.stereotype.Service;

import com.gooagoo.analysis.complement.service.ComplementService;
import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.analysis.entity.RuleInput;

/**
 * 行为类型：4-申请会员
 * 通用规则属性（已在上层处理）：时间段,来源（手机app、手机网站、个人中心、位置引擎 、转发器、店员助理）
 * 差异性的规则属性：无
 */
@Service("behave4ComplementService")
public class Behave4ComplementServiceImpl implements ComplementService
{

    @Override
    public RuleInput doComplement(RuleInput ruleInput, Behave behave) throws Exception
    {
        return ruleInput;
    }

}