package com.gooagoo.dao.business.goods.info;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface GoodsInfoAdapterMapper
{
    /**
     * 按品类,商品名称,商家,区域编号查询营销活动信息
     * @param shopId 商家编号
     * @param goodsName 商品名称
     * @param positionId 区域编号categoryId
     * @param categoryIds 品类编号(多个逗号分隔)
     * @return
     */
    public List<String> findGoodsInfoByCategory(@Param("shopId") String shopId, @Param("goodsName") String goodsName, @Param("positionId") String positionId, @Param("categoryIdList") List<String> categoryIdList, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

}
