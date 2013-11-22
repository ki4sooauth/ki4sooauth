package com.gooagoo.api.business.query.member.cache;

import java.util.Map;

/**
 * 从缓存中查询会员相关信息
 */
public interface MemberCacheQueryService
{
    /**
     * 用户会员信息(类型(A关注,M会员)、电子卡号、物理卡号、积分)
     * @param UserId_ShopId/scardno 用户编号_商家编号或scardno
     * @return 类型(A关注,M会员)、电子卡号、物理卡号、积分
     * @throws Exception
     */
    public Map<String, String> findMembeInfo(String userId, String shopId) throws Exception;

    /**
     * 用户会员信息(类型(A关注,M会员)、电子卡号、物理卡号、积分)
     * @param scardno 会员卡音频编号
     * @return 类型(A关注,M会员)、电子卡号、物理卡号、积分
     * @throws Exception
     */
    public Map<String, String> findMembeInfoByScardno(String scardno) throws Exception;

}
