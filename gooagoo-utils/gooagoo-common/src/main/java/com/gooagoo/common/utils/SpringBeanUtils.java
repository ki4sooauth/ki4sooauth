package com.gooagoo.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringBeanUtils implements ApplicationContextAware
{

    private static SpringBeanUtils instance = null;

    public static SpringBeanUtils getInstance()
    {
        if (instance == null)
        {
            instance = new SpringBeanUtils();
        }
        return instance;
    }

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext arg0) throws BeansException
    {
        SpringBeanUtils.applicationContext = arg0;
    }

    public ApplicationContext getApplicationContext()
    {
        return applicationContext;
    }

    public static Object getBean(String name) throws BeansException
    {
        return applicationContext.getBean(name);
    }

    /**
     * 
     * @param name
     * @param requiredType
     * @return
     * @throws BeansException
     */
    public static <T> T getBean(String name, Class<T> requiredType) throws BeansException
    {
        return applicationContext.getBean(name, requiredType);
    }
}