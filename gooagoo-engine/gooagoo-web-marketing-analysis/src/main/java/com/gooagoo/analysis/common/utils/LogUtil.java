package com.gooagoo.analysis.common.utils;

import java.util.Date;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.common.jms.JmsUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.business.log.MessageLog;
import com.gooagoo.entity.message.GooagooMessage;

@Service
public class LogUtil
{
    @Autowired
    private JmsTemplate messageLogTemplate;
    @Autowired
    private ActiveMQQueue messageLogDestination;

    /**
     * 消息路由日志发送前调用此方法
     * @param log
     */
    public void sendLog(MessageLog log)
    {
        log.setSendtime(new Date());
        JmsUtils.send(this.messageLogTemplate, this.messageLogDestination, log);
        log.setException("");
    }

    /**
     * 消费者刚接收到GooagooMessage时调用此方法
     * Server填写相应接收服务系统代码（营销引擎-11）
     * @param gooagooMessage
     * @param log
     */
    public MessageLog setLog(GooagooMessage<?> gooagooMessage)
    {
        MessageLog log = new MessageLog();
        log.setRecetime(new Date());
        log.setUuid(gooagooMessage.getUuid());
        log.setSource(gooagooMessage.getSource() != null ? gooagooMessage.getSource() : "");
        log.setBehaveCode(gooagooMessage.getBehaveCode() != null ? gooagooMessage.getBehaveCode() : "");
        log.setBehaveType(gooagooMessage.getBehaveType() != null ? gooagooMessage.getBehaveType() : "");
        log.setServer("11");
        return log;
    }

    /**
     * 如果一条消息产生多条消息则调用此方法
     * 消息路由日志产生新的UUID，父UUID采用GooagooMessage的UUID;
     * 新的GooagooMessage的UUID则与消息路由日志的新UUID保持一致;
     * @param log 消息路由日志
     * @param gooagooMessage GooagooMessage
     */
    public void changeUUID(MessageLog log, Behave behave, GooagooMessage<?> gooagooMessage)
    {
        log.setUuid(UUID.getUUID());
        log.setPuuid(gooagooMessage.getUuid());
        behave.setBehaveId(log.getUuid());
    }

}
