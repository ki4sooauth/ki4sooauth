package com.gooagoo.api.business.core.system.user.enterprise;

/**
 *  商家LID管理
 */
public interface AllotLidCoreService
{
    /**
     * 分配Lid
     * @param lidBase LID基本信息
     * @param shopId 商家编号
     * @param shopEntityId 实体店编号
     * @return True/False
     * @throws Exception
     */
    public boolean allotjLid(String lidBase, String shopId, String shopEntityId) throws Exception;

    /**
     * 批量软删商家LID详细分配信息
     * @param lids LID多个用逗号分隔
     * @return True/False
     * @throws Exception
     */
    public boolean batchDeleteShopLidDetail(String lids) throws Exception;

}
