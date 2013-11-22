package com.gooagoo.api.business.query.shop.query;

import java.util.List;

import com.gooagoo.entity.business.shop.MyShopInfoBusiness;
import com.gooagoo.entity.business.shop.ShopInfoBusiness;

public interface UserShopQueryService
{
    /**
     * 查询我的商家列表（分页、排序）
     * @param keyword 商家名称模糊查询
     * @param shoptypeId 商家类型编号
     * @param pageId (商家编号)
     * @param pageType 分页类型(N:下一页,P:上一页)
     * @param pageSize 页面大小
     * @return List<ShopInfoBusiness>
     * @throws Exception
     */
    public List<ShopInfoBusiness> findUserShopList(String keyword, String shoptypeId, String pageId, String pageType, Integer pageSize) throws Exception;

    /**
     * 查询我的商家列表（个人中心）
     * @param userId
     * @param shopTypeRoot
     * @param shopName
     * @param cardType2
     * @param pageIndex
     * @param pageSize
     * @param orderByClause
     * @return
     * @throws Exception
     */
    public List<MyShopInfoBusiness> findMyShopList(String userId, String shopTypeRoot, String shopName, String cardType2, Integer pageIndex, Integer pageSize, String orderByClause) throws Exception;

}
