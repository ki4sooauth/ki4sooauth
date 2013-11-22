package com.gooagoo.common.jms;

import java.io.Serializable;
import java.util.Map;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.StreamMessage;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import com.gooagoo.common.log.GooagooLog;

/**
 * 转换器
 *
 * @author liangzh 2013-4-24 下午1:04:00
 *
 */
public class MQConvert implements MessageConverter
{
    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException
    {
        if (message instanceof ActiveMQObjectMessage)
        {
            ActiveMQObjectMessage aMsg = (ActiveMQObjectMessage) message;
            return aMsg.getObject();
        }
        else
        {
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException
    {
        if (object instanceof String)
        {
            TextMessage msg = session.createTextMessage((String) object);
            return msg;
        }
        else if (object instanceof Map)
        {
            MapMessage msg = session.createMapMessage();
            Map<String, ? extends Object> map = (Map<String, ? extends Object>) object;
            for (String key : map.keySet())
            {
                msg.setObjectProperty(key, map.get(key));
            }
            return msg;
        }
        else if (object instanceof Serializable)
        {
            ObjectMessage msg = session.createObjectMessage();
            msg.setObject((Serializable) object);
            return msg;
        }
        else if (object instanceof byte[])
        {
            BytesMessage msg = session.createBytesMessage();
            msg.writeBytes((byte[]) object);
            return msg;
        }
        else if (object instanceof StreamMessage)
        {
            StreamMessage msg = session.createStreamMessage();
            return msg;
        }
        else
        {
            if (object == null)
            {
                GooagooLog.warn("发送对象为NULL");
            }
            else
            {
                GooagooLog.warn("发送对象类型不识别");
            }

            return null;
        }
    }
}
