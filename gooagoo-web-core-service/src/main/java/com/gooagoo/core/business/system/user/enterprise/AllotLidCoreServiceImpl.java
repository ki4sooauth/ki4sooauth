package com.gooagoo.core.business.system.user.enterprise;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.core.system.user.enterprise.AllotLidCoreService;
import com.gooagoo.api.generator.core.shop.ShopLidDetailGeneratorCoreService;
import com.gooagoo.api.generator.core.shop.ShopLidInfoGeneratorCoreService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.shop.ShopLidDetail;
import com.gooagoo.entity.generator.shop.ShopLidDetailExample;
import com.gooagoo.entity.generator.shop.ShopLidInfo;
import com.gooagoo.entity.generator.shop.ShopLidInfoExample;

/**
 *  商家LID管理
 */
@Service
public class AllotLidCoreServiceImpl implements AllotLidCoreService
{

    @Autowired
    private ShopLidInfoGeneratorCoreService shopLidInfoGeneratorCoreService;

    @Autowired
    private ShopLidDetailGeneratorCoreService shopLidDetailGeneratorCoreService;

    @Override
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public boolean allotjLid(String lidBase, String shopId, String shopEntityId) throws Exception
    {
        ShopLidInfoExample shopLidInfoExample = new ShopLidInfoExample();
        shopLidInfoExample.createCriteria().andLidBaseEqualTo(lidBase).andShopIdEqualTo(shopId).andShopEntityIdEqualTo(shopEntityId);
        List<ShopLidInfo> shopLidInfoList = this.shopLidInfoGeneratorCoreService.selectByExample(shopLidInfoExample);
        if (CollectionUtils.isNotEmpty(shopLidInfoList))
        {
            ShopLidInfo shopLidInfo = shopLidInfoList.get(0);
            if ("Y".equals(shopLidInfo.getIsDel()))
            {
                shopLidInfo.setIsDel("N");
                if (!this.shopLidInfoGeneratorCoreService.updateByPrimaryKeySelective(shopLidInfo))
                {
                    GooagooLog.error("还原商家LID基本信息失败[shopLidInfo=" + shopLidInfo.toString() + "]", null);
                    return false;
                }
            }
        }
        else
        {
            ShopLidInfo shopLidInfo = new ShopLidInfo();
            shopLidInfo.setLidBase(lidBase);
            shopLidInfo.setShopId(shopId);
            shopLidInfo.setShopEntityId(shopEntityId);
            shopLidInfo.setIsDel("N");
            if (!this.shopLidInfoGeneratorCoreService.insertSelective(shopLidInfo))
            {
                GooagooLog.error("新增商家LID基本信息失败[shopLidInfo=" + shopLidInfo.toString() + "]", null);
                return false;
            }
        }
        for (int i = 0; i < 256; i++)
        {
            String lid = i < 16 ? lidBase + "0" + Integer.toHexString(i) : lidBase + Integer.toHexString(i);//lidBase+16进制
            ShopLidDetailExample shopLidDetailExample = new ShopLidDetailExample();
            shopLidDetailExample.createCriteria().andLidEqualTo(lid).andLidBaseEqualTo(lidBase).andShopIdEqualTo(shopId).andShopEntityIdEqualTo(shopEntityId);
            List<ShopLidDetail> shopLidDetailList = this.shopLidDetailGeneratorCoreService.selectByExample(shopLidDetailExample);
            if (CollectionUtils.isNotEmpty(shopLidDetailList))
            {
                ShopLidDetail shopLidDetail = shopLidDetailList.get(0);
                if ("Y".equals(shopLidDetail.getIsDel()))
                {
                    shopLidDetail.setIsDel("N");
                    if (!this.shopLidDetailGeneratorCoreService.updateByPrimaryKeySelective(shopLidDetail))
                    {
                        GooagooLog.error("还原商家LID详细分配信息失败[shopLidDetail=" + shopLidDetail.toString() + "]", null);
                        return false;
                    }
                }
            }
            else
            {
                ShopLidDetail shopLidDetail = new ShopLidDetail();
                shopLidDetail.setLid(lid);
                shopLidDetail.setLidBase(lidBase);
                shopLidDetail.setShopId(shopId);
                shopLidDetail.setShopEntityId(shopEntityId);
                shopLidDetail.setStatus("Y");
                shopLidDetail.setIsDel("N");
                if (!this.shopLidDetailGeneratorCoreService.insertSelective(shopLidDetail))
                {
                    GooagooLog.error("新增商家LID详细分配信息失败[shopLidDetail=" + shopLidDetail.toString() + "]", null);
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean batchDeleteShopLidDetail(String lids) throws Exception
    {
        if (!StringUtils.hasText(lids))
        {
            return false;
        }
        List<String> lidList = Arrays.asList(lids.split(","));
        ShopLidDetail shopLidDetail = new ShopLidDetail();
        shopLidDetail.setIsDel("Y");
        ShopLidDetailExample shopLidDetailExample = new ShopLidDetailExample();
        shopLidDetailExample.createCriteria().andLidIn(lidList);
        if (!this.shopLidDetailGeneratorCoreService.updateByExampleSelective(shopLidDetail, shopLidDetailExample))
        {
            GooagooLog.error("批量软删商家LID详细分配信息失败[lids=" + lids + "]", null);
            return false;
        }
        return true;
    }

}
