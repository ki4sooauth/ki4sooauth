package com.gooagoo.api.business.core.system.sys.dictionary;

import java.util.List;

import com.gooagoo.entity.generator.base.ShoppingListGoodsType;

/**
 *  购物清单商品类型字典表管理
 */
public interface ShoppingListDicCoreService

{

    /**
     * 新增购物清单商品类型
     * @param shoppingListGoodsType
     * @return
     * @throws Exception
     */
    public boolean addShoppingListDic(ShoppingListGoodsType shoppingListGoodsType) throws Exception;

    /**
     * 编辑购物清单商品类型
     * @param shoppingListGoodsType
     * @return
     * @throws Exception
     */
    public boolean updateShoppingListDic(ShoppingListGoodsType shoppingListGoodsType) throws Exception;

    /**
     * 删除购物清单商品类型
     * @param goodsTypeId
     * @return
     * @throws Exception
     */
    public boolean delShoppingListDic(String goodsTypeId) throws Exception;

    /**
     * 批量新增购物清单商品类型（清空表数据，然后新增）
     * @param sysList
     * @return
     * @throws Exception
     */
    public boolean addAllShoppingListDic(List<ShoppingListGoodsType> sysList) throws Exception;

}
