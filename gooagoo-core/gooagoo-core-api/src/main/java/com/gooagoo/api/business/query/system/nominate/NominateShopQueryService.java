package com.gooagoo.api.business.query.system.nominate;

import java.util.List;

import com.gooagoo.entity.business.system.nominate.NominateShopBusiness;

public interface NominateShopQueryService
{

    /**
          * 查询推荐商家
          * @param nominateShopBusiness
          * @param pageIndex
          * @param pageSize
          * @return
          */

    public List<NominateShopBusiness> findNominateShopBusinessList(NominateShopBusiness nominateShopBusiness, Integer pageIndex, Integer pageSize);

    /**
          * 查询推荐商家(count)
          * @param nominateShopBusiness
          * @return
          */

    public int CountNominateShopBusiness(NominateShopBusiness nominateShopBusiness);

    /**
     * 单独查询推荐商家
     * @param nominateShopBusiness
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<NominateShopBusiness> findNominateShopList(NominateShopBusiness nominateShopBusiness, Integer pageIndex, Integer pageSize);

    /**
     * 查询推荐商家(count)
     * @param nominateShopBusiness
     * @return
     */

    public int CountNominateShop(NominateShopBusiness nominateShopBusiness);

}
