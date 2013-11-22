package com.gooagoo.api.business.core.member.membercard;

import com.gooagoo.entity.generator.member.MemberCard;

public interface MemberCardCoreService
{
    /****
     * 5.3.2. 商家新增会员卡
     * @param memberCard
     * @return true/false
     * @throws Exception
     */
    public boolean addMemberCard(MemberCard memberCard) throws Exception;

    /****
     * 5.3.3. 商家编辑会员卡
     * @param memberCard
     * @return true/false
     * @throws Exception
     */
    public boolean updateMemberCard(MemberCard memberCard) throws Exception;

    /****
     * 5.3.4. 商家删除会员卡
     * @param cardId
     * @return true/false
     * @throws Exception
     */
    public boolean deleteMemberCard(String cardId) throws Exception;

    /**
     * 审核会员卡
     * @param cardId
     * @param status
     * @param note
     * @return
     * @throws Exception
     */
    public boolean reviewedMemberCard(String cardId, String status, String note) throws Exception;

    /**
     * 发布会员卡
     * @param cardId
     * @return
     * @throws Exception
     */
    public boolean publishMemberCard(String cardId) throws Exception;
}
