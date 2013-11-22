package com.gooagoo.current.sub.behave;

import java.util.Map;

import com.gooagoo.api.business.query.goods.cache.GoodsCacheQueryService;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.current.tools.UserTools;
import com.gooagoo.entity.business.log.BehaveLog;
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
public class InteractionGoods implements Customer
{
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 InteractionGoods");
        BehaveLog behaveLog = (BehaveLog) message;
        String id = behaveLog.getObjectValue();
        String value = UserTools.account(behaveLog); //用户 有userId,mac和IP三种
        String source = behaveLog.getSource();
        if ("G".equals(behaveLog.getObjectType()) && StringUtils.hasText(id, value, source))
        {
            String userId = behaveLog.getUserId();
            String shopId = getShopId(id);
            InteractionGeneral.put(shopId, source, value, "A");
            if (UserTools.isMember(userId, shopId))
            {
                InteractionGeneral.put(shopId, source, value, "M");
            }
            else
            {
                InteractionGeneral.put(shopId, source, value, "N");
            }
        }
    }

    private String getShopId(String goodsId)
    {
        try
        {
            GoodsCacheQueryService goodsCacheQueryService = SpringBeanUtils.getBean(GoodsCacheQueryService.class);
            Map<String, String> goods = goodsCacheQueryService.findGoodsInfo(goodsId);
            return goods.get("shopId");
        }
        catch (Exception e)
        {
            GooagooLog.error("查询商品缓存出错 商品id:" + goodsId, e);
        }
        return null;
    }
}
