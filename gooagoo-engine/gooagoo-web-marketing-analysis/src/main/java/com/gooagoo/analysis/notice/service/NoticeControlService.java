package com.gooagoo.analysis.notice.service;

import com.gooagoo.analysis.entity.MarketingNotice;

/**
 * 
 * @author YL
 *
 */
public interface NoticeControlService
{
    /**
     * push-推送，email-邮件，message-短信
     * @param marketingNotice
     * @throws Exception
     */
    public void send(MarketingNotice<?> marketingNotice) throws Exception;

}
