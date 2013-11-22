package com.gooagoo.current.sub.behave;

import com.gooagoo.bi.entity.bill.Bill;
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
@Message({ DispatcherConstants.bill })
public class InteractionBill implements Customer
{
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 InteractionGoods");
        Bill bill = (Bill) message;
        String shopId = bill.getOrderInfo().getShopId();
        String userId = bill.getOrderInfo().getUserId();
        String value = UserTools.account(userId, null, null);
        String source = bill.getSource();

        InteractionGeneral.put(shopId, source, value, "A");
        InteractionGeneral.put(shopId, "*", value, "A");
        if (UserTools.isMember(userId, shopId))
        {
            InteractionGeneral.put(shopId, source, value, "M");
            InteractionGeneral.put(shopId, "*", value, "M");
        }
        else
        {
            InteractionGeneral.put(shopId, source, value, "N");
            InteractionGeneral.put(shopId, "*", value, "N");
        }
    }
}
