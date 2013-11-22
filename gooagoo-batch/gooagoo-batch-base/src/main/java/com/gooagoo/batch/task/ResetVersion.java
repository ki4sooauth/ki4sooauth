package com.gooagoo.batch.task;

import org.springframework.stereotype.Service;

import com.gooagoo.batch.entry.BaseZkOperator;
import com.gooagoo.common.constants.ZookeeperConstants;
import com.gooagoo.common.log.GooagooLog;

/**
 * 重置所有缓存信息的版本号
 * @author Administrator
 *
 */
@Service
public class ResetVersion
{
    public void run()
    {
        BaseZkOperator zk = new BaseZkOperator();
        try
        {
            for (String string : ZookeeperConstants.getCacheVersionNode())
            {
                zk.setData(string, "gooagoo");
            }
            GooagooLog.info("重置所有数据版本号成功");
        }
        catch (Exception e)
        {
            GooagooLog.error("重置所有数据版本号异常", e);
        }
        finally
        {
            if (zk != null)
            {
                zk.close();
            }
        }
    }
}
