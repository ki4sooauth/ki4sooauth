package com.gooagoo.api.protecteds.core.marketing;

import java.util.List;

import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.exception.GooagooException;

public interface MarketingProtectedCoreService
{
    /**
     * 保存规则用户关联信息
     * @param users
     * @param rule
     * @return
     * @throws GooagooException
     */
    public void saveMarketingUserLinkList(List<Account> users, RuleInfo rule) throws Exception;
}
