package com.gooagoo.intelligence.utils;

import java.io.Serializable;
import java.util.ResourceBundle;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.gooagoo.intelligence.common.log.GooagooLog;

public class MQUtil
{
    private Connection connection = null;
    private Session session = null;
    private String destinationName = null; //消息目的地

    public MQUtil(String url, String user, String pwd)
    {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        connectionFactory.setUserName(user);
        connectionFactory.setPassword(pwd);
        try
        {
            this.connection = connectionFactory.createConnection();
            this.connection.start();
            this.session = this.connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        }
        catch (Exception e)
        {
            GooagooLog.error("MQUtil", e);
        }
    }

    public MQUtil(String key)
    {
        ResourceBundle bundle = ResourceBundle.getBundle("activeMQ");
        String url = bundle.getString(key + ".url");
        String usr = bundle.getString(key + ".usr");
        String pwd = bundle.getString(key + ".pwd");
        destinationName = bundle.getString(key + ".des");

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
        connectionFactory.setUserName(usr);
        connectionFactory.setPassword(pwd);
        try
        {
            this.connection = connectionFactory.createConnection();
            this.connection.start();
            this.session = this.connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        }
        catch (Exception e)
        {
            GooagooLog.error("MQUtil", e);
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
            GooagooLog.error("sendTextMessage", e);
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
            GooagooLog.error("sendObjectMessage", e);
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
            GooagooLog.error("close", e);
        }
    }
}
