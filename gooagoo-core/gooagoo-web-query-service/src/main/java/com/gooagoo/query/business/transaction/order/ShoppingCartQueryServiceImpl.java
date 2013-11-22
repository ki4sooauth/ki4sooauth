package com.gooagoo.query.business.transaction.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.query.transaction.order.ShoppingCartQueryService;
import com.gooagoo.api.generator.query.bill.ShoppingCartGeneratorQueryService;
import com.gooagoo.entity.generator.bill.ShoppingCart;
import com.gooagoo.entity.generator.bill.ShoppingCartExample;

@Service
public class ShoppingCartQueryServiceImpl implements ShoppingCartQueryService
{

    @Autowired
    private ShoppingCartGeneratorQueryService shoppingCartGeneratorQueryService;

    @Override
    public List<ShoppingCart> findShoppingCart(String userId, String shopEntityId) throws Exception
    {
        ShoppingCartExample shoppingCartExample = new ShoppingCartExample();
        shoppingCartExample.createCriteria().andUserIdEqualTo(userId).andShopEntityIdEqualTo(shopEntityId).andIsDelEqualTo("N");
        return this.shoppingCartGeneratorQueryService.selectByExample(shoppingCartExample);
    }

}
