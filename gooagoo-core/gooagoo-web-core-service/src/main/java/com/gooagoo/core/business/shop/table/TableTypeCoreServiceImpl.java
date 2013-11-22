package com.gooagoo.core.business.shop.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.shop.table.TableTypeCoreService;
import com.gooagoo.api.generator.core.shop.ShopTableTypeManageGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.shop.ShopTableTypeManage;

@Service
public class TableTypeCoreServiceImpl implements TableTypeCoreService
{
    @Autowired
    private ShopTableTypeManageGeneratorCoreService shopTableTypeManageGeneratorCoreService;

    @Override
    public boolean addShopTableTypeManage(ShopTableTypeManage shopTableTypeManage) throws Exception
    {
        shopTableTypeManage.setIsDel("N");
        return this.shopTableTypeManageGeneratorCoreService.insertSelective(shopTableTypeManage);
    }

    @Override
    public boolean updateShopTableTypeManage(ShopTableTypeManage shopTableTypeManage) throws Exception
    {
        return this.shopTableTypeManageGeneratorCoreService.updateByPrimaryKeySelective(shopTableTypeManage);
    }

    @Override
    public boolean deleteShopTableTypeManage(String id) throws Exception
    {
        if (!StringUtils.hasText(id))
        {
            GooagooLog.warn("删除商家餐桌类型：Id为空");
            return false;
        }
        return this.shopTableTypeManageGeneratorCoreService.deleteByPrimaryKey(id);
    }
}
