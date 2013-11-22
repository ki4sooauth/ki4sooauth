package com.gooagoo.current.utils;

import java.io.Serializable;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.business.log.ShopLog;
import com.gooagoo.entity.message.GooagooMessage;

//http://192.168.3.214:8161/admin/queues.jsp
public class SendMessageUtil
{
    private Connection connection = null;
    private Session session = null;

    public static final String url = "tcp://realcount.queue.goo.com:61616";
    public static final String mquser = "system";
    public static final String mqpwd = "manager";
    public static final String destinationName = "RealCountQueueTest";

    public SendMessageUtil()
    {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        connectionFactory.setUserName(mquser);
        connectionFactory.setPassword(mqpwd);
        try
        {
            this.connection = connectionFactory.createConnection();
            this.connection.start();
            this.session = this.connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void sendTextMessage(String message)
    {
        try
        {
            Destination destination = this.session.createQueue(destinationName);
            MessageProducer producer = this.session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            producer.send(this.session.createTextMessage(message));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void sendObjectMessage(Serializable message)
    {
        try
        {
            Destination destination = this.session.createQueue(destinationName);
            MessageProducer producer = this.session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            ObjectMessage objMessage = this.session.createObjectMessage();
            objMessage.setObject(message);
            producer.send(objMessage);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void close()
    {
        try
        {
            this.session.close();
            this.connection.close();
        }
        catch (JMSException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        bill();
    }

    public static void bill()
    {
        SendMessageUtil sendMessageUtil = new SendMessageUtil();

        GooagooMessage<ShopLog> message = new GooagooMessage<ShopLog>();
        message.setSource("4");
        ShopLog shopLog = new ShopLog();
        shopLog.setRemoteCode("gtsc05");
        shopLog.setOperateResult("Y");
        shopLog.setObjectCode("02017Q3Ee198TUUV50000HFYOBYE123F");
        message.setContent(shopLog);
        sendMessageUtil.sendObjectMessage(message);
        sendMessageUtil.close();
    }

    public static void behavelog()
    {
        SendMessageUtil sendMessageUtil = new SendMessageUtil();
        GooagooMessage<BehaveLog> message = new GooagooMessage<BehaveLog>();
        message.setSource("3");//消息来源
        message.setBehaveCode("gusm02");//调用的接口编码（位置引擎中表示定位（001）与行为（002）的识别标志）
        message.setBehaveType("9");//行为类型（特指用户行为类型，商家及管理员暂无）
        message.setFlag(true);//操作结果，true-成功，false-失败

        BehaveLog behaveLog = new BehaveLog();
        behaveLog.setOperateResult("Y");
        behaveLog.setBehaveType("9");
        behaveLog.setShopId("01822IE57DH111M085QBPFEIISWR0JGT");
        behaveLog.setObjectValue("183JO6FN69TLH32G8PELDKNPHI5CSCUF"); //这个就随便生成了一个
        behaveLog.setUserId("01822N0IJLPA8N700C5V4PBJ43P1R5JO");
        behaveLog.setSource("W");
        behaveLog.setObjectSource("018237FSEHNVTOI005B2D4J4VOR9U6KK");
        message.setContent(behaveLog);//消息内容

        sendMessageUtil.sendObjectMessage(message);
        sendMessageUtil.close();
    }
}
