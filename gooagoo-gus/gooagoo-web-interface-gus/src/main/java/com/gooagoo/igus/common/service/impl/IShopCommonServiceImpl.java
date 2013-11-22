package com.gooagoo.igus.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.ServletRequestUtils;

import com.gooagoo.api.business.query.marketing.recommend.RecommendQueryService;
import com.gooagoo.api.business.query.system.cms.SysCmsContentQueryService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.common.entity.TransData;
import com.gooagoo.common.gus.constants.Constants;
import com.gooagoo.common.gus.constants.InterGusConstants;
import com.gooagoo.common.gus.constants.MessageConst;
import com.gooagoo.common.gus.utils.FormatDataUtils;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.business.marketing.recommend.RecommendShop;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.shop.ShopInfoExample;
import com.gooagoo.entity.generator.shop.ShopInfoExample.Criteria;
import com.gooagoo.igus.common.service.IShopCommonService;
import com.gooagoo.igus.utils.MessageAnnotation;
import com.gooagoo.view.gus.web.common.URecommendShop;
import com.gooagoo.view.gus.web.common.UShopInfo;

@Service("iShopCommonService")
public class IShopCommonServiceImpl implements IShopCommonService
{

    @Autowired
    private ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;

    @Autowired
    private RecommendQueryService recommendQueryService;

    @Autowired
    private SysCmsContentQueryService sysCmsContentQueryService;

    @Override
    @MessageAnnotation(InterGusConstants.COMMON_SHOPCOMMON_GETRECOMMENDATIONSHOPLIST)
    public TransData<Object> getRecommendationShopList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String userId = ServletRequestUtils.getStringParameter(request, Constants.USER_LOGIN_USERID);
            Integer pageSize = ServletRequestUtils.getIntParameter(request, "pageSize");
            Integer pageIndex = ServletRequestUtils.getIntParameter(request, "pageIndex");
            //1、获取推荐商家列表
            List<RecommendShop> recommendShopList = this.recommendQueryService.recommendShop(userId, pageIndex, pageSize);
            if (CollectionUtils.isEmpty(recommendShopList))
            {
                GooagooLog.info("获取推荐商家列表：未获取到满足条件的推荐商家列表");
                return new TransData<Object>(true, MessageConst.COMMON_NOTESIST, null);
            }
            //2、组装返回数据
            List<URecommendShop> urecommendShopList = new ArrayList<URecommendShop>();
            for (RecommendShop recommendShop : recommendShopList)
            {
                try
                {
                    URecommendShop urecommendShop = new URecommendShop();
                    urecommendShop.setShopId(recommendShop.getShopId());
                    urecommendShop.setShopName(recommendShop.getShopName());
                    urecommendShop.setShopLogo(FormatDataUtils.formatImageInfo(recommendShop.getShopLogo()));
                    try
                    {
                        urecommendShop.setShopUrl(this.sysCmsContentQueryService.getCmsContentUrl(recommendShop.getShopId(), "W"));
                    }
                    catch (Exception e)
                    {
                        GooagooLog.error("获取推荐商家列表：获取手机虚拟商家、网站虚拟商家访问路径异常", e);
                    }
                    urecommendShop.setAttentionNum(recommendShop.getAttentionNum());
                    urecommendShop.setMemberNum(recommendShop.getMemberNum());
                    urecommendShop.setFullRate(recommendShop.getFullRate());
                    urecommendShop.setAttentionCardName(recommendShop.getAttentionCardName());
                    urecommendShop.setAttentionCardUrl(FormatDataUtils.formatCardImageInfo(recommendShop.getAttentionCardUrl()));
                    urecommendShop.setMemberCardName(recommendShop.getMemberCardName());
                    urecommendShop.setMemberCardUrl(FormatDataUtils.formatCardImageInfo(recommendShop.getMemberCardUrl()));
                    urecommendShopList.add(urecommendShop);
                }
                catch (Exception e)
                {
                    GooagooLog.error("获取推荐商家列表：组装单个商家信息异常", e);
                }
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, urecommendShopList);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取推荐商家列表：获取推荐商家异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

    @Override
    @MessageAnnotation(InterGusConstants.COMMON_SHOPCOMMON_GETSHOPLIST)
    public TransData<Object> getShopList(HttpServletRequest request)
    {
        TransData<Object> transData = null;
        try
        {
            String shopTypeRootId = ServletRequestUtils.getStringParameter(request, "shopTypeRootId");
            String shopTypeLeafId = ServletRequestUtils.getStringParameter(request, "shopTypeLeafId");
            //1、获取商家列表
            ShopInfoExample queryCondition = new ShopInfoExample();
            Criteria criteria = queryCondition.createCriteria();
            if (StringUtils.isNotBlank(shopTypeRootId))
            {
                criteria.andShopTypeRootEqualTo(shopTypeRootId);
            }
            if (StringUtils.isNotBlank(shopTypeLeafId))
            {
                criteria.andShopTypeLeafEqualTo(shopTypeLeafId);
            }
            criteria.andShopStatusEqualTo("U").andIsDelEqualTo("N");
            List<ShopInfo> shopInfoList = this.shopInfoGeneratorQueryService.selectByExample(queryCondition);
            if (CollectionUtils.isEmpty(shopInfoList))
            {
                GooagooLog.info("获取商家列表：未获取到满足条件的商家列表");
                return new TransData<Object>(true, MessageConst.COMMON_NOTESIST, null);
            }
            //2、组装数据
            List<UShopInfo> uShopInfoList = new ArrayList<UShopInfo>();
            for (ShopInfo shopInfo : shopInfoList)
            {
                UShopInfo uShopInfo = new UShopInfo();
                uShopInfo.setShopId(shopInfo.getShopId());
                uShopInfo.setShopName(shopInfo.getShopName());
                uShopInfoList.add(uShopInfo);
            }
            transData = new TransData<Object>(true, MessageConst.COMMON_SYS_LOAD_DATA_SUCCESS, uShopInfoList);
        }
        catch (Exception e)
        {
            GooagooLog.error("获取商家列表：获取商家列表异常", e);
            transData = new TransData<Object>(false, MessageConst.COMMON_SYS_LOAD_DATA_ERROR, null);
        }

        return transData;
    }

}
