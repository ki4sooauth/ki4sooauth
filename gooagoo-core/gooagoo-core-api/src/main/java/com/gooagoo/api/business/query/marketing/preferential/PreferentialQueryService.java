package com.gooagoo.api.business.query.marketing.preferential;


public interface PreferentialQueryService
{
    /**
     * 品类优惠查询
     * @param userId
     * @param pageIndex
     * @param pageSize
     * @return
     * @throws Exception
     */
    public boolean categoryPreferential(String userId, String pageIndex, String pageSize) throws Exception;

}
