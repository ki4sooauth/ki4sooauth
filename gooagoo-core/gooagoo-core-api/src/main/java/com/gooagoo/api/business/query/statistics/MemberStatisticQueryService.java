package com.gooagoo.api.business.query.statistics;

import java.util.Set;

public interface MemberStatisticQueryService
{
    /**
     * 商家关注用户
     * @param shopId
     * @param Source
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws Exception
     */
    public Set<String> findAttention(String shopId, String Source, Integer pageIndex, Integer pageSize) throws Exception;

    /**
     * 关注用户数量
     * @param shopId
     * @param Source
     * @return
     * @throws Exception
     */
    public Integer countAttention(String shopId, String Source) throws Exception;

    /**
     * 商家会员用户 不区分关注和会员
     * @param shopId
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws Exception
     */
    public Set<String> findMember(String shopId, Integer pageIndex, Integer pageSize) throws Exception;

    /**
     * 会员数量，不区分关注和会员
     * @param shopId
     * @return
     * @throws Exception
     */
    public Integer countMember(String shopId) throws Exception;

}
