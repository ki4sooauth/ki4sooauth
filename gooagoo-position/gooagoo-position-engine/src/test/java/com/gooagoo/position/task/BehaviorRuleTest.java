package com.gooagoo.position.task;

import java.util.ArrayList;

import junit.framework.TestCase;

import com.gooagoo.position.constants.BehaviorConstants;
import com.gooagoo.position.constants.RedisConstants;
import com.gooagoo.position.entity.PositionCache;
import com.gooagoo.redis.data.RedisObjectDao;
import com.google.gson.Gson;

public class BehaviorRuleTest extends TestCase
{

    public void testBehaviorRule()
    {
    }

    public void getListByMac()
    {
        String mac = "test_mac_00_11";
        RedisObjectDao objDao = new RedisObjectDao(RedisConstants.business_behavior_anls);

        ArrayList<PositionCache> addList = new ArrayList<PositionCache>();
        for (int i = 0; i < 100; i++)
        {
            PositionCache obj = new PositionCache();
            obj.setMac(mac);
            obj.setPositionId("positon" + i);
            obj.setShopId("shopId");
            addList.add(obj);
        }

        objDao.set(BehaviorConstants.CACHE_PREFIX_POSITION_LIST + mac, addList);

        ArrayList<PositionCache> list = (ArrayList<PositionCache>) objDao.get(BehaviorConstants.CACHE_PREFIX_POSITION_LIST + mac);
        if (list != null)
        {
            Gson gson = new Gson();
            for (PositionCache pos : list)
            {
                System.out.println(gson.toJson(pos));
            }
        }
    }
}
