package co.ehcache;

import org.apache.log4j.Logger;

/**
 * 
 * @author lichun
 * @date Feb 28, 2008
 * @see
 */
public class Log
{
	static Logger logger = Logger.getRootLogger();

	public static void debug(Object message)
	{
		logger.debug(message);
	}

	public static void info(Object message)
	{
		logger.info(message);
	}

	public static void warn(Object message)
	{
		logger.warn(message);
	}

	public static void warn(Object message, Exception exception)
	{
		logger.warn(message, exception);
	}

	public static void error(Object message)
	{
		logger.error(message);
	}

	public static void error(Object message, Exception exception)
	{
		logger.error(message, exception);
	}

	public static void fatal(Object message)
	{
		logger.fatal(message);
	}

	public static void fatal(Object message, Exception exception)
	{
		logger.fatal(message, exception);
	}

	public static boolean isDebugEnabled()
	{
		return logger.isDebugEnabled();
	}

	public static boolean isInfoEnabled()
	{
		return logger.isInfoEnabled();
	}
}
