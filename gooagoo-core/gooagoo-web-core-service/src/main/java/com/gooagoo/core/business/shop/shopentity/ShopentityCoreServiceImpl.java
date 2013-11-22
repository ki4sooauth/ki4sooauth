package com.gooagoo.core.business.shop.shopentity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.shop.shopentity.ShopentityCoreService;
import com.gooagoo.api.generator.core.shop.ShopEntityInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.shop.ShopEntityLinkGeneratorCoreService;
import com.gooagoo.api.generator.core.shop.ShopGpsInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.shop.ShopInvoiceInfoGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.shop.ShopEntityInfo;
import com.gooagoo.entity.generator.shop.ShopEntityLink;
import com.gooagoo.entity.generator.shop.ShopGpsInfo;
import com.gooagoo.entity.generator.shop.ShopInvoiceInfo;
import com.gooagoo.exception.common.OperateFailException;
import com.google.gson.Gson;

@Service
public class ShopentityCoreServiceImpl implements ShopentityCoreService
{
    @Autowired
    private ShopEntityInfoGeneratorCoreService shopEntityInfoGeneratorCoreService;
    @Autowired
    private ShopInvoiceInfoGeneratorCoreService shopInvoiceInfoGeneratorCoreService;
    @Autowired
    private ShopEntityLinkGeneratorCoreService shopEntityLinkGeneratorCoreService;
    @Autowired
    private ShopGpsInfoGeneratorCoreService shopGpsInfoGeneratorCoreService;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean addShopEntityInfo(ShopEntityInfo shopEntityInfo) throws Exception
    {
        shopEntityInfo.setIsDel("N");
        boolean res = this.shopEntityInfoGeneratorCoreService.insertSelective(shopEntityInfo);
        if (!res)
        {
            GooagooLog.warn("创建实体店信息失败:obj=" + new Gson().toJson(shopEntityInfo));
            return false;
        }
        //创建发票信息
        ShopInvoiceInfo shopInvoiceInfo = new ShopInvoiceInfo();
        shopInvoiceInfo.setName1("[]");
        shopInvoiceInfo.setName2("[]");
        shopInvoiceInfo.setShopEntityId(shopEntityInfo.getShopEntityId());
        shopInvoiceInfo.setIsDel("N");
        res = this.shopInvoiceInfoGeneratorCoreService.insertSelective(shopInvoiceInfo);
        if (!res)
        {
            GooagooLog.warn("创建实体店信息,添加发票信息失败:obj=" + new Gson().toJson(shopInvoiceInfo));
            throw new OperateFailException("创建实体店信息失败");
        }
        //创建实体店联系方式信息
        ShopEntityLink shopEntityLink = new ShopEntityLink();
        shopEntityLink.setShopEntityId(shopEntityInfo.getShopEntityId());
        shopEntityLink.setShopId(shopEntityInfo.getShopId());
        shopEntityLink.setIsDel("N");
        res = this.shopEntityLinkGeneratorCoreService.insertSelective(shopEntityLink);
        if (!res)
        {
            GooagooLog.warn("创建实体店信息,添加实体店联系方式信息失败:obj=" + new Gson().toJson(shopInvoiceInfo));
            throw new OperateFailException("创建实体店信息失败");
        }
        //创建gps信息
        ShopGpsInfo shopGpsInfo = new ShopGpsInfo();
        shopGpsInfo.setShopEntityId(shopEntityInfo.getShopEntityId());
        shopGpsInfo.setShopId(shopEntityInfo.getShopId());
        shopGpsInfo.setIsDel("N");
        res = this.shopGpsInfoGeneratorCoreService.insertSelective(shopGpsInfo);
        if (!res)
        {
            GooagooLog.warn("创建实体店信息,添加gps信息失败:obj=" + new Gson().toJson(shopInvoiceInfo));
            throw new OperateFailException("创建实体店信息失败");
        }
        return true;
    }

    @Override
    public boolean updateShopEntityInfo(ShopEntityInfo shopEntityInfo) throws Exception
    {
        return this.shopEntityInfoGeneratorCoreService.updateByPrimaryKeySelective(shopEntityInfo);
    }

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean deleteShopEntityInfo(String id) throws Exception
    {
        if (!StringUtils.hasText(id))
        {
            GooagooLog.warn("删除实体店信息：Id为空");
            return false;
        }
        boolean res = false;
        res = this.shopEntityInfoGeneratorCoreService.deleteByPrimaryKey(id);
        if (!res)
        {
            GooagooLog.warn("删除实体店信息失败:shopEntityInfoId=" + new Gson().toJson(id));
            return false;
        }
        res = this.shopInvoiceInfoGeneratorCoreService.deleteByPrimaryKey(id);
        if (!res)
        {
            GooagooLog.warn("删除实体店信息，删除发票信息失败:shopEntityInfoId=" + id);
            throw new OperateFailException("删除实体店信息失败");
        }
        res = this.shopEntityLinkGeneratorCoreService.deleteByPrimaryKey(id);
        if (!res)
        {
            GooagooLog.warn("删除实体店信，删除gps息失败:shopEntityInfoId=" + id);
            throw new OperateFailException("删除实体店信息失败");
        }
        res = this.shopGpsInfoGeneratorCoreService.deleteByPrimaryKey(id);
        if (!res)
        {
            GooagooLog.warn("删除实体店信，删除gps息失败:shopEntityInfoId=" + id);
            throw new OperateFailException("删除实体店信息失败");
        }
        return true;
    }
}
