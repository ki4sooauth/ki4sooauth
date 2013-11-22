package com.gooagoo.dao.business.goods.category;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.goods.GoodsCategory;

/**
 * 品类
*/
public interface CategoryBusinessMapper
{
    /**
     * 根据商家编号和实体店编号获取品类列表(去重)
     * @param shopId
     * @param shopEntityId
     * @return
     */
    public List<GoodsCategory> findDistinctGoodsCategoryList(@Param("shopId") String shopId, @Param("shopEntityId") String shopEntityId);

    /**
     * 查询商家品类（按品类编码、品类名称去重）
     * @param shopId
     * @param shopEntityId
     * @param categoryId
     * @param categoryName 模糊查询
     * @return 按品类编码、品类名称
     */
    public List<GoodsCategory> findDistinctGoodsCategory(@Param("shopId") String shopId, @Param("shopEntityId") String shopEntityId, @Param("categoryId") String categoryId, @Param("categoryName") String categoryName, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    /**
     * 根据商家编号和实体店编号获取品类列表(去重)
     * @param shopId
     * @param shopEntityId
     * @return
     */
    public int countDistinctGoodsCategory(@Param("shopId") String shopId, @Param("shopEntityId") String shopEntityId, @Param("categoryId") String categoryId, @Param("categoryName") String categoryName);

}
