package com.googoo.batch.dispatcher.cache.userShopSub;

import java.util.List;

import com.gooagoo.bi.entity.analysisUser.AnalysisAccount;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.googoo.batch.utils.MongoAccountUtils;

@Message("members")
public class AccountMember implements Customer
{
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动 AccountMember");
        List<MemberOfCard> members = (List<MemberOfCard>) message;
        for (MemberOfCard memberOfCard : members)
        {
            MongoAccountUtils accountUtils = new MongoAccountUtils();
            AnalysisAccount account = accountUtils.buildByCard(memberOfCard);
            accountUtils.save(account);
        }
    }
}
