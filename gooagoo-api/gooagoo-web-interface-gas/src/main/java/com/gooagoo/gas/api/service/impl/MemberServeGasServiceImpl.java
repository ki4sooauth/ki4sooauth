package com.gooagoo.gas.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.transaction.order.UserOrderCoreService;
import com.gooagoo.api.business.query.goods.query.GoodsQueryService;
import com.gooagoo.api.business.query.member.query.UserMemberQueryService;
import com.gooagoo.api.business.query.member.swipe.SwipeCardQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.business.member.MemberInfoBusiness;
import com.gooagoo.entity.business.transaction.OrderResult;
import com.gooagoo.entity.generator.bill.UserOrderDetail;
import com.gooagoo.entity.generator.bill.UserOrderInfo;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.exception.MessageException;
import com.gooagoo.gas.api.service.MemberServeGasService;
import com.gooagoo.gas.common.MessageConst;
import com.gooagoo.gas.common.ToolsUtils;
import com.gooagoo.gas.common.entity.GoodsInfoEntity;
import com.gooagoo.gas.entity.gasc01.transform.Goodsinfo;
import com.gooagoo.gas.entity.gasc01.transform.QueryGoodsInfoRoot;
import com.gooagoo.gas.entity.gasc03.transform.UserBaseInfoRoot;
import com.gooagoo.gas.entity.gasc03.transform.Userbaseinfo;
import com.google.gson.Gson;

@Service
public class MemberServeGasServiceImpl implements MemberServeGasService
{
    @Autowired
    private GoodsQueryService queryGoodsService;
    @Autowired
    private UserOrderCoreService userOrderCoreService;
    @Autowired
    private UserMemberQueryService userMemberQueryService;
    @Autowired
    private SwipeCardQueryService swipeCardQueryService;

    @Override
    public QueryGoodsInfoRoot queryGoodsInfo(String shopEntityId, String itemSerial) throws Exception
    {
        GooagooLog.info("queryGoodsInfo-->入参:shopEntityid=" + shopEntityId + ",itemserial=" + itemSerial);

        //1.查询商品基本信息
        GoodsBaseInfo goodsBaseInfo = this.queryGoodsService.findGoodsByItemSerial(shopEntityId, itemSerial);

        Goodsinfo goodsInfo = null;
        if (goodsBaseInfo != null)
        {//2.查询到商品信息
            goodsInfo = new Goodsinfo();
            goodsInfo.setGoodsid(goodsBaseInfo.getGoodsId());
            goodsInfo.setGoodsname(goodsBaseInfo.getGoodsName());
            goodsInfo.setPrice(goodsBaseInfo.getPrice().toString());
        }
        //3.封装返回数据
        QueryGoodsInfoRoot root = new QueryGoodsInfoRoot();
        root.setGoodsinfo(goodsInfo);

        return root;
    }

    @Override
    public UserBaseInfoRoot queryMemberBaseInfo(String scardno) throws Exception
    {
        GooagooLog.info("queryMemberBaseInfo-->入参:scardno=" + scardno);

        //1.查询会员信息
        MemberInfoBusiness memberInfoBusiness = this.userMemberQueryService.findMemberInfo(null, null, scardno);

        GooagooLog.debug("查询到会员信息为：" + new Gson().toJson(memberInfoBusiness));
        Userbaseinfo userbaseinfo = null;
        if (memberInfoBusiness != null)
        {
            //2.封装会员信息
            userbaseinfo = new Userbaseinfo();
            userbaseinfo.setUserid(memberInfoBusiness.getUserId());
            userbaseinfo.setCardname(memberInfoBusiness.getCardName());
            userbaseinfo.setRealname(memberInfoBusiness.getName());
            userbaseinfo.setScardno(scardno);
            userbaseinfo.setUseableintegralnumber(memberInfoBusiness.getUseableIntegralNumber() != null ? memberInfoBusiness.getUseableIntegralNumber() : "0");

        }
        UserBaseInfoRoot userBaseInfoRoot = new UserBaseInfoRoot();
        userBaseInfoRoot.setUserbaseinfo(userbaseinfo);
        return userBaseInfoRoot;
    }

    @Override
    public String submitRetailOrder(String userId, String shopId, String shopEntityId, String goodsInfo, String takemethod) throws Exception
    {
        GooagooLog.info("submitRetailOrder-->入参:userId=" + userId + ",shopId=" + shopId + ",shopEntityId=" + shopEntityId + ",goodsInfo=" + goodsInfo);
        //1.从商品信息json串取出商品信息（商品id、商品数量）String :goodsInfo-->Gson-->GoodsInfo goodsInfo
        List<GoodsInfoEntity> getGoodsInfoList = ToolsUtils.getGoodsInfo(goodsInfo);

        GooagooLog.debug("取出商品信息为：" + new Gson().toJson(getGoodsInfoList));
        List<UserOrderDetail> userOrderDetailList = null;
        if (CollectionUtils.isNotEmpty(getGoodsInfoList))
        {
            //2.用户订单明细
            userOrderDetailList = new ArrayList<UserOrderDetail>();
            for (GoodsInfoEntity goodsInfoEntity : getGoodsInfoList)
            {
                UserOrderDetail userOrderDetail = new UserOrderDetail();
                userOrderDetail.setShopId(shopId);
                userOrderDetail.setShopEntityId(shopEntityId);
                userOrderDetail.setGoodsId(goodsInfoEntity.getGoodsId());
                userOrderDetail.setGoodsNum(goodsInfoEntity.getGoodsnum());
                userOrderDetailList.add(userOrderDetail);
            }
        }
        //3.用户订单
        UserOrderInfo userOrderInfo = new UserOrderInfo();
        userOrderInfo.setUserId(userId);
        userOrderInfo.setShopId(shopId);
        userOrderInfo.setShopEntityId(shopEntityId);
        userOrderInfo.setIsSaCommit("Y");//店员助理提交
        userOrderInfo.setTakeMethod(takemethod);//提货方式，0-直接拿走、1-前台提货、2-送货上门
        //        userOrderInfo.setDeliveryStatus("0");//取货状态，0-用户未收到货物，1-商家已拣货，2-商家已发货，3-用户已收取货物

        GooagooLog.debug("封装的订单明细信息为：" + userOrderDetailList.toString() + ",封装的订单明细信息为" + userOrderInfo.toString());
        //4.提交用户订单，返回的值为优惠{可用优惠券、不可用优惠}
        OrderResult adduserorders = this.userOrderCoreService.addUserOrder(null, userOrderInfo, userOrderDetailList, null, null);

        GooagooLog.debug("订单提交返回信息：" + new Gson().toJson(adduserorders));

        if (!StringUtils.hasText(adduserorders.getOrderId()))
        {
            GooagooLog.warn("提交订单失败");
            throw new MessageException(MessageConst.GAS_BILL_ADD_FAIL);
        }
        return adduserorders.getOrderId();
    }

    @Override
    public boolean swipeCardRoot(String scardno, String shopid) throws Exception
    {
        GooagooLog.info("swipeCardRoot-->入参:userId=" + scardno + ",shopId=" + shopid);
        this.swipeCardQueryService.userSwipe(scardno, shopid);
        return true;
    }

}
