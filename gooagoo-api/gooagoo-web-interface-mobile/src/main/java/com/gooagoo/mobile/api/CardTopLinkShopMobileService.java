package com.gooagoo.mobile.api;

import com.gooagoo.mobile.entity.moba01.transform.UserMemberCardRoot;
import com.gooagoo.mobile.entity.moba05.transform.RecommendShopRoot;
import com.gooagoo.mobile.entity.moba08.transform.ShopListRoot;
import com.gooagoo.mobile.entity.moba09.transform.ShopCardInfoRoot;

/**
 * 卡包有关商家的接口
 * 如果接口入参同时存在userId,sessionId,则需要先校验是否登录
 */
public interface CardTopLinkShopMobileService
{
    /**
     * 接口 moba05 : 推荐商家 
     * @param userId 用户编号
     * @param pageIndex 页码
     * @param pageSize 每页信息显示条数
     * @return
     * @throws Exception
     */
    public RecommendShopRoot getRecommendShopInfo(String userId, String pageIndex, String pageSize) throws Exception;

    /**
     * 接口 moba08 : 查询商家列表
     * 当shopType和keyword都不为空时，综合此两条件查询
     * @param shopId 商家编号
     * @param pageType 翻页类型
     * @param pageSize 每页信息显示条数
     * @param shopType 商家类别
     * @param keyWord  关键字,商家名称模糊查询
     * @return
     * @throws Exception
     */
    public ShopListRoot getShopList(String shopId, String pageType, String pageSize, String shopType, String keyWord) throws Exception;

    /**
     * 接口 moba09 : 查询商家会员卡信息列表 
     * @param shopId 商家编号
     * @return
     * @throws Exception
     */
    public ShopCardInfoRoot getShopMemberCard(String shopId) throws Exception;

    /**
     * 接口 moba01 : 用户会员卡列表 
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param cTimeStamp 最大时间戳
     * @param pageSize 每页信息显示条数
     * @return
     * @throws Exception
     */
    public UserMemberCardRoot getUserMemberCard(String userId, String sessionId, String cTimeStamp, String pageSize) throws Exception;
}
