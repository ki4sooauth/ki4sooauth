package com.gooagoo.position.task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.entity.position.Behavior;
import com.gooagoo.position.business.PositionZip;
import com.gooagoo.position.constants.BehaviorConstants;
import com.gooagoo.position.utils.SendMessageUtil;

public class BehaviorTask extends TimerTask
{
    private ConcurrentLinkedQueue<Behavior> behaviorQueue = null;
    private SendMessageUtil smu = new SendMessageUtil();

    public BehaviorTask(ConcurrentLinkedQueue<Behavior> queue)
    {
        this.behaviorQueue = queue;
    }

    @Override
    public void run()
    {
        if (this.behaviorQueue != null && this.behaviorQueue.size() > 0)
        {
            List<Behavior> behaviors = new ArrayList<Behavior>();
            while (!this.behaviorQueue.isEmpty())
            {
                behaviors.add(this.behaviorQueue.remove());
            }
            this.sendMessage(behaviors);
        }
    }

    private void sendMessage(List<Behavior> behaviors)
    {
        try
        {
            GooagooMessage<String> message = new GooagooMessage<String>();
            message.setSource("4");
            message.setBehaveCode("002");
            //message.setBehaveType(behaveType)
            message.setFlag(true);
            message.setContent(PositionZip.fromBehavior(behaviors));

            this.smu.sendObjectMessage(BehaviorConstants.MQ_DESTINATION_POSITION, message);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
