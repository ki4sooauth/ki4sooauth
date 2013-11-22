package com.gooagoo.api.business.query.user.cache;

import java.util.List;
import java.util.Map;

import com.gooagoo.entity.business.marketing.rule.HistoryCondition;
import com.gooagoo.entity.business.user.MobilePushInfoBusiness;
import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.business.user.account.action.ActionRecord;
import com.gooagoo.entity.business.user.account.property.PropertyRecord;

/**
 * 从缓存中查询用户相关信息
 */
public interface UserCacheQueryService
{

    /**
     * 根据mac查UserId
     * @param mac
     * @return UserId
     * @throws Exception
     */
    public String findUserIdByMac(String mac) throws Exception;

    /**
     * 查询用户信息
     * @param UserId_ShopId
     * @return
     * @throws Exception
     */
    public Map<String, String> findUserInfo(String userId);

    /**
     * 通过历史条件查询用户账号列表
     * @param shopId
     * @param historyCondition   历史条件
     * @param pageIndex 第几页
     * @param pageSize 为null时不分页，返回所有数据
     * @return
     * @throws Exception
     */
    public List<Account> getUserAccountsList(String shopId, HistoryCondition historyCondition) throws Exception;

    /**
     * 根据用户帐号类型和用户帐号获取用户属性信息
     * @param shopId
     * @param accountType   用户类型，参考字段表
     * @param account       用户帐号，如userid、mac地址、手机号码等
     * @return
     * @throws Exception
     */
    public PropertyRecord getUserPropertyRecord(String shopId, String accountType, String account) throws Exception;

    /**
     * 分页查询根据用户帐号类型和用户帐号获取用户历史行为信息
     * @param shopId
     * @param accountType   用户类型，参考字段表
     * @param account       用户帐号，如userid、mac地址、手机号码等
     * @param pageIndex 第几页
     * @param pageSize 每页数
     * @return
     * @throws Exception
     */
    public List<ActionRecord> getUserActionRecords(String shopId, String accountType, String account, Integer pageIndex, Integer pageSize) throws Exception;

    /**
     * 根据用户帐号类型和用户帐号获取用户历史行为信息的总条数
     * @param shopId
     * @param accountType
     * @param account
     * @return
     * @throws Exception
     */
    public Integer countUserActionRecords(String shopId, String accountType, String account) throws Exception;

    /**
     * 查询用户信息
     * @param mac
     * @return
     * @throws Exception
     */
    public MobilePushInfoBusiness findUserMobileInfoByMacAddress(String mac) throws Exception;
}
