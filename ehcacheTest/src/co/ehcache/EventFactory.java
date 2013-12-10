package co.ehcache;

import java.util.Properties;

import net.sf.ehcache.event.CacheEventListener;
import net.sf.ehcache.event.CacheEventListenerFactory;


public class EventFactory extends CacheEventListenerFactory  
{
	@Override
	public CacheEventListener createCacheEventListener(Properties properties)
	{
		// TODO Auto-generated method stub
		return new CacheEvent();
	}

}
