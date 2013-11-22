package com.gooagoo.api.business.query.marketing.cryout;


public interface ShopCryoutQueryService
{
    /**
     *     6.4.5. 查询吆喝列表
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean findShopCryoutList(String parameter) throws Exception;

    /**
     *         6.4.6. 查看吆喝详情
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean findShopCryoutDetail(String parameter) throws Exception;

}
