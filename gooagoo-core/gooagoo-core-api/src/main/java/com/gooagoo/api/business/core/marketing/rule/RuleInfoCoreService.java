package com.gooagoo.api.business.core.marketing.rule;

import com.gooagoo.entity.generator.marketing.RuleInfo;

public interface RuleInfoCoreService
{
    /**
     * 删除规则信息
     * @param shopId
     * @param ruleId
     * @return
     * @throws Exception
     */
    public boolean deleteRuleInfo(String ruleId) throws Exception;

    /**
     * 添加规则信息
     * @param ruleInfo
     * @return
     * @throws Exception
     */
    public boolean addRuleInfo(RuleInfo ruleInfo) throws Exception;

    /**
     * 修改规则信息
     * @param ruleInfo
     * @return
     * @throws Exception
     */
    public boolean updateRuleInfo(RuleInfo ruleInfo) throws Exception;

    /**
     * 审核规则信息
     * @param ruleId
     * @param status 审核状态(Y-通过，N-不通过)
     * @param note 审核备注
     * @return
     * @throws Exception
     */
    public boolean reviewedRuleInfo(String ruleId, String status, String note) throws Exception;

    /**
     * 发布规则信息(修改发布状态)
     * @param ruleInfo
     * @return
     * @throws Exception
     */
    public boolean publishRuleInfo(RuleInfo ruleInfo) throws Exception;

}
