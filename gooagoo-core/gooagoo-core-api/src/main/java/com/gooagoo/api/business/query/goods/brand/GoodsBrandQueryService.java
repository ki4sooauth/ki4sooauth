package com.gooagoo.api.business.query.goods.brand;

import java.util.List;

import com.gooagoo.entity.generator.goods.GoodsBrand;

/**
 * 商品品牌接口
 */
public interface GoodsBrandQueryService
{

    /**
     * 根据商家编号和实体店编号获取品牌列表(去重)
     * @param shopId
     * @param shopEntityId
     * @param parentCategoryId
     * @return
     * @throws Exception
     */
    public List<GoodsBrand> findDistinctGoodsBrandList(String shopId, String shopEntityId) throws Exception;

    /**
     * 查询商家品牌（按品牌编码、品牌名称去重）
     * @param shopId
     * @param shopEntityId
     * @param brandId
     * @param brandName 模糊查询
     * @return 按品牌品类编码、品牌名称
     */
    public List<GoodsBrand> findDistinctGoodsBrand(String shopId, String shopEntityId, String brandId, String brandName, Integer pageIndex, Integer pageSize);

    /**
     * 查询商家品牌count（按品牌编码、品牌名称去重）
     * @param shopId
     * @param shopEntityId
     * @param brandId
     * @param brandName 模糊查询
     * @return 按品牌编码、品牌名称
     */
    public int countDistinctGoodsBrand(String shopId, String shopEntityId, String brandId, String brandName);
}
