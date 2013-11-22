package com.gooagoo.current.sub.behave;

import com.gooagoo.bi.entity.position.BehaviorGeneral;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.current.tools.UserTools;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;

/**
 * 用户 发生过关系 的商家
 * @author 王宇
 *
 */
@Message({ DispatcherConstants.store })
public class InteractionStore implements Customer
{
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 InteractionActive");
        BehaviorGeneral behave = (BehaviorGeneral) message;
        String value = UserTools.account(behave.getUserId(), behave.getMacAddress(), null);

        String userId = behave.getUserId();
        String shopId = behave.getShopId();
        InteractionGeneral.put(shopId, "4", value, "A");
        InteractionGeneral.put(shopId, "*", value, "A");
        if (UserTools.isMember(userId, shopId))
        {
            InteractionGeneral.put(shopId, "4", value, "M");
            InteractionGeneral.put(shopId, "*", value, "M");
        }
        else
        {
            InteractionGeneral.put(shopId, "4", value, "N");
            InteractionGeneral.put(shopId, "*", value, "N");
        }

    }
}
