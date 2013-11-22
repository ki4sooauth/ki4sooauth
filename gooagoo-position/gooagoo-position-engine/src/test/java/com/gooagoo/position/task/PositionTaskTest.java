package com.gooagoo.position.task;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.jms.ObjectMessage;

import junit.framework.TestCase;

import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.entity.position.Behavior;
import com.gooagoo.position.business.Buffer;
import com.gooagoo.position.constants.BehaviorConstants;
import com.gooagoo.position.entity.MacPosition;
import com.gooagoo.position.utils.SendMessageUtil;

public class PositionTaskTest extends TestCase
{
    public void testGetMessageFromMG()
    {
        SendMessageUtil smu = new SendMessageUtil();
        for (int i = 0; i < 100; i++)
        {
            GooagooMessage<String> obj = new GooagooMessage<String>();
            obj.setContent("message" + i);
            //smu.sendObjectMessage(BehaviorConstants.MQ_DESTINATION_POSITION, obj);
        }

        List<ObjectMessage> list = smu.getObjectMessageList(BehaviorConstants.MQ_DESTINATION_POSITION);
        System.out.println(BehaviorConstants.MQ_DESTINATION_POSITION + " total position message:" + list.size());
        try
        {
            for (ObjectMessage obj : list)
            {
                if (obj.getObject() instanceof GooagooMessage)
                {
                    GooagooMessage<String> gooagoo = (GooagooMessage<String>) obj.getObject();
                    if ("002" == gooagoo.getBehaveCode() || "002".equals(gooagoo.getBehaveCode()) || true)
                    {
                        System.out.println("behavior code:" + gooagoo.getBehaveCode() + ",content:" + gooagoo.getContent());
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        smu.close();

    }

    public void test()
    {
        System.out.println("Position info test start..............");

        /*ResourceBundle bundle = ResourceBundle.getBundle("activeMQ");
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(bundle.getString("url"));
        connectionFactory.setUserName(bundle.getString("mquser"));
        connectionFactory.setPassword(bundle.getString("mqpwd"));
        try
        {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(BehaviorConstants.MQ_DESTINATION_POSITION);
            MessageConsumer consumer = session.createConsumer(destination);
            //PositionListener posListener = new PositionListener();
            //consumer.setMessageListener(posListener);
            System.out.println(consumer.receive(2000));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }*/

        for (int i = 0; i < 1000; i++)
        {
            MacPosition macPosition = this.genMacPosition();
            Buffer.put(macPosition.getMac(), macPosition);
        }

        ConcurrentLinkedQueue<Behavior> behaviorQueue = new ConcurrentLinkedQueue<Behavior>();
        PositionTask task = new PositionTask(behaviorQueue);
        task.run();

        System.out.println("Position info test end..............");
    }

    private MacPosition genMacPosition()
    {
        MacPosition obj = new MacPosition();
        String mac = null;
        for (int i = 0; i < 6; i++)
        {
            if (i == 0)
            {
                mac = Integer.toHexString((int) (255 * Math.random()));
            }
            else
            {
                mac = ":" + Integer.toHexString((int) (255 * Math.random()));
            }
        }
        obj.setMac(mac);
        obj.setX((int) (1000 * Math.random()));
        obj.setY((int) (1000 * Math.random()));
        obj.setType('1');
        obj.setDevice("1C:8F:B6:8C:3E:0C");
        return obj;
    }
}
