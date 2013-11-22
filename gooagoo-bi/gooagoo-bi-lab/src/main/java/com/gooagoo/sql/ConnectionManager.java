package com.gooagoo.sql;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionManager
{
    private static Logger log = Logger.getLogger("gooagoo_db");

    private static ConnectionManager instance;
    private Map<String, ComboPooledDataSource> dataSources = new HashMap<String, ComboPooledDataSource>();
    private static String c3p0Properties = "datasource";

    private ConnectionManager() throws Exception
    {
        ConnectionPoolConfig poolConfig = new ConnectionPoolConfig();
        ResourceBundle rb = ResourceBundle.getBundle(c3p0Properties);
        Enumeration<String> en = rb.getKeys();
        while (en.hasMoreElements())
        {
            String key = en.nextElement();
            String value = rb.getString(key);
            if (key.indexOf('.') == -1)
            {
                poolConfig.putPoolConfig(key, value);
            }
            else
            {
                poolConfig.putSources(key, value);
            }
        }
        Map<String, Source> sources = poolConfig.getSources();
        for (String key : sources.keySet())
        {
            Source source = sources.get(key);
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setUser(source.getUserName());
            dataSource.setPassword(source.getPassword());
            dataSource.setJdbcUrl(source.getUrl());
            dataSource.setDriverClass(poolConfig.getDriver());
            dataSource.setInitialPoolSize(poolConfig.getInitialPoolSize());
            dataSource.setMinPoolSize(poolConfig.getMinPoolSize());
            dataSource.setMaxPoolSize(poolConfig.getMaxPoolSize());
            dataSource.setMaxStatements(poolConfig.getMaxStatements());
            dataSource.setMaxIdleTime(poolConfig.getMaxIdleTime());
            dataSources.put(key, dataSource);
        }
    }

    public static synchronized final ConnectionManager getInstance()
    {
        if (instance == null)
        {
            try
            {
                instance = new ConnectionManager();
            }
            catch (Exception e)
            {
                log.error("getInstance", e);
            }
        }
        return instance;
    }

    public synchronized final Connection getConnection(String db)
    {
        try
        {
            return dataSources.get(db).getConnection();
        }
        catch (SQLException e)
        {
            log.error("无法取得数据库连接", e);
        }
        return null;
    }

    /**
     * 通过正则从sql中匹配数据库
     * @param sql
     * @return
     * @throws GooagooDbException
     */
    public String matching(String sql) throws GooagooDbException
    {
        String regEx = "\\S+\\.";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(sql);
        if (matcher.find())
        {
            return matcher.group().replace(".", "");
        }
        throw new GooagooDbException("sql无法匹配数据库");
    }
}
