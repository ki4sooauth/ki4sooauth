package com.gooagoo.mobile.api.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.generator.query.bill.OrderInfoGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.entity.generator.bill.OrderInfo;
import com.gooagoo.exception.MessageException;
import com.gooagoo.mobile.api.CommonMobileService;
import com.gooagoo.mobile.api.OrderTransactionMobileService;
import com.gooagoo.mobile.common.HttpClientUtils;
import com.gooagoo.mobile.common.MessageConst;
import com.gooagoo.mobile.common.UrlConst;
import com.gooagoo.mobile.common.entity.PlfPayEntity;
import com.gooagoo.mobile.entity.mobm01.transform.MobileOrderPayRoot;
import com.gooagoo.mobile.entity.mobm02.transform.TransactionStatusRoot;

@Service
public class OrderTransactionMobileServiceImpl implements OrderTransactionMobileService
{
    @Autowired
    private CommonMobileService commonMobileService;
    @Autowired
    private OrderInfoGeneratorQueryService orderInfoGeneratorQueryService;

    @Override
    public MobileOrderPayRoot mobileOrderPay(String userId, String sessionId, String orderId) throws Exception
    {
        //1.校验登录
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //2.收到請求查詢訂單相關信息
        OrderInfo orderInfo = this.orderInfoGeneratorQueryService.selectUnDelByPrimaryKey(orderId);
        if (orderInfo == null)
        {
            GooagooLog.warn("订单号不存在【orderId=" + orderId + "的订单未查询到】");
            throw new MessageException(MessageConst.MOBILE_BILL_BILLID_IS_NOT_EXIST);
        }
        if ("3".equals(orderInfo.getBillType()))
        {
            GooagooLog.warn("此订单已结账【orderId=" + orderId + "的订单已经结完帐了】");
            throw new MessageException(MessageConst.MOBILE_BILL_ALREADY_PAID);
        }
        //3.組裝調用拍了付接口的入參
        PlfPayEntity plfPayEntity = new PlfPayEntity();
        plfPayEntity.setPartnerId("131101104401");
        plfPayEntity.setMerId("104440148990039");
        plfPayEntity.setOrderId(orderId);
        Double amount = orderInfo.getPayPrice() * 100;
        plfPayEntity.setAmount(Integer.valueOf(amount.intValue()));
        plfPayEntity.setBackEndUrl(UrlConst.BACK_END_URL);
        plfPayEntity.setOrderDescription("");
        plfPayEntity.setOrderTime(TimeUtils.convertDateToString(new Date(), TimeUtils.FORMAT6));
        List<NameValuePair> paramlist = new ArrayList<NameValuePair>();//传入参数
        paramlist.add(new BasicNameValuePair("json", JsonUtils.toJson(plfPayEntity)));
        //4.調用拍了付支付接口
        String result = HttpClientUtils.HttpPost(UrlConst.ORDER_PAY_URL, paramlist);
        GooagooLog.info("拍了付" + "订单" + orderId + "请求参数" + "返回结果:" + result);
        MobileOrderPayRoot root = new MobileOrderPayRoot();
        if (!StringUtils.hasText(result))
        {
            GooagooLog.warn("第三方(拍了付)接口支付异常【orderId=" + orderId + "的订单已经结完帐了】");
            throw new MessageException(MessageConst.MOBILE_BILL_THIRD_PAID_ERROR);
        }
        else
        {
            Map<String, String> resultMap = JsonUtils.json2Map(result);
            root.setMsgcode(resultMap.get("RespCode"));
            root.setMsg(resultMap.get("RespMsg"));
            root.setTransactionserialnum(resultMap.get("tn"));
        }

        return root;
    }

    @Override
    public TransactionStatusRoot getTransactionStatus(String userId, String sessionId, String orderId) throws Exception
    {
        //1.校验登录
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        //2.收到請求查詢訂單相關信息
        OrderInfo orderInfo = this.orderInfoGeneratorQueryService.selectUnDelByPrimaryKey(orderId);
        if (orderInfo == null)
        {
            GooagooLog.warn("订单号不存在【orderId=" + orderId + "的订单未查询到】");
            throw new MessageException(MessageConst.MOBILE_BILL_BILLID_IS_NOT_EXIST);
        }
        TransactionStatusRoot root = new TransactionStatusRoot();
        if ("3".equals(orderInfo.getBillType()))
        {
            root.setMsgcode("0000");
            root.setMsg("支付成功");
            return root;
        }
        //3.組裝調用拍了付接口的入參
        Map<String, String> json = new HashMap<String, String>();
        json.put("PartnerId", "131101104401");
        json.put("MerId", "104440148990039");
        json.put("OrderId", orderId);
        List<NameValuePair> paramlist = new ArrayList<NameValuePair>();//传入参数
        paramlist.add(new BasicNameValuePair("json", JsonUtils.toJson(json)));
        //4.調用拍了付查询接口
        String result = HttpClientUtils.HttpPost(UrlConst.ORDER_TRANSACTIONSTATUS_URL, paramlist);
        GooagooLog.info("拍了付返回结果:" + result);

        if (!StringUtils.hasText(result))
        {
            GooagooLog.warn("第三方(拍了付)订单支付状态查询接口异常");
            throw new MessageException(MessageConst.MOBILE_BILL_INTERNET_ERROR);
        }
        else
        {
            Map<String, String> resultMap = JsonUtils.json2Map(result);
            root.setMsgcode(resultMap.get("RespCode"));
            root.setMsg(resultMap.get("RespMsg"));
        }
        return root;
    }

}
