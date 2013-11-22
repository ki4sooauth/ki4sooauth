package com.gooagoo.common.jms;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.jms.BytesMessage;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import com.gooagoo.common.log.GooagooLog;
import com.google.gson.Gson;

/**
 * 父监听
 *
 * @author liangzh 2013-4-24 下午12:01:18
 *
 * @param <T>
 */
public abstract class AbstractMQMessageListener<T> implements MessageListener
{

    @SuppressWarnings("unchecked")
    @Override
    public void onMessage(Message message)
    {
        try
        {
            if (message instanceof ObjectMessage)
            {
                ObjectMessage objectMessage = (ObjectMessage) message;
                T object = (T) objectMessage.getObject();
                GooagooLog.debug("MQ接收" + object.getClass() + "信息:" + new Gson().toJson(object));
                this.process(object);
            }
            else if (message instanceof TextMessage)
            {
                TextMessage textMessage = (TextMessage) message;
                T str = (T) textMessage.getText();
                GooagooLog.debug("MQ接收String信息:" + str);
                this.process(str);
            }
            else if (message instanceof MapMessage)
            {
                MapMessage mapMessage = (MapMessage) message;
                Enumeration<String> itemNames = mapMessage.getPropertyNames();
                Map<String, Object> map = new HashMap<String, Object>();
                if (itemNames != null)
                {
                    while (itemNames.hasMoreElements())
                    {
                        String key = itemNames.nextElement();
                        map.put(key, mapMessage.getObjectProperty(key));
                    }
                }
                GooagooLog.debug("MQ接收Map信息:" + new Gson().toJson(map));
                this.process((T) map);
            }
            else if (message instanceof BytesMessage)
            {
                byte[] b = new byte[1024];
                BytesMessage msg = (BytesMessage) message;
                msg.readBytes(b);
                GooagooLog.debug("MQ接收byte[]长度:" + b.length);
                this.process((T) b);

            }
            else
            {
                if (message != null)
                {
                    GooagooLog.warn("接收对象类型不识别");
                }
                else
                {
                    GooagooLog.warn("接收信息为NULL");
                }
                this.process((T) message);
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("JMS接收信息发生异常", e);
        }

    }

    public abstract void process(T object);

}
