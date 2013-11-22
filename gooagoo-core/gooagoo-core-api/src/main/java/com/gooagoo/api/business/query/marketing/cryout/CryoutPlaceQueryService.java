package com.gooagoo.api.business.query.marketing.cryout;

import java.util.List;

import com.gooagoo.entity.business.marketing.FirstMenu;
import com.gooagoo.entity.business.marketing.ShopDetailForPlace;

public interface CryoutPlaceQueryService
{

    /**
     * 吆喝广场侧边栏分类查询
     * mobc02
     * @param parameter
     * @return List<Firstmenu>
     */
    public List<FirstMenu> findCryoutPlaceMenu() throws Exception;

    /**
     * 吆喝广场商家列表
     * mobc03
     * @param keyword
     * @param typeCode(type + shopTypeId)
     * @return
     */
    public List<ShopDetailForPlace> findCryoutPlaceList(String keyword, String typeCode, Integer pageIndex, Integer pageSize) throws Exception;

    /**
     * 6.4.13. 吆喝广场商家详情查询
     * @param shopId
     * @return CryoutShopDetail
     */
    public ShopDetailForPlace findCryoutPlaceDetail(String shopId) throws Exception;
}
