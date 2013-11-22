package com.gooagoo.igus.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.shop.ShopInfoExample;
import com.gooagoo.entity.generator.shop.ShopInfoExample.Criteria;
import com.gooagoo.igus.service.IGusService;
import com.gooagoo.view.gus.UShop;

/**
 * 获取商家列表
 * @author SPZ
 *
 */
@Service("igus017Service")
public class IGus017ServiceImpl implements IGusService
{

    @Autowired
    private ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;

    @Override
    public TransData<Object> service(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String shopTypeRootId = ServletRequestUtils.getStringParameter(request, "shopTypeRootId");
            String shopTypeLeafId = ServletRequestUtils.getStringParameter(request, "shopTypeLeafId");
            ShopInfoExample shopInfoExample = new ShopInfoExample();
            Criteria criteria = shopInfoExample.createCriteria();
            if (StringUtils.isNotBlank(shopTypeRootId))
            {
                criteria.andShopTypeRootEqualTo(shopTypeRootId);
            }
            if (StringUtils.isNotBlank(shopTypeLeafId))
            {
                criteria.andShopTypeLeafEqualTo(shopTypeLeafId);
            }
            criteria.andShopStatusEqualTo("U").andIsDelEqualTo("N");
            List<ShopInfo> shopInfoList = this.shopInfoGeneratorQueryService.selectByExample(shopInfoExample);
            if (CollectionUtils.isEmpty(shopInfoList))
            {
                GooagooLog.error("获取商家列表：未获取到满足条件的商家列表", null);
                return new TransData<Object>(false, null, null);//TODO 没有数据异常
            }
            List<UShop> ushopList = new ArrayList<UShop>();
            for (ShopInfo shopInfo : shopInfoList)
            {
                UShop ushop = new UShop();
                ushop.setShopId(shopInfo.getShopId());
                ushop.setShopName(shopInfo.getShopName());
                ushopList.add(ushop);
            }
            transData = new TransData<Object>(true, null, ushopList);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取商家列表：获取商家列表异常", e);
            transData = new TransData<Object>(false, null, null);//TODO 系统异常
        }
        return transData;
    }

}
