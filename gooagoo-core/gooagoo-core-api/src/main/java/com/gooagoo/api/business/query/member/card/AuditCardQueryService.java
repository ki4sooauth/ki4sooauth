package com.gooagoo.api.business.query.member.card;


public interface AuditCardQueryService
{
    /**
     * 5.5.1. 商家查询全部会员卡审批列表
    5.5.2. 商家查询未处理会员卡审批列表
    5.5.3. 商家查询审核通过会员卡列表
    5.5.4. 商家查询审核不通过会员卡列表
     */
    public void findAuditMemberCardList(String shopId) throws Exception;

    /**
     * 5.5.6. 全部物理卡转换审批列表查询
    5.5.7. 未处理物理卡转换审批列表查询
    5.5.8. 审核通过物理卡转换审批列表查询
    5.5.9. 审核不通过物理卡转换审批列表查询
     * @param shopId
     * @throws Exception
     */
    public void findConvertPhysicalCardList(String shopId) throws Exception;

    /**
     * 5.5.12. 会员卡升级审批列表查询
     * @param shopId
     * @throws Exception
     */
    public void findMemberCardUpgradeList(String shopId) throws Exception;

}
