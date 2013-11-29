package com.gooagoo.core.business.shop.cache;

import java.util.HashMap;
import java.util.Map;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gooagoo.api.business.core.shop.cache.ShopCacheCoreService;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.dao.generator.base.ShopTypeMapper;
import com.gooagoo.dao.generator.shop.ShopInfoMapper;
import com.gooagoo.entity.generator.base.ShopType;
import com.gooagoo.entity.generator.base.ShopTypeKey;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.shop.ShopInfoKey;
import com.gooagoo.redis.data.RedisHashDao;

/**
 * 从缓存中查询商家用户相关信息
 */
@Service
public class ShopCacheCoreServiceImpl implements ShopCacheCoreService
{

    @Autowired
    ShopInfoMapper shopInfoMapper;
    @Autowired
    ShopTypeMapper shopTypeMapper;
    private static Cache dateCache;
    static
    {
        CacheManager manager = CacheManager.create();
        manager.addCache("dateCache");
        dateCache = manager.getCache("dateCache");
    }

    @Override
    public Map<String, String> findShopInfo(String shopId) throws Exception
    {
        RedisHashDao dao = new RedisHashDao(RedisServerConstants.business_shop);
        Map<String, String> result = dao.get(shopId);
        if (result == null || result.size() == 0)
        {
            result = this.init(shopId);
            dao.set(shopId, result);
        }
        return result;
    }

    private Map<String, String> init(String shopId)
    {
        Map<String, String> result = null;
        ShopInfoKey shopInfoKey = new ShopInfoKey();
        shopInfoKey.setShopId(shopId);
        ShopInfo shopInfo = this.shopInfoMapper.selectByPrimaryKey(shopInfoKey);
        if (shopInfo != null)
        {
            result = new HashMap<String, String>();
            ShopTypeKey rootKey = new ShopTypeKey();
            rootKey.setShopTypeId(shopInfo.getShopTypeRoot());
            ShopType root = this.shopTypeMapper.selectByPrimaryKey(rootKey);
            ShopTypeKey leafKey = new ShopTypeKey();
            leafKey.setShopTypeId(shopInfo.getShopTypeLeaf());
            ShopType leaf = this.shopTypeMapper.selectByPrimaryKey(leafKey);
            result.put("email", shopInfo.getEmail()); //电子邮箱，唯一，字母、数字、下划线、@组成
            result.put("nickName", shopInfo.getNickName()); //昵称，默认为电子邮箱@之前的部分
            result.put("shopStatus", shopInfo.getShopStatus());//商家状态，参考通用字典表的shop_status    L-锁定，P-待营业，U-正常营业
            result.put("isChain", shopInfo.getIsChain());//是否连锁，Y-连锁，N-非连锁
            result.put("serviceStyle", shopInfo.getServiceStyle());//部署模式，参考通用字典表的service_style
            result.put("shopName", shopInfo.getShopName());//商家名称
            result.put("shopTypeRoot", shopInfo.getShopTypeRoot().toString());//商家类型（根节点）
            if (root != null)
            {
                result.put("shopTypeRootName", root.getShopTypeName());//商家类型（根节点）
            }
            if (leaf != null)
            {
                result.put("shopTypeLeafName", leaf.getShopTypeName());//商家类型（叶节点）
            }
            if (shopInfo.getShopTypeLeaf() != null)
            {
                result.put("shopTypeLeaf", shopInfo.getShopTypeLeaf().toString());//商家类型（叶节点）
            }
            result.put("logo1", shopInfo.getLogo1());
            result.put("logo2", shopInfo.getLogo2());
        }
        return result;
    }

    @Override
    public ShopType findShopCategory(String shopTypeId) throws Exception
    {
        Element readElement = dateCache.get(shopTypeId);
        if (readElement == null)
        {
            ShopTypeKey shopTypeKey = new ShopTypeKey();
            shopTypeKey.setShopTypeId(Integer.valueOf(shopTypeId));
            ShopType shopType = this.shopTypeMapper.selectByPrimaryKey(shopTypeKey);
            Element writeElement = new Element(shopTypeId, shopType);
            dateCache.put(writeElement);
            return shopType;
        }
        else
        {
            return (ShopType) readElement.getObjectValue();
        }
    }
}
