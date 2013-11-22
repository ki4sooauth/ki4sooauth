package com.gooagoo.core.business.transaction.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.goods.cache.GoodsCacheCoreService;
import com.gooagoo.api.business.core.transaction.order.ShopOrderCoreService;
import com.gooagoo.api.protecteds.core.transaction.TransactionProtectedCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.dao.generator.bill.BillAddInfoMapper;
import com.gooagoo.dao.generator.bill.OrderDetailInfoMapper;
import com.gooagoo.dao.generator.bill.OrderInfoMapper;
import com.gooagoo.dao.generator.bill.OrderPicMapper;
import com.gooagoo.dao.generator.bill.ShopOrderDetailMapper;
import com.gooagoo.dao.generator.bill.ShopOrderInfoMapper;
import com.gooagoo.dao.generator.bill.ShopOrderPicMapper;
import com.gooagoo.dao.generator.goods.GoodsBaseInfoMapper;
import com.gooagoo.entity.business.transaction.OrderBusiness;
import com.gooagoo.entity.generator.bill.BillAddInfo;
import com.gooagoo.entity.generator.bill.BillAddInfoExample;
import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.entity.generator.bill.OrderDetailInfoExample;
import com.gooagoo.entity.generator.bill.OrderInfo;
import com.gooagoo.entity.generator.bill.OrderPic;
import com.gooagoo.entity.generator.bill.ShopOrderDetail;
import com.gooagoo.entity.generator.bill.ShopOrderInfo;
import com.gooagoo.entity.generator.bill.ShopOrderPic;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;

@Service
public class ShopOrderCoreServiceImpl implements ShopOrderCoreService
{

    @Autowired
    ShopOrderInfoMapper shopOrderInfoMapper;

    @Autowired
    ShopOrderDetailMapper shopOrderDetailMapper;

    @Autowired
    ShopOrderPicMapper shopOrderPicMapper;

    @Autowired
    OrderInfoMapper orderInfoMapper;

    @Autowired
    BillAddInfoMapper billAddInfoMapper;

    @Autowired
    OrderDetailInfoMapper orderDetailInfoMapper;

    @Autowired
    OrderPicMapper orderPicMapper;

    @Autowired
    TransactionProtectedCoreService transactionProtectedCoreService;

    @Autowired
    GoodsBaseInfoMapper goodsBaseInfoMapper;

    @Autowired
    GoodsCacheCoreService goodsCacheCoreService;

    @Override
    public boolean addShopOrder(ShopOrderInfo shopOrderInfo, List<ShopOrderDetail> shopOrderDetailList, ShopOrderPic shopOrderPic) throws Exception
    {
        OrderBusiness orderBusiness = new OrderBusiness();
        //1.参数效验
        this.checkShopOrderParam(shopOrderInfo, shopOrderDetailList, shopOrderPic);
        //2.组装订单(包含商家原始订单、订单、优惠券校验)
        this.completionOrder(shopOrderInfo, shopOrderDetailList, shopOrderPic, orderBusiness);
        //3.数据持久化（包括新建user_order_info、user_order_detail、user_order_coupon；新建或更新order_info、order_detail_info、order_coupon_info；给优惠券加锁favorite_info）
        this.save(shopOrderInfo, shopOrderDetailList, shopOrderPic, orderBusiness);
        return true;
    }

    /**
     * 验证商家订单数据上传参数
     * @param originalBillInfo
     * @param originalBillDetailList
     * @param originalBillPic
     * @throws Exception 
     */
    private void checkShopOrderParam(ShopOrderInfo shopOrderInfo, List<ShopOrderDetail> shopOrderDetailList, ShopOrderPic shopOrderPic) throws Exception
    {
        if (shopOrderInfo == null)
        {
            GooagooLog.error("商家订单原始信息为空", null);
            throw new NullException("商家订单原始信息为空");
        }
        if (!StringUtils.hasText(shopOrderInfo.getShopId()))
        {
            GooagooLog.error("商家订单原始信息ShopId为空", null);
            throw new NullException("商家订单原始信息ShopId为空");
        }
        if (!StringUtils.hasText(shopOrderInfo.getShopEntityId()))
        {
            GooagooLog.error("商家订单原始信息ShopEntityId为空", null);
            throw new NullException("商家订单原始信息ShopEntityId为空");
        }
        if (!StringUtils.hasText(shopOrderInfo.getMac()))
        {
            GooagooLog.error("商家订单原始信息mac为空", null);
            throw new NullException("商家订单原始信息mac为空");
        }
        if (!StringUtils.hasText(shopOrderInfo.getDeskName()))
        {
            GooagooLog.error("商家订单原始信息DeskName不能为空", null);
            throw new NullException("商家订单原始信息DeskName不能为空");
        }
        if (CollectionUtils.isEmpty(shopOrderDetailList))
        {
            GooagooLog.error("订单商品详细信息为空", null);
            throw new NullException("订单商品详细信息为空");
        }
        for (ShopOrderDetail shopOrderDetail : shopOrderDetailList)
        {
            if (!StringUtils.hasText(shopOrderDetail.getGoodsId()) && !StringUtils.hasText(shopOrderDetail.getGoodsName()))
            {
                GooagooLog.error("订单商品详细信息中goodsId和goodsName不能同时为空", null);
                throw new NullException("订单商品详细信息中'商品编号'和'商品名称'不能同时为空");
            }
            if (shopOrderDetail.getGoodsNum() == null)
            {
                GooagooLog.error("订单商品详细信息中goodsNum不能为空", null);
                throw new NullException("订单商品详细信息中'商品数量'不能为空");
            }
        }
        if (shopOrderPic == null)
        {
            GooagooLog.error("原始订单信息图片详情不能为空", null);
            throw new NullException("原始订单信息图片详情不能为空");
        }
        if (!StringUtils.hasText(shopOrderPic.getPicUrl()))
        {
            GooagooLog.error("原始订单信息图片详情PicUrl不能为空", null);
            throw new NullException("原始订单信息图片详情PicUrl不能为空");
        }
    }

    /**
     * 组装订单信息（订单、商家订单）
     * @param shopOrderInfo
     * @param shopOrderDetailList
     * @param shopOrderPic
     * @param orderBusiness
     * @return
     * @throws Exception
     */
    private OrderBusiness completionOrder(ShopOrderInfo shopOrderInfo, List<ShopOrderDetail> shopOrderDetailList, ShopOrderPic shopOrderPic, OrderBusiness orderBusiness) throws Exception
    {
        //校验商家订单类型01-（此餐桌无用户订单，本次上传为商家订单）；11-（此餐桌有用户订单，本次上传为商家订单）；12-（此餐桌有用户订单，本次上传为加菜订单）；13-（此餐桌有用户订单，本次上传为减菜订单）
        String shopOrderType = this.checkShopOrderType(orderBusiness, shopOrderInfo, shopOrderDetailList);
        if ("00".equals(shopOrderType))
        {//异常情况
            throw new GooagooException("商家订单无对应的用户订单或加减菜申请");
        }
        else if ("01".equals(shopOrderType))
        {//01-（此餐桌无用户订单，本次上传为商家订单），新建订单
            this.completionOrder01(shopOrderInfo, shopOrderDetailList, shopOrderPic, orderBusiness);
        }
        else if ("11".equals(shopOrderType))
        {//11-（此餐桌有用户订单，本次上传为商家订单），更新订单
            this.completionOrder11(shopOrderInfo, shopOrderDetailList, shopOrderPic, orderBusiness);
        }
        else if ("12".equals(shopOrderType))
        {//12-（此餐桌有用户订单，本次上传为加菜订单），更新订单
            this.completionOrder12(shopOrderInfo, shopOrderDetailList, shopOrderPic, orderBusiness);
        }
        else if ("13".equals(shopOrderType))
        {//13-（此餐桌有用户订单，本次上传为减菜订单），更新订单
            this.completionOrder13(shopOrderInfo, shopOrderDetailList, shopOrderPic, orderBusiness);
        }
        return orderBusiness;
    }

    /**
     * 
     * @param shopOrderInfo
     * @param shopOrderDetailList
     * @param orderBusiness
     * @throws Exception
     */
    private void completionOrder01(ShopOrderInfo shopOrderInfo, List<ShopOrderDetail> shopOrderDetailList, ShopOrderPic shopOrderPic, OrderBusiness orderBusiness) throws Exception
    {
        //生成商家订单号
        String shopOrderId = UUID.getUUID();
        String orderId = this.transactionProtectedCoreService.getOrderId(shopOrderInfo.getShopEntityId());
        Integer goodsTotalNum = 0;//订单商品总数
        Double originalPrice = 0.00;//订单原价格
        List<OrderDetailInfo> orderDetailInfoList = new ArrayList<OrderDetailInfo>();//订单商品详细信息
        if (!StringUtils.hasText(orderId))
        {
            throw new GooagooException("生成订单号失败");
        }
        //1.封装OrderDetailInfo
        orderBusiness.setOrderDetailInfoUpdateType("1");//订单商品详细信息更新类型1-新建2-增量更新3-全量更新
        for (ShopOrderDetail shopOrderDetail : shopOrderDetailList)
        {
            OrderDetailInfo orderDetailInfo = this.getOrderDetailInfo01(orderId, shopOrderId, shopOrderInfo, shopOrderDetail);
            orderDetailInfoList.add(orderDetailInfo);
            //用于封装OrderInfo
            goodsTotalNum = goodsTotalNum + orderDetailInfo.getGoodsNum();//订单商品总数
            originalPrice = originalPrice + orderDetailInfo.getPrice() * orderDetailInfo.getGoodsNum();//订单原价格
        }
        orderBusiness.setOrderDetailInfoList(orderDetailInfoList);
        //2.封装orderInfo
        orderBusiness.setOrderInfoUpdateType("1");//订单信息更新类型1-新建2-增量更新
        orderBusiness.setOrderInfo(this.getOrderInfo01(orderId, shopOrderId, shopOrderInfo, goodsTotalNum, originalPrice));
        //3.封装OrderPic
        List<OrderPic> orderPicList = new ArrayList<OrderPic>();
        orderPicList.add(this.getOrderPic(orderId, shopOrderId, shopOrderPic));
        orderBusiness.setOrderPicList(orderPicList);
    }

    private void completionOrder11(ShopOrderInfo shopOrderInfo, List<ShopOrderDetail> shopOrderDetailList, ShopOrderPic shopOrderPic, OrderBusiness orderBusiness) throws Exception
    {
        String orderId = orderBusiness.getOrderInfo().getOrderId();
        //生成商家订单号
        String shopOrderId = UUID.getUUID();
        Integer goodsTotalNum = 0;//订单商品总数
        Double originalPrice = 0.00;//订单原价格
        List<OrderDetailInfo> orderDetailInfoList = new ArrayList<OrderDetailInfo>();//订单商品详细信息
        //1.封装OrderDetailInfo
        orderBusiness.setOrderDetailInfoUpdateType("3");//订单商品详细信息更新类型1-新建2-增量更新3-全量更新4-删除
        List<OrderDetailInfo> orderDetailInfoListExist = this.getOrderDetailInfo(orderId);
        for (ShopOrderDetail shopOrderDetail : shopOrderDetailList)
        {
            OrderDetailInfo orderDetailInfoExist = this.transactionProtectedCoreService.getMatchOrderDetailInfo(shopOrderDetail.getGoodsId(), shopOrderDetail.getGoodsName(), orderDetailInfoListExist);
            OrderDetailInfo orderDetailInfo = null;
            if (orderDetailInfoExist != null)
            {
                orderDetailInfo = this.getOrderDetailInfo11(shopOrderId, shopOrderDetail, orderDetailInfoExist);
            }
            else
            {
                orderDetailInfo = this.getOrderDetailInfo01(orderId, shopOrderId, shopOrderInfo, shopOrderDetail);
            }
            orderDetailInfoList.add(orderDetailInfo);
            //用于封装OrderInfo
            goodsTotalNum = goodsTotalNum + orderDetailInfo.getGoodsNum();//订单商品总数
            originalPrice = originalPrice + orderDetailInfo.getPrice() * orderDetailInfo.getGoodsNum();//订单原价格
        }
        orderBusiness.setOrderDetailInfoList(orderDetailInfoList);
        //2.封装orderInfo
        orderBusiness.setOrderInfoUpdateType("2");//订单信息更新类型1-新建2-增量更新
        orderBusiness.setOrderInfo(this.getOrderInfo11(orderBusiness.getOrderInfo(), shopOrderId, shopOrderInfo, goodsTotalNum, originalPrice));
        //3.封装OrderPic
        List<OrderPic> orderPicList = new ArrayList<OrderPic>();
        orderPicList.add(this.getOrderPic(orderId, shopOrderId, shopOrderPic));
        orderBusiness.setOrderPicList(orderPicList);
    }

    private void completionOrder12(ShopOrderInfo shopOrderInfo, List<ShopOrderDetail> shopOrderDetailList, ShopOrderPic shopOrderPic, OrderBusiness orderBusiness) throws Exception
    {
        String orderId = orderBusiness.getOrderInfo().getOrderId();
        //生成商家订单号
        String shopOrderId = UUID.getUUID();
        Integer goodsTotalNum = 0;//订单商品总数
        Double originalPrice = 0.00;//订单原价格
        List<OrderDetailInfo> orderDetailInfoList = new ArrayList<OrderDetailInfo>();//订单商品详细信息
        //1.封装OrderDetailInfo
        orderBusiness.setOrderDetailInfoUpdateType("1");//订单商品详细信息更新类型1-新建2-增量更新3-全量更新
        for (ShopOrderDetail shopOrderDetail : shopOrderDetailList)
        {
            OrderDetailInfo orderDetailInfo = this.getOrderDetailInfo01(orderId, shopOrderId, shopOrderInfo, shopOrderDetail);
            orderDetailInfoList.add(orderDetailInfo);
            //用于封装OrderInfo
            goodsTotalNum = goodsTotalNum + orderDetailInfo.getGoodsNum();//订单商品总数
            originalPrice = originalPrice + orderDetailInfo.getPrice() * orderDetailInfo.getGoodsNum();//订单原价格
        }
        orderBusiness.setOrderDetailInfoList(orderDetailInfoList);
        //2.封装orderInfo
        orderBusiness.setOrderInfoUpdateType("2");//订单信息更新类型1-新建2-增量更新
        orderBusiness.setOrderInfo(this.getOrderInfo11(orderBusiness.getOrderInfo(), shopOrderId, shopOrderInfo, goodsTotalNum, originalPrice));
        //3.封装OrderPic
        List<OrderPic> orderPicList = new ArrayList<OrderPic>();
        orderPicList.add(this.getOrderPic(orderId, shopOrderId, shopOrderPic));
        orderBusiness.setOrderPicList(orderPicList);
    }

    private void completionOrder13(ShopOrderInfo shopOrderInfo, List<ShopOrderDetail> shopOrderDetailList, ShopOrderPic shopOrderPic, OrderBusiness orderBusiness) throws Exception
    {
        String orderId = orderBusiness.getOrderInfo().getOrderId();
        //生成商家订单号
        String shopOrderId = UUID.getUUID();
        Integer goodsTotalNum = 0;//订单商品总数
        Double originalPrice = 0.00;//订单原价格
        List<OrderDetailInfo> orderDetailInfoList = new ArrayList<OrderDetailInfo>();//订单商品详细信息
        //1.封装OrderDetailInfo
        orderBusiness.setOrderDetailInfoUpdateType("4");//订单商品详细信息更新类型1-新建2-增量更新3-全量更新
        List<OrderDetailInfo> orderDetailInfoListExist = this.getOrderDetailInfo(orderId);
        for (ShopOrderDetail shopOrderDetail : shopOrderDetailList)
        {
            OrderDetailInfo orderDetailInfoExist = this.transactionProtectedCoreService.getMatchOrderDetailInfo(shopOrderDetail.getGoodsId(), shopOrderDetail.getGoodsName(), orderDetailInfoListExist);
            OrderDetailInfo orderDetailInfo = null;
            if (orderDetailInfoExist != null)
            {
                orderDetailInfo = this.getOrderDetailInfo11(shopOrderId, shopOrderDetail, orderDetailInfoExist);
            }
            orderDetailInfoList.add(orderDetailInfo);
            //用于封装OrderInfo
            goodsTotalNum = goodsTotalNum + orderDetailInfo.getGoodsNum();//订单商品总数
            originalPrice = originalPrice + orderDetailInfo.getPrice() * orderDetailInfo.getGoodsNum();//订单原价格
        }
        orderBusiness.setOrderDetailInfoList(orderDetailInfoList);
        //2.封装orderInfo
        orderBusiness.setOrderInfoUpdateType("2");//订单信息更新类型1-新建2-增量更新
        orderBusiness.setOrderInfo(this.getOrderInfo13(orderBusiness.getOrderInfo(), shopOrderId, shopOrderInfo, goodsTotalNum, originalPrice));
        //3.封装OrderPic
        List<OrderPic> orderPicList = new ArrayList<OrderPic>();
        orderPicList.add(this.getOrderPic(orderId, shopOrderId, shopOrderPic));
        orderBusiness.setOrderPicList(orderPicList);
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
    private void save(ShopOrderInfo shopOrderInfo, List<ShopOrderDetail> shopOrderDetailList, ShopOrderPic shopOrderPic, OrderBusiness orderBusiness) throws Exception
    {
        //保存(新建)商家订单
        this.insertShopOrderInfo(shopOrderInfo, shopOrderDetailList, shopOrderPic);
        this.transactionProtectedCoreService.saveOrderInfo(orderBusiness);
    }

    /**
     * 添加原始商家订单
     * @param shopOrderInfo 商家订单原始信息
     * @param shopOrderDetailList 商家订单原始信息商品详情
     * @param shopOrderPic 商家订单原始信息图片详情
     * @thows OperateFailException 
     * @throws NullException 
     */
    private void insertShopOrderInfo(ShopOrderInfo shopOrderInfo, List<ShopOrderDetail> shopOrderDetailList, ShopOrderPic shopOrderPic) throws OperateFailException, NullException
    {
        //添加商家订单原始信息
        if (this.shopOrderInfoMapper.insertSelective(shopOrderInfo) < 1)
        {
            GooagooLog.error("添加商家订单原始信息[" + shopOrderInfo.toString() + "]失败", null);
            throw new OperateFailException("添加商家订单原始信息失败");
        }
        if (CollectionUtils.isNotEmpty(shopOrderDetailList))
        {
            for (ShopOrderDetail shopOrderDetail : shopOrderDetailList)
            {
                //添加商家订单原始信息商品详情
                if (this.shopOrderDetailMapper.insertSelective(shopOrderDetail) < 1)
                {
                    GooagooLog.error("添加商家订单原始信息商品详情[" + shopOrderDetail.toString() + "]失败", null);
                    throw new OperateFailException("添加商家订单原始信息商品详情失败");
                }
            }
        }
        if (shopOrderPic != null)
        {
            //添加商家订单原始信息图片详情
            if (this.shopOrderPicMapper.insertSelective(shopOrderPic) < 1)
            {
                GooagooLog.error("添加商家订单原始信息图片详情[" + shopOrderPic.toString() + "]失败", null);
                throw new OperateFailException("添加商家订单原始信息图片详情失败");
            }
        }

    }

    /**
     * 
     * @param shopOrderInfo
     * @param shopOrderDetailList
     * @param orderBusiness
     * @throws Exception
     */
    private OrderPic getOrderPic(String orderId, String shopOrderId, ShopOrderPic shopOrderPic) throws Exception
    {
        //封装orderPic
        OrderPic orderPic = new OrderPic();
        orderPic.setIsDel("N");
        orderPic.setOrderDetailId(UUID.getUUID());
        orderPic.setOrderId(orderId);
        orderPic.setPicType("0");
        orderPic.setPicUrl(shopOrderPic.getPicUrl());
        //封装shopOrderPic
        shopOrderPic.setShopOrderDetailId(UUID.getUUID());
        shopOrderPic.setShopOrderId(shopOrderId);
        return orderPic;
    }

    /**
     * 封装OrderDetailInfo、shopOrderDetail
     * @param orderId
     * @param userOrderId
     * @param userOrderInfo
     * @param shopOrderDetail
     * @return
     * @throws Exception
     */
    private OrderDetailInfo getOrderDetailInfo01(String orderId, String shopOrderId, ShopOrderInfo shopOrderInfo, ShopOrderDetail shopOrderDetail) throws Exception
    {
        //封装OrderDetailInfo
        OrderDetailInfo orderDetailInfo = new OrderDetailInfo();
        GoodsBaseInfo goodsBaseInfo = null;
        Map<String, String> goodsInfo = new HashMap<String, String>();
        if (goodsBaseInfo != null)
        {
            try
            {
                goodsInfo = this.goodsCacheCoreService.findGoodsInfo(goodsBaseInfo.getGoodsId());
            }
            catch (Exception e)
            {
                GooagooLog.error("通过goodsId查询商品缓存详细出错，GoodsId=" + goodsBaseInfo.getGoodsId(), null);
            }
        }
        Double price = Double.parseDouble(goodsInfo.get("price"));//商品单价
        orderDetailInfo.setOrderDetailId(shopOrderId);//订单明细编号，UUID
        orderDetailInfo.setOrderId(orderId);//订单编号
        orderDetailInfo.setGoodsId(goodsBaseInfo.getGoodsId());//商品编号
        orderDetailInfo.setGoodsName(goodsInfo.get("goodsName"));//商品名称（来自账单文件）
        orderDetailInfo.setShopId(shopOrderInfo.getShopId());//商家编号
        orderDetailInfo.setShopEntityId(shopOrderInfo.getShopEntityId());//实体店编号
        orderDetailInfo.setGoodsCategoryRoot(goodsInfo.get("goodsCategoryRoot"));//品类编号（根节点）
        orderDetailInfo.setGoodsCategoryLeaf(goodsInfo.get("goodsCategoryLeaf"));//品类编号（叶节点）
        orderDetailInfo.setGoodsBrand(goodsInfo.get("goodsBrand"));//品牌编号
        orderDetailInfo.setGoodsSerial(goodsInfo.get("goodsSerial"));//商品序列号（商品的唯一识别编码）
        orderDetailInfo.setItemSerial(goodsInfo.get("itemSerial"));//自定义序列号（商品细分的唯一识别编码）
        orderDetailInfo.setPrice(price);//商品价格
        orderDetailInfo.setGoodsImg(StringUtils.hasText(goodsInfo.get("goodsImg")) ? JsonUtils.json2List(goodsInfo.get("goodsImg")).get(0) : null);//商品主图地址
        if (shopOrderDetail.getPayPrice() != null)
        {
            orderDetailInfo.setPayPrice(shopOrderDetail.getPayPrice());//实际支付单价（来自账单文件）
        }
        else
        {
            orderDetailInfo.setPayPrice(Double.parseDouble(goodsInfo.get("price")));//实际支付单价（来自账单文件）
        }
        orderDetailInfo.setGoodsNum(shopOrderDetail.getGoodsNum());//商品数量（来自账单文件）
        //        orderDetailInfo.setGoodsWeight(goodsWeight);//'商品重量（来自账单文件）',
        //        if (shopOrderDetail.getPayPrice() != null && shopOrderDetail.getPayPrice() != 0 && shopOrderDetail.getGoodsNum() != null && shopOrderDetail.getGoodsNum() != 0)
        //        {
        if (shopOrderDetail.getTotalPrice() != null)
        {
            //orderDetailInfo.setTotalPrice(shopOrderDetail.getPayPrice() * shopOrderDetail.getGoodsNum());//实际支付总价=商品数量×实际支付单价
            orderDetailInfo.setTotalPrice(shopOrderDetail.getTotalPrice());//实际支付总价=商品数量×实际支付单价
        }
        else
        {
            orderDetailInfo.setTotalPrice(orderDetailInfo.getPayPrice() * orderDetailInfo.getGoodsNum());//实际支付总价=商品数量×实际支付单价  
        }
        //        orderDetailInfo.setUserId(userId);//提交者（只保留第一个提交此商品的人，后来提交的只做数量合并，不覆盖提交者）
        //        orderDetailInfo.setAvoidItem(avoidItem);//'忌口',
        orderDetailInfo.setServeNum(0);//上菜情况（仅针对餐饮），默认值为0
        //        orderDetailInfo.setCommentId(commentId);//评论编号
        //封装userOrderDetail
        shopOrderDetail.setShopOrderDetailId(UUID.getUUID());//订单明细编号，UUID
        shopOrderDetail.setShopOrderId(shopOrderId);//商家订单编号
        shopOrderDetail.setShopId(shopOrderInfo.getShopId());//商家编号
        shopOrderDetail.setShopEntityId(shopOrderInfo.getShopEntityId());//实体店编号
        shopOrderDetail.setGoodsId(goodsBaseInfo.getGoodsId());//商品编号
        //        shopOrderDetail.setGoodsName(goodsName);//商品名称
        shopOrderDetail.setGoodsPrice(price);//商品单价
        //        shopOrderDetail.setPayPrice(payPrice);//实际支付单价
        //        shopOrderDetail.setGoodsNum(goodsNum);//商品数量
        //        shopOrderDetail.setTotalPrice(totalPrice);//实际支付总价=商品数量×实际支付单价
        return orderDetailInfo;
    }

    /**
     * 封装orderInfo、userOrderInfo
     * @param orderId
     * @param userOrderId
     * @param userOrderInfo
     * @param orderDetailInfoList
     * @param goodsTotalNum
     * @param originalPrice
     * @return
     * @throws Exception
     */
    private OrderInfo getOrderInfo01(String orderId, String shopOrderId, ShopOrderInfo shopOrderInfo, Integer goodsTotalNum, Double originalPrice) throws Exception
    {
        OrderInfo orderInfo = new OrderInfo();//订单信息
        Map<String, String> accountHm = this.transactionProtectedCoreService.getAccount(shopOrderInfo.getShopId(), shopOrderInfo.getUserId(), shopOrderInfo.getScardNo());
        orderInfo.setOrderId(orderId);//订单编号，UUID
        orderInfo.setBillType("1");//订单状态，-1-远程提交，0-用户提交，1-商家处理，2-申请结账，3-已结账
        orderInfo.setShopId(shopOrderInfo.getShopId());//商家编号
        orderInfo.setShopEntityId(shopOrderInfo.getShopEntityId());//实体店编号
        orderInfo.setMac(shopOrderInfo.getMac());//商家硬件设备MAC地址
        orderInfo.setRequestTime(new Date());//消费时间
        orderInfo.setThirdOrderId(shopOrderInfo.getThirdOrderId());//第三方订单编号
        if (accountHm != null)
        {
            orderInfo.setUserId(accountHm.get("userid"));//用户编号
            orderInfo.setScardNo(accountHm.get("scardno"));//会员卡号，16位音频卡号
        }
        orderInfo.setGoodsTotalNum(goodsTotalNum);//账单商品总数
        orderInfo.setOriginalPrice(originalPrice);//原价格
        if (originalPrice != 0 && shopOrderInfo.getPayPrice() != 0)
        {
            orderInfo.setDiscountRate(shopOrderInfo.getPayPrice() / originalPrice);//折扣
        }
        orderInfo.setPayPrice(shopOrderInfo.getPayPrice());//实际支付价格
        //        orderInfo.setTakeMethod(takeMethod);//提货方式，0-直接拿走、1-前台提货、2-送货上门
        //        orderInfo.setConsigneeId(consigneeId);//收货人信息编号，关联收货人信息的主键
        //        orderInfo.setDeliveryStatus(deliveryStatus);//取货状态，0-用户未收到货物，1-商家已拣货，2-商家已发货，3-用户已收取货物
        orderInfo.setRoomName(shopOrderInfo.getRoomName());//房间名称（仅针对餐饮）
        orderInfo.setDeskName(shopOrderInfo.getDeskName());//桌子名称（仅针对餐饮）
        orderInfo.setIsSaCommit("N");//是否店员助理提交，Y-是，N-否
        //        orderInfo.setAccount(account);//店员助理登录帐号
        //        orderInfo.setUserOrderTime(userOrderTime);//用户订单提交时间
        orderInfo.setShopOrderTime(new Date());//商家订单提交时间（仅针对餐饮）
        //        orderInfo.setPaymentApplicationTime(paymentApplicationTime);//申请结账时间（仅针对餐饮）
        //        orderInfo.setPaymentTime(paymentTime);//结账时间
        //        orderInfo.setInvoiceApplicationTime(invoiceApplicationTime);//申请开发票时间
        orderInfo.setIsInvoice("N");//是否开具发票，N-未开发票，Y-已开发票
        //        orderInfo.setInvoiceTime(invoiceTime);//开发票时间
        //        orderInfo.setInvoiceLatestTime(invoiceLatestTime);//最晚开发票时间，为结账时间+最晚开发票天数
        //        orderInfo.setBillId(billId);//账单编号
        //        orderInfo.setUserOrderId(userOrderId);//用户订单编号
        //        orderInfo.setAvoidItem(avoidItem);//'整单忌口',
        //        orderInfo.setDiningNumbers(diningNumbers);//'就餐人数'
        orderInfo.setIsDel("N");//是否删除，Y-已删除，N-未删除
        //        orderInfo.setCreateTime(createTime);//创建时间
        //        orderInfo.setCTimeStamp(cTimeStamp);//最后一次修改时间
        //封装shopOrderInfo
        shopOrderInfo.setOrderId(orderId);
        shopOrderInfo.setShopOrderId(shopOrderId);//用户订单编号，UUID
        shopOrderInfo.setGoodsTotalNum(goodsTotalNum);//订单商品总数
        shopOrderInfo.setOriginalPrice(originalPrice);//原价格
        shopOrderInfo.setUserId(accountHm.get("userid"));
        shopOrderInfo.setScardNo(accountHm.get("scardno"));
        if (originalPrice != 0 && shopOrderInfo.getPayPrice() != 0)
        {
            shopOrderInfo.setDiscountRate(shopOrderInfo.getPayPrice() / originalPrice);//折扣
        }
        shopOrderInfo.setIsDel("N");
        return orderInfo;
    }

    /**
     * 封装orderInfo、userOrderInfo
     * @param orderId
     * @param userOrderId
     * @param userOrderInfo
     * @param orderDetailInfoList
     * @param goodsTotalNum
     * @param originalPrice
     * @return
     * @throws Exception
     */
    private OrderInfo getOrderInfo13(OrderInfo orderInfo, String shopOrderId, ShopOrderInfo shopOrderInfo, Integer goodsTotalNum, Double originalPrice) throws Exception
    {

        goodsTotalNum = orderInfo.getGoodsTotalNum() - goodsTotalNum;
        originalPrice = orderInfo.getOriginalPrice() - originalPrice;
        //        orderInfo.setOrderId(shopOrderId);//订单编号，UUID
        orderInfo.setBillType("1");//订单状态，-1-远程提交，0-用户提交，1-商家处理，2-申请结账，3-已结账
        //        orderInfo.setShopId(shopOrderInfo.getShopId());//商家编号
        //        orderInfo.setShopEntityId(shopOrderInfo.getShopEntityId());//实体店编号
        //        orderInfo.setUserId(accountHm.get("userid"));//用户编号
        orderInfo.setMac(shopOrderInfo.getMac());//商家硬件设备MAC地址
        //        orderInfo.setRequestTime(new Date());//消费时间
        orderInfo.setThirdOrderId(shopOrderInfo.getThirdOrderId());//第三方订单编号
        //        orderInfo.setScardNo(accountHm.get("scardno"));//会员卡号，16位音频卡号
        orderInfo.setGoodsTotalNum(goodsTotalNum);//账单商品总数
        orderInfo.setOriginalPrice(originalPrice);//原价格
        if (orderInfo.getPayPrice() != null && originalPrice != null && originalPrice != 0 && shopOrderInfo.getPayPrice() != null && shopOrderInfo.getPayPrice() != 0)
        {
            orderInfo.setDiscountRate(orderInfo.getPayPrice() - shopOrderInfo.getPayPrice() / originalPrice);//折扣
        }
        if (orderInfo.getPayPrice() != null && shopOrderInfo.getPayPrice() != null)
        {
            orderInfo.setPayPrice(orderInfo.getPayPrice() - shopOrderInfo.getPayPrice());//实际支付价格
        }
        //        orderInfo.setTakeMethod(takeMethod);//提货方式，0-直接拿走、1-前台提货、2-送货上门
        //        orderInfo.setConsigneeId(consigneeId);//收货人信息编号，关联收货人信息的主键
        //        orderInfo.setDeliveryStatus(deliveryStatus);//取货状态，0-用户未收到货物，1-商家已拣货，2-商家已发货，3-用户已收取货物
        orderInfo.setRoomName(shopOrderInfo.getRoomName());//房间名称（仅针对餐饮）
        orderInfo.setDeskName(shopOrderInfo.getDeskName());//桌子名称（仅针对餐饮）
        //        orderInfo.setIsSaCommit(isSaCommit);//是否店员助理提交，Y-是，N-否
        //        orderInfo.setAccount(account);//店员助理登录帐号
        //        orderInfo.setUserOrderTime(userOrderTime);//用户订单提交时间
        orderInfo.setShopOrderTime(new Date());//商家订单提交时间（仅针对餐饮）
        //        orderInfo.setPaymentApplicationTime(paymentApplicationTime);//申请结账时间（仅针对餐饮）
        //        orderInfo.setPaymentTime(paymentTime);//结账时间
        //        orderInfo.setInvoiceApplicationTime(invoiceApplicationTime);//申请开发票时间
        orderInfo.setIsInvoice("N");//是否开具发票，N-未开发票，Y-已开发票
        //        orderInfo.setInvoiceTime(invoiceTime);//开发票时间
        //        orderInfo.setInvoiceLatestTime(invoiceLatestTime);//最晚开发票时间，为结账时间+最晚开发票天数
        //        orderInfo.setBillId(billId);//账单编号
        //        orderInfo.setUserOrderId(userOrderId);//用户订单编号
        //        orderInfo.setAvoidItem(avoidItem);//'整单忌口',
        //        orderInfo.setDiningNumbers(diningNumbers);//'就餐人数'
        orderInfo.setIsDel("N");//是否删除，Y-已删除，N-未删除
        //        orderInfo.setCreateTime(createTime);//创建时间
        //        orderInfo.setCTimeStamp(cTimeStamp);//最后一次修改时间
        //封装shopOrderInfo
        shopOrderInfo.setOrderId(orderInfo.getOrderId());
        shopOrderInfo.setShopOrderId(shopOrderId);//用户订单编号，UUID
        shopOrderInfo.setGoodsTotalNum(goodsTotalNum);//订单商品总数
        shopOrderInfo.setOriginalPrice(originalPrice);//原价格
        shopOrderInfo.setUserId(orderInfo.getUserId());
        shopOrderInfo.setScardNo(orderInfo.getScardNo());
        if (originalPrice != 0 && shopOrderInfo.getPayPrice() != 0)
        {
            shopOrderInfo.setDiscountRate(shopOrderInfo.getPayPrice() / originalPrice);//折扣
        }
        shopOrderInfo.setIsDel("N");
        return orderInfo;
    }

    /**
     * 封装OrderDetailInfo、shopOrderDetail
     * @param orderId
     * @param userOrderId
     * @param userOrderInfo
     * @param shopOrderDetail
     * @return
     * @throws Exception
     */
    private OrderDetailInfo getOrderDetailInfo11(String shopOrderId, ShopOrderDetail shopOrderDetail, OrderDetailInfo orderDetailInfo) throws Exception
    {
        //封装OrderDetailInfo
        orderDetailInfo.setOrderDetailId(shopOrderId);//订单明细编号，UUID
        //        orderDetailInfo.setOrderId(orderId);//订单编号
        //        orderDetailInfo.setGoodsId(goodsId);//商品编号
        //        orderDetailInfo.setGoodsName(goodsName);//商品名称（来自账单文件）
        //        orderDetailInfo.setShopId(shopId);//商家编号
        //        orderDetailInfo.setShopEntityId(shopEntityId);//实体店编号
        //        orderDetailInfo.setGoodsCategoryRoot(goodsCategoryRoot);//品类编号（根节点）
        //        orderDetailInfo.setGoodsCategoryLeaf(goodsCategoryLeaf);//品类编号（叶节点）
        //        orderDetailInfo.setGoodsBrand(goodsBrand);//品牌编号
        //        orderDetailInfo.setGoodsSerial(goodsSerial);//商品序列号（商品的唯一识别编码）
        //        orderDetailInfo.setItemSerial(itemSerial);//自定义序列号（商品细分的唯一识别编码）
        //        orderDetailInfo.setPrice(price);//商品价格
        //        orderDetailInfo.setGoodsImg(goodsImg);//商品主图地址
        orderDetailInfo.setPayPrice(shopOrderDetail.getPayPrice());//实际支付单价（来自账单文件）
        orderDetailInfo.setGoodsNum(shopOrderDetail.getGoodsNum());//商品数量（来自账单文件）
        //        orderDetailInfo.setGoodsWeight(goodsWeight);//'商品重量（来自账单文件）',
        if (shopOrderDetail.getPayPrice() != null && shopOrderDetail.getPayPrice() != 0 && shopOrderDetail.getGoodsNum() != null && shopOrderDetail.getGoodsNum() != 0)
        {
            orderDetailInfo.setTotalPrice(shopOrderDetail.getPayPrice() * shopOrderDetail.getGoodsNum());//实际支付总价=商品数量×实际支付单价
        }
        //        orderDetailInfo.setUserId(userId);//提交者（只保留第一个提交此商品的人，后来提交的只做数量合并，不覆盖提交者）
        //        orderDetailInfo.setAvoidItem(avoidItem);//'忌口',
        //        orderDetailInfo.setServeNum(serveNum);//上菜情况（仅针对餐饮），默认值为0
        //        orderDetailInfo.setCommentId(commentId);//评论编号
        //封装userOrderDetail
        shopOrderDetail.setShopOrderDetailId(UUID.getUUID());//订单明细编号，UUID
        shopOrderDetail.setShopOrderId(shopOrderId);//商家订单编号
        shopOrderDetail.setShopId(orderDetailInfo.getShopId());//商家编号
        shopOrderDetail.setShopEntityId(orderDetailInfo.getShopEntityId());//实体店编号
        shopOrderDetail.setGoodsId(orderDetailInfo.getGoodsId());//商品编号
        //        shopOrderDetail.setGoodsName(goodsName);//商品名称
        shopOrderDetail.setGoodsPrice(orderDetailInfo.getPrice());//商品单价
        //        shopOrderDetail.setPayPrice(payPrice);//实际支付单价
        //        shopOrderDetail.setGoodsNum(goodsNum);//商品数量
        //        shopOrderDetail.setTotalPrice(totalPrice);//实际支付总价=商品数量×实际支付单价
        return orderDetailInfo;
    }

    /**
     * 封装orderInfo、userOrderInfo
     * @param orderId
     * @param userOrderId
     * @param userOrderInfo
     * @param orderDetailInfoList
     * @param goodsTotalNum
     * @param originalPrice
     * @return
     * @throws Exception
     */
    private OrderInfo getOrderInfo11(OrderInfo orderInfo, String shopOrderId, ShopOrderInfo shopOrderInfo, Integer goodsTotalNum, Double originalPrice) throws Exception
    {
        //        orderInfo.setOrderId(shopOrderId);//订单编号，UUID
        orderInfo.setBillType("1");//订单状态，-1-远程提交，0-用户提交，1-商家处理，2-申请结账，3-已结账
        //        orderInfo.setShopId(shopId);//商家编号
        //        orderInfo.setShopEntityId(shopEntityId);//实体店编号
        //        orderInfo.setUserId(userId);//用户编号
        orderInfo.setMac(shopOrderInfo.getMac());//商家硬件设备MAC地址
        orderInfo.setRequestTime(new Date());//消费时间
        orderInfo.setThirdOrderId(shopOrderInfo.getThirdOrderId());//第三方订单编号
        //        orderInfo.setScardNo(scardNo);//会员卡号，16位音频卡号
        orderInfo.setGoodsTotalNum(goodsTotalNum);//账单商品总数
        orderInfo.setOriginalPrice(originalPrice);//原价格
        if (originalPrice != 0 && shopOrderInfo.getPayPrice() != 0)
        {
            orderInfo.setDiscountRate(shopOrderInfo.getPayPrice() / originalPrice);//折扣
        }
        orderInfo.setPayPrice(shopOrderInfo.getPayPrice());//实际支付价格
        //        orderInfo.setTakeMethod(takeMethod);//提货方式，0-直接拿走、1-前台提货、2-送货上门
        //        orderInfo.setConsigneeId(consigneeId);//收货人信息编号，关联收货人信息的主键
        //        orderInfo.setDeliveryStatus(deliveryStatus);//取货状态，0-用户未收到货物，1-商家已拣货，2-商家已发货，3-用户已收取货物
        orderInfo.setRoomName(shopOrderInfo.getRoomName());//房间名称（仅针对餐饮）
        orderInfo.setDeskName(shopOrderInfo.getDeskName());//桌子名称（仅针对餐饮）
        //        orderInfo.setIsSaCommit(isSaCommit);//是否店员助理提交，Y-是，N-否
        //        orderInfo.setAccount(account);//店员助理登录帐号
        //        orderInfo.setUserOrderTime(userOrderTime);//用户订单提交时间
        orderInfo.setShopOrderTime(new Date());//商家订单提交时间（仅针对餐饮）
        //        orderInfo.setPaymentApplicationTime(paymentApplicationTime);//申请结账时间（仅针对餐饮）
        //        orderInfo.setPaymentTime(paymentTime);//结账时间
        //        orderInfo.setInvoiceApplicationTime(invoiceApplicationTime);//申请开发票时间
        orderInfo.setIsInvoice("N");//是否开具发票，N-未开发票，Y-已开发票
        //        orderInfo.setInvoiceTime(invoiceTime);//开发票时间
        //        orderInfo.setInvoiceLatestTime(invoiceLatestTime);//最晚开发票时间，为结账时间+最晚开发票天数
        //        orderInfo.setBillId(billId);//账单编号
        //        orderInfo.setUserOrderId(userOrderId);//用户订单编号
        //        orderInfo.setAvoidItem(avoidItem);//'整单忌口',
        //        orderInfo.setDiningNumbers(diningNumbers);//'就餐人数'
        orderInfo.setIsDel("N");//是否删除，Y-已删除，N-未删除
        //        orderInfo.setCreateTime(createTime);//创建时间
        //        orderInfo.setCTimeStamp(cTimeStamp);//最后一次修改时间
        //封装shopOrderInfo
        shopOrderInfo.setOrderId(orderInfo.getOrderId());
        shopOrderInfo.setShopOrderId(shopOrderId);//用户订单编号，UUID
        shopOrderInfo.setGoodsTotalNum(goodsTotalNum);//订单商品总数
        shopOrderInfo.setOriginalPrice(originalPrice);//原价格
        shopOrderInfo.setUserId(orderInfo.getUserId());
        shopOrderInfo.setScardNo(orderInfo.getScardNo());
        if (originalPrice != 0 && shopOrderInfo.getPayPrice() != 0)
        {
            shopOrderInfo.setDiscountRate(shopOrderInfo.getPayPrice() / originalPrice);//折扣
        }
        shopOrderInfo.setIsDel("N");
        return orderInfo;
    }

    /**
     * 校验商家订单类型01-（此餐桌无用户订单，本次上传为商家订单）；11-（此餐桌有用户订单，本次上传为商家订单）；12-（此餐桌有用户订单，本次上传为加菜订单）；13-（此餐桌有用户订单，本次上传为减菜订单）
     * @param orderBusiness
     * @param shopOrderInfo
     * @param shopOrderDetailList
     * @return
     */
    private String checkShopOrderType(OrderBusiness orderBusiness, ShopOrderInfo shopOrderInfo, List<ShopOrderDetail> shopOrderDetailList)
    {
        //判断是否有未结账订单
        OrderInfo orderInfo = this.transactionProtectedCoreService.getNotCheckoutOrder(shopOrderInfo.getDeskName(), shopOrderInfo.getShopEntityId());
        if (orderInfo == null)
        {//0-此餐桌无用户订单
            return "01";//01-此餐桌无用户订单，本次上传为商家订单
        }
        else
        {//1-此餐桌有用户订单
            orderBusiness.setOrderInfo(orderInfo);//供调用者使用
            List<OrderDetailInfo> orderDetailInfoList = new ArrayList<OrderDetailInfo>();
            List<OrderDetailInfo> orderDetailInfoListTemp = this.getOrderDetailInfo(orderInfo.getOrderId());
            if (CollectionUtils.isNotEmpty(orderDetailInfoListTemp))
            {
                orderBusiness.setOrderDetailInfoList(orderDetailInfoListTemp);//供调用者使用
                for (ShopOrderDetail shopOrderDetail : shopOrderDetailList)
                {
                    for (OrderDetailInfo orderDetailInfo : orderDetailInfoListTemp)
                    {
                        if (orderDetailInfo.getGoodsName().equals(shopOrderDetail.getGoodsName()))
                        {
                            orderDetailInfoList.add(orderDetailInfo);
                            orderDetailInfoListTemp.remove(orderDetailInfo);
                        }
                    }
                }
            }
            List<BillAddInfo> billAddInfoListTemp = this.getBillAddInfo(orderInfo.getOrderId());
            List<BillAddInfo> billAddList = new ArrayList<BillAddInfo>();
            List<BillAddInfo> billMinusList = new ArrayList<BillAddInfo>();
            if (CollectionUtils.isEmpty(billAddInfoListTemp)) //无用户加菜减菜申请信息,则为第一次商家订单提交
            {//商家订单
                return "11";//11-此餐桌有用户订单，本次上传为商家订单
            }
            else
            {
                for (ShopOrderDetail shopOrderDetail : shopOrderDetailList)
                {
                    for (BillAddInfo billAddInfo : billAddInfoListTemp)
                    {
                        String addGoodsName = billAddInfo.getGoodsName();
                        String typeDeal = billAddInfo.getTypeDeal();
                        if (addGoodsName.equals(shopOrderDetail.getGoodsName()))
                        {
                            if ("0".equals(typeDeal))
                            {
                                billAddInfo.setIsDeal("Y");
                                billAddInfo.setDealTime(new Date());
                                billAddList.add(billAddInfo);
                                billAddInfoListTemp.remove(billAddInfo);
                            }
                            else if ("1".equals(typeDeal))
                            {
                                billAddInfo.setIsDeal("Y");
                                billAddInfo.setDealTime(new Date());
                                billMinusList.add(billAddInfo);
                                billAddInfoListTemp.remove(billAddInfo);
                            }
                        }
                    }
                }
            }
            if (orderDetailInfoList.size() == shopOrderDetailList.size() && billAddList.size() == shopOrderDetailList.size() && billMinusList.size() == shopOrderDetailList.size())
            {
                if ("0".equals(orderInfo.getBillType()))
                {//订单状态为用户提交的情况下优先处理商家订单
                    return "11";//11-此餐桌有用户订单，本次上传为商家订单
                }
                else
                {//同时满足加菜、减菜申请，以先提交的为准
                    if (TimeUtils.dateDiff(TimeUtils.DATATYPE_SECOND, billAddList.get(0).getCreateTime(), billMinusList.get(0).getCreateTime()) > 0)
                    {//用户先提交加菜申请
                        orderBusiness.setBillAddInfoList(billAddList);//供调用者使用
                        return "12";//12-此餐桌有用户订单，本次上传为加菜订单
                    }
                    else
                    {//用户先提交减菜申请
                        orderBusiness.setBillAddInfoList(billMinusList);//供调用者使用
                        return "13";//13-此餐桌有用户订单，本次上传为减菜订单
                    }
                }
            }
            if (orderDetailInfoList.size() == shopOrderDetailList.size() && billAddList.size() == shopOrderDetailList.size() && billMinusList.size() != shopOrderDetailList.size())
            {
                if ("0".equals(orderInfo.getBillType()))
                {//订单状态为用户提交的情况下优先处理商家订单
                    return "11";//11-此餐桌有用户订单，本次上传为商家订单
                }
                else
                {//加菜加菜订单
                    orderBusiness.setBillAddInfoList(billAddList);//供调用者使用
                    return "12";//12-此餐桌有用户订单，本次上传为加菜订单
                }
            }
            if (orderDetailInfoList.size() == shopOrderDetailList.size() && billAddList.size() != shopOrderDetailList.size() && billMinusList.size() == shopOrderDetailList.size())
            {
                if ("0".equals(orderInfo.getBillType()))
                {//订单状态为用户提交的情况下优先处理商家订单
                    return "11";//11-此餐桌有用户订单，本次上传为商家订单
                }
                else
                {//减菜订单
                    orderBusiness.setBillAddInfoList(billMinusList);//供调用者使用
                    return "13";//13-此餐桌有用户订单，本次上传为减菜订单
                }
            }
            if (orderDetailInfoList.size() == shopOrderDetailList.size() && billAddList.size() != shopOrderDetailList.size() && billMinusList.size() != shopOrderDetailList.size())
            {//商家订单
                return "11";//11-此餐桌有用户订单，本次上传为商家订单
            }
            if (orderDetailInfoList.size() != shopOrderDetailList.size() && billAddList.size() == shopOrderDetailList.size() && billMinusList.size() == shopOrderDetailList.size())
            {//同时满足加菜、减菜申请，以先提交的为准
                if (TimeUtils.dateDiff(TimeUtils.DATATYPE_SECOND, billAddList.get(0).getCreateTime(), billMinusList.get(0).getCreateTime()) > 0)
                {//用户先提交加菜申请
                    orderBusiness.setBillAddInfoList(billAddList);//供调用者使用
                    return "12";//12-此餐桌有用户订单，本次上传为加菜订单
                }
                else
                {//用户先提交减菜申请
                    orderBusiness.setBillAddInfoList(billMinusList);//供调用者使用
                    return "13";//13-此餐桌有用户订单，本次上传为减菜订单
                }
            }
            if (orderDetailInfoList.size() != shopOrderDetailList.size() && billAddList.size() != shopOrderDetailList.size() && billMinusList.size() == shopOrderDetailList.size())
            {//减菜订单
                orderBusiness.setBillAddInfoList(billMinusList);//供调用者使用
                return "13";//13-此餐桌有用户订单，本次上传为减菜订单
            }
            if (orderDetailInfoList.size() != shopOrderDetailList.size() && billAddList.size() == shopOrderDetailList.size() && billMinusList.size() != shopOrderDetailList.size())
            {//加菜订单
                orderBusiness.setBillAddInfoList(billAddList);//供调用者使用
                return "12";//12-此餐桌有用户订单，本次上传为加菜订单
            }
            else
            //(orderDetailInfoList.size() != shopOrderDetailList.size() && billAddList.size() != shopOrderDetailList.size() && billMinusList.size() != shopOrderDetailList.size())
            {
                return "00";//异常
            }
        }
    }

    /**
     * 根据orderId查询用户提交的加菜减菜申请
     * @param orderId
     * @return
     */
    private List<BillAddInfo> getBillAddInfo(String orderId)
    {
        BillAddInfoExample billAddInfoExample = new BillAddInfoExample();
        billAddInfoExample.createCriteria().andOrderIdEqualTo(orderId).andIsDealEqualTo("N").andIsDelEqualTo("N");
        List<BillAddInfo> billAddInfoList = this.billAddInfoMapper.selectByExample(billAddInfoExample);
        return billAddInfoList;
    }

    /**
     * 根据orderId查询订单商品详细信息
     * @param orderId
     * @return
     */
    private List<OrderDetailInfo> getOrderDetailInfo(String orderId)
    {
        OrderDetailInfoExample orderDetailInfoExample = new OrderDetailInfoExample();
        orderDetailInfoExample.createCriteria().andOrderIdEqualTo(orderId).andServeNumNotEqualTo("0");
        return this.orderDetailInfoMapper.selectByExample(orderDetailInfoExample);
    }

    public static void main(String[] args)
    {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setMac("11111");//商家硬件设备MAC地址
        orderInfo.setRequestTime(new Date());//消费时间
        orderInfo.setBillType("1");//订单状态，0-用户提交，1-商家处理，2-申请结账，3-已结账
        orderInfo.setUserId("11111");//用户编号
        orderInfo.setScardNo("11111");//会员卡号，16位音频卡号
        orderInfo.setGoodsTotalNum(111);//账单商品总数
        orderInfo.setOriginalPrice(111.00);//原价格
        orderInfo.setPayPrice(111.00);//实际支付价格
        orderInfo.setShopOrderTime(new Date());//商家订单提交时间（仅针对餐饮）
        orderInfo.setIsDel("N");//是否删除，Y-已删除，N-未删除
        orderInfo.setOrderId("11111");//订单编号，UUID
        orderInfo.setShopId("11111");//商家编号
        orderInfo.setShopEntityId("11111");//实体店编号
        int i;
        long s = System.currentTimeMillis();

        for (i = 0; i < 10000; i++)
        {
            ShopOrderInfo shopOrderInfo = new ShopOrderInfo();
            shopOrderInfo.setScardNo(orderInfo.getAccount() == "" ? "1" : "2");
            shopOrderInfo.setUserId(orderInfo.getUserId());
            shopOrderInfo.setGoodsTotalNum(orderInfo.getGoodsTotalNum());
            shopOrderInfo.setIsDel("N");
            shopOrderInfo.setOriginalPrice(3.0 * 3);
            shopOrderInfo.setPayPrice(orderInfo.getPayPrice());
        }
        System.out.println(System.currentTimeMillis() - s);
    }
}
