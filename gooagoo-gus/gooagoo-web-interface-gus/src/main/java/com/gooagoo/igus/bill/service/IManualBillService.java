package com.gooagoo.igus.bill.service;

import javax.servlet.http.HttpServletRequest;

import com.gooagoo.common.entity.TransData;

public interface IManualBillService
{

    /**
     * 查询手工账单列表
     * @param request
     * @return
     */
    public TransData<Object> getManualBillList(HttpServletRequest request);


    /**
     * 添加手工账单
     * @param request
     * @return
     */
    public TransData<Object> addManualBill(HttpServletRequest request);

    /**
     * 编辑手工账单
     * @param request
     * @return
     */
    public TransData<Object> updateManualBill(HttpServletRequest request);

    /**
     * 删除手工账单
     * @param request
     * @return
     */
    public TransData<Object> deleteManualBill(HttpServletRequest request);

}
