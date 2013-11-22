package com.gooagoo.api.business.core.goods.manage;

import com.gooagoo.entity.generator.goods.GoodsCategory;

/**
 * 品类管理
 */
public interface GoodsCategoryCoreService
{
    /**
     * 通过主键删除品类信息
     * @param id 品类主键
     * @return true/false
     * @throws Exception
     */
    public boolean deleteGoodsCategory(String id) throws Exception;

    /**
     * 添加品类信息
     * @param goodsCategory 品类信息
     * @return true/false
     * @throws Exception
     */
    public boolean addGoodsCategory(GoodsCategory goodsCategory) throws Exception;

    /**
     * 通过主键修改品类信息
     * @param goodsCategory 品类信息
     * @return true/false
     * @throws Exception
     */
    public boolean updateGoodsCategory(GoodsCategory goodsCategory) throws Exception;

}
