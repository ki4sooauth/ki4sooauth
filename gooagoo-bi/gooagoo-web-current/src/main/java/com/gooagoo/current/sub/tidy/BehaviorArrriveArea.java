package com.gooagoo.current.sub.tidy;

import java.util.Date;

import com.gooagoo.bi.entity.position.BehaviorAreaChange;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.entity.business.user.account.action.ActionRecord;
import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;

@Message(DispatcherConstants.area)
public class BehaviorArrriveArea implements Customer
{
    @Override
    public void message(Object message)
    {
        BehaviorAreaChange areaChange = (BehaviorAreaChange) message;
        MongoDao mongoDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_USER_BEHAVIOR);

        ActionRecord actionRecord = new ActionRecord();
        actionRecord.set_id(UUID.getUUID());
        actionRecord.setShopId(areaChange.getShopId()); //商家id
        actionRecord.setMac(areaChange.getMacAddress());
        actionRecord.setUserId(areaChange.getUserId()); //用户id
        actionRecord.setBehaveType("2"); //行为类型 2到区域
        for (String newArea : areaChange.getNewArea())
        {
            actionRecord.setObjectValue(newArea);
            actionRecord.setTimestamp(new Date()); //时间戳
            mongoDao.saveEntity(actionRecord);
        }
    }
}
