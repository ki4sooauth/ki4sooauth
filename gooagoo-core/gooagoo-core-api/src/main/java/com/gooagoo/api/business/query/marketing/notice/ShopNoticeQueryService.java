package com.gooagoo.api.business.query.marketing.notice;


public interface ShopNoticeQueryService
{

    /**
     *    6.7.6. 查询通知列表（分页）
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean findShopNoticeList(String parameter) throws Exception;
}
