package com.gooagoo.api.business.query.statistics;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.gooagoo.entity.business.goods.GoodsSalesRanking;

public interface BuyStatisticQueryService
{

    /**
     * 查询商品购买次数
     * @param shopId 商家id/实体店id
     * @param goodsSerialNo 商品序列号
     * @param dateTime 时间类型
     * @param userType  用户类型
     * @param dateTime  时间
     * @return
     */
    public abstract int goodsBuyTimes(String shopId, String goodsSerialNo, String dateType, String userType, Date dateTime);

    /**
     * 查询商品购买人群
     * @param shopId 商家id/实体店id
     * @param goodsSerialNo 商品序列号
     * @param dateTime 时间类型
     * @param userType  用户类型
     * @param dateTime  时间
     * @return
     */
    public abstract List<String> goodsBuyPeople(String shopId, String goodsSerialNo, String dateType, String userType, Date dateTime);

    /**
     * 查询品类购买次数
     * @param shopId 商家id/实体店id
     * @param categoryId 商品序列号
     * @param dateTime 时间类型
     * @param userType  用户类型
     * @param dateTime  时间
     * @return
     */
    public abstract int categoryBuyTimes(String shopId, String categoryId, String dateType, String userType, Date dateTime);

    /**
     * 查询品类购买人群
     * @param shopId 商家id/实体店id
     * @param categoryId 品类id
     * @param dateTime 时间类型
     * @param userType  用户类型
     * @param dateTime  时间
     * @return
     */
    public abstract List<String> categoryBuyPeople(String shopId, String categoryId, String dateType, String userType, Date dateTime);

    /**
     * 查询品牌购买次数
     * @param shopId 商家id/实体店id
     * @param brandId  品牌id
     * @param dateTime 时间类型
     * @param userType  用户类型
     * @param dateTime  时间
     * @return
     */
    public abstract int brandBuyTimes(String shopId, String brandId, String dateType, String userType, Date dateTime);

    /**
     * 查询品牌购买人群
     * @param shopId 商家id/实体店id
     * @param brandId 品牌id
     * @param dateTime 时间类型
     * @param userType  用户类型
     * @param dateTime  时间
     * @return
     */
    public abstract List<String> brandBuyPeople(String shopId, String brandId, String dateType, String userType, Date dateTime);

    /**
     * 老的区域销量排行
     * @param positionId
     * @return
     */
    @Deprecated
    public List<GoodsSalesRanking> salesRanking(String positionId, Integer pageIndex, Integer pageSize);

    /**
     * 区域销量排行
     * @param goodsId
     * @return
     */
    public List<GoodsSalesRanking> areaSalesRanking(String positionId);

    /**
     * 品类销量排行
     * @param categoryId
     * @return
     */
    public List<GoodsSalesRanking> categorySalesRanking(String categoryId);

    /**
     * 用户消费次数
     * @param shopId_D shopId_D日/shopId
     * @return
     */
    public Set<String> consumptionNum(String shopId_D);

    /**
     * 查询指定商品的销量
     * @param goodsId
     * @return
     */
    public GoodsSalesRanking findSalesByGoodsId(String goodsId);

}