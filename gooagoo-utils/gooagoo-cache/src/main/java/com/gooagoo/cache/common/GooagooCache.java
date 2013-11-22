package com.gooagoo.cache.common;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import com.gooagoo.cache.thread.CacheThread;

@Service
public class GooagooCache implements InitializingBean
{

    @Override
    public void afterPropertiesSet() throws Exception
    {
        CacheThread cacheThread = new CacheThread();
        cacheThread.start();
    }
}
