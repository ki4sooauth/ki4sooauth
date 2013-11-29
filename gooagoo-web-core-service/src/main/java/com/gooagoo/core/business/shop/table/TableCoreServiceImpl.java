package com.gooagoo.core.business.shop.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.shop.table.TableCoreService;
import com.gooagoo.api.generator.core.shop.ShopTableInfoGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.shop.ShopTableInfo;

@Service
public class TableCoreServiceImpl implements TableCoreService
{
    @Autowired
    private ShopTableInfoGeneratorCoreService shopTableInfoGeneratorCoreService;

    @Override
    public boolean addTable(ShopTableInfo shopTableInfo) throws Exception
    {
        shopTableInfo.setIsDel("N");
        return this.shopTableInfoGeneratorCoreService.insertSelective(shopTableInfo);
    }

    @Override
    public boolean updateTable(ShopTableInfo shopTableInfo) throws Exception
    {
        return this.shopTableInfoGeneratorCoreService.updateByPrimaryKeySelective(shopTableInfo);
    }

    @Override
    public boolean deleteTable(String id) throws Exception
    {
        if (!StringUtils.hasText(id))
        {
            GooagooLog.warn("删除商家餐桌：Id为空");
            return false;
        }
        return this.shopTableInfoGeneratorCoreService.deleteByPrimaryKey(id);
    }
}
