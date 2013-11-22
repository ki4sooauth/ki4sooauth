package com.gooagoo.common.utils;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.ZooDefs.Ids;
import org.springframework.util.StringUtils;

import com.gooagoo.common.constants.ZookeeperConstants;
import com.gooagoo.common.enums.Audio;
import com.gooagoo.common.enums.ZKSerial;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.zookeeper.AbstractZooKeeper;

public final class SerialUtils
{
    /**
     * 生成优惠凭证音频号
     * @return
     */
    public static String createCouponSerial()
    {
        String name = TimeUtils.getCurrentDateTime("yyyyMM");
        if (StringUtils.hasText(name) && name.length() == 6)
        {
            return name + createSerialByName(ZKSerial.coupon, name, 8) + Audio.Coupon;
        }
        else
        {
            GooagooLog.warn("非法的参数" + name);
            return null;
        }
    }

    /**
     * 生成订单号
     * @return
     */
    public static String createOrderSerial()
    {
        String name = TimeUtils.getCurrentDateTime("yyyyMM");
        if (StringUtils.hasText(name) && name.length() == 6)
        {
            return name + createSerialByName(ZKSerial.order, name, 8) + Audio.Order;
        }
        else
        {
            GooagooLog.warn("非法的参数" + name);
            return null;
        }
    }

    /**
     * 生成用户序列号
     * @return
     */
    public static String createUserSerial()
    {
        return createSerialByName(ZKSerial.user, null, 8);
    }

    /**
     * 根据名称和指定位数生成自增长的16进制数字
     * @param name      根目录名称
     * @param name2     二级目录名称
     * @param length    长度
     * @return
     */
    private static String createSerialByName(ZKSerial name, String name2, int length)
    {
        try
        {
            AbstractZooKeeper zk = new AbstractZooKeeper("serial.zk.goo.com")
            {
                @Override
                public void processWatcher(WatchedEvent arg0)
                {
                }
            };
            String temp = ZookeeperConstants.SERIAL_PATH;
            if (zk.zooKeeper.exists(temp, false) == null)
            {
                zk.zooKeeper.create(temp, null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
            temp = ZookeeperConstants.SERIAL_PATH + "/" + name;
            if (zk.zooKeeper.exists(temp, false) == null)
            {
                zk.zooKeeper.create(temp, null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            }
            if (StringUtils.hasText(name2))
            {
                temp = ZookeeperConstants.SERIAL_PATH + "/" + name + "/" + name2;
                if (zk.zooKeeper.exists(temp, false) == null)
                {
                    zk.zooKeeper.create(temp, null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                }
            }
            String result = zk.zooKeeper.create(temp + "/0", null, Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT_SEQUENTIAL);
            zk.close();
            result = result.replaceAll(temp + "/0", "");
            return formatNum(result, length);
        }
        catch (Exception e)
        {
            GooagooLog.error("生成序列号异常" + name + "^" + name2, e);
            return null;
        }
    }

    /**
     * 把字符串转化成16进制的数字
     * @param temp  转化前的字符串
     * @param num   位数
     * @return
     */
    private static String formatNum(String temp, int length)
    {
        String lengthStr = "0000000000000000";
        Long original = Long.parseLong(temp);
        String hex = Long.toHexString(original);
        temp = lengthStr.substring(0, length - hex.length()) + hex;
        return temp.toUpperCase();
    }
}
