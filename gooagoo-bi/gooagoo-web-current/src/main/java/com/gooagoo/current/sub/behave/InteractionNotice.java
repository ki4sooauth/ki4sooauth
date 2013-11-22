package com.gooagoo.current.sub.behave;

import com.gooagoo.api.generator.query.marketing.NoticeInfoGeneratorQueryService;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.current.tools.UserTools;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.generator.marketing.NoticeInfo;
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
@Message({ DispatcherConstants.browse, })
public class InteractionNotice implements Customer
{
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 InteractionNotice");
        BehaveLog behaveLog = (BehaveLog) message;
        String ids = behaveLog.getObjectValue();
        String value = UserTools.account(behaveLog); //用户 有userId,mac和IP三种
        String source = behaveLog.getSource();
        if ("N".equals(behaveLog.getObjectType()) && StringUtils.hasText(ids, value, source))
        {
            NoticeInfoGeneratorQueryService noticeInfoService = SpringBeanUtils.getBean(NoticeInfoGeneratorQueryService.class);
            String[] arrIds = ids.split(",");
            String userId = behaveLog.getUserId();
            for (String id : arrIds)
            {
                NoticeInfo noticeInfo = noticeInfoService.selectByPrimaryKey(id);
                InteractionGeneral.put(noticeInfo.getShopId(), source, value, "A");
                InteractionGeneral.put(noticeInfo.getShopId(), "*", value, "A");
                if (UserTools.isMember(userId, noticeInfo.getShopId()))
                {
                    InteractionGeneral.put(noticeInfo.getShopId(), source, value, "M");
                    InteractionGeneral.put(noticeInfo.getShopId(), "*", value, "M");
                }
                else
                {
                    InteractionGeneral.put(noticeInfo.getShopId(), source, value, "N");
                    InteractionGeneral.put(noticeInfo.getShopId(), "*", value, "N");
                }
            }

        }
    }
}
