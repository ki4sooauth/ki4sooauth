package com.gooagoo.core.protecteds.transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.generator.core.behave.FavoriteInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.bill.BillAddInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.bill.OrderCouponInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.bill.OrderDetailInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.bill.OrderInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.bill.OrderPicGeneratorCoreService;
import com.gooagoo.api.generator.core.goods.GoodsBaseInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.member.MemberOfCardGeneratorCoreService;
import com.gooagoo.api.protecteds.core.goods.GoodsProtectedCoreService;
import com.gooagoo.api.protecteds.core.transaction.TransactionProtectedCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.SerialUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.business.transaction.CanNotUseCoupon;
import com.gooagoo.entity.business.transaction.CouponRuleJson;
import com.gooagoo.entity.business.transaction.OrderBusiness;
import com.gooagoo.entity.business.transaction.OrderCouponBusiness;
import com.gooagoo.entity.generator.behave.FavoriteInfo;
import com.gooagoo.entity.generator.bill.BillAddInfo;
import com.gooagoo.entity.generator.bill.OrderCouponInfo;
import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.entity.generator.bill.OrderDetailInfoExample;
import com.gooagoo.entity.generator.bill.OrderInfo;
import com.gooagoo.entity.generator.bill.OrderInfoExample;
import com.gooagoo.entity.generator.bill.OrderPic;
import com.gooagoo.entity.generator.bill.UserOrderCoupon;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsBaseInfoExample;
import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.entity.generator.member.MemberOfCardExample;
import com.gooagoo.exception.GooagooException;

@Service
public class TransactionProtectedCoreServiceImpl implements TransactionProtectedCoreService
{

    @Autowired
    private FavoriteInfoGeneratorCoreService favoriteInfoGeneratorCoreService;
    @Autowired
    private OrderCouponInfoGeneratorCoreService orderCouponInfoGeneratorCoreService;
    @Autowired
    private OrderInfoGeneratorCoreService orderInfoGeneratorCoreService;
    @Autowired
    private OrderDetailInfoGeneratorCoreService orderDetailInfoGeneratorCoreService;
    @Autowired
    private GoodsProtectedCoreService goodsProtectedCoreService;
    @Autowired
    private GoodsBaseInfoGeneratorCoreService goodsBaseInfoGeneratorCoreService;
    @Autowired
    private BillAddInfoGeneratorCoreService billAddInfoGeneratorCoreService;
    @Autowired
    private MemberOfCardGeneratorCoreService memberOfCardGeneratorCoreService;
    @Autowired
    private OrderPicGeneratorCoreService orderPicGeneratorCoreService;

    /**
     * 判断优惠券是否可以使用
     * @param userId 用户编号(提交者)
     * @param favoriteId 优惠凭证收藏编号
     * @param shopId 商家编号
     * @param shopEntityId 实体店编号
     * @param categoryTypeSet 购买商品品类编号集合
     * @return true/false
     */
    @Override
    public CanNotUseCoupon checkCoupon(String userId, String favoriteId, String shopId, String shopEntityId, Set<String> categoryTypeSet)
    {
        CanNotUseCoupon result = new CanNotUseCoupon();
        FavoriteInfo favoriteInfo = this.favoriteInfoGeneratorCoreService.selectUnDelByPrimaryKey(favoriteId);
        if (favoriteInfo == null)
        {
            GooagooLog.debug("优惠券favoriteid=" + favoriteId + "不存在");
            result.setFavoriteId(favoriteId);
            result.setCode("1");
            result.setMessage("优惠券favoriteid=" + favoriteId + "不存在");
            return result;
        }
        //a.身份校验：必须是本人的优惠凭证
        if (!userId.equals(favoriteInfo.getUserId()))
        {
            GooagooLog.debug("不是本人的优惠凭证:userid=" + userId + ",favoriteid=" + favoriteId);
            result.setFavoriteId(favoriteId);
            result.setCode("a");
            result.setMessage("不是本人的优惠凭证:userid=" + userId + ",favoriteid=" + favoriteId);
            return result;
        }
        //b.状态校验：未锁定且未使用的优惠凭证
        if ("1".equals(favoriteInfo.getCouponStatus()))
        {
            GooagooLog.debug("已锁定的优惠凭证:favoriteid=" + favoriteId);
            result.setFavoriteId(favoriteId);
            result.setCode("b1");
            result.setMessage("已锁定的优惠凭证:favoriteid=" + favoriteId);
            return result;
        }
        else if ("2".equals(favoriteInfo.getCouponStatus()))
        {
            GooagooLog.debug("已使用的优惠凭证:favoriteid=" + favoriteId);
            result.setFavoriteId(favoriteId);
            result.setCode("b2");
            result.setMessage("已使用的优惠凭证:favoriteid=" + favoriteId);
            return result;
        }
        //通过缓存取优惠凭证信息信息
        /////////////////////////////////////////////////
        Coupon coupon = new Coupon();
        if (coupon == null)
        {
            GooagooLog.error("通过couponid=" + favoriteInfo.getObjectId() + "查询优惠凭证信息为空", null);
            result.setFavoriteId(favoriteId);
            result.setCode("2");
            result.setMessage("优惠券favoriteid=" + favoriteId + "不存在");
            return result;
        }
        //c.期限校验：在指定的期限内才能使用
        if (new Date().after(coupon.getUseEndTime()))
        {
            GooagooLog.debug("已过期的优惠凭证:couponid=" + favoriteInfo.getObjectId());
            result.setFavoriteId(favoriteId);
            result.setCode("c");
            result.setMessage("已过期的优惠凭证:couponid=" + favoriteInfo.getObjectId());
            return result;
        }
        //获得优惠凭证校验信息
        if (!StringUtils.hasText(coupon.getCheckJson()))//无check_json不用校验返回true
        {
            GooagooLog.debug("couponid=" + favoriteInfo.getObjectId() + "优惠凭证使用效验check_json为空,无需使用校验");
            return null;
        }
        CouponRuleJson couponRuleJson = null;
        try
        {
            couponRuleJson = JsonUtils.toObj(coupon.getCheckJson(), CouponRuleJson.class);
        }
        catch (Exception e)
        {
            GooagooLog.error("couponid=" + favoriteInfo.getObjectId() + "check_json=" + coupon.getCheckJson() + "优惠凭证使用效验check_json格式错误", null);
            result.setFavoriteId(favoriteId);
            result.setCode("3");
            result.setMessage("couponid=" + favoriteInfo.getObjectId() + "check_json=" + coupon.getCheckJson() + "优惠凭证使用效验check_json格式错误");
            return result;
        }
        //d.品类：购买了指定品类才能使用
        if (CollectionUtils.isNotEmpty(couponRuleJson.getCategoryData()))//无规则任意品类都可使用
        {
            if (!this.checkCategoryType(categoryTypeSet, couponRuleJson.getCategoryData()))
            {
                GooagooLog.debug("couponid=" + favoriteInfo.getObjectId() + "未购买了指定品类");
                result.setFavoriteId(favoriteId);
                result.setCode("d");
                result.setMessage("couponid=" + favoriteInfo.getObjectId() + "未购买了指定品类");
                return result;
            }
        }
        //e.实体店：在指定实体店才能使用
        if (CollectionUtils.isNotEmpty(couponRuleJson.getShopEntityData()))//无规则任意实体店都可使用
        {
            if (!couponRuleJson.getShopEntityData().contains(shopEntityId))
            {
                GooagooLog.debug("couponid=" + favoriteInfo.getObjectId() + "不在指定实体店");
                result.setFavoriteId(favoriteId);
                result.setCode("e");
                result.setMessage("couponid=" + favoriteInfo.getObjectId() + "不在指定实体店");
                return result;
            }
        }
        //通过缓存取会员卡信息
        String cardId = null;
        if (!StringUtils.hasText(cardId))
        {
            GooagooLog.error("用户userId=" + userId + "无商家shopId=" + shopId + "会员卡", null);
            result.setFavoriteId(favoriteId);
            result.setCode("4");
            result.setMessage("用户userId=" + userId + "无商家shopId=" + shopId + "会员卡");
            return result;
        }
        ///////////////
        //f.会员细分之会员等级：指定级别的会员才能使用
        if (CollectionUtils.isNotEmpty(couponRuleJson.getVipGradeData()))//无规则任意级别会员卡都可使用
        {
            if (!couponRuleJson.getVipGradeData().contains(cardId))
            {
                GooagooLog.debug("couponid=" + favoriteInfo.getObjectId() + "会员等级不符");
                result.setFavoriteId(favoriteId);
                result.setCode("f");
                result.setMessage("couponid=" + favoriteInfo.getObjectId() + "会员等级不符");
                return result;
            }
        }
        return null;
    }

    /**
     * 效验是否购买了优惠凭证指定品类
     * @param categoryTypeSet
     * @param categoryDataList
     * @return
     */
    @Override
    public boolean checkCategoryType(Set<String> categoryTypeSet, List<String> categoryDataList)
    {
        for (String categoryType : categoryTypeSet)
        {
            if (categoryDataList.contains(categoryType))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * 修改优惠券状态
     * @param favoriteId
     * @param couponStatus
     * @return
     */
    @Override
    public boolean changeCouponStatus(String favoriteId, String couponStatus)
    {
        FavoriteInfo favoriteInfo = new FavoriteInfo();
        favoriteInfo.setFavoriteId(favoriteId);
        favoriteInfo.setCouponStatus(couponStatus);
        return this.favoriteInfoGeneratorCoreService.updateByPrimaryKeySelective(favoriteInfo);
    }

    /**
    * 通过用户编号和商家编号获取会员卡音频编号/会员卡音频编号获取用户编号
    * @param shopId
    * @param userId
    * @param scardNo
    * @return Map<String, String>[keys:userid,scardno]
    */
    @Override
    public Map<String, String> getAccount(String shopId, String userId, String scardNo)
    {
        Map<String, String> accountMap = null;
        MemberOfCard memberOfCard = null;
        if (StringUtils.hasText(scardNo))
        {
            memberOfCard = this.memberOfCardGeneratorCoreService.selectUnDelByPrimaryKey(scardNo);
        }
        else if (StringUtils.hasText(userId) && StringUtils.hasText(shopId))
        {
            MemberOfCardExample memberOfCardExample = new MemberOfCardExample();
            memberOfCardExample.createCriteria().andUserIdEqualTo(userId).andShopIdEqualTo(shopId).andIsDelEqualTo("N");
            List<MemberOfCard> memberOfCardList = this.memberOfCardGeneratorCoreService.selectByExample(memberOfCardExample);
            if (CollectionUtils.isNotEmpty(memberOfCardList))
            {
                memberOfCard = memberOfCardList.get(0);
            }
        }
        if (memberOfCard != null)
        {
            accountMap = new HashMap<String, String>();
            accountMap.put("userid", memberOfCard.getUserId());
            accountMap.put("scardno", memberOfCard.getScardno());
        }
        return accountMap;
    }

    /**
     * 保存订单信息
     * @param orderBusiness
     * @throws Exception
     */
    @Override
    public void saveOrderInfo(OrderBusiness orderBusiness) throws Exception
    {
        if (orderBusiness.getOrderInfo() != null)
        { //添加订单信息
            if ("1".equals(orderBusiness.getOrderInfoUpdateType()))
            {
                if (!this.orderInfoGeneratorCoreService.insertSelective(orderBusiness.getOrderInfo()))
                {
                    GooagooLog.error("添加订单信息[" + orderBusiness.getOrderInfo().toString() + "]失败", null);
                    throw new GooagooException("添加订单信息失败");
                }
            }
            else if ("2".equals(orderBusiness.getOrderInfoUpdateType()))
            {
                if (!this.orderInfoGeneratorCoreService.updateByPrimaryKeySelective(orderBusiness.getOrderInfo()))
                {
                    GooagooLog.error("增量更新订单信息[" + orderBusiness.getOrderInfo().toString() + "]失败", null);
                    throw new GooagooException("增量更新订单信息失败");
                }
            }
        }
        if (orderBusiness.getOrderDetailInfoList() != null)
        {//添加订单商品详细信息
            if ("1".equals(orderBusiness.getOrderDetailInfoUpdateType()))
            {
                for (OrderDetailInfo orderDetailInfo : orderBusiness.getOrderDetailInfoList())
                {
                    if (!this.orderDetailInfoGeneratorCoreService.insertSelective(orderDetailInfo))
                    {
                        GooagooLog.error("添加订单商品详细信息[" + orderDetailInfo.toString() + "]失败", null);
                        throw new GooagooException("添加订单商品详细信息失败");
                    }
                }
            }
            if ("2".equals(orderBusiness.getOrderDetailInfoUpdateType()))
            {
                for (OrderDetailInfo orderDetailInfo : orderBusiness.getOrderDetailInfoList())
                {
                    if (!this.orderDetailInfoGeneratorCoreService.updateByPrimaryKeySelective(orderDetailInfo))
                    {
                        GooagooLog.error("增量更新订单商品详细信息[" + orderDetailInfo.toString() + "]失败", null);
                        throw new GooagooException("增量更新订单商品详细信息失败");
                    }
                }
            }
            if ("3".equals(orderBusiness.getOrderDetailInfoUpdateType()))
            {
                OrderDetailInfoExample orderDetailInfoExample = new OrderDetailInfoExample();
                orderDetailInfoExample.createCriteria().andOrderIdEqualTo(orderBusiness.getOrderInfo().getOrderId());
                this.orderDetailInfoGeneratorCoreService.physicalDeleteByExample(orderDetailInfoExample);
                for (OrderDetailInfo orderDetailInfo : orderBusiness.getOrderDetailInfoList())
                {
                    if (!this.orderDetailInfoGeneratorCoreService.insertSelective(orderDetailInfo))
                    {
                        GooagooLog.error("全量更新订单商品详细信息[" + orderDetailInfo.toString() + "]失败", null);
                        throw new GooagooException("全量更新订单商品详细信息失败");
                    }
                }
            }
            if ("4".equals(orderBusiness.getOrderDetailInfoUpdateType()))
            {
                OrderDetailInfoExample orderDetailInfoExample = new OrderDetailInfoExample();
                orderDetailInfoExample.createCriteria().andOrderIdEqualTo(orderBusiness.getOrderInfo().getOrderId());
                if (!this.orderDetailInfoGeneratorCoreService.physicalDeleteByExample(orderDetailInfoExample))
                {
                    GooagooLog.error("删除订单商品详细信息[" + orderBusiness.getOrderInfo().getOrderId() + "]失败", null);
                    throw new GooagooException("删除订单商品详细信息失败");
                }
            }
        }
        if (orderBusiness.getOrderCouponInfoList() != null)
        { //添加订单优惠凭证详情
            if ("1".equals(orderBusiness.getOrderCouponInfoUpdateType()))
            {
                for (OrderCouponInfo orderCouponInfo : orderBusiness.getOrderCouponInfoList())
                {
                    if (!this.orderCouponInfoGeneratorCoreService.insertSelective(orderCouponInfo))
                    {
                        GooagooLog.error("添加订单优惠凭证详情[" + orderCouponInfo.toString() + "]失败", null);
                        throw new GooagooException("添加订单优惠凭证详情失败");
                    }
                }
            }
            if ("2".equals(orderBusiness.getOrderCouponInfoUpdateType()))
            {
                for (OrderCouponInfo orderCouponInfo : orderBusiness.getOrderCouponInfoList())
                {
                    if (!this.orderCouponInfoGeneratorCoreService.updateByPrimaryKeySelective(orderCouponInfo))
                    {
                        GooagooLog.error("增量更新订单优惠凭证详情[" + orderCouponInfo.toString() + "]失败", null);
                        throw new GooagooException("增量更新订单优惠凭证详情失败");
                    }
                }
            }
        }
        if (orderBusiness.getBillAddInfoList() != null)
        {//添加菜减菜申请
            if ("1".equals(orderBusiness.getBillAddInfoUpdateType()))
            {
                for (BillAddInfo billAddInfo : orderBusiness.getBillAddInfoList())
                {
                    if (!this.billAddInfoGeneratorCoreService.insertSelective(billAddInfo))
                    {
                        GooagooLog.error("添加订单商品详细信息[" + billAddInfo.toString() + "]失败", null);
                        throw new GooagooException("添加订单商品详细信息失败");
                    }
                }
            }
            if ("2".equals(orderBusiness.getBillAddInfoUpdateType()))
            {
                for (BillAddInfo billAddInfo : orderBusiness.getBillAddInfoList())
                {
                    if (!this.billAddInfoGeneratorCoreService.updateByPrimaryKeySelective(billAddInfo))
                    {
                        GooagooLog.error("增量更新订单商品详细信息[" + billAddInfo.toString() + "]失败", null);
                        throw new GooagooException("增量更新订单商品详细信息失败");
                    }
                }
            }

        }
        if (orderBusiness.getOrderPicList() != null)
        {//添加订单图片详情
            for (OrderPic orderPic : orderBusiness.getOrderPicList())
            {
                if (!this.orderPicGeneratorCoreService.insertSelective(orderPic))
                {
                    GooagooLog.error("添加订单商品详细信息[" + orderPic.toString() + "]失败", null);
                    throw new GooagooException("添加订单商品详细信息失败");
                }
            }
        }
    }

    /**
     * 锁定优惠券
     * @param orderCouponInfoList
     * @throws Exception
     */
    @Override
    public void changeCouponStatusForOrder(List<OrderCouponInfo> orderCouponInfoList, String couponStatus) throws Exception
    {
        if (CollectionUtils.isNotEmpty(orderCouponInfoList))
        {
            for (OrderCouponInfo orderCouponInfo : orderCouponInfoList)
            {
                if ("1".equals(orderCouponInfo.getStatus()))
                {
                    if (!this.changeCouponStatus(orderCouponInfo.getCouponUserId(), couponStatus))
                    {
                        GooagooLog.error("锁定优惠券[" + orderCouponInfo.getCouponUserId() + "]失败", null);
                        throw new GooagooException("锁定优惠券失败");
                    }
                }
            }
        }
    }

    /**
     * 查询商品信息
     * @param shopEntityId
     * @param goodsName
     * @return
     */
    @Override
    public GoodsBaseInfo getGoodsBaseInfoFromDB(String shopEntityId, String goodsName, String goodsItemSerial)
    {
        GoodsBaseInfoExample goodsBaseInfoExample = new GoodsBaseInfoExample();
        if (StringUtils.hasText(goodsItemSerial))
        {//自定义序列号不为空时，按序列号查询
            goodsBaseInfoExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andItemSerialEqualTo(goodsItemSerial);
        }
        else
        {
            goodsBaseInfoExample.createCriteria().andShopEntityIdEqualTo(shopEntityId).andGoodsNameEqualTo(goodsName);
        }

        List<GoodsBaseInfo> goodsBaseInfoList = this.goodsBaseInfoGeneratorCoreService.selectByExample(goodsBaseInfoExample);
        GoodsBaseInfo goodsBaseInfo = null;
        if (CollectionUtils.isNotEmpty(goodsBaseInfoList))
        {
            goodsBaseInfo = goodsBaseInfoList.get(0);
        }
        return goodsBaseInfo;
    }

    /**
     * 根据桌号、实体店查询未结账订单
     * @param tableName
     * @param shopEntityId
     * @return
     */
    @Override
    public OrderInfo getNotCheckoutOrder(String tableName, String shopEntityId)
    {
        OrderInfoExample orderInfoExample = new OrderInfoExample();
        if (StringUtils.hasText(tableName))
        {//餐饮业
            orderInfoExample.createCriteria().andBillTypeNotEqualTo("3").andDeskNameEqualTo(tableName).andShopEntityIdEqualTo(shopEntityId).andIsDelEqualTo("N");
            orderInfoExample.setOrderByClause("c_time_stamp desc");
            List<OrderInfo> orderInfoList = this.orderInfoGeneratorCoreService.selectByExample(orderInfoExample);
            if (CollectionUtils.isNotEmpty(orderInfoList))
            {
                return orderInfoList.get(0);
            }
        }
        else
        {//零售业

        }
        return null;

    }

    /**
     * 查询goodsId对应订单详细信息
     * @param goodsId
     * @param orderDetailInfoList
     * @return
     */
    @Override
    public OrderDetailInfo getMatchOrderDetailInfo(String goodsId, String goodsName, List<OrderDetailInfo> orderDetailInfoList)
    {
        if (orderDetailInfoList != null)
        {
            for (OrderDetailInfo orderDetailInfoExist : orderDetailInfoList)
            {
                if (orderDetailInfoExist.getGoodsName().equals(goodsName))
                {
                    return orderDetailInfoExist;
                }
                if (orderDetailInfoExist.getGoodsId().equals(goodsId))
                {
                    return orderDetailInfoExist;
                }
            }
        }
        return null;
    }

    /**
     * 获得订单优惠凭证详情和不能使用的优惠券列表
     * @param userId
     * @param shopId
     * @param shopEntityId
     * @param orderDetailInfoList
     * @param userOrderCouponList
     * @param orderId
     * @return
     * @throws Exception 
     */
    @Override
    public OrderCouponBusiness getOrderCouponBusiness(String userId, String shopId, String shopEntityId, List<OrderDetailInfo> orderDetailInfoList, List<UserOrderCoupon> userOrderCouponList, String orderId) throws Exception
    {
        OrderCouponBusiness orderCouponBusiness = new OrderCouponBusiness();
        List<OrderCouponInfo> orderCouponInfoList = new ArrayList<OrderCouponInfo>();
        List<CanNotUseCoupon> canNotUseCouponList = new ArrayList<CanNotUseCoupon>();
        Set<String> categoryTypeSet = this.getAllCategoryType(shopId, shopEntityId, orderDetailInfoList);
        for (UserOrderCoupon userOrderCoupon : userOrderCouponList)
        {
            //校验优惠券
            CanNotUseCoupon canNotUseCoupon = this.checkCoupon(userId, userOrderCoupon.getCouponUserId(), shopId, shopEntityId, categoryTypeSet);
            String Status = "1";
            if (canNotUseCoupon != null)//优惠券可以使用
            {
                canNotUseCouponList.add(canNotUseCoupon);
                Status = "0";
            }
            OrderCouponInfo orderCouponInfo = new OrderCouponInfo();
            orderCouponInfo.setOrderDetailId(UUID.getUUID());
            orderCouponInfo.setOrderId(orderId);
            orderCouponInfo.setShopId(shopId);
            orderCouponInfo.setShopEntityId(shopEntityId);
            orderCouponInfo.setCouponUserId(userOrderCoupon.getCouponUserId());
            orderCouponInfo.setUserId(userId);
            orderCouponInfo.setCouponSource(userOrderCoupon.getCouponSource());
            orderCouponInfo.setStatus(Status);
            orderCouponInfo.setIsDeal("N");
            orderCouponInfo.setIsDel("N");
            orderCouponInfoList.add(orderCouponInfo);
        }
        orderCouponBusiness.setCanNotUseCouponList(canNotUseCouponList);
        orderCouponBusiness.setOrderCouponInfoList(orderCouponInfoList);
        return orderCouponBusiness;
    }

    /**
     * 查询订单商品对应所有类别
     * @param orderBusiness
     * @param userOrderBusiness
     * @return
     * @throws Exception 
     */
    private Set<String> getAllCategoryType(String shopId, String shopEntityId, List<OrderDetailInfo> orderDetailInfoList) throws Exception
    {
        Set<String> categoryTypeSet = new HashSet<String>();//商品品类，用于检验优惠券
        for (OrderDetailInfo orderDetailInfo : orderDetailInfoList)
        {
            //待优化
            List<String> goodsCategoryList = this.goodsProtectedCoreService.findGoodsCategoryListByParent(shopEntityId, orderDetailInfo.getGoodsCategoryLeaf());
            for (String categoryId : goodsCategoryList)
            {
                categoryTypeSet.add(categoryId);
            }
        }
        return categoryTypeSet;
    }

    /**
     * 获取订单图片详情
     * @param orderId
     * @param picUrl
     * @param picType
     * @return
     */
    @Override
    public OrderPic getOrderPic(String orderId, String picUrl, String picType)
    {
        OrderPic orderPic = new OrderPic();
        orderPic.setIsDel("N");
        orderPic.setOrderDetailId(UUID.getUUID());
        orderPic.setOrderId(orderId);
        orderPic.setPicType(picType);
        orderPic.setPicUrl(picUrl);
        return orderPic;
    }

    @Override
    public String getOrderId(String shopEntityId) throws Exception
    {
        return SerialUtils.createOrderSerial();
    }

}
