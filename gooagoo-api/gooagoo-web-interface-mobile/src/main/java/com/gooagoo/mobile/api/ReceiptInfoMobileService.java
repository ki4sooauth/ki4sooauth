package com.gooagoo.mobile.api;

import com.gooagoo.mobile.entity.mobp01.transform.GetReceiptInfoRoot;

/**
 * 用户发票抬头信息管理
 */
public interface ReceiptInfoMobileService
{

    /**
     * mobo01:添加用户发票抬头信息
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @return
     * @throws Exception
     */
    public GetReceiptInfoRoot getReceiptInfo(String userId, String sessionId) throws Exception;

    /**
     * mobo02:编辑用户发票抬头信息
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param companyName 公司名称
     * @param isDefault 是否默认选项，Y-是，N-否
     * @throws Exception
     */
    public void editReceiptInfo(String userId, String sessionId, String companyName, String isDefault) throws Exception;

    /**
     * mobo03:删除用户发票抬头信息
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param receiptInfoId 用户发票抬头信息编号，UUID
     * @return
     * @throws Exception
     */
    public void delReceiptInfo(String userId, String sessionId, String receiptInfoId) throws Exception;

    /**
     * mobo04:添加用户发票抬头信息
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param companyName 公司名称
     * @param isDefault 是否默认选项，Y-是，N-否
     * @return
     * @throws Exception
     */
    public void addReceiptInfo(String userId, String sessionId, String companyName, String isDefault) throws Exception;

}
