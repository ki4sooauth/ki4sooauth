package com.gooagoo.api.business.core.marketing.shortmessage;

import java.util.List;

import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.entity.generator.marketing.ShortMessage;

/**
 * 短信管理
 */
public interface ShortMessageCoreService
{

    /**
     *  6.5.1. 创建短信
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean addShortMessage(ShortMessage shortMessage) throws Exception;

    /**
     *   6.5.2. 编辑短信
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean updateShortMessage(ShortMessage shortMessage) throws Exception;

    /**
     * 6.5.3. 审核短信
     * @param id
     * @param status 审核状态(Y-通过，N-不通过)
     * @param note 审核备注
     * @return
     * @return
     * @throws Exception
     */
    public boolean reviewedShortMessage(String id, String status, String note) throws Exception;

    /**
     * 6.5.4.发布短信
     * @param id
     * @param userList
     * @param ruleInfo
     * @return
     * @throws Exception
     */
    public boolean publishShortMessage(String id, List<Account> userList, RuleInfo ruleInfo) throws Exception;

    /**
     *   6.5.7. 删除短信
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean deleteShortMessage(String id) throws Exception;

}
