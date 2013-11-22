package com.gooagoo.current.tools;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.business.log.MessageLog;
import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.intelligence.utils.MQUtil;

@Service
public class LogUtil
{

    /**
     * 消息路由日志发送前调用此方法
     * @param log
     */
    public void sendLog(MessageLog log)
    {
        log.setSendtime(new Date());
        MQUtil mqUtil = new MQUtil("log");
        mqUtil.sendObjectMessage(log);
    }

    /**
     * 消费者刚接收到GooagooMessage时调用此方法
     * Server填写相应接收服务系统代码（实时统计-10）
     * @param gooagooMessage
     * @param log
     */
    public void setLog(GooagooMessage<?> gooagooMessage, MessageLog log)
    {
        log.setRecetime(new Date());
        log.setUuid(gooagooMessage.getUuid());
        log.setSource(gooagooMessage.getSource() != null ? gooagooMessage.getSource() : "");
        log.setBehaveCode(gooagooMessage.getBehaveCode() != null ? gooagooMessage.getBehaveCode() : "");
        log.setBehaveType(gooagooMessage.getBehaveType() != null ? gooagooMessage.getBehaveType() : "");
        log.setServer("10");
        gooagooMessage.setSource("10");
    }

    /**
     * 如果一条消息产生多条消息则调用此方法
     * 消息路由日志产生新的UUID，父UUID采用GooagooMessage的UUID;
     * 新的GooagooMessage的UUID则与消息路由日志的新UUID保持一致;
     * @param log 消息路由日志
     * @param gooagooMessage GooagooMessage
     */
    public void changeUUID(MessageLog log, GooagooMessage<?> gooagooMessage)
    {
        log.setUuid(UUID.getUUID());
        log.setPuuid(gooagooMessage.getUuid());
        gooagooMessage.setUuid(log.getUuid());
    }

}
