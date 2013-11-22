package com.gooagoo.socket.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.mina.core.session.IoSession;

/**
 * IoSession缓存
 * @author zsl
 *
 */
public class IoSessionCache
{
    private static IoSessionCache sessionCache = null;
    private ConcurrentMap<String, IoSession> clientMap = null;

    private IoSessionCache()
    {

    }

    synchronized public static IoSessionCache getInstance()
    {
        if (sessionCache == null)
        {
            sessionCache = new IoSessionCache();
        }
        return sessionCache;
    }

    public ConcurrentMap<String, IoSession> getClientMap()
    {
        if (this.clientMap == null)
        {
            this.clientMap = new ConcurrentHashMap<String, IoSession>();
        }
        return this.clientMap;
    }

}
