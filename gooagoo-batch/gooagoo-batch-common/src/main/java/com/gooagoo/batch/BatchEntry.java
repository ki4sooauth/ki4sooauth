package com.gooagoo.batch;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.data.Stat;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

import com.gooagoo.batch.zookeeper.BatchZkOperator;
import com.gooagoo.common.cipher.DesUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.DataUtils;
import com.gooagoo.common.utils.PubUtils;

/**
 * 注意事项：事先在客户端的hosts文件中写入zookeeper服务器的域名，能极大地减小连接时间
 * 约定
 * 1、任务名称全局唯一，任务实例和方法名称联合唯一，都放在任务字典表中统一管理。
 * 详细设计
 * 1、每个任务的客户端启动时，先向服务器注册，从服务器拿到临时分配的编号，如果此编号是最小的，则启动定时任务，否则待命。
 * 2、当监听到有变化时，所有客户端都检查下各自的任务编号，如果此编号是最小的，则启动定时任务，否则，终止当前任务。
 * @author Administrator
 *
 */
public final class BatchEntry
{
    public final static String ROOT_PATH = "/root/task";
    private static DesUtils desUtils = null;
    protected static BatchZkOperator zk = new BatchZkOperator("task.zk.goo.com");
    private static List<String[]> global_args = new ArrayList<String[]>();//执行任务所需的参数
    public static String ip = "";
    public static String alias = "";
    private static String[] static_args = null;

    static
    {
        try
        {
            desUtils = new DesUtils("gooagoo_batch");
        }
        catch (Exception e)
        {
            GooagooLog.error("初始化加密工具异常", e);
        }
        try
        {
            InetAddress address = PubUtils.getLocalAddress();
            ip = address.getHostAddress();
            GooagooLog.info("本服务器IP=" + ip);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取IP地址异常", e);
        }
        alias = DataUtils.getRandom(4);
        GooagooLog.info("本服务器别名=" + alias);
    }

    /**
     * 重连后检查任务，如任务消失，则重建
     */
    public static void checkJob()
    {
        try
        {
            if (zk.exists(GooagooJob.getFirstJobValue()) != null)
            {
                GooagooLog.info("【" + ip + ":" + alias + "】---任务节点存在，不需要重新创建");
            }
            else
            {
                GooagooLog.info("【" + ip + ":" + alias + "】---任务节点不存在，需要重新创建");
                initParameter();
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("【" + ip + ":" + alias + "】---重连后检查任务异常", e);
        }
    }

    /**
     * 定时任务监控
     * 向服务器注册
     * @param args
     */
    public static void start(String[] args)
    {
        try
        {
            static_args = args;
            initParameter();
            initTask();
        }
        catch (Exception e)
        {
            GooagooLog.error("【" + ip + ":" + alias + "】---初始化异常，系统终止运行", e);
            System.exit(0);
        }
    }

    private static void initParameter() throws Exception
    {
        global_args.clear();
        GooagooJob.clear();
        if (static_args == null || static_args.length == 0)
        {
            throw new Exception("【" + ip + ":" + alias + "】---没有要执行的任务");
        }
        createRoot();
        String[] job = null;
        String path;
        String cur;
        for (int i = 0; i < static_args.length; i++)
        {
            GooagooLog.debug(static_args[i]);
            job = decrypt(static_args[i]);//类名、方法名、定时表达式、任务名称
            GooagooLog.debug(job[0] + "^" + job[1] + "^" + job[2] + "^" + job[3]);
            global_args.add(job);
            path = job[0] + "-" + job[1];
            if (zk.exists(ROOT_PATH + "/" + path) == null)
            {
                zk.createPersistentPath(ROOT_PATH + "/" + path, "");
            }
            if (GooagooJob.getJob(ROOT_PATH + "/" + path) != null)
            {
                throw new Exception("【" + ip + ":" + alias + "】---重复的任务" + ROOT_PATH + "/" + path);
            }
            cur = zk.createEphemeralSequentialPath(ROOT_PATH + "/" + path + "/0", ip + "^" + alias + "^" + static_args[i]);
            zk.exists(cur);
            GooagooJob.addJob(ROOT_PATH + "/" + path, cur);
            List<String> list = zk.getChild(ROOT_PATH + "/" + path);
            if (cur.equals(ROOT_PATH + "/" + path + "/" + queryMinString(list)))
            {
                GooagooJob.add(ROOT_PATH + "/" + path, true);
                GooagooLog.info("【" + ip + ":" + alias + "】---启动主任务：" + cur);
            }
            else
            {
                GooagooJob.add(ROOT_PATH + "/" + path, false);
                GooagooLog.info("【" + ip + ":" + alias + "】---启动从任务：" + cur);
            }
        }
    }

    /**
     * 取出最小值
     * @param list
     * @return
     */
    private static String queryMinString(List<String> list)
    {
        Collections.sort(list);
        return list.get(0);
    }

    /**
     * 初始化任务
     * @throws Exception 
     */
    private static void initTask() throws Exception
    {
        Scheduler handsomeMan = new StdSchedulerFactory().getScheduler();
        JobDetail jobDetail;
        CronTrigger cronTrigger;
        String uuid;
        for (String[] temp : global_args)
        {
            uuid = UUID.randomUUID().toString().replaceAll("-", "");
            GooagooLog.info("【" + ip + ":" + alias + "】---初始化任务：" + temp[3] + "^" + temp[0] + "^" + temp[1] + "^" + temp[2]);
            jobDetail = new JobDetail(uuid + temp[3], uuid + temp[3], GooagooJob.class);
            cronTrigger = new CronTrigger(uuid + temp[0], uuid + temp[1], temp[2]);
            handsomeMan.scheduleJob(jobDetail, cronTrigger);
        }
        handsomeMan.start();
    }

    /**
     * 创建任务根目录
     * @throws InterruptedException 
     * @throws KeeperException 
     * @throws UnsupportedEncodingException 
     */
    private static void createRoot() throws KeeperException, InterruptedException, UnsupportedEncodingException
    {
        Stat stat;
        String str;
        List<String> list = split(ROOT_PATH);
        for (String string : list)
        {
            stat = zk.exists(string);
            if (stat == null)
            {
                str = zk.createPersistentPath(string, "");
                GooagooLog.info(str + "创建成功");
            }
            else
            {
                GooagooLog.info(string + "已经存在，不需要创建");
            }
        }
    }

    /**
     * 解密
     * @param string
     * @return
     * @throws Exception
     */
    private static String[] decrypt(String string) throws Exception
    {
        String str = desUtils.decrypt(string);
        return str.split("\\^");
    }

    /**
     * 拆分字符串
     * @param src
     * @return
     */
    private static List<String> split(String src)
    {
        List<String> list = new ArrayList<String>();
        String[] temp = src.split("/");
        String tt = "";
        for (String string : temp)
        {
            if (!string.equals(""))
            {
                tt += "/" + string;
                list.add(tt);
            }
        }
        return list;
    }
}
