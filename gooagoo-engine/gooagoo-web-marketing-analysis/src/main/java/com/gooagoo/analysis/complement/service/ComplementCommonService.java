package com.gooagoo.analysis.complement.service;

import java.util.List;

import com.gooagoo.analysis.entity.GoodsInfoRuleProperties;

/**
 * 
 * @author YL
 *
 */
public interface ComplementCommonService
{

    /**
     * 获取会员等级规则属性
     * @param date
     * @return
     * @throws Exception
     */
    public String getMemberLevelRuleProperties(String userId, String shopId, String scardNo) throws Exception;

    /**
     * 获取商品、品牌、品类规则属性
     * @param date
     * @return
     * @throws Exception
     */
    public GoodsInfoRuleProperties getGoodsInfoRuleProperties(List<String> goodsIdList, String type) throws Exception;

}
