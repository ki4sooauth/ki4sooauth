package com.gooagoo.current.sub.tidy;

import java.sql.Date;

import com.gooagoo.bi.entity.position.BehaviorLeaveShop;
import com.gooagoo.bi.entity.position.Leave;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.mongodb.BasicDBObject;

@Message(DispatcherConstants.leave)
public class LeaveShop implements Customer
{
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 LeaveShop");
        BehaviorLeaveShop behavior = (BehaviorLeaveShop) message;

        MongoDao arrivalShopDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_ARRIVAL_SHOP);
        MongoDao arrivalArea = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_ARRIVAL_AREA);

        BasicDBObject store = new BasicDBObject();
        store.put("_id", UUID.getUUID());
        store.put("userId", behavior.getUserId());
        store.put("mac", behavior.getMacAddress());
        store.put("start", new Date(behavior.getStart()));
        store.put("end", new Date(behavior.getEnd()));
        store.put("duration", behavior.getDuration());
        store.put("shopId", behavior.getShopId());
        store.put("entityId", behavior.getEntityId());
        arrivalShopDao.insert(store);

        for (Leave leave : behavior.getLastArea())
        {
            BasicDBObject lastArea = new BasicDBObject();
            lastArea.put("_id", UUID.getUUID());
            lastArea.put("userId", behavior.getUserId());
            lastArea.put("mac", behavior.getMacAddress());
            lastArea.put("start", new Date(leave.getStart()));
            lastArea.put("end", new Date(leave.getEnd()));
            lastArea.put("duration", leave.getDuration());
            lastArea.put("positionId", leave.getId());
            arrivalArea.insert(lastArea);
        }
    }
}