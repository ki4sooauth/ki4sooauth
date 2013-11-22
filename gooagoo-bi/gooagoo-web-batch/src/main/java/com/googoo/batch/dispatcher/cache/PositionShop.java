package com.googoo.batch.dispatcher.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gooagoo.api.generator.query.shop.ShopPositionGeneratorQueryService;
import com.gooagoo.entity.generator.shop.ShopPosition;
import com.gooagoo.entity.generator.shop.ShopPositionExample;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.gooagoo.redis.data.RedisHashDao;
import com.googoo.batch.utils.Timestamp;

//@Engine(BatchTimeCnstants.everyHour)
public class PositionShop //implements Tyre
{
    ShopPositionGeneratorQueryService positionService = SpringBeanUtils.getBean(ShopPositionGeneratorQueryService.class);

    //@Override
    public void run()
    {
        GooagooLog.debug("启动任务 PositionShop");
        int page = 1;
        int pageSize = 1000;
        RedisHashDao hashDao = new RedisHashDao(RedisServerConstants.business_position);
        ShopPositionExample query = new ShopPositionExample();
        query.createCriteria().andCTimeStampGreaterThanOrEqualTo(Timestamp.lastTime(Timestamp.SHOP_POSITION));
        while (true)
        {
            query.setPage(page, pageSize);
            List<ShopPosition> positions = this.positionService.selectByExample(query);
            for (ShopPosition shopPosition : positions)
            {
                Map<String, String> position = new HashMap<String, String>();
                position.put("shopId", shopPosition.getShopId());
                position.put("shopEntityId", shopPosition.getShopEntityId());
                position.put("name", shopPosition.getPositionName());
                position.put("parentId", shopPosition.getParentPositionId());
                hashDao.set(shopPosition.getPositionId(), position);
            }
            page++;
            if (pageSize > positions.size())
            {
                break;
            }
        }
    }
}
