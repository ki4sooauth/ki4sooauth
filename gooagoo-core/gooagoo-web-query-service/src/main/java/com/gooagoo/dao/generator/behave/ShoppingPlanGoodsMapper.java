package com.gooagoo.dao.generator.behave;

import java.util.List;

import com.gooagoo.entity.generator.behave.ShoppingPlanGoods;
import com.gooagoo.entity.generator.behave.ShoppingPlanGoodsExample;
import com.gooagoo.entity.generator.behave.ShoppingPlanGoodsKey;

public interface ShoppingPlanGoodsMapper
{

    public Integer countByExample(ShoppingPlanGoodsExample shoppingPlanGoodsExample);

    public List<ShoppingPlanGoods> selectByExample(ShoppingPlanGoodsExample shoppingPlanGoodsExample);

    public ShoppingPlanGoods selectByPrimaryKey(ShoppingPlanGoodsKey shoppingPlanGoodsKey);

}
