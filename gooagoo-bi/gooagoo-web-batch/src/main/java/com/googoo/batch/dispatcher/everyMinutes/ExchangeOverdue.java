package com.googoo.batch.dispatcher.everyMinutes;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gooagoo.api.generator.query.goods.GoodsBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.ShopIntegralGeneratorQueryService;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsBaseInfoExample;
import com.gooagoo.entity.generator.marketing.ShopIntegral;
import com.gooagoo.entity.generator.marketing.ShopIntegralExample;
import com.gooagoo.entity.generator.marketing.ShopIntegralExample.Criteria;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.transferBox.Engine;
import com.gooagoo.intelligence.transferBox.Tyre;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisSortedSetDao;
import com.googoo.batch.constants.BatchTimeCnstants;

@Engine(BatchTimeCnstants.everyTenMinutes)
public class ExchangeOverdue implements Tyre
{

    @Override
    public void run()
    {
        GooagooLog.debug("启动任务 ExchangeOverdue");
        ShopIntegralGeneratorQueryService integralService = SpringBeanUtils.getBean(ShopIntegralGeneratorQueryService.class);
        GoodsBaseInfoGeneratorQueryService goodsService = SpringBeanUtils.getBean(GoodsBaseInfoGeneratorQueryService.class);
        //删除过期的兑换信息
        //RedisSortedSetDao daoG = new RedisSortedSetDao(RedisServerConstants.statistics_goodsSerial);
        //RedisDatabase baseG = new RedisDatabase(RedisServerConstants.statistics_goodsSerial);

        RedisDatabase goodsSerialBase = new RedisDatabase(RedisServerConstants.statistics_goodsSerial);
        RedisSortedSetDao goodsSerialDao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsSerial);
        RedisDatabase goodsCategoryBase = new RedisDatabase(RedisServerConstants.statistics_goodsCategory);
        RedisSortedSetDao goodsCategoryDao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsCategory);
        RedisDatabase goodsBrandBase = new RedisDatabase(RedisServerConstants.statistics_goodsBrand);
        RedisSortedSetDao goodsBrandDao = new RedisSortedSetDao(RedisServerConstants.statistics_goodsBrand);

        RedisDatabase[] redisBases = { goodsSerialBase, goodsCategoryBase, goodsBrandBase };
        RedisSortedSetDao[] redisDaos = { goodsSerialDao, goodsCategoryDao, goodsBrandDao };

        for (int i = 0; i < 3; i++)
        {
            Set<String> gKeys = redisBases[i].keys("*_E_*");
            Map<String, String> goodsIds = new HashMap<String, String>();
            for (String key : gKeys)
            {
                String[] split = key.split("_");
                goodsIds.put(split[0] + "_" + split[1], key);
            }
            if (goodsIds.size() > 0)
            {
                for (Map.Entry<String, String> entry : goodsIds.entrySet())
                {
                    GoodsBaseInfoExample example = new GoodsBaseInfoExample();
                    com.gooagoo.entity.generator.goods.GoodsBaseInfoExample.Criteria criteria = example.createCriteria();
                    String[] split = entry.getKey().split("_");
                    criteria.andShopIdEqualTo(split[0]);
                    criteria.andItemSerialEqualTo(split[1]);
                    List<GoodsBaseInfo> list = goodsService.selectByExample(example);
                    for (GoodsBaseInfo goods : list)
                    {
                        String goodsId = goods.getGoodsId();
                        ShopIntegralExample exampleInte = new ShopIntegralExample();
                        Criteria criteriaInte = exampleInte.createCriteria();
                        criteriaInte.andIntegralTradeIdEqualTo(goodsId);
                        List<ShopIntegral> list2 = integralService.selectByExample(exampleInte);
                        for (ShopIntegral integral : list2)
                        {
                            Date tradeEndTime = integral.getTradeEndTime();
                            if (tradeEndTime.before(new Date()))
                            {
                                //删除
                                redisBases[i].del(entry.getValue());
                                redisDaos[i].delElement("Interaction", entry.getValue());
                            }
                        }

                    }
                }
            }

            RedisSortedSetDao daoC = new RedisSortedSetDao(RedisServerConstants.statistics_coupon);
            RedisDatabase baseC = new RedisDatabase(RedisServerConstants.statistics_coupon);
            Set<String> cKeys = baseC.keys("*_E_*");
            Map<String, String> couponIds = new HashMap<String, String>();
            for (String key : cKeys)
            {
                String[] split = key.split("_");
                couponIds.put(split[0], key);
            }
            if (couponIds.size() > 0)
            {
                //在shop_integral表中查询活动id看是否过期
                for (Map.Entry<String, String> entry : couponIds.entrySet())
                {
                    ShopIntegralExample example = new ShopIntegralExample();
                    Criteria criteria = example.createCriteria();
                    criteria.andIntegralTradeIdEqualTo(entry.getKey());
                    List<ShopIntegral> list = integralService.selectByExample(example);
                    for (ShopIntegral integral : list)
                    {
                        Date tradeEndTime = integral.getTradeEndTime();
                        if (tradeEndTime.before(new Date()))
                        {
                            //删除
                            baseC.del(entry.getValue());
                            daoC.delElement("Interaction", entry.getValue());
                        }
                    }
                }
            }
        }
    }
}
