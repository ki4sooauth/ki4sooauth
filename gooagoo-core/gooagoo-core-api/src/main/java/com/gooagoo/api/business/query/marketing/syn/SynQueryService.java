package com.gooagoo.api.business.query.marketing.syn;

import com.gooagoo.entity.business.log.BehaveLog;

public interface SynQueryService
{
    /**
     * 原营销引擎同步
     * @param behaveLog
     * @return
     * @throws Exception
     */
    public String synQueryForEvent(BehaveLog behaveLog) throws Exception;

}
