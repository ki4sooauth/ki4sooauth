package com.test;

import com.gooagoo.batch.entry.BaseZkOperator;
import com.gooagoo.common.constants.ZookeeperConstants;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.DataUtils;

public class Read
{

    public static void main(String[] args)
    {
        try
        {
            BaseZkOperator zk = new BaseZkOperator();
            for (String string : ZookeeperConstants.getCacheVersionNode())
            {
                GooagooLog.info(string);
                byte[] bb = zk.zooKeeper.getData(string, false, null);
                Object object = DataUtils.unserialize(bb);
                GooagooLog.info(object);
            }
            zk.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
