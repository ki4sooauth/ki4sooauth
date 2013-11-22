package com.gooagoo.core.business.user.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.user.app.AppSerialNumberCoreService;
import com.gooagoo.api.generator.core.user.ProductSerialNumberGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.user.ProductSerialNumber;

@Service
public class AppSerialNumberCoreServiceImpl implements AppSerialNumberCoreService
{

    @Autowired
    ProductSerialNumberGeneratorCoreService productSerialNumberGeneratorCoreService;

    @Override
    public String appSerialNumber(ProductSerialNumber productSerialNumber) throws Exception
    {
        String gooagooId = UUID.getUUID();
        productSerialNumber.setGooagooId(gooagooId);
        if (!this.productSerialNumberGeneratorCoreService.insertSelective(productSerialNumber))
        {
            GooagooLog.info("手机APP序列号分配：添加产品序列号信息（" + productSerialNumber.toString() + "）失败");
            return null;
        }
        return gooagooId;
    }

}
