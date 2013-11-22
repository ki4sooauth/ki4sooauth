package com.gooagoo.analysis.notice.impl;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.gooagoo.analysis.entity.MarketingNotice;
import com.gooagoo.analysis.notice.service.NoticeSendService;
import com.gooagoo.common.jms.JmsUtils;

/**
 * email-邮件
 */
@Service("emailSendService")
public class EmailSendServiceImpl implements NoticeSendService
{
    @Autowired
    private JmsTemplate emailTemplate;
    @Autowired
    private ActiveMQQueue emailDestination;

    @Override
    public void send(MarketingNotice<?> marketingNotice) throws Exception
    {
        JmsUtils.send(this.emailTemplate, this.emailDestination, marketingNotice.getGooagooMessage());
    }

}
