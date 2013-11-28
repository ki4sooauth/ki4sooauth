package com.gooagoo.mobile.api.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.user.invoice.InvoiceHeadCoreService;
import com.gooagoo.api.business.query.user.invoice.InvoiceQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.user.ReceiptInfo;
import com.gooagoo.exception.GooagooException;
import com.gooagoo.mobile.api.CommonMobileService;
import com.gooagoo.mobile.api.ReceiptInfoMobileService;
import com.gooagoo.mobile.entity.mobp01.transform.GetReceiptInfoRoot;
import com.gooagoo.mobile.entity.mobp01.transform.Receiptinfo;
import com.google.gson.Gson;

@Service
public class ReceiptInfoMobileServiceImpl implements ReceiptInfoMobileService
{
    @Autowired
    private InvoiceHeadCoreService invoiceHeadCoreService;
    @Autowired
    private CommonMobileService commonMobileService;
    @Autowired
    private InvoiceQueryService invoiceQueryService;

    @Override
    public GetReceiptInfoRoot getReceiptInfo(String userId, String sessionId) throws Exception
    {
        GooagooLog.info("getReceiptInfo,mobo01:添加用户发票抬头信息入参信息为-->:userId=" + userId + ",sessionId=" + sessionId);
        //校验登陆状态
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        List<ReceiptInfo> infos = this.invoiceQueryService.findInvoice(null, userId);
        List<Receiptinfo> receiptinfoList = null;
        if (CollectionUtils.isNotEmpty(infos))
        {
            receiptinfoList = new ArrayList<Receiptinfo>();
            for (ReceiptInfo t : infos)
            {
                Receiptinfo receiptinfo = new Receiptinfo();
                receiptinfo.setCompanyname(t.getCompanyName());
                receiptinfo.setIsdefault(t.getIsDefault());
                receiptinfo.setReceiptid(t.getReceiptId());
                receiptinfoList.add(receiptinfo);
            }
        }
        GetReceiptInfoRoot root = new GetReceiptInfoRoot();
        root.setReceiptinfo(receiptinfoList);
        return root;
    }

    @Override
    public void editReceiptInfo(String userId, String sessionId, String companyName, String isDefault) throws Exception
    {
        GooagooLog.info("editReceiptInfo,mobo02:编辑用户发票抬头信息入参信息为-->:userId=" + userId + ",sessionId=" + sessionId + ",companyName=" + companyName + ",isDefault=" + isDefault);
        //校验登陆状态
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        ReceiptInfo receiptInfo = new ReceiptInfo();
        receiptInfo.setUserId(userId);
        receiptInfo.setCompanyName(companyName);
        receiptInfo.setIsDefault(isDefault);
        if (!this.invoiceHeadCoreService.updateInvoiceHead(receiptInfo))
        {
            GooagooLog.info("编辑用户发票抬头信息失败:" + new Gson().toJson(receiptInfo));
            throw new GooagooException("编辑用户发票抬头信息失败");
        }

    }

    @Override
    public void delReceiptInfo(String userId, String sessionId, String receiptInfoId) throws Exception
    {
        GooagooLog.info("delReceiptInfo,mobo03:删除用户发票抬头信息入参信息为-->:userId=" + userId + ",sessionId=" + sessionId + ",receiptInfoId=" + receiptInfoId);
        //校验登陆状态
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        if (!this.invoiceHeadCoreService.deleteInvoiceHead(receiptInfoId))
        {
            GooagooLog.info("删除用户发票抬头信息失败:" + receiptInfoId);
            throw new GooagooException("删除用户发票抬头信息失败");
        }
    }

    @Override
    public void addReceiptInfo(String userId, String sessionId, String companyName, String isDefault) throws Exception
    {
        GooagooLog.info("addReceiptInfo,mobo04:添加用户发票抬头信息入参信息为-->:userId=" + userId + ",sessionId=" + sessionId + ",companyName=" + companyName + ",isDefault=" + isDefault);
        //校验登陆状态
        this.commonMobileService.checkLoginStatus(userId, sessionId);
        ReceiptInfo receiptInfo = new ReceiptInfo();
        receiptInfo.setUserId(userId);
        receiptInfo.setCompanyName(companyName);
        receiptInfo.setIsDefault(isDefault);
        if (!this.invoiceHeadCoreService.addInvoiceHead(receiptInfo))
        {
            GooagooLog.info("添加用户发票抬头信息失败:" + new Gson().toJson(receiptInfo));
            throw new GooagooException("添加用户发票抬头信息失败");
        }
    }

}
