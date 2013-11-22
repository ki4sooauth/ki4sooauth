package com.gooagoo.current.sub.tidy;

import java.util.Date;
import java.util.Map;

import com.gooagoo.api.business.query.goods.cache.GoodsCacheQueryService;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.mongodb.BasicDBObject;

@Message(DispatcherConstants.browse)
public class AnalysisUserBrowse implements Customer
{

    @Override
    public void message(Object message)
    {
        GoodsCacheQueryService goodsCacheService = SpringBeanUtils.getBean(GoodsCacheQueryService.class);
        BehaveLog behaveLog = (BehaveLog) message;
        MongoDao mongoDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_BROWSE);

        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.put("_id", UUID.getUUID());
        basicDBObject.put("shopId", behaveLog.getShopId());
        basicDBObject.put("userId", behaveLog.getUserId());
        basicDBObject.put("ip", behaveLog.getIpAddress());
        basicDBObject.put("mac", behaveLog.getMacAddress());
        basicDBObject.put("timestamp", new Date());
        basicDBObject.put("source", behaveLog.getSource());
        if ("G".equals(behaveLog.getObjectType()))
        {
            Map<String, String> goodsCache = goodsCacheService.findGoodsInfo(behaveLog.getObjectValue());
            basicDBObject.put("goodsId", behaveLog.getObjectValue());
            basicDBObject.put("itemSerial", goodsCache.get("itemSerial"));
            basicDBObject.put("goodsBrand", goodsCache.get("goodsBrand"));
            basicDBObject.put("category", new String[] { goodsCache.get("goodsCategoryRoot"), goodsCache.get("goodsCategoryLeaf") });
            mongoDao.insert(basicDBObject);
        }
        else if ("A".equals(behaveLog.getObjectType()))
        {
            basicDBObject.put("activityId", behaveLog.getObjectValue());
            mongoDao.insert(basicDBObject);
        }
        else if ("C".equals(behaveLog.getObjectType()))
        {
            basicDBObject.put("couponId", behaveLog.getObjectValue());
            mongoDao.insert(basicDBObject);
        }

    }
}
