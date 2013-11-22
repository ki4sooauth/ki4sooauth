package com.gooagoo.common.monitor;

public class MonitorThread extends Thread
{
    private String name = "";
    private String version = "";

    public MonitorThread(String name, String version)
    {
        this.name = name;
        this.version = version;
    }

    @Override
    public void run()
    {
        MonitorUtils utils = new MonitorUtils(this.name, this.version);
        utils.monitorStart();
    }
}
