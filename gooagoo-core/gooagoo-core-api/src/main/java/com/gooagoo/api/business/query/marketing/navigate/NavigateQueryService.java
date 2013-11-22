package com.gooagoo.api.business.query.marketing.navigate;


public interface NavigateQueryService
{

    /**
     *  
    6.8.1. 当前地图全部活动查询
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean findActivityInMap(String parameter) throws Exception;

    /**
     *  6.8.2. 位置查询（根据“关键字”查询实体店编号或商品编号）
    * @param parameter
     * @return
     * @throws Exception
     */
    public boolean findPosition(String parameter) throws Exception;

    /**
     *  
    6.8.3. 导航（起点{x,y}，终点{x,y}）
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean navigateByCoordinate(String parameter) throws Exception;

    /**
     * 6.8.4. 导航（起点{x,y}，实体店编号或商品编号）
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean navigateByPosition(String parameter) throws Exception;

    /**
     *  
    6.8.5. 地图内商家列表
     * @param parameter
     * @return
     * @throws Exception
     */
    public boolean findShopListInMap(String parameter) throws Exception;

}
