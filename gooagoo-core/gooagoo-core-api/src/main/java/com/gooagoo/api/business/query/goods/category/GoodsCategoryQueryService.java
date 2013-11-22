package com.gooagoo.api.business.query.goods.category;

import java.util.List;

import com.gooagoo.entity.generator.goods.GoodsCategory;
import com.gooagoo.exception.GooagooException;

/**
 * 商品品类
 */
public interface GoodsCategoryQueryService
{

    /**
     * 根据商家编号和实体店编号获取品类列表(去重)
     * @param shopId
     * @param shopEntityId
     * @return
     * @throws Exception
     */
    public List<GoodsCategory> findDistinctGoodsCategoryList(String shopId, String shopEntityId) throws Exception;

    /**
     * 查询从页结点至根结点的所有品类
     * @param goodsCategoryRoot
     * @param goodsCategoryLeaf
     * @return
     * @throws GooagooException
     */
    public List<GoodsCategory> findGoodsCategoryListByLeaf(String shopEntityId, String goodsCategoryRoot, String goodsCategoryLeaf);

    /**
     * 查询商家品类（按品类编码、品类名称去重）
     * @param shopId
     * @param shopEntityId
     * @param categoryId
     * @param categoryName 模糊查询
     * @return 按品类编码、品类名称
     */
    public List<GoodsCategory> findDistinctGoodsCategory(String shopId, String shopEntityId, String categoryId, String categoryName, Integer pageIndex, Integer pageSize);

    /**
     * 查询商家品类count（按品类编码、品类名称去重）
     * @param shopId
     * @param shopEntityId
     * @param categoryId
     * @param categoryName 模糊查询
     * @return 按品类编码、品类名称
     */
    public int findDistinctGoodsCategoryCount(String shopId, String shopEntityId, String categoryId, String categoryName);

}
