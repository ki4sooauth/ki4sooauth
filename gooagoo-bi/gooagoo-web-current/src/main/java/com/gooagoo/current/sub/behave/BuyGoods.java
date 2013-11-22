package com.gooagoo.current.sub.behave;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gooagoo.api.business.query.goods.cache.GoodsCacheQueryService;
import com.gooagoo.api.generator.query.bill.OrderDetailInfoGeneratorQueryService;
import com.gooagoo.bi.entity.bill.Bill;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.current.tools.UserTools;
import com.gooagoo.entity.cache.GoodsCache;
import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.entity.generator.bill.OrderDetailInfoExample;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.gooagoo.intelligence.utils.StringUtils;
import com.gooagoo.intelligence.utils.TimeTag;
import com.gooagoo.redis.data.RedisSortedSetDao;

@Message(DispatcherConstants.bill)
public class BuyGoods implements Customer
{
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 BuyGoods");
        Bill bill = (Bill) message;
        String shopId = bill.getOrderInfo().getShopId();
        String store = bill.getOrderInfo().getShopEntityId();
        String billId = bill.getOrderInfo().getOrderId();
        String userId = bill.getOrderInfo().getUserId();
        if (StringUtils.hasText(shopId, billId, store, userId))
        {
            String account = "0_" + userId;
            List<GoodsCache> goods = this.getBillGoods(billId);
            this.put(goods, shopId, store, account, "A"); //所有用户
            if (UserTools.isMember(userId, shopId))
            {
                this.put(goods, shopId, store, account, "M"); //会员
            }
            else
            {
                this.put(goods, shopId, store, account, "N");//非会员
            }
        }
    }

    private List<GoodsCache> getBillGoods(String id)
    {
        OrderDetailInfoGeneratorQueryService orderDetailService = SpringBeanUtils.getBean(OrderDetailInfoGeneratorQueryService.class);
        GoodsCacheQueryService goodsCacheQueryService = SpringBeanUtils.getBean(GoodsCacheQueryService.class);

        List<GoodsCache> goodsCaches = new ArrayList<GoodsCache>();
        OrderDetailInfoExample query = new OrderDetailInfoExample();
        query.createCriteria().andOrderIdEqualTo(id);
        List<OrderDetailInfo> billGoods = orderDetailService.selectByExample(query);
        for (OrderDetailInfo orderDetailInfo : billGoods)
        {
            try
            {
                GoodsCache target = new GoodsCache();
                Map<String, String> findGoodsInfo = goodsCacheQueryService.findGoodsInfo(orderDetailInfo.getGoodsId());
                if (findGoodsInfo != null)
                {
                    BeanUtils.populate(target, findGoodsInfo);
                    goodsCaches.add(target);
                    String categoryCache = findGoodsInfo.get("category");
                    if (StringUtils.hasText(categoryCache))
                    {
                        String[] categories = categoryCache.split(",");
                        target.setGoodsCategory(new ArrayList<String>(Arrays.asList(categories)));
                    }
                }
            }
            catch (Exception e)
            {
                GooagooLog.error("统计商品购买", e);
            }
        }
        return goodsCaches;
    }

    private void redisPut(RedisSortedSetDao sortedSetDao, String baseKey, String value)
    {
        TimeTag time = new TimeTag();
        sortedSetDao.put(baseKey, time.timestamp(), value);

        sortedSetDao.put(baseKey + time.year() + time.month() + time.day(), time.timestamp(), value);
        sortedSetDao.put(baseKey + time.year() + time.month() + time.day() + time.hour(), time.timestamp(), value);
        sortedSetDao.put(baseKey + time.year() + time.week(), time.timestamp(), value);
        sortedSetDao.put(baseKey + time.year() + time.month(), time.timestamp(), value);
        sortedSetDao.put(baseKey + time.year(), time.timestamp(), value);

        sortedSetDao.edit("Interaction", 1L, baseKey);
        sortedSetDao.edit("Interaction", 1L, baseKey + time.year() + time.month() + time.day());
        sortedSetDao.edit("Interaction", 1L, baseKey + time.year() + time.month() + time.day() + time.hour());
        sortedSetDao.edit("Interaction", 1L, baseKey + time.year() + time.week());
        sortedSetDao.edit("Interaction", 1L, baseKey + time.year() + time.month());
        sortedSetDao.edit("Interaction", 1L, baseKey + time.year());
    }

    private void put(List<GoodsCache> goodsCaches, String shopId, String store, String value, String member)
    {
        RedisSortedSetDao goodsSerial = new RedisSortedSetDao(RedisServerConstants.statistics_goodsSerial);
        RedisSortedSetDao goodsBrand = new RedisSortedSetDao(RedisServerConstants.statistics_goodsBrand);
        RedisSortedSetDao goodsCategory = new RedisSortedSetDao(RedisServerConstants.statistics_goodsCategory);

        for (GoodsCache goodsCache : goodsCaches)
        {
            for (String shop : new String[] { shopId, store })
            {
                for (String category : goodsCache.getGoodsCategory())
                {
                    String categoryBaseKey = shop + "_" + category + "_P_" + member;
                    redisPut(goodsCategory, categoryBaseKey, value);
                }
                String brandBaseKey = shop + "_" + goodsCache.getGoodsBrand() + "_P_" + member;
                redisPut(goodsBrand, brandBaseKey, value);
                String serialBaseKey = shop + "_" + goodsCache.getItemSerial() + "_P_" + member;
                redisPut(goodsSerial, serialBaseKey, value);
            }
        }
    }
}
