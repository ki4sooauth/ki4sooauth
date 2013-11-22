package com.gooagoo.igms.good.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.goods.manage.GoodsCoreService;
import com.gooagoo.api.generator.query.goods.GoodsFeatureInfoGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.StringUtils;
import com.gooagoo.entity.generator.goods.GoodsFeatureInfo;
import com.gooagoo.entity.generator.goods.GoodsFeatureInfoExample;
import com.gooagoo.entity.generator.goods.GoodsFeatureInfoExample.Criteria;
import com.gooagoo.igms.good.service.IGoodsSpecialService;
import com.gooagoo.view.gms.good.FGoodsSpecial;

@Service(value = "igoodsSpecialService")
public class IGoodsSpecialServiceImpl implements IGoodsSpecialService
{

    @Autowired
    private GoodsCoreService featureInfoCoreService;
    @Autowired
    private GoodsFeatureInfoGeneratorQueryService featureInfoQueryService;

    @Override
    public TransData<String> addGoodsSpecialInfo(HttpServletRequest request) throws Exception
    {
        String id = StringUtils.getUUID();
        GoodsFeatureInfo goodsFeatureInfo = ServletUtils.objectMethod(GoodsFeatureInfo.class, request);
        goodsFeatureInfo.setIsDel("N");
        goodsFeatureInfo.setCreateTime(new Date());
        goodsFeatureInfo.setId(id);
        boolean result = this.checkFeatureInfo(goodsFeatureInfo);
        if (result)
        {
            result = this.featureInfoCoreService.addGoodsFeatureInfo(goodsFeatureInfo);
        }
        return GMSUtil.getBooleanAndExtendResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, id, id);
    }

    @Override
    public TransData<Object> delGoodsSpecialInfo(HttpServletRequest request) throws Exception
    {

        String id = ServletRequestUtils.getStringParameter(request, "id", "");
        boolean flag = false;
        if (id.length() == 32)
        {
            flag = this.featureInfoCoreService.deleteGoodsFeatureInfo(id);
        }
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, id);
    }

    @Override
    public TransData<Object> updateGoodsSpecialInfo(HttpServletRequest request) throws Exception
    {
        GoodsFeatureInfo goodsFeatureInfo = ServletUtils.objectMethod(GoodsFeatureInfo.class, request);
        boolean result = this.checkFeatureInfo(goodsFeatureInfo);
        if (result)
        {
            result = this.featureInfoCoreService.updateGoodsFeatureInfo(goodsFeatureInfo);
        }
        return GMSUtil.getBooleanResult(result, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, goodsFeatureInfo.getId());
    }

    @Override
    public TransData<FGoodsSpecial> getGoodsSpecialInfo(HttpServletRequest request) throws Exception
    {

        String id = ServletRequestUtils.getStringParameter(request, "id", "");
        boolean flag = false;
        GoodsFeatureInfo goodsFeatureInfo = null;
        if (id.length() == 32)
        {
            goodsFeatureInfo = this.featureInfoQueryService.selectByPrimaryKey(id);
            if (goodsFeatureInfo != null)
            {
                flag = true;
            }
        }

        if (flag)
        {
            FGoodsSpecial goodsSpecial = this.convertToFGoodsSpecial(goodsFeatureInfo);
            return new TransData<FGoodsSpecial>(true, MessageConst.GMS_OPERATE_SUCCESS, goodsSpecial, id);
        }
        else
        {
            return new TransData<FGoodsSpecial>(false, MessageConst.GMS_OPERATE_FAIL, null);
        }
    }

    @Override
    public TransData<List<FGoodsSpecial>> getGoodsSpecialInfoList(HttpServletRequest request) throws Exception
    {
        String goodsId = ServletRequestUtils.getStringParameter(request, "goodsId", "");
        GoodsFeatureInfoExample example = new GoodsFeatureInfoExample();
        Criteria criteria = example.createCriteria();
        criteria.andGoodsIdEqualTo(goodsId);
        criteria.andIsDelEqualTo(GMSConstant.NO);

        List<GoodsFeatureInfo> list = this.featureInfoQueryService.selectByExample(example);
        if (list == null)
        {
            return new TransData<List<FGoodsSpecial>>(false, MessageConst.GMS_OPERATE_FAIL, null);
        }

        List<FGoodsSpecial> specials = new ArrayList<FGoodsSpecial>();
        for (int i = 0; i < list.size(); i++)
        {
            FGoodsSpecial special = this.convertToFGoodsSpecial(list.get(i));
            specials.add(special);
        }

        return new TransData<List<FGoodsSpecial>>(true, MessageConst.GMS_OPERATE_SUCCESS, specials);
    }

    private boolean checkFeatureInfo(GoodsFeatureInfo featureInfo)
    {
        // TODO 校验
        return true;
    }

    private FGoodsSpecial convertToFGoodsSpecial(GoodsFeatureInfo featureInfo)
    {
        FGoodsSpecial special = null;
        if (featureInfo != null)
        {
            special = new FGoodsSpecial();
            special.setFeatureCode(featureInfo.getFeatureCode());
            special.setFeatureName(featureInfo.getFeatureName());
            special.setFeatureValue(featureInfo.getFeatureValue());
            special.setGoodsId(featureInfo.getGoodsId());
            special.setGoodsName(featureInfo.getGoodsName());
            special.setId(featureInfo.getId());
            special.setShopId(featureInfo.getShopId());
        }
        return special;
    }
}
