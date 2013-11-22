package com.gooagoo.mobile.api;

import com.gooagoo.entity.para.Parameter;
import com.gooagoo.mobile.entity.mobo01.transform.GetConsigneeInfoRoot;

/**
 * 收货人地址信息管理
 */
public interface ConsigneeInfoMobileService
{
    /**
     * mobo01:获取收货人地址信息
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @return
     * @throws Exception
     */
    public GetConsigneeInfoRoot getConsigneeInfo(String userId, String sessionId) throws Exception;

    /**
     * mobo02:编辑收货人地址信息
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param parameter 入参集合,(包括收货人姓名、省、市、县、详细地址、手机号码、联系电话、默认选项等)
     * @return
     * @throws Exception
     */
    public void editConsigneeInfo(String userId, String sessionId, Parameter parameter) throws Exception;

    /**
     * mobo03:删除收货人地址信息
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param consigneeId 收货人信息编号，UUID
     * @return
     * @throws Exception
     */
    public void delConsigneeInfo(String userId, String sessionId, String consigneeId) throws Exception;

    /**
     * mobo04:添加收货人地址信息
     * @param userId 用户编号
     * @param sessionId 用户sessionId
     * @param parameter 入参集合,(包括收货人姓名、省、市、县、详细地址、手机号码、联系电话、默认选项等)
     * @return
     * @throws Exception
     */
    public void addConsigneeInfo(String userId, String sessionId, Parameter parameter) throws Exception;

}
