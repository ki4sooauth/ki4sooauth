package com.gooagoo.batch.entry;

import org.apache.zookeeper.KeeperException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gooagoo.batch.BatchEntry;
import com.gooagoo.common.cipher.DesUtils;
import com.gooagoo.common.constants.ZookeeperConstants;
import com.gooagoo.common.log.GooagooLog;

public class BaseEntry
{

    @SuppressWarnings("unused")
    public static void main(String[] args)
    {
        try
        {
            //nohup java -jar batch-base.jar >> /usr/local/log/nohup.out &
            init();
            ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml", "hessian-query-generator-client.xml");
            if (args == null || args.length == 0)
            {
                DesUtils desUtils = new DesUtils("gooagoo_batch");
                //每天凌晨3点重置缓存版本号
                String str1 = desUtils.encrypt("resetVersion^run^0 0 3 * * ?^重置缓存版本号");
                //每隔一分钟检查数据库更新
                String str2 = desUtils.encrypt("loadDbTask^run^0 0/1 * * * ?^检查数据库更新");
                //每隔一个小时清除垃圾序列号
                String str3 = desUtils.encrypt("clearSerial^run^0 0 0/1 * * ?^清除垃圾序列号");
                args = new String[] { str1, str2, str3 };
            }
            BatchEntry.start(args);
        }
        catch (Exception e)
        {
            GooagooLog.error("任务启动异常", e);
        }
    }

    /**
     * 初始化节点（如果节点不存在，则创建该节点）
     * @throws KeeperException
     * @throws InterruptedException
     */
    private static void init() throws KeeperException, InterruptedException
    {
        BaseZkOperator zk = new BaseZkOperator();
        for (String string : ZookeeperConstants.getCacheAllNode())
        {
            if (zk.exists(string) == null)
            {
                zk.create(string, null);
                GooagooLog.info(string + "创建成功");
            }
            else
            {
                GooagooLog.info(string + "已经存在，不需要创建");
            }
        }
        zk.close();
    }
}
