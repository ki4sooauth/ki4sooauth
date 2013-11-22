package com.gooagoo.current.comple;

import java.util.ArrayList;
import java.util.List;

import com.gooagoo.api.generator.query.behave.FavoriteInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.bill.OrderCouponInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.bill.OrderDetailInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.bill.OrderInfoGeneratorQueryService;
import com.gooagoo.bi.entity.bill.Bill;
import com.gooagoo.entity.generator.behave.FavoriteInfo;
import com.gooagoo.entity.generator.bill.OrderCouponInfo;
import com.gooagoo.entity.generator.bill.OrderCouponInfoExample;
import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.entity.generator.bill.OrderDetailInfoExample;
import com.gooagoo.entity.generator.bill.OrderInfo;
import com.gooagoo.intelligence.utils.SpringBeanUtils;

public class BillServer
{
    private OrderInfoGeneratorQueryService orderInfoQueryService = SpringBeanUtils.getBean(OrderInfoGeneratorQueryService.class);
    private OrderDetailInfoGeneratorQueryService orderDetailService = SpringBeanUtils.getBean(OrderDetailInfoGeneratorQueryService.class);
    private OrderCouponInfoGeneratorQueryService orderCouponService = SpringBeanUtils.getBean(OrderCouponInfoGeneratorQueryService.class);
    private FavoriteInfoGeneratorQueryService favoriteService = SpringBeanUtils.getBean(FavoriteInfoGeneratorQueryService.class);
    private String billId;
    private String source;

    public BillServer(String billId, String source)
    {
        super();
        this.billId = billId;
        this.source = source;
    }

    public Bill assemblyBill()
    {
        Bill bill = new Bill();
        bill.setSource(source);
        bill.setOrderInfo(order(billId));
        bill.setOrderDetailInfos(orderDetail(billId));
        bill.setCoupons(orderCoupon(billId));
        return bill;
    }

    private OrderInfo order(String billId)
    {
        return this.orderInfoQueryService.selectByPrimaryKey(billId);
    }

    private List<String> orderCoupon(String billId)
    {
        List<String> couponIds = new ArrayList<String>();
        OrderCouponInfoExample example = new OrderCouponInfoExample();
        example.createCriteria().andOrderIdEqualTo(billId).andStatusEqualTo("2");
        List<OrderCouponInfo> couponInfos = this.orderCouponService.selectByExample(example);
        for (OrderCouponInfo orderCouponInfo : couponInfos)
        {
            FavoriteInfo favoriteInfo = this.favoriteService.selectByPrimaryKey(orderCouponInfo.getCouponUserId());
            couponIds.add(favoriteInfo.getObjectId());
        }
        return couponIds;
    }

    private List<OrderDetailInfo> orderDetail(String billId)
    {
        OrderDetailInfoExample example = new OrderDetailInfoExample();
        example.createCriteria().andOrderIdEqualTo(billId);
        return this.orderDetailService.selectByExample(example);
    }
}
