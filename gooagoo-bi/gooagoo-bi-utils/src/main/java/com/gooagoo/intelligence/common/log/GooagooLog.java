package com.gooagoo.intelligence.common.log;

import org.apache.log4j.Logger;

public class GooagooLog
{
    //==================静态调用方法=================
    private static Logger staticlog = Logger.getLogger("gooagoo");

    public static synchronized void error(Object message, Throwable e)
    {
        staticlog.error(message, e);
    }

    public static synchronized void warn(Object message)
    {
        staticlog.warn(message);
    }

    public static synchronized void info(Object message)
    {
        staticlog.info(message);
    }

    public static synchronized void debug(Object message)
    {
        staticlog.debug(message);
    }

    //==================实例化调用方法=================
    /**
     * 使用实例化调用方法可以传入自定义的log
     */
    private Logger logger = null;

    public GooagooLog(String logName)
    {
        logger = Logger.getLogger(logName);
    }

    public void ERROR(Object message, Throwable e)
    {
        logger.error(message, e);
    }

    public void WARN(Object message)
    {
        logger.warn(message);
    }

    public void INFO(Object message)
    {
        logger.info(message);
    }

    public void DEBUG(Object message)
    {
        logger.debug(message);
    }
}
