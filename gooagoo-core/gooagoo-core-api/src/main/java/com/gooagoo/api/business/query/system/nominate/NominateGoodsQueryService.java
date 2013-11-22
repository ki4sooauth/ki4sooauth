package com.gooagoo.api.business.query.system.nominate;

import java.util.List;

import com.gooagoo.entity.business.system.nominate.NominateGoodsBusiness;

public interface NominateGoodsQueryService
{

    /**
     * 查询推荐商品
     * @param nominateGoodsBusiness
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<NominateGoodsBusiness> findNominateGoodsBusiness(NominateGoodsBusiness nominateGoodsBusiness, Integer pageIndex, Integer pageSize);

    /**
     * 查询推荐商品(count)
     * @param nominateGoodsBusiness
     * @return
     */
    public int countNominateGoodsBusiness(NominateGoodsBusiness nominateGoodsBusiness);

    /**
     * 单独查询推荐商品
     * @param nominateGoodsBusiness
     * @return
     */
    public List<NominateGoodsBusiness> findNominateGoods(NominateGoodsBusiness nominateGoodsBusiness, Integer pageIndex, Integer pageSize);

    /**
     * 查询推荐商品(count)
     * @param nominateGoodsBusiness
     * @return
     */
    public int countNominateGoods(NominateGoodsBusiness nominateGoodsBusiness);

}
