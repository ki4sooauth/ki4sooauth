package com.gooagoo.current.sub.behave;

import com.gooagoo.api.business.query.marketing.activity.ActivityQueryService;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.current.tools.UserTools;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.business.marketing.ActivityDetail;
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
@Message({ DispatcherConstants.browse, DispatcherConstants.favorite })
public class InteractionActive implements Customer
{
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 InteractionActive");
        BehaveLog behaveLog = (BehaveLog) message;
        String id = behaveLog.getObjectValue();
        String value = UserTools.account(behaveLog); //用户 有userId,mac和IP三种
        String source = behaveLog.getSource();
        if ("A".equals(behaveLog.getObjectType()) && StringUtils.hasText(id, value, source))
        {
            String userId = behaveLog.getUserId();
            String shopId = getShopId(id);
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

    private String getShopId(String id)
    {
        try
        {
            ActivityQueryService activityQueryService = SpringBeanUtils.getBean(ActivityQueryService.class);
            ActivityDetail activityDetail = activityQueryService.findActivityDetail(id);
            String shopId = activityDetail.getShopInfo().getShopId();
            return shopId;
        }
        catch (Exception e)
        {
            GooagooLog.error("查询优惠凭证缓存出错 商品id:" + id, e);
        }
        return null;
    }
}
