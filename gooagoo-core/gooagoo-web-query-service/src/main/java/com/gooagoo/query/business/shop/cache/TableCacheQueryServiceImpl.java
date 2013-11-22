package com.gooagoo.query.business.shop.cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.shop.cache.TableCacheQueryService;
import com.gooagoo.api.generator.query.shop.ShopTableTypeManageGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.generator.shop.ShopTableTypeManage;
import com.gooagoo.redis.data.RedisListDao;

/**
 * 从缓存中查询商家餐桌状态相关信息
 */
@Service
public class TableCacheQueryServiceImpl implements TableCacheQueryService
{
    @Autowired
    private ShopTableTypeManageGeneratorQueryService shopTableTypeManageGeneratorQueryService;

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
    public List<Map<String, String>> findTableInfoByTable(String shopEntityId, String tableStateName) throws Exception
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
                if (tableStateName.equals(tableMap.get("tablestate")))
                {
                    result.add(tableMap);
                }
            }
        }
        return result;
    }

    @Override
    public List<Map<String, String>> findTableInfoByTypeAndState(String shopEntityId, String tableTypeCode, String tableStateName) throws Exception
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
                if (tableType.equals(tableMap.get("tabletype")) && tableStateName.equals(tableMap.get("tablestate")))
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
        ShopTableTypeManage shopTableTypeManage = this.shopTableTypeManageGeneratorQueryService.selectUnDelByPrimaryKey(tableTypeCode);
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
}
