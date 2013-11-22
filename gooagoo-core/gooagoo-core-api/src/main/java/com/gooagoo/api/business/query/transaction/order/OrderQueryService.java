package com.gooagoo.api.business.query.transaction.order;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.gooagoo.entity.business.transaction.OrderDetailInShopEntity;
import com.gooagoo.entity.business.transaction.OrderDetailInfo4TableBusiness;
import com.gooagoo.entity.business.transaction.OrderGoodsBusiness;
import com.gooagoo.entity.business.transaction.OrderInShopEntity;
import com.gooagoo.entity.business.transaction.OrderInfoBusiness;
import com.gooagoo.entity.business.transaction.OrderLinkDetailInfoBusiness;
import com.gooagoo.entity.business.transaction.PurchasedGoodsBusiness;
import com.gooagoo.entity.business.user.favorite.coupon.CouponInfoBusiness;

public interface OrderQueryService
{

    /**
     * 根据桌号获取订单信息
     * mobe07,gasj04
     * @param shopEntityId 实体店编号
     * @param deskName 桌号
     * @param roomName 房间号
     * @return  OrderDetailInfo4TableBusiness
     * @throws Exception
     */
    public OrderDetailInfo4TableBusiness findOrderListByTable(String shopEntityId, String deskName, String roomName, Integer pageIndex, Integer pageSize) throws Exception;

    /**
     * 用户获取账单信息接口（商家服务器）
     * gtsc02,mobe01,mobe16
     * @param userId 用户编号
     * @param shopId 商家编号
     * @param shopType 商家类型编号
     * @param orderId 订单编号
     * @param deliveryStatus 取货状态: Y-已取货、N-未取货
     * @param scardno 用户音频会员卡号
     * @param cTimeStamp 时间戳
     * @param shopEntityId 实体店编号
     * @param billType 订单状态(B:账单,O:订单)
     * @param date 日期(YYYY-MM-DD)
     * @param pageId (账单编号:查询大于或小于此编号的账单列表)
     * @return List<OrderDetailInfoBusiness>
     * @throws Exception
     */
    public OrderLinkDetailInfoBusiness findOrderListForAll(String userId, String shopId, String shopTypeId, String orderId, String deliveryStatus, String scardno, String shopEntityId, String cTimeStamp, String billType, String date, String pageId, String pageType, Integer pageSize) throws Exception;

    /**
     * 4.3.5. 统计用户电子账单数量
     * @param userId
     * @param shopId
     * @param begin
     * @param end
     * @param goodsName
     * @return
     * @throws Exception
     */
    public Integer countOrderList(String userId, String shopId, Date begin, Date end, String goodsName) throws Exception;

    /**
     * 4.3.5. 用户查询电子账单列表（分页）
     * @param userId
     * @param shopId
     * @param begin
     * @param end
     * @param goodsName
     * @param pageIndex
     * @param pageSize
     * @param orderBy
     * @return
     * @throws Exception
     */
    public List<OrderInfoBusiness> findOrderList(String userId, String shopId, Date begin, Date end, String goodsName, Integer pageIndex, Integer pageSize, String orderBy) throws Exception;

    /**
     * 4.3.6. 电子账单商品列表
     * <br>
     * 根据用户账单ID查询
     * @param orderId
     * @return List<OrderDetailInfo>
     * @throws Exception
     */
    public List<OrderGoodsBusiness> findOrderDetail(String orderId) throws Exception;

    /**
     * 店员查询用户在本实体店的消费记录
     * gase03
     * @param shopEntityId
     * @param userId
     * @throws Exception
     */
    public List<OrderInShopEntity> findOrderListInShopEntity(String shopEntityId, String userId, Integer pageIndex, Integer pageSize) throws Exception;

    /**
     * 查询用户在实体店的消费记录明细
     * gase04
     * @param shopEntityId
     * @param userId
     * @return
     * @throws Exception
     */
    public List<OrderDetailInShopEntity> findOrderDetailInShopEntity(String orderId, Integer pageIndex, Integer pageSize) throws Exception;

    /**
     * mobk03:已购买过的商品 
     * @param userId 用户编号
     * @param shopId 商家编号
     * @param shopType 商家类别，通过商铺类别查询时必填
     * @param shopEntityId 实体店编，通过卡查询时购过商品必填
     * @param goodsName 商品名称模糊查询
     * @param begin 开始时间
     * @param end 结束时间 yyyy-MM-dd HH:mm:ss
     * @param pageIndex 页码
     * @param pageSize 每页信息显示条数
     * @return
     * @throws Exception
     */
    public List<PurchasedGoodsBusiness> findBoughtGoods(String userId, String shopId, String shopType, String shopEntityId, String goodsName, String begin, String end, Integer pageIndex, Integer pageSize) throws Exception;

    /**
     * 商家查询重量确认
     * @param mac 所属转发器mac地址
     * @param shopEntityId 实体店编号
     * @param ctimestamp 订单编号
     * @return
     * @throws Exception
     */
    public List<Map<String, String>> findConfirmWeight(String mac, String shopEntityId, String ctimestamp) throws Exception;

    /**
     * 接口gtsc23:商家查询修改台头请求
     * @param mac 转发器MAC地址
     * @param shopEntityId 实体店编号
     * @param cTimeStamp 最大时间戳
     * @return
     * @throws Exception
     */
    public List<Map<String, String>> findDiningNumbers(String mac, String shopentityid, String cTimeStamp) throws Exception;

    /**
     * 接口gtsc29:转发器查询优惠凭证信息
     * @param shopEntityId 实体店编号
     * @param cTimeStamp 最大时间戳
     * @return
     * @throws Exception
     */
    public List<CouponInfoBusiness> findCouponInfo(String shopEntityId, String cTimeStamp) throws Exception;
}
