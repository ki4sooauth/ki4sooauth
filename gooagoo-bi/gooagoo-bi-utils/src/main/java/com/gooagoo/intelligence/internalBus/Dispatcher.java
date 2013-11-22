package com.gooagoo.intelligence.internalBus;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.gooagoo.intelligence.common.log.GooagooLog;

public class Dispatcher
{
    private static GooagooLog logger = new GooagooLog("framework");
    private ExecutorService pool = Executors.newFixedThreadPool(BusConfig.pool);
    private TaskPool taskPool = TaskPool.getTaskPool();

    public void send(String address, Object message)
    {
        logger.DEBUG("发送……");
        List<Customer> tasks = taskPool.getCustomers(address);
        if (tasks != null)
        {
            for (Customer transferCase : tasks)
            {
                try
                {
                    Drive drive = new Drive(transferCase);
                    drive.setMessage(message);
                    pool.execute(drive);
                }
                catch (Exception e)
                {
                    logger.ERROR("启动任务失败:", e);
                }
            }
        }
    }

    public void close()
    {
        pool.shutdown();
    }

    /**
     * 阻塞 直到线程池中的任务全部运行完闭
     */
    public void await()
    {
        try
        {
            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        }
        catch (InterruptedException e)
        {
            logger.ERROR("Dispatcher await:", e);
        }
    }
}
