package com.gooagoo.analysis.notice.impl;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.gooagoo.analysis.entity.MarketingNotice;
import com.gooagoo.analysis.notice.service.NoticeSendService;
import com.gooagoo.common.jms.JmsUtils;

/**
 * push-推送
 */
@Service("pushSendService")
public class PushSendServiceImpl implements NoticeSendService
{

    @Autowired
    private JmsTemplate mobilePushTemplate;
    @Autowired
    private ActiveMQQueue mobilePushDestination;

    @Override
    public void send(MarketingNotice<?> marketingNotice) throws Exception
    {
        JmsUtils.send(this.mobilePushTemplate, this.mobilePushDestination, marketingNotice.getGooagooMessage());

    }

}
