package com.gooagoo.igms.good.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.goods.manage.GoodsCoreService;
import com.gooagoo.api.generator.query.goods.GoodsMarketingInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopPositionGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfo;
import com.gooagoo.entity.generator.shop.ShopPosition;
import com.gooagoo.igms.good.service.IGoodsMarketingService;
import com.gooagoo.view.gms.good.FGoodsMarketing;
import com.google.gson.Gson;

@Service(value = "igoodsMarketingService")
public class IGoodsMarketingServiceImpl implements IGoodsMarketingService
{
    @Autowired
    private GoodsCoreService marketingCoreService;
    @Autowired
    private GoodsMarketingInfoGeneratorQueryService marketingQueryService;
    @Autowired
    private ShopPositionGeneratorQueryService positionQueryService;

    @Override
    public TransData<String> addGoodsMarkeringInfo(HttpServletRequest request) throws Exception
    {
        GoodsMarketingInfo goodsMarketingInfo = ServletUtils.objectMethod(GoodsMarketingInfo.class, request);

        Gson gson = new Gson();
        String jsonNull = gson.toJson(new ArrayList<String>());

        if (StringUtils.hasText(goodsMarketingInfo.getGoodsImg()))
        {
            String[] t = goodsMarketingInfo.getGoodsImg().split(",");
            List<String> list = new ArrayList<String>();
            for (String e : t)
            {
                list.add(e);
            }
            String json = gson.toJson(list);
            goodsMarketingInfo.setGoodsImg(json);
        }
        else
        {
            goodsMarketingInfo.setGoodsImg(jsonNull);
        }
        if (StringUtils.hasText(goodsMarketingInfo.getCrossGoods()))
        {
            String[] t = goodsMarketingInfo.getCrossGoods().split(",");
            List<String> list = new ArrayList<String>();
            for (String e : t)
            {
                list.add(e);
            }
            String json = gson.toJson(list);
            goodsMarketingInfo.setCrossGoods(json);
        }
        else
        {
            goodsMarketingInfo.setCrossGoods(jsonNull);
        }
        if (StringUtils.hasText(goodsMarketingInfo.getRelationGoods()))
        {
            String[] t = goodsMarketingInfo.getRelationGoods().split(",");
            List<String> list = new ArrayList<String>();
            for (String e : t)
            {
                list.add(e);
            }
            String json = gson.toJson(list);
            goodsMarketingInfo.setRelationGoods(json);
        }
        else
        {
            goodsMarketingInfo.setRelationGoods(jsonNull);
        }
        if (StringUtils.hasText(goodsMarketingInfo.getReplaceGoods()))
        {
            String[] t = goodsMarketingInfo.getReplaceGoods().split(",");
            List<String> list = new ArrayList<String>();
            for (String e : t)
            {
                list.add(e);
            }
            String json = gson.toJson(list);
            goodsMarketingInfo.setReplaceGoods(json);
        }
        else
        {
            goodsMarketingInfo.setReplaceGoods(jsonNull);
        }

        goodsMarketingInfo.setIsDel("N");
        goodsMarketingInfo.setCreateTime(new Date());
        boolean flag = this.checkMarketing(goodsMarketingInfo);
        if (flag)
        {
            flag = this.marketingCoreService.addGoodsMarketingInfo(goodsMarketingInfo);
        }
        return GMSUtil.getBooleanAndExtendResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, goodsMarketingInfo.getGoodsId(), goodsMarketingInfo.getGoodsId());
    }

    @Override
    @Deprecated
    public TransData<Object> delGoodsMarkeringInfo(HttpServletRequest request) throws Exception
    {
        return null;
    }

    @Override
    public TransData<Object> updateGoodsMarkeringInfo(HttpServletRequest request) throws Exception
    {
        GoodsMarketingInfo goodsMarketingInfo = ServletUtils.objectMethod(GoodsMarketingInfo.class, request);

        Gson gson = new Gson();
        String jsonNull = gson.toJson(new ArrayList<String>());

        if (StringUtils.hasText(goodsMarketingInfo.getGoodsImg()))
        {
            String[] t = goodsMarketingInfo.getGoodsImg().split(",");
            List<String> list = new ArrayList<String>();
            for (String e : t)
            {
                list.add(e);
            }
            String json = gson.toJson(list);
            goodsMarketingInfo.setGoodsImg(json);
        }
        else
        {
            goodsMarketingInfo.setGoodsImg(jsonNull);
        }
        if (StringUtils.hasText(goodsMarketingInfo.getCrossGoods()))
        {
            String[] t = goodsMarketingInfo.getCrossGoods().split(",");
            List<String> list = new ArrayList<String>();
            for (String e : t)
            {
                list.add(e);
            }
            String json = gson.toJson(list);
            goodsMarketingInfo.setCrossGoods(json);
        }
        else
        {
            goodsMarketingInfo.setCrossGoods(jsonNull);
        }
        if (StringUtils.hasText(goodsMarketingInfo.getRelationGoods()))
        {
            String[] t = goodsMarketingInfo.getRelationGoods().split(",");
            List<String> list = new ArrayList<String>();
            for (String e : t)
            {
                list.add(e);
            }
            String json = gson.toJson(list);
            goodsMarketingInfo.setRelationGoods(json);
        }
        else
        {
            goodsMarketingInfo.setRelationGoods(jsonNull);
        }
        if (StringUtils.hasText(goodsMarketingInfo.getReplaceGoods()))
        {
            String[] t = goodsMarketingInfo.getReplaceGoods().split(",");
            List<String> list = new ArrayList<String>();
            for (String e : t)
            {
                list.add(e);
            }
            String json = gson.toJson(list);
            goodsMarketingInfo.setReplaceGoods(json);
        }
        else
        {
            goodsMarketingInfo.setReplaceGoods(jsonNull);
        }

        boolean result = this.checkMarketing(goodsMarketingInfo);
        if (result)
        {
            result = this.marketingCoreService.updateGoodsMarketingInfo(goodsMarketingInfo);
        }
        return GMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, goodsMarketingInfo.getGoodsId());
    }

    @Override
    public TransData<FGoodsMarketing> getGoodsMarketingInfo(HttpServletRequest request) throws Exception
    {
        String goodsId = ServletRequestUtils.getStringParameter(request, "goodsId", "");

        boolean flag = false;
        GoodsMarketingInfo goodsMarketingInfo = null;
        if (goodsId.length() == 32)
        {
            goodsMarketingInfo = this.marketingQueryService.selectByPrimaryKey(goodsId);
            if (goodsMarketingInfo != null)
            {
                flag = true;
            }
        }
        if (flag)
        {
            FGoodsMarketing goodsMarketing = this.convertToFGoodsMarketing(goodsMarketingInfo);
            return new TransData<FGoodsMarketing>(true, MessageConst.GMS_OPERATE_SUCCESS, goodsMarketing, goodsId);
        }
        else
        {
            return new TransData<FGoodsMarketing>(false, MessageConst.GMS_OPERATE_FAIL, null);
        }
    }

    private boolean checkMarketing(GoodsMarketingInfo marketingInfo)
    {
        // TODO 校验
        return true;
    }

    private FGoodsMarketing convertToFGoodsMarketing(GoodsMarketingInfo info)
    {
        FGoodsMarketing marketing = null;
        if (info != null)
        {
            marketing = new FGoodsMarketing();
            marketing.setCrossGoods(this.jsonToString(info.getCrossGoods()));
            marketing.setGoodsContent(info.getGoodsContent());
            marketing.setGoodsId(info.getGoodsId());
            marketing.setGoodsSolution(info.getGoodsSolution());
            marketing.setPositionId(info.getPositionId());
            marketing.setRelationGoods(this.jsonToString(info.getRelationGoods()));
            marketing.setReplaceGoods(this.jsonToString(info.getReplaceGoods()));
            marketing.setShopEntityId(info.getShopEntityId());
            marketing.setShopId(info.getShopId());
            marketing.setVendor(info.getVendor());
            marketing.setUseType(info.getUseType());
            marketing.setLifeIdea(info.getLifeIdea());

            ShopPosition position = this.positionQueryService.selectByPrimaryKey(info.getPositionId());
            if (position != null)
            {
                marketing.setPositionName(position.getPositionName());
            }
            else
            {
                marketing.setPositionName("");
            }

            marketing.setFeature(info.getFeature());
            marketing.setAddress(info.getAddress());
            marketing.setCrowd(info.getCrowd());
            marketing.setUseMessage(info.getUseMessage());

            marketing.setGoodsImg(this.jsonToString(info.getGoodsImg()));
            String str[] = marketing.getGoodsImg().split(",");
            if (str.length < 1)
            {
                marketing.setMainImg("");
            }
            else
            {
                marketing.setMainImg(str[0]);
                List<String> list = new ArrayList<String>();
                for (int i = 1; i < str.length; i++)
                {
                    list.add(str[i]);
                }
                marketing.setSubImgs(list);
            }

        }
        return marketing;
    }

    @SuppressWarnings("unchecked")
    private String jsonToString(String str)
    {
        if (!org.springframework.util.StringUtils.hasText(str))
        {
            return "";
        }
        Gson gson = new Gson();
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
}
