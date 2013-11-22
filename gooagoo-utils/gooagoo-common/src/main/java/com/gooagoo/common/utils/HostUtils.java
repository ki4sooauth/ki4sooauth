package com.gooagoo.common.utils;

import java.net.InetAddress;

public class HostUtils
{
    private static InetAddress inetAddress = null;
    private static String hostAddress = null;
    private static String hostName = null;

    static
    {
        try
        {
            inetAddress = PubUtils.getLocalAddress();
            hostAddress = inetAddress.getHostAddress();
            hostName = inetAddress.getHostName();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static InetAddress getInetAddress()
    {
        return inetAddress;
    }

    public static String getHostAddress()
    {
        return hostAddress;
    }

    public static String getHostName()
    {
        return hostName;
    }

}
