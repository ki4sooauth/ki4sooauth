package com.gooagoo.gas.api.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.transaction.order.ChangeFoodCoreService;
import com.gooagoo.api.business.core.transaction.order.OrderCoreService;
import com.gooagoo.api.business.core.transaction.order.ServeFoodCoreService;
import com.gooagoo.api.business.core.transaction.order.ShopBillCoreService;
import com.gooagoo.api.business.core.transaction.order.UserOrderCoreService;
import com.gooagoo.api.business.query.shop.table.TableStatusQueryService;
import com.gooagoo.api.business.query.user.favorite.FavoriteQueryService;
import com.gooagoo.api.generator.query.member.MemberOfCardGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.business.shop.table.TableDiningStatus;
import com.gooagoo.entity.business.transaction.OrderResult;
import com.gooagoo.entity.business.user.FavoriteInfoDetail;
import com.gooagoo.entity.generator.behave.FavoriteInfoExample;
import com.gooagoo.entity.generator.bill.BillAddInfo;
import com.gooagoo.entity.generator.bill.BillPayApplication;
import com.gooagoo.entity.generator.bill.OrderCouponInfo;
import com.gooagoo.entity.generator.bill.UserOrderDetail;
import com.gooagoo.entity.generator.bill.UserOrderInfo;
import com.gooagoo.entity.generator.marketing.Coupon;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.exception.MessageException;
import com.gooagoo.gas.api.service.OrderLinkGasService;
import com.gooagoo.gas.common.MessageConst;
import com.gooagoo.gas.common.ToolsUtils;
import com.gooagoo.gas.common.entity.GoodsInfoEntity;
import com.gooagoo.gas.entity.gasl02.transform.Desklist;
import com.gooagoo.gas.entity.gasl02.transform.GetAllBillRoot;
import com.gooagoo.gas.entity.gasl13.transform.FindCouponRoot;
import com.gooagoo.gas.entity.gasl13.transform.Voucherdetail;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class OrderLinkGasServiceImpl implements OrderLinkGasService
{
    @Autowired
    private ChangeFoodCoreService changeFoodCoreService;
    @Autowired
    private TableStatusQueryService tableStatusQueryService;
    @Autowired
    private UserOrderCoreService userOrderCoreService;
    @Autowired
    private ServeFoodCoreService serveFoodCoreService;
    @Autowired
    private ShopBillCoreService shopBillCoreService;
    @Autowired
    private FavoriteQueryService favoriteQueryService;
    @Autowired
    private MemberOfCardGeneratorQueryService memberOfCardGeneratorQueryService;
    @Autowired
    private OrderCoreService orderCoreService;

    @Override
    public GetAllBillRoot queryHaveDinnerStatus(String shopEntityId, String tableName, String pageIndex, String pageSize) throws Exception
    {
        GooagooLog.info("queryHaveDinnerStatus-->入参:shopEntityId=" + shopEntityId + ",tableName=" + tableName + ",pageIndex=" + pageIndex + "pageSize" + pageSize);
        //1.查询正在用餐餐桌的状态
        List<TableDiningStatus> tableDiningStatusList = this.tableStatusQueryService.findTableDiningStatus(shopEntityId, tableName, Integer.valueOf(pageIndex), Integer.valueOf(pageSize));
        GooagooLog.debug("查询查询已开台餐桌的用餐状态信息为：" + new Gson().toJson(tableDiningStatusList));
        List<Desklist> desklist = null;
        if (CollectionUtils.isNotEmpty(tableDiningStatusList))
        {
            //2.组装餐桌状态信息
            desklist = new ArrayList<Desklist>();
            for (TableDiningStatus temp : tableDiningStatusList)
            {
                Desklist desk = new Desklist();
                desk.setDeskno(temp.getTableName());
                desk.setDesktypecode(temp.getTabletypecode());
                desk.setDesktypename(temp.getTableTypeName());
                desk.setIsvip(temp.getMemberType());
                desk.setScardno(temp.getScardno());
                desk.setDeskstate(temp.getTableStatus());
                desk.setMealtime(temp.getMealtime());
                desk.setUserordertime(temp.getUserordertime());
                desklist.add(desk);
            }
        }
        //2.组装返回对象
        GetAllBillRoot root = new GetAllBillRoot();
        root.setDesklist(desklist);
        return root;
    }

    @Override
    public String commitCateringOrder(String shopId, String shopEntityId, String deskNo, String goodsInfo, String dishway) throws Exception
    {
        GooagooLog.info("commitCateringOrder-->入参:shopEntityId=" + shopEntityId + ",deskNo=" + deskNo + ",goodsInfo=" + goodsInfo + " ,dishWay=" + dishway);
        //1.取商品信息
        List<GoodsInfoEntity> goodsInfoList = ToolsUtils.getGoodsInfo(goodsInfo);

        //2.封装点餐用户订单信息
        UserOrderInfo userOrderInfo = new UserOrderInfo();
        userOrderInfo.setShopId(shopId);
        userOrderInfo.setShopEntityId(shopEntityId);
        userOrderInfo.setDeskName(deskNo);
        userOrderInfo.setIsSaCommit("Y");//店员助理提交
        userOrderInfo.setTakeMethod("0");//提货方式，0-直接拿走、1-前台提货、2-送货上门
        //        userOrderInfo.setDeliveryStatus("0");//取货状态，0-用户未收到货物，1-商家已拣货，2-商家已发货，3-用户已收取货物
        List<UserOrderDetail> userOrderDetailList = null;
        if (CollectionUtils.isNotEmpty(goodsInfoList))
        {
            userOrderDetailList = new ArrayList<UserOrderDetail>();
            for (GoodsInfoEntity tempGoodsInfoEntity : goodsInfoList)
            {
                UserOrderDetail userOrderDetail = new UserOrderDetail();
                userOrderDetail.setShopId(shopId);
                userOrderDetail.setShopEntityId(shopEntityId);
                userOrderDetail.setGoodsId(tempGoodsInfoEntity.getGoodsId());
                userOrderDetail.setGoodsNum(tempGoodsInfoEntity.getGoodsnum());
                userOrderDetailList.add(userOrderDetail);
            }
        }
        GooagooLog.debug("封装的点餐用户订单信息,userOrderInfo-->" + new Gson().toJson(userOrderInfo) + ",UserOrderDetail-->" + new Gson().toJson(userOrderDetailList));

        //3.店员帮用户提交点餐单（餐饮业）
        OrderResult addUserOrder = this.userOrderCoreService.addUserOrder(null, userOrderInfo, userOrderDetailList, null, null);

        GooagooLog.debug("提交点菜单返回信息:" + new Gson().toJson(addUserOrder));
        if (addUserOrder == null || !StringUtils.hasText(addUserOrder.getOrderId()))
        {
            throw new MessageException(MessageConst.GAS_BILL_ADD_FAIL);
        }
        return addUserOrder.getOrderId();
    }

    @Override
    public boolean markUpDish(String orderId, String shopEntityId, String tableName, String foodsInfo) throws Exception
    {
        GooagooLog.info("markUpDish-->入参:orderId=" + orderId + ",foodsInfo=" + foodsInfo);
        //1.组织入参
        List<Map<String, String>> goodsInfo = new Gson().fromJson(foodsInfo, new TypeToken<List<Map<String, String>>>()
        {
        }.getType());
        //2.店员标记已上菜品
        return this.serveFoodCoreService.serve(orderId, shopEntityId, tableName, goodsInfo);
    }

    @Override
    public boolean submitPayBillApply(String orderId, String shopId, String shopEntityId, String scardNo, String couponId) throws Exception
    {
        GooagooLog.info("submitPayBillApply-->入参:orderId=" + orderId + ",shopId=" + shopId + ",shopEntityId=" + shopEntityId + ",scardNo" + scardNo + ",couponId" + couponId);
        //1.封装订单申请信息
        BillPayApplication billPayApplication = new BillPayApplication();
        billPayApplication.setOrderId(orderId);
        billPayApplication.setShopId(shopId);
        billPayApplication.setShopEntityId(shopEntityId);

        GooagooLog.debug("封装订单申请信息为：" + new Gson().toJson(billPayApplication));

        //2.封装优惠券信息
        List<OrderCouponInfo> orderCouponInfoList = null;
        if (StringUtils.hasText(couponId))
        {//有优惠券
            String couponIds[] = couponId.split(",");
            orderCouponInfoList = new ArrayList<OrderCouponInfo>();
            for (int i = 0; i < couponIds.length; i++)
            {
                OrderCouponInfo tempOrderCouponInfo = new OrderCouponInfo();
                tempOrderCouponInfo.setCouponUserId(couponIds[i]);
                tempOrderCouponInfo.setOrderId(orderId);
                tempOrderCouponInfo.setShopId(shopId);
                tempOrderCouponInfo.setShopEntityId(shopEntityId);
                orderCouponInfoList.add(tempOrderCouponInfo);
            }

            GooagooLog.debug("封装优惠券信息为：" + new Gson().toJson(orderCouponInfoList));
        }

        //3.店员帮用户提交结账申请
        boolean result = this.shopBillCoreService.applyBill(null, scardNo, billPayApplication, orderCouponInfoList);
        return result;
    }

    @Override
    public boolean submitAddDishApply(String shopId, String shopEntityId, String tableName, String goodsInfo) throws Exception
    {

        GooagooLog.info("submitAddDishApply-->入参:shopEntityId=" + shopEntityId + ",tableName=" + tableName + ",goodsInfo=" + goodsInfo);
        //1.组装加菜申请信息
        List<BillAddInfo> billAddInfoList = this.getBillAddInfoData(shopId, shopEntityId, goodsInfo);
        //2.店员帮用户提交加菜申请
        return this.changeFoodCoreService.applyAddFood(tableName, billAddInfoList);
    }

    @Override
    public boolean submitSubDishApply(String shopId, String shopEntityId, String tableName, String goodsInfo) throws Exception
    {

        GooagooLog.info("submitSubDishApply-->入参:shopEntityId=" + shopEntityId + ",tableName=" + tableName + ",goodsInfo=" + goodsInfo);
        //1.组装减菜申请信息
        List<BillAddInfo> billAddInfoList = this.getBillAddInfoData(shopId, shopEntityId, goodsInfo);
        //2.店员帮用户提交减菜申请
        return this.changeFoodCoreService.applyMinusFood(tableName, billAddInfoList);
    }

    /**
     * 组装加减菜信息
     * @param shopId 商家编号
     * @param shopEntityId 实体店编号
     * @param goodsInfo 加减菜点餐信息
     * @return
     */
    public List<BillAddInfo> getBillAddInfoData(String shopId, String shopEntityId, String goodsInfo)
    {
        //1.取订单中商品信息
        List<GoodsInfoEntity> goodsInfoEntityList = ToolsUtils.getGoodsInfo(goodsInfo);
        List<BillAddInfo> billAddInfoList = null;
        if (CollectionUtils.isNotEmpty(goodsInfoEntityList))
        {
            //2.组装加减菜订单信息
            billAddInfoList = new ArrayList<BillAddInfo>();
            for (GoodsInfoEntity tempGoodsInfoEntity : goodsInfoEntityList)
            {
                BillAddInfo billAddInfo = new BillAddInfo();
                billAddInfo.setShopId(shopId);
                billAddInfo.setShopEntityId(shopEntityId);
                billAddInfo.setGoodsId(tempGoodsInfoEntity.getGoodsId());
                billAddInfo.setGoodsNum(tempGoodsInfoEntity.getGoodsnum());
                billAddInfoList.add(billAddInfo);
            }
        }
        return billAddInfoList;
    }

    @Override
    public boolean orderDish(String shopEntityId, String orderId, String tableName, String itemSerial, String goodsNum) throws Exception
    {
        GooagooLog.info("orderDish-->入参为:【shopEntityId=" + shopEntityId + " ,orderId=" + orderId + " ,tableName=" + tableName + " ,itemSerial=" + itemSerial + " ,goodsNum=" + goodsNum);

        boolean flag = this.serveFoodCoreService.orderDish(orderId, shopEntityId, tableName, itemSerial, goodsNum);
        if (!flag)
        {
            throw new MessageException(MessageConst.GAS_BILL_SUBMIT_ORDER_DISH_APPLY_FAIL);
        }

        return true;
    }

    @Override
    public boolean updatePeopleNums(String shopEntityId, String tableName, String peopleNums) throws Exception
    {
        GooagooLog.info("updatePeopleNums-->入参为:【shopEntityId=" + shopEntityId + " ,tableName=" + tableName + " ,peopleNums=" + peopleNums);

        boolean flag = this.orderCoreService.changeDiningNumbers(shopEntityId, tableName, peopleNums);
        if (!flag)
        {
            throw new MessageException(MessageConst.GAS_BILL_UPD_HAVA_DINNER_INFO_FAIL);
        }
        return true;
    }

    @Override
    public boolean weightconfirm(String shopEntityId, String orderId, String tableName, String itemSerial, String goodsWeight) throws Exception
    {
        GooagooLog.info("weightconfirm-->入参为:【shopEntityId=" + shopEntityId + " ,orderId=" + orderId + " ,tableName=" + tableName + " ,itemSerial=" + itemSerial + " ,goodsWeight=" + goodsWeight);

        boolean flag = this.orderCoreService.confirmWeight(orderId, shopEntityId, tableName, itemSerial, goodsWeight);
        if (!flag)
        {
            throw new MessageException(MessageConst.GAS_BILL_SUBMIT_ORDER_DISH_APPLY_FAIL);
        }

        return true;
    }

    @Override
    public FindCouponRoot findCoupon(String shopEntityId, String scardNo) throws Exception
    {
        GooagooLog.info("findCoupon-->入参信息为空:【shopEntityId=" + shopEntityId + " ,scardNo=" + scardNo + "】");

        //1.根据scardno查询用户userId（由于刷卡已经校验过会员卡信息，此处不再校验）
        MemberOfCard memberOfCard = this.memberOfCardGeneratorQueryService.selectUnDelByPrimaryKey(scardNo);

        //2.查询用手收藏的优惠券信息

        //1)封装查询条件
        FavoriteInfoExample favoriteInfoExample = new FavoriteInfoExample();
        favoriteInfoExample.createCriteria().andUserIdEqualTo(memberOfCard.getUserId()).andInfoTypeEqualTo("C").andShopIdEqualTo(memberOfCard.getShopId()).andIsDelEqualTo("N");
        //2)查询收藏的优惠券
        List<FavoriteInfoDetail> favoriteInfoDetails = this.favoriteQueryService.findFavoriteList(favoriteInfoExample);
        GooagooLog.debug("查询到会员用户的优惠券信息为:【" + new Gson().toJson(favoriteInfoDetails) + "】");
        List<Voucherdetail> voucherdetailList = null;
        if (CollectionUtils.isNotEmpty(favoriteInfoDetails))
        {
            //3.封装数据
            voucherdetailList = new ArrayList<Voucherdetail>();
            for (FavoriteInfoDetail favoriteInfoDetail : favoriteInfoDetails)
            {
                //优惠凭证
                Coupon coupon = favoriteInfoDetail.getCoupon();
                if (coupon == null)
                {
                    continue;
                }

                Voucherdetail voucherdetail = new Voucherdetail();
                voucherdetail.setCouponcontent(coupon.getCouponContent());
                voucherdetail.setCouponname(coupon.getCouponName());
                voucherdetail.setCoupontype(coupon.getCouponType());
                voucherdetail.setCouponurl(coupon.getCouponUrl());
                voucherdetail.setCouponuserid(favoriteInfoDetail.getFavoriteInfo().getFavoriteId());
                voucherdetail.setCouponvalue(coupon.getCouponValue().toString());
                voucherdetail.setPublishstarttime(TimeUtils.convertDateToString(coupon.getUseStartTime(), TimeUtils.FORMAT1));
                voucherdetail.setPublishendtime(TimeUtils.convertDateToString(coupon.getPublishEndTime(), TimeUtils.FORMAT1));
                voucherdetail.setShopid(coupon.getShopId());
                voucherdetailList.add(voucherdetail);
            }
        }
        FindCouponRoot root = new FindCouponRoot();
        root.setVoucherdetail(voucherdetailList);

        return root;
    }

    @Override
    public boolean hurryDish(String shopEntityId, String orderId, String tableName, String itemSerial, String goodsKind) throws Exception
    {
        GooagooLog.info("hurryDish-->入参为:【shopEntityId=" + shopEntityId + " ,orderId=" + orderId + " ,tableName=" + tableName + " ,itemSerial=" + itemSerial + " ,goodsKind=" + goodsKind);

        boolean flag = this.serveFoodCoreService.hurryDish(orderId, shopEntityId, tableName, itemSerial, goodsKind);
        if (!flag)
        {
            throw new MessageException(MessageConst.GAS_BILL_SUBMIT_HURRY_DISH_APPLY_FAIL);
        }
        return true;
    }

    @Override
    public boolean slowDish(String shopEntityId, String orderId, String tableName, String itemSerial, String goodsNum) throws Exception
    {
        GooagooLog.info("slowDish-->入参为:【shopEntityId=" + shopEntityId + " ,orderId=" + orderId + " ,tableName=" + tableName + " ,itemSerial=" + itemSerial + " ,goodsNum=" + goodsNum);

        boolean flag = this.serveFoodCoreService.slowDish(orderId, shopEntityId, tableName, itemSerial, goodsNum);
        if (!flag)
        {
            throw new MessageException(MessageConst.GAS_BILL_SUBMIT_SLOW_DISH_APPLY_FAIL);
        }
        return true;
    }
}
