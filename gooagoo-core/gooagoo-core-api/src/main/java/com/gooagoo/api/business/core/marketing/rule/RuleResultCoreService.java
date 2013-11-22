package com.gooagoo.api.business.core.marketing.rule;

import java.util.List;

import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.entity.generator.marketing.RuleResult;

public interface RuleResultCoreService
{
    /**
     * 删除规则结果
     * @param ruleResultId
     * @return
     * @throws Exception
     */
    public boolean deleteRuleResult(String ruleResultId) throws Exception;

    /**
     * 添加规则结果
     * @param ruleResult
     * @return
     * @throws Exception
     */
    public boolean addRuleResult(RuleResult ruleResult) throws Exception;

    /**
     * 修改规则结果
     * @param ruleResult
     * @return
     * @throws Exception
     */
    public boolean updateRuleResult(RuleResult ruleResult) throws Exception;

    /**
     * 审核规则结果
     * @param shopId
     * @param ruleResultId
     * @param status 审核状态(Y-通过，N-不通过)
     * @param note 审核备注
     * @return
     * @throws Exception
     */
    public boolean reviewedRuleResult(String ruleResultId, String status, String note) throws Exception;

    /**
     * 发布规则结果(修改发布状态)
     * @param ruleResult
     * @return
     * @throws Exception
     */
    public boolean publishRuleResult(RuleResult ruleResult) throws Exception;

    /**
     * 删除规则结果和规则信息
     * @param ruleInfoId
     * @return
     * @throws Exception
     */
    public boolean deleteRuleResultAndInfo(String ruleInfoId) throws Exception;

    /**
     * 添加规则结果和规则信息
     * @param ruleResult
     * @return
     * @throws Exception
     */
    public boolean addRuleResultAndInfo(RuleResult ruleResult, RuleInfo ruleInfo) throws Exception;

    /**
     * 修改规则结果和规则信息
     * @param ruleResult
     * @return
     * @throws Exception
     */
    public boolean updateRuleResultAndInfo(RuleResult ruleResult, RuleInfo ruleInfo) throws Exception;

    /**
     * 审核规则结果和规则信息
     * @param shopId
     * @param ruleInfoId
     * @param status 审核状态(Y-通过，N-不通过)
     * @param note 审核备注
     * @return
     * @throws Exception
     */
    public boolean reviewedRuleResultAndInfo(String ruleInfoId, String status, String note) throws Exception;

    /**
     * 发布规则结果和规则信息
     * @param ruleInfoId
     * @param userList
     * @return
     * @throws Exception
     */
    public boolean publishRuleResultAndInfo(String ruleInfoId, List<Account> userList) throws Exception;

}
