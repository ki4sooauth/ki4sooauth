package com.gooagoo.test;

import java.util.Timer;
import java.util.TimerTask;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.log4j.Logger;

import com.gooagoo.behave.gus.action.Count;

public class JmsReceive2
{

    private static String url = "tcp://192.168.3.214:61616";
    private static String user = "";
    private static String password = "";
    private static Logger logger = Logger.getLogger(JmsReceive2.class);
    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);

    public void ttt()
    {
        this.connectionFactory.getPrefetchPolicy().setQueuePrefetch(1000);
    }

    public void receiveMessage()
    {
        // 创建连接工厂  
        // 创建连接  
        Connection connection;
        try
        {
            connection = this.connectionFactory.createConnection();
            connection.start();
            // 创建Session  
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            // 创建目标，就创建主题也可以创建队列  
            Destination destination = session.createQueue("AAAAA");
            // 创建消息消费者  
            MessageConsumer consumer = session.createConsumer(destination);
            // 接收消息，参数：接收消息的超时时间，为0的话则不超时，receive返回下一个消息，但是超时了或者消费者被关闭，返回null  
            Message message = consumer.receive(10);
            //            System.out.println("<<>><<>>" + message);
            if (message instanceof TextMessage)
            {
                TextMessage textMessage = (TextMessage) message;
                String text = textMessage.getText();
                Count.add();
            }
            consumer.close();
            session.close();
            connection.close();
        }
        catch (JMSException e)
        {
            // TODO Auto-generated catch block  
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        Timer timer = new Timer();
        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                System.out.println(Count.getCount());
            }
        }, 1000, 1000);
        JmsReceive2 receiveMessageFromMQ = new JmsReceive2();
        receiveMessageFromMQ.ttt();
        receiveMessageFromMQ.receiveMessage();
        while (true)
        {
            receiveMessageFromMQ.receiveMessage();
        }
    }
}