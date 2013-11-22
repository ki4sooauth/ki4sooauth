package com.gooagoo.igms.good.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.goods.manage.GoodsBrandCoreService;
import com.gooagoo.api.generator.query.goods.GoodsBrandGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.StringUtils;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.entity.generator.goods.GoodsBrand;
import com.gooagoo.entity.generator.goods.GoodsBrandExample;
import com.gooagoo.entity.generator.goods.GoodsBrandExample.Criteria;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.good.service.IGoodsBrandService;
import com.gooagoo.igms.shopinfo.service.ShopLoginService;
import com.gooagoo.view.gms.good.FGoodsBrand;

@Service("igoodsBrandService")
public class IGoodsBrandServiceImpl implements IGoodsBrandService
{
    @Autowired
    private GoodsBrandCoreService brandCoreService;
    @Autowired
    private GoodsBrandGeneratorQueryService brandQueryService;
    @Autowired
    private ShopLoginService shopLoginService;

    @Override
    public TransData<String> addGoodsBrand(HttpServletRequest request) throws Exception
    {
        String id = StringUtils.getUUID();

        GoodsBrand goodsBrand = ServletUtils.objectMethod(GoodsBrand.class, request);
        goodsBrand.setId(id);
        goodsBrand.setShopId(GmsInterfaceUtil.getShopIdByInterface(request));
        goodsBrand.setSort(0);
        goodsBrand.setIsDel(GMSConstant.NO);
        goodsBrand.setCreateTime(new Date());

        boolean result = this.checkGoodsBrand(goodsBrand);
        if (result)
        {
            result = this.brandCoreService.addGoodsBrand(goodsBrand);
        }
        return GMSUtil.getBooleanAndExtendResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, id, id);
    }

    @Override
    public TransData<Object> delGoodsBrand(HttpServletRequest request) throws Exception
    {
        String id = ServletRequestUtils.getStringParameter(request, "id", "");
        boolean result = false;
        if (id.length() == 32)
        {
            result = this.brandCoreService.deleteGoodsBrand(id);
        }
        return GMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, id);
    }

    @Override
    public TransData<Object> updateGoodsBrand(HttpServletRequest request) throws Exception
    {
        GoodsBrand goodsBrand = ServletUtils.objectMethod(GoodsBrand.class, request);

        boolean flag = this.checkGoodsBrand(goodsBrand);
        if (flag)
        {
            flag = this.brandCoreService.updateGoodsBrand(goodsBrand);
        }

        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, goodsBrand.getId());
    }

    @Override
    public TransData<FGoodsBrand> getGoodsBrand(HttpServletRequest request) throws Exception
    {
        String id = ServletRequestUtils.getStringParameter(request, "id", "");
        boolean flag = false;
        GoodsBrand goodsBrand = null;

        if (id.length() == 32)
        {
            goodsBrand = this.brandQueryService.selectByPrimaryKey(id);
            if (goodsBrand != null)
            {
                flag = true;
            }
        }

        if (flag)
        {
            FGoodsBrand gBrand = this.convertToFGoodsBrand(goodsBrand);
            return new TransData<FGoodsBrand>(true, MessageConst.GMS_OPERATE_SUCCESS, gBrand, id);
        }
        else
        {
            return new TransData<FGoodsBrand>(false, MessageConst.GMS_OPERATE_FAIL, null);
        }
    }

    @Override
    public TransData<List<FGoodsBrand>> getGoodsBrandList(HttpServletRequest request) throws Exception
    {
        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");
        ShopLoginInfo loginInfo = this.shopLoginService.getShopLoginInfo(request);

        if (org.springframework.util.StringUtils.hasText(loginInfo.getShopAndUserInfo().getUserShopEntityId()))
        {
            shopEntityId = loginInfo.getShopAndUserInfo().getUserShopEntityId();
        }

        GoodsBrandExample example = new GoodsBrandExample();
        Criteria criteria = example.createCriteria();
        criteria.andShopIdEqualTo(GmsInterfaceUtil.getShopIdByInterface(request));
        criteria.andIsDelEqualTo(GMSConstant.NO);
        if (shopEntityId.length() == 32)
        {
            criteria.andShopEntityIdEqualTo(shopEntityId);
        }
        List<GoodsBrand> list = this.brandQueryService.selectByExample(example);

        if (list == null)
        {
            return new TransData<List<FGoodsBrand>>(false, MessageConst.GMS_OPERATE_FAIL, null);
        }

        List<FGoodsBrand> brands = new ArrayList<FGoodsBrand>();
        for (int i = 0; i < list.size(); i++)
        {
            FGoodsBrand brand = this.convertToFGoodsBrand(list.get(i));
            brands.add(brand);
        }

        return new TransData<List<FGoodsBrand>>(true, MessageConst.GMS_OPERATE_SUCCESS, brands);
    }

    private boolean checkGoodsBrand(GoodsBrand goodsBrand)
    {
        if (goodsBrand == null)
        {
            return false;
        }
        if (goodsBrand.getShopEntityId() == null || goodsBrand.getShopEntityId().length() != 32)
        {
            return false;
        }
        if (goodsBrand.getPicUrl() == null || goodsBrand.getPicUrl().length() > 255)
        {
            return false;
        }
        if (goodsBrand.getPositionId() == null || goodsBrand.getPositionId().length() != 32)
        {
            return false;
        }
        if (goodsBrand.getPositionName() == null || goodsBrand.getPositionName().length() > 32)
        {
            return false;
        }
        if (goodsBrand.getBrandName() == null || goodsBrand.getBrandName().length() > 32)
        {
            return false;
        }
        if (goodsBrand.getBrandId() == null || goodsBrand.getBrandId().isEmpty())
        {
            return false;
        }

        GoodsBrandExample example = new GoodsBrandExample();
        Criteria criteria = example.createCriteria();
        criteria.andBrandIdEqualTo(goodsBrand.getBrandId());
        criteria.andShopEntityIdEqualTo(goodsBrand.getShopEntityId());

        List<GoodsBrand> list = this.brandQueryService.selectByExample(example);
        if (list.size() > 1)
        {
            return false;
        }
        if (list.size() == 1 && !list.get(0).getId().equals(goodsBrand.getId()))
        {
            return false;
        }

        return true;
    }

    private FGoodsBrand convertToFGoodsBrand(GoodsBrand brand)
    {
        FGoodsBrand goodsBrand = null;
        if (brand != null)
        {
            goodsBrand = new FGoodsBrand();
            goodsBrand.setBrandId(brand.getBrandId());
            goodsBrand.setBrandName(brand.getBrandName());
            goodsBrand.setId(brand.getId());
            goodsBrand.setPicUrl(brand.getPicUrl());
            goodsBrand.setPositionId(brand.getPositionId());
            goodsBrand.setPositionName(brand.getPositionName());
            goodsBrand.setShopId(brand.getShopId());
            goodsBrand.setEntityId(brand.getShopEntityId());
        }
        return goodsBrand;
    }
}
