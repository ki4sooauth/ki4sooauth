package com.gooagoo.api.business.query.member.card;

import java.util.List;

import com.gooagoo.entity.business.member.MemberCardDetail;
import com.gooagoo.entity.generator.member.MemberCard;

public interface ShopCardQueryService
{

    /**
     *5.3.1. 会员卡列表查询
     * @param shopId
     * @return List<MemberCard>
     * @throws Exception
     */
    public List<MemberCard> findMemberCardList(String shopId) throws Exception;

    /**
     * 5.3.5. 查看会员卡详细信息
     * @param cardId
     * @return MemberCardDetail
     * @throws Exception
     */
    public MemberCardDetail findMemberCardDetail(String cardId) throws Exception;

}
