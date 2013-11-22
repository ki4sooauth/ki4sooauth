package com.gooagoo.api.business.core.marketing.event;

import java.util.List;

import com.gooagoo.entity.business.user.account.Account;
import com.gooagoo.entity.generator.marketing.MarketingEvent;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.exception.business.sys.TemplateDataIsEmptyException;

/**
 * 事件管理
 */
public interface EventCoreService
{

    /**
     *   6.6.1. 创建事件
     * @param marketingEvent
     * @param marketingItemLink(0-营销内容关联类型,1-营销内容关联编号)
     * @return
     * @throws Exception
     */
    public boolean addEvent(MarketingEvent marketingEvent, String[][] marketingItemLinks) throws Exception;

    /**
    * 6.6.2. 编辑事件
    * @param marketingEvent
     * @param marketingItemLink(0-营销内容关联类型,1-营销内容关联编号)
    * @return
    * @throws Exception
    */
    public boolean updateEvent(MarketingEvent marketingEvent, String[][] marketingItemLinks) throws Exception;

    /**
    * 6.6.3. 审核事件
    * @param eventId
    * @param status 审核状态(Y-通过，N-不通过)
    * @param note 审核备注
    * @return
    * @throws TemplateDataIsEmptyException 事件模板数据为空异常
    */
    public boolean reviewedEvent(String eventId, String status, String note) throws Exception;

    /**
    *  6.6.4. 发布事件
    * @param eventId
    * @param channelCode
    * @param userList
    * @param ruleInfo
    * @return
    * @throws Exception
    */
    public boolean publishEvent(String eventId, String channelCode, List<Account> userList, RuleInfo ruleInfo) throws Exception;

    /**
    *  6.6.7. 删除事件
    * @param eventId
    * @return
    * @throws Exception
    */
    public boolean deleteEvent(String eventId) throws Exception;
}
