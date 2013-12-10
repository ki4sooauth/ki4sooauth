package co.ehcache;

import junit.framework.TestCase;

public class EventListenerTest extends TestCase
{
	public void testEventListener()
	{
		String key = "person";
		Person person = new Person("lcl", 100);
		MyCacheManager.getInstance().put("Test", key, person);
		Person p = (Person) MyCacheManager.getInstance().get("Test", key);

		try
		{
			Thread.sleep(10000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertNull(MyCacheManager.getInstance().get("Test", key));
	}
}
