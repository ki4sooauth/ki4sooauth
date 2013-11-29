package com.gooagoo.core.business.transaction.order;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.goods.cache.GoodsCacheCoreService;
import com.gooagoo.api.business.core.transaction.order.ChangeFoodCoreService;
import com.gooagoo.api.protecteds.core.transaction.TransactionProtectedCoreService;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.dao.generator.behave.FavoriteInfoMapper;
import com.gooagoo.dao.generator.bill.BillAddInfoMapper;
import com.gooagoo.dao.generator.bill.OrderCouponInfoMapper;
import com.gooagoo.dao.generator.bill.OrderInfoMapper;
import com.gooagoo.dao.generator.marketing.CouponMapper;
import com.gooagoo.entity.business.transaction.CouponRuleJson;
import com.gooagoo.entity.generator.behave.FavoriteInfo;
import com.gooagoo.entity.generator.behave.FavoriteInfoKey;
import com.gooagoo.entity.generator.bill.BillAddInfo;
import com.gooagoo.entity.generator.bill.OrderCouponInfo;
import com.gooagoo.entity.generator.bill.OrderCouponInfoExample;
import com.gooagoo.entity.generator.bill.OrderInfo;
import com.gooagoo.entity.generator.bill.OrderInfoExample;
import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.entity.generator.marketing.CouponKey;
import com.gooagoo.exception.business.bill.OrderNotExistsException;
import com.gooagoo.exception.common.NullException;

@Service
public class ChangeFoodCoreServiceImpl implements ChangeFoodCoreService
{

    @Autowired
    OrderInfoMapper orderInfoMapper;
    @Autowired
    BillAddInfoMapper billAddInfoMapper;
    @Autowired
    OrderCouponInfoMapper orderCouponInfoMapper;
    @Autowired
    FavoriteInfoMapper favoriteInfoMapper;
    @Autowired
    CouponMapper couponMapper;
    @Autowired
    GoodsCacheCoreService goodsCacheCoreService;
    @Autowired
    TransactionProtectedCoreService transactionProtectedCoreService;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean applyAddFood(String tableName, List<BillAddInfo> billAddInfoList) throws Exception
    {
        if (CollectionUtils.isEmpty(billAddInfoList))
        {
            return false;
        }
        //批量添加用户加菜申请信息
        Set<String> categoryTypeSet = this.addBillAddInfoList(tableName, billAddInfoList, "0");
        String orderId = billAddInfoList.get(0).getOrderId();
        if (!StringUtils.hasText(orderId) || CollectionUtils.isEmpty(categoryTypeSet))
        {
            return false;
        }
        //合并订单优惠券
        this.updateOrderCouponInfoList(orderId, categoryTypeSet, "0");
        return true;
    }

    @Override
    public boolean applyMinusFood(String tableName, List<BillAddInfo> billAddInfoList) throws Exception
    {
        if (CollectionUtils.isEmpty(billAddInfoList))
        {
            return false;
        }
        //批量添加用户减菜申请信息
        Set<String> categoryTypeSet = this.addBillAddInfoList(tableName, billAddInfoList, "1");
        String orderId = billAddInfoList.get(0).getOrderId();
        if (!StringUtils.hasText(orderId) && CollectionUtils.isEmpty(categoryTypeSet))
        {
            return false;
        }
        this.updateOrderCouponInfoList(orderId, categoryTypeSet, "1");
        return true;
    }

    /**
     * 批量添加加减菜申请
     * @param billAddInfoList 用户提交的加菜减菜申请（仅针对餐饮）
     * @param tableName 桌号
     * @param typeDeal 加减菜类型，0-加菜，1-减菜
     * @return Set<String> 返回所有加菜品类编号
     * @throws Exception 
     */
    private Set<String> addBillAddInfoList(String tableName, List<BillAddInfo> billAddInfoList, String typeDeal) throws Exception
    {
        Set<String> categoryTypeSet = null;
        if (CollectionUtils.isNotEmpty(billAddInfoList))
        {
            categoryTypeSet = new HashSet<String>();
            for (BillAddInfo billAddInfo : billAddInfoList)
            {
                Map<String, String> goodsCache = this.goodsCacheCoreService.findGoodsInfo(billAddInfo.getGoodsId());
                if (goodsCache == null || goodsCache.size() == 0)
                {
                    throw new NullException("查询商品信息为空[goodsId=" + billAddInfo.getGoodsId() + "]");
                }
                OrderInfoExample orderInfoExample = new OrderInfoExample();
                orderInfoExample.createCriteria().andShopEntityIdEqualTo(billAddInfo.getShopEntityId()).andBillTypeNotEqualTo("3").andDeskNameEqualTo(tableName).andIsDelEqualTo("N");
                List<OrderInfo> orderInfoList = this.orderInfoMapper.selectByExample(orderInfoExample);
                if (CollectionUtils.isEmpty(orderInfoList))
                {
                    throw new OrderNotExistsException("根据条件查询订单为空[shopEntityId=" + billAddInfo.getShopEntityId() + ", tableName=" + tableName + "]");
                }
                String orderId = orderInfoList.get(0).getOrderId();
                billAddInfo.setOrderDetailId(UUID.getUUID());
                billAddInfo.setGoodsName(goodsCache.get("goodsName"));
                billAddInfo.setShopId(goodsCache.get("shopId"));
                billAddInfo.setShopEntityId(billAddInfo.getShopEntityId());
                billAddInfo.setGoodsCategoryRoot(goodsCache.get("goodsCategoryRoot"));
                billAddInfo.setGoodsCategoryLeaf(goodsCache.get("goodsCategoryLeaf"));
                billAddInfo.setGoodsBrand(goodsCache.get("goodsBrand"));
                billAddInfo.setGoodsSerial(goodsCache.get("goodsSerial"));
                billAddInfo.setItemSerial(goodsCache.get("itemSerial"));
                billAddInfo.setPrice(Double.parseDouble(goodsCache.get("price")));
                billAddInfo.setGoodsImg(StringUtils.hasText(goodsCache.get("goodsImg")) ? JsonUtils.json2List(goodsCache.get("goodsImg")).get(0) : null);//商品主图地址，去商品图片的第一张图片
                billAddInfo.setTypeDeal(typeDeal);
                billAddInfo.setOrderId(orderId);
                billAddInfo.setIsDel("N");
                billAddInfo.setIsDeal("N");
                //redis获取商品对应的品类编号放入set集合中
                Map<String, String> categoryCache = this.goodsCacheCoreService.findGoodsCategory(billAddInfo.getShopEntityId(), billAddInfo.getGoodsCategoryLeaf());
                if (categoryCache != null && categoryCache.size() > 0)
                {
                    categoryTypeSet.add(categoryCache.get("categoryId"));
                }
                this.billAddInfoMapper.insertSelective(billAddInfo);
            }
        }
        return categoryTypeSet;
    }

    /**
     * 通过品类编号更新优惠凭证状态
     * @param typeDeal 加减菜类型，0-加菜，1-减菜
     * @param orderId 订单编号
     * @param categoryTypeSet 品类编号
     */
    private void updateOrderCouponInfoList(String orderId, Set<String> categoryTypeSet, String typeDeal)
    {
        //合并优惠凭证
        OrderCouponInfoExample orderCouponInfoExample = new OrderCouponInfoExample();
        orderCouponInfoExample.createCriteria().andOrderIdEqualTo(orderId).andIsDelEqualTo("N");
        List<OrderCouponInfo> orderCouponInfoList = this.orderCouponInfoMapper.selectByExample(orderCouponInfoExample);
        if (CollectionUtils.isNotEmpty(orderCouponInfoList))
        {
            for (OrderCouponInfo orderCouponInfo : orderCouponInfoList)
            {
                FavoriteInfoKey favoriteInfoKey = new FavoriteInfoKey();
                favoriteInfoKey.setFavoriteId(orderCouponInfo.getCouponUserId());
                favoriteInfoKey.setIsDel("N");
                FavoriteInfo favoriteInfo = this.favoriteInfoMapper.selectByPrimaryKey(favoriteInfoKey);
                if (favoriteInfo != null)
                {
                    String couponId = favoriteInfo.getObjectId();//优惠凭证编号
                    CouponKey couponKey = new CouponKey();
                    couponKey.setCouponId(couponId);
                    couponKey.setIsDel("N");
                    Coupon coupon = this.couponMapper.selectByPrimaryKey(couponKey);
                    if (coupon != null)
                    {
                        CouponRuleJson couponRuleJson = JsonUtils.toObj(coupon.getCheckJson(), CouponRuleJson.class);
                        if ("N".equals(orderCouponInfo.getIsDeal()) && this.transactionProtectedCoreService.checkCategoryType(categoryTypeSet, couponRuleJson.getCategoryData()))
                        {
                            if ("0".equals(typeDeal))//类型，0-加菜，1-减菜
                            {
                                if ("1".equals(orderCouponInfo.getStatus()))
                                {
                                    continue;
                                }
                                orderCouponInfo.setStatus("1");
                            }
                            else if ("1".equals(typeDeal))
                            {
                                if ("0".equals(orderCouponInfo.getStatus()))
                                {
                                    continue;
                                }
                                orderCouponInfo.setStatus("0");
                            }
                            this.orderCouponInfoMapper.updateByPrimaryKeySelective(orderCouponInfo);
                        }
                    }
                }
            }
        }

    }

}
