/*
 * Created on Jan 28, 2008
 * 
 * TODO To change the template for this generated file go to Window - Preferences - Java - Code Style - Code Templates
 */
package co.ehcache;

import java.io.Serializable;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheException;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * @author lichun
 * 
 * TODO To change the template for this generated type comment go to Window - Preferences - Java - Code Style - Code
 * Templates
 */
public class MyCacheManager
{
    private static MyCacheManager myCacheManager = null;

    private static CacheManager cacheManager = null;
    
    private MyCacheManager()
    {
        try
        {
            if (cacheManager == null)
                cacheManager = CacheManager.getInstance();
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }
    };

    public synchronized static MyCacheManager getInstance()
    {
    	if(myCacheManager == null)
    		myCacheManager = new MyCacheManager();
    	
        return myCacheManager;
    }

    public void put(String cacheName, Serializable key, Serializable value)
    {
        Cache cache = cacheManager.getCache(cacheName);
        Element element = new Element(key, value);
        cache.put(element);

    }

    public Serializable get(String cacheName, Serializable key) throws CacheException
    {
        Cache cache = cacheManager.getCache(cacheName);
        Element element = cache.get(key);
        if (element == null)
            return null;
        return element.getValue();
    }
    
    public void shutdown()
    {
    	cacheManager.shutdown();
    }
    
}

