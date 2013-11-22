package com.gooagoo.position.business;

import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import com.gooagoo.position.constants.RedisConstants;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisHashDao;

public class AreaCacheTest extends TestCase
{
    AreaCache cache = new AreaCache();

    public void testGridCoordinateInfo()
    {
        Map<String, String> result = this.cache.gridCoordinateInfo("1847TT7KBON6VB2G8PELGLDJF158KQM2", -10, -1);
        System.out.println("value:" + result);
        RedisDatabase db = new RedisDatabase(RedisConstants.business_grid);
        RedisHashDao dao = new RedisHashDao(RedisConstants.business_grid);
        Set<String> keys = db.keys("*");
        System.out.println("key size:" + keys.size());
        for (String key : keys)
        {
            System.out.println(key + "|" + dao.get(key));
            break;
        }
    }

    public void testAllGridCoordinateInfo()
    {
        RedisDatabase db = new RedisDatabase(RedisConstants.business_grid);
        RedisHashDao dao = new RedisHashDao(RedisConstants.business_grid);
        Set<String> keys = db.keys("188JP4GQKAG3IQ00A1BAQJMEMAV85UM0*");
        System.out.println("key size:" + keys.size());
        for (String key : keys)
        {
            System.out.println(key + "|" + dao.get(key));
        }
    }

    public void testMapInfo()
    {
        /*RedisStringDao dao = new RedisStringDao(RedisConstants.business_map);
        RedisDatabase db = new RedisDatabase(RedisConstants.business_map);
        Set<String> keys = db.keys("2*");
        System.out.println("key size:" + keys.size());
        for (String key : keys)
        {
            System.out.println(key + "|" + dao.get(key));
        }*/

        Map<String, String> map = this.cache.mapInfo("188JP4GQKAG3IQ00A1BAQJMEMAV85UM0");
        System.out.println(map);
    }

    public void testGetMapId()
    {
        String mapId = this.cache.getMapId("1000000a", '0');
        System.out.println("MapID:" + mapId);

        mapId = this.cache.getMapId("01822R97QK2FRDT085QBV2EIISWR0JGT", '1');
        System.out.println("MapID:" + mapId);
    }

    public void removeCache()
    {
        RedisHashDao dao = new RedisHashDao(RedisConstants.business_map);
        RedisDatabase db = new RedisDatabase(RedisConstants.business_map);
        Set<String> keys = db.keys("M_188JP4GQKAG3IQ00A1BAQJMEMAV85UM0");
        System.out.println("key size:" + keys.size());
        for (String key : keys)
        {
            System.out.println(key + "|" + dao.get(key));
            db.del(key);
        }
    }
}
