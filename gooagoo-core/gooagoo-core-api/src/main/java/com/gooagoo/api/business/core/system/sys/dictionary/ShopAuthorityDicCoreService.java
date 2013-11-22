package com.gooagoo.api.business.core.system.sys.dictionary;

import java.util.List;

import com.gooagoo.entity.generator.shop.ShopAuthority;

/**
 *  商家管理权限表管理
 */
public interface ShopAuthorityDicCoreService

{

    /**
     * 新增商家管理权限
     * @param shopAuthority
     * @return
     * @throws Exception
     */
    public boolean addShopAuthorityDic(ShopAuthority shopAuthority) throws Exception;

    /**
     * 编辑商家管理权限
     * @param shopAuthority
     * @return
     * @throws Exception
     */
    public boolean updateShopAuthorityDic(ShopAuthority shopAuthority) throws Exception;

    /**
     * 删除商家管理权限
     * @param authorityId
     * @return
     * @throws Exception
     */
    public boolean delShopAuthorityDic(String authorityId) throws Exception;

    /**
     * 批量新增商家管理权限（清空表数据，然后新增）
     * @param sysList
     * @return
     * @throws Exception
     */
    public boolean addAllShopAuthorityDic(List<ShopAuthority> sysList) throws Exception;

}
