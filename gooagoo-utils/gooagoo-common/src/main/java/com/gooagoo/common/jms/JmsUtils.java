package com.gooagoo.common.jms;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsTemplate;

import com.gooagoo.common.log.GooagooLog;
import com.google.gson.Gson;

/**
 * 消息发送工具类
 *
 * @author liangzh 2013-5-8 下午8:40:41
 *
 */
public class JmsUtils
{

    public static void send(final JmsTemplate template, final ActiveMQQueue destination, final Object object)
    {
        GooagooLog.debug("MQ发送信息:" + new Gson().toJson(object));
        try
        {
            if (template == null)
            {
                throw new Exception("template为NULL");
            }
            if (destination == null)
            {
                throw new Exception("destination为NULL");
            }
            template.convertAndSend(destination, object);
        }
        catch (Exception e)
        {
            GooagooLog.error("MQ发送信息异常", e);
        }
    }
}
