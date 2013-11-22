package com.gooagoo.api.business.query.goods.query;

import java.util.List;
import java.util.Map;

import com.gooagoo.entity.business.goods.GoodsCategoryBusiness;
import com.gooagoo.entity.business.goods.GoodsContainComment;
import com.gooagoo.entity.business.goods.GoodsDetail;
import com.gooagoo.entity.business.goods.ShopGoodsDetailInfo;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;

/****
 * 商品查询
 * @author Administrator
 *
 */
public interface GoodsQueryService
{

    /****
     * 2.1.2. 根据商品Id查询商品基本信息详情
     * @param goodsId
     * @return
     * @throws Exception
     */
    public GoodsDetail findGoodsBaseDetail(String goodsId) throws Exception;

    /****
     * 2.1.2. 根据商品Id查询商品营销信息详情
     * @param goodsId
     * @return
     * @throws Exception
     */
    public GoodsDetail findGoodsMarketingDetail(String goodsId) throws Exception;

    /****
     * 2.1.2. 根据商品Id查询商品特征信息详情
     * @param goodsId
     * @return
     * @throws Exception
     */
    public GoodsDetail findGoodsFeatureDetail(String goodsId) throws Exception;

    /*****
     * 2.1.4. 根据自定义序列号、实体店编号、商家编号查询商品详情
     * @param shopEntityId 实体店编号
     * @param itemSerial 自定义序列号
     * @return GoodsBaseInfo
     */
    public GoodsBaseInfo findGoodsByItemSerial(String shopEntityId, String itemSerial);

    /**
     * 店员查询商家商品品类(只返回根节点及其下一级节点)
     * gasd01
     * @param shopEntityId
     * @return
     */
    public List<GoodsCategoryBusiness> findGoodsCategory(String ShopId, String shopEntityId, Integer pageIndex, Integer pageSize);

    /**
     * 查询商品
     * 入参要求：商家编号、实体店编号必选其一
     * 排序方式如下（可不传）：
     * 按人气降序：1
     * 按最新降序：2
     * 按活动降序：3
     * gasd02,gask01,gask03
     * @param shopId 商家编号
     * @param shopEntityId 实体店编号
     * @param itemSerial 自定义序列号
     * @param goodsName 商品名称
     * @param categoryId
     * @param priceMin 价格上区间
     * @param priceMax 价格下区间
     * @param pageIndex
     * @param pageSize
     * @param orderByClause
     * @return
     * @throws Exception
     */
    public List<GoodsDetail> findGoods(String shopId, String shopEntityId, String itemSerial, String goodsName, String categoryId, String priceMin, String priceMax, Integer pageIndex, Integer pageSize, String orderByClause) throws Exception;

    /**
     * 统计商家总店商品数量
     * @param shopId
     * @return
     */
    public Integer countGeneralGoods(String shopId);

    /**
     * 查询商品详细信息
     * mobb04
     * @param goodsInfoList
     * @return
     * @throws Exception
     */
    public List<ShopGoodsDetailInfo> findGoodsAndComment(List<Map<String, String>> goodsInfoList) throws Exception;

    /*****
     * 通扫码获取商品信息(目前只用于收藏广场mobe09)
     * @param shopEntityId 实体店编号
     * @param itemSerial 自定义序列号
     * @return GoodsBaseInfo
     * @throws Exception;
     */
    public List<GoodsContainComment> findGoodsContainComment(String shopEntityId, String itemSerial) throws Exception;

    /**
     *  mobe04查询品类及下级品类所有商品
     * @param userId 用户编号
     * @param shopEntityId 实体店编号
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws Exception
     */
    public List<ShopGoodsDetailInfo> getGoodsMenu(String userId, String shopEntityId, Integer pageIndex, Integer pageSize) throws Exception;

}
