package com.gooagoo.api.business.core.goods.manage;

import com.gooagoo.entity.generator.goods.GoodsFeature;

/**
 * 商品特征项管理
 */
public interface GoodsFeatureCoreService
{
    /**
     * 通过主键删除商品特征项信息
     * @param id 主键
     * @return true/false
     * @throws Exception
     */
    public boolean deleteGoodsFeature(String id) throws Exception;

    /**
     * 添加商品特征项信息
     * @param goodsFeature 商品特征项信息
     * @return true/false
     * @throws Exception
     */
    public boolean addGoodsFeature(GoodsFeature goodsFeature) throws Exception;

    /**
     * 通过主键修改商品特征项信息
     * @param goodsFeature 商品特征项信息
     * @return true/false
     * @throws Exception
     */
    public boolean updateGoodsFeature(GoodsFeature goodsFeature) throws Exception;

}
