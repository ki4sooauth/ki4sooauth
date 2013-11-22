package com.gooagoo.core.business.system.sys.dictionary;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.system.sys.dictionary.MerchantTypeDicCoreService;
import com.gooagoo.api.generator.core.base.ShopTypeGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.base.ShopType;
import com.gooagoo.exception.common.OperateFailException;
import com.google.gson.Gson;

@Service
public class MerchantTypeDicCoreServiceImpl implements MerchantTypeDicCoreService

{

    @Autowired
    private ShopTypeGeneratorCoreService shopTypeGeneratorCoreService;

    @Override
    public boolean addMerchantTypeDic(ShopType shopType) throws Exception
    {
        shopType.setIsDel("N");
        return this.shopTypeGeneratorCoreService.insertSelective(shopType);
    }

    @Override
    public boolean updateMerchantTypeDic(ShopType shopType) throws Exception
    {
        return this.shopTypeGeneratorCoreService.updateByPrimaryKeySelective(shopType);
    }

    @Override
    public boolean delMerchantTypeDic(String shopTypeId) throws Exception
    {
        ShopType shopType = new ShopType();
        shopType.setShopTypeId(Integer.parseInt(shopTypeId));
        shopType.setIsDel("Y");
        return this.shopTypeGeneratorCoreService.updateByPrimaryKeySelective(shopType);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean addAllMerchantTypeDic(List<ShopType> sysList) throws Exception
    {
        if (!CollectionUtils.isNotEmpty(sysList))
        {
            GooagooLog.info("对象内容为空");
            return false;
        }
        if (!this.shopTypeGeneratorCoreService.deleteByExample(null))
        {
            GooagooLog.info("清空商家类型表失败");
            throw new OperateFailException("清空商家类型表失败");
        }
        for (ShopType inter : sysList)
        {
            if (!this.shopTypeGeneratorCoreService.insertSelective(inter))
            {
                throw new OperateFailException("新增商家类型失败" + new Gson().toJson(inter));
            }
        }
        return true;
    }

}
