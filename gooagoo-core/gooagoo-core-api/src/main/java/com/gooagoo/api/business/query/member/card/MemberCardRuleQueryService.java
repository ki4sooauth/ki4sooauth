package com.gooagoo.api.business.query.member.card;

import java.util.List;

import com.gooagoo.entity.generator.member.MemberCard;

public interface MemberCardRuleQueryService
{

    /**
     *  商家查询发卡规则详细信息
     * @param userId
     * @param shopId 
     * @return List<MemberCard> 
     * @throws Exception
     */
    public List<MemberCard> findMemberCardRule(String userId, String shopId) throws Exception;

}
