package com.gooagoo.api.business.core.statistics;

import java.util.Map;

public interface UserPositionStatisticCoreService
{
    /**
     * 商家关注用户
     * @param mac
     * @return Map<String, String>
     * @throws Exception
     */
    public Map<String, String> findUserPositionInfo(String mac) throws Exception;

}
