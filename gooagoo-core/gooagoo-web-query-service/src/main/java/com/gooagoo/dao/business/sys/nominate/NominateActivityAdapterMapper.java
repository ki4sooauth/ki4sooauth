package com.gooagoo.dao.business.sys.nominate;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.gooagoo.entity.business.system.nominate.NominateActivityBusiness;

/**
 * 推荐活动
 * @author Administrator
 *
 */
public interface NominateActivityAdapterMapper
{
    /**
     * 条件查询推荐活动
     * @param nominateActivityBusiness
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<NominateActivityBusiness> findNominateActivityBusiness(@Param("nominateActivityBusiness") NominateActivityBusiness nominateActivityBusiness, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    /**
     * 条件查询推荐活动(count)
     * @param nominateActivityBusiness
     * @return
     */
    public int countNominateActivityBusiness(@Param("nominateActivityBusiness") NominateActivityBusiness nominateActivityBusiness);

    /**
     * 单独查询推荐活动
     * @param nominateActivityBusiness
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<NominateActivityBusiness> findNominateActivity(@Param("nominateActivityBusiness") NominateActivityBusiness nominateActivityBusiness, @Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);

    /**
     * 条件查询推荐活动(count)
     * @param nominateActivityBusiness
     * @return
     */
    public int countNominateActivity(@Param("nominateActivityBusiness") NominateActivityBusiness nominateActivityBusiness);

}
