package com.gooagoo.igms.good.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.goods.manage.GoodsCategoryCoreService;
import com.gooagoo.api.generator.query.goods.GoodsCategoryGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopPositionGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.StringUtils;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.entity.generator.goods.GoodsCategory;
import com.gooagoo.entity.generator.goods.GoodsCategoryExample;
import com.gooagoo.entity.generator.goods.GoodsCategoryExample.Criteria;
import com.gooagoo.entity.generator.shop.ShopPosition;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.good.service.IGoodsCategoryService;
import com.gooagoo.igms.shopinfo.service.ShopLoginService;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.good.FGoodsCategory;

@Service("igoodsCategoryService")
public class IGoodsCategoryServiceImpl implements IGoodsCategoryService
{
    @Autowired
    private GoodsCategoryCoreService categoryCoreService;
    @Autowired
    private GoodsCategoryGeneratorQueryService categoryQueryService;
    @Autowired
    private ShopPositionGeneratorQueryService positionQueryService;
    @Autowired
    private ShopLoginService shopLoginService;

    @Override
    public TransData<String> addCategory(HttpServletRequest request) throws Exception
    {
        String id = StringUtils.getUUID();
        GoodsCategory goodsCategory = ServletUtils.objectMethod(GoodsCategory.class, request);
        goodsCategory.setId(id);
        goodsCategory.setShopId(GmsInterfaceUtil.getShopIdByInterface(request));
        goodsCategory.setSort(0);
        goodsCategory.setIsDel("N");
        goodsCategory.setCreateTime(new Date());
        boolean result = this.checkCategory(goodsCategory);
        if (result)
        {
            result = this.categoryCoreService.addGoodsCategory(goodsCategory);
        }
        return GMSUtil.getBooleanAndExtendResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, id, id);
    }

    @Override
    public TransData<Object> delCategory(HttpServletRequest request) throws Exception
    {
        String id = ServletRequestUtils.getStringParameter(request, "id", "");
        boolean result = false;
        if (id.length() == 32)
        {
            result = this.categoryCoreService.deleteGoodsCategory(id);
        }

        return GMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, id);
    }

    @Override
    public TransData<Object> updateCategory(HttpServletRequest request) throws Exception
    {
        GoodsCategory goodsCategory = ServletUtils.objectMethod(GoodsCategory.class, request);
        boolean result = this.checkCategory(goodsCategory);
        if (result)
        {
            result = this.categoryCoreService.updateGoodsCategory(goodsCategory);
        }
        return GMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, goodsCategory.getId());
    }

    @Override
    public TransData<FGoodsCategory> getCategory(HttpServletRequest request) throws Exception
    {
        String id = ServletRequestUtils.getStringParameter(request, "id", "");
        GoodsCategory goodsCategory = null;
        if (id.length() == 32)
        {
            goodsCategory = this.categoryQueryService.selectByPrimaryKey(id);
        }
        if (goodsCategory != null)
        {
            FGoodsCategory gCategory = this.convertToFGoodsCategory(goodsCategory);
            return new TransData<FGoodsCategory>(true, MessageConst.GMS_OPERATE_SUCCESS, gCategory, id);
        }
        else
        {
            return new TransData<FGoodsCategory>(false, MessageConst.GMS_OPERATE_FAIL, null);
        }
    }

    @Override
    public TransData<List<FGoodsCategory>> getCategoryList(HttpServletRequest request) throws Exception
    {
        ShopLoginInfo loginInfo = this.shopLoginService.getShopLoginInfo(request);
        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");
        if (loginInfo.getShopAndUserInfo().getUserShopEntityId() != null && !loginInfo.getShopAndUserInfo().getUserShopEntityId().isEmpty())
        {
            shopEntityId = loginInfo.getShopAndUserInfo().getUserShopEntityId();
        }

        GoodsCategoryExample example = new GoodsCategoryExample();
        Criteria criteria = example.createCriteria();
        criteria.andShopIdEqualTo(GmsInterfaceUtil.getShopIdByInterface(request));
        if (shopEntityId.length() == 32)
        {
            criteria.andShopEntityIdEqualTo(shopEntityId);
        }
        criteria.andIsDelEqualTo(GMSConstant.NO);

        List<GoodsCategory> list = this.categoryQueryService.selectByExample(example);
        if (list == null)
        {
            return new TransData<List<FGoodsCategory>>(false, MessageConst.GMS_OPERATE_FAIL, null);
        }
        else
        {
            List<FGoodsCategory> categories = new ArrayList<FGoodsCategory>();
            for (int i = 0; i < list.size(); i++)
            {
                FGoodsCategory category = this.convertToFGoodsCategory(list.get(i));
                categories.add(category);
            }
            return new TransData<List<FGoodsCategory>>(true, MessageConst.GMS_OPERATE_SUCCESS, categories);
        }
    }

    @Override
    @Deprecated
    public TransData<PageModel<FGoodsCategory>> getCategoryPage(HttpServletRequest request) throws Exception
    {

        //        FGoodsCategory goodsCategory = new FGoodsCategory();
        //        GmsLoginInfo gmsLoginInfo = GMSUtil.getShopInfo(request);
        //        goodsCategory.setShopId(gmsLoginInfo.getShopId());
        //        goodsCategory.setId("N");
        //        PageCondition pageCon = ServletUtils.objectMethod(PageCondition.class, request);
        //
        //        PageModel<FGoodsCategory> pageModel = this.categoryQueryService.getCategoryPage(goodsCategory, pageCon);
        //
        //        if (pageModel == null)
        //        {
        //            return new TransData<PageModel<FGoodsCategory>>(false, MessageConst.GMS_GOOD_CATEGORY_GET_LIST_FAIL, null);
        //        }
        //        else
        //        {
        //            return new TransData<PageModel<FGoodsCategory>>(true, MessageConst.SYS_LOAD_DATA_SUCCESS, pageModel);
        //        }
        return null;
    }

    private boolean checkCategory(GoodsCategory goodsCategory)
    {

        if (goodsCategory == null)
        {
            return false;
        }
        if (goodsCategory.getParentCategoryId() == null || goodsCategory.getParentCategoryId().isEmpty() || goodsCategory.getParentCategoryId().length() > 32)
        {
            return false;
        }
        if (goodsCategory.getPositionId() == null || goodsCategory.getPositionId().length() != 32)
        {
            return false;
        }
        if (goodsCategory.getCategoryName() == null || goodsCategory.getCategoryName().length() > 32)
        {
            return false;
        }
        if (goodsCategory.getPicUrl() == null)
        {
            goodsCategory.setPicUrl("");
        }
        if (goodsCategory.getPicUrl().length() > 255)
        {
            return false;
        }
        if (goodsCategory.getShopEntityId() == null || goodsCategory.getShopEntityId().length() != 32)
        {
            return false;
        }
        if (goodsCategory.getCategoryId() == null)
        {
            return false;
        }

        GoodsCategoryExample example = new GoodsCategoryExample();
        Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(goodsCategory.getCategoryId());
        criteria.andShopEntityIdEqualTo(goodsCategory.getShopEntityId());

        List<GoodsCategory> list = this.categoryQueryService.selectByExample(example);
        if (list.size() > 1)
        {
            return false;
        }
        if (list.size() == 1 && !list.get(0).getId().equals(goodsCategory.getId()))
        {
            return false;
        }
        return true;
    }

    private FGoodsCategory convertToFGoodsCategory(GoodsCategory goodsCategory)
    {
        FGoodsCategory category = null;
        if (goodsCategory != null)
        {
            category = new FGoodsCategory();
            category.setId(goodsCategory.getId());
            category.setCategoryId(goodsCategory.getCategoryId());
            category.setCategoryName(goodsCategory.getCategoryName());
            category.setPicUrl(goodsCategory.getPicUrl());
            category.setShopId(goodsCategory.getShopId());
            category.setEntityId(goodsCategory.getShopEntityId());
            category.setPositionId(goodsCategory.getPositionId());
            category.setParentCategoryId(goodsCategory.getParentCategoryId());
            if (!goodsCategory.getParentCategoryId().equals("-1"))
            {
                GoodsCategoryExample example = new GoodsCategoryExample();
                Criteria criteria = example.createCriteria();
                criteria.andCategoryIdEqualTo(goodsCategory.getParentCategoryId());
                criteria.andShopEntityIdEqualTo(goodsCategory.getShopEntityId());
                criteria.andIsDelEqualTo(GMSConstant.NO);

                List<GoodsCategory> categories = this.categoryQueryService.selectByExample(example);

                if (categories.size() > 0)
                {
                    category.setParentCategoryName(categories.get(0).getCategoryName());
                }
            }
            else
            {
                category.setParentCategoryName("无父节点");
            }
            if (goodsCategory.getPositionId().length() == 32)
            {
                ShopPosition t = this.positionQueryService.selectByPrimaryKey(goodsCategory.getPositionId());
                if (t != null)
                {
                    category.setPositionName(t.getPositionName());
                }
            }
            else
            {
                category.setPositionName("");
            }
        }
        return category;
    }
}
