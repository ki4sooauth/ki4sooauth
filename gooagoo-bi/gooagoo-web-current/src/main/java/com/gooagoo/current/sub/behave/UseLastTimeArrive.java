package com.gooagoo.current.sub.behave;

import com.gooagoo.api.generator.core.behave.UserLastTimeGeneratorCoreService;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.generator.behave.UserLastTime;
import com.gooagoo.entity.generator.behave.UserLastTimeExample;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.SpringBeanUtils;

@Message(DispatcherConstants.store)
public class UseLastTimeArrive implements Customer
{

    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 UseLastTimeArrive");
        UserLastTimeGeneratorCoreService userLastTimeService = SpringBeanUtils.getBean(UserLastTimeGeneratorCoreService.class);
        BehaveLog behaveLog = (BehaveLog) message;

        UserLastTimeExample example = new UserLastTimeExample();
        example.createCriteria().andUserIdEqualTo(behaveLog.getUserId()).andShopIdEqualTo(behaveLog.getShopId());

        UserLastTime newEntity = new UserLastTime();
        newEntity.setStrollTime(behaveLog.getCreateTime());
        userLastTimeService.updateByExampleSelective(newEntity, example);
    }
}
