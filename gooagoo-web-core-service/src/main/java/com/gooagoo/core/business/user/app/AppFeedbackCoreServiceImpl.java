package com.gooagoo.core.business.user.app;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.user.app.AppFeedbackCoreService;
import com.gooagoo.api.generator.core.behave.UserFeedbackGeneratorCoreService;
import com.gooagoo.api.generator.core.user.ProductSerialNumberGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.UUID;
import com.gooagoo.entity.generator.behave.UserFeedback;
import com.gooagoo.entity.generator.user.ProductSerialNumber;
import com.gooagoo.entity.generator.user.ProductSerialNumberExample;

@Service
public class AppFeedbackCoreServiceImpl implements AppFeedbackCoreService
{

    @Autowired
    UserFeedbackGeneratorCoreService userFeedbackGeneratorCoreService;
    @Autowired
    ProductSerialNumberGeneratorCoreService productSerialNumberGeneratorCoreService;

    @Override
    public boolean appFeedback(UserFeedback userFeedback) throws Exception
    {
        ProductSerialNumberExample productSerialNumberExample = new ProductSerialNumberExample();
        productSerialNumberExample.createCriteria().andMacAddressEqualTo(userFeedback.getMacAddress());
        List<ProductSerialNumber> productSerialNumberList = this.productSerialNumberGeneratorCoreService.selectByExample(productSerialNumberExample);
        if (CollectionUtils.isEmpty(productSerialNumberList))
        {
            GooagooLog.info("通过mac地址获取gooagooid失败[macAddress=" + userFeedback.getMacAddress() + "]");
            return false;
        }
        userFeedback.setFeedbackId(UUID.getUUID());
        userFeedback.setGooagooId(productSerialNumberList.get(0).getGooagooId());
        userFeedback.setCreateTime(new Date());
        userFeedback.setIsDel("N");
        if (!this.userFeedbackGeneratorCoreService.insertSelective(userFeedback))
        {
            GooagooLog.info("手机APP产品意见反馈：添加用户反馈信息（" + userFeedback.toString() + "）失败");
            return false;
        }
        return true;
    }
}
