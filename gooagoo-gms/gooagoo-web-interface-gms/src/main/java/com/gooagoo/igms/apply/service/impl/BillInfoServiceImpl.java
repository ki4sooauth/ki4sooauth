package com.gooagoo.igms.apply.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.generator.query.bill.OrderDetailInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.bill.OrderInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.bill.OrderPicGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.entity.generator.bill.OrderDetailInfo;
import com.gooagoo.entity.generator.bill.OrderDetailInfoExample;
import com.gooagoo.entity.generator.bill.OrderInfo;
import com.gooagoo.entity.generator.bill.OrderInfoExample;
import com.gooagoo.entity.generator.bill.OrderInfoExample.Criteria;
import com.gooagoo.entity.generator.bill.OrderPic;
import com.gooagoo.entity.generator.bill.OrderPicExample;
import com.gooagoo.igms.apply.service.BillInfoService;
import com.gooagoo.igms.shopinfo.service.ShopLoginService;
import com.gooagoo.view.gms.apply.FOrderDetailAndPicInfo;
import com.gooagoo.view.gms.apply.FOrderDetailInfo;
import com.gooagoo.view.gms.apply.FOrderInfo;
import com.gooagoo.view.gms.apply.FOrderPic;
import com.gooagoo.view.gms.common.PageModel;

@Service(value = "billInfoService")
public class BillInfoServiceImpl implements BillInfoService
{
    @Autowired
    private OrderInfoGeneratorQueryService orderInfoGeneratorQueryService;
    @Autowired
    private ShopLoginService shopLoginService;
    @Autowired
    private OrderDetailInfoGeneratorQueryService orderDetailInfoGeneratorQueryService;
    @Autowired
    private OrderPicGeneratorQueryService orderPicGeneratorQueryService;

    @Override
    public TransData<PageModel<FOrderInfo>> pageBillInfo(HttpServletRequest request) throws Exception
    {
        ShopLoginInfo shopInfo = this.shopLoginService.getShopLoginInfo(request);
        String fshopEntityId = ServletRequestUtils.getStringParameter(request, "fshopEntityId", "");
        String fscardNo = ServletRequestUtils.getStringParameter(request, "fscardNo", "");
        FOrderInfo fOrderInfo = ServletUtils.objectMethod(FOrderInfo.class, request);
        OrderInfoExample orderInfoExample = new OrderInfoExample();
        Criteria criteria = orderInfoExample.createCriteria();
        criteria.andShopIdEqualTo(shopInfo.getShopAndUserInfo().getShopId());
        if (shopInfo.getShopAndUserInfo().getUserIsShopAccount().equals("N"))
        {
            criteria.andShopEntityIdEqualTo(fOrderInfo.getShopEntityId());
        }
        if (StringUtils.hasText(fshopEntityId))
        {
            criteria.andShopEntityIdEqualTo(fshopEntityId);
        }
        if (StringUtils.hasText(fscardNo))
        {
            criteria.andScardNoLike(fscardNo);
        }
        criteria.andBillTypeEqualTo("3");//暂时查询订单信息，订单状态，-1-远程提交，0-用户提交，1-商家处理，2-申请结账，3-已结账
        int count = this.orderInfoGeneratorQueryService.countByExample(orderInfoExample);
        int pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        orderInfoExample.setPage(pageIndex, pageSize);
        List<OrderInfo> orderInfos = this.orderInfoGeneratorQueryService.selectByExample(orderInfoExample);
        List<FOrderInfo> infos = new ArrayList<FOrderInfo>();
        for (OrderInfo orderInfo : orderInfos)
        {
            FOrderInfo info = new FOrderInfo();
            BeanUtils.copyProperties(orderInfo, info);

            infos.add(info);
        }
        PageModel<FOrderInfo> pm = new PageModel<FOrderInfo>();
        pm.setCount(count);
        pm.setPageIndex(pageIndex);
        pm.setPageSize(pageSize);
        pm.setResult(infos);
        return GMSUtil.toTransData(true, null, pm);
    }

    @Override
    public TransData<FOrderInfo> getBillInfo(HttpServletRequest request) throws Exception
    {
        FOrderInfo fOrderInfo = ServletUtils.objectMethod(FOrderInfo.class, request);
        OrderInfo orderInfo = this.orderInfoGeneratorQueryService.selectUnDelByPrimaryKey(fOrderInfo.getOrderId());
        FOrderInfo fInfo = new FOrderInfo();
        BeanUtils.copyProperties(orderInfo, fInfo);
        fInfo.setDeliveryStatusName(orderInfo.getDeliveryStatus());
        return GMSUtil.toTransData(true, null, fInfo);
    }

    @Override
    public TransData<PageModel<FOrderDetailAndPicInfo>> pageBillDetailInfo(HttpServletRequest request) throws Exception
    {
        ShopLoginInfo shopInfo = this.shopLoginService.getShopLoginInfo(request);
        FOrderDetailInfo fOrderDetailInfo = ServletUtils.objectMethod(FOrderDetailInfo.class, request);
        String orderid = ServletRequestUtils.getStringParameter(request, "orderid", "");
        OrderDetailInfoExample example = new OrderDetailInfoExample();
        if (StringUtils.hasText(orderid))
        {

            example.createCriteria().andOrderIdEqualTo(orderid).andShopIdEqualTo(shopInfo.getShopAndUserInfo().getShopId());
        }
        else
        {
            example.createCriteria().andOrderIdEqualTo(fOrderDetailInfo.getOrderId()).andShopIdEqualTo(shopInfo.getShopAndUserInfo().getShopId());
        }

        int count = this.orderDetailInfoGeneratorQueryService.countByExample(example);
        int pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        example.setPage(pageIndex, pageSize);

        List<OrderDetailInfo> detailInfos = this.orderDetailInfoGeneratorQueryService.selectByExample(example);
        List<FOrderDetailAndPicInfo> orderDetailInfos = new ArrayList<FOrderDetailAndPicInfo>();
        FOrderDetailAndPicInfo info = new FOrderDetailAndPicInfo();

        OrderPicExample orderPicExample = new OrderPicExample();
        if (StringUtils.hasText(orderid))
        {
            orderPicExample.createCriteria().andOrderIdEqualTo(orderid).andIsDelEqualTo("N");
        }
        else
        {
            orderPicExample.createCriteria().andOrderIdEqualTo(fOrderDetailInfo.getOrderId()).andIsDelEqualTo("N");

        }
        List<OrderPic> orderPics = this.orderPicGeneratorQueryService.selectByExample(orderPicExample);

        for (OrderDetailInfo orderDetailInfo : detailInfos)
        {
            FOrderDetailInfo detailInfo = new FOrderDetailInfo();
            BeanUtils.copyProperties(orderDetailInfo, detailInfo);
            info.setDetailInfo(detailInfo);
            if (info.getPic() == null && orderPics.size() > 0)
            {
                FOrderPic fOrderPic = new FOrderPic();
                BeanUtils.copyProperties(orderPics.get(0), fOrderPic);
                info.setPic(fOrderPic);
            }

            orderDetailInfos.add(info);
        }

        PageModel<FOrderDetailAndPicInfo> pm = new PageModel<FOrderDetailAndPicInfo>();
        pm.setCount(count);
        pm.setPageIndex(pageIndex);
        pm.setPageSize(pageSize);
        pm.setResult(orderDetailInfos);
        return GMSUtil.toTransData(true, null, pm);
    }

    @Override
    public TransData<FOrderPic> getBillPicInfo(HttpServletRequest request) throws Exception
    {
        FOrderPic fOrderPic = ServletUtils.objectMethod(FOrderPic.class, request);
        OrderPic orderPic = this.orderPicGeneratorQueryService.selectUnDelByPrimaryKey(fOrderPic.getOrderId());
        FOrderPic pic = new FOrderPic();
        BeanUtils.copyProperties(orderPic, pic);
        return GMSUtil.toTransData(true, null, pic);
    }
}
