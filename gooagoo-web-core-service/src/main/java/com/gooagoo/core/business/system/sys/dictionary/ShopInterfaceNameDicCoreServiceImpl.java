package com.gooagoo.core.business.system.sys.dictionary;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.system.sys.dictionary.ShopInterfaceNameDicCoreService;
import com.gooagoo.api.generator.core.base.ShopInterfaceNameGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.base.ShopInterfaceName;
import com.gooagoo.exception.common.OperateFailException;
import com.google.gson.Gson;

@Service
public class ShopInterfaceNameDicCoreServiceImpl implements ShopInterfaceNameDicCoreService

{

    @Autowired
    private ShopInterfaceNameGeneratorCoreService ShopInterfaceNameGeneratorCoreService;

    @Override
    public boolean addShopInterfaceNameDic(ShopInterfaceName shopInterfaceName) throws Exception
    {
        shopInterfaceName.setIsDel("N");
        return this.ShopInterfaceNameGeneratorCoreService.insertSelective(shopInterfaceName);
    }

    @Override
    public boolean updateShopInterfaceNameDic(ShopInterfaceName shopInterfaceName) throws Exception
    {
        return this.ShopInterfaceNameGeneratorCoreService.updateByPrimaryKeySelective(shopInterfaceName);
    }

    @Override
    public boolean delShopInterfaceNameDic(String id) throws Exception
    {
        ShopInterfaceName shopInterfaceName = new ShopInterfaceName();
        shopInterfaceName.setId(id);
        shopInterfaceName.setIsDel("Y");
        return this.ShopInterfaceNameGeneratorCoreService.updateByPrimaryKeySelective(shopInterfaceName);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean addAllShopInterfaceNameDic(List<ShopInterfaceName> sysList) throws Exception
    {
        if (!CollectionUtils.isNotEmpty(sysList))
        {
            GooagooLog.info("对象内容为空");
            return false;
        }
        if (!this.ShopInterfaceNameGeneratorCoreService.deleteByExample(null))
        {
            GooagooLog.info("清空商家界面名称表失败");
            throw new OperateFailException("清空商家界面名称表失败");
        }
        for (ShopInterfaceName inter : sysList)
        {
            if (!this.ShopInterfaceNameGeneratorCoreService.insertSelective(inter))
            {
                throw new OperateFailException("新增商家界面名称失败" + new Gson().toJson(inter));
            }
        }
        return true;
    }

}
