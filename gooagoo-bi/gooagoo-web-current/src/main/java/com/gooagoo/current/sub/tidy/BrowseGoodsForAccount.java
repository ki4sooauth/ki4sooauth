package com.gooagoo.current.sub.tidy;

import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gooagoo.api.business.query.goods.cache.GoodsCacheQueryService;
import com.gooagoo.bi.entity.analysisUser.AnalysisAccount;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.current.tools.MongoAccountUtils;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.cache.GoodsCache;
import com.gooagoo.gmongo.MongoDao;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.CollectionConstants;
import com.gooagoo.intelligence.constants.MongoConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.gooagoo.intelligence.utils.StringUtils;
import com.mongodb.BasicDBObject;

@Message(DispatcherConstants.browse)
public class BrowseGoodsForAccount implements Customer
{
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 BrowseGoods");
        BehaveLog behaveLog = (BehaveLog) message;
        String goodsId = behaveLog.getObjectValue();
        String source = behaveLog.getSource();
        if ("G".equals(behaveLog.getObjectType()) && StringUtils.hasText(goodsId, source))
        {
            GoodsCache goodsCache = this.getGoodsCache(goodsId);
            String shopId = goodsCache.getShopId();

            MongoDao mongoDao = new MongoDao(MongoConstants.MONGO_URL, MongoConstants.analysisDB, CollectionConstants.ANLS_ACCOUNT);
            BasicDBObject dbObject = new BasicDBObject();
            dbObject.put("userId", behaveLog.getUserId());
            dbObject.put("ip", behaveLog.getIpAddress());
            dbObject.put("mac", behaveLog.getMacAddress());
            dbObject.put("shopId", shopId);

            if (StringUtils.hasText(behaveLog.getUserId()))
            {
                String id = shopId + "_0_" + behaveLog.getUserId();
                if (!mongoDao.isIdExist(id))
                {
                    dbObject.put("_id", id);
                    mongoDao.insert(dbObject);
                }
            }
            if (StringUtils.hasText(behaveLog.getIpAddress()))
            {
                String id = shopId + "_2_" + behaveLog.getIpAddress();
                if (!mongoDao.isIdExist(id))
                {
                    dbObject.put("_id", id);
                    mongoDao.insert(dbObject);
                }
            }
            if (StringUtils.hasText(behaveLog.getMacAddress()))
            {
                MongoAccountUtils accountUtils = new MongoAccountUtils();
                AnalysisAccount account = accountUtils.buildByMac(shopId, behaveLog.getMacAddress());
                accountUtils.save(account);
            }

        }
    }

    private GoodsCache getGoodsCache(String id)
    {
        GoodsCacheQueryService goodsCacheQueryService = SpringBeanUtils.getBean(GoodsCacheQueryService.class);

        GoodsCache target = new GoodsCache();
        try
        {
            Map<String, String> findGoodsInfo = goodsCacheQueryService.findGoodsInfo(id);
            BeanUtils.populate(target, findGoodsInfo);
        }
        catch (Exception e)
        {
            GooagooLog.error("查询商品缓存出错（goodsCacheQueryService.findGoodsInfo）", e);
        }
        return target;
    }
}
