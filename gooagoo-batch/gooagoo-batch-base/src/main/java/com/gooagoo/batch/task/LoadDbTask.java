package com.gooagoo.batch.task;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.batch.entry.BaseZkOperator;
import com.gooagoo.batch.task.service.QueryVersionService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.DataUtils;
import com.gooagoo.common.utils.StringUtils;
import com.google.gson.Gson;

@Service
public class LoadDbTask
{
    @Autowired
    private QueryVersionService queryVersionService;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public void run()
    {
        BaseZkOperator zk = new BaseZkOperator();
        byte[] data;
        try
        {
            //读取所有文件的最后一次修改时间，再用md5加密
            Map<String, String> map = this.queryVersionService.getLatestVersion();
            for (Iterator iterator = map.entrySet().iterator(); iterator.hasNext();)
            {
                Entry<String, String> type = (Entry<String, String>) iterator.next();
                String version = zk.getVersion(type.getKey());
                //对于有变化的文件，统一加载数据到内存中，并修改版本号
                if (version == null || !version.equals(type.getValue()))
                {
                    GooagooLog.info(type.getKey() + "：版本不一致，需要重新加载最新数据，zookeeper版本=" + version + "，最新版本=" + type.getValue());
                    data = this.reloadData(type.getKey());
                    zk.setData(type.getKey(), type.getValue(), data);
                }
                else
                {
                    GooagooLog.debug(type.getKey() + "：版本一致，zookeeper版本=" + version + "，最新版本=" + type.getValue());
                }
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("检查数据库更新异常", e);
        }
        finally
        {
            if (zk != null)
            {
                zk.close();
            }
        }
    }

    private byte[] reloadData(String key) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException
    {
        GooagooLog.info("重新载入" + key);
        Method method = this.queryVersionService.getClass().getMethod("query" + StringUtils.upperFirstLetter(key));
        Object object = method.invoke(this.queryVersionService);
        GooagooLog.info(new Gson().toJson(object));
        return DataUtils.serialize(object);
    }
}
