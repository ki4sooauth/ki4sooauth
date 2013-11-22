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

@Message(DispatcherConstants.comment)
public class AnalysisUserComment implements Customer
{

    @Override
    public void message(Object message)
    {
        GoodsCacheQueryService goodsCacheService = SpringBeanUtils.getBean(GoodsCacheQueryService.class);
        BehaveLog behaveLog = (BehaveLog) message;
        MongoDao mongoDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_COMMENT);

        BasicDBObject basicDBObject = new BasicDBObject();
        String goodsId = behaveLog.getObjectValue();
        basicDBObject.put("_id", UUID.getUUID());

        basicDBObject.put("userId", behaveLog.getUserId());
        basicDBObject.put("timestamp", new Date());
        basicDBObject.put("source", behaveLog.getSource());

        Map<String, String> goodsCache = goodsCacheService.findGoodsInfo(goodsId);
        basicDBObject.put("shopId", goodsCache.get("shopId"));
        basicDBObject.put("itemSerial", goodsCache.get("itemSerial"));
        basicDBObject.put("goodsBrand", goodsCache.get("goodsBrand"));
        basicDBObject.put("goodsCategoryRoot", goodsCache.get("goodsCategoryRoot"));
        mongoDao.insert(basicDBObject);
    }
}
