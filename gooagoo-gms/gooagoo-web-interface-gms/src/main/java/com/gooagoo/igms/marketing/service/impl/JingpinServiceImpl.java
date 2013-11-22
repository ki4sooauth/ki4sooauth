package com.gooagoo.igms.marketing.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.core.marketing.qualitygoods.QualityGoodsCoreService;
import com.gooagoo.api.generator.query.base.QualitySquareGoodsTypeGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsMarketingInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.marketing.MarketingQualityGoodsGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gms.constants.GMSConstant;
import com.gooagoo.common.gms.constants.MessageConst;
import com.gooagoo.common.gms.utils.GMSUtil;
import com.gooagoo.common.utils.EntityTools;
import com.gooagoo.common.utils.ServletUtils;
import com.gooagoo.common.utils.StringUtils;
import com.gooagoo.entity.generator.base.QualitySquareGoodsType;
import com.gooagoo.entity.generator.base.QualitySquareGoodsTypeExample;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfo;
import com.gooagoo.entity.generator.marketing.MarketingQualityGoods;
import com.gooagoo.entity.generator.marketing.MarketingQualityGoodsExample;
import com.gooagoo.entity.generator.marketing.MarketingQualityGoodsExample.Criteria;
import com.gooagoo.igms.common.utils.GmsInterfaceUtil;
import com.gooagoo.igms.marketing.service.JingpinService;
import com.gooagoo.view.gms.common.PageCondition;
import com.gooagoo.view.gms.common.PageModel;
import com.gooagoo.view.gms.marketing.FJingpin;
import com.gooagoo.view.gms.marketing.FJingpinType;
import com.google.gson.Gson;

@Service(value = "jingpinService")
public class JingpinServiceImpl implements JingpinService
{
    @Autowired
    private MarketingQualityGoodsGeneratorQueryService marketingQualityGoodsGeneratorQueryService;
    @Autowired
    private QualityGoodsCoreService qualityGoodsCoreService;

    @Autowired
    private GoodsBaseInfoGeneratorQueryService goodsBaseInfoGeneratorQueryService;
    @Autowired
    private QualitySquareGoodsTypeGeneratorQueryService qualitySquareGoodsTypeGeneratorQueryService;

    @Autowired
    private GoodsMarketingInfoGeneratorQueryService goodsMarketingInfoGeneratorQueryService;

    @Override
    public TransData<Object> add(HttpServletRequest request) throws Exception
    {
        FJingpin jingpin = ServletUtils.objectMethod(FJingpin.class, request);
        jingpin.setJingpinId(StringUtils.getUUID());
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);
        jingpin.setShopId(shopId);
        MarketingQualityGoods mqg = this.convertMarketingQualityGoods(jingpin);
        mqg.setCreateTime(new Date());
        boolean r = this.checkQualityGoods(mqg);
        if (r)
        {
            QualitySquareGoodsType e = this.qualitySquareGoodsTypeGeneratorQueryService.selectByPrimaryKey(mqg.getQualityTypeLeaf());
            if (e != null)
            {
                while (e.getParentGoodsTypeId() != -1)
                {
                    e = this.qualitySquareGoodsTypeGeneratorQueryService.selectByPrimaryKey(e.getParentGoodsTypeId());
                    if (e == null)
                    {
                        break;
                    }
                }
                if (e == null)
                {
                    mqg.setQualityTypeRoot(-1);
                }
                else
                {
                    mqg.setQualityTypeRoot(e.getGoodsTypeId());
                }
            }
            r = this.qualityGoodsCoreService.addQualityGood(mqg);
        }

        TransData<Object> data = GMSUtil.getBooleanResult(r, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);

        data.setData(mqg.getId());

        return data;
    }

    @Override
    public TransData<Object> update(HttpServletRequest request) throws Exception
    {
        FJingpin jingpin = ServletUtils.objectMethod(FJingpin.class, request);
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);
        jingpin.setShopId(shopId);

        MarketingQualityGoods mqg = this.convertMarketingQualityGoods(jingpin);
        boolean r = this.checkQualityGoods(mqg);
        if (r)
        {
            r = this.qualityGoodsCoreService.updateQualityGood(mqg);
        }

        return GMSUtil.getBooleanResult(r, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);
    }

    @Override
    public TransData<Object> delete(HttpServletRequest request) throws Exception
    {
        String id = ServletRequestUtils.getStringParameter(request, "id", "");
        boolean r = this.qualityGoodsCoreService.deleteQualityGood(id);
        return GMSUtil.getBooleanResult(r, MessageConst.GMS_OPERATE_SUCCESS, MessageConst.GMS_OPERATE_FAIL);
    }

    @Override
    public TransData<FJingpin> getJingpin(HttpServletRequest request) throws Exception
    {
        String id = ServletRequestUtils.getStringParameter(request, "id", "");

        MarketingQualityGoods mqg = this.marketingQualityGoodsGeneratorQueryService.selectByPrimaryKey(id);
        FJingpin fj = this.convertFJingpin(mqg);
        return new TransData<FJingpin>(true, MessageConst.GMS_OPERATE_SUCCESS, fj);
    }

    @Override
    public TransData<PageModel<FJingpin>> pageJingpin(HttpServletRequest request) throws Exception
    {
        String shopId = GmsInterfaceUtil.getShopIdByInterface(request);
        FJingpin jingpin = ServletUtils.objectMethod(FJingpin.class, request);
        jingpin.setShopId(shopId);
        PageCondition pc = ServletUtils.objectMethod(PageCondition.class, request);
        PageModel<FJingpin> pm = new PageModel<FJingpin>();
        pm.setPageIndex(pc.getPageIndex());
        pm.setPageSize(pc.getPageSize());

        MarketingQualityGoodsExample example = new MarketingQualityGoodsExample();
        example.setPage(pm.getIndex(), pm.getPageSize());
        example.setOrderByClause("c_time_stamp desc");

        Criteria criteria = example.createCriteria();
        criteria.andIsDelEqualTo(GMSConstant.NO);
        criteria.andShopIdEqualTo(shopId);
        int count = this.marketingQualityGoodsGeneratorQueryService.countByExample(example);
        pm.setCount(count);
        if (count > 0)
        {
            List<MarketingQualityGoods> list = this.marketingQualityGoodsGeneratorQueryService.selectByExample(example);
            for (MarketingQualityGoods m : list)
            {
                pm.getResult().add(this.convertFJingpin(m));
            }
        }
        return new TransData<PageModel<FJingpin>>(true, MessageConst.GMS_OPERATE_SUCCESS, pm);
    }

    @Override
    public TransData<List<FJingpinType>> getJingpinTypes(HttpServletRequest request) throws Exception
    {
        //        QualitySquareGoodsType type = new QualitySquareGoodsType();
        //        List<FJingpinType> types = new ArrayList<FJingpinType>();
        //        List<DicImageCache> list = QualitySquareGoodsTypeCache.getNext(String.valueOf(type));
        //        for (DicImageCache di : list)
        //        {
        //            type.setGoodsTypeId(Integer.valueOf(di.getId()));
        //            type.setGoodsTypeName(di.getName());
        //            types.add(this.convertToFJingpinType(type));
        //        }
        QualitySquareGoodsTypeExample example = new QualitySquareGoodsTypeExample();
        example.createCriteria().andIsDelEqualTo("N");
        List<QualitySquareGoodsType> list = this.qualitySquareGoodsTypeGeneratorQueryService.selectByExample(example);
        List<FJingpinType> types = new ArrayList<FJingpinType>();
        for (QualitySquareGoodsType type : list)
        {
            types.add(this.convertToFJingpinType(type));
        }

        return new TransData<List<FJingpinType>>(true, MessageConst.GMS_OPERATE_SUCCESS, types);
    }

    private FJingpin convertFJingpin(MarketingQualityGoods m) throws IllegalArgumentException, IllegalAccessException
    {
        FJingpin fj = null;
        if (m != null)
        {
            fj = new FJingpin();
            fj.setJingpinId(m.getId());
            fj.setJingpinTypeId(m.getQualityTypeLeaf());
            fj.setJingpinTypeRootId(m.getQualityTypeRoot());
            EntityTools.copyValue(m, fj);
            QualitySquareGoodsType qualitySquareGoodsType = this.qualitySquareGoodsTypeGeneratorQueryService.selectByPrimaryKey(m.getQualityTypeLeaf());
            if (qualitySquareGoodsType != null)
            {
                fj.setJingpinTypeName(qualitySquareGoodsType.getGoodsTypeName());
            }

            if (org.springframework.util.StringUtils.hasText(m.getGoodsId()))
            {

                GoodsBaseInfo goodsBaseInfo = this.goodsBaseInfoGeneratorQueryService.selectByPrimaryKey(m.getGoodsId());
                if (goodsBaseInfo != null)
                {
                    fj.setGoodsName(goodsBaseInfo.getGoodsName());
                }

                //有些地方需要用图片URL
                GoodsMarketingInfo gm = this.goodsMarketingInfoGeneratorQueryService.selectByPrimaryKey(m.getGoodsId());
                if (gm != null && org.springframework.util.StringUtils.hasText(gm.getGoodsImg()))
                {
                    List list = this.jsonToString(gm.getGoodsImg());
                    if (list.size() > 0)
                    {
                        fj.setImgUrl(String.valueOf(list.get(0)));
                    }
                }
            }
        }

        return fj;
    }

    private MarketingQualityGoods convertMarketingQualityGoods(FJingpin fjingpin) throws IllegalArgumentException, IllegalAccessException
    {
        MarketingQualityGoods m = null;
        if (fjingpin != null)
        {
            m = new MarketingQualityGoods();
            EntityTools.copyValue(fjingpin, m);
            m.setId(fjingpin.getJingpinId());
            m.setQualityTypeLeaf(fjingpin.getJingpinTypeId());
            m.setQualityTypeRoot(fjingpin.getJingpinTypeRootId());
            m.setCTimeStamp(new Date());
            m.setIsDel("N");
        }
        return m;
    }

    private FJingpinType convertToFJingpinType(QualitySquareGoodsType type) throws IllegalArgumentException, IllegalAccessException
    {
        FJingpinType types = null;
        if (type != null)
        {
            types = new FJingpinType();
            EntityTools.copyValue(type, types);
        }
        return types;
    }

    private boolean checkQualityGoods(MarketingQualityGoods mqg)
    {

        if (mqg == null)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(mqg.getId()) || mqg.getId().length() != 32)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(mqg.getGoodsId()) || mqg.getGoodsId().length() != 32)
        {
            return false;
        }
        if (org.apache.commons.lang.StringUtils.isBlank(String.valueOf(mqg.getQualityTypeLeaf())))
        {
            return false;
        }
        return true;
    }

    private List jsonToString(String str)
    {
        if (!org.springframework.util.StringUtils.hasText(str))
        {
            return null;
        }
        Gson gson = new Gson();
        List<String> list = gson.fromJson(str, List.class);

        return list;
    }
}
