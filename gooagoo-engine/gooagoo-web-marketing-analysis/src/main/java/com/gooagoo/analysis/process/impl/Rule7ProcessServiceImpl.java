package com.gooagoo.analysis.process.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.analysis.common.utils.MarketingUtils;
import com.gooagoo.analysis.common.utils.UserSendConstants;
import com.gooagoo.analysis.entity.Behave;
import com.gooagoo.analysis.entity.MarketingNotice;
import com.gooagoo.analysis.init.ResultRule;
import com.gooagoo.analysis.process.service.ProcessCommonService;
import com.gooagoo.analysis.process.service.ProcessService;
import com.gooagoo.api.business.core.member.membercard.AuditMemberCardCoreService;
import com.gooagoo.api.business.query.shop.cache.ShopCacheQueryService;
import com.gooagoo.api.generator.query.member.MemberCardGeneratorQueryService;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.entity.generator.marketing.RuleResult;
import com.gooagoo.entity.generator.member.MemberCard;
import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.entity.push.MobPushMsg;

/**
 * 会员卡
 */
@Service("rule7ProcessService")
public class Rule7ProcessServiceImpl implements ProcessService
{
    @Autowired
    private ProcessCommonService processCommonService;
    @Autowired
    private AuditMemberCardCoreService auditMemberCardCoreService;
    @Autowired
    private MemberCardGeneratorQueryService memberCardGeneratorQueryService;
    @Autowired
    private ShopCacheQueryService shopCacheQueryService;

    //    @Autowired
    //    private ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;

    @SuppressWarnings("unchecked")
    @Override
    public MarketingNotice<GooagooMessage<MobPushMsg>> doProcess(RuleInfo ruleInfo, Behave behave) throws Exception
    {
        RuleResult ruleResult = ResultRule.getRuleResult(ruleInfo.getRuleId());
        GooagooMessage<MobPushMsg> gooagooMessage = MarketingUtils.getGooagooMessage(behave);
        String content = UserSendConstants.NEWCARD;
        if (this.processCommonService.processMarketingUserLink(behave, ruleInfo))
        {
            if (this.auditMemberCardCoreService.specialApprovalMemberCard(behave.getShopId(), behave.getUserId(), ruleResult.getRuleResultValue(), null))
            {
                MemberCard memberCard = this.memberCardGeneratorQueryService.selectUnDelByPrimaryKey(ruleResult.getRuleResultValue());
                if (memberCard != null)
                {
                    MobPushMsg mobPushMsg = MarketingUtils.getMobPushMsg(behave);
                    //String shopName = this.shopInfoGeneratorQueryService.selectUnDelByPrimaryKey(behave.getShopId()).getShopName();
                    String shopName = this.shopCacheQueryService.findShopInfo(behave.getShopId()).get("shopName");
                    content = content.replaceAll("\\$\\{shopName\\}", shopName);
                    content = content.replaceAll("\\$\\{cardName\\}", memberCard.getCardName());
                    content = content.replaceAll("\\$\\{shopid\\}", memberCard.getShopId());
                    content = content.replaceAll("\\$\\{cardid\\}", memberCard.getCardId());
                    content = content.replaceAll("\\$\\{cardtype\\}", memberCard.getCardType());
                    mobPushMsg.setContent(content);
                    gooagooMessage.setContent(mobPushMsg);
                }
            }
            return (MarketingNotice<GooagooMessage<MobPushMsg>>) MarketingUtils.getMarketingNotice("push", gooagooMessage);
        }
        return null;
    }

}
