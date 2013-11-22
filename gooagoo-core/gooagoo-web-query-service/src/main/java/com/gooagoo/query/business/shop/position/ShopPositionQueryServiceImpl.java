package com.gooagoo.query.business.shop.position;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.shop.position.ShopPositionQueryService;
import com.gooagoo.api.business.query.statistics.ShopEntityPeopleStatisticsQueryService;
import com.gooagoo.api.generator.query.goods.GoodsBrandGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopPositionGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.business.shop.MainAreaBusiness;
import com.gooagoo.entity.business.shop.SubAreaBusiness;
import com.gooagoo.entity.business.shop.position.ShopUserPositionBusiness;
import com.gooagoo.entity.generator.goods.GoodsBrand;
import com.gooagoo.entity.generator.goods.GoodsBrandExample;
import com.gooagoo.entity.generator.shop.ShopPosition;
import com.gooagoo.entity.generator.shop.ShopPositionExample;
import com.gooagoo.entity.generator.shop.ShopPositionExample.Criteria;
import com.gooagoo.query.business.shop.cache.ShopEntityCacheQueryServiceImpl;

@Service
public class ShopPositionQueryServiceImpl implements ShopPositionQueryService
{
    @Autowired
    private ShopPositionGeneratorQueryService shopPositionGeneratorQueryService;

    @Autowired
    private ShopEntityPeopleStatisticsQueryService shopEntityPeopleStatisticsQueryService;

    @Autowired
    private GoodsBrandGeneratorQueryService goodsBrandGeneratorQueryService;

    @Autowired
    private ShopEntityCacheQueryServiceImpl shopEntityCacheQueryServiceImpl;

    @Override
    public List<ShopPosition> findShopPositionListByParent(String shopId, String shopEntityId, String parentId) throws Exception
    {
        List<ShopPosition> list = new ArrayList<ShopPosition>();
        this.treeShopPosition(list, shopId, shopEntityId, parentId);
        return list;
    }

    /**
     * 通过父节点迭代查询子节点,并将子节点添加到集合中
     * @param shopPositionList
     * @param parentId
     */
    private void treeShopPosition(List<ShopPosition> shopPositionList, String shopId, String shopEntityId, String parentId)
    {
        if (!StringUtils.hasText(parentId))
        {
            return;
        }
        ShopPositionExample shopPositionExample = new ShopPositionExample();
        shopPositionExample.createCriteria().andIsDelEqualTo("N").andShopIdEqualTo(shopId).andShopEntityIdEqualTo(shopEntityId).andParentPositionIdEqualTo(parentId);
        List<ShopPosition> list = this.shopPositionGeneratorQueryService.selectByExample(shopPositionExample);
        if (list == null)
        {
            return;
        }
        for (Iterator<ShopPosition> iterator = list.iterator(); iterator.hasNext();)
        {
            ShopPosition shopPosition = iterator.next();
            shopPositionList.add(shopPosition);
            this.treeShopPosition(shopPositionList, shopId, shopEntityId, shopPosition.getPositionId());
        }
    }

    @Override
    public List<MainAreaBusiness> findShopPositionNumberOfPeople(String shopEntityId, String positionId) throws Exception
    {
        List<MainAreaBusiness> mainAreaBusinessList = null;
        ShopPositionExample mainShopPositionExample = new ShopPositionExample();
        Criteria mainCriteria = mainShopPositionExample.createCriteria();
        if (StringUtils.hasText(positionId))
        {
            mainCriteria.andPositionIdEqualTo(positionId);
        }
        else
        {
            mainCriteria.andParentPositionIdEqualTo("-1");
        }
        mainCriteria.andShopEntityIdEqualTo(shopEntityId).andIsDelEqualTo("N");
        //主区域信息列表
        List<ShopPosition> mainShopPositionList = this.shopPositionGeneratorQueryService.selectByExample(mainShopPositionExample);
        if (CollectionUtils.isNotEmpty(mainShopPositionList))
        {
            mainAreaBusinessList = new ArrayList<MainAreaBusiness>();
            for (ShopPosition mainShopPosition : mainShopPositionList)
            {
                MainAreaBusiness mainAreaBusiness = new MainAreaBusiness();
                mainAreaBusiness.setStoreId(shopEntityId);//店铺编号
                mainAreaBusiness.setStoreAreaId(mainShopPosition.getPositionId());//主区域编号
                mainAreaBusiness.setStoreAreaName(mainShopPosition.getPositionName());//主区域名称
                Integer mainAreaCount = this.shopEntityPeopleStatisticsQueryService.findEntityAreaPeopleNum(mainShopPosition.getPositionId(), "A");
                mainAreaBusiness.setStoreAreaCount(mainAreaCount != null ? mainAreaCount.toString() : "0");//主区域人数
                List<SubAreaBusiness> subAreaBusinessList = null;
                ShopPositionExample subShopPositionExample = new ShopPositionExample();
                Criteria subCriteria = subShopPositionExample.createCriteria();
                subCriteria.andParentPositionIdEqualTo(mainShopPosition.getPositionId()).andShopEntityIdEqualTo(shopEntityId).andIsDelEqualTo("N");
                //子区域信息列表
                List<ShopPosition> subShopPositionList = this.shopPositionGeneratorQueryService.selectByExample(subShopPositionExample);
                if (CollectionUtils.isNotEmpty(subShopPositionList))
                {
                    subAreaBusinessList = new ArrayList<SubAreaBusiness>();
                    for (ShopPosition subShopPosition : subShopPositionList)
                    {
                        SubAreaBusiness subAreaBusiness = new SubAreaBusiness();
                        subAreaBusiness.setStoreSubAreaId(subShopPosition.getPositionId());//子区域编号
                        subAreaBusiness.setStoreSubAreaName(subShopPosition.getPositionName());//子区域名称
                        Integer subAreaCount = this.shopEntityPeopleStatisticsQueryService.findEntityAreaPeopleNum(subShopPosition.getPositionId(), "A");
                        subAreaBusiness.setStoreAreaCount(subAreaCount != null ? subAreaCount.toString() : "0");//子区域人数
                        subAreaBusinessList.add(subAreaBusiness);
                    }
                }
                mainAreaBusiness.setSubAreaBusinessList(subAreaBusinessList);//子区域列表
                mainAreaBusinessList.add(mainAreaBusiness);
            }
        }
        return mainAreaBusinessList;
    }

    /**
     * 有下列4中情况
     * 1.只有shopid,查询上级下各实体店主区域编号信息
     * 2.有shopid及shopentityid,无brandId,查询当前实体店的主区域编号
     * 3.有shopid及brandId,无shopentityid,查询shopid下各品牌对应的区域编号
     * 4.有shopid及brandId、shopentityid则查询实体店下品牌对应区域编号
     */
    @Override
    public List<ShopUserPositionBusiness> getPositionOfShopUser(String shopId, String shopEntityId, String brandId) throws Exception
    {

        //商家区域信息查询条件对象
        ShopPositionExample shopPositionExample = new ShopPositionExample();
        List<ShopPosition> shopPostionList = null;

        //品牌区域信息查询条件对象
        GoodsBrandExample goodsBrandExample = new GoodsBrandExample();
        List<GoodsBrand> goodsBrandList = null;

        if (StringUtils.hasText(shopId) && !StringUtils.hasText(shopEntityId) && !StringUtils.hasText(brandId))
        {
            //1.只有shopid,查询商家下各实体店主区域编号信息
            shopPositionExample.createCriteria().andShopIdEqualTo(shopId).andParentPositionIdEqualTo("-1").andIsDelEqualTo("N");
            shopPostionList = this.shopPositionGeneratorQueryService.selectByExample(shopPositionExample);
        }
        else if (StringUtils.hasText(shopId) && StringUtils.hasText(shopEntityId) && !StringUtils.hasText(brandId))
        {
            //2.有shopid及shopentityid,无brandId,查询当前实体店的主区域编号
            shopPositionExample.createCriteria().andShopIdEqualTo(shopId).andParentPositionIdEqualTo("-1").andShopEntityIdEqualTo(shopEntityId).andIsDelEqualTo("N");
            shopPostionList = this.shopPositionGeneratorQueryService.selectByExample(shopPositionExample);
        }
        else if (StringUtils.hasText(shopId) && !StringUtils.hasText(shopEntityId) && StringUtils.hasText(brandId))
        {
            //3.有shopid及brandId,无shopentityid,查询shopid下各品牌对应的区域编号
            goodsBrandExample.createCriteria().andShopIdEqualTo(shopId).andBrandIdEqualTo(brandId).andIsDelEqualTo("N");
            goodsBrandList = this.goodsBrandGeneratorQueryService.selectByExample(goodsBrandExample);
        }
        else if (StringUtils.hasText(shopId) && StringUtils.hasText(shopEntityId) && StringUtils.hasText(brandId))
        {
            //4.有shopid及brandId、shopentityid则查询实体店下品牌对应区域编号
            goodsBrandExample.createCriteria().andShopIdEqualTo(shopId).andShopEntityIdEqualTo(shopEntityId).andBrandIdEqualTo(brandId).andIsDelEqualTo("N");
            goodsBrandList = this.goodsBrandGeneratorQueryService.selectByExample(goodsBrandExample);
        }
        //封装查询数据
        List<ShopUserPositionBusiness> shopUserPositionBusinessList = this.packageShopUserPositionInfo(shopPostionList, goodsBrandList);
        if (CollectionUtils.isEmpty(shopUserPositionBusinessList))
        {
            GooagooLog.warn("未查询到店员所属区域信息【shopEntityId=" + shopEntityId + "shopId" + shopId + ",brandId=" + brandId + "】");
        }
        return shopUserPositionBusinessList;
    }

    /**
     * 封装店员所属区域信息
     * @param shopPostionList
     * @param goodsBrandList
     * @return
     */
    private List<ShopUserPositionBusiness> packageShopUserPositionInfo(List<ShopPosition> shopPostionList, List<GoodsBrand> goodsBrandList) throws Exception
    {
        List<ShopUserPositionBusiness> shopUserPositionBusinessList = null;
        if (CollectionUtils.isNotEmpty(shopPostionList))
        {
            shopUserPositionBusinessList = new ArrayList<ShopUserPositionBusiness>();
            for (ShopPosition shopPosition : shopPostionList)
            {
                ShopUserPositionBusiness shopUserPositionBusiness = new ShopUserPositionBusiness();
                shopUserPositionBusiness.setShopEntityId(shopPosition.getShopEntityId());
                Map<String, String> shopEntityInfoMap = this.shopEntityCacheQueryServiceImpl.findShopEntityInfo(shopPosition.getShopEntityId());
                shopUserPositionBusiness.setShopEntityName(shopEntityInfoMap.get("shopEntityName") != null ? shopEntityInfoMap.get("shopEntityName") : "");
                shopUserPositionBusiness.setPositionId(shopPosition.getPositionId());
                shopUserPositionBusinessList.add(shopUserPositionBusiness);
            }
        }
        else if (CollectionUtils.isNotEmpty(goodsBrandList))
        {
            shopUserPositionBusinessList = new ArrayList<ShopUserPositionBusiness>();
            for (GoodsBrand goodsBrand : goodsBrandList)
            {
                ShopUserPositionBusiness shopUserPositionBusiness = new ShopUserPositionBusiness();
                shopUserPositionBusiness.setShopEntityId(goodsBrand.getShopEntityId());
                Map<String, String> shopEntityInfoMap = this.shopEntityCacheQueryServiceImpl.findShopEntityInfo(goodsBrand.getShopEntityId());
                shopUserPositionBusiness.setShopEntityName(shopEntityInfoMap.get("shopEntityName") != null ? shopEntityInfoMap.get("shopEntityName") : "");
                shopUserPositionBusiness.setPositionId(goodsBrand.getPositionId());
                shopUserPositionBusinessList.add(shopUserPositionBusiness);
            }
        }
        return shopUserPositionBusinessList;
    }
}
