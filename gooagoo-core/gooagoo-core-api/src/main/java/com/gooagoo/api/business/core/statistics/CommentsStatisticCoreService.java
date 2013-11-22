package com.gooagoo.api.business.core.statistics;

import java.util.Date;
import java.util.List;

public interface CommentsStatisticCoreService
{
    /**
     * 查询商品评分
     * @param goodsId 商品编号
     * @return
     */
    public abstract String getGoodsGrade(String goodsId);

    /**
     * 查询商品评论次数
     * @param shopId 商家id/实体店id
     * @param goodsSerialNo 商品序列号
     * @param dateTime 时间类型
     * @param userType  用户类型
     * @param source 来源
     * @param dateTime  时间
     * @return
     */
    public abstract int goodsCommentTimes(String shopId, String goodsSerialNo, String dateType, String userType, Date dateTime, String source);

    /**
     *查询商品评论人群
     * @param shopId 商家id/实体店id
     * @param goodsSerialNo 商品序列号
     * @param dateTime 时间类型
     * @param userType  用户类型
     * @param source 来源
     * @param dateTime  时间
     * @return
     */
    public abstract List<String> goodsCommentPeople(String shopId, String goodsSerialNo, String dateType, String userType, Date dateTime, String source);

    /**
     * 查询品类评论次数
     * @param shopId 商家id/实体店id
     * @param categoryId 品类id
     * @param dateTime 时间类型
     * @param userType  用户类型
     * @param source 来源
     * @param dateTime  时间
     * @return
     */
    public abstract int categoryCommentTimes(String shopId, String categoryId, String dateType, String userType, Date dateTime, String source);

    /**
     *查询品类评论人群
     * @param shopId 商家id/实体店id
     * @param categoryId 品类id
     * @param dateTime 时间类型
     * @param userType  用户类型
     * @param source 来源
     * @param dateTime  时间
     * @return
     */
    public abstract List<String> categoryCommentPeople(String shopId, String categoryId, String dateType, String userType, Date dateTime, String source);

    /**
     * 查询品牌评论次数
     * @param shopId 商家id/实体店id
     * @param brandId 品牌id
     * @param dateTime 时间类型
     * @param userType  用户类型
     * @param source 来源
     * @param dateTime  时间
     * @return
     */
    public abstract int brandCommentTimes(String shopId, String brandId, String dateType, String userType, Date dateTime, String source);

    /**
     *查询品牌评论人群
     * @param shopId 商家id/实体店id
     * @param brandId 品牌id
     * @param dateTime 时间类型
     * @param userType  用户类型
     * @param source 来源
     * @param dateTime  时间
     * @return
     */
    public abstract List<String> brandCommentPeople(String shopId, String brandId, String dateType, String userType, Date dateTime, String source);
}
