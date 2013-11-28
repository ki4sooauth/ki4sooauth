package com.gooagoo.mobile.api;

import com.gooagoo.mobile.entity.mobd01.transform.UserShoppingPlanSRoot;
import com.gooagoo.mobile.entity.mobd02.transform.ShoppingMatchDetileRoot;
import com.gooagoo.mobile.entity.mobd03.transform.MarketingactivityRoot;
import com.gooagoo.mobile.entity.mobd04.transform.ActivitylistRoot;
import com.gooagoo.mobile.entity.mobd06.transform.UserShoppingPlanBTARoot;
import com.gooagoo.mobile.entity.mobd07.transform.UserShoppingPlanBTBRoot;
import com.gooagoo.mobile.entity.mobd08.transform.ShoppingMatchActiveRoot;

/**
 * 购物计划相关接口
 * 如果接口接口入参同时存在userId,sessionId,则需要先校验是否登录
 */
public interface ShoppingPlanMobileService
{
    /**
     * 接口 mobd01 : 计划列表与服务器同步（单条） 
     * @param userId 用户编号
     * @param sessionId 用户sessionid
     * @param userShoppingPlan 用户购物计划信息
     * @return
     * @throws Exception
     */
    public UserShoppingPlanSRoot getUserShoppingPlan(String userId, String sessionId, String userShoppingPlan) throws Exception;

    /**
     * 接口 mobd02 : 购物匹配（商品详细信息）
     * @param userId 用户编号
     * @param sessionId 用户sessionid
     * @param goodsId 商品编号,字符串(以逗号隔开)：1232,1123,3245
     * @return
     * @throws Exception
     */
    public ShoppingMatchDetileRoot getShoppingMatchInfo(String userId, String sessionId, String goodsId) throws Exception;

    /**
     * 接口 mobd03 : 活动查询 
     * @param type 查询类型（Y-年，M-月）
     * @param date 查询时间（年-YYYY，月-YYYY-MM
     * @return
     * @throws Exception
     */
    public MarketingactivityRoot getMarketingactivity(String type, String date) throws Exception;

    /**
     * 接口 mobd04 : 活动列表查询
     * @param startDate 查询开始时间（YYYY-MM-DD）
     * @param endDate 查询结束时间（YYYY-MM-DD
     * @param pageIndex 页码
     * @param pageSize 每页信息显示条数
     * @return
     * @throws Exception
     */
    public ActivitylistRoot getActivityList(String startDate, String endDate, String pageIndex, String pageSize) throws Exception;

    /**
     * 接口 mobd06 : 计划列表与服务器同步（批量，步骤1） 
     * @param userId 用户编号
     * @param sessionId 用户sessionid
     * @param userShoppingPlan 用户购物计划信息
     * @return
     * @throws Exception
     */
    public UserShoppingPlanBTARoot shoppingPlanSynStepA(String userId, String sessionId, String userShoppingPlan) throws Exception;

    /**
     * 接口 mobd07 : 计划列表与服务器同步（批量，步骤2）
     * @param userId 用户编号
     * @param sessionId 用户sessionid
     * @param userShoppingPlan 用户购物计划信息
     * @return
     * @throws Exception
     */
    public UserShoppingPlanBTBRoot shoppingPlanSynStepB(String userId, String sessionId, String userShoppingPlan) throws Exception;

    /**
     * 接口 mobd08 : 购物匹配（主动） 
     * @param userId 用户编号
     * @param sessionId 用户sessionid
     * @param mac 手机mac地址
     * @param keyWord 匹配关键字
     * @return
     * @throws Exception
     */
    public ShoppingMatchActiveRoot shoppingMatch(String mac, String userId, String sessionId, String keyWord) throws Exception;

}
