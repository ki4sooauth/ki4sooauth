package com.gooagoo.api.business.core.user.deliveryaddress;

import com.gooagoo.entity.generator.user.ConsigneeInfo;
import com.gooagoo.exception.common.FormatErrorException;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;

public interface DeliveryAddressCoreService

{

    /**
     * 创建收货地址
     * @param consigneeInfo 
     * @return true/false
     * @throws FormatErrorException
     * @throws OperateFailException
     * @throws NullException
     */
    public boolean addDeliveryAddress(ConsigneeInfo consigneeInfo) throws Exception;

    /**
     * 删除收货地址
     * @param consigneeId
     * @return true/false
     * @throws NullException
     * @throws OperateFailException
     */
    public boolean deleteDeliveryAddress(String consigneeId) throws Exception;

    /**
     * 编辑收货地址
     * <br>
     * 删除要编辑的收货地址、新增一条新的收货地址
     * @param consigneeInfo
     * @return 
     * @throws OperateFailException
     * @throws NullException
     * @throws FormatErrorException
     */
    public ConsigneeInfo updateDeliveryAddress(ConsigneeInfo consigneeInfo) throws Exception;

    /**
     * 修改默认选项
     * @param userId
     * @param consigneeId
     * @return 
     */
    public boolean setDeliveryAddress(String userId, String consigneeId) throws Exception;

}
