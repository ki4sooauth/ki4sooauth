package com.googoo.batch.dispatcher.cache.userShopSub;

import java.util.List;

import com.gooagoo.api.generator.query.shop.ShopPositionGeneratorQueryService;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.gooagoo.redis.data.RedisSortedSetDao;

@Message("members")
public class PositionShop implements Customer
{
    ShopPositionGeneratorQueryService positionService = SpringBeanUtils.getBean(ShopPositionGeneratorQueryService.class);

    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 PositionShop");
        RedisSortedSetDao member = new RedisSortedSetDao(RedisServerConstants.statistics_member);
        List<MemberOfCard> members = (List<MemberOfCard>) message;
        for (MemberOfCard memberOfCard : members)
        {
            member.put(memberOfCard.getShopId() + "_M", System.currentTimeMillis(), "0_" + memberOfCard.getUserId());
            member.put(memberOfCard.getShopId() + "_A", System.currentTimeMillis(), "0_" + memberOfCard.getUserId());
        }
    }
}
