package com.gooagoo.position.task;

import javax.jms.Message;
import javax.jms.MessageListener;

public class PositionListener implements MessageListener
{
    private static int count = 1;

    @Override
    public void onMessage(Message message)
    {
        System.out.println("message" + count + ":" + message.toString());
        count++;
    }
}
