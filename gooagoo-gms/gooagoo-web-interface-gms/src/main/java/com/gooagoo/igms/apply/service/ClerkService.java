package com.gooagoo.igms.apply.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.apply.FBillInvoiceLog;
import com.gooagoo.view.gms.apply.FBillPayApplication;
import com.gooagoo.view.gms.apply.FOrderInfo;
import com.gooagoo.view.gms.apply.FShopLog;
import com.gooagoo.view.gms.common.PageModel;

public interface ClerkService
{
    /**
     * 刷卡信息列表
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public TransData<PageModel<FShopLog>> pageClerkCreditCard(HttpServletRequest request) throws Exception;

    /**
     * 订单信息列表
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public TransData<PageModel<FOrderInfo>> pageClerkOrderInfo(HttpServletRequest request) throws Exception;

    /**
     * 开发票信息列表
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public TransData<PageModel<FBillInvoiceLog>> pageClerkInvoiceLog(HttpServletRequest request) throws Exception;

    /**
     * 申请结账信息列表
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public TransData<PageModel<FBillPayApplication>> pageClerkPayAoolication(HttpServletRequest request) throws Exception;
}
