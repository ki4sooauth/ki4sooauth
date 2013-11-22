package com.gooagoo.core.business.system.user.enterprise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.system.user.enterprise.ToolsManageCoreService;
import com.gooagoo.api.generator.core.shop.ShopToolListGeneratorCoreService;
import com.gooagoo.entity.generator.shop.ShopToolList;

@Service
public class ToolsManageCoreServiceImpl implements ToolsManageCoreService

{
    @Autowired
    private ShopToolListGeneratorCoreService shopToolListGeneratorCoreService;

    @Override
    public boolean updateTools(String id, String status) throws Exception
    {
        ShopToolList shopToolList = new ShopToolList();
        shopToolList.setId(id);
        shopToolList.setStatus(status);
        return this.shopToolListGeneratorCoreService.updateByPrimaryKeySelective(shopToolList);
    }

    @Override
    public boolean delTools(String id) throws Exception
    {
        ShopToolList shopToolList = new ShopToolList();
        shopToolList.setId(id);
        shopToolList.setIsDel("Y");
        return this.shopToolListGeneratorCoreService.updateByPrimaryKeySelective(shopToolList);
    }

}
