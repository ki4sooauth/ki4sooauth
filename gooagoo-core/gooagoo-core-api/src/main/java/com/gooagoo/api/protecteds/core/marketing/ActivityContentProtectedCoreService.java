package com.gooagoo.api.protecteds.core.marketing;

import java.util.List;

import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.generator.marketing.RuleInfo;

public interface ActivityContentProtectedCoreService
{

    /**
     * 发布活动内容
     * 1.初始化规则中的默认信息
     * 2.活动内容信息校验
     * 3.保存活动内容的营销用户关联信息
     * 4.保存活动内容的发布规则信息
     * 5.更新活动内容的发布状态
     * @param objectId 发布对象Id
     * @param ruleType 规则类型
     * @param users 发布用户
     * @param ruleInfo 规则信息
     * @return
     * @throws Exception
     */
    public boolean release(String objectId, String ruleType, List<Account> users, RuleInfo ruleInfo) throws Exception;

}
