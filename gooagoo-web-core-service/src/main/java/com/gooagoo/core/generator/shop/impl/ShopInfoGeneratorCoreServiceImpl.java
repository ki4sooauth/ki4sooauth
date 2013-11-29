package com.gooagoo.core.generator.shop.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.gooagoo.api.generator.core.shop.ShopInfoGeneratorCoreService;
import com.gooagoo.constants.RedisServerConstants;
import com.gooagoo.dao.generator.shop.ShopInfoMapper;
import com.gooagoo.entity.generator.shop.ShopInfo;
import com.gooagoo.entity.generator.shop.ShopInfoExample;
import com.gooagoo.entity.generator.shop.ShopInfoKey;
import com.gooagoo.redis.data.RedisDatabase;

@Service
public class ShopInfoGeneratorCoreServiceImpl implements ShopInfoGeneratorCoreService
{

    @Autowired
    private ShopInfoMapper shopInfoMapper;

    @Override
    public Integer countByExample(ShopInfoExample shopInfoExample)
    {
        return this.shopInfoMapper.countByExample(shopInfoExample);
    }

    @Override
    public List<ShopInfo> selectByExample(ShopInfoExample shopInfoExample)
    {
        return this.shopInfoMapper.selectByExample(shopInfoExample);
    }

    @Override
    public ShopInfo selectUnDelByPrimaryKey(String primaryKey)
    {
        ShopInfoKey shopInfoKey = new ShopInfoKey();
        shopInfoKey.setIsDel("N");
        shopInfoKey.setShopId(primaryKey);
        return this.shopInfoMapper.selectByPrimaryKey(shopInfoKey);
    }

    @Override
    public ShopInfo selectByPrimaryKey(String primaryKey)
    {
        ShopInfoKey shopInfoKey = new ShopInfoKey();
        shopInfoKey.setShopId(primaryKey);
        return this.shopInfoMapper.selectByPrimaryKey(shopInfoKey);
    }

    @Override
    public boolean physicalDeleteByExample(ShopInfoExample shopInfoExample)
    {
        List<ShopInfo> list = this.shopInfoMapper.selectByExample(shopInfoExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        if (this.shopInfoMapper.deleteByExample(shopInfoExample) != list.size())
        {
            return false;
        }
        for (ShopInfo item : list)
        {
            this.clearRedis(item.getShopId());
        }
        return true;
    }

    @Override
    public boolean physicalDeleteByPrimaryKey(String primaryKey)
    {
        ShopInfoKey shopInfoKey = new ShopInfoKey();
        shopInfoKey.setShopId(primaryKey);
        if (this.shopInfoMapper.deleteByPrimaryKey(shopInfoKey) != 1)
        {
            return false;
        }
        this.clearRedis(primaryKey);
        return true;
    }

    @Override
    public boolean deleteByExample(ShopInfoExample shopInfoExample)
    {
        List<ShopInfo> list = this.shopInfoMapper.selectByExample(shopInfoExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        ShopInfo shopInfo = new ShopInfo();
        shopInfo.setIsDel("Y");
        if (this.shopInfoMapper.updateByExampleSelective(shopInfo, shopInfoExample) != list.size())
        {
            return false;
        }
        for (ShopInfo item : list)
        {
            this.clearRedis(item.getShopId());
        }
        return true;
    }

    @Override
    public boolean deleteByPrimaryKey(String primaryKey)
    {
        ShopInfo shopInfo = new ShopInfo();
        shopInfo.setShopId(primaryKey);
        shopInfo.setIsDel("Y");
        if (this.shopInfoMapper.updateByPrimaryKeySelective(shopInfo) != 1)
        {
            return false;
        }
        this.clearRedis(primaryKey);
        return true;
    }

    @Override
    public boolean insertSelective(ShopInfo shopInfo)
    {
        return this.shopInfoMapper.insertSelective(shopInfo) > 0 ? true : false;
    }

    @Override
    public boolean updateByExampleSelective(ShopInfo shopInfo, ShopInfoExample shopInfoExample)
    {
        List<ShopInfo> list = this.shopInfoMapper.selectByExample(shopInfoExample);
        if (CollectionUtils.isEmpty(list))
        {
            return false;
        }
        if (this.shopInfoMapper.updateByExampleSelective(shopInfo, shopInfoExample) != list.size())
        {
            return false;
        }
        for (ShopInfo item : list)
        {
            this.clearRedis(item.getShopId());
        }
        return true;
    }

    @Override
    public boolean updateByPrimaryKeySelective(ShopInfo shopInfo)
    {
        if (this.shopInfoMapper.updateByPrimaryKeySelective(shopInfo) != 1)
        {
            return false;
        }
        this.clearRedis(shopInfo.getShopId());
        return true;
    }

    /**
     * 清空品类redis缓存
     * @param goodsId 商品编号
     */
    private void clearRedis(String shopId)
    {
        if (StringUtils.hasText(shopId))
        {
            RedisDatabase base = new RedisDatabase(RedisServerConstants.business_shop);
            base.del(shopId);
        }
    }

}
