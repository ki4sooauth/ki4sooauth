package com.googoo.batch.dispatcher.cache;

import java.util.List;

import com.gooagoo.api.generator.query.member.MemberBaseInfoGeneratorQueryService;
import com.gooagoo.bi.entity.analysisUser.AnalysisAccount;
import com.gooagoo.entity.generator.member.MemberBaseInfo;
import com.gooagoo.entity.generator.member.MemberBaseInfoExample;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.transferBox.Engine;
import com.gooagoo.intelligence.transferBox.Tyre;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.googoo.batch.constants.BatchTimeCnstants;
import com.googoo.batch.utils.MongoAccountUtils;
import com.googoo.batch.utils.Timestamp;

@Engine(BatchTimeCnstants.everyMinutes)
public class AccountPhysics implements Tyre
{
    MemberBaseInfoGeneratorQueryService queryService = SpringBeanUtils.getBean(MemberBaseInfoGeneratorQueryService.class);

    @Override
    public void run()
    {
        GooagooLog.debug("启动任务 AccountPhysics");
        int page = 1;
        int pageSize = 1000;
        MemberBaseInfoExample example = new MemberBaseInfoExample();
        example.createCriteria().andCTimeStampGreaterThanOrEqualTo(Timestamp.lastTime(Timestamp.USER_SHOP));
        while (true)
        {
            example.setPage(page, pageSize);
            List<MemberBaseInfo> members = this.queryService.selectByExample(example);
            GooagooLog.debug("AccountPhysics 查出的数据条目:" + members.size());
            for (MemberBaseInfo memberBaseInfo : members)
            {
                MongoAccountUtils accountUtils = new MongoAccountUtils();
                AnalysisAccount account = accountUtils.buildByMemberBaseInfo(memberBaseInfo);
                accountUtils.save(account);
            }
            page++;
            if (pageSize > members.size())
            {
                break;
            }
        }

    }

}
