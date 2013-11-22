package com.gooagoo.analysis.notice.impl;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.gooagoo.analysis.entity.MarketingNotice;
import com.gooagoo.analysis.notice.service.NoticeSendService;
import com.gooagoo.common.jms.JmsUtils;

/**
 * message-短信
 */
@Service("messageSendService")
public class MessageSendServiceImpl implements NoticeSendService
{
    @Autowired
    private JmsTemplate messageTemplate;
    @Autowired
    private ActiveMQQueue messageDestination;

    @Override
    public void send(MarketingNotice<?> marketingNotice) throws Exception
    {
        JmsUtils.send(this.messageTemplate, this.messageDestination, marketingNotice.getGooagooMessage());
    }

}
