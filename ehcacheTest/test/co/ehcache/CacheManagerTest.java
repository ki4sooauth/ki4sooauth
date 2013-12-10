package co.ehcache;

import java.io.Serializable;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import junit.framework.TestCase;

public class CacheManagerTest extends TestCase
{
	public void testGetCacheNames()
	{
		String[] cacheNames = CacheManager.getInstance().getCacheNames();
		assertTrue(cacheNames.length > 0);
	}

	public void testCreateInstance()
	{
		CacheManager manager1 = new CacheManager("src/ehcache1.xml");
		CacheManager manager2 = new CacheManager();
		String[] cacheNamesForManager1 = manager1.getCacheNames();
		assertTrue(cacheNamesForManager1.length > 0);
		for (int i = 0; i < cacheNamesForManager1.length; i++)
			Log.debug("cacheNamesForManager1[" + i + "] = " + cacheNamesForManager1[i]);
		String[] cacheNamesForManager2 = manager2.getCacheNames();
		assertTrue(cacheNamesForManager2.length > 0);
		for (int i = 0; i < cacheNamesForManager2.length; i++)
			Log.debug("cacheNamesForManager2[" + i + "] = " + cacheNamesForManager2[i]);
	}

	public void testCreatCacheByProgram()
	{
		CacheManager singletonManager = CacheManager.create();
		Cache memoryOnlyCache = new Cache("testCache", 5000, false, false, 5, 2);
		singletonManager.addCache(memoryOnlyCache);
		Cache testCache = singletonManager.getCache("testCache");
		assertNotNull(testCache);
		Person person = new Person("myname", 30);
		testCache.put(new Element("key1", person));
		Person p = (Person) testCache.get("key1").getValue();
		assertSame(person, p);
	}

	public void testCRUD()
	{
		String cacheName = "sampleCache1";
		CacheManager manager = new CacheManager("src/ehcache1.xml");
		Cache cache = manager.getCache(cacheName);
		// Put an element into a cache
		Element element = new Element("key1", "value1");
		cache.put(element);
		// This updates the entry for "key1"
		cache.put(new Element("key1", "value2"));
		// Get a Serializable value from an element in a cache with a key of "key1".
		element = cache.get("key1");
		Serializable value = element.getValue();
		// Get a NonSerializable value from an element in a cache with a key of "key1".
		element = cache.get("key1");
		assertNotNull(element);
		Object valueObj = element.getObjectValue();
		assertNotNull(valueObj);
		// Remove an element from a cache with a key of "key1".
		assertNotNull(cache.get("key1"));
		cache.remove("key1");
		assertNull(cache.get("key1"));
	}

	public void testDiskPersistence()
	{
		String cacheName = "sampleCache1";
		CacheManager manager = new CacheManager("src/ehcache1.xml");
		Cache cache = manager.getCache(cacheName);
		for (int i = 0; i < 5; i++)
		{
			Element element = new Element("key" + i, "myvalue" + i);
			cache.put(element);
		}
		cache.flush();
		Log.debug("java.io.tmpdir = " + System.getProperty("java.io.tmpdir"));
	}
}
