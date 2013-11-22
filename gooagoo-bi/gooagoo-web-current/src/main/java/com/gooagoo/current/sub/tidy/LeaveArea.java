package com.gooagoo.current.sub.tidy;

import java.sql.Date;

import com.gooagoo.bi.entity.position.BehaviorAreaChange;
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

@Message(DispatcherConstants.area)
public class LeaveArea implements Customer
{
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 LeaveArea");
        BehaviorAreaChange behavior = (BehaviorAreaChange) message;
        MongoDao arrivalArea = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_ARRIVAL_AREA);

        for (Leave leave : behavior.getOldArea())
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