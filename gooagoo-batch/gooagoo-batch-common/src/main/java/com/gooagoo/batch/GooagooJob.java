package com.gooagoo.batch;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.SpringBeanUtils;

public class GooagooJob implements Job
{
    //任务目录路径、任务全路径、是否在本地执行三者的映射关系
    private static Map<String, Boolean> map = new HashMap<String, Boolean>();//任务目录路径、是否在本地执行
    private static Map<String, String> job = new HashMap<String, String>();//任务目录路径、任务全路径
    public static boolean isConnected = false;//是否连上zookeeper服务器

    public static void clear()
    {
        map.clear();
        job.clear();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static String getFirstJobValue()
    {
        for (Iterator iterator = job.entrySet().iterator(); iterator.hasNext();)
        {
            Entry<String, String> type = (Entry<String, String>) iterator.next();
            return type.getValue();
        }
        return null;
    }

    public static void add(String src, Boolean flag)
    {
        map.put(src, flag);
    }

    public static void addJob(String src, String path)
    {
        job.put(src, path);
    }

    public static String getJob(String key)
    {
        return job.get(key);
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException
    {
        String jobName = null;
        try
        {
            jobName = context.getJobDetail().getName().substring(32);
            if (!isConnected)
            {
                GooagooLog.warn("【" + BatchEntry.ip + ":" + BatchEntry.alias + "】---未连上zookeeper服务器，任务【" + jobName + "】不予执行");
                return;
            }
            String beanName = context.getTrigger().getName().substring(32);
            String methodName = context.getTrigger().getGroup().substring(32);
            if (map.get(BatchEntry.ROOT_PATH + "/" + beanName + "-" + methodName))
            {
                GooagooLog.info("【" + BatchEntry.ip + ":" + BatchEntry.alias + "】---开始执行任务：" + jobName);
                Object bean = SpringBeanUtils.getBean(beanName);
                Method method = bean.getClass().getMethod(methodName);
                method.invoke(bean);
            }
            else
            {
                GooagooLog.info("【" + BatchEntry.ip + ":" + BatchEntry.alias + "】---已有别的服务器在执行任务：" + jobName);
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("【" + BatchEntry.ip + ":" + BatchEntry.alias + "】---执行任务异常：" + jobName, e);
        }
    }
}
