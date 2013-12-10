package co.ehcache;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import net.sf.ehcache.Status;
import net.sf.ehcache.event.CacheEventListener;

public class CacheEvent implements CacheEventListener  
{

	public void dispose()
	{
		log("in dispose");
	}

	public void notifyElementEvicted(Ehcache cache, Element element)
	{
		// TODO Auto-generated method stub
		log("in notifyElementEvicted" + element);
	}

	public void notifyElementExpired(Ehcache cache, Element element)
	{
		// TODO Auto-generated method stub
		log("in notifyElementExpired" + element);
	}

	public void notifyElementPut(Ehcache cache, Element element) throws CacheException
	{
		// TODO Auto-generated method stub
		log("in notifyElementPut" + element);
	}

	public void notifyElementRemoved(Ehcache cache, Element element) throws CacheException
	{
		// TODO Auto-generated method stub
		log("in notifyElementRemoved" + element);
	}

	public void notifyElementUpdated(Ehcache cache, Element element) throws CacheException
	{
		// TODO Auto-generated method stub
		log("in notifyElementUpdated" + element);
	}

	public void notifyRemoveAll(Ehcache cache)
	{
		// TODO Auto-generated method stub
		log("in notifyRemoveAll");
	}
	
    public Object clone() throws CloneNotSupportedException 
    {
        return super.clone();
    }	
    
    private void log(String s)
    {
    	Log.debug(s);
    }
}
