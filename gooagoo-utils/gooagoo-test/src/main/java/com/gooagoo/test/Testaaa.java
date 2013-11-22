package com.gooagoo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

import com.gooagoo.behave.gus.action.Count;
import com.gooagoo.common.jms.JmsUtils;

public class Testaaa extends Thread
{
    public static int numbers = 100000;
    public static int thread = 2;
    public static int sum = numbers * thread;
    public static List<Integer> list = new ArrayList<Integer>();

    @Override
    public void run()
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        JmsTemplate template = (JmsTemplate) ctx.getBean("logTemplate");
        ActiveMQQueue destination = (ActiveMQQueue) ctx.getBean("logdestination");
        String object = "sgfjdgjhajhkjahskdjhw348973895749857974904805riouteoirutilrjtklertjklrejtkl";
        for (int i = 0; i < numbers; i++)
        {
            Count.add();
            JmsUtils.send(template, destination, object);
        }
    }

    public static void main(String[] args)
    {
        System.out.println("任务总数为：" + sum);
        Timer timer = new Timer();
        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                int temp = Count.getCount();
                if (temp == Testaaa.sum)
                {
                    Testaaa.finished();
                }
                else
                {
                    Testaaa.list.add(temp);
                }
                System.out.println(Count.getCount());
            }
        }, 1000, 1000);
        for (int i = 0; i < thread; i++)
        {
            Testaaa testaaa = new Testaaa();
            testaaa.start();
        }
    }

    protected static void finished()
    {
        System.out.println("完成任务：" + numbers + "|" + thread + "|" + sum + "|" + list.size() + "|" + sum / list.size() + "|" + list);
    }
}
