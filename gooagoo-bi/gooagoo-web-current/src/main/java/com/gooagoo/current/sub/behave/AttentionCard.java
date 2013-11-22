package com.gooagoo.current.sub.behave;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.gooagoo.api.business.core.user.behave.UserLastTimeCoreService;
import com.gooagoo.api.generator.query.member.MemberOfCardGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.current.constants.DispatcherConstants;
import com.gooagoo.entity.business.log.BehaveLog;
import com.gooagoo.entity.generator.behave.UserLastTime;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.entity.generator.member.MemberOfCardExample;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.intelligence.common.log.GooagooLog;
import com.gooagoo.intelligence.internalBus.Customer;
import com.gooagoo.intelligence.internalBus.Message;
import com.gooagoo.intelligence.utils.SpringBeanUtils;
import com.google.gson.Gson;

@Message(DispatcherConstants.attention)
public class AttentionCard implements Customer
{
    ShopInfoGeneratorQueryService shopInfoGeneratorQueryService = SpringBeanUtils.getBean(ShopInfoGeneratorQueryService.class);
    MemberOfCardGeneratorQueryService memberOfCardGeneratorQueryService = SpringBeanUtils.getBean(MemberOfCardGeneratorQueryService.class);
    UserLastTimeCoreService userLastTimeCoreService = SpringBeanUtils.getBean(UserLastTimeCoreService.class);

    @Override
    public void message(Object message)
    {
        GooagooLog.debug("启动任务 AttentionCard");
        BehaveLog behaveLog = (BehaveLog) message;

        //查询商家信息

        ShopInfo shopInfo = this.shopInfoGeneratorQueryService.selectByPrimaryKey(behaveLog.getShopId());
        GooagooLog.debug("查询商家信息" + new Gson().toJson(shopInfo));

        //查询会员卡与用户关联表
        MemberOfCardExample memberOfCardExample = new MemberOfCardExample();
        memberOfCardExample.createCriteria().andShopIdEqualTo(behaveLog.getShopId()).andUserIdEqualTo(behaveLog.getUserId()).andIsDelEqualTo("N");
        List<MemberOfCard> memberOfCardList = this.memberOfCardGeneratorQueryService.selectByExample(memberOfCardExample);
        GooagooLog.debug("查询会员卡与用户关联表信息" + new Gson().toJson(memberOfCardList));
        if (CollectionUtils.isNotEmpty(memberOfCardList))
        {
            //向用户足迹表插入数据
            UserLastTime userLastTime = new UserLastTime();
            userLastTime.setId(memberOfCardList.get(0).getScardno());
            userLastTime.setUserId(memberOfCardList.get(0).getUserId());
            userLastTime.setShopId(memberOfCardList.get(0).getShopId());
            userLastTime.setShopName(shopInfo.getShopName());
            userLastTime.setShopTypeRoot(shopInfo.getShopTypeRoot());
            userLastTime.setCardId(memberOfCardList.get(0).getCardId());
            userLastTime.setCardType2(memberOfCardList.get(0).getCardType2());
            userLastTime.setScardno(memberOfCardList.get(0).getScardno());
            userLastTime.setShoppingTime(new Date());
            userLastTime.setStrollTime(new Date());
            GooagooLog.debug("向用户足迹表插入数据信息" + new Gson().toJson(userLastTime));
            this.userLastTimeCoreService.insertSelective(userLastTime);
        }
    }
}
