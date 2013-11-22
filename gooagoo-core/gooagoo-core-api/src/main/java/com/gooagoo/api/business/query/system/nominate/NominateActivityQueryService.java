package com.gooagoo.api.business.query.system.nominate;

import java.util.List;

import com.gooagoo.entity.business.system.nominate.NominateActivityBusiness;

public interface NominateActivityQueryService
{

    /**
     * 条件查询推荐活动
     * @param nominateActivityBusiness
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<NominateActivityBusiness> findNominateActivityBusiness(NominateActivityBusiness nominateActivityBusiness, Integer pageIndex, Integer pageSize);

    /**
     * 条件查询推荐活动(count)
     * @param nominateActivityBusiness
     * @return
     */
    public int countNominateActivityBusiness(NominateActivityBusiness nominateActivityBusiness);

    /**
     * 单独查询推荐活动
     * @param nominateActivityBusiness
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<NominateActivityBusiness> findNominateActivity(NominateActivityBusiness nominateActivityBusiness, Integer pageIndex, Integer pageSize);

    /**
     * 条件查询推荐活动(count)
     * @param nominateActivityBusiness
     * @return
     */
    public int countNominateActivity(NominateActivityBusiness nominateActivityBusiness);

}
