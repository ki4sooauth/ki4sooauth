package com.gooagoo.core.business.transaction.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.goods.cache.GoodsCacheCoreService;
import com.gooagoo.api.business.core.shop.cache.TableCacheCoreService;
import com.gooagoo.api.business.core.transaction.order.UserOrderCoreService;
import com.gooagoo.api.generator.core.bill.BillInvoiceLogGeneratorCoreService;
import com.gooagoo.api.generator.core.bill.OrderInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.bill.ShoppingCartGeneratorCoreService;
import com.gooagoo.api.generator.core.bill.UserOrderCouponGeneratorCoreService;
import com.gooagoo.api.generator.core.bill.UserOrderDetailGeneratorCoreService;
import com.gooagoo.api.generator.core.bill.UserOrderInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.shop.ShopTableInfoGeneratorCoreService;
import com.gooagoo.api.protecteds.core.transaction.TransactionProtectedCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.business.transaction.CanNotUseCoupon;
import com.gooagoo.entity.business.transaction.OrderBusiness;
import com.gooagoo.entity.business.transaction.OrderCouponBusiness;
import com.gooagoo.entity.business.transaction.OrderResult;
import com.gooagoo.entity.generator.bill.BillAddInfo;
import com.gooagoo.entity.generator.bill.BillInvoiceLog;
import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.entity.generator.bill.OrderInfo;
import com.gooagoo.entity.generator.bill.OrderInfoExample;
import com.gooagoo.entity.generator.bill.ShoppingCartExample;
import com.gooagoo.entity.generator.bill.UserOrderCoupon;
import com.gooagoo.entity.generator.bill.UserOrderDetail;
import com.gooagoo.entity.generator.bill.UserOrderInfo;
import com.gooagoo.entity.generator.shop.ShopTableInfo;
import com.gooagoo.entity.generator.shop.ShopTableInfoExample;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.exception.business.bill.OrderAlreadyExistsException;
import com.gooagoo.exception.business.shop.TableNotExistException;
import com.gooagoo.exception.business.shop.TableStateNotFreeException;
import com.gooagoo.exception.common.NoDataException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisListDao;

@Service
public class UserOrderCoreServiceImpl implements UserOrderCoreService
{

    @Autowired
    private UserOrderInfoGeneratorCoreService userOrderInfoGeneratorCoreService;
    @Autowired
    private OrderInfoGeneratorCoreService orderInfoGeneratorCoreService;
    @Autowired
    private UserOrderDetailGeneratorCoreService userOrderDetailGeneratorCoreService;
    @Autowired
    private UserOrderCouponGeneratorCoreService userOrderCouponGeneratorCoreService;
    @Autowired
    private TransactionProtectedCoreService transactionProtectedCoreService;
    @Autowired
    private GoodsCacheCoreService goodsCacheCoreService;
    @Autowired
    private ShopTableInfoGeneratorCoreService shopTableInfoGeneratorCoreService;
    @Autowired
    private TableCacheCoreService tableCacheCoreService;
    @Autowired
    private ShoppingCartGeneratorCoreService shoppingCartGeneratorCoreService;
    @Autowired
    private BillInvoiceLogGeneratorCoreService billInvoiceLogGeneratorCoreService;

    /**
     * 用户提交订单
     * 1.用户第一次提交订单，只需补全数据、校验优惠券、保存数据
     * 2.用户非第一次提交订单（通过此餐桌是否有未结账订单判断），转换为加菜申请、补全数据、校验优惠券、保存数据
     * 3.通过购物车提交订单时、需将购物车对应的商品删除
     * @param userOrderInfo 用户订单原始信息
     * @param userOrderDetailList 用户订单原始信息商品详情
     * @param userOrderCouponList 用户订单原始信息优惠凭证详情
     * @return 不能使用的优惠券列表
     * @throws TableNotExistException 餐桌不存在
     * @throws OrderAlreadyExistsException 订单已存在,不可重复提交订单异常
     */
    @Override
    public OrderResult addUserOrder(UserOrderInfo userOrderInfo, List<UserOrderDetail> userOrderDetailList, List<UserOrderCoupon> userOrderCouponList, BillInvoiceLog billInvoiceLog, Map<String, String> parmMap) throws Exception
    {
        OrderResult orderResult = new OrderResult();
        OrderBusiness orderBusiness = new OrderBusiness();
        List<CanNotUseCoupon> canNotUseCouponList = new ArrayList<CanNotUseCoupon>();
        //1.参数校验
        this.checkUserOrderParam(parmMap != null ? parmMap.get("type") : null, userOrderInfo, userOrderDetailList, userOrderCouponList);
        //2.组装订单(包含用户原始订单、订单、优惠券校验)
        this.completionOrder(userOrderInfo, userOrderDetailList, userOrderCouponList, canNotUseCouponList, orderBusiness, billInvoiceLog);
        orderResult.setCanNotUseCouponList(canNotUseCouponList);
        //4.数据持久化（包括新建user_order_info、user_order_detail、user_order_coupon；新建或更新order_info、order_detail_info、order_coupon_info；给优惠券加锁favorite_info）
        this.save(userOrderInfo, userOrderDetailList, userOrderCouponList, orderBusiness, billInvoiceLog);
        orderResult.setOrderId(CollectionUtils.isNotEmpty(orderBusiness.getBillAddInfoList()) ? orderBusiness.getBillAddInfoList().get(0).getOrderId() : orderBusiness.getOrderInfo().getOrderId());
        //5.更新缓存餐桌状态
        if (StringUtils.isNotBlank(userOrderInfo.getDeskName()))
        {//远程提交订单，无需修改餐桌状态，当为店内提交订单时，需修改餐桌状态为已点餐
            this.updateTableStatus4Redis(userOrderInfo.getShopEntityId(), userOrderInfo.getDeskName(), "已点餐");
        }
        //6.通过购物车提交订单时、需将购物车对应的商品删除
        if (parmMap != null && "0".equals(parmMap.get("goodssource")))
        {
            this.deleteShoppingCart(userOrderInfo.getUserId(), userOrderInfo.getShopEntityId(), userOrderDetailList);
        }
        return orderResult;
    }

    /**
     * 更新redis中的餐桌状态
     * @param list
     * @param tablestatus 餐桌状态 0-开台、1-空闲
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

    /**
     * 校验用户订单参数
     * @param userOrderInfo 
     * @param userOrderDetailList
     * @param userOrderCouponList
     * @throws Exception
     */
    private void checkUserOrderParam(String type, UserOrderInfo userOrderInfo, List<UserOrderDetail> userOrderDetailList, List<UserOrderCoupon> userOrderCouponList) throws Exception
    {
        if (userOrderInfo == null)
        {
            GooagooLog.error("用户订单原始信息为空", null);
            throw new NullException("用户订单原始信息为空");
        }
        if (StringUtils.isNotBlank(userOrderInfo.getDeskName()) && ("00".equals(type) || StringUtils.isBlank(type)))
        {
            ShopTableInfoExample shopTableInfoExample = new ShopTableInfoExample();
            shopTableInfoExample.createCriteria().andShopEntityIdEqualTo(userOrderInfo.getShopEntityId()).andTableNameEqualTo(userOrderInfo.getDeskName()).andIsDelEqualTo("N");
            List<ShopTableInfo> shopTableInfoList = this.shopTableInfoGeneratorCoreService.selectByExample(shopTableInfoExample);
            if (CollectionUtils.isEmpty(shopTableInfoList))
            {
                GooagooLog.error("桌号不存在[shopEntityId=" + userOrderInfo.getShopEntityId() + "、tableName=" + userOrderInfo.getDeskName() + "]", null);
                throw new TableNotExistException("桌号不存在[shopEntityId=" + userOrderInfo.getShopEntityId() + "、tableName=" + userOrderInfo.getDeskName() + "]");
            }
            if (StringUtils.isNotBlank(userOrderInfo.getIsSaCommit()) && "Y".equals(userOrderInfo.getIsSaCommit()))
            {//店员助理提交订单需校验订单是否重复提交
                OrderInfoExample orderInfoExample = new OrderInfoExample();
                orderInfoExample.createCriteria().andShopEntityIdEqualTo(userOrderInfo.getShopEntityId()).andDeskNameEqualTo(userOrderInfo.getDeskName()).andBillTypeNotEqualTo("3").andIsDelEqualTo("N");
                List<OrderInfo> orderInfoList = this.orderInfoGeneratorCoreService.selectByExample(orderInfoExample);
                if (CollectionUtils.isNotEmpty(orderInfoList))
                {
                    GooagooLog.error("订单已存在,不可重复提交订单[shopEntityId=" + userOrderInfo.getShopEntityId() + "、tableName=" + userOrderInfo.getDeskName() + "]", null);
                    throw new OrderAlreadyExistsException("订单已存在,不可重复提交订单[shopEntityId=" + userOrderInfo.getShopEntityId() + "、tableName=" + userOrderInfo.getDeskName() + "]");
                }
            }

        }
        else if (!"00".equals(type) && StringUtils.isNotBlank(userOrderInfo.getDeskName()))
        {
            GooagooLog.error("订单数据有误，非到店餐饮订单，餐桌号应该为空", null);
            throw new NullException("订单数据有误，非到店餐饮订单，餐桌号应该为空");
        }
        if (StringUtils.isBlank(userOrderInfo.getShopId()))
        {
            GooagooLog.error("用户订单原始信息ShopId为空", null);
            throw new NullException("用户订单原始信息ShopId为空");
        }
        if (StringUtils.isBlank(userOrderInfo.getShopEntityId()))
        {
            GooagooLog.error("用户订单原始信息ShopEntityId为空", null);
            throw new NullException("用户订单原始信息ShopEntityId为空");
        }
        if (StringUtils.isBlank(userOrderInfo.getIsSaCommit()))
        {
            GooagooLog.error("用户订单原始信息IsSaCommit为空", null);
            throw new NullException("用户订单原始信息IsSaCommit为空");
        }
        if ("2".equals(userOrderInfo.getTakeMethod()))
        {
            if (StringUtils.isBlank(userOrderInfo.getConsigneeId()))
            {
                GooagooLog.error("用户订单原始信息TakeMethod=2时ConsigneeId不能为空", null);
                throw new NullException("用户订单原始信息中'提货方式'为'送货上门'时'收货人信息编号'不能为空");
            }
        }
        if (StringUtils.isNotBlank(userOrderInfo.getAccount()))
        {
            if (StringUtils.isBlank(userOrderInfo.getIsSaCommit()))
            {
                GooagooLog.error("用户订单原始信息Account有值时IsSaCommit不能为空", null);
                throw new NullException("用户订单原始信息'店员助理登录帐号'有值时'是否店员助理提交'不能为空");
            }
        }
        if (CollectionUtils.isEmpty(userOrderDetailList))
        {
            GooagooLog.error("订单商品详细信息为空", null);
            throw new NullException("订单商品详细信息为空");
        }
        for (UserOrderDetail userOrderDetail : userOrderDetailList)
        {
            if (StringUtils.isBlank(userOrderDetail.getGoodsId()) && StringUtils.isBlank(userOrderDetail.getGoodsName()))
            {
                GooagooLog.error("订单商品详细信息中goodsId和goodsName不能同时为空", null);
                throw new NullException("订单商品详细信息中'商品编号'和'商品名称'不能同时为空");
            }
            if (userOrderDetail.getGoodsNum() == null)
            {
                GooagooLog.error("订单商品详细信息中goodsNum不能为空", null);
                throw new NullException("订单商品详细信息中'商品数量'不能为空");
            }
        }
    }

    /**
     * 组装订单(包含用户原始订单、订单、优惠券校验)
     * @param userOrderInfo
     * @param userOrderDetailList
     * @param userOrderCouponList
     * @param canNotUseCouponList
     * @return
     * @throws Exception
     */
    private OrderBusiness completionOrder(UserOrderInfo userOrderInfo, List<UserOrderDetail> userOrderDetailList, List<UserOrderCoupon> userOrderCouponList, List<CanNotUseCoupon> canNotUseCouponList, OrderBusiness orderBusiness, BillInvoiceLog billInvoiceLog) throws Exception
    {
        boolean isNew = true;//true-用户第一次提交订单
        //生成用户订单号
        String userOrderId = UUID.getUUID();
        //生成订单音频卡号
        String orderId = this.transactionProtectedCoreService.getOrderId(userOrderInfo.getShopEntityId());
        if (StringUtils.isBlank(orderId))
        {
            throw new GooagooException("生成订单号失败");
        }
        OrderInfo orderInfoTemp = null;
        if (StringUtils.isNotBlank(userOrderInfo.getDeskName()))
        {//当餐桌号为空时，为远程点餐，不为空时，查询餐桌最后一条未结账订单
         //查询此餐桌最后一条未结账订单
            orderInfoTemp = this.transactionProtectedCoreService.getNotCheckoutOrder(userOrderInfo.getDeskName(), userOrderInfo.getShopEntityId());
        }
        String existOrderId = orderInfoTemp != null ? orderInfoTemp.getOrderId() : null;
        if (existOrderId != null)
        {
            orderId = existOrderId;
            isNew = false;
        }
        List<OrderDetailInfo> orderDetailInfoList = new ArrayList<OrderDetailInfo>();//订单商品详细信息
        List<BillAddInfo> billAddInfoList = new ArrayList<BillAddInfo>();
        //用于封装OrderInfo
        Integer goodsTotalNum = 0;//订单商品总数
        Double originalPrice = 0.00;//订单原价格
        if (isNew)//用户第一次提交订单
        {
            //1.封装OrderDetailInfo
            orderBusiness.setOrderDetailInfoUpdateType("1");//订单商品详细信息更新类型1-新建2-增量更新3-全量更新
            for (UserOrderDetail userOrderDetail : userOrderDetailList)
            {
                OrderDetailInfo orderDetailInfo = this.getOrderDetailInfo(orderId, userOrderId, userOrderInfo, userOrderDetail);
                orderDetailInfoList.add(orderDetailInfo);
                //用于封装OrderInfo
                goodsTotalNum = goodsTotalNum + orderDetailInfo.getGoodsNum();//订单商品总数
                originalPrice = originalPrice + orderDetailInfo.getPrice() * orderDetailInfo.getGoodsNum();//订单原价格
            }
            orderBusiness.setOrderDetailInfoList(orderDetailInfoList);
            //2.封装orderInfo
            orderBusiness.setOrderInfoUpdateType("1");//订单信息更新类型1-新建2-增量更新
            orderBusiness.setOrderInfo(this.getOrderInfo(orderId, userOrderId, userOrderInfo, goodsTotalNum, originalPrice));
            //3.组装发票信息
            if (billInvoiceLog != null)
            {
                billInvoiceLog.setOrderId(orderId);//订单编号
                billInvoiceLog.setInvoicedRequestTime(new Date());//开发票申请时间
                billInvoiceLog.setIsDel("N");
            }
        }
        else
        //用户提交的加菜减菜申请
        { //2.封装BillAddInfo
            for (UserOrderDetail userOrderDetail : userOrderDetailList)
            {
                orderBusiness.setBillAddInfoUpdateType("1");
                BillAddInfo billAddInfo = new BillAddInfo();
                billAddInfo = this.getBillAddInfo(orderId, userOrderId, userOrderInfo, userOrderDetail, goodsTotalNum, originalPrice);
                billAddInfoList.add(billAddInfo);
                goodsTotalNum = goodsTotalNum + billAddInfo.getGoodsNum();//订单商品总数
                originalPrice = originalPrice + billAddInfo.getPrice() * billAddInfo.getGoodsNum();//订单原价格
            }
            orderBusiness.setBillAddInfoList(billAddInfoList);
        }
        //3.封装orderCouponInfo
        if (CollectionUtils.isNotEmpty(userOrderCouponList))
        {
            orderBusiness.setOrderCouponInfoUpdateType("1");
            OrderCouponBusiness OrderCouponBusiness = this.transactionProtectedCoreService.getOrderCouponBusiness(userOrderInfo.getUserId(), userOrderInfo.getShopId(), userOrderInfo.getShopEntityId(), orderDetailInfoList, userOrderCouponList, existOrderId);
            canNotUseCouponList = OrderCouponBusiness.getCanNotUseCouponList();
            orderBusiness.setOrderCouponInfoList(OrderCouponBusiness.getOrderCouponInfoList());
        }
        return orderBusiness;
    }

    /**
     * 封装OrderDetailInfo、userOrderDetail
     * @param orderId
     * @param userOrderId
     * @param userOrderInfo
     * @param userOrderDetail
     * @return
     * @throws Exception
     */
    private OrderDetailInfo getOrderDetailInfo(String orderId, String userOrderId, UserOrderInfo userOrderInfo, UserOrderDetail userOrderDetail) throws Exception
    {
        //封装OrderDetailInfo
        String goodsId = userOrderDetail.getGoodsId();
        Map<String, String> goodsInfo = new HashMap<String, String>();
        goodsInfo = this.goodsCacheCoreService.findGoodsInfo(goodsId);
        if (goodsInfo == null || goodsInfo.size() == 0)
        {
            GooagooLog.error("通过goodsId查询商品缓存详细出错，GoodsId=" + goodsId, null);
            throw new NoDataException("通过goodsId查询商品缓存详细出错，GoodsId=" + goodsId);
        }
        Double price = Double.parseDouble(goodsInfo.get("price"));//商品单价
        OrderDetailInfo orderDetailInfo = new OrderDetailInfo();
        orderDetailInfo.setGoodsId(goodsId);//商品编号
        orderDetailInfo.setGoodsCategoryRoot(goodsInfo.get("goodsCategoryRoot"));//品类编号（根节点）
        orderDetailInfo.setGoodsCategoryLeaf(goodsInfo.get("goodsCategoryLeaf"));//品类编号（叶节点）
        orderDetailInfo.setGoodsBrand(goodsInfo.get("goodsBrand"));//品牌编号
        orderDetailInfo.setGoodsSerial(goodsInfo.get("goodsSerial"));//商品序列号（商品的唯一识别编码）
        orderDetailInfo.setItemSerial(goodsInfo.get("itemSerial"));//自定义序列号（商品细分的唯一识别编码）
        orderDetailInfo.setGoodsImg(StringUtils.isNotBlank(goodsInfo.get("goodsImg")) ? JsonUtils.json2List(goodsInfo.get("goodsImg")).get(0) : null);//商品主图地址,商品基本信息中图片的第一张图片
        orderDetailInfo.setGoodsName(goodsInfo.get("goodsName"));//商品名称（来自账单文件）
        orderDetailInfo.setPrice(price);//商品价格
        orderDetailInfo.setOrderDetailId(UUID.getUUID());//订单明细编号，UUID
        orderDetailInfo.setOrderId(orderId);//订单编号
        orderDetailInfo.setShopId(userOrderInfo.getShopId());//商家编号
        orderDetailInfo.setShopEntityId(userOrderInfo.getShopEntityId());//实体店编号
        orderDetailInfo.setPayPrice(price);//实际支付单价（来自账单文件）
        orderDetailInfo.setGoodsNum(userOrderDetail.getGoodsNum());//商品数量（来自账单文件）
        orderDetailInfo.setTotalPrice(price * userOrderDetail.getGoodsNum());//实际支付总价=商品数量×实际支付单价
        orderDetailInfo.setUserId(userOrderInfo.getUserId());//提交者（只保留第一个提交此商品的人，后来提交的只做数量合并，不覆盖提交者）
        orderDetailInfo.setServeNum(0);//上菜情况（仅针对餐饮），默认值为0
        orderDetailInfo.setGoodsWeight(0.00);
        //封装userOrderDetail
        userOrderDetail.setUserOrderDetailId(UUID.getUUID());//订单明细编号
        userOrderDetail.setUserOrderId(userOrderId);//用户订单编号
        userOrderDetail.setShopId(userOrderInfo.getShopId());//商家编号
        userOrderDetail.setShopEntityId(userOrderInfo.getShopEntityId());//实体店编号
        userOrderDetail.setGoodsId(goodsId);//商品编号
        userOrderDetail.setGoodsName(goodsInfo.get("goodsName"));//商品名称
        userOrderDetail.setGoodsPrice(price);//商品单价
        userOrderDetail.setUserId(userOrderInfo.getUserId());//提交者
        return orderDetailInfo;
    }

    /**
     * 封装orderInfo、userOrderInfo
     * @param orderId
     * @param userOrderId
     * @param userOrderInfo
     * @param goodsTotalNum
     * @param originalPrice
     * @return
     * @throws Exception
     */
    private OrderInfo getOrderInfo(String orderId, String userOrderId, UserOrderInfo userOrderInfo, Integer goodsTotalNum, Double originalPrice) throws Exception
    {
        //封装OrderInfo
        Map<String, String> accountHm = this.transactionProtectedCoreService.getAccount(userOrderInfo.getShopId(), userOrderInfo.getUserId(), null);
        OrderInfo orderInfo = new OrderInfo();//订单信息
        orderInfo.setOrderId(orderId);//订单编号，UUID
        orderInfo.setBillType("0");//订单状态，0-用户提交，1-商家处理，2-申请结账，3-已结账
        orderInfo.setShopId(userOrderInfo.getShopId());//商家编号
        orderInfo.setShopEntityId(userOrderInfo.getShopEntityId());//实体店编号
        if (accountHm != null)
        {
            orderInfo.setUserId(accountHm.get("userid"));//用户编号
            orderInfo.setScardNo(accountHm.get("scardno"));//会员卡号，16位音频卡号
        }
        orderInfo.setTakeMethod(StringUtils.isBlank(userOrderInfo.getTakeMethod()) ? "0" : userOrderInfo.getTakeMethod());//提货方式，0-直接拿走、1-前台提货、2-送货上门
        orderInfo.setConsigneeId(userOrderInfo.getConsigneeId());//收货人信息编号，关联收货人信息的主键
        orderInfo.setDeliveryStatus("0");//取货状态，0-用户未收到货物，1-商家已拣货，2-商家已发货，3-用户已收取货物
        orderInfo.setIsSaCommit(StringUtils.isBlank(userOrderInfo.getIsSaCommit()) ? "N" : "Y");//是否店员助理提交，Y-是，N-否
        orderInfo.setAccount(userOrderInfo.getAccount());//店员助理登录帐号
        orderInfo.setUserOrderTime(new Date());//用户订单提交时间
        orderInfo.setRequestTime(new Date());//消费时间
        orderInfo.setGoodsTotalNum(goodsTotalNum);//账单商品总数
        orderInfo.setOriginalPrice(originalPrice);//原价格
        orderInfo.setPayPrice(originalPrice);
        if (StringUtils.isNotBlank(userOrderInfo.getPayMethod()))
        {//零售业封装支付方式
            orderInfo.setPayMethod(userOrderInfo.getPayMethod());
        }
        orderInfo.setIsInvoice("N");
        orderInfo.setRoomName(userOrderInfo.getRoomName());//房间名称（仅针对餐饮）
        orderInfo.setDeskName(userOrderInfo.getDeskName());//桌子名称（仅针对餐饮）
        //        orderInfo.setShopOrderTime(new Date());//商家订单提交时间（仅针对餐饮）
        orderInfo.setIsDel("N");//是否删除，Y-已删除，N-未删除
        //封装userOrderInfo
        userOrderInfo.setOrderId(orderId);
        userOrderInfo.setUserOrderId(userOrderId);//用户订单编号，UUID
        userOrderInfo.setGoodsTotalNum(goodsTotalNum);//订单商品总数
        userOrderInfo.setOriginalPrice(originalPrice);//原价格
        return orderInfo;
    }

    /**
     * 封装BillAddInfo、userOrderDetail、userOrderInfo
     * @param orderId
     * @param userOrderId
     * @param userOrderInfo
     * @param userOrderDetail
     * @param goodsTotalNum
     * @param originalPrice
     * @return
     * @throws Exception
     */
    private BillAddInfo getBillAddInfo(String orderId, String userOrderId, UserOrderInfo userOrderInfo, UserOrderDetail userOrderDetail, Integer goodsTotalNum, Double originalPrice) throws Exception
    {
        if (StringUtils.isNotBlank(userOrderInfo.getAccount()))
        {//店员助理不提供订单转加菜订单功能
            throw new GooagooException("此餐桌有未结账订单tablename：" + userOrderInfo.getDeskName());
        }
        String goodsId = userOrderDetail.getGoodsId();
        Map<String, String> goodsInfo = new HashMap<String, String>();
        goodsInfo = this.goodsCacheCoreService.findGoodsInfo(goodsId);
        if (goodsInfo == null || goodsInfo.size() == 0)
        {
            GooagooLog.error("通过goodsId查询商品缓存详细出错，GoodsId=" + goodsId, null);
            throw new NoDataException("通过goodsId查询商品缓存详细出错，GoodsId=" + goodsId);
        }
        BillAddInfo billAddInfo = new BillAddInfo();
        billAddInfo.setOrderDetailId(UUID.getUUID());
        billAddInfo.setOrderId(orderId);
        billAddInfo.setGoodsId(goodsId);
        billAddInfo.setGoodsName(goodsInfo.get("goodsName"));
        billAddInfo.setShopId(userOrderInfo.getShopId());
        billAddInfo.setShopEntityId(userOrderInfo.getShopEntityId());
        billAddInfo.setGoodsCategoryRoot(goodsInfo.get("goodsCategoryRoot"));//品类编号（根节点）
        billAddInfo.setGoodsCategoryLeaf(goodsInfo.get("goodsCategoryLeaf"));//品类编号（叶节点）
        billAddInfo.setGoodsBrand(goodsInfo.get("goodsBrand"));//品牌编号
        billAddInfo.setGoodsSerial(goodsInfo.get("goodsSerial"));
        billAddInfo.setItemSerial(goodsInfo.get("itemSerial"));
        billAddInfo.setPrice(Double.parseDouble(goodsInfo.get("price")));//商品单价
        billAddInfo.setGoodsImg(StringUtils.isNotBlank(goodsInfo.get("goodsImg")) ? JsonUtils.json2List(goodsInfo.get("goodsImg")).get(0) : null);//商品主图地址，去图片的第一张
        billAddInfo.setGoodsNum(userOrderDetail.getGoodsNum());
        billAddInfo.setUserId(userOrderInfo.getUserId());
        billAddInfo.setTypeDeal("0");
        billAddInfo.setIsDeal("N");
        billAddInfo.setIsDel("N");
        //封装userOrderDetail
        userOrderDetail.setUserOrderDetailId(UUID.getUUID());//订单明细编号
        userOrderDetail.setUserOrderId(userOrderId);//用户订单编号
        userOrderDetail.setShopId(userOrderInfo.getShopId());//商家编号
        userOrderDetail.setShopEntityId(userOrderInfo.getShopEntityId());//实体店编号
        userOrderDetail.setGoodsId(goodsId);//商品编号
        userOrderDetail.setGoodsName(goodsInfo.get("goodsName"));//商品名称
        userOrderDetail.setGoodsPrice(Double.parseDouble(goodsInfo.get("price")));//商品单价
        userOrderDetail.setUserId(userOrderInfo.getUserId());//提交者
        //封装userOrderInfo
        userOrderInfo.setUserOrderId(userOrderId);//用户订单编号，UUID
        userOrderInfo.setOrderId(orderId);
        userOrderInfo.setGoodsTotalNum(goodsTotalNum);//订单商品总数
        userOrderInfo.setOriginalPrice(originalPrice);//原价格
        return billAddInfo;
    }

    /**
     * 数据持久化,包括:新建user_order_info、user_order_detail、user_order_coupon；
     * 新建或更新order_info、order_detail_info、order_coupon_info；
     * 给优惠券加锁favorite_info
     * @param type 0-新建，1-合并
     * @param userOrderBusiness
     * @param orderBusiness
     * @throws Exception
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    private void save(UserOrderInfo userOrderInfo, List<UserOrderDetail> userOrderDetailList, List<UserOrderCoupon> userOrderCouponList, OrderBusiness orderBusiness, BillInvoiceLog billInvoiceLog) throws Exception
    {
        //保存用户订单
        this.insertUserOrderInfo(userOrderInfo, userOrderDetailList, userOrderCouponList);
        //保存订单
        this.transactionProtectedCoreService.saveOrderInfo(orderBusiness);
        //锁定优惠券
        this.transactionProtectedCoreService.changeCouponStatusForOrder(orderBusiness.getOrderCouponInfoList(), "1");
        //保存申请发发票申请信息
        if (billInvoiceLog != null)
        {
            if (!this.billInvoiceLogGeneratorCoreService.insertSelective(billInvoiceLog))
            {
                GooagooLog.error("用户提交订单:申请开发票[billInvoiceLog=" + billInvoiceLog.toString() + "]失败", null);
                throw new GooagooException("用户提交订单:申请开发票[billInvoiceLog=" + billInvoiceLog.toString() + "]失败");
            }
        }
    }

    /**
     * 保存用户订单原始信息
     * @param userOrderInfo
     * @param userOrderDetailList
     * @param userOrderCouponList
     * @throws Exception
     */
    private void insertUserOrderInfo(UserOrderInfo userOrderInfo, List<UserOrderDetail> userOrderDetailList, List<UserOrderCoupon> userOrderCouponList) throws Exception
    {
        //添加用户订单原始信息
        if (!this.userOrderInfoGeneratorCoreService.insertSelective(userOrderInfo))
        {
            GooagooLog.error("添加用户订单原始信息[" + userOrderInfo.toString() + "]失败", null);
            throw new GooagooException("添加用户订单原始信息失败");
        }
        //添加用户订单原始信息商品详情
        for (UserOrderDetail userOrderDetail : userOrderDetailList)
        {
            if (!this.userOrderDetailGeneratorCoreService.insertSelective(userOrderDetail))
            {
                GooagooLog.error("添加用户订单原始信息商品详情[" + userOrderDetail.toString() + "]失败", null);
                throw new GooagooException("添加用户订单原始信息商品详情失败");
            }
        }
        //添加用户订单原始信息优惠凭证详情
        if (CollectionUtils.isNotEmpty(userOrderCouponList))
        {
            for (UserOrderCoupon userOrderCoupon : userOrderCouponList)
            {
                if (!this.userOrderCouponGeneratorCoreService.insertSelective(userOrderCoupon))
                {
                    GooagooLog.error("添加用户订单原始信息优惠凭证详情[" + userOrderCoupon.toString() + "]失败", null);
                    throw new GooagooException("添加用户订单原始信息优惠凭证详情失败");
                }
            }
        }

    }

    @Override
    public boolean bindTable(String orderId, String deskName, String roomName) throws Exception
    {
        OrderInfo orderInfo = this.orderInfoGeneratorCoreService.selectUnDelByPrimaryKey(orderId);
        if (orderInfo == null)
        {
            GooagooLog.warn("绑定桌号、订单号、用户id时订单号为" + orderId + "的账单信息不存在");
            return false;
        }
        Map<String, String> tableCache = this.tableCacheCoreService.findTableInfoByTableName(orderInfo.getShopEntityId(), deskName);
        if (tableCache == null || tableCache.size() == 0)
        {
            GooagooLog.warn("redis缓存中该餐桌状态信息为空[shopEntityId=" + orderInfo.getShopEntityId() + "、tableName=" + deskName + "]");
            return false;
        }
        if (!"空闲".equals(tableCache.get("tablestate")))
        {
            throw new TableStateNotFreeException("餐桌被占用不能绑定[shopEntityId=" + orderInfo.getShopEntityId() + "、tableName=" + deskName + "、tableState=" + tableCache.get("tablestate") + "]");
        }
        orderInfo.setDeskName(deskName);
        orderInfo.setRoomName(roomName);
        if (this.orderInfoGeneratorCoreService.updateByPrimaryKeySelective(orderInfo))
        {
            this.updateTableStatus4Redis(orderInfo.getShopEntityId(), deskName, "已点餐");
            return true;
        }
        else
        {
            return false;
        }
    }

    /**当订单来源为购物车时、删除购物车对应商品
     * @param userId
     * @param shopEntityId
     * @param userOrderDetailList 订单商品列表
     */
    private void deleteShoppingCart(String userId, String shopEntityId, List<UserOrderDetail> userOrderDetailList)
    {
        List<String> goodsIdList = new ArrayList<String>();
        for (UserOrderDetail item : userOrderDetailList)
        {
            goodsIdList.add(item.getGoodsId());
        }
        ShoppingCartExample shoppingCartExample = new ShoppingCartExample();
        shoppingCartExample.createCriteria().andUserIdEqualTo(userId).andShopEntityIdEqualTo(shopEntityId).andGoodsIdIn(goodsIdList).andIsDelEqualTo("N");
        if (!this.shoppingCartGeneratorCoreService.deleteByExample(shoppingCartExample))
        {
            GooagooLog.error("用户提交订单:删除购物车失败[userId=" + userId + "、shopEntityId=" + shopEntityId + "、goodsIdList=" + goodsIdList.toString() + "]", null);
        }
    }
}
