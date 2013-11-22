package com.gooagoo.api.business.core.user.app;

import com.gooagoo.entity.generator.user.ProductSerialNumber;

public interface AppSerialNumberCoreService
{
    /**
     * 手机APP序列号分配
     * @param productSerialNumber
     * @return true/false
     */
    public String appSerialNumber(ProductSerialNumber productSerialNumber) throws Exception;

}
