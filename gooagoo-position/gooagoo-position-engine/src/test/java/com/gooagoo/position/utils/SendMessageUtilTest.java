package com.gooagoo.position.utils;

import java.util.List;

import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.position.constants.BehaviorConstants;

public class SendMessageUtilTest
{

    public static void main(String[] args) throws Exception
    {
        System.out.println("start..." + BehaviorConstants.MQ_DESTINATION_POSITION);
        SendMessageUtil smutil = new SendMessageUtil();
        for (int i = 1; i < 100; i++)
        {
            GooagooMessage<String> message = new GooagooMessage<String>();
            message.setSource("4");
            message.setBehaveCode("001");
            message.setFlag(true);
            message.setContent("hello world!" + i);
            smutil.sendObjectMessage(BehaviorConstants.MQ_DESTINATION_POSITION, message);
        }

        List<TextMessage> list = smutil.getTextMessageList(BehaviorConstants.MQ_DESTINATION_POSITION);
        System.out.println("total size:" + list.size());
        for (TextMessage obj : list)
        {
            System.out.println("message:" + obj.getText());
        }

        List<ObjectMessage> messages = smutil.getObjectMessageList(BehaviorConstants.MQ_DESTINATION_POSITION);
        System.out.println("total object size:" + messages.size());
        for (ObjectMessage message : messages)
        {
            GooagooMessage<String> obj = (GooagooMessage<String>) message.getObject();
            System.out.println("GooagooMessage:" + obj.getContent());
        }

        smutil.close();
        System.out.println("end..");
    }
}
