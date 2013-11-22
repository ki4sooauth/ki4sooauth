package com.gooagoo.api.business.core.system.sys.dictionary;

import java.util.List;

import com.gooagoo.entity.generator.base.ShopInterfaceName;

/**
 *  商家平台界面名称表管理
 */
public interface ShopInterfaceNameDicCoreService

{

    /**
     * 新增商家平台界面名称
     * @param shopInterfaceName
     * @return
     * @throws Exception
     */
    public boolean addShopInterfaceNameDic(ShopInterfaceName shopInterfaceName) throws Exception;

    /**
     * 编辑商家平台界面名称
     * @param shopInterfaceName
     * @return
     * @throws Exception
     */
    public boolean updateShopInterfaceNameDic(ShopInterfaceName shopInterfaceName) throws Exception;

    /**
     * 删除商家平台界面名称
     * @param id
     * @return
     * @throws Exception
     */
    public boolean delShopInterfaceNameDic(String id) throws Exception;

    /**
     * 删除所有商家平台界面名称（物理删除）
     * @param id
     * @return
     * @throws Exception
     */
    public boolean addAllShopInterfaceNameDic(List<ShopInterfaceName> sysList) throws Exception;

}
