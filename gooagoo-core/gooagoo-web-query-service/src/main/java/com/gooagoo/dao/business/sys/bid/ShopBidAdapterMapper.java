package com.gooagoo.dao.business.sys.bid;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.sys.ShopBid;

public interface ShopBidAdapterMapper
{
    /**
     * 通过商家编号获取商家竞拍历史数量(过滤重复的竞拍编码)
     * @param shopId 商家编号
     * @return Integer
     */
    public Integer countShopBidDetailInfoByShopId(@Param("shopId") String shopId);

    /**
     * 通过商家编号获取商家竞拍历史详细信息(过滤重复的竞拍编码)
     * @param shopId 商家编号
     * @param Integer pageIndex
     * @param Integer pageSize
     * @return
     */
    public List<ShopBid> findShopBidDetailInfoByShopId(@Param("shopId") String shopId, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

}
