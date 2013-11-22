package com.gooagoo.api.business.core.marketing.notice;

import java.util.List;

import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.generator.marketing.NoticeInfo;
import com.gooagoo.entity.generator.marketing.RuleInfo;

/**
 * 通知管理
 */
public interface NoticeCoreService
{

    /**
     *     6.7.1. 创建通知
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean addNotice(NoticeInfo noticeInfo) throws Exception;

    /**
    *   6.7.2. 编辑通知
    * @param parameter
    * @return
    * @throws Exception
    */
    public boolean updateNotice(NoticeInfo noticeInfo) throws Exception;

    /**
    *  6.7.3. 审核通知
    * @param id
    * @param status 审核状态(Y-通过，N-不通过)
    * @param note 审核备注
    * @return
    * @throws Exception
    */
    public boolean reviewedNotice(String id, String status, String note) throws Exception;

    /**
    *   6.7.4. 发布通知
    * @param id
    * @param userList
    * @param ruleInfo
    * @return
    * @throws Exception
    */
    public boolean publishNotice(String id, List<Account> userList, RuleInfo ruleInfo) throws Exception;

    /**
    *   6.7.7. 删除通知
    * @param id
    * @return
    * @throws Exception
    */
    public boolean deleteNotice(String id) throws Exception;

}
