package com.gooagoo.test;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gooagoo.behave.gus.action.Count;

public class JmsReceive
{
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
        for (int i = 0; i < 3; i++)
        {
            ApplicationContext ctx = new ClassPathXmlApplicationContext("receive.xml");
        }

    }

}
