package com.gooagoo.dao.generator.behave;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.behave.ShoppingPlanGoods;
import com.gooagoo.entity.generator.behave.ShoppingPlanGoodsExample;
import com.gooagoo.entity.generator.behave.ShoppingPlanGoodsKey;

public interface ShoppingPlanGoodsMapper
{

    public Integer countByExample(ShoppingPlanGoodsExample shoppingPlanGoodsExample);

    public List<ShoppingPlanGoods> selectByExample(ShoppingPlanGoodsExample shoppingPlanGoodsExample);

    public ShoppingPlanGoods selectByPrimaryKey(ShoppingPlanGoodsKey shoppingPlanGoodsKey);

    public Integer deleteByExample(ShoppingPlanGoodsExample shoppingPlanGoodsExample);

    public Integer deleteByPrimaryKey(ShoppingPlanGoodsKey shoppingPlanGoodsKey);

    public Integer insertSelective(ShoppingPlanGoods shoppingPlanGoods);

    public Integer updateAllByExample(@Param("record") ShoppingPlanGoods shoppingPlanGoods, @Param("example") ShoppingPlanGoodsExample shoppingPlanGoodsExample);

    public Integer updateByExampleSelective(@Param("record") ShoppingPlanGoods shoppingPlanGoods, @Param("example") ShoppingPlanGoodsExample shoppingPlanGoodsExample);

    public Integer updateByPrimaryKeySelective(ShoppingPlanGoods shoppingPlanGoods);

}
