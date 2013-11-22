package com.gooagoo.api.business.query.marketing.cache;

import java.util.List;

/**
 * 从缓存中查询吆喝相关信息
 */
public interface CryoutCacheQueryService
{
    /**
     * 查询吆喝
     * @param UserId
     * @return 吆喝id(orderset)
     * @throws Exception
     */
    public List<String> findUserCryout(String UserId, int pageIndex, int pageMax) throws Exception;

}
