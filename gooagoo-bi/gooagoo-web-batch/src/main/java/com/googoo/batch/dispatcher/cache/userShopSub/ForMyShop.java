package com.googoo.batch.dispatcher.cache.userShopSub;

import java.util.Date;
import java.util.List;

import com.gooagoo.api.business.core.user.behave.UserLastTimeCoreService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.entity.generator.behave.UserLastTime;
import com.gooagoo.entity.generator.behave.UserLastTimeExample;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.SpringBeanUtils;

@Message("members")
public class ForMyShop implements Customer
{
    @SuppressWarnings("unchecked")
    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动 ForMyShop");
        UserLastTimeCoreService lastTimeService = SpringBeanUtils.getBean(UserLastTimeCoreService.class);
        ShopInfoGeneratorQueryService shopInfoService = SpringBeanUtils.getBean(ShopInfoGeneratorQueryService.class);
        List<MemberOfCard> members = (List<MemberOfCard>) message;
        for (MemberOfCard memberOfCard : members)
        {
            if ("Y".equals(memberOfCard.getIsDel()))
            {
                try
                {
                    UserLastTimeExample example = new UserLastTimeExample();
                    example.createCriteria().andScardnoEqualTo(memberOfCard.getScardno());
                    lastTimeService.physicalDeleteByExample(example);
                }
                catch (Exception e)
                {
                    GooagooLog.error("我的商家", e);
                }
            }
            else
            {
                try
                {
                    UserLastTime userLastTime = new UserLastTime();
                    userLastTime.setId(memberOfCard.getScardno());//自动编号，UUID
                    userLastTime.setUserId(memberOfCard.getUserId());//用户id
                    userLastTime.setShopId(memberOfCard.getShopId());//商家id
                    ShopInfo shopInfo = shopInfoService.selectByPrimaryKey(memberOfCard.getShopId());
                    userLastTime.setShopName(shopInfo.getShopName());//商家名称
                    userLastTime.setShopTypeRoot(shopInfo.getShopTypeRoot());//商家类型
                    userLastTime.setCardId(memberOfCard.getCardId());//会员卡id
                    userLastTime.setCardType2(memberOfCard.getCardType2());//会员卡类型2，0-关注卡，1-电子卡，2-实体卡
                    userLastTime.setScardno(memberOfCard.getScardno());//会员卡音频编码
                    userLastTime.setShoppingTime(new Date());//最后一次购物时间
                    userLastTime.setStrollTime(new Date());//最后一次到店时间
                    try
                    {
                        lastTimeService.insertSelective(userLastTime);
                    }
                    catch (Exception e)
                    {
                        GooagooLog.debug("user_last_time 表中已存在记录" + memberOfCard.getScardno());
                    }
                }
                catch (Exception e)
                {
                    GooagooLog.error("我的商家", e);
                }
            }
        }

    }
}
