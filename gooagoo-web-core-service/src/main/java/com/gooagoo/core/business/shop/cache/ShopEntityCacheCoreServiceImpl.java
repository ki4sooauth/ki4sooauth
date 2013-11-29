package com.gooagoo.core.business.shop.cache;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.shop.cache.ShopEntityCacheCoreService;
import com.gooagoo.api.generator.core.shop.ShopEntityInfoGeneratorCoreService;
import com.gooagoo.api.generator.core.shop.ShopEntityLinkGeneratorCoreService;
import com.gooagoo.api.generator.core.shop.ShopGpsInfoGeneratorCoreService;
import com.gooagoo.common.utils.CollectionCoreUtils;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.generator.shop.ShopEntityInfo;
import com.gooagoo.entity.generator.shop.ShopEntityLink;
import com.gooagoo.entity.generator.shop.ShopGpsInfo;
import com.gooagoo.redis.data.RedisHashDao;

/**
 * 从缓存中查询实体店相关信息
 */
@Service
public class ShopEntityCacheCoreServiceImpl implements ShopEntityCacheCoreService
{

    @Autowired
    private ShopEntityInfoGeneratorCoreService shopEntityInfoGeneratorCoreService;
    @Autowired
    private ShopEntityLinkGeneratorCoreService shopEntityLinkGeneratorCoreService;
    @Autowired
    private ShopGpsInfoGeneratorCoreService shopGpsInfoGeneratorCoreService;

    @Override
    public Map<String, String> findShopEntityInfo(String shopEntityId) throws Exception
    {
        RedisHashDao dao = new RedisHashDao(RedisServerConstants.business_shop);
        Map<String, String> result = dao.get(shopEntityId);
        if (result == null || result.size() == 0)
        {
            result = this.init(shopEntityId);
            dao.set(shopEntityId, result);
        }
        return result;
    }

    private Map<String, String> init(String shopEntityId)
    {
        Map<String, String> result = null;
        ShopEntityInfo shopEntityInfo = this.shopEntityInfoGeneratorCoreService.selectByPrimaryKey(shopEntityId);
        if (shopEntityInfo != null)
        {
            result = new HashMap<String, String>();
            result.put("shopEntityName", shopEntityInfo.getShopEntityName());//实体店名称
            result.put("isGeneral", shopEntityInfo.getIsGeneral());//是否为总店，每个商家只允许有一家总店，Y-是，N-否
            result.put("shopId", shopEntityInfo.getShopId());//商家编号
            result.put("registeredNumber", shopEntityInfo.getRegisteredNumber());//注册号
            result.put("enterpriseName", shopEntityInfo.getEnterpriseName());//企业全称
            result.put("registeredCity", shopEntityInfo.getRegisteredCity());//注册城市，关联user_cityarea
            result.put("corporate", shopEntityInfo.getCorporate());//法人代表
            result.put("registeredCapital", shopEntityInfo.getRegisteredCapital());//注册资本
            result.put("businessLicense", shopEntityInfo.getBusinessLicense());//营业执照URL
            result.put("shopRoadGuide", shopEntityInfo.getShopRoadGuide());//交通指南
            ShopEntityLink shopEntityLink = this.shopEntityLinkGeneratorCoreService.selectByPrimaryKey(shopEntityId);
            if (shopEntityLink != null)
            {
                result.put("mobile", shopEntityLink.getMobile());//手机号码
                result.put("phone", shopEntityLink.getPhone());//联系电话
                result.put("postCode", shopEntityLink.getPostCode());//邮政编码
                result.put("province", shopEntityLink.getProvince());//省
                result.put("city", shopEntityLink.getCity());//市
                result.put("area", shopEntityLink.getArea());//区县
                result.put("address", shopEntityLink.getAddress());//详细地址
            }
            ShopGpsInfo shopGpsInfo = this.shopGpsInfoGeneratorCoreService.selectUnDelByPrimaryKey(shopEntityId);
            if (shopGpsInfo != null)
            {
                result.put("shopGpsBaidux", shopGpsInfo.getShopGpsBaidux());//GPS百度的X坐标
                result.put("shopGpsBaiduy", shopGpsInfo.getShopGpsBaiduy());//GPS百度的Y坐标
            }
        }
        CollectionCoreUtils.filterNullValue4Map(result);
        return result;
    }
}
