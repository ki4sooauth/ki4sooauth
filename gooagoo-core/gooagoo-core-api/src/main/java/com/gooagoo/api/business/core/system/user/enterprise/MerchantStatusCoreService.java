package com.gooagoo.api.business.core.system.user.enterprise;

/**
 *  商家状态管理
 */
public interface MerchantStatusCoreService

{

    /**
     * 编辑商家状态和审核备注
     * @param shopId 商家编号
     * @param shopStatus 商家状态
     * @param note 审核备注
     * @return
     * @throws Exception
     */
    public boolean updateMerchantStatus(String shopId, String shopStatus, String note) throws Exception;

}
