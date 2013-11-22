package com.gooagoo.igms.cache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class GMSCache {
	private static Cache cache;
	static {
		CacheManager manager = CacheManager.create();
		manager.addCache("gmsCache");
		cache = manager.getCache("gmsCache");
	}

	public static void putCache(String key, Object object) {
		Element element = new Element(key, object);
		cache.put(element);
	}

	public static Object getCache(String key) {
		Element element = cache.get(key);
		if (element != null) {
			return element.getValue();
		}
		return null;
	}

}
