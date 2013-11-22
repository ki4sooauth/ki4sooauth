package com.gooagoo.position.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class SendMessageUtil
{
    private Connection connection = null;
    private Session session = null;

    /*public SendMessageUtil(String url, String user, String pwd)
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
            e.printStackTrace();
        }
    }*/

    public SendMessageUtil()
    {
        ResourceBundle bundle = ResourceBundle.getBundle("activeMQ");
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(bundle.getString("url"));
        connectionFactory.setUserName(bundle.getString("mquser"));
        connectionFactory.setPassword(bundle.getString("mqpwd"));
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

    public void sendTextMessage(String destinationName, String message)
    {
        MessageProducer producer = null;
        try
        {
            Destination destination = this.session.createQueue(destinationName);
            producer = this.session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            producer.send(this.session.createTextMessage(message));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (producer != null)
                {
                    producer.close();
                }
            }
            catch (JMSException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void sendObjectMessage(String destinationName, Serializable message)
    {
        MessageProducer producer = null;
        try
        {
            Destination destination = this.session.createQueue(destinationName);
            producer = this.session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.PERSISTENT);
            ObjectMessage objMessage = this.session.createObjectMessage();
            objMessage.setObject(message);
            producer.send(objMessage);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (producer != null)
                {
                    producer.close();
                }
            }
            catch (JMSException e)
            {
                e.printStackTrace();
            }
        }
    }

    public ObjectMessage getObjectMessage(String destinationName)
    {
        MessageConsumer consumer = null;
        ObjectMessage objmessage = null;
        try
        {
            Destination destination = this.session.createQueue(destinationName);
            consumer = this.session.createConsumer(destination);
            Message message = consumer.receive(1000);
            if (message instanceof ObjectMessage)
            {
                objmessage = (ObjectMessage) message;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (consumer != null)
                {
                    consumer.close();
                }
            }
            catch (JMSException e)
            {
                e.printStackTrace();
            }
        }
        return objmessage;
    }

    public TextMessage getTextMessage(String destinationName)
    {
        MessageConsumer consumer = null;
        TextMessage textmessage = null;
        try
        {
            Destination destination = this.session.createQueue(destinationName);
            consumer = this.session.createConsumer(destination);
            Message message = consumer.receive(1000);
            if (message instanceof TextMessage)
            {
                textmessage = (TextMessage) message;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (consumer != null)
                {
                    consumer.close();
                }
            }
            catch (JMSException e)
            {
                e.printStackTrace();
            }
        }
        return textmessage;
    }

    public List<TextMessage> getTextMessageList(String destinationName)
    {
        MessageConsumer consumer = null;
        List<TextMessage> messages = new ArrayList<TextMessage>();
        try
        {
            Destination destination = this.session.createQueue(destinationName);
            consumer = this.session.createConsumer(destination);
            Message message = null;
            TextMessage textmessage = null;
            do
            {
                message = null;
                message = consumer.receive(500);
                if (message != null && message instanceof TextMessage)
                {
                    textmessage = (TextMessage) message;
                    messages.add(textmessage);
                }
            }
            while (message != null);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (consumer != null)
                {
                    consumer.close();
                }
            }
            catch (JMSException e)
            {
                e.printStackTrace();
            }
        }
        return messages;
    }

    public List<ObjectMessage> getObjectMessageList(String destinationName)
    {
        MessageConsumer consumer = null;
        List<ObjectMessage> messages = new ArrayList<ObjectMessage>();
        try
        {
            Destination destination = this.session.createQueue(destinationName);
            consumer = this.session.createConsumer(destination);
            Message message = null;
            ObjectMessage objectMessage = null;
            do
            {
                message = null;
                message = consumer.receive(5000);
                if (message != null && message instanceof ObjectMessage)
                {
                    objectMessage = (ObjectMessage) message;
                    messages.add(objectMessage);
                }
            }
            while (message != null);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (consumer != null)
                {
                    consumer.close();
                }
            }
            catch (JMSException e)
            {
                e.printStackTrace();
            }
        }
        return messages;
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
}
