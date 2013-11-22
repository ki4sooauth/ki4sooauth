package com.gooagoo.current.sub.behave;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.gooagoo.api.business.query.goods.cache.GoodsCacheQueryService;
import com.gooagoo.bi.entity.bill.Bill;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.entity.cache.GoodsCache;
import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.gooagoo.intelligence.utils.StringUtils;
import com.gooagoo.redis.data.RedisSortedSetDao;

/**
 * 品类销量排行
 * @author 王宇
 *
 */
@Message(DispatcherConstants.bill)
public class CategorySale implements Customer
{
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 CategorySale");
        Bill bill = (Bill) message;
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_categorySale);
        for (OrderDetailInfo detail : bill.getOrderDetailInfos())
        {
            String goodsId = detail.getGoodsId();
            GoodsCache goodsCache = getGoodsCache(goodsId);
            for (String goodsCategory : goodsCache.getGoodsCategoryId())
            {
                sortedSetDao.edit(goodsCategory, 1, goodsId);
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
            String categoryIdCache = findGoodsInfo.get("categoryId");
            if (StringUtils.hasText(categoryIdCache))
            {
                String[] categories = categoryIdCache.split(",");
                target.setGoodsCategoryId(new ArrayList<String>(Arrays.asList(categories)));
            }
        }
        catch (Exception e)
        {
            GooagooLog.error("查询商品缓存出错（goodsCacheQueryService.findGoodsInfo）", e);
        }
        return target;
    }
}
