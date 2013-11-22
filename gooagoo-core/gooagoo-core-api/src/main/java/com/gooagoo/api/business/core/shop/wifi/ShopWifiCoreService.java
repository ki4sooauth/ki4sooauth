package com.gooagoo.api.business.core.shop.wifi;

import com.gooagoo.entity.generator.shop.ShopWifiinfo;

public interface ShopWifiCoreService
{
    /**
     * 添加wifi
     * @param shopWifiinfo
     * @return true/false
     * @throws Exception
     */
    public boolean addShopWifiinfo(ShopWifiinfo shopWifiinfo) throws Exception;

    /**
     * 修改wifi
     * @param shopWifiinfo
     * @return true/false
     * @throws Exception
     */
    public boolean updateShopWifiinfo(ShopWifiinfo shopWifiinfo) throws Exception;

    /**
     * 删除wifi
     * @param Id
     * @return true/false
     * @throws Exception
     */
    public boolean deleteShopWifiinfo(String Id) throws Exception;

}
