package com.gooagoo.core.business.shop.wifi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.shop.wifi.ShopWifiCoreService;
import com.gooagoo.api.generator.core.shop.ShopWifiinfoGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.shop.ShopWifiinfo;

@Service
public class ShopWifiCoreServiceImpl implements ShopWifiCoreService
{
    @Autowired
    private ShopWifiinfoGeneratorCoreService shopWifiinfoGeneratorCoreService;

    @Override
    public boolean addShopWifiinfo(ShopWifiinfo shopWifiinfo) throws Exception
    {
        shopWifiinfo.setIsDel("N");
        return this.shopWifiinfoGeneratorCoreService.insertSelective(shopWifiinfo);
    }

    @Override
    public boolean updateShopWifiinfo(ShopWifiinfo shopWifiinfo) throws Exception
    {
        return this.shopWifiinfoGeneratorCoreService.updateByPrimaryKeySelective(shopWifiinfo);
    }

    @Override
    public boolean deleteShopWifiinfo(String id) throws Exception
    {
        if (!StringUtils.hasText(id))
        {
            GooagooLog.warn("删除商家wifi信息：Id为空");
            return false;
        }
        return this.shopWifiinfoGeneratorCoreService.deleteByPrimaryKey(id);
    }
}
