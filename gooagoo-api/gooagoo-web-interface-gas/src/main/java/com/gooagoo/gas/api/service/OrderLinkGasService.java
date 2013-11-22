package com.gooagoo.gas.api.service;

import com.gooagoo.gas.entity.gasl02.transform.GetAllBillRoot;
import com.gooagoo.gas.entity.gasl13.transform.FindCouponRoot;

public interface OrderLinkGasService
{
    /**
     * 接口gasl02:查询已开台餐桌的用餐状态
     * @param shopEntityId 实体店编号
     * @param deskNo 桌号
     * @param pageIndex 页码
     * @param pageSize  每页信息显示条数
     * @return
     * @throws Exception
     */
    public GetAllBillRoot queryHaveDinnerStatus(String shopEntityId, String tableName, String pageIndex, String pageSize) throws Exception;

    /**
     * 接口gasl03:店员帮用户提交点餐单（餐饮业）
     * @param shopId 商家编号
     * @param shopEntityId 实体店编号
     * @param deskNo 桌号
     * @param goodsInfo  点餐信息
     * @param dishWay  起菜方式
     * @return
     * @throws Exception
     */
    public String commitCateringOrder(String shopId, String shopEntityId, String deskNo, String goodsInfo, String dishWay) throws Exception;

    /**
     * 接口gasl04:店员标记已上菜品
     * @param orderId 订单编号
     * @param shopEntityId 实体店编号
     * @param tableName 餐桌号
     * @param foodsInfo 已上菜品信息 格式：[ { "itemserial": "00017STNPL7NIGF1T0000LEIISQNS0DL", "goodsnum":"2"}]
     * @return
     * @throws Exception
     */
    public boolean markUpDish(String orderId, String shopEntityId, String tableName, String foodsInfo) throws Exception;

    /**
     * 接口gasl05:店员帮用户提交结账申请
     * @param orderId 订单编号
     * @param shopId 商家编号
     * @param shopEntityId 实体店编号
     * @param scardNo 会员卡号
     * @param couponId 优惠券编号 如果有多个，则组成以逗号分隔的字符串,如：“1,2,3”
     * @return
     * @throws Exception
     */
    public boolean submitPayBillApply(String orderId, String shopId, String shopEntityId, String scardNo, String couponId) throws Exception;

    /**
     * 接口gasl06:店员帮用户提交加菜申请
     * @param shopId 商家编号
     * @param shopEntityId 实体店编号
     * @param tableName 桌号
     * @param goodsInfo 点餐信息
     * @return
     * @throws Exception
     */
    public boolean submitAddDishApply(String shopId, String shopEntityId, String tableName, String goodsInfo) throws Exception;

    /**
     * 接口gasl07:店员帮用户提交减菜申请
     * @param shopId 商家编号
     * @param shopEntityId 实体店编号
     * @param tableName 桌号
     * @param goodsInfo 点餐信息
     * @return
     * @throws Exception
     */
    public boolean submitSubDishApply(String shopId, String shopEntityId, String tableName, String goodsInfo) throws Exception;

    /**
     * 接口gasl08:店员帮助用户起菜
     * @param shopEntityId 实体店编号
     * @param orderId 订单编号
     * @param tableName 桌号
     * @param itemSerial 菜品自定义序列号
     * @param goodsNum 菜品数量
     * @return
     * @throws Exception
     */
    public boolean orderDish(String shopEntityId, String orderId, String tableName, String itemSerial, String goodsNum) throws Exception;

    /**
     * 接口gasl09:店员帮助用户催菜
     * @param shopEntityId 实体店编号
     * @param orderId 订单编号
     * @param tableName 桌号
     * @param itemSerial 菜品自定义序列号
     * @param goodsKind 菜品列表
     * @return
     * @throws Exception
     */
    public boolean hurryDish(String shopEntityId, String orderId, String tableName, String itemSerial, String goodsKind) throws Exception;

    /**
     * 接口gasl10:店员帮助用户缓菜
     * @param shopEntityId 实体店编号
     * @param orderId 订单编号
     * @param tableName 桌号
     * @param itemSerial 菜品自定义序列号
     * @param goodsNum 菜品数量
     * @return
     * @throws Exception
     */
    public boolean slowDish(String shopEntityId, String orderId, String tableName, String itemSerial, String goodsNum) throws Exception;

    /**
     * 接口gasl11:修改台头(用户就餐信息)
     * @param shopEntityId 实体店编号
     * @param tableName 餐桌号
     * @param peopleNums 就餐人数
     * @return
     * @throws Exception
     */
    public boolean updatePeopleNums(String shopEntityId, String tableName, String peopleNums) throws Exception;

    /**
     * 接口gasl12:重量确认
     * @param shopEntityId 实体店编号
     * @param orderId 订单编号
     * @param tableName 餐桌号
     * @param itemSerial 菜品自定义序列号
     * @param goodsWeight 菜品重量
     * @return
     * @throws Exception
     */
    public boolean weightconfirm(String shopEntityId, String orderId, String tableName, String itemSerial, String goodsWeight) throws Exception;

    /**
     * 接口gasl13:查询优惠劵信息（会员用户的优惠券信息）
     * @param shopEntityId 实体店编号
     * @param scardNo 会员卡号
     * @return
     * @throws Exception
     */
    public FindCouponRoot findCoupon(String shopEntityId, String scardNo) throws Exception;

}
