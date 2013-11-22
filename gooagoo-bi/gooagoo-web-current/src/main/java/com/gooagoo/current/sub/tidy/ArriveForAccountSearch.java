package com.gooagoo.current.sub.tidy;

import com.gooagoo.bi.entity.analysisUser.AnalysisAccount;
import com.gooagoo.bi.entity.position.BehaviorGeneral;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.current.tools.MongoAccountUtils;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.constants.RedisServerConstants;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.redis.data.RedisHashDao;

@Message(DispatcherConstants.store)
public class ArriveForAccountSearch implements Customer
{
    RedisHashDao redisHashDao = new RedisHashDao(RedisServerConstants.business_user);

    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 ArriveForAccountSearch");

        BehaviorGeneral general = (BehaviorGeneral) message;
        String shopId = general.getShopId();
        String mac = general.getMacAddress();
        MongoAccountUtils accountUtils = new MongoAccountUtils();
        AnalysisAccount account = accountUtils.buildByMac(shopId, mac);
        accountUtils.save(account);
    }
}
