package com.gooagoo.trans.api.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.generator.query.bill.OrderInfoGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.entity.generator.bill.OrderInfo;
import com.gooagoo.entity.generator.bill.OrderInfoExample;
import com.gooagoo.exception.MessageException;
import com.gooagoo.trans.api.OrderPayTransactionTransService;
import com.gooagoo.trans.common.HttpClientUtils;
import com.gooagoo.trans.common.MessageConst;
import com.gooagoo.trans.common.UrlConst;
import com.gooagoo.trans.entity.gtse01.transform.OrderTransactionStatusRoot;

@Service
public class OrderPayTransactionTransServiceImpl implements OrderPayTransactionTransService
{
    @Autowired
    private OrderInfoGeneratorQueryService orderInfoGeneratorQueryService;

    @Override
    public OrderTransactionStatusRoot getOrderTransactionStatusRoot(String mac, String billNo) throws Exception
    {

        //1.根據mac地址和第三方訂單號查詢gooagoo訂單號

        OrderInfoExample orderInfoExample = new OrderInfoExample();
        //TODO 临时写成andThirdOrderIdLike("%" + billNo + "%")，把andBillTypeEqualTo("3")去掉
        orderInfoExample.createCriteria().andMacEqualTo(mac).andThirdOrderIdLike("%" + billNo + "%").andIsDelEqualTo("N");
        orderInfoExample.setOrderByClause("c_time_stamp desc");
        List<OrderInfo> orderInfoList = this.orderInfoGeneratorQueryService.selectByExample(orderInfoExample);

        if (CollectionUtils.isEmpty(orderInfoList))
        {
            GooagooLog.warn("订单号不存在【mac=" + mac + ",billNo=" + billNo + "的账单未查询到】");
            throw new MessageException(MessageConst.TRANS_BILL_BILL_IS_NOT_EXIST);
        }
        //2.訂單號查詢gooagoo訂單交易狀態信息
        //1).組裝調用拍了付接口的入參
        Map<String, String> json = new HashMap<String, String>();
        json.put("PartnerId", "131101104401");
        json.put("MerId", "104440148990039");
        json.put("OrderId", orderInfoList.get(0).getOrderId());
        List<NameValuePair> paramlist = new ArrayList<NameValuePair>();//传入参数
        paramlist.add(new BasicNameValuePair("json", JsonUtils.toJson(json)));
        //2).調用拍了付查询接口
        String result = HttpClientUtils.HttpPost(UrlConst.ORDER_TRANSACTIONSTATUS_URL, paramlist);
        GooagooLog.info("拍了付返回结果:" + result);
        OrderTransactionStatusRoot root = new OrderTransactionStatusRoot();
        if (!StringUtils.hasText(result))
        {
            GooagooLog.warn("第三方(拍了付)订单支付状态查询接口异常");
            throw new MessageException(MessageConst.TRANS_BILL_INTERNET_ERROR);
        }
        else
        {
            Map<String, String> resultMap = JsonUtils.json2Map(result);
            root.setTransactionstatus(resultMap.get("RespCode"));
        }
        return root;
    }
}
