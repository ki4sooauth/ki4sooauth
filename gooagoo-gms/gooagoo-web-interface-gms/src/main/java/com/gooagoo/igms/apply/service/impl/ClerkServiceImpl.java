package com.gooagoo.igms.apply.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.query.log.LogQueryService;
import com.gooagoo.api.generator.query.bill.BillInvoiceLogGeneratorQueryService;
import com.gooagoo.api.generator.query.bill.BillPayApplicationGeneratorQueryService;
import com.gooagoo.api.generator.query.bill.OrderInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.member.MemberOfCardGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.entity.business.log.ShopLog;
import com.gooagoo.entity.business.log.ShopLogExample;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.entity.generator.bill.BillInvoiceLog;
import com.gooagoo.entity.generator.bill.BillInvoiceLogExample;
import com.gooagoo.entity.generator.bill.BillPayApplication;
import com.gooagoo.entity.generator.bill.BillPayApplicationExample;
import com.gooagoo.entity.generator.bill.OrderInfo;
import com.gooagoo.entity.generator.bill.OrderInfoExample;
import com.gooagoo.entity.generator.bill.OrderInfoExample.Criteria;
import com.gooagoo.entity.generator.member.MemberOfCard;
import com.gooagoo.entity.generator.member.MemberOfCardExample;
import com.gooagoo.igms.apply.service.ClerkService;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.shopinfo.service.ShopLoginService;
import com.gooagoo.view.gms.apply.FBillInvoiceLog;
import com.gooagoo.view.gms.apply.FBillPayApplication;
import com.gooagoo.view.gms.apply.FOrderInfo;
import com.gooagoo.view.gms.apply.FShopLog;
import com.gooagoo.view.gms.common.PageModel;

@Service(value = "clerkService")
public class ClerkServiceImpl implements ClerkService
{
    @Autowired
    private OrderInfoGeneratorQueryService orderInfoGeneratorQueryService;
    @Autowired
    private BillInvoiceLogGeneratorQueryService billInvoiceLogGeneratorQueryService;
    @Autowired
    private BillPayApplicationGeneratorQueryService billPayApplicationGeneratorQueryService;
    @Autowired
    private LogQueryService logQueryService;
    @Autowired
    private MemberOfCardGeneratorQueryService memberOfCardGeneratorQueryService;
    @Autowired
    private ShopLoginService shopLoginService;

    @Override
    public TransData<PageModel<FShopLog>> pageClerkCreditCard(HttpServletRequest request) throws Exception
    {
        int pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        ShopLogExample shopLogExample = new ShopLogExample();
        shopLogExample.setShopId(shopId);
        shopLogExample.setRemoteCode("gasc06");//刷卡  接口gasc06:用户通过店员助理刷卡
        //查询商家日志  objectCode=卡号
        List<String> list = new ArrayList<String>();//卡号
        com.gooagoo.entity.common.PageModel<ShopLog> pageModel = this.logQueryService.selectShopLog(shopLogExample, pageIndex, pageSize);
        for (ShopLog t : pageModel.getResult())
        {
            list.add(t.getObjectCode());
        }
        MemberOfCardExample example = new MemberOfCardExample();
        com.gooagoo.entity.generator.member.MemberOfCardExample.Criteria criteria = example.createCriteria();
        criteria.andShopIdEqualTo(shopId).andIsDelEqualTo("N");
        criteria.andScardnoIn(list);
        List<MemberOfCard> memberOfCards = this.memberOfCardGeneratorQueryService.selectByExample(example);
        Map<String, String> map = new HashMap<String, String>();
        for (MemberOfCard tCard : memberOfCards)
        {
            map.put(tCard.getScardno(), tCard.getPhyCardNo());
        }
        List<FShopLog> logs = new ArrayList<FShopLog>();
        for (ShopLog tlog : pageModel.getResult())
        {
            FShopLog log = new FShopLog();
            BeanUtils.copyProperties(tlog, log);
            if (map.containsKey(tlog.getObjectCode()))
            {
                log.setObjectCode(map.get(tlog.getObjectCode()));
            }
            logs.add(log);

        }
        PageModel<FShopLog> pm = new PageModel<FShopLog>();
        pm.setCount(pageModel.getCount());
        pm.setPageIndex(pageModel.getPageIndex());
        pm.setPageSize(pageModel.getPageSize());

        pm.setResult(logs);
        return GMSUtil.toTransData(true, null, pm);
    }

    @Override
    public TransData<PageModel<FOrderInfo>> pageClerkOrderInfo(HttpServletRequest request) throws Exception
    {
        //查询商家日志信息入参
        int pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        String selectName = ServletRequestUtils.getStringParameter(request, "selectName", "");//实体店ID
        String inputName = ServletRequestUtils.getStringParameter(request, "inputName", "");//会员卡号
        ShopLogExample shopLogExample = new ShopLogExample();
        shopLogExample.setShopId(shopId);
        ShopLoginInfo shopInfo = this.shopLoginService.getShopLoginInfo(request);
        if (shopInfo.getShopAndUserInfo().getShopTypeLeaf() == 1)
        {
            shopLogExample.setRemoteCode("gasl03");//所调用的接口编码
        }
        else
        {
            shopLogExample.setRemoteCode("gasc05");//所调用的接口编码
        }
        //查询商家日志
        com.gooagoo.entity.common.PageModel<ShopLog> pageModel = this.logQueryService.selectShopLog(shopLogExample, pageIndex, pageSize);
        //找到操作对象编号，对应oederinfo 表中orderId
        List<String> list = new ArrayList<String>();
        for (ShopLog t : pageModel.getResult())
        {
            list.add(t.getObjectCode());
        }
        //根据日志表中objectCode<组装成List<String>>查询订单表中订单信息
        OrderInfoExample example = new OrderInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andShopIdEqualTo(shopId).andOrderIdIn(list).andIsDelEqualTo("N");
        if (StringUtils.hasText(selectName))
        {
            criteria.andShopEntityIdEqualTo(selectName);
        }
        if (StringUtils.hasText(inputName))
        {
            criteria.andScardNoLike(inputName);
        }
        criteria.andBillTypeNotEqualTo("3");
        List<OrderInfo> orderInfos = this.orderInfoGeneratorQueryService.selectByExample(example);
        List<FOrderInfo> fOrderInfos = new ArrayList<FOrderInfo>();
        for (OrderInfo orderInfo : orderInfos)
        {
            FOrderInfo info = new FOrderInfo();
            BeanUtils.copyProperties(orderInfo, info);
            info.setBillTypeName(orderInfo.getBillType());
            fOrderInfos.add(info);
        }
        PageModel<FOrderInfo> pm = new PageModel<FOrderInfo>();
        pm.setCount(fOrderInfos.size());
        pm.setPageIndex(pageIndex);
        pm.setPageSize(pageSize);
        pm.setResult(fOrderInfos);
        return GMSUtil.toTransData(true, null, pm);
    }

    @Override
    public TransData<PageModel<FBillInvoiceLog>> pageClerkInvoiceLog(HttpServletRequest request) throws Exception
    {
        //查询商家日志信息入参
        int pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);
        String selectName = ServletRequestUtils.getStringParameter(request, "selectName", "");//实体店ID
        String inputName = ServletRequestUtils.getStringParameter(request, "inputName", "");//会员卡号
        ShopLogExample shopLogExample = new ShopLogExample();
        shopLogExample.setShopId(shopId);
        shopLogExample.setRemoteCode("gasm02");//所调用的接口编码
        //查询商家日志
        com.gooagoo.entity.common.PageModel<ShopLog> pageModel = this.logQueryService.selectShopLog(shopLogExample, pageIndex, pageSize);
        //找到操作对象编号，对应oederinfo 表中orderId
        List<String> list = new ArrayList<String>();
        for (ShopLog t : pageModel.getResult())
        {
            list.add(t.getObjectCode());
        }
        //根据日志表中objectCode<组装成List<String>>查询
        BillInvoiceLogExample example = new BillInvoiceLogExample();
        com.gooagoo.entity.generator.bill.BillInvoiceLogExample.Criteria criteria = example.createCriteria();
        criteria.andShopIdEqualTo(shopId).andIsDelEqualTo("N");
        criteria.andOrderIdIn(list);
        if (StringUtils.hasText(selectName))
        {
            criteria.andInvoicedTypeEqualTo(selectName);
        }
        if (StringUtils.hasText(inputName))
        {
            criteria.andInvoicedTileEqualTo(inputName);
        }
        List<BillInvoiceLog> invoiceLogs = this.billInvoiceLogGeneratorQueryService.selectByExample(example);
        List<FBillInvoiceLog> lists = new ArrayList<FBillInvoiceLog>();
        for (BillInvoiceLog t : invoiceLogs)
        {
            FBillInvoiceLog info = new FBillInvoiceLog();
            BeanUtils.copyProperties(t, info);
            lists.add(info);
        }
        PageModel<FBillInvoiceLog> pm = new PageModel<FBillInvoiceLog>();
        pm.setCount(lists.size());
        pm.setPageIndex(pageIndex);
        pm.setPageSize(pageSize);
        pm.setResult(lists);
        return GMSUtil.toTransData(true, null, pm);
    }

    @Override
    public TransData<PageModel<FBillPayApplication>> pageClerkPayAoolication(HttpServletRequest request) throws Exception
    {
        //查询商家日志信息入参
        int pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);

        ShopLogExample shopLogExample = new ShopLogExample();
        shopLogExample.setShopId(shopId);
        shopLogExample.setRemoteCode("gasl05");//所调用的接口编码
        //查询商家日志
        com.gooagoo.entity.common.PageModel<ShopLog> pageModel = this.logQueryService.selectShopLog(shopLogExample, pageIndex, pageSize);
        //找到操作对象编号，对应oederinfo 表中orderId
        List<String> list = new ArrayList<String>();
        for (ShopLog t : pageModel.getResult())
        {
            list.add(t.getObjectCode());
        }
        //根据日志表中objectCode<组装成List<String>>查询
        BillPayApplicationExample example = new BillPayApplicationExample();
        example.createCriteria().andShopIdEqualTo(shopId).andIsDealEqualTo("N");
        example.createCriteria().andOrderIdIn(list);
        List<BillPayApplication> billPayApplications = this.billPayApplicationGeneratorQueryService.selectByExample(example);
        List<FBillPayApplication> lists = new ArrayList<FBillPayApplication>();
        for (BillPayApplication t : billPayApplications)
        {
            FBillPayApplication info = new FBillPayApplication();
            BeanUtils.copyProperties(t, info);
            lists.add(info);
        }
        PageModel<FBillPayApplication> pm = new PageModel<FBillPayApplication>();
        pm.setCount(lists.size());
        pm.setPageIndex(pageIndex);
        pm.setPageSize(pageSize);
        pm.setResult(lists);
        return GMSUtil.toTransData(true, null, pm);
    }

}
