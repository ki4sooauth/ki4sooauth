package com.gooagoo.common.monitor;

public class MonitorService
{
    private static boolean flag = false;//是否已经启动过，false-未启动

    private MonitorService(String name, String version)
    {
        if (!flag)
        {
            MonitorThread thread = new MonitorThread(name, version);
            thread.start();
            flag = true;
        }
    }
}
