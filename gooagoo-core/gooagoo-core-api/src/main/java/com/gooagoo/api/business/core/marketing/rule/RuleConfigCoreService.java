package com.gooagoo.api.business.core.marketing.rule;

import com.gooagoo.entity.generator.marketing.RuleConfig;

/**
 * 规则配置表管理
 */
public interface RuleConfigCoreService
{

    /**
     * 添加规则配置表
     * @param ruleConfig 规则配置表
     * @return
     * @throws Exception
     */
    public boolean addRuleConfig(RuleConfig ruleConfig) throws Exception;

    /**
     * 修改规则配置表
     * @param ruleConfig 规则配置表
     * @return
     * @throws Exception
     */
    public boolean updateRuleConfig(RuleConfig ruleConfig) throws Exception;

    /**
     * 删除规则配置表
     * @param ids 规则配置编号多个逗号分隔
     * @return
     * @throws Exception
     */
    public boolean deleteRuleConfig(String ids) throws Exception;

}
