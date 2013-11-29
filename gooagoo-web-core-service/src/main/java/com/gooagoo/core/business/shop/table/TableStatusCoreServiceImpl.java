package com.gooagoo.core.business.shop.table;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.shop.table.TableStatusCoreService;
import com.gooagoo.api.protecteds.core.shop.ShopProtectedCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisListDao;

@Service
public class TableStatusCoreServiceImpl implements TableStatusCoreService
{

    @Autowired
    private ShopProtectedCoreService shopProtectedCoreService;

    @Override
    public boolean openTable(String shopEntityId, String tableName, String peopleNums) throws Exception
    {
        String mac = this.shopProtectedCoreService.getTransponderMac(shopEntityId, tableName);
        if (StringUtils.isBlank(mac))
        {
            GooagooLog.info("MAC地址为空");
            return false;
        }
        RedisListDao redisListDao = new RedisListDao(RedisServerConstants.catering_servefood);
        String key = mac + "_4";//开台类型为4
        Map<String, String> map = new HashMap<String, String>();
        map.put("tablename", tableName);
        map.put("ctimestamp", TimeUtils.convertDateToString(new Date(), TimeUtils.FORMAT6));
        map.put("tablename", tableName);
        if (StringUtils.isNotBlank(peopleNums))
        {
            map.put("guestsnumber", peopleNums);
        }
        String json = JsonUtils.toJson(map);
        redisListDao.put(key, json);
        //更新redis中的餐桌状态为0-开台
        this.updateTableStatus4Redis(shopEntityId, tableName, "开台");
        return true;
    }

    @Override
    public boolean clearTable(String shopEntityId, String tableName) throws Exception
    {
        String mac = this.shopProtectedCoreService.getTransponderMac(shopEntityId, tableName);
        if (StringUtils.isBlank(mac))
        {
            GooagooLog.info("MAC地址为空");
            return false;
        }
        RedisListDao redisListDao = new RedisListDao(RedisServerConstants.catering_servefood);
        String key = mac + "_7";//清台类型为7
        Map<String, String> map = new HashMap<String, String>();
        map.put("tablename", tableName);
        map.put("ctimestamp", TimeUtils.convertDateToString(new Date(), TimeUtils.FORMAT6));
        String json = JsonUtils.toJson(map);
        redisListDao.put(key, json);
        //更新redis中的餐桌状态为1-空闲
        this.updateTableStatus4Redis(shopEntityId, tableName, "空闲");
        return true;
    }

    /**
     * //更新redis中的餐桌状态
     * @param list
     * @param tablestatus 餐桌状态 0-开台、1-空闲
     */
    private void updateTableStatus4Redis(String shopEntityId, String tableName, String tableStatus)
    {
        boolean changed = false;
        RedisListDao listDao = new RedisListDao(RedisServerConstants.catering_table);
        List<String> list = listDao.get(shopEntityId);
        if (CollectionUtils.isNotEmpty(list))
        {
            for (int i = 0; i < list.size(); i++)
            {
                if (changed)
                {
                    break;
                }
                Map<String, String> tableMap = JsonUtils.json2Map(list.get(i));
                if (tableName.equals(tableMap.get("tablename")))
                {
                    tableMap.put("tablestate", tableStatus);
                    list.set(i, JsonUtils.toJson(tableMap));
                    changed = true;
                }
            }
        }
        if (changed)
        {
            RedisDatabase baseDao = new RedisDatabase(RedisServerConstants.catering_table);
            baseDao.del(shopEntityId);
            listDao.set(shopEntityId, list);
        }
    }

}
