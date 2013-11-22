package com.gooagoo.current.sub.behave;

import com.gooagoo.api.generator.query.marketing.CryoutInfoGeneratorQueryService;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.current.tools.UserTools;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.generator.marketing.CryoutInfo;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.gooagoo.intelligence.utils.StringUtils;

/**
 * 用户 发生过关系 的商家
 * @author 王宇
 *
 */
@Message({ DispatcherConstants.browse })
public class InteractionCryout implements Customer
{
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 InteractionCryout");
        BehaveLog behaveLog = (BehaveLog) message;
        String ids = behaveLog.getObjectValue();
        String value = UserTools.account(behaveLog); //用户 有userId,mac和IP三种
        String source = behaveLog.getSource();
        if ("Y".equals(behaveLog.getObjectType()) && StringUtils.hasText(ids, value, source))
        {
            CryoutInfoGeneratorQueryService cryoutInfoService = SpringBeanUtils.getBean(CryoutInfoGeneratorQueryService.class);
            String userId = behaveLog.getUserId();
            String[] arrIds = ids.split(",");
            for (String id : arrIds)
            {
                CryoutInfo cryoutInfo = cryoutInfoService.selectByPrimaryKey(id);
                InteractionGeneral.put(cryoutInfo.getShopId(), source, value, "A");
                InteractionGeneral.put(cryoutInfo.getShopId(), "*", value, "A");
                if (UserTools.isMember(userId, cryoutInfo.getShopId()))
                {
                    InteractionGeneral.put(cryoutInfo.getShopId(), source, value, "M");
                    InteractionGeneral.put(cryoutInfo.getShopId(), "*", value, "M");
                }
                else
                {
                    InteractionGeneral.put(cryoutInfo.getShopId(), source, value, "N");
                    InteractionGeneral.put(cryoutInfo.getShopId(), "*", value, "N");
                }
            }
        }
    }
}
