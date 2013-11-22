package com.gooagoo.position.socket;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.Timer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.gooagoo.entity.position.Behavior;
import com.gooagoo.position.business.Buffer;
import com.gooagoo.position.constants.ConfigConstants;
import com.gooagoo.position.log.PositionEngineLog;
import com.gooagoo.position.task.BehaviorTask;
import com.gooagoo.position.task.CleanCacheTask;
import com.gooagoo.position.task.PositionTask;
import com.gooagoo.position.task.ScheduleTask;

public class Listener
{
    public static void main(String[] args)
    {
        PositionEngineLog.info("Position Listener start.............");

        //保存分析出待发送的用户行为
        ConcurrentLinkedQueue<Behavior> behaviorQueue = new ConcurrentLinkedQueue<Behavior>();

        Timer positionTimer = new Timer();
        PositionTask positionTask = new PositionTask(behaviorQueue);
        positionTimer.schedule(positionTask, 0, ConfigConstants.POSITION_TASK_FREQUENCY);

        Timer behaviorTimer = new Timer();
        BehaviorTask behaviorTask = new BehaviorTask(behaviorQueue);
        behaviorTimer.schedule(behaviorTask, 0, ConfigConstants.BEHAVIOR_TASK_FREQUENCY);

        Timer scheduleTimer = new Timer();
        ScheduleTask scheduleTask = new ScheduleTask(positionTask, behaviorTask, behaviorQueue);
        scheduleTimer.schedule(scheduleTask, 0, ConfigConstants.SCHEDULE_TASK_FREQUENCY);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 24);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Timer cacheTimer = new Timer();
        CleanCacheTask cacheTask = new CleanCacheTask();
        cacheTimer.scheduleAtFixedRate(cacheTask, calendar.getTime(), 24 * 60 * 60 * 1000);

        ServerSocket serverSocket = null;
        try
        {
            serverSocket = new ServerSocket(4700); //创建一个ServerSocket在端口4700监听客户请求
        }
        catch (Exception e)
        {
            PositionEngineLog.error("can not listen to:", e);
        }
        ExecutorService pool = Executors.newFixedThreadPool(50);
        try
        {
            while (true)
            {
                Socket socket = serverSocket.accept();//使用accept()阻塞等待客户请求，有客户请求到来则产生一个Socket对象，并继续执行
                Server server = new Server(socket);
                pool.execute(server);
                PositionEngineLog.debug("current buffer size:" + Buffer.count());
            }
        }
        catch (Exception e)
        {
            PositionEngineLog.error("error:", e);
        }
    }
}
