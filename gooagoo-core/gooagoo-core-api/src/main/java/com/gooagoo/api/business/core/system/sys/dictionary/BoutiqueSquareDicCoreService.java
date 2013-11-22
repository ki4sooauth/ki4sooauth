package com.gooagoo.api.business.core.system.sys.dictionary;

import java.util.List;

import com.gooagoo.entity.generator.base.QualitySquareGoodsType;

/**
 *  精品广场商品类型字典表管理
 */
public interface BoutiqueSquareDicCoreService

{

    /**
     * 新增精品广场商品类型
     * @param qualitySquareGoodsType
     * @return
     * @throws Exception
     */
    public boolean addBoutiqueSquareDic(QualitySquareGoodsType qualitySquareGoodsType) throws Exception;

    /**
     * 编辑精品广场商品类型
     * @param qualitySquareGoodsType
     * @return
     * @throws Exception
     */
    public boolean updateBoutiqueSquareDic(QualitySquareGoodsType qualitySquareGoodsType) throws Exception;

    /**
     * 删除精品广场商品类型
     * @param goodsTypeId
     * @return
     * @throws Exception
     */
    public boolean delBoutiqueSquareDic(String goodsTypeId) throws Exception;

    /**
     * 批量新增精品广场商品类型（清空表数据，然后新增）
     * @param sysList
     * @return
     * @throws Exception
     */
    public boolean addAllBoutiqueSquareDic(List<QualitySquareGoodsType> sysList) throws Exception;

}
