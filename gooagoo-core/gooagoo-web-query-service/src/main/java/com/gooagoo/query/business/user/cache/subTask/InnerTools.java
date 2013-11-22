package com.gooagoo.query.business.user.cache.subTask;

import java.util.Set;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import com.gooagoo.common.cipher.Md5Utils;
import com.gooagoo.entity.business.user.account.Account;
import com.google.gson.Gson;

public class InnerTools
{
    private static Cache cache;
    static
    {
        CacheManager manager = CacheManager.create();
        manager.addCache("queryCache");
        cache = manager.getCache("queryCache");
    }

    public static void putCache(String key, Set<Account> accounts)
    {
        Element element = new Element(key, accounts);
        cache.put(element);
    }

    public static Set<Account> getCache(String key)
    {
        Element element = cache.get(key);
        if (element != null)
        {
            return (Set<Account>) element.getValue();
        }
        else
        {
            return null;
        }
    }

    public static void putCache(Set<Account> accounts, Object... condition)
    {
        String key = entityMd5(condition);
        Element element = new Element(key, accounts);
        cache.put(element);
    }

    public static Set<Account> getCache(Object... condition)
    {
        String key = entityMd5(condition);
        Element element = cache.get(key);
        if (element != null)
        {
            return (Set<Account>) element.getValue();
        }
        return null;
    }

    //private static ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    /*public static <T> T getBean(Class<T> clas)
    {

        return appContext.getBean(clas);
    }*/

    /**
     * 判断字符串是否有值
     * @param str
     * @return
     */
    public static boolean hasText(String... str)
    {
        boolean value = true;
        if (str != null && str.length != 0)
        {
            for (String string : str)
            {
                if (string == null || "".equals(string))
                {
                    value = false;
                }
            }
        }
        else
        {
            value = false;
        }
        return value;
    }

    /*public static boolean isNotEmpty(Object object)
    {
        if (object == null)
        {
            return false;
        }
        Class<? extends Object> claz = object.getClass();
        Field[] fields = claz.getDeclaredFields();
        for (Field field : fields)
        {
            try
            {
                if (!Modifier.isFinal(field.getModifiers()))
                {
                    field.setAccessible(true); //让字段可访问 有没有get、set方法都行
                    if (field.get(object) != null)
                    {
                        return true;
                    }
                    field.setAccessible(false);
                }
            }
            catch (Exception e)
            {
                GooagooLog.debug(e.getMessage());//这个是debug级别的
            }
        }
        return false;
    }*/

    private static String entityMd5(Object... condition)
    {
        StringBuilder stringBuilder = new StringBuilder();
        Gson gson = new Gson();
        for (Object cond : condition)
        {
            stringBuilder.append(gson.toJson(cond));
        }
        Md5Utils md5 = new Md5Utils();
        return md5.encrypt(stringBuilder.toString());
    }
}
