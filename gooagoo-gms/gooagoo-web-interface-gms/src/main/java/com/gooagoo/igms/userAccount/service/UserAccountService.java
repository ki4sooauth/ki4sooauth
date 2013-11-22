package com.gooagoo.igms.userAccount.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.view.gms.account.UserView;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.rule.FRuleInfo;

public interface UserAccountService
{
    /**
     * 根据历史条件查询用户账号及详细信息（分页）
     * @param ruleInfo
     * @return 
     * @throws Exception 
     */
    public TransData<PageModel<UserView>> pageUserAccount(HttpServletRequest request) throws Exception;

    /**
     * 根据历史条件查询用户账号
     * @param ruleInfo
     * @return 
     * @throws Exception 
     */
    public List<Account> getUserAccountList(FRuleInfo ruleInfo, String shopId, String channelCode) throws Exception;

    /**
     * 规则信息对象转换
     * @param fRuleInfo
     * @return
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
    public RuleInfo covertToRuleInfo(FRuleInfo fRuleInfo) throws IllegalArgumentException, IllegalAccessException;

    /**
     * 根据历史查询用户账户总数
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<Object> getUserAccountCount(HttpServletRequest request) throws Exception;
}
