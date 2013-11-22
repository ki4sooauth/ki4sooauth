package com.gooagoo.gas.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.transaction.invoice.InvoiceCoreService;
import com.gooagoo.api.business.query.user.invoice.InvoiceQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.bill.BillInvoiceLog;
import com.gooagoo.entity.generator.user.ReceiptInfo;
import com.gooagoo.gas.api.service.InvoiceLinkGasService;
import com.gooagoo.gas.entity.gasm01.transform.GetInvoiceTitlesRoot;
import com.gooagoo.gas.entity.gasm01.transform.Invoicetitles;
import com.google.gson.Gson;

@Service
public class InvoiceLinkGasServiceImpl implements InvoiceLinkGasService
{
    @Autowired
    private InvoiceQueryService invoiceQueryService;
    @Autowired
    private InvoiceCoreService invoiceCoreService;

    @Override
    public GetInvoiceTitlesRoot queryInvoiceTitles(String shopEntityId, String userId) throws Exception
    {
        GooagooLog.info("queryInvoiceTitles-->入参:userId=" + userId + ",shopEntityId=" + shopEntityId);
        //1.获取发票抬头信息
        List<ReceiptInfo> receiptInfoList = this.invoiceQueryService.findInvoice(null, userId);
        GooagooLog.debug("查询会员发票抬头常用信息" + new Gson().toJson(receiptInfoList));

        List<Invoicetitles> invoicetitlesList = null;
        if (CollectionUtils.isNotEmpty(receiptInfoList))
        {
            //2.封装发票抬头信息
            invoicetitlesList = new ArrayList<Invoicetitles>();
            for (ReceiptInfo temp : receiptInfoList)
            {
                //常用发票抬头信息列表查询发票抬头
                Invoicetitles invoicetitles = new Invoicetitles();
                invoicetitles.setTitle(temp.getCompanyName());
                invoicetitlesList.add(invoicetitles);
            }
        }
        //3.组装返回参数
        GetInvoiceTitlesRoot root = new GetInvoiceTitlesRoot();
        root.setInvoicetitles(invoicetitlesList);
        return root;
    }

    @Override
    public boolean submitOpenInvoiceApply(String shopId, String shopEntityId, String userId, String title, String invoicedType, String orderid) throws Exception
    {
        GooagooLog.info("submitOpenInvoiceApply-->入参:userId=" + userId + ",shopEntityId=" + shopEntityId + " ,invoicedType" + invoicedType);
        //组装返回对象
        BillInvoiceLog billInvoiceLog = new BillInvoiceLog();
        billInvoiceLog.setOrderId(orderid);
        billInvoiceLog.setShopId(shopId);
        billInvoiceLog.setShopEntityId(shopEntityId);
        billInvoiceLog.setUserId(userId);
        billInvoiceLog.setInvoicedTile(title);
        billInvoiceLog.setInvoicedType(invoicedType);
        boolean result = this.invoiceCoreService.AddInvoice(billInvoiceLog);
        return result;
    }
}
