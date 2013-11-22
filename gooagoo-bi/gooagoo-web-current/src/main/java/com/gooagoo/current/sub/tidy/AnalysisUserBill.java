package com.gooagoo.current.sub.tidy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gooagoo.api.business.query.member.cache.MemberCacheQueryService;
import com.gooagoo.bi.entity.bill.Bill;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.mongodb.BasicDBObject;

@Message(DispatcherConstants.bill)
public class AnalysisUserBill implements Customer
{
    @Override
    public void message(Object message)
    {
        MemberCacheQueryService memberCacheQueryService = SpringBeanUtils.getBean(MemberCacheQueryService.class);

        Bill bill = (Bill) message;
        MongoDao mongoDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_BILL);
        List<String> itemSerial = new ArrayList<String>();
        List<String> goodsBrand = new ArrayList<String>();
        List<String> category = new ArrayList<String>();
        List<String> coupon = bill.getCoupons();

        for (OrderDetailInfo orderDetail : bill.getOrderDetailInfos())
        {
            itemSerial.add(orderDetail.getItemSerial());
            goodsBrand.add(orderDetail.getGoodsBrand());
            category.add(orderDetail.getGoodsCategoryRoot());
            category.add(orderDetail.getGoodsCategoryLeaf());
        }
        String shopId = bill.getOrderInfo().getShopId();
        String userId = bill.getOrderInfo().getUserId();
        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.put("_id", bill.getOrderInfo().getOrderId());

        try
        {
            Map<String, String> memberCache = memberCacheQueryService.findMembeInfo(bill.getOrderInfo().getUserId(), shopId);
            basicDBObject.put("cardId", memberCache.get("cardId"));
        }
        catch (Exception e)
        {
            GooagooLog.error("读会员信息缓存", e);
        }
        basicDBObject.put("shopId", shopId);
        basicDBObject.put("shopEntityId", bill.getOrderInfo().getShopEntityId());
        basicDBObject.put("userId", userId);
        basicDBObject.put("payPrice", bill.getOrderInfo().getPayPrice());
        basicDBObject.put("timestamp", new Date());
        basicDBObject.put("source", bill.getSource());

        basicDBObject.put("itemSerial", itemSerial);
        basicDBObject.put("goodsBrand", goodsBrand);
        basicDBObject.put("category", category);
        basicDBObject.put("coupon", coupon);
        mongoDao.save(basicDBObject);
    }
}
