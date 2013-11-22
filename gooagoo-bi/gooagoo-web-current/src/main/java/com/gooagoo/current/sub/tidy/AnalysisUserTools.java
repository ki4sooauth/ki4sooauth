package com.gooagoo.current.sub.tidy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gooagoo.api.business.query.goods.cache.GoodsCacheQueryService;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.gooagoo.intelligence.utils.StringUtils;
import com.mongodb.BasicDBObject;

@Message(DispatcherConstants.server)
public class AnalysisUserTools implements Customer
{

    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 AnalysisUserTools");
        GoodsCacheQueryService goodsCacheService = SpringBeanUtils.getBean(GoodsCacheQueryService.class);
        BehaveLog behaveLog = (BehaveLog) message;
        MongoDao mongoDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_TOOLS);
        BasicDBObject basicDBObject = new BasicDBObject();
        basicDBObject.put("_id", UUID.getUUID());
        basicDBObject.put("shopId", behaveLog.getShopId());
        basicDBObject.put("userId", behaveLog.getUserId());
        basicDBObject.put("timestamp", new Date());
        basicDBObject.put("toolsid", behaveLog.getObjectValue());
        List<String> goodsIds = getGoodsIdFromBehave(behaveLog);

        if (goodsIds != null && goodsIds.size() != 0)
        {
            List<String> itemSerial = new ArrayList<String>();
            List<String> goodsBrand = new ArrayList<String>();
            List<String> category = new ArrayList<String>();
            for (String goodsId : goodsIds)
            {
                Map<String, String> goodsCache = goodsCacheService.findGoodsInfo(goodsId);
                itemSerial.add(goodsCache.get("itemSerial"));
                goodsBrand.add(goodsCache.get("goodsBrand"));
                category.add(goodsCache.get("goodsCategoryRoot"));
                category.add(goodsCache.get("goodsCategoryLeaf"));
            }
            basicDBObject.put("itemSerial", itemSerial);
            basicDBObject.put("goodsBrand", goodsBrand);
            basicDBObject.put("category", category);
        }
        mongoDao.insert(basicDBObject);
    }

    private List<String> getGoodsIdFromBehave(BehaveLog behaveLog)
    {
        List<String> list = null;
        if (StringUtils.hasText(behaveLog.getDetail()))
        {
            String detail = behaveLog.getDetail().replaceAll("[\\[{\"}\\]]", "");
            list = Arrays.asList(detail.split(","));
        }
        return list;
        /*String detail = behaveLog.getDetail();
        ToolsLogDetail logDetail = new Gson().fromJson(detail, ToolsLogDetail.class);
        return logDetail.getGoodsId();*/
    }
}
