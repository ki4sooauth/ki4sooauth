package com.gooagoo.igms.apply.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;
import com.gooagoo.view.gms.apply.FOrderDetailAndPicInfo;
import com.gooagoo.view.gms.apply.FOrderInfo;
import com.gooagoo.view.gms.apply.FOrderPic;
import com.gooagoo.view.gms.common.PageModel;

public interface BillInfoService
{
    /**
     * 分页查询订单信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<FOrderInfo>> pageBillInfo(HttpServletRequest request) throws Exception;

    /**
     * 查询订单详细信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<FOrderInfo> getBillInfo(HttpServletRequest request) throws Exception;

    /**
     * 订单商品详细信息
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<PageModel<FOrderDetailAndPicInfo>> pageBillDetailInfo(HttpServletRequest request) throws Exception;

    /**
     * 获取订单图片详情
     * @param request
     * @return
     * @throws Exception
     */
    public TransData<FOrderPic> getBillPicInfo(HttpServletRequest request) throws Exception;
}
