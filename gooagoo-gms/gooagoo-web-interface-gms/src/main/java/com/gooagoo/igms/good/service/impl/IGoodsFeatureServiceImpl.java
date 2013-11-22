package com.gooagoo.igms.good.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.goods.manage.GoodsFeatureCoreService;
import com.gooagoo.api.generator.query.goods.GoodsFeatureGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.StringUtils;
import com.gooagoo.entity.generator.goods.GoodsFeature;
import com.gooagoo.entity.generator.goods.GoodsFeatureExample;
import com.gooagoo.entity.generator.goods.GoodsFeatureExample.Criteria;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.good.service.IGoodsFeatureService;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.good.FGoodsFeature;

@Service("goodsFeatureService")
public class IGoodsFeatureServiceImpl implements IGoodsFeatureService
{

    @Autowired
    private GoodsFeatureCoreService featureCoreService;
    @Autowired
    private GoodsFeatureGeneratorQueryService featureQueryService;

    @Override
    public TransData<String> addGoodsFeature(HttpServletRequest request) throws Exception
    {
        String id = StringUtils.getUUID();
        GoodsFeature goodsFeature = ServletUtils.objectMethod(GoodsFeature.class, request);
        goodsFeature.setId(id);
        goodsFeature.setShopId(GmsInterfaceUtil.getShopIdByInterface(request));
        goodsFeature.setIsDel("N");
        goodsFeature.setCreateTime(new Date());

        boolean flag = this.checkFeature(goodsFeature);
        if (flag)
        {
            flag = this.featureCoreService.addGoodsFeature(goodsFeature);
        }
        return GMSUtil.getBooleanAndExtendResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, id, id);
    }

    @Override
    public TransData<Object> delGoodsFeature(HttpServletRequest request) throws Exception
    {
        String id = ServletRequestUtils.getStringParameter(request, "id", "");
        boolean flag = false;
        if (id.length() == 32)
        {
            flag = this.featureCoreService.deleteGoodsFeature(id);
        }
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, id);
    }

    @Override
    public TransData<Object> updateGoodsFeature(HttpServletRequest request) throws Exception
    {
        GoodsFeature goodsFeature = ServletUtils.objectMethod(GoodsFeature.class, request);
        boolean flag = this.checkFeature(goodsFeature);
        if (flag)
        {
            flag = this.featureCoreService.updateGoodsFeature(goodsFeature);
        }
        return GMSUtil.getBooleanResult(flag, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL, goodsFeature.getId());
    }

    @Override
    public TransData<FGoodsFeature> getGoodsFeature(HttpServletRequest request) throws Exception
    {
        String id = ServletRequestUtils.getStringParameter(request, "id", "");
        boolean flag = false;
        GoodsFeature goodsFeature = null;
        if (id.length() == 32)
        {
            goodsFeature = this.featureQueryService.selectByPrimaryKey(id);
            if (goodsFeature != null)
            {
                flag = true;
            }
        }
        if (flag)
        {
            FGoodsFeature feature = this.convertToFGoodsFeature(goodsFeature);
            return new TransData<FGoodsFeature>(true, MessageConst.GMS_OPERATE_SUCCESS, feature, id);
        }
        else
        {
            return new TransData<FGoodsFeature>(false, MessageConst.GMS_OPERATE_FAIL, null);
        }
    }

    @Override
    public TransData<PageModel<FGoodsFeature>> getGoodsFeatureList(HttpServletRequest request) throws Exception
    {
        String code = ServletRequestUtils.getStringParameter(request, "code", "");
        String goodsSerial = ServletRequestUtils.getStringParameter(request, "goodsSerial", "");
        GoodsFeatureExample example = new GoodsFeatureExample();
        Criteria criteria = example.createCriteria();
        criteria.andShopIdEqualTo(GmsInterfaceUtil.getShopIdByInterface(request));
        criteria.andIsDelEqualTo(GMSConstant.NO);
        if (org.springframework.util.StringUtils.hasText(code))
        {
            criteria.andTypeCodeLike("%" + code + "%");
        }
        if (org.springframework.util.StringUtils.hasText(goodsSerial))
        {
            criteria.andGoodsSerialLike("%" + goodsSerial + "%");
        }
        int count = this.featureQueryService.countByExample(example);

        int pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex", 1);
        int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 10);
        String orderBy = ServletRequestUtils.getStringParameter(request, "orderBy", "");

        example.setPage(pageIndex, pageSize);
        if (!orderBy.isEmpty())
        {
            example.setOrderByClause(orderBy);
        }

        List<GoodsFeature> list = this.featureQueryService.selectByExample(example);

        if (list == null)
        {
            return new TransData<PageModel<FGoodsFeature>>(false, MessageConst.GMS_OPERATE_FAIL, null);
        }
        List<FGoodsFeature> features = new ArrayList<FGoodsFeature>();
        for (int i = 0; i < list.size(); i++)
        {
            FGoodsFeature f = this.convertToFGoodsFeature(list.get(i));
            features.add(f);
        }

        PageModel<FGoodsFeature> pm = new PageModel<FGoodsFeature>();
        pm.setCount(count);
        pm.setPageIndex(pageIndex);
        pm.setPageSize(pageSize);
        pm.setResult(features);

        return new TransData<PageModel<FGoodsFeature>>(true, MessageConst.GMS_OPERATE_SUCCESS, pm);
    }

    private boolean checkFeature(GoodsFeature feature)
    {
        // TODO 校验
        return true;
    }

    private FGoodsFeature convertToFGoodsFeature(GoodsFeature feature)
    {
        FGoodsFeature gf = null;
        if (feature != null)
        {
            gf = new FGoodsFeature();
            gf.setId(feature.getId());
            gf.setShopId(feature.getShopId());
            gf.setCode(feature.getTypeCode());
            gf.setName(feature.getTypeName());
            gf.setValues(JsonUtils.json2List(feature.getEnumValue()));
            gf.setGoodsSerial(feature.getGoodsSerial());
            gf.setIsDisplay(feature.getIsDisplay());
        }
        return gf;
    }
}
