package com.gooagoo.api.business.core.transaction.order;

import java.util.List;
import java.util.Map;

import com.gooagoo.entity.business.transaction.OrderResult;
import com.gooagoo.entity.generator.bill.UserOrderCoupon;
import com.gooagoo.entity.generator.bill.UserOrderDetail;
import com.gooagoo.entity.generator.bill.UserOrderInfo;
import com.gooagoo.entity.generator.user.ConsigneeInfo;
import com.gooagoo.exception.business.shop.TableNotExistException;
import com.gooagoo.exception.business.shop.TableStateNotFreeException;

/**
 * 用户订单管理
 */
public interface UserOrderCoreService
{

    /**
     * 用户提交订单
     * @param userOrderInfo 用户订单原始信息
     * @param userOrderDetailList 用户订单原始信息商品详情
     * @param userOrderCouponList 用户订单原始信息优惠凭证详情
     * @param parmMap (key:goodssource、value:0代表商品来源是购物车)
     * @return 不能使用的优惠券列表
     * @throws TableNotExistException 餐桌不存在
     */
    public OrderResult addUserOrder(ConsigneeInfo consigneeInfo, UserOrderInfo userOrderInfo, List<UserOrderDetail> userOrderDetailList, List<UserOrderCoupon> userOrderCouponList, Map<String, String> parmMap) throws Exception;

    /**
     * 绑定桌号、订单号、用户id
     * @param orderId 订单号
     * @param deskName 桌号
     * @param roomName 房间号
     * @return boolean 绑定是否成功
     * @throws TableStateNotFreeException 餐桌状态不匹配绑定餐桌异常(绑定餐桌只允许空闲餐桌)
     */
    public boolean bindTable(String orderId, String deskName, String roomName) throws Exception;
}
