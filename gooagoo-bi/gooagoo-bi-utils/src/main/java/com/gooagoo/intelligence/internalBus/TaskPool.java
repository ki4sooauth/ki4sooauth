package com.gooagoo.intelligence.internalBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gooagoo.intelligence.common.log.GooagooLog;

public class TaskPool
{
    private static GooagooLog logger = new GooagooLog("framework");
    private static TaskPool pool = new TaskPool();
    private static Map<String, List<Customer>> customers = new HashMap<String, List<Customer>>();

    static
    {
        init();
    }

    private TaskPool()
    {

    }

    public static TaskPool getTaskPool()
    {
        return pool;
    }

    private static void init()
    {

        CustomerScanner scanner = new CustomerScanner();
        Set<Class<?>> classes = scanner.getPackageAllClasses(BusConfig.basepackage, true);
        logger.DEBUG("扫描到的任务：" + classes);
        for (Class<?> clazz : classes)
        {
            Message message = clazz.getAnnotation(Message.class);
            if (message != null && Customer.class.isAssignableFrom(clazz))
            {
                Customer customer;
                try
                {
                    customer = (Customer) clazz.newInstance();
                    putTask(message.value(), customer);
                }
                catch (Exception e)
                {
                    logger.ERROR("init task pool", e);
                }
            }
        }
        logger.DEBUG("初始化任务完闭");
    }

    private static void putTask(String[] keys, Customer task)
    {
        for (String key : keys)
        {
            List<Customer> tasks = customers.get(key);
            if (tasks != null)
            {
                tasks.add(task);
            }
            else
            {
                tasks = new ArrayList<Customer>();
                tasks.add(task);
                customers.put(key, tasks);
            }
        }

    }

    public List<Customer> getCustomers(String key)
    {
        return customers.get(key);
    }
}
