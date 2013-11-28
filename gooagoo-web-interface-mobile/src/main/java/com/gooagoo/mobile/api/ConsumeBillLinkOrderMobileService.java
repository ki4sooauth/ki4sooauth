package com.gooagoo.mobile.api;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.mobile.entity.mobe01.transform.BillListgRoot;
import com.gooagoo.mobile.entity.mobe04.transform.CookbookRoot;
import com.gooagoo.mobile.entity.mobe05.transform.SubmitOrderFormRoot;
import com.gooagoo.mobile.entity.mobe07.transform.GetOrderFormRoot;

/**
 * 消费账单有关订单接口
 * 如果接口接口入参同时存在userId,sessionId,则需要先校验是否登录
 */
public interface ConsumeBillLinkOrderMobileService
{
    /**
     * 接口 mobe01 : 用户获取账单信息接口（Gooagoo服务器）
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param shopId 商家编号
     * @param ctimestamp 最大时间戳
     * @param orderId 订单编号
     * @param pageType 订单编号
     * @param pageSize 每页信息显示条数
     * @param date 日期，YYYY-MM-DD，如果传入date则查询当日的账单
     * @param ordertype 订单/账单类型,，-1-远程提交，0-用户提交，1-商家处理，2-申请结账，3-已结账
     * @param deliverystatus 取货状态，Y-已经取货 N-未取货
     * @param shopTypeId 商家类型编号
     * @return
     * @throws Exception
     */
    public BillListgRoot getBillListOfGooagoo(String userId, String sessionId, String shopId, String cTimeStamp, String orderId, String pageType, String pageSize, String date, String ordertype, String deliverystatus, String shopTypeId) throws Exception;

    /**
     * 接口 mobe02 : 用户根据账单信息申请开发票
     * @param userId 用户编号
     * @param sessionId 用户sessinoId
     * @param orderId  订单编号
     * @param invoicetype 发票类型，0-个人，1-公司
     * @param invoicedtile 发票抬头
     * @param invoiceditem 发票项目名称
     * @return
     * @throws Exception
     */
    public boolean applyOpenInvoice(String userId, String sessionId, String orderId, String invoicetype, String invoicedtile, String invoiceditem) throws Exception;

    /**
     * 接口 mobe04 : 获取菜谱 
     * @param userId 用户编号
     * @param sessionId 用户sessinoId
     * @param shopId 商家编号
     * @param shopEntityId 实体店编号
     * @param pageIndex 页码
     * @param pageSize 每页信息显示条数
     * @return
     * @throws Exception
     */
    public CookbookRoot getCookbook(String userId, String sessionId, String shopId, String shopEntityId, String pageIndex, String pageSize) throws Exception;

    /**
     * 接口 mobe05 : 手机提交订单（点菜单、快速结账） 
     * @param userId 用户编号
     * @param sessionId 用户sessinoId
     * @param shopId 商家编号
     * @param shopEntityId 实体店编号
     * @param request 接口入参集合（包括：couponid 优惠券编号（多个时以","分隔）、address-收货地址、name-收货人、phone-联系电话）
     * @param tableno2d 餐桌二维码，当“type=0-快速点餐”时此项有值则为“现场点餐”；无值则为“远程点餐”。格式为：实体店id^房间号^桌号 
     * @param goodsidlist 商品列表 格式如： [ { "goodsid": "Y12321d", "goodsnum":"2"}, { "goodsid": "Y12321", "goodsnum":"20"}, ]
     * @param type 订单类型
     * @return
     * @throws Exception
     */
    public SubmitOrderFormRoot submitOrder(String userId, String sessionId, String type, HttpServletRequest request, String shopId, String shopEntityId, String tableno2d, String goodsidlist) throws Exception;

    /**
     * 接口 mobe06 : 结帐申请
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param tableno2d 餐桌二维码 格式：["gooagoo","00","实体店编号","桌号","房间号"]
     * @param orderId 订单编号
     * @param shopId  商家编号
     * @param couponId 优惠券编号，多个时以","分隔
     * @return
     * @throws Exception
     */
    public boolean payBillApply(String userId, String sessionId, String tableno2d, String orderId, String shopId, String couponId) throws Exception;

    /**
     * 接口 mobe07 : 通过桌号获取点菜单信息 
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param tableno2d 桌号、房间
     * @return
     * @throws Exception
     */
    public GetOrderFormRoot getOrderByTableNo(String userId, String sessionId, String tableno2d) throws Exception;

    /**
     * 接口 mobe18 : 用户加菜申请 
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param mac 手机mac地址
     * @param shopId 商家编号
     * @param goodsInfo 商品列表 格式如：[ { "goodsid": "00017STNPL7NIGF1T0000LEIISQNS0DL", "goodsnum":"2"}, { "goodsid": "00017STNPL7NIGF1T0000LEIISQNS0DL", "goodsnum":"20"}]
     * @param tableNo2d 桌号，格式为：["gooagoo","00","实体店编号","桌号","房间号"] 
     * @return
     * @throws Exception
     */
    public boolean billAddApply(String userId, String sessionId, String mac, String shopId, String goodsInfo, String tableNo2d) throws Exception;

    /**
     * 接口 mobe19 : 手机端用户账单接口 
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param orderinfo 账单编号，如有多个以逗号分隔，如：1,2,3
     * @return
     * @throws Exception
     */
    public void DelUserBill(String userId, String sessionId, String orderinfo) throws Exception;

}
