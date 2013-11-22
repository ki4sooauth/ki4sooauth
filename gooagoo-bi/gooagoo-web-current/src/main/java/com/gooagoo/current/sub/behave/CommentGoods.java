package com.gooagoo.current.sub.behave;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gooagoo.api.business.query.goods.cache.GoodsCacheQueryService;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.current.tools.UserTools;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.cache.GoodsCache;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.gooagoo.intelligence.utils.StringUtils;
import com.gooagoo.intelligence.utils.TimeTag;
import com.gooagoo.redis.data.RedisSortedSetDao;

@Message(DispatcherConstants.comment)
public class CommentGoods implements Customer
{
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 CommentGoods");
        BehaveLog behaveLog = (BehaveLog) message;
        String id = behaveLog.getObjectValue();
        String value = UserTools.account(behaveLog); //用户 有userId,mac和IP三种
        String source = behaveLog.getSource();
        if (StringUtils.hasText(id, value, source))
        {
            GoodsCache goodsCache = this.getGoods(id);
            String shopId = goodsCache.getShopId();
            this.put(goodsCache, value, "A", source); //所有用户
            this.put(goodsCache, value, "A", "*"); //所有用户
            if (UserTools.isMember(behaveLog.getUserId(), shopId))
            {
                this.put(goodsCache, value, "M", source); //会员
                this.put(goodsCache, value, "M", "*"); //会员
            }
            else
            {
                this.put(goodsCache, value, "N", source);//非会员
                this.put(goodsCache, value, "N", "*"); //非会员
            }
        }
    }

    private GoodsCache getGoods(String id)
    {
        GoodsCacheQueryService goodsCacheQueryService = SpringBeanUtils.getBean(GoodsCacheQueryService.class);

        GoodsCache target = new GoodsCache();
        try
        {
            Map<String, String> findGoodsInfo = goodsCacheQueryService.findGoodsInfo(id);
            BeanUtils.populate(target, findGoodsInfo);
            String categoryCache = findGoodsInfo.get("category");
            if (StringUtils.hasText(categoryCache))
            {
                String[] categories = categoryCache.split(",");
                target.setGoodsCategory(new ArrayList<String>(Arrays.asList(categories)));
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("查询商品缓存出错（goodsCacheQueryService.findGoodsInfo）", e);
        }
        return target;
    }

    private void put(GoodsCache goodsCache, String value, String member, String source)
    {
        if (StringUtils.hasText(value, member, source))
        {
            RedisSortedSetDao goodsSerial = new RedisSortedSetDao(RedisServerConstants.statistics_goodsSerial);
            RedisSortedSetDao goodsBrand = new RedisSortedSetDao(RedisServerConstants.statistics_goodsBrand);
            RedisSortedSetDao goodsCategory = new RedisSortedSetDao(RedisServerConstants.statistics_goodsCategory);

            for (String shop : new String[] { goodsCache.getShopId(), goodsCache.getShopEntityId() })
            {
                for (String category : goodsCache.getGoodsCategory())
                {
                    String categoryBaseKey = shop + "_" + category + "_C_" + member + "_" + source;
                    this.redisPut(goodsCategory, categoryBaseKey, value);
                }
                String brandBaseKey = shop + "_" + goodsCache.getGoodsBrand() + "_C_" + member + "_" + source;
                this.redisPut(goodsBrand, brandBaseKey, value);
                String serialBaseKey = shop + "_" + goodsCache.getItemSerial() + "_C_" + member + "_" + source;
                this.redisPut(goodsSerial, serialBaseKey, value);
            }
        }
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
}
