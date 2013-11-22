package com.gooagoo.query.business.member.card;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.member.card.UserCardQueryService;
import com.gooagoo.api.generator.query.member.IntegralInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberOfCardGeneratorQueryService;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.business.member.MemberOfCardBusiness;
import com.gooagoo.entity.generator.member.IntegralInfo;
import com.gooagoo.entity.generator.member.IntegralInfoExample;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.entity.generator.member.MemberOfCardExample;
import com.gooagoo.entity.generator.member.MemberOfCardExample.Criteria;

@Service
public class UserCardQueryServiceImpl implements UserCardQueryService
{

    @Autowired
    private MemberOfCardGeneratorQueryService memberOfCardGeneratorQueryService;

    @Autowired
    private IntegralInfoGeneratorQueryService integralInfoGeneratorQueryService;

    @Override
    public List<MemberOfCardBusiness> findUserMemberCardList(String userId, String shopId, String ctimestamp, Integer pageSize) throws Exception
    {
        List<MemberOfCardBusiness> memberOfCardBusinessList = null;
        MemberOfCardExample memberOfCardExample = new MemberOfCardExample();
        Criteria criteria = memberOfCardExample.createCriteria();
        criteria.andUserIdEqualTo(userId);
        if (StringUtils.hasText(ctimestamp))
        {
            criteria.andCTimeStampGreaterThan(TimeUtils.convertStringToDate(ctimestamp));
        }

        memberOfCardExample.setOrderByClause("c_time_stamp ASC");
        criteria.andIsDelEqualTo("N");
        if (pageSize != null)
        {
            memberOfCardExample.setPage(1, pageSize);
        }
        if (StringUtils.hasText(shopId))
        {
            criteria.andShopIdEqualTo(shopId);
        }
        List<MemberOfCard> memberOfCardList = this.memberOfCardGeneratorQueryService.selectByExample(memberOfCardExample);
        if (CollectionUtils.isNotEmpty(memberOfCardList))
        {
            memberOfCardBusinessList = new ArrayList<MemberOfCardBusiness>();
            for (MemberOfCard memberOfCard : memberOfCardList)
            {
                MemberOfCardBusiness memberOfCardBusiness = new MemberOfCardBusiness();
                memberOfCardBusiness.setMemberOfCard(memberOfCard);
                memberOfCardBusiness.setScardnoQrUrl(UrlUtils.getBarUrl(memberOfCard.getScardno()));
                memberOfCardBusiness.setScardnoUrl(UrlUtils.getAudioUrl(memberOfCard.getScardno()));
                //查询可用积分
                IntegralInfoExample integralInfoExample = new IntegralInfoExample();
                integralInfoExample.createCriteria().andUserIdEqualTo(userId).andShopIdEqualTo(memberOfCard.getShopId()).andIsDelEqualTo("N");
                List<IntegralInfo> integralInfoList = this.integralInfoGeneratorQueryService.selectByExample(integralInfoExample);
                if (CollectionUtils.isNotEmpty(integralInfoList))
                {
                    IntegralInfo integralInfo = integralInfoList.get(0);
                    memberOfCardBusiness.setUseableIntegralNumber(integralInfo.getUseableIntegralNumber() != null ? integralInfo.getUseableIntegralNumber().toString() : "0");
                }
                memberOfCardBusinessList.add(memberOfCardBusiness);
            }
        }
        return memberOfCardBusinessList;
    }

    @Override
    public Integer countUserMemberCardList(String userId, String shopId) throws Exception
    {
        MemberOfCardExample memberOfCardExample = new MemberOfCardExample();
        Criteria criteria = memberOfCardExample.createCriteria();
        criteria.andUserIdEqualTo(userId).andIsDelEqualTo("N");
        if (StringUtils.hasText(shopId))
        {
            criteria.andShopIdEqualTo(shopId);
        }
        return this.memberOfCardGeneratorQueryService.countByExample(memberOfCardExample);
    }
}
