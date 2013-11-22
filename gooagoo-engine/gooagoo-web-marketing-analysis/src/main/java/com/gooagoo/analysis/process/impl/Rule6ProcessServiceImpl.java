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
import com.gooagoo.api.business.core.user.favorite.FavoriteCoreService;
import com.gooagoo.api.generator.query.marketing.CouponGeneratorQueryService;
import com.gooagoo.entity.generator.behave.FavoriteInfo;
import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.entity.generator.marketing.RuleInfo;
import com.gooagoo.entity.generator.marketing.RuleResult;
import com.gooagoo.entity.message.GooagooMessage;
import com.gooagoo.entity.push.MobPushMsg;

/**
 * 优惠
 */
@Service("rule6ProcessService")
public class Rule6ProcessServiceImpl implements ProcessService
{
    @Autowired
    ProcessCommonService processCommonService;
    @Autowired
    FavoriteCoreService favoriteCoreService;
    @Autowired
    CouponGeneratorQueryService couponGeneratorQueryService;

    @SuppressWarnings("unchecked")
    @Override
    public MarketingNotice<GooagooMessage<MobPushMsg>> doProcess(RuleInfo ruleInfo, Behave behave) throws Exception
    {

        RuleResult ruleResult = ResultRule.getRuleResult(ruleInfo.getRuleId());
        GooagooMessage<MobPushMsg> gooagooMessage = MarketingUtils.getGooagooMessage(behave);
        String content = UserSendConstants.FAVORITE;
        if (this.processCommonService.processMarketingUserLink(behave, ruleInfo))
        {
            Coupon coupon = this.couponGeneratorQueryService.selectUnDelByPrimaryKey(ruleResult.getRuleResultValue());
            if (coupon != null)
            {
                FavoriteInfo favoriteInfo = new FavoriteInfo();
                favoriteInfo.setUserId(behave.getUserId());//用户编号
                favoriteInfo.setShopId(behave.getShopId());//商家编号
                favoriteInfo.setInfoTitle(coupon.getCouponName());//收藏标题，为优惠券、商品、活动的名称
                favoriteInfo.setInfoType("C");//收藏类型，参考通用字典表的favorite_type
                favoriteInfo.setInfoUrl(coupon.getCouponUrl());//收藏地址，为优惠券、商品、活动的地址
                favoriteInfo.setObjectId(coupon.getCouponId());//收藏的商品、活动的id，如果收藏的是优惠凭证，则是优惠凭证编号
                favoriteInfo.setSource(behave.getSource());//信息来源，参考通用字典表的info_source
                favoriteInfo.setCouponStatus("0");//优惠凭证状态，参考通用字典表的coupon_status
                favoriteInfo.setIsDel("N");//是否删除，Y-已删除，N-未删除
                if (this.favoriteCoreService.addFavorite(favoriteInfo))
                {
                    MobPushMsg mobPushMsg = MarketingUtils.getMobPushMsg(behave);
                    mobPushMsg.setContent(content);
                    gooagooMessage.setContent(mobPushMsg);
                    return (MarketingNotice<GooagooMessage<MobPushMsg>>) MarketingUtils.getMarketingNotice("push", gooagooMessage);
                }
            }
        }
        return null;
    }
}
