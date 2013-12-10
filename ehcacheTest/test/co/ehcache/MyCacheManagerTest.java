package co.ehcache;

import junit.framework.TestCase;

public class MyCacheManagerTest extends TestCase
{
	public static final String CACHE_NAME = "Test";

	public void testGetInstance()
	{
		MyCacheManager cacheManager1 = MyCacheManager.getInstance();
		assertNotNull(cacheManager1);
		MyCacheManager cacheManager2 = MyCacheManager.getInstance();
		assertNotNull(cacheManager2);
		assertSame(cacheManager1, cacheManager2);		
	}
	
	public void testPutGet()
	{
        String key20 = "person20";
        String key30 = "person30";
        Person person20 = new Person("person20", 20);
        Person person30 = new Person("person30", 30);
        MyCacheManager.getInstance().put(CACHE_NAME, key20, person20);
        MyCacheManager.getInstance().put(CACHE_NAME, key30, person30);
        Person p20 = (Person)MyCacheManager.getInstance().get("Test", key20);
        Person p30 = (Person)MyCacheManager.getInstance().get("Test", key30);
        log(p20); 
        assertSame(person20, p20);
        assertSame(person30, p30);
//        log(System.getProperty("java.io.tmpdir"));        
	}
	
	private void log(Object obj)
	{
		System.out.println(obj);
	}
}
