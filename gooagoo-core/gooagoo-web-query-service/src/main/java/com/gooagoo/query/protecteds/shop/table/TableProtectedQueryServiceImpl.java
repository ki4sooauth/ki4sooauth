package com.gooagoo.query.protecteds.shop.table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.shop.ShopTableInfoGeneratorQueryService;
import com.gooagoo.api.protecteds.query.shop.table.TableProtectedQueryService;
import com.gooagoo.entity.generator.shop.ShopTableInfoExample;

@Service
public class TableProtectedQueryServiceImpl implements TableProtectedQueryService
{

    @Autowired
    private ShopTableInfoGeneratorQueryService shopTableInfoGeneratorQueryService;

    @Override
    public String getTableTypeSum(String shopEntityId, String tableTypeCode)
    {
        ShopTableInfoExample shopTableInfoExample = new ShopTableInfoExample();
        shopTableInfoExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andTableTypeCodeEqualTo(tableTypeCode).andIsDelEqualTo("N");
        Integer tableTypeSum = this.shopTableInfoGeneratorQueryService.countByExample(shopTableInfoExample);
        return tableTypeSum.toString();
    }

    @Override
    public String getCountByDeskStatus(String shopEntityId, String deskStatus)
    {
        ShopTableInfoExample shopTableInfoExample = new ShopTableInfoExample();
        shopTableInfoExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andStatusEqualTo(deskStatus).andIsDelEqualTo("N");
        Integer count = this.shopTableInfoGeneratorQueryService.countByExample(shopTableInfoExample);
        return count.toString();
    }

}
