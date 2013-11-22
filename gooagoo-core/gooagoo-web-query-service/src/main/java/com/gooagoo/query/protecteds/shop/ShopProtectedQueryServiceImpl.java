package com.gooagoo.query.protecteds.shop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.generator.query.base.ShopTypeGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopEntityInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopEntityLinkGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopLidInfoGeneratorQueryService;
import com.gooagoo.api.protecteds.query.shop.ShopProtectedQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.common.utils.JsonUtils;
import com.gooagoo.common.utils.TimeUtils;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.entity.business.shop.ShopEntityInfoBusiness;
import com.gooagoo.entity.generator.base.ShopType;
import com.gooagoo.entity.generator.base.ShopTypeExample;
import com.gooagoo.entity.generator.shop.ShopEntityInfo;
import com.gooagoo.entity.generator.shop.ShopEntityInfoExample;
import com.gooagoo.entity.generator.shop.ShopEntityLink;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.shop.ShopInfoExample;
import com.gooagoo.entity.generator.shop.ShopLidInfo;
import com.gooagoo.redis.data.RedisDatabase;
import com.gooagoo.redis.data.RedisListDao;

@Service
public class ShopProtectedQueryServiceImpl implements ShopProtectedQueryService
{

    @Autowired
    private ShopEntityInfoGeneratorQueryService shopEntityInfoGeneratorQueryService;

    @Autowired
    private ShopLidInfoGeneratorQueryService shopLidInfoGeneratorQueryService;

    @Autowired
    private ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;
    @Autowired
    private ShopEntityLinkGeneratorQueryService shopEntityLinkGeneratorQueryService;

    @Autowired
    private ShopTypeGeneratorQueryService shopTypeGeneratorQueryService;

    @Override
    public String getShopEntity(String shopId, String lid)
    {
        //1、校验入参
        if (StringUtils.isBlank(shopId))
        {
            GooagooLog.info("定位实体店：商家编号（" + shopId + "）为空");
            return null;
        }
        //2、获取商家名下总店
        String shopEntityId = null;
        ShopEntityInfoExample queryCondition = new ShopEntityInfoExample();
        queryCondition.createCriteria().andShopIdEqualTo(shopId).andIsGeneralEqualTo("Y").andIsDelEqualTo("N");
        List<ShopEntityInfo> shopEntityInfoList = this.shopEntityInfoGeneratorQueryService.selectByExample(queryCondition);
        if (CollectionUtils.isNotEmpty(shopEntityInfoList))
        {
            shopEntityId = shopEntityInfoList.get(0).getShopEntityId();
        }
        //3、根据lid定位实体店
        if (StringUtils.isEmpty(lid) || lid.length() < 6)
        {
            return shopEntityId;
        }
        ShopLidInfo shopLidInfo = this.shopLidInfoGeneratorQueryService.selectByPrimaryKey(lid.substring(0, 6));
        if (shopLidInfo == null || "Y".equals(shopLidInfo) || !shopId.equals(shopLidInfo.getShopId()))
        {
            GooagooLog.info("定位实体店：商家（" + shopId + "）名下无LID（" + lid + "）");
            return shopEntityId;
        }

        return shopLidInfo.getShopEntityId();
    }

    @Override
    public void getShopTypeIdByRecursion(List<String> shopTypeIdList, String shoptypeId)
    {
        ShopTypeExample shopTypeExample = new ShopTypeExample();
        shopTypeExample.createCriteria().andParentShopTypeIdEqualTo(shoptypeId).andIsDelEqualTo("N");
        List<ShopType> shopTypeList = this.shopTypeGeneratorQueryService.selectByExample(shopTypeExample);
        if (CollectionUtils.isNotEmpty(shopTypeList))
        {
            for (ShopType shopType : shopTypeList)
            {
                shopTypeIdList.add(shopType.getShopTypeId().toString());
                this.getShopTypeIdByRecursion(shopTypeIdList, shopType.getShopTypeId().toString());
            }
        }
    }

    @Override
    public List<String> getShopIdByShopType(String shopTypeId)
    {
        //1.查询当前shopTypeId其下属商家类型
        List<String> shopTypeIdList = new ArrayList<String>();
        shopTypeIdList.add(shopTypeId);

        //递归查询shopTypeId其下属商家类型（包括本身）
        this.getShopTypeIdByRecursion(shopTypeIdList, shopTypeId);

        //2.根据查询出来的商家类型，查询其所属商家信息
        ShopInfoExample shopInfoExample = new ShopInfoExample();
        shopInfoExample.createCriteria().andShopTypeLeafIn(shopTypeIdList).andIsDelEqualTo("N");
        List<ShopInfo> shopInfoList = this.shopInfoGeneratorQueryService.selectByExample(shopInfoExample);

        //3.根据查询出来的商家信息，取出商家编号
        List<String> shopIdStrs = null;
        if (CollectionUtils.isNotEmpty(shopInfoList))
        {
            shopIdStrs = new ArrayList<String>();
            for (ShopInfo shopInfo : shopInfoList)
            {
                shopIdStrs.add(shopInfo.getShopId());
            }
        }

        return shopIdStrs;
    }

    @Override
    public List<Map<String, String>> findByType(String mac, String shopEntityId, String ctimestamp, String type)
    {
        List<Map<String, String>> resultList = null;
        RedisListDao redisListDao = new RedisListDao(RedisServerConstants.catering_servefood);
        if (StringUtils.isBlank(ctimestamp))
        {
            String key = mac + "_" + type;
            List<String> list = redisListDao.get(key);
            if (CollectionUtils.isNotEmpty(list))
            {
                resultList = new ArrayList<Map<String, String>>();
                String currentTime = TimeUtils.convertDateToString(new Date(), TimeUtils.FORMAT6);
                for (String json : list)
                {
                    Map<String, String> map = JsonUtils.json2Map(json);
                    map.put("ctimestamp", currentTime);
                    resultList.add(map);
                }
                RedisDatabase redisDatabase = new RedisDatabase(RedisServerConstants.catering_servefood);
                //删除redis数据
                redisDatabase.del(key);
                //记录上一次数据
                key += "_" + currentTime;
                redisListDao.set(key, list);
            }
        }
        else
        {
            String key = mac + "_" + type;
            List<String> list = redisListDao.get(key);
            if (CollectionUtils.isNotEmpty(list))
            {
                resultList = new ArrayList<Map<String, String>>();
                for (String json : list)
                {
                    Map<String, String> tempMap = JsonUtils.json2Map(json);
                    String cTimeStamp = tempMap.get("ctimestamp");
                    if (cTimeStamp != null && ctimestamp.compareTo(cTimeStamp) < 0)
                    {
                        resultList.add(JsonUtils.json2Map(json));
                    }
                }
            }
        }
        return resultList;
    }

    @Override
    public ShopEntityInfoBusiness getTheMainShopInfo(String shopId)
    {
        ShopEntityInfoExample shopEntityInfoExample = new ShopEntityInfoExample();
        shopEntityInfoExample.createCriteria().andShopIdEqualTo(shopId).andIsGeneralEqualTo("Y").andIsDelEqualTo("N");
        List<ShopEntityInfo> ShopEntityInfoList = this.shopEntityInfoGeneratorQueryService.selectByExample(shopEntityInfoExample);
        if (CollectionUtils.isNotEmpty(ShopEntityInfoList))
        {
            //实体店基本信息
            ShopEntityInfoBusiness shopEntityInfoBusiness = new ShopEntityInfoBusiness();
            shopEntityInfoBusiness.setShopEntityInfo(ShopEntityInfoList.get(0));
            //实体店联系方式
            ShopEntityLink shopEntityLink = this.shopEntityLinkGeneratorQueryService.selectUnDelByPrimaryKey(ShopEntityInfoList.get(0).getShopEntityId());
            shopEntityInfoBusiness.setShopEntityLink(shopEntityLink);
            return shopEntityInfoBusiness;
        }
        else
        {
            GooagooLog.warn("未查询到商家主店信息【shop_entity_info查询shopId=" + shopId + ",isGeneral=Y的实体店信息】");
            return null;
        }
    }
}
