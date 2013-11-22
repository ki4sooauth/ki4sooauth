package com.gooagoo.api.business.query.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtils
{
    private static final ApplicationContext applicationContext;

    static
    {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    public static ApplicationContext getApplicationContext()
    {
        return applicationContext;
    }

    public static <T> T getBean(Class<T> clazz)
    {
        return applicationContext.getBean(clazz);
    }
}
