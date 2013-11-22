package com.gooagoo.entity.push;

import java.io.Serializable;

public class ServerInfo implements Serializable
{
    private static final long serialVersionUID = -6233518699648938807L;

    private String ip;//服务器IP
    private int port;//服务器端口号

    public String getIp()
    {
        return this.ip;
    }

    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public int getPort()
    {
        return this.port;
    }

    public void setPort(int port)
    {
        this.port = port;
    }

}
