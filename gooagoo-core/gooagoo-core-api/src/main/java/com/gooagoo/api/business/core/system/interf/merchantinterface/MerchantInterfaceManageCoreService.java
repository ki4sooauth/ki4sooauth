package com.gooagoo.api.business.core.system.interf.merchantinterface;

import com.gooagoo.entity.generator.sys.ShopInterfaceInfo;

/**
 * 商家接口管理
 */
public interface MerchantInterfaceManageCoreService

{

    /**
     * 分配商家接口地址（输入域名）
     * @param url
     * @param shopId 商家ID
     * @return
     * @throws Exception
     */
    public boolean allotInterface(String url, String shopId) throws Exception;

    /**
     * 编辑商家接口地址信息
     * @param shopInterfaceInfo
     * @return
     * @throws Exception
     */
    public boolean updateInterface(ShopInterfaceInfo shopInterfaceInfo) throws Exception;

}
