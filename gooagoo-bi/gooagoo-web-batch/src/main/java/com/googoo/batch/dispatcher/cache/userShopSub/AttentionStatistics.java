package com.googoo.batch.dispatcher.cache.userShopSub;

import java.util.List;

import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.redis.data.RedisSortedSetDao;

/**
 * 删除取消关注的会员
 * @author 王宇
 *
 */
@Message("members")
public class AttentionStatistics implements Customer
{
    @SuppressWarnings("unchecked")
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动 AttentionStatistics");
        RedisSortedSetDao sortedSetDao = new RedisSortedSetDao(RedisServerConstants.statistics_attention);
        List<MemberOfCard> members = (List<MemberOfCard>) message;
        for (MemberOfCard moc : members)
        {
            if ("Y".equals(moc.getIsDel()) && "0".equals(moc.getCardType2()))
            {
                sortedSetDao.delElement(moc.getShopId(), moc.getUserId());
                sortedSetDao.delElement(moc.getShopId() + "_M", moc.getUserId());//不方便确定来源
                sortedSetDao.delElement(moc.getShopId() + "_W", moc.getUserId());
            }
        }

    }

}
