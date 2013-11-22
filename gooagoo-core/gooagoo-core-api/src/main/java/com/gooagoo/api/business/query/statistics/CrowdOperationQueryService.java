package com.gooagoo.api.business.query.statistics;

import java.util.List;
import java.util.Set;

import com.gooagoo.entity.business.statistics.UserGroup;
import com.gooagoo.entity.business.user.account.Account;

public interface CrowdOperationQueryService
{

    /**
     * 保存人群 
     * @param shopId   商家id
     * @param crowdName 人群名称
     * @param crowdDesc 人群描述 
     * @param key  用于获取人群 
     * @return
     */
    public abstract boolean saveCrowd(String shopId, String crowdName, String crowdDesc, List<Account> accounts);

    /**
     * 查询商家己保存人群
     * @param shopId
     * @return
     */
    public abstract List<UserGroup> findCrowd(String shopId);

    /**
     * 查询图表中具体标签下的用户
     * @param isCustom 是否商家自定义统计类型
     * @param ayalysisType 统计类型代码
     * @param accounts 条件检索出的用户列表
     * @param label 图中X轴的标签名
     * @return
     */
    public abstract List<Account> findAccounts(String shopId, boolean isCustom, String ayalysisType, List<Account> accounts, String label);

    /**
     * 根据人群ID查询人群列表
     * @param groupId
     * @return
     */
    public Set<Account> getAccountsByGroupID(String groupId);
}
