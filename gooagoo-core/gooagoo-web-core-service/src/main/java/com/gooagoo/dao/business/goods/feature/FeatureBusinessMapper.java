package com.gooagoo.dao.business.goods.feature;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.generator.goods.GoodsFeatureInfo;

/**
 * 特征
*/
public interface FeatureBusinessMapper
{
    /**
     * 获取商品(单品)特征信息列表
     * @param shopId
     * @param goodsSerial
     * @return
     */
    public List<GoodsFeatureInfo> findSingleGoodsFeatureInfo(@Param("shopId") String shopId, @Param("goodsSerial") String goodsSerial);

}
