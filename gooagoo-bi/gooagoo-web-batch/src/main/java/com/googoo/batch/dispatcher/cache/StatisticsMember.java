package com.googoo.batch.dispatcher.cache;

import java.util.List;

import com.gooagoo.api.generator.query.member.MemberOfCardGeneratorQueryService;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.entity.generator.member.MemberOfCardExample;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.transferBox.Tyre;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.gooagoo.intelligence.utils.TimeTag;
import com.gooagoo.redis.data.RedisSortedSetDao;

//@Engine(BatchTimeCnstants.integralPoint)
/**
 * 这个类的功能被PositionShop取代(测试)
 * @author 王宇
 *
 */
public class StatisticsMember implements Tyre
{
    MemberOfCardGeneratorQueryService memberOfCardService = SpringBeanUtils.getBean(MemberOfCardGeneratorQueryService.class);

    @Override
    public void run()
    {
        GooagooLog.debug("启动任务 StatisticsMember");
        TimeTag time = new TimeTag();
        RedisSortedSetDao member = new RedisSortedSetDao(RedisServerConstants.statistics_member);

        int page = 1;
        int pageSize = 1000;
        MemberOfCardExample query = new MemberOfCardExample();
        query.createCriteria().andIsDelEqualTo("N");
        while (true)
        {
            query.setPage(page, pageSize);
            List<MemberOfCard> members = this.memberOfCardService.selectByExample(query);
            GooagooLog.debug("StatisticsMember查出的数据条目:" + members.size());
            page++;
            if (members != null && members.size() > 0)
            {
                for (MemberOfCard memberOfCard : members)
                {
                    member.put(memberOfCard.getShopId() + "_A" + time.year() + time.month() + time.day() + time.hour(), memberOfCard.getCTimeStamp().getTime(), "0_" + memberOfCard.getUserId());
                    member.put(memberOfCard.getShopId() + "_M" + time.year() + time.month() + time.day() + time.hour(), memberOfCard.getCTimeStamp().getTime(), "0_" + memberOfCard.getUserId());
                }
            }
            if (pageSize > members.size())
            {
                break;
            }
        }
    }
}
