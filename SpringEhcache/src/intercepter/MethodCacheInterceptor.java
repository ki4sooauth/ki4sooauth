package intercepter;

import java.io.Serializable;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.InitializingBean;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

public class MethodCacheInterceptor implements MethodInterceptor, InitializingBean{
	private Cache cache;

	public void setCache(Cache cache) {
		this.cache = cache;
	}
	
	public Object invoke(MethodInvocation invocation) throws Throwable {
		String targetName = invocation.getThis().getClass().getName();
		String methodName = invocation.getMethod().getName();
		Object[] arguments = invocation.getArguments();
		Object result;

		String cacheKey = getCacheKey(targetName, methodName, arguments);
		Element element = cache.get(cacheKey);
		if (element == null) {
			// call target/sub-interceptor
			result = invocation.proceed();
			System.out.println("set into cache");
			// cache method result
			element = new Element(cacheKey, (Serializable) result);
			cache.put(element);
		}
		System.out.println("out cache");
		return element.getValue();
	}

	
	private String getCacheKey(String targetName, String methodName,
			Object[] arguments) {
		StringBuffer sb = new StringBuffer();
		sb.append(targetName).append(".").append(methodName);
		if ((arguments != null) && (arguments.length != 0)) {
			for (int i = 0; i < arguments.length; i++) {
				sb.append(".").append(arguments[i]);
			}
		}

		return sb.toString();
	}

	public void afterPropertiesSet() throws Exception {
		if(null == cache) {
			throw new IllegalArgumentException("Cache should not be null.");
		}
	}

}
