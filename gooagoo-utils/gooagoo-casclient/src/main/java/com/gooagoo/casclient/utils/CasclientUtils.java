package com.gooagoo.casclient.utils;

import org.apache.zookeeper.WatchedEvent;

import com.gooagoo.casclient.constants.ZookeeperConstants;
import com.gooagoo.casclient.log.CasLog;
import com.gooagoo.casclient.zookeeper.AbstractZooKeeper;

public class CasclientUtils
{

    private static String BASE_HOST = "";//基础域名

    private static String PERSONAL_LOGIN_URL = "";

    private static String SHOP_LOGIN_URL = "";

    private static String MIS_LOGIN_URL = "";

    static
    {
        AbstractZooKeeper keeper = null;
        try
        {
            keeper = new AbstractZooKeeper()
            {
                @Override
                public void processWatcher(WatchedEvent arg0)
                {
                }
            };
            byte[] aa = keeper.zooKeeper.getData(ZookeeperConstants.DOMAIN_PATH, false, null);
            BASE_HOST = new String(aa, AbstractZooKeeper.CHARACTER_SET_ENCODING);
            PERSONAL_LOGIN_URL = "http://passport." + BASE_HOST + "/userLogin";
            SHOP_LOGIN_URL = "http://passport." + BASE_HOST + "/shopLogin";
            MIS_LOGIN_URL = "http://passport." + BASE_HOST + "/misLogin";
            CasLog.info("基础域名=" + BASE_HOST);
        }
        catch (Exception e)
        {
            BASE_HOST = "";
            CasLog.error("读取基础域名异常", e);
        }
        finally
        {
            if (keeper != null)
            {
                keeper.close();
            }
        }
    }

    public static String getPersonalLoginUrl()
    {
        return PERSONAL_LOGIN_URL;
    }

    public static String getShopLoginUrl()
    {
        return SHOP_LOGIN_URL;
    }

    public static String getMisLoginUrl()
    {
        return MIS_LOGIN_URL;
    }

}
