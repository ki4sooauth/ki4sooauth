package com.gooagoo.core.business.transaction.order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.goods.cache.GoodsCacheCoreService;
import com.gooagoo.api.business.core.transaction.order.ShopBillCoreService;
import com.gooagoo.api.generator.core.bill.BillPayApplicationGeneratorCoreService;
import com.gooagoo.api.generator.core.bill.OrderCouponInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.bill.OrderDetailInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.bill.OrderInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.bill.OriginalBillDetailGeneratorCoreService;
import com.gooagoo.api.generator.core.bill.OriginalBillInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.bill.OriginalBillPicGeneratorCoreService;
import com.gooagoo.api.generator.core.goods.GoodsBaseInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.shop.ShopEntityInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.shop.ShopTableInfoGeneratorCoreService;
import com.gooagoo.api.protecteds.core.transaction.TransactionProtectedCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.business.transaction.OrderBusiness;
import com.gooagoo.entity.business.transaction.OrderResult;
import com.gooagoo.entity.business.transaction.OriginalBillBusiness;
import com.gooagoo.entity.generator.bill.BillPayApplication;
import com.gooagoo.entity.generator.bill.OrderCouponInfo;
import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.entity.generator.bill.OrderDetailInfoExample;
import com.gooagoo.entity.generator.bill.OrderInfo;
import com.gooagoo.entity.generator.bill.OrderInfoExample;
import com.gooagoo.entity.generator.bill.OrderPic;
import com.gooagoo.entity.generator.bill.OriginalBillDetail;
import com.gooagoo.entity.generator.bill.OriginalBillInfo;
import com.gooagoo.entity.generator.bill.OriginalBillPic;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.shop.ShopTableInfo;
import com.gooagoo.entity.generator.shop.ShopTableInfoExample;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.exception.business.bill.AlreadyApplyBillException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisListDao;
import com.gooagoo.redis.data.RedisStringDao;

@Service
public class ShopBillCoreServiceImpl implements ShopBillCoreService
{

    @Autowired
    BillPayApplicationGeneratorCoreService billPayApplicationGeneratorCoreService;

    @Autowired
    OrderCouponInfoGeneratorCoreService orderCouponInfoGeneratorCoreService;

    @Autowired
    OrderInfoGeneratorCoreService orderInfoGeneratorCoreService;

    @Autowired
    ShopTableInfoGeneratorCoreService shopTableInfoGeneratorCoreService;

    @Autowired
    GoodsBaseInfoGeneratorCoreService goodsBaseInfoGeneratorCoreService;

    @Autowired
    OriginalBillInfoGeneratorCoreService originalBillInfoGeneratorCoreService;

    @Autowired
    OriginalBillDetailGeneratorCoreService originalBillDetailGeneratorCoreService;

    @Autowired
    OriginalBillPicGeneratorCoreService originalBillPicGeneratorCoreService;

    @Autowired
    ShopEntityInfoGeneratorCoreService shopEntityInfoGeneratorCoreService;

    @Autowired
    TransactionProtectedCoreService transactionProtectedCoreService;

    @Autowired
    OrderDetailInfoGeneratorCoreService orderDetailInfoGeneratorCoreService;

    @Autowired
    GoodsCacheCoreService goodsCacheCoreService;

    /***
     * 4.3.1. 结账申请
     * @param tableName 桌号
     * @param scardno 音频卡号
     * @param orderCouponInfo 优惠券列表
     * @param billPayApplication 结账申请信息
     * @return true/false
     * @throws AlreadyApplyBillException 已申请结账异常
     */
    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean applyBill(String tableName, String scardno, BillPayApplication billPayApplication, List<OrderCouponInfo> orderCouponInfoList) throws Exception
    {
        //1.参数效验
        OrderInfo orderInfo = this.checkBillParam(tableName, billPayApplication, orderCouponInfoList);
        //TODO 2.验证优惠券是否使用 等待杨路的优惠券验证方法
        List<Map<String, String>> canNotUseCouponList = null;
        //3.补全结账申请信息,订单优惠凭证详情信息
        this.completionBillPayApplication(scardno, billPayApplication, orderCouponInfoList, canNotUseCouponList);
        //4.数据持久化（包括:新建bill_pay_application,更新order_info的,更新shop_table_info的status,新建order_coupon_info)
        this.saveApplyBill(billPayApplication, orderCouponInfoList);
        //实时统计正在结账数
        this.statisticsCheckoutNum(billPayApplication.getShopEntityId(), orderInfo.getDeskName(), "plus");
        if (StringUtils.hasText(tableName))
        {//远程或零售业提交订单，无需修改餐桌状态，当为店内提交订单时，需修改餐桌状态为空闲
            this.updateTableStatus4Redis(billPayApplication.getShopEntityId(), tableName, "空闲");
        }
        else
        {//餐桌号未传，根据订单信息查询出餐桌号,如接口GASL05
            if (billPayApplication != null && StringUtils.hasText(billPayApplication.getOrderId()))
            {
                if (StringUtils.hasText(orderInfo.getDeskName()))
                {
                    this.updateTableStatus4Redis(billPayApplication.getShopEntityId(), orderInfo.getDeskName(), "空闲");
                }
            }
        }
        //更新订单申请结账时间
        orderInfo.setPaymentApplicationTime(new Date());
        return this.orderInfoGeneratorCoreService.updateByPrimaryKeySelective(orderInfo);
    }

    /**
     * 校验结账申请参数
     * @param BillPayApplication billPayApplication
     * @param List<OrderCouponInfo> orderCouponInfoList
     * @throws NullException
     * @throws AlreadyApplyBillException
     */
    private OrderInfo checkBillParam(String tableName, BillPayApplication billPayApplication, List<OrderCouponInfo> orderCouponInfoList) throws NullException, AlreadyApplyBillException
    {
        if (billPayApplication == null)
        {
            GooagooLog.error("结账申请信息为空", null);
            throw new NullException("结账申请信息为空");
        }
        OrderInfo orderInfo = null;
        if (StringUtils.hasText(tableName))
        {
            //判断是否已结账
            OrderInfoExample orderInfoExample = new OrderInfoExample();
            orderInfoExample.createCriteria().andShopEntityIdEqualTo(billPayApplication.getShopEntityId()).andDeskNameEqualTo(tableName).andBillTypeNotEqualTo("3").andIsDelEqualTo("N");
            List<OrderInfo> orderInfoList = this.orderInfoGeneratorCoreService.selectByExample(orderInfoExample);
            if (CollectionUtils.isEmpty(orderInfoList))
            {
                throw new NullException("订单不存在[shopEntityId=" + billPayApplication.getShopEntityId() + "、tableName=" + tableName + "]");
            }
            orderInfo = orderInfoList.get(0);
        }
        else
        {
            orderInfo = this.orderInfoGeneratorCoreService.selectByPrimaryKey(billPayApplication.getOrderId());
            if (orderInfo == null)
            {
                throw new NullException("订单不存在[orderId=" + billPayApplication.getOrderId() + "]");
            }
        }
        if (orderInfo.getPaymentApplicationTime() != null)
        {
            GooagooLog.warn("orderId=" + orderInfo.getOrderId() + "订单已申请过结账");
            throw new AlreadyApplyBillException("orderId=" + orderInfo.getOrderId() + "订单已申请过结账");
        }
        return orderInfo;
    }

    /**
     * 补全结账申请信息,订单优惠凭证详情信息
     * @param billPayApplication
     * @param orderCouponInfoList
     * @param canNotUseCouponList
     */
    private void completionBillPayApplication(String scardno, BillPayApplication billPayApplication, List<OrderCouponInfo> orderCouponInfoList, List<Map<String, String>> canNotUseCouponList)
    {
        //补全结账申请信息
        billPayApplication.setApplyTime(new Date());
        billPayApplication.setIsDeal("N");
        billPayApplication.setIsDel("N");
        Map<String, String> map = this.transactionProtectedCoreService.getAccount(billPayApplication.getShopId(), null, scardno);
        if (map != null && map.size() > 0)
        {
            billPayApplication.setUserId(map.get("userid"));
        }
        if (orderCouponInfoList != null)
        {
            //补全订单优惠凭证详情信息
            for (OrderCouponInfo orderCouponInfo : orderCouponInfoList)
            {
                orderCouponInfo.setOrderDetailId(UUID.getUUID());
                //TODO 订单优惠券来源还不是很清楚，暂时给个0，（优惠凭证来源，0-购阿购）
                orderCouponInfo.setCouponSource("0");
                orderCouponInfo.setIsDeal("N");
                orderCouponInfo.setIsDel("N");
            }
        }
    }

    /**
     * 结账申请对应的数据持久化（包括:新建bill_pay_application,更新order_info的,更新shop_table_info的status,新建order_coupon_info)
     * @param billPayApplication
     * @param orderCouponInfoList
     * @throws Exception 
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    private void saveApplyBill(BillPayApplication billPayApplication, List<OrderCouponInfo> orderCouponInfoList) throws Exception
    {
        //持久化结账申请bill_pay_application
        if (!this.billPayApplicationGeneratorCoreService.insertSelective(billPayApplication))
        {
            GooagooLog.error("新增结账申请失败[" + billPayApplication.toString() + "]", null);
            throw new GooagooException("新增结账申请失败");
        }
        if (CollectionUtils.isNotEmpty(orderCouponInfoList))
        {
            //持久化订单优惠凭证详情order_coupon_info
            for (OrderCouponInfo orderCouponInfo : orderCouponInfoList)
            {
                if (!this.orderCouponInfoGeneratorCoreService.insertSelective(orderCouponInfo))
                {
                    GooagooLog.error("新增订单优惠凭证详情失败[" + orderCouponInfo.toString() + "]", null);
                    throw new GooagooException("新增订单优惠凭证详情失败");
                }
            }
        }
        OrderInfo orderInfo = this.orderInfoGeneratorCoreService.selectUnDelByPrimaryKey(billPayApplication.getOrderId());
        if (orderInfo == null)
        {
            GooagooLog.warn("查询orderId=" + billPayApplication.getOrderId() + "的订单信息为空");
            throw new NullException("查询订单信息为空");
        }
        orderInfo.setBillType("2");
        if (!this.orderInfoGeneratorCoreService.updateByPrimaryKeySelective(orderInfo))
        {
            GooagooLog.error("更新[orderId=" + orderInfo.getOrderId() + "]订单信息状态为2-申请结账失败", null);
            throw new GooagooException("更新订单信息失败");
        }
        ShopTableInfoExample shopTableInfoExample = new ShopTableInfoExample();
        shopTableInfoExample.createCriteria().andShopEntityIdEqualTo(billPayApplication.getShopEntityId()).andRoomNameEqualTo(orderInfo.getDeskName()).andIsDelEqualTo("N");
        //餐厅桌号信息
        //        List<ShopTableInfo> shopTableInfoList = this.shopTableInfoGeneratorCoreService.selectByExample(shopTableInfoExample);
        //        if (CollectionUtils.isEmpty(shopTableInfoList))
        //        {
        //            GooagooLog.warn("查询shopEntityId=" + billPayApplication.getShopEntityId() + ",roomName=" + orderInfo.getDeskName() + "的餐厅桌号信息为空");
        //            throw new NullException("查询餐厅桌号信息为空");
        //        }
        //        ShopTableInfo shopTableInfo = shopTableInfoList.get(0);
        //        shopTableInfo.setStatus("3");
        //        //持久化餐厅桌号信息(餐桌状态改为3-正在结账)
        //        if (this.shopTableInfoGeneratorCoreService.updateByPrimaryKeySelective(shopTableInfo) < 1)
        //        {
        //            GooagooLog.error("更新[id=" + shopTableInfo.getId() + "]餐厅桌号信息餐桌状态为3-正在结账失败", null);
        //            throw new GooagooException("更新订单信息失败");
        //        }
    }

    /***
     * 商家账单数据上传
     * gtsc05
     * @param originalBillDetail
     * @return true/false
     * @throws Exception
     */
    @Override
    public OrderResult addShopBill(OriginalBillInfo originalBillInfo, List<OriginalBillDetail> originalBillDetailList, OriginalBillPic originalBillPic) throws Exception
    {
        //1.参数效验
        this.checkShopBillParam(originalBillInfo, originalBillDetailList, originalBillPic);
        //2.补全商家订单
        OrderBusiness orderBusiness = this.getOrderBusiness(originalBillInfo, originalBillDetailList, originalBillPic);
        //3.补全结账原始账单信息,原始账单信息图片详情,原始账单商品详情
        OriginalBillBusiness originalBillBusiness = this.completionOriginalBill(orderBusiness, originalBillInfo, originalBillDetailList, originalBillPic);
        originalBillInfo = originalBillBusiness.getOriginalBillInfo();
        originalBillDetailList = originalBillBusiness.getOriginalBillDetailList();
        originalBillPic = originalBillBusiness.getOriginalBillPic();
        //4.数据持久化(新建original_bill_detail,新建original_bill_info,新建original_bill_pic,合并order_info,,,)
        this.save(orderBusiness, originalBillInfo, originalBillDetailList, originalBillPic);
        //实时统计正在结账数
        this.statisticsCheckoutNum(originalBillInfo.getShopEntityId(), originalBillInfo.getDeskName(), "minus");
        //转发器提交账单时需修改餐桌状态为空闲
        this.updateTableStatus4Redis(originalBillInfo.getShopEntityId(), originalBillInfo.getDeskName(), "空闲");
        OrderResult orderResult = new OrderResult();
        orderResult.setOrderId(orderBusiness.getOrderInfo().getOrderId());
        return orderResult;
    }

    /**
     * 验证商家账单数据上传参数
     * @param originalBillInfo
     * @param originalBillDetailList
     * @param originalBillPic
     * @throws Exception 
     */
    private void checkShopBillParam(OriginalBillInfo originalBillInfo, List<OriginalBillDetail> originalBillDetailList, OriginalBillPic originalBillPic) throws Exception
    {
        if (originalBillInfo == null)
        {
            GooagooLog.error("原始账单信息为空", null);
            throw new NullException("原始账单信息为空");
        }
        //        if (originalBillPic == null)
        //        {
        //            GooagooLog.error("原始账单信息图片详情为空", null);
        //            throw new NullException("原始账单信息图片详情为空");
        //        }
        //        if (CollectionUtils.isEmpty(originalBillDetailList))
        //        {
        //            GooagooLog.error("原始账单商品详情为空", null);
        //            throw new NullException("原始账单商品详情为空");
        //        }
    }

    /**
     * 订单信息
     * @param originalBillInfo
     * @param originalBillDetailList
     * @param originalBillPic
     * @return
     * @throws Exception 
     */
    private OrderBusiness getOrderBusiness(OriginalBillInfo originalBillInfo, List<OriginalBillDetail> originalBillDetailList, OriginalBillPic originalBillPic) throws Exception
    {
        OrderBusiness orderBusiness = new OrderBusiness();
        OrderInfo orderInfo = this.transactionProtectedCoreService.getNotCheckoutOrder(originalBillInfo.getDeskName(), originalBillInfo.getShopEntityId());
        List<OrderDetailInfo> orderDetailInfoList = new ArrayList<OrderDetailInfo>();
        List<OrderDetailInfo> orderDetailInfoListExist = null;
        String shopEntityId = null;
        String orderId = null;
        String shopId = null;
        String userId = null;
        String scardNo = null;
        if (orderInfo != null)
        {//数据库有订单信息
            orderBusiness.setOrderInfoUpdateType("2");//增量更新订单
            OrderDetailInfoExample orderDetailInfoExample = new OrderDetailInfoExample();
            orderDetailInfoExample.createCriteria().andOrderIdEqualTo(orderInfo.getOrderId());
            orderDetailInfoListExist = this.orderDetailInfoGeneratorCoreService.selectByExample(orderDetailInfoExample);
            orderId = orderInfo.getOrderId();
            shopId = orderInfo.getShopId();
            shopEntityId = orderInfo.getShopEntityId();
            userId = orderInfo.getUserId();
            scardNo = orderInfo.getScardNo();
        }
        else
        {//数据库无订单信息
            orderBusiness.setOrderInfoUpdateType("1");//新建订单
            orderInfo = new OrderInfo();
            orderInfo.setIsSaCommit("N");//不是店员助理提交
            orderId = this.transactionProtectedCoreService.getOrderId(orderInfo.getShopEntityId());
            if (!StringUtils.hasText(orderId))
            {
                throw new GooagooException("生成订单号失败");
            }
            shopEntityId = originalBillInfo.getShopEntityId();
            shopId = originalBillInfo.getShopId();
            Map<String, String> accountHm = this.transactionProtectedCoreService.getAccount(originalBillInfo.getShopId(), originalBillInfo.getUserId(), originalBillInfo.getScardNo());
            if (accountHm != null && accountHm.size() > 0)
            {//非会员的情况下，查询不到会员信息
                userId = accountHm.get("userid");
                scardNo = accountHm.get("scardno");
            }
        }
        Integer goodsTotalNum = 0;//订单商品总数
        Double originalPrice = 0.00;//订单原价格
        Double payPrice = 0.00;//订单实际支付价格
        if (CollectionUtils.isNotEmpty(originalBillDetailList))
        {
            for (OriginalBillDetail originalBillDetail : originalBillDetailList)
            {
                Double payPriceTemp = originalBillDetail.getPayPrice() != null ? originalBillDetail.getPayPrice() : 0.00;
                Integer goodsNumTemp = originalBillDetail.getGoodsNum() != null ? originalBillDetail.getGoodsNum() : 0;
                OrderDetailInfo orderDetailInfo = new OrderDetailInfo();
                OrderDetailInfo orderDetailInfoExist = this.transactionProtectedCoreService.getMatchOrderDetailInfo(originalBillDetail.getGoodsId(), originalBillDetail.getGoodsName(), orderDetailInfoListExist);
                if (orderDetailInfoExist != null)
                {//1-商家订单（数据库有订单）更新
                    orderBusiness.setOrderDetailInfoUpdateType("3");//订单商品详细信息更新类型1-新建2-增量更新3-全量更新
                    orderDetailInfo.setPrice(orderDetailInfoExist.getPrice());
                    orderDetailInfo.setPayPrice(originalBillDetail.getPayPrice());//实际支付单价（来自账单文件）
                    orderDetailInfo.setGoodsNum(originalBillDetail.getGoodsNum());//商品数量（来自账单文件）
                    orderDetailInfo.setTotalPrice(originalBillDetail.getPayPrice() * originalBillDetail.getGoodsNum());//实际支付总价=商品数量×实际支付单价
                    orderDetailInfoList.add(orderDetailInfo);
                }
                else
                {//新建
                    orderBusiness.setOrderDetailInfoUpdateType("1");//订单商品详细信息更新类型1-新建2-增量更新3-全量更新
                    GoodsBaseInfo goodsBaseInfo = this.transactionProtectedCoreService.getGoodsBaseInfoFromDB(shopEntityId, originalBillDetail.getGoodsName(), originalBillDetail.getGoodsItemSerial());
                    if (goodsBaseInfo != null)
                    {
                        orderDetailInfo.setGoodsId(goodsBaseInfo.getGoodsId());//商品编号
                        orderDetailInfo.setGoodsCategoryRoot(goodsBaseInfo.getGoodsCategoryRoot());//品类编号（根节点）
                        orderDetailInfo.setGoodsCategoryLeaf(goodsBaseInfo.getGoodsCategoryLeaf());//品类编号（叶节点）
                        orderDetailInfo.setGoodsBrand(goodsBaseInfo.getGoodsBrand());//品牌编号
                        orderDetailInfo.setGoodsSerial(goodsBaseInfo.getGoodsSerial());//商品序列号（商品的唯一识别编码）
                        orderDetailInfo.setItemSerial(goodsBaseInfo.getItemSerial());//自定义序列号（商品细分的唯一识别编码）
                        orderDetailInfo.setPrice(goodsBaseInfo.getPrice());//商品价格
                        Map<String, String> goodsInfo;
                        try
                        {
                            goodsInfo = this.goodsCacheCoreService.findGoodsInfo(goodsBaseInfo.getGoodsId());
                            if (goodsInfo != null)
                            {
                                orderDetailInfo.setGoodsImg(StringUtils.hasText(goodsInfo.get("goodsImg")) ? JsonUtils.json2List(goodsInfo.get("goodsImg")).get(0) : null);//商品主图地址
                            }
                        }
                        catch (Exception e)
                        {
                            GooagooLog.error("通过goodsId查询商品缓存详细出错，GoodsId=" + goodsBaseInfo.getGoodsId(), null);
                        }
                    }
                    orderDetailInfo.setOrderDetailId(UUID.getUUID());//订单明细编号，UUID
                    orderDetailInfo.setOrderId(orderId);//订单编号
                    orderDetailInfo.setGoodsName(StringUtils.hasText(originalBillDetail.getGoodsName()) ? originalBillDetail.getGoodsName() : "-");//商品名称（来自账单文件）
                    orderDetailInfo.setShopId(shopId);//商家编号
                    orderDetailInfo.setShopEntityId(shopEntityId);//实体店编号
                    orderDetailInfo.setPayPrice(payPriceTemp);//实际支付单价（来自账单文件）
                    orderDetailInfo.setGoodsNum(goodsNumTemp);//商品数量（来自账单文件）
                    if (originalBillDetail.getTotalPrice() != null)
                    {//如果商家订单上传的商品列表中对于商品总价格不为null,则总价格取该值
                        orderDetailInfo.setTotalPrice(originalBillDetail.getTotalPrice());
                    }
                    else
                    {
                        orderDetailInfo.setTotalPrice(payPriceTemp * goodsNumTemp);//实际支付总价=商品数量×实际支付单价
                    }
                    orderDetailInfo.setUserId(userId);//提交者（只保留第一个提交此商品的人，后来提交的只做数量合并，不覆盖提交者）
                    orderDetailInfo.setServeNum(0);//上菜情况（仅针对餐饮），默认值为0
                    orderDetailInfoList.add(orderDetailInfo);
                }
                //为订单信息提供数据
                goodsTotalNum = goodsTotalNum + goodsNumTemp;//订单商品总数
                payPrice = originalPrice + orderDetailInfo.getTotalPrice();//订单实际支付价格 

                if (orderDetailInfo.getPrice() == null)
                {
                    originalPrice = payPrice;
                }
                else
                {
                    originalPrice = originalPrice + orderDetailInfo.getPrice() * orderDetailInfo.getGoodsNum();//订单原价格
                }
            }
            orderBusiness.setOrderDetailInfoList(orderDetailInfoList);
        }
        if (StringUtils.hasText(originalBillInfo.getThirdOrderId()))
        {
            orderInfo.setThirdOrderId(originalBillInfo.getThirdOrderId());//第三方订单编号
        }
        orderInfo.setMac(originalBillInfo.getMac());//商家硬件设备MAC地址
        orderInfo.setRequestTime(new Date());//消费时间
        //判断是否为线上支付商家
        if (this.isOnlineShop(shopId))
        {
            orderInfo.setBillType("1");//订单状态，0-用户提交，1-商家处理，2-申请结账，3-已结账
        }
        else
        {
            orderInfo.setBillType("3");//订单状态，0-用户提交，1-商家处理，2-申请结账，3-已结账
            orderInfo.setPaymentTime(new Date());//结账时间
        }
        orderInfo.setUserId(userId);//用户编号
        orderInfo.setScardNo(scardNo);//会员卡号，16位音频卡号
        orderInfo.setGoodsTotalNum(goodsTotalNum);//账单商品总数
        orderInfo.setOriginalPrice(originalPrice);//原价格
        orderInfo.setPayPrice(payPrice);//实际支付价格
        if (originalPrice != null && originalPrice != 0.00)
        {
            orderInfo.setDiscountRate(payPrice / originalPrice);//折扣
        }
        if (StringUtils.hasText(originalBillInfo.getRoomName()))
        {
            orderInfo.setRoomName(originalBillInfo.getRoomName());//房间名称（仅针对餐饮）
        }
        if (StringUtils.hasText(originalBillInfo.getDeskName()))
        {
            orderInfo.setDeskName(originalBillInfo.getDeskName());//桌子名称（仅针对餐饮）
        }
        orderInfo.setShopOrderTime(new Date());//商家订单提交时间（仅针对餐饮）
        orderInfo.setIsDel("N");//是否删除，Y-已删除，N-未删除
        orderInfo.setOrderId(orderId);//订单编号，UUID
        orderInfo.setShopId(originalBillInfo.getShopId());//商家编号
        orderInfo.setShopEntityId(originalBillInfo.getShopEntityId());//实体店编号
        orderBusiness.setOrderInfo(orderInfo);
        if (originalBillPic != null && StringUtils.hasText(originalBillPic.getPicUrl()))
        {
            List<OrderPic> orderPicList = new ArrayList<OrderPic>();
            orderPicList.add(this.transactionProtectedCoreService.getOrderPic(orderId, originalBillPic.getPicUrl(), "1"));
            orderBusiness.setOrderPicList(orderPicList);
        }
        return orderBusiness;
    }

    /**
     * 补全用户订单
     * @param userOrderInfo
     * @param userOrderDetailList
     * @param userOrderCouponList
     * @return
     */
    private OriginalBillBusiness completionOriginalBill(OrderBusiness orderBusiness, OriginalBillInfo originalBillInfo, List<OriginalBillDetail> originalBillDetailList, OriginalBillPic originalBillPic)
    {
        OriginalBillBusiness originalBillBusiness = new OriginalBillBusiness();
        String billId = UUID.getUUID();
        //补全原始账单信息original_bill_info
        originalBillInfo = this.completionOriginalBillInfo(billId, orderBusiness.getOrderInfo(), originalBillInfo);
        //补全原始账单商品详情original_bill_detail
        originalBillDetailList = this.completionOriginalBillDetail(billId, orderBusiness.getOrderDetailInfoList());
        //补全用户订单原始信息优惠凭证详情user_order_coupon
        originalBillPic = this.completionOriginalBillPic(billId, originalBillPic);
        originalBillBusiness.setOriginalBillInfo(originalBillInfo);
        originalBillBusiness.setOriginalBillDetailList(originalBillDetailList);
        originalBillBusiness.setOriginalBillPic(originalBillPic);
        return originalBillBusiness;
    }

    /**
     * 补全原始账单信息original_bill_info
     * @param billId
     * @param orderInfo
     * @param originalBillInfo
     * @return
     */
    private OriginalBillInfo completionOriginalBillInfo(String billId, OrderInfo orderInfo, OriginalBillInfo originalBillInfo)
    {
        originalBillInfo.setOrderId(orderInfo.getOrderId());
        originalBillInfo.setBillId(billId);
        originalBillInfo.setUserId(orderInfo.getUserId());
        originalBillInfo.setRequestTime(orderInfo.getRequestTime());
        originalBillInfo.setScardNo(orderInfo.getScardNo());
        originalBillInfo.setGoodsTotalNum(orderInfo.getGoodsTotalNum());
        originalBillInfo.setOriginalPrice(orderInfo.getOriginalPrice());
        originalBillInfo.setDiscountRate(orderInfo.getDiscountRate());
        originalBillInfo.setIsDel("N");
        return originalBillInfo;
    }

    /**
     * 补全原始账单商品详情original_bill_detail
     * @param billId
     * @param orderInfo
     * @param originalBillInfo
     * @return
     */
    private List<OriginalBillDetail> completionOriginalBillDetail(String billId, List<OrderDetailInfo> orderDetailInfoList)
    {
        List<OriginalBillDetail> originalBillDetailList = new ArrayList<OriginalBillDetail>();
        for (OrderDetailInfo orderDetailInfo : orderDetailInfoList)
        {
            OriginalBillDetail originalBillDetail = new OriginalBillDetail();
            originalBillDetail.setBillDetailId(UUID.getUUID());
            originalBillDetail.setBillId(billId);
            originalBillDetail.setGoodsId(orderDetailInfo.getGoodsId());
            originalBillDetail.setGoodsName(orderDetailInfo.getGoodsName());
            originalBillDetail.setGoodsNum(orderDetailInfo.getGoodsNum());
            originalBillDetail.setGoodsPrice(orderDetailInfo.getPrice());
            originalBillDetail.setPayPrice(orderDetailInfo.getPayPrice());
            originalBillDetail.setShopEntityId(orderDetailInfo.getShopEntityId());
            originalBillDetail.setShopId(orderDetailInfo.getShopId());
            originalBillDetail.setTotalPrice(orderDetailInfo.getTotalPrice());
            originalBillDetailList.add(originalBillDetail);
        }
        return originalBillDetailList;
    }

    /**
     * 补全用户订单原始信息优惠凭证详情user_order_coupon
     * @param shopOrderId
     * @param shopOrderPic
     * @return
     */
    private OriginalBillPic completionOriginalBillPic(String billId, OriginalBillPic originalBillPic)
    {
        originalBillPic.setBillDetailId(UUID.getUUID());
        originalBillPic.setBillId(billId);
        return originalBillPic;
    }

    /**
     * 数据持久化
     * @param orderBusiness
     * @param originalBillInfo
     * @param originalBillDetailList
     * @param originalBillPic
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    private void save(OrderBusiness orderBusiness, OriginalBillInfo originalBillInfo, List<OriginalBillDetail> originalBillDetailList, OriginalBillPic originalBillPic) throws Exception
    {
        //保存原始账单信息
        this.saveOriginalBill(originalBillInfo, originalBillDetailList, originalBillPic);
        //保存订单
        this.transactionProtectedCoreService.saveOrderInfo(orderBusiness);
    }

    /**
     * 保存原始账单信息
     * @param originalBillInfo
     * @param originalBillDetailList
     * @param originalBillPic
     * @throws GooagooException
     */
    private void saveOriginalBill(OriginalBillInfo originalBillInfo, List<OriginalBillDetail> originalBillDetailList, OriginalBillPic originalBillPic) throws GooagooException
    {
        //新建原始账单信息
        if (!this.originalBillInfoGeneratorCoreService.insertSelective(originalBillInfo))
        {
            GooagooLog.error("[billId=" + originalBillInfo.getBillId() + "]新建原始账单信息失败", null);
            throw new GooagooException("新建原始账单信息失败");
        }
        //新建原始账单商品详情
        for (OriginalBillDetail originalBillDetail : originalBillDetailList)
        {
            if (!this.originalBillDetailGeneratorCoreService.insertSelective(originalBillDetail))
            {
                GooagooLog.error("[billDetailId=" + originalBillDetail.getBillDetailId() + "]新建原始账单商品详情失败", null);
                throw new GooagooException("新建原始账单商品详情失败");
            }
        }
        //新建原始账单信息图片详情
        if (!this.originalBillPicGeneratorCoreService.insertSelective(originalBillPic))
        {
            GooagooLog.error("[billDetailId=" + originalBillPic.getBillDetailId() + "]新建原始账单信息图片详情失败", null);
            throw new GooagooException("新建原始账单信息图片详情失败");
        }

    }

    /**
     * 统计正在结账数量(申请结账时加1、商家账单数据上传时减1)
     * @param shopEntityId 实体店编号
     * @param tableName 桌号
     * @param statisticsType 统计类型(plus:加  minus:减)
     * redis-key:shopEntityId_tableTypeCode
     */
    private void statisticsCheckoutNum(String shopEntityId, String tableName, String statisticsType)
    {
        ShopTableInfoExample shopTableInfoExample = new ShopTableInfoExample();
        shopTableInfoExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andTableNameEqualTo(tableName).andIsDelEqualTo("N");
        List<ShopTableInfo> shopTableInfoList = this.shopTableInfoGeneratorCoreService.selectByExample(shopTableInfoExample);
        if (CollectionUtils.isNotEmpty(shopTableInfoList))
        {
            ShopTableInfo shopTableInfo = shopTableInfoList.get(0);
            String key = shopTableInfo.getShopEntityId() + "_" + shopTableInfo.getTableTypeCode();
            RedisStringDao redisStringDao = new RedisStringDao(RedisServerConstants.catering_checkout);
            String checkout = redisStringDao.get(key);
            if ("plus".equals(statisticsType))//申请结账
            {
                Integer checkoutNum = StringUtils.hasText(checkout) ? Integer.parseInt(checkout) + 1 : 1;
                redisStringDao.set(key, checkoutNum.toString());
            }
            else if ("minus".equals(statisticsType))//商家账单数据上传
            {
                if (StringUtils.hasText(checkout))
                {
                    if ("1".equals(checkout))
                    {
                        RedisDatabase redisDatabase = new RedisDatabase(RedisServerConstants.catering_checkout);
                        redisDatabase.del(key);
                    }
                    else
                    {
                        Integer checkoutNum = Integer.parseInt(checkout) - 1;
                        redisStringDao.set(key, checkoutNum.toString());
                    }
                }
            }
        }
    }

    /**
     * 更新redis中的餐桌状态
     * @param list
     * @param tablestatus 餐桌状态 1-空闲
     */
    private void updateTableStatus4Redis(String shopEntityId, String tableName, String tableStatus)
    {
        boolean changed = false;
        RedisListDao listDao = new RedisListDao(RedisServerConstants.catering_table);
        List<String> list = listDao.get(shopEntityId);
        if (CollectionUtils.isNotEmpty(list))
        {
            for (int i = 0; i < list.size(); i++)
            {
                if (changed)
                {
                    break;
                }
                Map<String, String> tableMap = JsonUtils.json2Map(list.get(i));
                if (tableName.equals(tableMap.get("tablename")))
                {
                    tableMap.put("tablestate", tableStatus);
                    list.set(i, JsonUtils.toJson(tableMap));
                    changed = true;
                }
            }
        }
        if (changed)
        {
            RedisDatabase baseDao = new RedisDatabase(RedisServerConstants.catering_table);
            baseDao.del(shopEntityId);
            listDao.set(shopEntityId, list);
        }
    }

    /**判断是否为线上支付商家
     * @param shopId
     * @return
     */
    private boolean isOnlineShop(String shopId)
    {
        ResourceBundle bundle = ResourceBundle.getBundle("coreConfig");
        String onlinePayShopIds = bundle.getString("online_pay_shop");
        if (StringUtils.hasText(onlinePayShopIds))
        {
            List<String> onlinePayShopIdList = Arrays.asList(onlinePayShopIds.split(","));
            for (String onlinePayShopId : onlinePayShopIdList)
            {
                if (shopId.equals(onlinePayShopId))
                {
                    return true;
                }
            }
        }
        return false;
    }

}
