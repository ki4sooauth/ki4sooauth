package com.gooagoo.dao.business.user.shoppingmatch;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.goods.GoodsBaseInfo;

public interface ShoppingMatchAdapterMapper
{

    /**
     * 按位置编号和商品名称模糊查询商品基本信息
     * @param positionId
     * @param goodsName
     * @return List<GoodsBaseInfo>
     */
    public List<GoodsBaseInfo> findShoppingMatchInfo(@Param("positionId") String positionId, @Param("goodsName") String goodsName);

}
