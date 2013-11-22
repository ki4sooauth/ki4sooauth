package com.gooagoo.api.business.core.goods.manage;

import java.util.List;

import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsFeatureInfo;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfo;

/**
 * 商品信息管理
 */
public interface GoodsCoreService
{

    /**
     * 添加商品信息
     * @param goodsBaseInfo 
     * @param goodsMarketingInfo
     * @param goodsFeatureInfoList
     * @return
     * @throws Exception
     */
    public boolean addGoodsInfo(GoodsBaseInfo goodsBaseInfo, GoodsMarketingInfo goodsMarketingInfo, List<GoodsFeatureInfo> goodsFeatureInfoList) throws Exception;

    /**
     * 删除商品（删除商品基本、营销、特征信息）
     * @param goodsId 商品编号
     * @return true/false
     * @throws Exception
     */
    public boolean deleteGoodsInfo(String goodsId) throws Exception;

    /**
     * 修改商品信息
     * @param goodsBaseInfo 
     * @param goodsMarketingInfo
     * @param goodsFeatureInfoList
     * @return
     * @throws Exception
     */
    public boolean updateGoodsInfo(GoodsBaseInfo goodsBaseInfo, GoodsMarketingInfo goodsMarketingInfo, List<GoodsFeatureInfo> goodsFeatureInfoList) throws Exception;

    /**
     * 添加商品基本信息
     * @param goodsBaseInfo 商品基本信息
     * @return true/false
     * @throws Exception
     */
    public boolean addGoodsBaseInfo(GoodsBaseInfo goodsBaseInfo) throws Exception;

    /**
     * 修改商品基本信息
     * @param goodsBaseInfo 商品基本信息
     * @return true/false
     * @throws Exception
     */
    public boolean updateGoodsBaseInfo(GoodsBaseInfo goodsBaseInfo) throws Exception;

    /**
     * 添加商品营销信息
     * @param goodsMarketingInfo 商品营销信息
     * @return true/false
     * @throws Exception
     */
    public boolean addGoodsMarketingInfo(GoodsMarketingInfo goodsMarketingInfo) throws Exception;

    /**
     * 修改商品营销信息
     * @param goodsMarketingInfo 商品营销信息
     * @return true/false
     * @throws Exception
     */
    public boolean updateGoodsMarketingInfo(GoodsMarketingInfo goodsMarketingInfo) throws Exception;

    /**
     * 添加商品特征信息
     * @param goodsFeatureInfo 商品特征信息
     * @return true/false
     * @throws Exception
     */
    public boolean addGoodsFeatureInfo(GoodsFeatureInfo goodsFeatureInfo) throws Exception;

    /**
     * 修改商品特征信息
     * @param goodsFeatureInfo 商品特征信息
     * @return true/false
     * @throws Exception
     */
    public boolean updateGoodsFeatureInfo(GoodsFeatureInfo goodsFeatureInfo) throws Exception;

    /**
     * 删除商品特征信息
     * @param id 商品特征信息主键
     * @return true/false
     * @throws Exception
     */
    public boolean deleteGoodsFeatureInfo(String id) throws Exception;

    /**
     * 审核商品
     * @param goodsId 商品编号
     * @param status 审核状态(Y-通过，N-不通过)
     * @param note 审核备注
     * @return
     * @throws Exception
     */
    public boolean reviewedActivity(String goodsId, String status, String note) throws Exception;

    /**
     * 发布商品
     * @param goodsId 商品编号
     * @return
     * @throws Exception
     */
    public boolean publishGoods(String goodsId) throws Exception;
}
