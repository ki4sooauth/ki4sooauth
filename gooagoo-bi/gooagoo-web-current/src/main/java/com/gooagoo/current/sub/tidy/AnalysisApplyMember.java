package com.gooagoo.current.sub.tidy;

import java.util.Date;

import com.gooagoo.common.utils.UUID;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.mongodb.BasicDBObject;

@Message(DispatcherConstants.applyMember)
public class AnalysisApplyMember implements Customer
{

    @Override
    public void message(Object message)
    {
        BehaveLog behaveLog = (BehaveLog) message;
        MongoDao mongoDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_APPLYMEMBER);

        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.put("_id", UUID.getUUID());
        basicDBObject.put("shopId", behaveLog.getShopId());
        basicDBObject.put("userId", behaveLog.getUserId());
        basicDBObject.put("timestamp", new Date());
        basicDBObject.put("source", behaveLog.getSource());

        mongoDao.insert(basicDBObject);
    }
}
