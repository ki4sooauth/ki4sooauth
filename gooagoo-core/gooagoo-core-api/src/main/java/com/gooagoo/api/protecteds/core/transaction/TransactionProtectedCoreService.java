package com.gooagoo.api.protecteds.core.transaction;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gooagoo.entity.business.transaction.CanNotUseCoupon;
import com.gooagoo.entity.business.transaction.OrderBusiness;
import com.gooagoo.entity.business.transaction.OrderCouponBusiness;
import com.gooagoo.entity.generator.bill.OrderCouponInfo;
import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.entity.generator.bill.OrderInfo;
import com.gooagoo.entity.generator.bill.OrderPic;
import com.gooagoo.entity.generator.bill.UserOrderCoupon;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;

public interface TransactionProtectedCoreService
{

    /**
     * 判断优惠券是否可以使用
     * @param userId 用户编号(提交者)
     * @param favoriteId 优惠凭证收藏编号
     * @param shopId 商家编号
     * @param shopEntityId 实体店编号
     * @param categoryTypeSet 购买商品品类编号集合
     * @return true/false
     */
    public CanNotUseCoupon checkCoupon(String userId, String favoriteId, String shopId, String shopEntityId, Set<String> categoryTypeSet);

    /**
     * 修改优惠券状态
     * @param favoriteId
     * @param couponStatus
     * @return
     */
    public boolean changeCouponStatus(String favoriteId, String couponStatus);

    /**
     * 通过用户编号和商家编号获取会员卡音频编号/会员卡音频编号获取用户编号
     * @param shopId
     * @param userId
     * @param scardNo
     * @return Map<String, String>[keys:userid,scardno]
     */
    public Map<String, String> getAccount(String shopId, String userId, String scardNo);

    /**
     * 保存订单信息
     * @param orderBusiness
     * @throws Exception
     */
    public void saveOrderInfo(OrderBusiness orderBusiness) throws Exception;

    /**
     * 查询商品信息
     * @param shopEntityId 实体店编号
     * @param goodsName 商品名称
     * @param goodsItemSerial 商品自定义序列号
     * @return
     */
    public GoodsBaseInfo getGoodsBaseInfoFromDB(String shopEntityId, String goodsName, String goodsItemSerial);

    /**
     * 根据桌号、实体店查询未结账订单
     * @param tableName 餐桌号
     * @param shopEntityId 实体店编号
     * @return
     */
    public OrderInfo getNotCheckoutOrder(String tableName, String shopEntityId);

    /**
     * 查询goodsId对应订单详细信息
     * @param goodsId  商品编号
     * @param orderDetailInfoList 订单明细信息
     * @return
     */
    public OrderDetailInfo getMatchOrderDetailInfo(String goodsId, String goodsName, List<OrderDetailInfo> orderDetailInfoList);

    /**
     * 获得订单优惠凭证详情和不能使用的优惠券列表
     * @param userId
     * @param shopId
     * @param shopEntityId
     * @param orderDetailInfoList
     * @param userOrderCouponList
     * @param orderId
     * @return
     */
    public OrderCouponBusiness getOrderCouponBusiness(String userId, String shopId, String shopEntityId, List<OrderDetailInfo> orderDetailInfoList, List<UserOrderCoupon> userOrderCouponList, String orderId) throws Exception;

    /**
     * 锁定优惠券
     * @param orderCouponInfoList
     * @throws Exception
     */
    public void changeCouponStatusForOrder(List<OrderCouponInfo> orderCouponInfoList, String couponStatus) throws Exception;

    /**
     * 获取订单图片详情
     * @param orderId
     * @param picUrl
     * @param picType
     * @return
     */
    public OrderPic getOrderPic(String orderId, String picUrl, String picType);

    /**
     * 效验是否购买了优惠凭证指定品类
     * @param categoryTypeSet
     * @param categoryDataList
     * @return
     */
    public boolean checkCategoryType(Set<String> categoryTypeSet, List<String> categoryDataList);

    /**
     * 获取16位订单编号
     * @param shopEntityId
     * @return
     * @throws Exception 
     */
    public String getOrderId(String shopEntityId) throws Exception;

}
