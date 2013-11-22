package com.gooagoo.sql;

import java.util.HashMap;
import java.util.Map;

public class ConnectionPoolConfig
{
    private Map<String, String> configs = new HashMap<String, String>();
    private Map<String, Source> sources = new HashMap<String, Source>();

    public void putSources(String properties, String value)
    {
        String[] keys = properties.split("\\.");
        String database = keys[0];
        String key = keys[1];
        Source source = sources.get(database);
        if (source == null)
        {
            source = new Source();
        }
        if ("url".equals(key))
        {
            source.setUrl(value);
        }
        else if ("username".equals(key))
        {
            source.setUserName(value);
        }
        else if ("password".equals(key))
        {
            source.setPassword(value);
        }
        sources.put(database, source);
    }

    public String getDriver()
    {
        return configs.get("driverClass");
    }

    public int getInitialPoolSize()
    {
        try
        {
            return Integer.valueOf(configs.get("initialPoolSize"));
        }
        catch (Exception e)
        {
            return 2;
        }
    }

    public int getMinPoolSize()
    {
        try
        {
            return Integer.valueOf(configs.get("minPoolSize"));
        }
        catch (Exception e)
        {
            return 1;
        }
    }

    public int getMaxPoolSize()
    {
        try
        {
            return Integer.valueOf(configs.get("maxPoolSize"));
        }
        catch (Exception e)
        {
            return 10;
        }
    }

    public int getMaxStatements()
    {
        try
        {
            return Integer.valueOf(configs.get("maxStatements"));
        }
        catch (Exception e)
        {
            return 50;
        }
    }

    public int getMaxIdleTime()
    {
        try
        {
            return Integer.valueOf(configs.get("maxIdleTime"));
        }
        catch (Exception e)
        {
            return 60;
        }
    }

    public void putPoolConfig(String key, String value)
    {
        configs.put(key, value);
    }

    public Map<String, Source> getSources()
    {
        return sources;
    }

    public void setSources(Map<String, Source> sources)
    {
        this.sources = sources;
    }
}
