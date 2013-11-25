package com.gooagoo.api.business.core.statistics.user;

import java.util.List;

import com.gooagoo.entity.generator.marketing.CryoutInfo;

public interface CryoutStatisticCoreService
{
    /**
     * 他们在说
     * @param account 用户编号
     * @return 吆喝列表
     * @throws Exception
     */
    public abstract List<CryoutInfo> queryCryoutings(String account) throws Exception;

}