package com.gooagoo.current.sub.tidy;

import com.gooagoo.bi.entity.analysisUser.AnalysisAccount;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.current.tools.MongoAccountUtils;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.StringUtils;
import com.gooagoo.intelligence.utils.TimeTag;
import com.gooagoo.redis.data.RedisSortedSetDao;
import com.mongodb.BasicDBObject;

/**
 * 浏览服务工具
 * @author 王宇
 *
 */
@Message(DispatcherConstants.browse)
public class BrowseToolsForAccount implements Customer
{
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 BrowseTools");
        BehaveLog behaveLog = (BehaveLog) message;
        String shopId = behaveLog.getShopId();
        String toolsId = behaveLog.getObjectValue();
        if ("S".equals(behaveLog.getObjectType()) && StringUtils.hasText(shopId, toolsId))
        {
            MongoDao mongoDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_ACCOUNT);
            BasicDBObject dbObject = new BasicDBObject();
            dbObject.put("userId", behaveLog.getUserId());
            dbObject.put("ip", behaveLog.getIpAddress());
            dbObject.put("mac", behaveLog.getMacAddress());
            dbObject.put("shopId", shopId);

            if (StringUtils.hasText(behaveLog.getUserId()))
            {
                String id = shopId + "_0_" + behaveLog.getUserId();
                if (!mongoDao.isIdExist(id))
                {
                    dbObject.put("_id", id);
                    mongoDao.insert(dbObject);
                }
            }
            if (StringUtils.hasText(behaveLog.getIpAddress()))
            {
                String id = shopId + "_2_" + behaveLog.getIpAddress();
                if (!mongoDao.isIdExist(id))
                {
                    dbObject.put("_id", id);
                    mongoDao.insert(dbObject);
                }
            }
            if (StringUtils.hasText(behaveLog.getMacAddress()))
            {
                MongoAccountUtils accountUtils = new MongoAccountUtils();
                AnalysisAccount account = accountUtils.buildByMac(shopId, behaveLog.getMacAddress());
                accountUtils.save(account);
            }

        }
    }

    /**
     * 浏览服务工具
     * @param toolsId 服务工具id
     * @param type 类型 B浏览 U使用
     * @param value
     * @param memberType
     */
    private void put(String toolsId, String value, String memberType)
    {
        TimeTag time = new TimeTag();
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_tools);
        sortedSetDao.put(toolsId + "_B_" + memberType, time.timestamp(), value);
        sortedSetDao.put(toolsId + "_B_" + memberType + time.day(), time.timestamp(), value);
        sortedSetDao.put(toolsId + "_B_" + memberType + time.day() + time.hour(), time.timestamp(), value);
        sortedSetDao.put(toolsId + "_B_" + memberType + time.month(), time.timestamp(), value);
        sortedSetDao.put(toolsId + "_B_" + memberType + time.week(), time.timestamp(), value);
        sortedSetDao.put(toolsId + "_B_" + memberType + time.year(), time.timestamp(), value);

        sortedSetDao.edit("Interaction", 1L, toolsId + "_B_" + memberType);
        sortedSetDao.edit("Interaction", 1L, toolsId + "_B_" + memberType + time.day());
        sortedSetDao.edit("Interaction", 1L, toolsId + "_B_" + memberType + time.day() + time.hour());
        sortedSetDao.edit("Interaction", 1L, toolsId + "_B_" + memberType + time.month());
        sortedSetDao.edit("Interaction", 1L, toolsId + "_B_" + memberType + time.week());
        sortedSetDao.edit("Interaction", 1L, toolsId + "_B_" + memberType + time.year());
    }
}
