package com.gooagoo.common.monitor;

public class MonitorService
{
    private MonitorService(String name, String version)
    {
        MonitorThread thread = new MonitorThread(name, version);
        thread.start();
    }
}
