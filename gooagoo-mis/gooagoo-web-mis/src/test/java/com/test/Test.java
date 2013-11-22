package com.test;

import com.gooagoo.cache.PassportConfigCache;

public class Test
{

    public static void main(String[] args) throws InterruptedException
    {
        //ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
        //        //        PassportConfigCache.set("otherRedisWritePort", "444");
        //        CacheThread cacheThread = new CacheThread();
        //        cacheThread.run();
        Thread.sleep(1000);
        System.out.println(PassportConfigCache.get("otherRedisWritePort"));
    }
}
