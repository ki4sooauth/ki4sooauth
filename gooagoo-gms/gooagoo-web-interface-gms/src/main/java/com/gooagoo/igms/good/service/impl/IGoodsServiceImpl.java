package com.gooagoo.igms.good.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.goods.manage.GoodsCoreService;
import com.gooagoo.api.generator.query.goods.GoodsBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsBrandGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsCategoryGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsMarketingInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopEntityInfoGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.StringUtils;
import com.gooagoo.common.utils.UrlUtils;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsBaseInfoExample;
import com.gooagoo.entity.generator.goods.GoodsBrand;
import com.gooagoo.entity.generator.goods.GoodsBrandExample;
import com.gooagoo.entity.generator.goods.GoodsBrandExample.Criteria;
import com.gooagoo.entity.generator.goods.GoodsCategory;
import com.gooagoo.entity.generator.goods.GoodsCategoryExample;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfo;
import com.gooagoo.entity.generator.shop.ShopEntityInfo;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.good.service.IGoodsService;
import com.gooagoo.igms.shopinfo.service.ShopLoginService;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.good.FGoods;
import com.google.gson.Gson;

@Service("igoodsService")
public class IGoodsServiceImpl implements IGoodsService
{
    @Autowired
    private GoodsCoreService goodsCoreService;
    @Autowired
    private GoodsBaseInfoGeneratorQueryService goodsQueryService;
    @Autowired
    private GoodsBrandGeneratorQueryService brandQueryService;
    @Autowired
    private GoodsCategoryGeneratorQueryService categoryQueryService;
    @Autowired
    private GoodsMarketingInfoGeneratorQueryService marketingQueryService;
    @Autowired
    private ShopLoginService shopLoginService;
    @Autowired
    private ShopEntityInfoGeneratorQueryService shopEntityInfoGeneratorQueryService;

    @Override
    public TransData<String> addGoods(HttpServletRequest request) throws Exception
    {
        FGoods fGoods = ServletUtils.objectMethod(FGoods.class, request);
        GoodsBaseInfo goodsBaseInfo = this.convertToGoodsBaseInfo(fGoods);
        String goodsId = StringUtils.getUUID();
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);
        goodsBaseInfo.setGoodsId(goodsId);
        goodsBaseInfo.setIsDel(GMSConstant.NO);
        goodsBaseInfo.setCreateTime(new Date());
        goodsBaseInfo.setPublishStatus("W");
        goodsBaseInfo.setShopId(shopId);

        boolean flag = this.checkGoods(goodsBaseInfo);
        if (flag)
        {
            flag = this.goodsCoreService.addGoodsBaseInfo(goodsBaseInfo);
        }
        return GMSUtil.getBooleanAndExtendResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, goodsId, goodsId);
    }

    @Override
    public TransData<Object> updateGoods(HttpServletRequest request) throws Exception
    {

        FGoods fGoods = ServletUtils.objectMethod(FGoods.class, request);
        GoodsBaseInfo goodsBaseInfo = this.convertToGoodsBaseInfo(fGoods);
        boolean result = this.checkGoods(goodsBaseInfo);
        if (result)
        {
            result = this.goodsCoreService.updateGoodsBaseInfo(goodsBaseInfo);
        }
        return GMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, goodsBaseInfo.getGoodsId());
    }

    @Override
    public TransData<Object> delGoods(HttpServletRequest request) throws Exception
    {

        String goodsId = ServletRequestUtils.getStringParameter(request, "goodsId", "");
        boolean flag = false;
        if (goodsId.length() == 32)
        {
            flag = this.goodsCoreService.deleteGoodsInfo(goodsId);
        }
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, goodsId);
    }

    @Override
    public TransData<FGoods> getGoods(HttpServletRequest request) throws Exception
    {

        String goodsId = ServletRequestUtils.getStringParameter(request, "goodsId", "");

        boolean flag = false;
        GoodsBaseInfo goodsBaseInfo = null;
        if (goodsId.length() == 32)
        {
            goodsBaseInfo = this.goodsQueryService.selectByPrimaryKey(goodsId);
            if (goodsBaseInfo != null)
            {
                flag = true;
            }
        }
        if (flag)
        {
            FGoods goods = this.convertToFGoods(goodsBaseInfo);
            return new TransData<FGoods>(true, MessageConst.GMS_OPERATE_SUCCESS, goods, goodsId);
        }
        else
        {
            return new TransData<FGoods>(false, MessageConst.GMS_OPERATE_FAIL, null);
        }
    }

    @Override
    public TransData<PageModel<FGoods>> getGoodsPage(HttpServletRequest request) throws Exception
    {
        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");
        String goodsName = ServletRequestUtils.getStringParameter(request, "goodsName", "");
        String goodsCategoryLeaf = ServletRequestUtils.getStringParameter(request, "goodsCategoryLeaf", "");
        String goodsBrand = ServletRequestUtils.getStringParameter(request, "goodsBrand", "");
        String goodsSerial = ServletRequestUtils.getStringParameter(request, "goodsSerial", "");
        String itemSerial = ServletRequestUtils.getStringParameter(request, "itemSerial", "");
        String publishStatus = ServletRequestUtils.getStringParameter(request, "publishStatus", "");
        ShopLoginInfo loginInfo = this.shopLoginService.getShopLoginInfo(request);

        if (loginInfo.getShopAndUserInfo().getUserShopEntityId() != null && !loginInfo.getShopAndUserInfo().getUserShopEntityId().isEmpty())
        {
            shopEntityId = loginInfo.getShopAndUserInfo().getUserShopEntityId();
        }

        int pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        String orderBy = ServletRequestUtils.getStringParameter(request, "orderBy", "");

        GoodsBaseInfoExample example = new GoodsBaseInfoExample();
        com.gooagoo.entity.generator.goods.GoodsBaseInfoExample.Criteria criteria = example.createCriteria();
        criteria.andShopIdEqualTo(GmsInterfaceUtil.getShopIdByInterface(request));
        criteria.andIsDelEqualTo("N");
        if (!shopEntityId.isEmpty())
        {
            criteria.andShopEntityIdEqualTo(shopEntityId);
        }
        if (org.springframework.util.StringUtils.hasText(goodsName))
        {
            criteria.andGoodsNameLike("%" + goodsName + "%");
        }
        if (org.springframework.util.StringUtils.hasText(goodsCategoryLeaf))
        {
            criteria.andGoodsCategoryLeafEqualTo(goodsCategoryLeaf);
        }
        if (org.springframework.util.StringUtils.hasText(goodsBrand))
        {
            criteria.andGoodsBrandEqualTo(goodsBrand);
        }
        if (org.springframework.util.StringUtils.hasText(goodsSerial))
        {
            criteria.andGoodsSerialEqualTo(goodsSerial);
        }
        if (org.springframework.util.StringUtils.hasText(itemSerial))
        {
            criteria.andItemSerialEqualTo(itemSerial);
        }
        if (org.springframework.util.StringUtils.hasText(publishStatus))
        {
            criteria.andPublishStatusEqualTo(publishStatus);
        }
        int count = this.goodsQueryService.countByExample(example);

        example.setPage(pageIndex, pageSize);
        if (!orderBy.isEmpty())
        {
            example.setOrderByClause(orderBy);
        }
        else
        {
            example.setOrderByClause(" c_time_stamp desc ");
        }

        List<GoodsBaseInfo> list = this.goodsQueryService.selectByExample(example);
        if (list == null)
        {
            return new TransData<PageModel<FGoods>>(false, MessageConst.GMS_OPERATE_FAIL, null);
        }
        else
        {
            List<FGoods> goods = new ArrayList<FGoods>();
            for (int i = 0; i < list.size(); i++)
            {
                FGoods g = this.convertToFGoods(list.get(i));
                goods.add(g);
            }
            PageModel<FGoods> pageModel = new PageModel<FGoods>();
            pageModel.setCount(count);
            pageModel.setPageIndex(pageIndex);
            pageModel.setPageSize(pageSize);
            pageModel.setResult(goods);
            return new TransData<PageModel<FGoods>>(true, MessageConst.GMS_OPERATE_SUCCESS, pageModel);
        }
    }

    @Override
    public TransData<List<FGoods>> goodsSerialIsExist(HttpServletRequest request) throws Exception
    {
        String goodsSerial = ServletRequestUtils.getStringParameter(request, "goodsSerial", "");

        GoodsBaseInfoExample example = new GoodsBaseInfoExample();
        com.gooagoo.entity.generator.goods.GoodsBaseInfoExample.Criteria criteria = example.createCriteria();
        criteria.andGoodsSerialEqualTo(goodsSerial);
        criteria.andIsDelEqualTo(GMSConstant.NO);

        List<GoodsBaseInfo> list = this.goodsQueryService.selectByExample(example);
        List<FGoods> goods = new ArrayList<FGoods>();
        for (GoodsBaseInfo g : list)
        {
            FGoods go = this.convertToFGoods(g);
            goods.add(go);
        }
        return new TransData<List<FGoods>>(true, MessageConst.GMS_OPERATE_SUCCESS, goods);
    }

    @Override
    public TransData<List<FGoods>> itemSerialIsExist(HttpServletRequest request) throws Exception
    {
        String itemSerial = ServletRequestUtils.getStringParameter(request, "itemSerial", "");
        String shopEntityId = ServletRequestUtils.getStringParameter(request, "shopEntityId", "");
        GoodsBaseInfoExample example = new GoodsBaseInfoExample();
        com.gooagoo.entity.generator.goods.GoodsBaseInfoExample.Criteria criteria = example.createCriteria();
        criteria.andItemSerialEqualTo(itemSerial);
        criteria.andShopEntityIdEqualTo(shopEntityId);
        criteria.andIsDelEqualTo(GMSConstant.NO);

        List<GoodsBaseInfo> list = this.goodsQueryService.selectByExample(example);
        List<FGoods> goods = new ArrayList<FGoods>();
        for (GoodsBaseInfo g : list)
        {
            FGoods go = this.convertToFGoods(g);
            goods.add(go);
        }
        return new TransData<List<FGoods>>(true, MessageConst.GMS_OPERATE_SUCCESS, goods);
    }

    @Override
    public TransData<List<FGoods>> getGoodsList(HttpServletRequest request) throws Exception
    {
        String goodsIdStr = ServletRequestUtils.getStringParameter(request, "goodsIdStr", "");
        String goodsIdArray[] = goodsIdStr.split(",");
        List<FGoods> list = new ArrayList<FGoods>();
        if (goodsIdArray.length > 0)
        {
            for (String goodsId : goodsIdArray)
            {
                GoodsBaseInfo goodsBaseInfo = this.goodsQueryService.selectByPrimaryKey(goodsId);
                if (goodsBaseInfo != null)
                {
                    list.add(this.convertToFGoods(goodsBaseInfo));
                }
            }
        }
        return new TransData<List<FGoods>>(true, MessageConst.GMS_OPERATE_SUCCESS, list);
    }

    private boolean checkGoods(GoodsBaseInfo info)
    {
        // TODO 校验
        return true;
    }

    private FGoods convertToFGoods(GoodsBaseInfo info)
    {
        FGoods goods = null;
        if (info != null)
        {
            goods = new FGoods();
            goods.setGoodsId(info.getGoodsId());
            goods.setGoodsName(info.getGoodsName());
            goods.setShopId(info.getShopId());
            goods.setEntityId(info.getShopEntityId());
            goods.setBrandId(info.getGoodsBrand());
            goods.setCategoryLeafId(info.getGoodsCategoryLeaf());
            goods.setCategoryRootId(info.getGoodsCategoryRoot());
            goods.setGoodsSerial(info.getGoodsSerial());
            goods.setItemSerial(info.getItemSerial());
            goods.setPrice(String.valueOf(info.getPrice()));
            goods.setStatus(info.getPublishStatus());
            goods.setAuditNote(info.getAuditNote());

            if (org.springframework.util.StringUtils.hasText(info.getShopEntityId()))
            {
                ShopEntityInfo entityInfo = this.shopEntityInfoGeneratorQueryService.selectByPrimaryKey(info.getShopEntityId());
                if (entityInfo != null)
                {
                    goods.setEntityName(entityInfo.getShopEntityName());
                }
            }

            try
            {
                if ("P".equals(info.getPublishStatus()))
                {
                    goods.setMobileVisitUrl(UrlUtils.getGoodsUrl(info.getGoodsId()));
                    goods.setWebVisitUrl(UrlUtils.getGoodsUrl(info.getGoodsId()));
                }
            }
            catch (Exception e)
            {
                GooagooLog.error("获取商品移动地址或者web地址出现异常", e);
                e.printStackTrace();
            }
            goods.setBrandName("");
            goods.setCategoryLeafName("");

            GoodsBrandExample brandExample = new GoodsBrandExample();
            Criteria criteria = brandExample.createCriteria();
            criteria.andShopIdEqualTo(info.getShopId());
            criteria.andShopEntityIdEqualTo(info.getShopEntityId());
            criteria.andBrandIdEqualTo(info.getGoodsBrand());

            List<GoodsBrand> brands = this.brandQueryService.selectByExample(brandExample);
            if (brands != null)
            {
                if (brands.size() > 0)
                {
                    goods.setBrandName(brands.get(0).getBrandName());
                }
            }

            GoodsCategoryExample categoryExample = new GoodsCategoryExample();
            com.gooagoo.entity.generator.goods.GoodsCategoryExample.Criteria c = categoryExample.createCriteria();
            c.andShopIdEqualTo(info.getShopId());
            c.andShopEntityIdEqualTo(info.getShopEntityId());
            c.andCategoryIdEqualTo(info.getGoodsCategoryLeaf());
            List<GoodsCategory> categories = this.categoryQueryService.selectByExample(categoryExample);
            if (categories != null)
            {
                if (categories.size() > 0)
                {
                    goods.setCategoryLeafName(categories.get(0).getCategoryName());
                }
            }

            GoodsMarketingInfo marketingInfo = this.marketingQueryService.selectByPrimaryKey(info.getGoodsId());
            if (marketingInfo != null)
            {
                String goodsImg = this.jsonToString(marketingInfo.getGoodsImg());

                if (org.springframework.util.StringUtils.hasText(goodsImg))
                {
                    goodsImg = goodsImg.split(",")[0];
                    goods.setGoodsImg(goodsImg);
                }
            }
        }
        return goods;
    }

    private GoodsBaseInfo convertToGoodsBaseInfo(FGoods fgoods) throws IllegalArgumentException, IllegalAccessException
    {
        GoodsBaseInfo info = null;
        if (fgoods != null)
        {
            info = new GoodsBaseInfo();
            info.setGoodsId(fgoods.getGoodsId());
            info.setGoodsName(fgoods.getGoodsName());
            info.setGoodsSerial(fgoods.getGoodsSerial());
            info.setItemSerial(fgoods.getItemSerial());
            info.setGoodsBrand(fgoods.getBrandId());
            info.setGoodsCategoryRoot(fgoods.getCategoryRootId());
            info.setGoodsCategoryLeaf(fgoods.getCategoryLeafId());
            info.setShopEntityId(fgoods.getEntityId());
            info.setPublishStatus(fgoods.getStatus());
            info.setPrice(Double.parseDouble(fgoods.getPrice()));

            GoodsCategoryExample categoryExample = new GoodsCategoryExample();
            com.gooagoo.entity.generator.goods.GoodsCategoryExample.Criteria c = categoryExample.createCriteria();
            c.andShopIdEqualTo(fgoods.getShopId());
            c.andShopEntityIdEqualTo(fgoods.getEntityId());
            c.andCategoryIdEqualTo(fgoods.getCategoryLeafId());
            List<GoodsCategory> categories = this.categoryQueryService.selectByExample(categoryExample);
            if (categories != null)
            {
                if (categories.size() > 0)
                {
                    if (categories.get(0).getParentCategoryId().equals("-1"))
                    {
                        info.setGoodsCategoryRoot(fgoods.getCategoryLeafId());
                    }
                    else
                    {
                        info.setGoodsCategoryRoot(categories.get(0).getParentCategoryId());
                    }

                }
            }

        }
        return info;

    }

    private String jsonToString(String str)
    {
        if (!org.springframework.util.StringUtils.hasText(str))
        {
            return "";
        }
        Gson gson = new Gson();
        @SuppressWarnings("unchecked")
        List<String> list = gson.fromJson(str, List.class);
        String temp = "";
        for (String e : list)
        {
            temp += e + ",";
        }
        if (temp.length() > 0)
        {
            temp = temp.substring(0, temp.length() - 1);
        }
        return temp;
    }

    @Override
    public TransData<Object> publishGoods(HttpServletRequest request) throws Exception
    {
        String goodsId = ServletRequestUtils.getStringParameter(request, "goodsId", "");
        boolean flag = this.goodsCoreService.publishGoods(goodsId);
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, goodsId);
    }

    @Override
    public TransData<Object> reviewedGoods(HttpServletRequest request) throws Exception
    {
        String goodsId = ServletRequestUtils.getStringParameter(request, "goodsId", "");
        String status = ServletRequestUtils.getStringParameter(request, "status", "N");
        String note = ServletRequestUtils.getStringParameter(request, "note", "");

        boolean flag = this.goodsCoreService.reviewedActivity(goodsId, status, note);

        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, goodsId);
    }
}
