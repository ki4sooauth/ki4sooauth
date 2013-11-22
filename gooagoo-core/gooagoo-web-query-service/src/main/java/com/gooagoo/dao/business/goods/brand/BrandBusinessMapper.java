package com.gooagoo.dao.business.goods.brand;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.goods.GoodsBrand;

/**
 * 品牌
*/
public interface BrandBusinessMapper
{
    /**
     * 根据商家编号和实体店编号获取品牌列表(去重)
     * @param shopId
     * @param shopEntityId
     * @return
     */
    public List<GoodsBrand> findDistinctGoodsBrandList(@Param("shopId") String shopId, @Param("shopEntityId") String shopEntityId);

    /**
     * 查询品牌列表（按品牌编码、品牌名称去重）
     * @param shopId
     * @param shopEntityId
     * @param brand_id
     * @param brand_name 模糊查询
     * @return
     */
    public List<GoodsBrand> findDistinctGoodsBrand(@Param("shopId") String shopId, @Param("shopEntityId") String shopEntityId, @Param("brandId") String brandId, @Param("brandName") String brandName, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    /**
     * 获取品牌数量(按品牌编码、品牌名称去重)
     * @param shopId
     * @param shopEntityId
     * @param brand_id
     * @param brand_name 模糊查询
     * @return
     */
    public int countDistinctGoodsBrand(@Param("shopId") String shopId, @Param("shopEntityId") String shopEntityId, @Param("brandId") String brandId, @Param("brandName") String brandName);
}
