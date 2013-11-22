package com.gooagoo.core.business.system.sys.dictionary;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gooagoo.api.business.core.system.sys.dictionary.ShopAuthorityDicCoreService;
import com.gooagoo.api.generator.core.shop.ShopAuthorityGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.shop.ShopAuthority;
import com.gooagoo.exception.common.OperateFailException;
import com.google.gson.Gson;

@Service
public class ShopAuthorityDicCoreServiceImpl implements ShopAuthorityDicCoreService

{

    @Autowired
    private ShopAuthorityGeneratorCoreService shopAuthorityGeneratorCoreService;

    @Override
    public boolean addShopAuthorityDic(ShopAuthority shopAuthority) throws Exception
    {
        shopAuthority.setIsDel("N");
        return this.shopAuthorityGeneratorCoreService.insertSelective(shopAuthority);
    }

    @Override
    public boolean updateShopAuthorityDic(ShopAuthority shopAuthority) throws Exception
    {
        return this.shopAuthorityGeneratorCoreService.updateByPrimaryKeySelective(shopAuthority);
    }

    @Override
    public boolean delShopAuthorityDic(String authorityId) throws Exception
    {
        ShopAuthority shopAuthority = new ShopAuthority();
        shopAuthority.setAuthorityId(authorityId);
        shopAuthority.setIsDel("Y");
        return this.shopAuthorityGeneratorCoreService.updateByPrimaryKeySelective(shopAuthority);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean addAllShopAuthorityDic(List<ShopAuthority> sysList) throws Exception
    {
        if (!CollectionUtils.isNotEmpty(sysList))
        {
            GooagooLog.info("对象内容为空");
            return false;
        }
        if (!this.shopAuthorityGeneratorCoreService.deleteByExample(null))
        {
            GooagooLog.info("清空商家管理权限表失败");
            throw new OperateFailException("清空商家管理权限表失败");
        }
        for (ShopAuthority inter : sysList)
        {
            if (!this.shopAuthorityGeneratorCoreService.insertSelective(inter))
            {
                throw new OperateFailException("新增商家管理权限失败" + new Gson().toJson(inter));
            }
        }
        return true;
    }

}
