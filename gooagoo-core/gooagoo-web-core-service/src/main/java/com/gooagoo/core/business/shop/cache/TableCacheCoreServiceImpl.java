package com.gooagoo.core.business.shop.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.shop.cache.TableCacheCoreService;
import com.gooagoo.api.generator.core.shop.ShopTableTypeManageGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.CollectionCoreUtils;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.generator.shop.ShopTableTypeManage;
import com.gooagoo.entity.generator.shop.ShopTableTypeManageExample;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisListDao;

/**
 * 从缓存中查询商家餐桌信息
 */
@Service
public class TableCacheCoreServiceImpl implements TableCacheCoreService
{

    @Autowired
    private ShopTableTypeManageGeneratorCoreService shopTableTypeManageGeneratorCoreService;

    @Override
    public boolean updateTableStatus(String mac, String shopentityid, List<Map<String, String>> tablesinfo) throws Exception
    {
        if (CollectionUtils.isEmpty(tablesinfo))
        {
            return false;
        }
        //清空该实体店所有餐桌状态
        RedisDatabase redisDatabase = new RedisDatabase(RedisServerConstants.catering_table);
        redisDatabase.del(shopentityid);
        RedisListDao redisListDao = new RedisListDao(RedisServerConstants.catering_table);
        for (Map<String, String> map : tablesinfo)
        {
            Map<String, String> tableMap = new HashMap<String, String>();
            tableMap.put("tablename", map.get("tablename"));
            tableMap.put("tabletypecode", this.getTableTypeCodeByName(shopentityid, map.get("tabletype")));
            tableMap.put("tabletype", map.get("tabletype"));
            tableMap.put("tablestate", map.get("tablestate"));
            CollectionCoreUtils.filterNullValue4Map(tableMap);
            redisListDao.put(shopentityid, JsonUtils.toJson(tableMap));
        }
        return true;
    }

    @Override
    public boolean updateTableInfo(String shopentityid, Map<String, String> tableinfo) throws Exception
    {
        //清空该实体店所有餐桌状态
        boolean changed = false;
        RedisListDao redisListDao = new RedisListDao(RedisServerConstants.catering_table);
        List<String> tableinfoList = redisListDao.get(shopentityid);
        for (int i = 0; i < tableinfoList.size(); i++)
        {
            String json = tableinfoList.get(i);
            Map<String, String> tableInfoMap = JsonUtils.json2Map(json);
            if (tableInfoMap.get("tablename").equals(tableinfo.get("tablename")))
            {
                tableinfoList.set(i, JsonUtils.toJson(tableinfo));
                changed = true;
                break;
            }
        }
        if (!changed)
        {
            GooagooLog.warn("实体店餐桌布存在[shopentityid=" + shopentityid + "、tablename=" + tableinfo.get("tablename") + "]");
            return false;
        }
        RedisDatabase redisDatabase = new RedisDatabase(RedisServerConstants.catering_table);
        redisDatabase.del(shopentityid);
        redisListDao.set(shopentityid, tableinfoList);
        return true;
    }

    public static void main(String[] args)
    {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        for (int i = 0; i < list.size(); i++)
        {
            if ("3".equals(list.get(i)))
            {
                list.set(i, "a");

            }
        }
        System.out.println(list.toString());
    }

    @Override
    public List<Map<String, String>> findTableInfo(String shopEntityId) throws Exception
    {
        List<Map<String, String>> result = null;
        RedisListDao redisListDao = new RedisListDao(RedisServerConstants.catering_table);
        List<String> list = redisListDao.get(shopEntityId);
        if (CollectionUtils.isNotEmpty(list))
        {
            result = new ArrayList<Map<String, String>>();
            for (String json : list)
            {
                result.add(JsonUtils.json2Map(json));
            }
        }
        return result;
    }

    @Override
    public Map<String, String> findTableInfoByTableName(String shopEntityId, String tableName) throws Exception
    {
        RedisListDao redisListDao = new RedisListDao(RedisServerConstants.catering_table);
        List<String> list = redisListDao.get(shopEntityId);
        if (CollectionUtils.isNotEmpty(list))
        {
            for (String json : list)
            {
                Map<String, String> tableMap = JsonUtils.json2Map(json);
                if (tableName.equals(tableMap.get("tablename")))
                {
                    return tableMap;
                }
            }
        }
        return null;
    }

    @Override
    public List<Map<String, String>> findTableInfoByTableType(String shopEntityId, String tableTypeCode) throws Exception
    {
        List<Map<String, String>> result = null;
        RedisListDao redisListDao = new RedisListDao(RedisServerConstants.catering_table);
        List<String> list = redisListDao.get(shopEntityId);
        if (CollectionUtils.isNotEmpty(list))
        {
            result = new ArrayList<Map<String, String>>();
            //根据餐桌类型编码查询出餐桌类型名称
            String tableType = this.getTableTypeNameByCode(tableTypeCode);
            for (String json : list)
            {
                Map<String, String> tableMap = JsonUtils.json2Map(json);
                if (tableType.equals(tableMap.get("tabletype")))
                {
                    result.add(tableMap);
                }
            }
        }
        return result;
    }

    @Override
    public List<Map<String, String>> findTableInfoByTable(String shopEntityId, String tableState) throws Exception
    {
        List<Map<String, String>> result = null;
        RedisListDao redisListDao = new RedisListDao(RedisServerConstants.catering_table);
        List<String> list = redisListDao.get(shopEntityId);
        if (CollectionUtils.isNotEmpty(list))
        {
            result = new ArrayList<Map<String, String>>();
            for (String json : list)
            {
                Map<String, String> tableMap = JsonUtils.json2Map(json);
                if (tableState.equals(tableMap.get("tablestate")))
                {
                    result.add(tableMap);
                }
            }
        }
        return result;
    }

    @Override
    public List<Map<String, String>> findTableInfoByTypeAndState(String shopEntityId, String tableTypeCode, String tableState) throws Exception
    {
        List<Map<String, String>> result = null;
        RedisListDao redisListDao = new RedisListDao(RedisServerConstants.catering_table);
        List<String> list = redisListDao.get(shopEntityId);
        if (CollectionUtils.isNotEmpty(list))
        {
            result = new ArrayList<Map<String, String>>();
            //根据餐桌类型编码查询出餐桌类型名称
            String tableType = this.getTableTypeNameByCode(tableTypeCode);
            for (String json : list)
            {
                Map<String, String> tableMap = JsonUtils.json2Map(json);
                if (tableType.equals(tableMap.get("tabletype")) && tableState.equals(tableMap.get("tablestate")))
                {
                    result.add(tableMap);
                }
            }
        }
        return result;
    }

    private String getTableTypeNameByCode(String tableTypeCode)
    {
        //根据餐桌类型编码查询出餐桌类型名称
        ShopTableTypeManage shopTableTypeManage = this.shopTableTypeManageGeneratorCoreService.selectUnDelByPrimaryKey(tableTypeCode);
        String tableTypeName = null;
        if (shopTableTypeManage != null)
        {
            tableTypeName = shopTableTypeManage.getTableTypeName();
        }
        else
        {
            GooagooLog.warn("无对应餐桌类型信息【通过tableTypeCode=" + tableTypeCode + "查询不到对应餐桌类型信息】");
        }
        return tableTypeName;
    }

    private String getTableTypeCodeByName(String shopEntityId, String tableTypeName)
    {
        //根据餐桌类型名称和实体店编号查询出餐桌类型编号
        String tableTypeCode = null;
        ShopTableTypeManageExample shopTableTypeManageExample = new ShopTableTypeManageExample();
        shopTableTypeManageExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andTableTypeNameEqualTo(tableTypeName).andIsDelEqualTo("N");
        List<ShopTableTypeManage> shopTableTypeManageList = this.shopTableTypeManageGeneratorCoreService.selectByExample(shopTableTypeManageExample);
        if (CollectionUtils.isNotEmpty(shopTableTypeManageList))
        {
            ShopTableTypeManage shopTableTypeManage = shopTableTypeManageList.get(0);
            tableTypeCode = shopTableTypeManage.getTableTypeCode();
        }
        else
        {
            GooagooLog.warn("无对应餐桌类型信息【通过tableTypeName=" + tableTypeName + "、shopEntityId=" + shopEntityId + "查询不到对应餐桌类型信息】");
        }
        return tableTypeCode;
    }
}
