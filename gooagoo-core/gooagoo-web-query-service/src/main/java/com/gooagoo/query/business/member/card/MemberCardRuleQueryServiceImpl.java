package com.gooagoo.query.business.member.card;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.member.card.MemberCardRuleQueryService;
import com.gooagoo.entity.generator.member.MemberCard;

@Service
public class MemberCardRuleQueryServiceImpl implements MemberCardRuleQueryService
{

    @Override
    public List<MemberCard> findMemberCardRule(String userId, String shopId) throws Exception
    {
        // TODO Auto-generated method stub
        return null;
    }

}
