package com.gooagoo.redis.entity;

import java.io.Serializable;

public class RedisConfig implements Serializable
{
    private static final long serialVersionUID = 2117941788583106657L;

    private String id;
    private String server;
    private String port;
    private String database;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getServer()
    {
        return server;
    }

    public void setServer(String server)
    {
        this.server = server;
    }

    public Integer getPort()
    {
        return Integer.valueOf(port);
    }

    public void setPort(String port)
    {
        this.port = port;
    }

    public Integer getDatabase()
    {
        return Integer.valueOf(database);
    }

    public void setDatabase(String database)
    {
        this.database = database;
    }

}