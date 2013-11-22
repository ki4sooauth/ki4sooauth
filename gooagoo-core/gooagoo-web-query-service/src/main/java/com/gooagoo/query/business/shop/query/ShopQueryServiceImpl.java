package com.gooagoo.query.business.shop.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.business.query.shop.auth.ShopAuthorityQueryService;
import com.gooagoo.api.business.query.shop.query.ShopQueryService;
import com.gooagoo.api.generator.query.base.ShopInterfaceNameGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsBaseInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.goods.GoodsMarketingInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopEntityInfoGeneratorQueryService;
import com.gooagoo.api.generator.query.shop.ShopInfoGeneratorQueryService;
import com.gooagoo.common.log.GooagooLog;
import com.gooagoo.entity.business.goods.ShopGoodsDetailInfo;
import com.gooagoo.entity.casclient.shop.ShopAndUserInfo;
import com.gooagoo.entity.casclient.shop.ShopAuth;
import com.gooagoo.entity.casclient.shop.ShopLoginInfo;
import com.gooagoo.entity.generator.base.ShopInterfaceName;
import com.gooagoo.entity.generator.base.ShopInterfaceNameExample;
import com.gooagoo.entity.generator.goods.GoodsBaseInfo;
import com.gooagoo.entity.generator.goods.GoodsBaseInfoExample;
import com.gooagoo.entity.generator.goods.GoodsBaseInfoExample.Criteria;
import com.gooagoo.entity.generator.goods.GoodsMarketingInfo;
import com.gooagoo.entity.generator.shop.ShopEntityInfo;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.shop.ShopUserInfo;

@Service
public class ShopQueryServiceImpl implements ShopQueryService
{
    @Autowired
    private ShopAuthorityQueryService shopAuthorityQueryService;
    @Autowired
    private ShopInterfaceNameGeneratorQueryService shopInterfaceNameGeneratorQueryService;
    @Autowired
    private ShopInfoGeneratorQueryService shopInfoGeneratorQueryService;
    @Autowired
    private ShopEntityInfoGeneratorQueryService shopEntityInfoGeneratorQueryService;
    @Autowired
    private GoodsBaseInfoGeneratorQueryService goodsBaseInfoGeneratorQueryService;
    @Autowired
    private GoodsMarketingInfoGeneratorQueryService goodsMarketingInfoGeneratorQueryService;

    @Override
    public void findShopInfo(String shopId) throws Exception
    {
        // TODO Auto-generated method stub

    }

    @Override
    public ShopLoginInfo getShopLoginInfo(ShopInfo shopInfo, ShopUserInfo shopUserInfo)
    {
        if (shopInfo == null)
        {
            GooagooLog.info("获取商家详情（登录）:ShopInfo为空");
            return null;
        }
        if (shopUserInfo == null)
        {
            GooagooLog.info("获取商家详情（登录）:ShopUserInfo为空");
            return null;
        }

        //获取商家营销平台页面文字字典表
        String version = this.getInterfaceNameVersion(shopInfo.getShopTypeRoot());
        Map<String, String> shopInterfaceNameMap = this.getShopInterfaceNamesByShopType(version);
        //获取商家用户权限
        List<ShopAuth> shopUserAuthorities = this.shopAuthorityQueryService.getShopUserLoginAuthorities(shopUserInfo.getShopId(), shopUserInfo.getUserId(), shopUserInfo.getIsShopAccount());

        ShopLoginInfo shopLoginInfo = new ShopLoginInfo();
        shopLoginInfo.setShopAndUserInfo(this.getShopAndUserInfo(shopInfo, shopUserInfo));
        shopLoginInfo.setShopAuthList(shopUserAuthorities);
        shopLoginInfo.setWordNames(shopInterfaceNameMap);

        return shopLoginInfo;
    }

    @Override
    public Map<String, String> getShopInterfaceNamesByShopType(String version)
    {
        Map<String, String> map = new HashMap<String, String>();

        ShopInterfaceNameExample shopInterfaceNameExample = new ShopInterfaceNameExample();
        shopInterfaceNameExample.createCriteria().andIsDelEqualTo("N").andVersionEqualTo(version);
        List<ShopInterfaceName> shopInterfaceNameList = this.shopInterfaceNameGeneratorQueryService.selectByExample(shopInterfaceNameExample);

        //没有取默认版
        if (shopInterfaceNameList == null || shopInterfaceNameList.size() < 1)
        {
            shopInterfaceNameExample = new ShopInterfaceNameExample();
            shopInterfaceNameExample.createCriteria().andIsDelEqualTo("N").andVersionEqualTo("0");
            shopInterfaceNameList = this.shopInterfaceNameGeneratorQueryService.selectByExample(shopInterfaceNameExample);
        }
        if (shopInterfaceNameList == null)
        {
            return map;
        }
        for (Iterator<ShopInterfaceName> iterator = shopInterfaceNameList.iterator(); iterator.hasNext();)
        {
            ShopInterfaceName shopInterfaceName = iterator.next();
            map.put(shopInterfaceName.getNameCode(), shopInterfaceName.getNameValue());
        }
        return map;
    }

    /**
     * 根据商家类型获取界面文字字典版本
     * @param shopType
     * @return
     */
    private String getInterfaceNameVersion(Integer shopType)
    {
        String version = "0";
        if (shopType == 1)
        {
            version = "1";
        }
        else if (shopType == 4)
        {
            version = "3";
        }

        return version;
    }

    /**
     * 获取商家用户信息对象
     * @param shopInfo
     * @param shopUserInfo
     * @return
     */
    private ShopAndUserInfo getShopAndUserInfo(ShopInfo shopInfo, ShopUserInfo shopUserInfo)
    {
        //商家信息
        ShopAndUserInfo shopAndUserInfo = new ShopAndUserInfo();
        shopAndUserInfo.setShopEmail(shopInfo.getEmail());
        shopAndUserInfo.setShopId(shopInfo.getShopId());
        shopAndUserInfo.setShopIsChain(shopInfo.getIsChain());
        shopAndUserInfo.setShopLogo1(shopInfo.getLogo1());
        shopAndUserInfo.setShopLogo2(shopInfo.getLogo2());
        shopAndUserInfo.setShopLogo3(shopInfo.getLogo3());
        shopAndUserInfo.setShopName(shopInfo.getShopName());
        shopAndUserInfo.setShopNickName(shopInfo.getNickName());
        shopAndUserInfo.setShopNote(shopInfo.getNote());
        shopAndUserInfo.setShopScope(shopInfo.getScope());
        shopAndUserInfo.setShopServiceStyle(shopInfo.getServiceStyle());
        shopAndUserInfo.setShopStatus(shopInfo.getShopStatus());
        shopAndUserInfo.setShopTypeLeaf(shopInfo.getShopTypeLeaf());
        shopAndUserInfo.setShopTypeRoot(shopInfo.getShopTypeRoot());
        //店员信息
        shopAndUserInfo.setUserBirthday(shopUserInfo.getBirthday());
        shopAndUserInfo.setUserBrand(shopUserInfo.getBrand());
        shopAndUserInfo.setUserId(shopUserInfo.getUserId());
        shopAndUserInfo.setUserIdNo(shopUserInfo.getIdNo());
        shopAndUserInfo.setUserIdType(shopUserInfo.getIdType());
        shopAndUserInfo.setUserIsShopAccount(shopUserInfo.getIsShopAccount());
        shopAndUserInfo.setUserName(shopUserInfo.getName());
        shopAndUserInfo.setUserPassword(shopUserInfo.getPassword());
        shopAndUserInfo.setUserSex(shopUserInfo.getSex());
        shopAndUserInfo.setUserShopEntityId(shopUserInfo.getShopEntityId());
        shopAndUserInfo.setUserStatus(shopUserInfo.getStatus());
        shopAndUserInfo.setUserHeadImg(shopUserInfo.getHeadImg());

        return shopAndUserInfo;
    }

    @Override
    public boolean checkShopStatus(String shopId, String shopEntityId)
    {
        //效验商家是否存在,正常营业
        if (StringUtils.hasText(shopId))
        {
            ShopInfo shopInfo = this.shopInfoGeneratorQueryService.selectUnDelByPrimaryKey(shopId);
            if (shopInfo == null)
            {
                GooagooLog.warn("shopId=" + shopId + "商家不存在");
                return false;
            }
            if (!"U".equals(shopInfo.getShopStatus()))
            {
                GooagooLog.warn("shopId=" + shopId + "商家状态非正常营业");
                return false;
            }
        }
        //效验实体店是否存在
        if (StringUtils.hasText(shopEntityId))
        {
            ShopEntityInfo shopEntityInfo = this.shopEntityInfoGeneratorQueryService.selectUnDelByPrimaryKey(shopEntityId);
            if (shopEntityInfo == null)
            {
                GooagooLog.warn("shopEntityInfo=" + shopEntityInfo + "实体店不存在");
                return false;
            }
        }
        return true;
    }

    @Override
    public List<ShopGoodsDetailInfo> pageShopGoodsDetailInfo(String shopId, String shopEntityId, String goodsItemSerial, String goodsName, String goodsBrand, String goodsCategory, Integer pageIndex, Integer pageSize)
    {
        List<ShopGoodsDetailInfo> shopGoodsDetailInfoList = null;
        GoodsBaseInfoExample goodsBaseInfoExample = new GoodsBaseInfoExample();
        Criteria criteria = goodsBaseInfoExample.createCriteria();
        criteria.andShopIdEqualTo(shopId).andIsDelEqualTo("N");
        if (StringUtils.hasText(shopEntityId))
        {
            criteria.andShopEntityIdEqualTo(shopEntityId);
        }
        if (StringUtils.hasText(goodsItemSerial))
        {
            criteria.andItemSerialEqualTo(goodsItemSerial);
        }
        if (StringUtils.hasText(goodsName))
        {
            criteria.andGoodsNameLike("%" + goodsName + "%");
        }
        if (StringUtils.hasText(goodsBrand))
        {
            criteria.andGoodsBrandEqualTo(goodsBrand);
        }
        if (StringUtils.hasText(goodsCategory))
        {
            criteria.andGoodsCategoryLeafEqualTo(goodsCategory);
        }
        goodsBaseInfoExample.setPage(pageIndex, pageSize);
        List<GoodsBaseInfo> goodsBaseInfoList = this.goodsBaseInfoGeneratorQueryService.selectByExample(goodsBaseInfoExample);
        if (CollectionUtils.isNotEmpty(goodsBaseInfoList))
        {
            shopGoodsDetailInfoList = new ArrayList<ShopGoodsDetailInfo>();
            for (GoodsBaseInfo goodsBaseInfo : goodsBaseInfoList)
            {
                ShopGoodsDetailInfo shopGoodsDetailInfo = new ShopGoodsDetailInfo();
                shopGoodsDetailInfo.setGoodsBaseInfo(goodsBaseInfo);//商品基本信息
                GoodsMarketingInfo goodsMarketingInfo = this.goodsMarketingInfoGeneratorQueryService.selectUnDelByPrimaryKey(goodsBaseInfo.getGoodsId());
                shopGoodsDetailInfo.setGoodsMarketingInfo(goodsMarketingInfo);//商品营销信息
                shopGoodsDetailInfoList.add(shopGoodsDetailInfo);
            }
        }
        return shopGoodsDetailInfoList;
    }

    @Override
    public Integer countShopGoodsDetailInfo(String shopId, String shopEntityId, String goodsItemSerial, String goodsName, String goodsBrand, String goodsCategory, Integer pageIndex, Integer pageSize)
    {
        GoodsBaseInfoExample goodsBaseInfoExample = new GoodsBaseInfoExample();
        Criteria criteria = goodsBaseInfoExample.createCriteria();
        criteria.andShopIdEqualTo(shopId).andIsDelEqualTo("N");
        if (StringUtils.hasText(shopEntityId))
        {
            criteria.andShopEntityIdEqualTo(shopEntityId);
        }
        if (StringUtils.hasText(goodsItemSerial))
        {
            criteria.andItemSerialEqualTo(goodsItemSerial);
        }
        if (StringUtils.hasText(goodsName))
        {
            criteria.andGoodsNameLike("%" + goodsName + "%");
        }
        if (StringUtils.hasText(goodsBrand))
        {
            criteria.andGoodsBrandEqualTo(goodsBrand);
        }
        if (StringUtils.hasText(goodsCategory))
        {
            criteria.andGoodsCategoryLeafEqualTo(goodsCategory);
        }
        return this.goodsBaseInfoGeneratorQueryService.countByExample(goodsBaseInfoExample);
    }
}
