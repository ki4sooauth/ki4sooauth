package com.gooagoo.intelligence.transferBox;

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
    private static Map<String, List<Drive>> customers = new HashMap<String, List<Drive>>();

    static
    {
        init();
    }

    public static TaskPool getTaskPool()
    {
        return pool;
    }

    private static void init()
    {
        try
        {
            CustomerScanner scanner = new CustomerScanner();
            Set<Class<?>> classes = scanner.getPackageAllClasses(TransferConfig.basepackage, true);
            for (Class<?> clazz : classes)
            {
                Engine engine = clazz.getAnnotation(Engine.class);
                if (engine != null && Tyre.class.isAssignableFrom(clazz))
                {
                    Tyre tyre = (Tyre) clazz.newInstance();
                    Drive transferCase = new Drive(tyre);
                    putTask(engine.value(), transferCase);
                }
            }
        }
        catch (Exception e)
        {
            logger.ERROR("init task pool", e);
        }
    }

    private static void putTask(String[] keys, Drive task)
    {
        for (String key : keys)
        {
            List<Drive> tasks = customers.get(key);
            if (tasks != null)
            {
                tasks.add(task);
            }
            else
            {
                tasks = new ArrayList<Drive>();
                tasks.add(task);
                customers.put(key, tasks);
            }
        }

    }

    public List<Drive> getCustomers(String key)
    {
        return customers.get(key);
    }
}
