package com.gooagoo.analysis.complement.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.analysis.complement.service.ComplementCommonService;
import com.gooagoo.analysis.entity.GoodsInfoRuleProperties;
import com.gooagoo.api.business.query.goods.cache.GoodsCacheQueryService;
import com.gooagoo.api.business.query.member.cache.MemberCacheQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.exception.GooagooException;

/**
 * 
 * @author YL
 *
 */
@Service
public class ComplementCommonServiceImpl implements ComplementCommonService
{

    @Autowired
    private MemberCacheQueryService memberCacheQueryService;

    @Autowired
    private GoodsCacheQueryService goodsCacheQueryService;

    @Override
    public String getMemberLevelRuleProperties(String userId, String shopId, String scardNo) throws Exception
    {
        if (StringUtils.hasText(scardNo))
        {
            return this.memberCacheQueryService.findMembeInfoByScardno(scardNo).get("cardId");
        }
        else if (StringUtils.hasText(userId) && StringUtils.hasText(shopId))
        {
            return this.memberCacheQueryService.findMembeInfo(userId, shopId).get("cardId");
        }
        return null;
    }

    @Override
    public GoodsInfoRuleProperties getGoodsInfoRuleProperties(List<String> goodsIdList, String type) throws Exception
    {
        if (CollectionUtils.isEmpty(goodsIdList))
        {
            return null;
        }
        GoodsInfoRuleProperties goodsInfoRuleProperties = new GoodsInfoRuleProperties();
        List<String> itemSerialList = new ArrayList<String>();
        List<String> categoryIdList = new ArrayList<String>();
        List<String> brandIdList = new ArrayList<String>();
        for (String goodsId : goodsIdList)
        {
            Map<String, String> goodsInfoMap = this.goodsCacheQueryService.findGoodsInfo(goodsId);
            if (goodsInfoMap == null)
            {
                GooagooLog.error("从缓存查询商品信息失败:goodsId：" + goodsId, null);
                throw new GooagooException("从缓存查询商品信息失败:goodsId：" + goodsId);
            }
            String shopEntityId = goodsInfoMap.get("shopEntityId");
            if (type.contains("1"))
            {
                itemSerialList.add(goodsInfoMap.get("itemSerial"));
            }
            if (type.contains("2"))
            {
                String categoryId = goodsInfoMap.get("categoryId");
                Map<String, String> categoryIdMap = this.goodsCacheQueryService.findGoodsCategory(shopEntityId, categoryId);
                if (categoryIdMap == null)
                {
                    GooagooLog.error("从缓存查询商品所属所有品类信息失败:categoryId：" + categoryId + ",shopEntityId:" + shopEntityId, null);
                    throw new GooagooException("从缓存查询商品所属所有品类信息失败:categoryId：" + categoryId + ",shopEntityId:" + shopEntityId);
                }
                for (Map.Entry<String, String> entry : categoryIdMap.entrySet())
                {
                    categoryIdList.add(entry.getKey());
                }
            }
            if (type.contains("3"))
            {
                brandIdList.add(goodsInfoMap.get("brandId"));
            }

        }
        goodsInfoRuleProperties.setBrandIdList(brandIdList);
        goodsInfoRuleProperties.setCategoryIdList(categoryIdList);
        goodsInfoRuleProperties.setItemSerialList(itemSerialList);
        return goodsInfoRuleProperties;
    }

}
