package com.googoo.batch.dispatcher.cache;

import java.util.List;

import com.gooagoo.api.generator.query.member.MemberOfCardGeneratorQueryService;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.entity.generator.member.MemberOfCardExample;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.internalBus.Dispatcher;
import com.gooagoo.intelligence.transferBox.Engine;
import com.gooagoo.intelligence.transferBox.Tyre;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.googoo.batch.constants.BatchTimeCnstants;
import com.googoo.batch.utils.Timestamp;

@Engine(BatchTimeCnstants.everyMinutes)
public class UserShop implements Tyre
{
    MemberOfCardGeneratorQueryService memberOfCardService = SpringBeanUtils.getBean(MemberOfCardGeneratorQueryService.class);

    @Override
    public void run()
    {
        GooagooLog.debug("启动任务 UserShop");
        int page = 1;
        int pageSize = 1000;
        Dispatcher dispatcher = new Dispatcher();
        MemberOfCardExample query = new MemberOfCardExample();
        query.createCriteria().andCTimeStampGreaterThanOrEqualTo(Timestamp.lastTime(Timestamp.MEMBEROFCARD));
        while (true)
        {
            query.setPage(page, pageSize);
            List<MemberOfCard> members = this.memberOfCardService.selectByExample(query);
            GooagooLog.debug("UserShop 查出的数据条目:" + members.size());
            page++;
            if (members != null && members.size() > 0)
            {
                dispatcher.send("members", members);
            }
            if (pageSize > members.size())
            {
                break;
            }
        }
        dispatcher.close();
    }
}
