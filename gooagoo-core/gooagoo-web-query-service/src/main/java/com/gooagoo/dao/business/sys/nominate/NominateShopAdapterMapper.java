package com.gooagoo.dao.business.sys.nominate;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.business.system.nominate.NominateShopBusiness;

/**
 * 推荐商家
*/
public interface NominateShopAdapterMapper
{

    /**
     * 查询后台推荐商家
     * @param nominateShopBusiness
     * @param pageIndex
     * @param pageSize
     * @return
     */

    public List<NominateShopBusiness> findNominateShopBusinessList(@Param("nominateShopBusiness") NominateShopBusiness nominateShopBusiness, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    /**
          * 查询后台推荐商家(count)
          * @param nominateShopBusiness
          * @return
          */

    public int CountNominateShopBusiness(@Param("nominateShopBusiness") NominateShopBusiness nominateShopBusiness);

    /**
     * 单独查询后台推荐商家
     * @param nominateShopBusiness
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<NominateShopBusiness> findNominateShopList(@Param("nominateShopBusiness") NominateShopBusiness nominateShopBusiness, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    /**
     * 查询后台推荐商家(count)
     * @param nominateShopBusiness
     * @return
     */

    public int countNominateShop(@Param("nominateShopBusiness") NominateShopBusiness nominateShopBusiness);

    /**
     * 查询平台推荐商家
     * @param nominateShopBusiness
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<NominateShopBusiness> findPlatformNominateShopList(@Param("userId") String userId, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    /**
     * 查询平台推荐商家count
     * @param nominateShopBusiness
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public int countPlatformNominateShop(@Param("userId") String userId);
}
