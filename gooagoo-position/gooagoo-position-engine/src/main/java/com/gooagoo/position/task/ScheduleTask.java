package com.gooagoo.position.task;

import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.gooagoo.entity.position.Behavior;
import com.gooagoo.position.business.Buffer;
import com.gooagoo.position.constants.ConfigConstants;

public class ScheduleTask extends TimerTask
{
    private PositionTask pt = null;
    private BehaviorTask bt = null;
    private ConcurrentLinkedQueue<Behavior> behaviorQueue = null;

    public ScheduleTask(PositionTask pt, BehaviorTask bt, ConcurrentLinkedQueue<Behavior> queue)
    {
        this.pt = pt;
        this.bt = bt;
        this.behaviorQueue = queue;
    }

    @Override
    public void run()
    {
        if (Buffer.count() > ConfigConstants.MAX_POSITIONS_SIZE)
        {
            this.pt.run();
        }

        if (this.behaviorQueue != null && this.behaviorQueue.size() > ConfigConstants.MAX_BEHAVIOR_SIZE)
        {
            this.bt.run();
        }
    }
}
