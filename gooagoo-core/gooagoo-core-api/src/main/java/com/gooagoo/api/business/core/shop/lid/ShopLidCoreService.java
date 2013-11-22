package com.gooagoo.api.business.core.shop.lid;

import com.gooagoo.entity.generator.shop.ShopLidDetail;

public interface ShopLidCoreService
{

    /**
     * 修改lid详细
     * @param shopLidDetail
     * @return true/false
     * @throws Exception
     */
    public boolean updateShopLidDetail(ShopLidDetail shopLidDetail) throws Exception;

    /**
     * 批量删除lid基本信息
     * @param lidBases 多个用逗号分隔
     * @return true/false
     * @throws Exception
     */
    public boolean batchDeleteShopLidInfo(String lidBases) throws Exception;

}
