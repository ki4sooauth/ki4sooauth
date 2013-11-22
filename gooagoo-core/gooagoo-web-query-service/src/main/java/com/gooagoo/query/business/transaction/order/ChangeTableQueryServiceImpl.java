package com.gooagoo.query.business.transaction.order;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.transaction.order.ChangeTableQueryService;
import com.gooagoo.api.protecteds.query.shop.ShopProtectedQueryService;

@Service
public class ChangeTableQueryServiceImpl implements ChangeTableQueryService
{

    @Autowired
    private ShopProtectedQueryService shopProtectedQueryService;

    @Override
    public List<Map<String, String>> findExchangeTable(String mac, String shopEntityId, String ctimestamp) throws Exception
    {
        return this.shopProtectedQueryService.findByType(mac, shopEntityId, ctimestamp, "5");
    }

    @Override
    public List<Map<String, String>> findMergeTable(String mac, String shopEntityId, String ctimestamp) throws Exception
    {
        return this.shopProtectedQueryService.findByType(mac, shopEntityId, ctimestamp, "6");
    }

}
