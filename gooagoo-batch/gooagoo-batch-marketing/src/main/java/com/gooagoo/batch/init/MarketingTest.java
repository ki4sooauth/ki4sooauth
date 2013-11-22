package com.gooagoo.batch.init;

import java.util.List;

import org.apache.zookeeper.KeeperException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gooagoo.batch.BatchEntry;
import com.gooagoo.batch.zookeeper.BatchZkOperator;
import com.gooagoo.common.cipher.DesUtils;

public class MarketingTest
{
    private static BatchZkOperator zk = new BatchZkOperator();

    public static void main(String[] args)
    {
        try
        {
            //执行命令:"nohup java -jar batch-marketing.jar 3e1e8a0ecedf81475a744a225bc780c83e4e24893a9e0fba4056872ff9b1c75534fe6bb03a858c2dbdc22282de97909a 3e1e8a0ecedf814758379aebadb8d9a9dc48b7735f0c8a84e557e6f734074268e136c6cebf4a889a8b6118d1e3846c2c >> /usr/local/log/nohup.out &"

            //3e1e8a0ecedf81475a744a225bc780c83e4e24893a9e0fba4056872ff9b1c75534fe6bb03a858c2dbdc22282de97909a
            //3e1e8a0ecedf814758379aebadb8d9a9dc48b7735f0c8a84e557e6f734074268e136c6cebf4a889a8b6118d1e3846c2c
            ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
            DesUtils desUtils = new DesUtils("gooagoo_batch");
            System.out.println(desUtils.encrypt("testqqq^my^0/1 * * * * ?^定时任务一"));
            System.out.println(desUtils.encrypt("testqqq^myy^0/5 * * * * ?^定时任务二"));
            args = new String[] { desUtils.encrypt("testqqq^my^0/1 * * * * ?^定时任务一"), desUtils.encrypt("testqqq^myy^0/5 * * * * ?^定时任务二") };
            BatchEntry.start(args);
            //            ttt("/root/batch/task");
            //            ttt("/root/batch/task/testqqq-myy");
            //            zk.delete("/root/batch/task/testqqq-my/00000000051");
            //            zk.delete("/root/batch/task/定时任务一-testqqq");
            //            ttt("/root/batch/task/testqqq-my");
            //            zk.setData("/root/batch/task/testqqq-my/00000000055", "");
            //            zk.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void ttt(String src) throws KeeperException, InterruptedException
    {
        System.out.println(src + "的子目录有：");
        List<String> list = zk.getChild(src);
        for (String string : list)
        {
            System.out.println(string);
        }
    }
}
