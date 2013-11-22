package com.gooagoo.dao.business.sys.nominate;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.business.system.nominate.NominateGoodsBusiness;

/**
 * 推荐商品
 * @author Administrator
 *
 */
public interface NominateGoodsAdapterMapper
{
    /**
     * 条件查询推荐商品
     * @param nominateGoodsBusiness
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<NominateGoodsBusiness> findNominateGoodsBusiness(@Param("nominateGoodsBusiness") NominateGoodsBusiness nominateGoodsBusiness, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    /**
     * 条件查询推荐商品(count)
     * @param nominateGoodsBusiness
     * @return
     */
    public int countNominateGoodsBusiness(@Param("nominateGoodsBusiness") NominateGoodsBusiness nominateGoodsBusiness);

    /**
     * 单独查询推荐商品
     * @param nominateGoodsBusiness
     * @return
     */
    public List<NominateGoodsBusiness> findNominateGoods(@Param("nominateGoodsBusiness") NominateGoodsBusiness nominateGoodsBusiness, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    /**
     * 条件查询推荐商品(count)
     * @param nominateGoodsBusiness
     * @return
     */
    public int countNominateGoods(@Param("nominateGoodsBusiness") NominateGoodsBusiness nominateGoodsBusiness);

}
