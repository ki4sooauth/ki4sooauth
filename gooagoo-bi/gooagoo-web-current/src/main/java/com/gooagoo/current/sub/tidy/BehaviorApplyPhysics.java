package com.gooagoo.current.sub.tidy;

import java.util.Date;

import com.gooagoo.common.utils.UUID;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.business.user.account.action.ActionRecord;
import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;

@Message(DispatcherConstants.applyPhysics)
public class BehaviorApplyPhysics implements Customer
{
    @Override
    public void message(Object message)
    {
        BehaveLog behaveLog = (BehaveLog) message;

        MongoDao mongoDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_USER_BEHAVIOR);

        ActionRecord actionRecord = new ActionRecord();
        actionRecord.set_id(UUID.getUUID());
        actionRecord.setShopId(behaveLog.getShopId()); //商家id
        actionRecord.setUserId(behaveLog.getUserId()); //用户id
        actionRecord.setBehaveType("5"); //行为类型 5申请物理卡转换
        actionRecord.setSource(behaveLog.getSource());//来源
        actionRecord.setTimestamp(new Date()); //时间戳
        mongoDao.saveEntity(actionRecord);
    }
}
