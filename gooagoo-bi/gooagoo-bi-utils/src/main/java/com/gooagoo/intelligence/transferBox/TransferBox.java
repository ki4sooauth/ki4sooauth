package com.gooagoo.intelligence.transferBox;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TransferBox
{
    private ExecutorService pool = Executors.newFixedThreadPool(TransferConfig.pool);
    private TaskPool taskPool = TaskPool.getTaskPool();

    public void send(String address)
    {
        List<Drive> tasks = taskPool.getCustomers(address);
        if (tasks != null)
        {
            for (Drive transferCase : tasks)
            {
                pool.execute(transferCase);
            }
        }
    }

    public void close()
    {
        pool.shutdown();
    }

    public void await() throws InterruptedException
    {
        pool.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
    }
}
