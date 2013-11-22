package com.gooagoo.analysis.process.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.analysis.common.utils.MarketingUtils;
import com.gooagoo.analysis.common.utils.UserSendConstants;
import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.analysis.entity.MarketingNotice;
import com.gooagoo.analysis.process.service.ProcessCommonService;
import com.gooagoo.analysis.process.service.ProcessService;
import com.gooagoo.api.business.query.shop.cache.ShopCacheQueryService;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.entity.push.MobPushMsg;

/**
 * 通知
 */
@Service("rule2ProcessService")
public class Rule2ProcessServiceImpl implements ProcessService
{
    @Autowired
    ProcessCommonService processCommonService;

    //    @Autowired
    //    ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;

    @Autowired
    ShopCacheQueryService shopCacheQueryService;

    @SuppressWarnings("unchecked")
    @Override
    public MarketingNotice<GooagooMessage<MobPushMsg>> doProcess(RuleInfo ruleInfo, Behave behave) throws Exception
    {
        GooagooMessage<MobPushMsg> gooagooMessage = MarketingUtils.getGooagooMessage(behave);
        String content = UserSendConstants.SHOPNOTICE;
        if (this.processCommonService.processMarketingUserLink(behave, ruleInfo))
        {
            MobPushMsg mobPushMsg = MarketingUtils.getMobPushMsg(behave);
            //String shopName = this.shopInfoGeneratorQueryService.selectUnDelByPrimaryKey(behave.getShopId()).getShopName();
            String shopName = this.shopCacheQueryService.findShopInfo(behave.getShopId()).get("shopName");
            content = content.replaceAll("\\$\\{shopName\\}", shopName).replaceAll("\\$\\{shopid\\}", behave.getShopId());
            mobPushMsg.setContent(content);
            gooagooMessage.setContent(mobPushMsg);
            return (MarketingNotice<GooagooMessage<MobPushMsg>>) MarketingUtils.getMarketingNotice("push", gooagooMessage);
        }
        return null;
    }
}
