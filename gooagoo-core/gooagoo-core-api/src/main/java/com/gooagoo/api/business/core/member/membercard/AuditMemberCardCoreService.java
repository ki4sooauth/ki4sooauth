package com.gooagoo.api.business.core.member.membercard;

import com.gooagoo.exception.business.card.CardAlreadyConvertedException;
import com.gooagoo.exception.business.card.CardAlreadyExistsException;
import com.gooagoo.exception.business.member.MemberIntegralNotEnoughException;

/***
 * 审核会员卡
 * @author Administrator
 *
 */
public interface AuditMemberCardCoreService
{
    /**
     * 会员卡审核操作
     * @param shopId
     * @param applicationId
     * @param status 审核状态(Y-通过，N-不通过)
     * @param note 审核备注
     * @return
     * @throws Exception
     */
    public boolean auditMemberCard(String applicationId, String status, String note) throws Exception;

    /****
     * 物理卡转换审批操作
     * @param shopId
     * @param applicationId
     * @param status 审核状态(Y-通过，N-不通过)
     * @param note 审核备注
     * @throws CardAlreadyConvertedException 物理卡已被转换异常
     * @throws CardAlreadyExistsException 会员卡已存在异常
     */
    public boolean auditConvertPhysicalCard(String applicationId, String status, String note) throws Exception;

    /****
     * 会员卡升级审批操作
     * @param cardUpInfoId
     * @param status 审核状态(Y-通过，N-不通过)
     * @param note 审核备注
     * @return true/false
     * @throws CardAlreadyExistsException 会员卡已存在异常
     * @throws MemberIntegralNotEnoughException 会员积分不足异常
     */
    public boolean auditMemberCardUpgrade(String cardUpInfoId, String status, String note) throws Exception;

    /****
     * 会员特批操作
     * @param shopId
     * @param userId
     * @param newCardId　新特批的卡id
     * @param oldCardId 当前拥有卡id
     * @return true/false
     * @throws Exception
     */
    public boolean specialApprovalMemberCard(String shopId, String userId, String newCardId, String oldCardId) throws Exception;

}
