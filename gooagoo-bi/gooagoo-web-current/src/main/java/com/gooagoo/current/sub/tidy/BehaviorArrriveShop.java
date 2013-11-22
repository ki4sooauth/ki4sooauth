package com.gooagoo.current.sub.tidy;

import java.util.Date;

import com.gooagoo.bi.entity.position.BehaviorGeneral;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.entity.business.user.account.action.ActionRecord;
import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;

@Message(DispatcherConstants.store)
public class BehaviorArrriveShop implements Customer
{
    @Override
    public void message(Object message)
    {
        BehaviorGeneral arrive = (BehaviorGeneral) message;
        MongoDao mongoDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_USER_BEHAVIOR);
        ActionRecord actionRecord = new ActionRecord();
        actionRecord.set_id(UUID.getUUID());
        actionRecord.setShopId(arrive.getShopId()); //商家id
        actionRecord.setMac(arrive.getMacAddress());
        actionRecord.setUserId(arrive.getUserId()); //用户id
        actionRecord.setBehaveType("1"); //行为类型 1到店
        actionRecord.setObjectValue(arrive.getShopId());
        actionRecord.setTimestamp(new Date()); //时间戳
        mongoDao.saveEntity(actionRecord);
    }
}
