package co.ehcache;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.management.ManagementService;
import junit.framework.TestCase;

public class CacheTest extends TestCase
{
	public void testCachesizes()
	{
		long count = 5;
		String cacheName = "sampleCache1";
		CacheManager manager = new CacheManager("src/ehcache1.xml");
		Cache cache = manager.getCache(cacheName);
		for (int i = 0; i < count; i++)
		{
			Element element = new Element("key" + i, "myvalue" + i);
			cache.put(element);
		}
		//Get the number of elements currently in the Cache.
		int elementsInCache = cache.getSize();
		assertTrue(elementsInCache == 5);
		//Cache cache = manager.getCache("sampleCache1");
		long elementsInMemory = cache.getMemoryStoreSize();
		//Get the number of elements currently in the DiskStore.
		long elementsInDiskStore = cache.getDiskStoreSize();
		assertTrue(elementsInMemory + elementsInDiskStore == count);	
	}
	
	public void testHitsAndMisses()
	{
//		//Get the number of times requested items were found in the cache. i.e. cache hits
//		CacheManager manager = new CacheManager("src/ehcache1.xml");
//		Cache cache = manager.getCache("sampleCache1");
//		int hits = cache.getHitCount();
//		//Get the number of times requested items were found in the MemoryStore of the cache.
//		hits = cache.getMemoryStoreHitCount();
//		//Get the number of times requested items were found in the DiskStore of the cache.
//		hits = cache.getDiskStoreCount();
//		//Get the number of times requested items were not found in the cache. i.e. cache misses.
//		Cache cache = manager.getCache("sampleCache1");
//		hits = cache.getMissCountNotFound();
//		//Get the number of times requested items were not found in the cache due to expiry of the elements.
//		Cache cache = manager.getCache("sampleCache1");
//		hits = cache.getMissCountExpired();
	}
	
	public void testMBServer()
	{		
//		long count = 5;
//		String cacheName = "sampleCache1";
//		CacheManager manager = new CacheManager("src/ehcache1.xml");
//		Cache cache = manager.getCache(cacheName);
//		
//		MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
//		ManagementService.registerMBeans(manager, mBeanServer, false, false, false, true);
//		
//		for (int i = 0; i < count; i++)
//		{
//			Element element = new Element("key" + i, "myvalue" + i);
//			cache.put(element);
//		}
//		while(true)
//		{
//			sleep(10);
//		}
	}
	
	private void sleep(long m)
	{
		try
		{
			Thread.sleep(m);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
