package com.gooagoo.trans.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.member.integral.IntegralQueryService;
import com.gooagoo.api.generator.query.member.MemberCardGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.generator.member.MemberCard;
import com.gooagoo.entity.generator.member.MemberCardExample;
import com.gooagoo.trans.api.MemberManageTransService;
import com.gooagoo.trans.entity.gtsb02.transform.Membercard;
import com.gooagoo.trans.entity.gtsb02.transform.ShopMemberCardsRoot;
import com.gooagoo.trans.entity.gtsb03.transform.GetUserIntegralRoot;
import com.google.gson.Gson;

@Service
public class MemberManageTransServiceImpl implements MemberManageTransService
{
    @Autowired
    private MemberCardGeneratorQueryService memberCardGeneratorQueryService;
    @Autowired
    private IntegralQueryService integralQueryService;

    @Override
    public ShopMemberCardsRoot getShopMemberCards(String shopId, String ctimestamp) throws Exception
    {
        GooagooLog.info("getShopMemberCards-->入参:shopId=" + shopId + ",ctimestamp" + ctimestamp);
        //1.查询商家会员卡基本信息
        MemberCardExample memberCardExample = new MemberCardExample();
        memberCardExample.createCriteria().andShopIdEqualTo(shopId).andCTimeStampGreaterThan(TimeUtils.convertStringToDate(ctimestamp));
        List<MemberCard> memberCardList = this.memberCardGeneratorQueryService.selectByExample(memberCardExample);

        GooagooLog.debug("根据shopId=" + shopId + ",ctimestamp >" + ctimestamp + "查询到的商家会员卡信息为：\n" + new Gson().toJson(memberCardList));
        List<Membercard> resultMembercardList = null;
        if (CollectionUtils.isNotEmpty(memberCardList))
        {
            //2.封装返回数据
            resultMembercardList = new ArrayList<Membercard>();
            for (MemberCard temp : memberCardList)
            {

                Membercard membercard = new Membercard();
                membercard.setCardid(temp.getCardId());
                membercard.setCardname(temp.getCardName());
                membercard.setCardtype(temp.getCardType());
                membercard.setCardurl(temp.getCardUrl());
                membercard.setCtimestamp(TimeUtils.convertDateToString(temp.getCTimeStamp(), TimeUtils.FORMAT1));//时间戳，格式"yyyy-MM-dd HH:mm:ss"
                membercard.setIsdel(temp.getIsDel());
                membercard.setIsphysical(temp.getCardType2());
                membercard.setShopid(temp.getShopId());
                resultMembercardList.add(membercard);
            }
        }
        ShopMemberCardsRoot root = new ShopMemberCardsRoot();
        root.setMembercard(resultMembercardList);
        root.setResult("true");
        return root;
    }

    @Override
    public GetUserIntegralRoot getUserIntegral(String shopId, String userId) throws Exception
    {
        GooagooLog.info("getUserIntegral-->入参:shopId=" + shopId + ",userId" + userId);

        //1.查询用户积分
        String integral = this.integralQueryService.findIntegral(userId, shopId);//获取用户积分
        GooagooLog.debug("查询到的用户可用积分为：" + integral);

        //2.封装返回数据
        GetUserIntegralRoot root = new GetUserIntegralRoot();
        root.setUseableintegralnumber(integral != null ? integral : "0");
        root.setResult("true");
        return root;
    }

}
