package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gooagoo.cache.AreaCache;
import com.gooagoo.cache.EmailCache;
import com.gooagoo.cache.ExceptionCache;

public class Test
{

    @SuppressWarnings("unused")
    public static void main(String[] args) throws InterruptedException
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println(1);
        Thread.sleep(2000);
        System.out.println(AreaCache.getProvince());
        System.out.println(ExceptionCache.get("S005"));
        System.out.println(EmailCache.get("A"));
    }
}
