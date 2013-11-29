package com.gooagoo.core.business.system.sys.dictionary;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.system.sys.dictionary.MerchantToolsDicCoreService;
import com.gooagoo.api.generator.core.base.ShopToolInfoGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.base.ShopToolInfo;
import com.gooagoo.exception.common.NullException;
import com.gooagoo.exception.common.OperateFailException;
import com.google.gson.Gson;

@Service
public class MerchantToolsDicCoreServiceImpl implements MerchantToolsDicCoreService

{

    @Autowired
    private ShopToolInfoGeneratorCoreService shopToolInfoGeneratorCoreService;

    @Override
    public boolean addMerchantToolsDic(ShopToolInfo shopToolInfo) throws Exception
    {
        shopToolInfo.setIsDel("N");
        return this.shopToolInfoGeneratorCoreService.insertSelective(shopToolInfo);
    }

    @Override
    public boolean updateMerchantToolsDic(ShopToolInfo shopToolInfo) throws Exception
    {
        return this.shopToolInfoGeneratorCoreService.updateByPrimaryKeySelective(shopToolInfo);
    }

    @Override
    public boolean delMerchantToolsDic(String toolId) throws NullException, OperateFailException
    {
        ShopToolInfo shopToolInfo = new ShopToolInfo();
        shopToolInfo.setToolId(toolId);
        shopToolInfo.setIsDel("Y");
        return this.shopToolInfoGeneratorCoreService.updateByPrimaryKeySelective(shopToolInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean addAllMerchantToolsDic(List<ShopToolInfo> sysList) throws NullException, OperateFailException
    {
        if (!CollectionUtils.isNotEmpty(sysList))
        {
            GooagooLog.info("对象内容为空");
            return false;
        }
        if (!this.shopToolInfoGeneratorCoreService.deleteByExample(null))
        {
            GooagooLog.info("清空商家服务工具表失败");
            throw new OperateFailException("清空商家服务工具表失败");
        }
        for (ShopToolInfo inter : sysList)
        {
            if (!this.shopToolInfoGeneratorCoreService.insertSelective(inter))
            {
                throw new OperateFailException("新增商家服务工具失败" + new Gson().toJson(inter));
            }
        }
        return true;
    }
}
