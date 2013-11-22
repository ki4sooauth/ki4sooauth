package com.gooagoo.position.utils;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HessianBeanUtils
{
    private static ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "classpath*:hessian-query-generator-client.xml", "classpath*:hessian-query-business-client.xml", "classpath*:hessian-core-business-client.xml" });

    public static <T> T getBean(Class<T> clas)
    {
        return appContext.getBean(clas);
    }
}
