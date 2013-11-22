package com.gooagoo.current.sub.behave;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gooagoo.api.business.query.goods.cache.GoodsCacheQueryService;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.current.tools.Marketing;
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

@Message(DispatcherConstants.browse)
public class BrowseGoods implements Customer
{
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 BrowseGoods");
        Marketing marketing = new Marketing();
        BehaveLog behaveLog = (BehaveLog) message;
        String id = behaveLog.getObjectValue();
        String value = UserTools.account(behaveLog); //用户 有userId,mac和IP三种
        String source = behaveLog.getSource();
        String channel = marketing.getChannel(behaveLog.getObjectSource());
        if ("G".equals(behaveLog.getObjectType()) && StringUtils.hasText(id, value, source))
        {
            GoodsCache goodsCache = this.getGoodsCache(id);
            if (goodsCache.getGoodsCategory() == null)
            {
                GooagooLog.debug("商品缓存不正确，没有品类信息 商品序列号:" + goodsCache.getItemSerial());
                return;
            }
            String shopId = goodsCache.getShopId();

            this.put(goodsCache, value, "A", channel, source); //所有用户 
            this.put(goodsCache, value, "A", channel, "*"); //所有用户   
            this.put(goodsCache, value, "A", channel + behaveLog.getObjectSource(), source); //所有用户 
            this.put(goodsCache, value, "A", channel + behaveLog.getObjectSource(), "*"); //所有用户   
            this.put(goodsCache, value, "A", "*", source); //所有用户
            this.put(goodsCache, value, "A", "*", "*"); //所有用户   

            if (UserTools.isMember(behaveLog.getUserId(), shopId))
            {
                this.put(goodsCache, value, "M", channel, source); //所有用户 
                this.put(goodsCache, value, "M", channel, "*"); //所有用户   
                this.put(goodsCache, value, "M", channel + behaveLog.getObjectSource(), source); //所有用户 
                this.put(goodsCache, value, "M", channel + behaveLog.getObjectSource(), "*"); //所有用户   
                this.put(goodsCache, value, "M", "*", source); //所有用户*/
                this.put(goodsCache, value, "M", "*", "*"); //所有用户   
            }
            else
            {
                this.put(goodsCache, value, "N", channel, source); //所有用户 
                this.put(goodsCache, value, "N", channel, "*"); //所有用户 
                this.put(goodsCache, value, "N", channel + behaveLog.getObjectSource(), source); //所有用户 
                this.put(goodsCache, value, "N", channel + behaveLog.getObjectSource(), "*"); //所有用户   
                this.put(goodsCache, value, "N", "*", source); //所有用户 */
                this.put(goodsCache, value, "N", "*", "*"); //所有用户   
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

    private void put(GoodsCache goodsCache, String value, String member, String channel, String source)
    {
        if (StringUtils.hasText(value, member, channel, source))
        {
            RedisSortedSetDao goodsSerial = new RedisSortedSetDao(RedisServerConstants.statistics_goodsSerial);
            RedisSortedSetDao goodsBrand = new RedisSortedSetDao(RedisServerConstants.statistics_goodsBrand);
            RedisSortedSetDao goodsCategory = new RedisSortedSetDao(RedisServerConstants.statistics_goodsCategory);

            for (String shop : new String[] { goodsCache.getShopId(), goodsCache.getShopEntityId() })
            {
                for (String category : goodsCache.getGoodsCategory())
                {
                    String categoryBaseKey = shop + "_" + category + "_B_" + member + "_" + channel + "_" + source;
                    this.redisPut(goodsCategory, categoryBaseKey, value);
                }
                String brandBaseKey = shop + "_" + goodsCache.getGoodsBrand() + "_B_" + member + "_" + channel + "_" + source;
                this.redisPut(goodsBrand, brandBaseKey, value);
                String serialBaseKey = shop + "_" + goodsCache.getItemSerial() + "_B_" + member + "_" + channel + "_" + source;
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
