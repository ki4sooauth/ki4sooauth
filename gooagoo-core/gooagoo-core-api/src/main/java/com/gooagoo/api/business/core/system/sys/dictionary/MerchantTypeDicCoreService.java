package com.gooagoo.api.business.core.system.sys.dictionary;

import java.util.List;
import com.gooagoo.entity.generator.base.ShopType;

/**
 *  商家类型字典表管理
 */
public interface MerchantTypeDicCoreService

{

    /**
     * 新增商家类型
     * @param shopType
     * @return
     * @throws Exception
     */
    public boolean addMerchantTypeDic(ShopType shopType) throws Exception;

    /**
     * 编辑商家类型
     * @param shopType
     * @return
     * @throws Exception
     */
    public boolean updateMerchantTypeDic(ShopType shopType) throws Exception;

    /**
     * 删除商家类型
     * @param shopTypeId
     * @return
     * @throws Exception
     */
    public boolean delMerchantTypeDic(String shopTypeId) throws Exception;

    /**
     * 批量新增商家类型（清空表数据，然后新增）
     * @param sysList
     * @return
     * @throws Exception
     */
    public boolean addAllMerchantTypeDic(List<ShopType> sysList) throws Exception;

}
