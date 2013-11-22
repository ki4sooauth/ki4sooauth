package com.gooagoo.current.sub.tidy;

import com.gooagoo.bi.entity.bill.Bill;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.mongodb.BasicDBObject;

@Message(DispatcherConstants.bill)
public class AnalysisUserShoppingBasic implements Customer
{
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 AnalysisUserShoppingBasic");
        Bill bill = (Bill) message;
        MongoDao mongoDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_USER_SHOPPING_BASIC);

        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.put("_id", bill.getOrderInfo().getOrderId());
        basicDBObject.put("shop_id", bill.getOrderInfo().getShopId());
        basicDBObject.put("shop_entity_id", bill.getOrderInfo().getShopEntityId());
        basicDBObject.put("user_id", bill.getOrderInfo().getUserId());
        basicDBObject.put("pro_date", bill.getOrderInfo().getCreateTime());
        basicDBObject.put("pay_price", bill.getOrderInfo().getPayPrice());

        mongoDao.insert(basicDBObject);
    }
}
