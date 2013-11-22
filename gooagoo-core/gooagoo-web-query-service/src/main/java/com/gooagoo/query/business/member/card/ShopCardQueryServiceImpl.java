package com.gooagoo.query.business.member.card;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.member.card.ShopCardQueryService;
import com.gooagoo.api.generator.query.member.MemberCardGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.business.member.MemberCardDetail;
import com.gooagoo.entity.generator.member.MemberCard;
import com.gooagoo.entity.generator.member.MemberCardExample;

@Service
public class ShopCardQueryServiceImpl implements ShopCardQueryService
{
    @Autowired
    private MemberCardGeneratorQueryService memberCardGeneratorQueryService;

    @Override
    public List<MemberCard> findMemberCardList(String shopId) throws Exception
    {
        if (!StringUtils.hasText(shopId))
        {
            GooagooLog.warn("商家查询会员卡列表：shopId为空");
            return null;
        }
        MemberCardExample memberCardExample = new MemberCardExample();
        memberCardExample.createCriteria().andShopIdEqualTo(shopId).andIsDelEqualTo("N");
        this.memberCardGeneratorQueryService.selectByExample(memberCardExample);
        return null;
    }

    @Override
    public MemberCardDetail findMemberCardDetail(String cardId) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

}
