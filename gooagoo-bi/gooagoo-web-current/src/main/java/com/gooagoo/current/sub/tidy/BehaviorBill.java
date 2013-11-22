package com.gooagoo.current.sub.tidy;

import java.util.Date;

import com.gooagoo.bi.entity.bill.Bill;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.entity.business.user.account.action.ActionRecord;
import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;

@Message(DispatcherConstants.bill)
public class BehaviorBill implements Customer
{
    @Override
    public void message(Object message)
    {
        Bill bill = (Bill) message;
        MongoDao mongoDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_USER_BEHAVIOR);
        ActionRecord actionRecord = new ActionRecord();
        actionRecord.set_id(UUID.getUUID());
        actionRecord.setShopId(bill.getOrderInfo().getShopId()); //商家id
        actionRecord.setUserId(bill.getOrderInfo().getUserId()); //用户id
        actionRecord.setBehaveType("0"); //行为类型 0帐单
        actionRecord.setObjectValue(bill.getOrderInfo().getOrderId()); //行为对象编号：用户所做操作的对象，比如商品、活动、商家
        actionRecord.setSource(bill.getSource());
        actionRecord.setTimestamp(new Date()); //时间戳
        mongoDao.saveEntity(actionRecord);
    }
}
